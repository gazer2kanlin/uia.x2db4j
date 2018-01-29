package uia.x2db;

public interface ColumnModel {

	public boolean isNullable();

	public boolean validate(String value);
	
	public Object convert(String value);
}
