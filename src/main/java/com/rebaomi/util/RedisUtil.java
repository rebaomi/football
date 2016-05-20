package com.rebaomi.util;

import redis.clients.jedis.Jedis;

/**
 * @author Future Chen 
 * @date 2015-3-19
 */
public class RedisUtil {
	
    private static Jedis redis;
    
    //也支持池子
//	private static Jedis[] redis = {JedisUtil.getInstance().getJedis("120.26.203.201", 6379), JedisUtil.getInstance().getJedis("120.26.203.200", 6379)};
	
    /**
     * 万一有人要先初始化redis 用自己想要用的ip，就可以用这个方法
     * @param ip
     */
    public static void initRedis(String ip) {
        redis = JedisUtil.getInstance().getJedis(ip, 6379);
    }
    
    /**
     * 这里做个懒汉单例，不想先调用initRedis初始化redis的人，直接用这个get也不会有问题
     * @return
     */
	public static Jedis getRedis() {
	    if(redis==null) {
	        redis = JedisUtil.getInstance().getJedis("120.24.16.130", 6379);
	    }
		return redis;
	}
}
