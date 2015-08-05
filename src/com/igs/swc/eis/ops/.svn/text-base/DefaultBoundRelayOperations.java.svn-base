package com.igs.swc.eis.ops;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.wimpi.modbus.Modbus;

import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jca.cci.core.CciTemplate;

import com.igs.modbus.cci.ModbusInteractionSpec;
import com.igs.modbus.cci.record.WriteCoilRequestRecord;
import com.igs.swc.eis.HwConstants;
import com.igs.swc.eis.MsgKey;

public class DefaultBoundRelayOperations implements BoundRelayOperations {

	private CciTemplate cciTemplate;
	private String swcId;
	private String relayId;
	private Relay relay;
	private RelayAddress relayAddress;
	private RedisTemplate<String, String> redisTemplate;

	public DefaultBoundRelayOperations(String swcId, String relayId,
			CciTemplate cciTemplate, RedisTemplate<String, String> redisTemplate) {
		super();
		this.swcId = swcId;
		this.relayId = relayId;
		this.cciTemplate = cciTemplate;

		this.relay = new Relay(relayId);
		this.relayAddress = new RelayAddress(relay);

		this.redisTemplate = redisTemplate;
	}

	@Override
	public void turnOn() {
		cciTemplate.execute(new ModbusInteractionSpec(Modbus.WRITE_COIL),
				new WriteCoilRequestRecord(relayAddress.onoffCoil(),
						HwConstants.ON));

	}

	@Override
	public void turnOff() {
		cciTemplate.execute(new ModbusInteractionSpec(Modbus.WRITE_COIL),
				new WriteCoilRequestRecord(relayAddress.onoffCoil(),
						HwConstants.OFF));
	}

	@Override
	public void enable(int func) {

	}

	@Override
	public void disable(int func) {

	}

	@Override
	public void getRrc(int num) {

	}

	@Override
	public void setRrc(int num) {

	}

	@Override
	public Map<String, ?> info() {
		BoundHashOperations<String, String, String> boundHashOperations = redisTemplate
				.boundHashOps(swcId);

		List<String> l = boundHashOperations.multiGet(Arrays.asList(
				relay.getRelayStateKey(), relay.getRelayUsedKey(),
				relay.getRelayRrcKey()));

		Map<String, String> m = new HashMap<>();

		m.put("rel_state", l.get(0));
		m.put("rel_used", l.get(1));
		m.put("rel_rrc", l.get(2));
		m.put(MsgKey.REL_ID, relayId);
		m.put(MsgKey.SWC_ID, swcId);

		return m;
	}

}
