package com.igs.swc.eis.ops;

import java.util.Collection;

import javax.resource.cci.ConnectionSpec;

import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.BoundSetOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.collections.DefaultRedisSet;
import org.springframework.jca.cci.core.CciTemplate;
import org.springframework.jca.cci.object.EisOperation;
import org.springframework.util.Assert;

import com.igs.modbus.cci.ModbusConnectionSpec;
import com.igs.swc.eis.MsgKey;

public class DefaultHwOperations extends EisOperation implements HwOperations {

	private RedisTemplate<String, String> redisTemplate;

	public void setRedisTemplate(RedisTemplate<String, String> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	@Override
	public void afterPropertiesSet() {
		Assert.notNull(redisTemplate);
		super.afterPropertiesSet();
	}

	@Override
	public BoundSwcOperations boundOpForSwc(String swcId) {
		ConnectionSpec connectionSpec = createConnectionSpec(swcId);
		return new DefaultBoundSwcOperations(swcId,
				getDerivedTemplate(connectionSpec), redisTemplate);
	}

	protected ConnectionSpec createConnectionSpec(String swcId) {
		SwcConnectionSpec connectionSpec = new SwcConnectionSpec(swcId);
		connectionSpec.binding();
		return connectionSpec;
	}

	protected CciTemplate getDerivedTemplate(ConnectionSpec connectionSpec) {
		return this.getCciTemplate().getDerivedTemplate(connectionSpec);
	}

	@Override
	public Collection<?> swcList() {
		BoundSetOperations<String, String> boundSetOperations = redisTemplate
				.boundSetOps(MsgKey.KEY_SWC_KEYS);
		return new DefaultRedisSet<>(boundSetOperations);
	}

	// -------------

	class SwcConnectionSpec extends ModbusConnectionSpec {
		private String swcId;

		public SwcConnectionSpec(String swcId) {
			this.swcId = swcId;
		}

		public String getSwcId() {
			return swcId;
		}

		public void setSwcId(String swcId) {
			this.swcId = swcId;
		}

		void binding() {
			BoundHashOperations<String, String, String> operations = redisTemplate
					.boundHashOps(getSwcId());

			String ip = operations.get(MsgKey.HW_NET_IP);

			this.setHostName(ip);
		}
	}

}
