package com.qy.utils;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {

    @Resource
    private RedisTemplate redisTemplate;

//    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
//        this.redisTemplate = redisTemplate;
//    }

    /**
     * 指定缓存的失效时间
     *
     * @param key  ： redis中的键，判断该key是否过期
     * @param time 过期时间（秒）
     * @return 判断指定的key是否已经失效
     */
    public boolean expired(String key, long time) {

        try {
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 获取指定key的失效时间
     *
     * @param key
     * @return 该key的秒单位的失效时间
     */
    public long getExpired(String key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    /**
     * 判断key是否在redis中存在
     *
     * @param key 值
     * @return true存在，否则false
     */
    public boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 删除缓存中所有的keys的值
     *
     * @param keys 可变长度的参数，可以是0个，1个和多个key进行删除
     */
    public void delete(String... keys) {
        if (keys != null && keys.length > 0) {
            if (keys.length == 1) {
                redisTemplate.delete(keys[0]);
            } else {
                redisTemplate.delete(CollectionUtils.arrayToList(keys));
            }
        }
    }

    /**
     * 设置Redis中String类型数据的值
     *
     * @param key
     * @param value
     * @return
     */
    public boolean set(String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 获取String类型的key对应的值
     *
     * @param key String类型redis数据的key
     * @return 该key对应的String的value
     */
    public Object get(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    /**
     * 在redis服务器中放置String类型的值，并设置失效时间
     *
     * @param key   String类型的key
     * @param value 值
     * @param time  失效时间（秒）
     * @return
     */
    public boolean set(String key, Object value, long time) {
        try {
            if (time > 0) {
                redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            } else {
                set(key, value);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * hash类型数据的存储
     *
     * @param key hash类型值的key
     * @param map 键值对
     * @return
     */
    public boolean hmset(String key, Map<String, Object> map) {
        try {
            redisTemplate.opsForHash().putAll(key, map);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 设置hash中指定key下的field的值为value
     *
     * @param key   hash的key键
     * @param field hash中的field域
     * @param value 给hash中的field设置的值
     * @return true设置成功，否则false
     */
    public boolean hset(String key, String field, Object value) {
        try {
            redisTemplate.opsForHash().put(key, field, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 设置hash中指定key下的field的值为value，并设置失效时间
     *
     * @param key   失效时间
     * @param field hash的key键
     * @param value hash中的field域
     * @param time  给hash中的field设置的值
     * @return true设置成功，否则false
     */
    public boolean hset(String key, String field, Object value, long time) {
        try {
            redisTemplate.opsForHash().put(key, field, value);
            if (time > 0) {
                expired(key, time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * hash类型数据的存储, 并设置失效时间
     *
     * @param time 失效时间
     * @param key  hash类型值的key
     * @param map  键值对
     * @return true代表设置成功，否则false
     */
    public boolean hmset(String key, Map<String, Object> map, long time) {
        try {
            redisTemplate.opsForHash().putAll(key, map);
            if (time > 0) {
                expired(key, time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * hash类型数据的获取
     *
     * @param key   hash类型值的key
     * @param field hash类型的field域
     * @return 在该key所对应的hash中field的值
     */
    public Object hget(String key, String field) {
        return redisTemplate.opsForHash().get(key, field);
    }

    /**
     * 获取hash类型数据的key对应的整个map对象
     *
     * @param key
     * @return
     */
    public Map<Object, Object> hmget(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * list类型数据的存储
     *
     * @param key
     * @param value
     * @return
     */
    public boolean rpush(String key, String value) {
        try {
            redisTemplate.opsForList().rightPush(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 使用redis分页，list类型数据的获取
     *
     * @param key
     * @param start
     * @param stop
     * @return
     */
    public List<Object> lrange(String key, int start, int stop) {
        return redisTemplate.opsForList().range(key, start, stop);
    }

    /**
     * 向zset中进行添加数据
     *
     * @param key
     * @param t
     * @param score
     * @param <T>
     * @return
     */
//    public <T> boolean zadd(String key, T t, double score, long time) {
//        try {
//            redisTemplate.opsForZSet().add(key, t, score);
//            if (time > 0) {
//                expired(key, time);
//            }
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
    public <T> boolean zadd(String key, T t, double score) {
        if (redisTemplate.opsForZSet().add(key, t, score)) {
            return true;
        }
        return false;
    }

    /**
     * 根据分数从大到小排序，获取指定范围内的数据
     *
     * @param key
     * @return
     */
    public Set zget(String key, long start, long stop) {
        return redisTemplate.opsForZSet().reverseRange(key, start, stop);
    }

    /**
     * 修改指定元素的分值
     *
     * @return
     */
    public <T> Double zincrby(String key, T t, Double score) {
        return redisTemplate.opsForZSet().incrementScore(key, t, score);
    }

    public <T> boolean remove(String key, T t) {
        return redisTemplate.opsForZSet().remove(key, t) > 0;
    }

    public boolean hexists(Object key, Object field) {

        return redisTemplate.opsForHash().hasKey(key, field);
    }

}
