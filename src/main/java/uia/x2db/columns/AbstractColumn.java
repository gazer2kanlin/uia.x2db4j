package uia.x2db.columns;

import uia.x2db.ColumnModel;

public abstract class AbstractColumn implements ColumnModel {
	
	private boolean nullable;
	
	public AbstractColumn() {
		this.nullable = true;
	}

	public boolean isNullable() {
		return nullable;
	}
 
	public void setNullable(boolean nullable) {
		this.nullable = nullable;
	}

	public boolean validate(String value) {
		return this.nullable || value != null ? true : false;
	}
}
