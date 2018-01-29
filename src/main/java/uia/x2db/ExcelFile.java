package uia.x2db;

import java.io.File;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFile {
	
	private Workbook wb;
	
	private Sheet sheet;
	
	private int rowCount;
	
	private int columnCount;
	
	private String[] columnNames;
	
	private TableModel tableModel;
	
	private int cursor;
	
	public ExcelFile(String fileName, TableModel tableModel) throws Exception {
		 this.wb = WorkbookFactory.create(new File(fileName));
		 this.sheet = this.wb.getSheetAt(0);
		 this.tableModel = tableModel;
		 this.rowCount = this.sheet.getLastRowNum();

		 Row row = this.sheet.getRow(0);
		 this.columnCount = row.getLastCellNum() - this.tableModel.getStartColumnIndex();
		 this.columnNames = new String[this.columnCount];
		 for(int c=0; c<this.columnCount; c++) {
			 Cell cell = row.getCell(c + this.tableModel.getStartColumnIndex());
			 this.columnNames[c] = cell == null ? null : cell.toString();
		 }
	}
	
	public String[] getColumnNames() {
		return this.columnNames;
	}
	
	public boolean next() {
		this.cursor++;
		return this.cursor < this.rowCount;
	}
	
	public String getInsertSql() {
		String[] ps = new String[this.columnCount];
		Arrays.fill(ps, "?");
		return String.format("INSERT INTO %s(%s) VALUES(%s)", 
				tableModel.getName(), 
				String.join(",", this.columnNames),
				String.join(",", ps));
	}
	
	
	public Object[] read() throws ExcelException {
		Object[] result = new Object[columnCount];
		Row row = this.sheet.getRow(this.cursor);
		for(int c=0; c<this.columnNames.length; c++) {
			ColumnModel cm = this.tableModel.get(this.columnNames[c]);
			String cellValue = row.getCell(c + this.tableModel.getStartColumnIndex()).toString();
			if(cellValue != null && cellValue.trim().length() == 0) {
				cellValue = null;
			}
			
			if(cm == null) {
				result[c] = cellValue;
				continue;
			}
			
			if((!cm.isNullable() && cellValue == null) || !cm.validate(cellValue)) {
				throw new ExcelException(this.cursor, c, cellValue);
			}

			result[c] = cm.convert(cellValue);
		}
		return result;
	}
}
