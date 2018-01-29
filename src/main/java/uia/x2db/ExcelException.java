package uia.x2db;

public class ExcelException extends Exception {
	
	private static final long serialVersionUID = 2249891811150754176L;

	public final int row;
	
	public final int col;
	
	public final String value;

	public ExcelException(int row, int col, String value) {
		this.row = row;
		this.col = col;
		this.value = value;
	}
}
