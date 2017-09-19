package com.demo.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import redis.clients.jedis.Jedis;

/**
 * Hello world!
 *
 */
@SpringBootApplication   
public class App 
{
    public static void main(String[] args )
    {
    	SpringApplication.run(App.class, args);
    	
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
