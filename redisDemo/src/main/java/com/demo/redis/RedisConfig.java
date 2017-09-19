package com.demo.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig extends CachingConfigurerSupport{
	
	private final static Logger LOGGER = LoggerFactory.getLogger(RedisConfig.class);
			
	@Value("${spring.redis.host}")
	private  String host;
	
	@Value("${spring.redis.port}")
	private int port;
	
	@Value("${spring.redis.timeout}")
	private int timeout;
	
	@Value("${spring.redis.password}")
	private String password;
	
	private static JedisPool jedisPool = null;
	
	@Bean
	public JedisPool getPool()
	{
		LOGGER.info("A");
		if(null == jedisPool)
		{
			JedisPoolConfig config = new JedisPoolConfig();
			jedisPool = new JedisPool(config,host, port,timeout,password);
			LOGGER.info("host"+host+"port"+port);
		}
		LOGGER.info("C");
		return jedisPool;
	}
}
