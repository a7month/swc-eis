package com.igs.swc.eis.ops;

import java.util.Collection;

public interface HwOperations {
	public BoundSwcOperations boundOpForSwc(String swcId);
	public Collection<?> swcList();
}
