package uia.x2db.columns;

import java.math.BigDecimal;

public class NumberColumn extends AbstractColumn {
	
	public Object convert(String value) {
		return value == null ? null : new BigDecimal(value);
	}
}
