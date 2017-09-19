package com.demo.redis;

import redis.clients.jedis.Jedis;

public class redisTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         RedisConfig redisConfig = new RedisConfig();
         Jedis jedis = null;
         try {
        	 jedis = redisConfig.getPool().getResource();
             
             jedis.ping();
             
             jedis.set("test", "1");
		} finally {
			// TODO: handle finally clause
			if(null != jedis)
			{
			jedis.close();
			}
		}
         
	}

}
