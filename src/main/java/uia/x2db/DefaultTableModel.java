package uia.x2db;

import java.util.TreeMap;

import uia.x2db.columns.NumberColumn;

public class DefaultTableModel implements TableModel {
	
	private String tableName;
	
	private TreeMap<String, ColumnModel> models;
	
	public DefaultTableModel(String tableName) {
		this.tableName = tableName;
		this.models = new TreeMap<String, ColumnModel>();
	}
	
	public void addColumn(String columnName, ColumnModel model) {
		this.models.put(columnName, model);
	}

	@Override
	public String getName() {
		return this.tableName;
	}

	@Override
	public ColumnModel get(String columnName) {
		return null;
	}

}
