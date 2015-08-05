package com.igs.swc.eis.ops;

import com.igs.swc.eis.HwConstants;

public class RelayAddress {

	private Relay relay;

	public RelayAddress(String relayId) {
		this.relay = new Relay(relayId);
	}

	public RelayAddress(Relay relay) {
		this.relay = relay;
	}

	public int stateAddr() {
		int i = 0;
		switch (relay.getRelayNum()) {
		case 1:
			i = HwConstants.COIL_STATE_REL_0;
			break;
		case 2:
			i = HwConstants.COIL_STATE_REL_1;
			break;
		case 3:
			i = HwConstants.COIL_STATE_REL_2;
			break;
		case 4:
			i = HwConstants.COIL_STATE_REL_3;
			break;
		case 5:
			i = HwConstants.COIL_STATE_REL_4;
			break;
		case 6:
			i = HwConstants.COIL_STATE_REL_5;
			break;
		case 7:
			i = HwConstants.COIL_STATE_REL_6;
			break;
		case 8:
			i = HwConstants.COIL_STATE_REL_7;
			break;
		default:
			i = 0;
			break;
		}
		return i;
	}

	public int onoffCoil() {
		return HwConstants.COIL_HWWM_START + relay.getRelayNum();
	}
}
