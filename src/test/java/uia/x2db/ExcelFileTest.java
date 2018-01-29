package uia.x2db;

import java.util.TreeMap;

import org.junit.Test;

public class ExcelFileTest {
	
	private WipTableModel model;
	
	public ExcelFileTest() {
		this.model = new WipTableModel("Item");
		this.model.addColumn("HANDLE", new BOColumn("Item", "ItemBO", "9998"));
		this.model.addColumn("STATUS_BO", new BOColumn("STATUS", "StatusBO", "9998"));
		this.model.addColumn("ROUTER_BO", new BOColumn("Item", "ItemBO", "9998"));
		this.model.addColumn("BOM_BO", new BOColumn("Item", "ItemBO", "9998"));
		this.model.addColumn("COMPONENT_GROUP_BO", new BOColumn("Item", "ItemBO", "9998"));
		this.model.addColumn("ITEM_GROUP_BO", new BOColumn("Item", "ItemBO", "9998"));
		this.model.addColumn("ASSY_DATA_TYPE_BO", new BOColumn("Item", "ItemBO", "9998"));
	}

	@Test
	public void test() throws Exception {
		ExcelFile file = new ExcelFile("d:/aaa.xlsx", this.model, 1);
		System.out.println(file.getInsertSql()); 
		file.next();
		for(Object data : file.read()) {
			System.out.println(data);
		}
	}
}
