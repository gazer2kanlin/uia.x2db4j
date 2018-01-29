package uia.x2db;

public interface TableModel {
	
	public int getStartColumnIndex();
	
	public String getName();
	
	public ColumnModel get(String columnName);
}
