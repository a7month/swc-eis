package com.igs.swc.eis.ops;

import java.util.Map;

public interface BoundSwcOperations {
	public void turnOn();
	public void turnOff();
	
	public void enable(int func);
	public void disable(int func);

	public void reset();
	public void restart();
	
	public Map<String, ?> info();
	
	public BoundRelayOperations boundOpForRelay(String relayId);
}
