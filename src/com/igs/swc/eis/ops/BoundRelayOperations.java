package com.igs.swc.eis.ops;

import java.util.Map;

public interface BoundRelayOperations {
	public void turnOn();
	public void turnOff();
	public void enable(int func);
	public void disable(int func);
	
	public void getRrc(int num);
	public void setRrc(int num);
	
	public Map<String, ?> info();
}
