package com.igs.swc.eis;

public class HwConstants {
	public static final int COIL_HWWM_START = 0x2100;

	public static final int COIL_ONOFF_REL_START = 0x01;
	public static final int COIL_ONOFF_REL_0 = COIL_ONOFF_REL_START + 0;
	public static final int COIL_ONOFF_REL_1 = COIL_ONOFF_REL_START + 1;
	public static final int COIL_ONOFF_REL_2 = COIL_ONOFF_REL_START + 2;
	public static final int COIL_ONOFF_REL_3 = COIL_ONOFF_REL_START + 3;
	public static final int COIL_ONOFF_REL_4 = COIL_ONOFF_REL_START + 4;
	public static final int COIL_ONOFF_REL_5 = COIL_ONOFF_REL_START + 5;
	public static final int COIL_ONOFF_REL_6 = COIL_ONOFF_REL_START + 6;
	public static final int COIL_ONOFF_REL_7 = COIL_ONOFF_REL_START + 7;

	public static final int COIL_STATE_REL_0 = 0x2A00;
	public static final int COIL_STATE_REL_1 = 0x2B00;
	public static final int COIL_STATE_REL_2 = 0x2C00;
	public static final int COIL_STATE_REL_3 = 0x2D00;
	public static final int COIL_STATE_REL_4 = 0x2E00;
	public static final int COIL_STATE_REL_5 = 0x2F00;
	public static final int COIL_STATE_REL_6 = 0x3000;
	public static final int COIL_STATE_REL_7 = 0x3100;

	public static final int OFFSET_RST = 0x00;
	public static final int OFFSET_RSA = 0x01;
	public static final int OFFSET_ROP = 0x02;
	public static final int OFFSET_RSS = 0x03;
	public static final int OFFSET_RS0 = 0x04;
	public static final int OFFSET_RS1 = 0x05;
	public static final int OFFSET_RS2 = 0x06;
	public static final int OFFSET_RS3 = 0x07;

	// ------------------

	// ------------------

	public static final int REG_RESTART = 0x00;
	public static final int REG_RESET = 0x00;

	// ---------------------

	public static final short OP_RESTART = 0x01;
	public static final short OP_RESET = 0x02;

	// ---------------------

	public static final boolean ON = true;
	public static final boolean OFF = false;

	public static final boolean[] OP_REL_ALL_OFF = new boolean[] { false,
			false, false, false, false, false, false, false };

	public static final boolean[] OP_REL_ALL_ON = new boolean[] { true, true,
			true, true, true, true, true, true };

}
