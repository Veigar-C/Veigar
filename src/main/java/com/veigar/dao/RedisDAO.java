package com.veigar.dao;

import org.springframework.stereotype.Repository;
import redis.clients.jedis.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/9.
 */

public class RedisDAO {
    private Jedis jedis;//非切片额客户端连接
    private JedisPool jedisPool;//非切片连接池
    private ShardedJedis shardedJedis;//切片额客户端连接
    private ShardedJedisPool shardedJedisPool;//切片连接池

    public RedisDAO()
    {
        initialPool();
        initialShardedPool();
        shardedJedis = shardedJedisPool.getResource();
        jedis = jedisPool.getResource();


    }

    /**
     * 初始化非切片池
     */
    private void initialPool()
    {
        // 池基本配置
        JedisPoolConfig config = new JedisPoolConfig();
        //config.setMaxActive(20);
        config.setMaxTotal(20);
        config.setMaxIdle(5);
        //config.setMaxWait(1000l);
        config.setMaxWaitMillis(10001);
        config.setTestOnBorrow(false);
        config.setTestOnBorrow(false);

        jedisPool = new JedisPool(config,"127.0.0.1",6379);
    }

    /**
     * 初始化切片池
     */
    private void initialShardedPool()
    {
        // 池基本配置
        JedisPoolConfig config = new JedisPoolConfig();
        //config.setMaxActive(20);
        config.setMaxTotal(20);
        config.setMaxIdle(5);
        //config.setMaxWait(1000l);
        config.setMaxWaitMillis(10001);
        config.setTestOnBorrow(false);
        // slave链接
        List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>();
        shards.add(new JedisShardInfo("127.0.0.1", 6379, "my_local_redis"));

        // 构造池
        shardedJedisPool = new ShardedJedisPool(config, shards);
    }

    public void show() {
        KeyOperate();
        jedisPool.close();
        shardedJedisPool.close();
    }

    public void setValue(String key,String value){
        jedis.set(key,value);
    }

    public void KeyOperate() {
        System.out.println("获取key为key001的value:"+jedis.get("key001"));

    }

}
