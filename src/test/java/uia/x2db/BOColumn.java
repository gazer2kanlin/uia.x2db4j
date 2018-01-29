package uia.x2db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import uia.x2db.columns.AbstractColumn;

public class BOColumn extends AbstractColumn {
	
	private Connection conn;
	
	private String tableName;
	
	private String name;
	
	private String site;
	
	private String revision;
	
	private String pkField;
	
	public BOColumn(String tableName, String name, String site) {
		this.tableName = tableName;
		this.name = name;
		this.site = site;
		this.pkField = "HANDLE";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getRevision() {
		return revision;
	}

	public void setRevision(String revision) {
		this.revision = revision;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	@Override
	public boolean validate(String value) {
		if(this.conn == null) {
			return true;
		}
		
		String sql = String.format("SELECT %s FROM %s WHERE %s=?", 
				this.pkField,
				this.tableName,
				this.pkField);
		try(PreparedStatement ps = this.conn.prepareStatement(sql)) {
			ps.setString(1, value);
			ResultSet rs = ps.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public Object convert(String value) {
		if(value == null) {
			return null;
		}
		
		String result = this.name + ":" + this.site + "," + value;
		return this.revision == null  ? result : result + "," + this.revision;
	}

}
