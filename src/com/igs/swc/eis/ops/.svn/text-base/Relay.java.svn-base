package com.igs.swc.eis.ops;

public class Relay {

	private String relayId;
	private String hwId;
	private int relayNum;

	public Relay(String relayId) {
		this.relayId = relayId;
		this.hwId = relayId.substring(8);
		this.relayNum = Integer.parseInt(relayId.substring(4, 8));
	}

	public String getHwId() {
		return hwId;
	}

	public int getRelayNum() {
		return relayNum;
	}

	public String getRelayId() {
		return relayId;
	}
	
	
	// -------------------------
	
	
	public String getRelayStateKey(){
		return "hw_rel_state_" + relayNum;
	}
	
	public String getRelayUsedKey(){
		return "hw_rel_used_" + relayNum;
	}
	
	public String getRelayRrcKey(){
		return "hw_rel_rrc_" + relayNum;
	}
}
