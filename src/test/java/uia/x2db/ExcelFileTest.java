package uia.x2db;

import java.util.TreeMap;

import org.junit.Test;

public class ExcelFileTest implements TableModel {
	
	private TreeMap<String, ColumnModel> cms;
	
	public ExcelFileTest() {
		this.cms = new TreeMap<String, ColumnModel>();
		this.cms.put("HANDLE", new BOColumn("Item", "ItemBO", "9998"));
		this.cms.put("STATUS_BO", new BOColumn("STATUS", "StatusBO", "9998"));
		this.cms.put("ROUTER_BO", new BOColumn("Item", "ItemBO", "9998"));
		this.cms.put("BOM_BO", new BOColumn("Item", "ItemBO", "9998"));
		this.cms.put("COMPONENT_GROUP_BO", new BOColumn("Item", "ItemBO", "9998"));
		this.cms.put("ITEM_GROUP_BO", new BOColumn("Item", "ItemBO", "9998"));
		this.cms.put("ASSY_DATA_TYPE_BO", new BOColumn("Item", "ItemBO", "9998"));
		this.cms.put("SELECTOR_ACTIVITY_BO", new BOColumn("Item", "ItemBO", "9998"));
		this.cms.put("ITEM_GROUP_BO", new BOColumn("Item", "ItemBO", "9998"));
		this.cms.put("ASSY_DATA_TYPE_BO", new BOColumn("Item", "ItemBO", "9998"));
		this.cms.put("SELECTOR_ACTIVITY_BO", new BOColumn("Item", "ItemBO", "9998"));
		this.cms.put("REMOVAL_ASSY_DATA_TYPE_BO", new BOColumn("Item", "ItemBO", "9998"));
		this.cms.put("INV_ASSY_DATA_TYPE_BO", new BOColumn("Item", "ItemBO", "9998"));
		this.cms.put("ORIGINAL_STATUS_BO", new BOColumn("Item", "ItemBO", "9998"));
		this.cms.put("MASK_GROUP_BO", new BOColumn("Item", "ItemBO", "9998"));
		this.cms.put("STORAGE_LOCATION_BO", new BOColumn("Item", "ItemBO", "9998"));
	}

	@Test
	public void test() throws Exception {
		ExcelFile file = new ExcelFile("d:/aaa.xlsx", this);
		System.out.println(file.getInsertSql()); 
		file.next();
		for(Object data : file.read()) {
			System.out.println(data);
		}
	}

	@Override
	public ColumnModel get(String columnName) {
		return this.cms.containsKey(columnName) ? this.cms.get(columnName) : null;
	}
	
	public int getStartColumnIndex() {
		return 1;
	}

	@Override
	public String getName() {
		return "ITEM";
	}
}
