package com.icubespace.projects.gateway.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class RedisService {

    @Resource
    private RedisTemplate<String, ?> redisTemplate;

    private static final Logger logger = LoggerFactory.getLogger(RedisService.class);

    public boolean exists(String key) {

        logger.info("RedisService exists key [{}]", key);
        boolean b = redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection redisConnection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                return redisConnection.exists(serializer.serialize(key));
            }
        });
        return b;
    }

    public String get(String key) {
        logger.info("RedisService get key [{}]", key);
        String result = redisTemplate.execute(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection redisConnection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                byte[] value =  redisConnection.get(serializer.serialize(key));
                return serializer.deserialize(value);
            }
        });
        return result;
    }

    public boolean set(String key, String value) {

        logger.info("RedisService set key:[{}], value:[{}]", key, value);
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                connection.set(serializer.serialize(key), serializer.serialize(value));
                return true;
            }
        });
        return result;
    }

    public Map<String, Object> getMap(String key) {
        Map<String, Object> result = redisTemplate.execute(new RedisCallback<Map<String, Object>>() {
            @Override
            public Map<String, Object> doInRedis(RedisConnection redisConnection) throws DataAccessException {
                RedisSerializer serializer = redisTemplate.getValueSerializer();
                RedisSerializer<String> keySerializer = redisTemplate.getStringSerializer();
                byte[] value =  redisConnection.get(keySerializer.serialize(key));
                return (Map<String, Object>)serializer.deserialize(value);
            }
        });
        return result;
    }

    public boolean setMap(String key, Map<String, Object> value) {
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer serializer = redisTemplate.getValueSerializer();
                RedisSerializer<String> keySerializer = redisTemplate.getStringSerializer();
                connection.set(keySerializer.serialize(key), serializer.serialize(value));
                return true;
            }
        });
        return result;
    }

    public boolean setMapAndExpire(String key, Map<String, Object> value, long expire) {
        logger.info("RedisService setMapAndExpire key:[{}], value:[{}], expire:[{}]", key, value, expire);
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer serializer = redisTemplate.getValueSerializer();
                RedisSerializer<String> keySerializer = redisTemplate.getStringSerializer();
                connection.setEx(keySerializer.serialize(key), expire, serializer.serialize(value));
                return true;
            }
        });

        return result;
    }

    public boolean setStringAndExpire(String key, String value, long expire) {
        logger.info("RedisService setStringAndExpire key:[{}], value:[{}], expire:[{}]", key, value, expire);
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                RedisSerializer<String> keySerializer = redisTemplate.getStringSerializer();
                connection.set(keySerializer.serialize(key), serializer.serialize(value));
                return true;
            }
        });
        if(result){
            return redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
        return result;
    }

    public boolean expire(String key, long expire) {
        return redisTemplate.expire(key, expire, TimeUnit.SECONDS);
    }

    public Long getExpire(String key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    public boolean delete(String key) {

        logger.info("RedisService delete key [{}]", key);
        return redisTemplate.delete(key);
    }
}
