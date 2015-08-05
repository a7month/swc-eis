package com.igs.swc.eis.ops;

import java.util.Map;

import net.wimpi.modbus.Modbus;

import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.collections.DefaultRedisMap;
import org.springframework.jca.cci.core.CciTemplate;

import com.igs.modbus.cci.ModbusInteractionSpec;
import com.igs.modbus.cci.record.WriteMultipleCoilsRequestRecord;
import com.igs.modbus.cci.record.WriteSingleRegisterRequestRecord;
import com.igs.swc.eis.HwConstants;

public class DefaultBoundSwcOperations implements BoundSwcOperations {

	private CciTemplate cciTemplate;
	private String swcId;
	private RedisTemplate<String, String> redisTemplate;

	public DefaultBoundSwcOperations(String swcId, CciTemplate cciTemplate,
			RedisTemplate<String, String> redisTemplate) {
		this.cciTemplate = cciTemplate;
		this.swcId = swcId;
		this.redisTemplate = redisTemplate;
	}

	@Override
	public void turnOn() {
		cciTemplate.execute(new ModbusInteractionSpec(
				Modbus.WRITE_MULTIPLE_COILS),
				new WriteMultipleCoilsRequestRecord(
						HwConstants.COIL_ONOFF_REL_START,
						HwConstants.OP_REL_ALL_ON));
	}

	@Override
	public void turnOff() {
		cciTemplate.execute(new ModbusInteractionSpec(
				Modbus.WRITE_MULTIPLE_COILS),
				new WriteMultipleCoilsRequestRecord(
						HwConstants.COIL_ONOFF_REL_START,
						HwConstants.OP_REL_ALL_OFF));
	}

	@Override
	public void enable(int func) {
	}

	@Override
	public void disable(int func) {

	}

	@Override
	public void reset() {
		cciTemplate.execute(new ModbusInteractionSpec(
				Modbus.WRITE_SINGLE_REGISTER),
				new WriteSingleRegisterRequestRecord(HwConstants.REG_RESET,
						HwConstants.OP_RESET));
	}

	@Override
	public void restart() {
		cciTemplate.execute(new ModbusInteractionSpec(
				Modbus.WRITE_SINGLE_REGISTER),
				new WriteSingleRegisterRequestRecord(HwConstants.REG_RESTART,
						HwConstants.OP_RESTART));
	}

	@Override
	public Map<String, ?> info() {
		BoundHashOperations<String, String, String> boundHashOperations = redisTemplate
				.boundHashOps(swcId);
		return new DefaultRedisMap<>(boundHashOperations);
	}

	@Override
	public BoundRelayOperations boundOpForRelay(String relayId) {
		return new DefaultBoundRelayOperations(swcId, relayId, cciTemplate,
				redisTemplate);
	}
}
