package uia.x2db;

public class WipTableModel extends DefaultTableModel {
	
	public WipTableModel(String tableName) {
		super(tableName);
	}
	
	public void addBoColumn(String columnName, String targetTable, String site, String boName) {
		addColumn(columnName, new BOColumn(targetTable, boName, site));
	}
}
