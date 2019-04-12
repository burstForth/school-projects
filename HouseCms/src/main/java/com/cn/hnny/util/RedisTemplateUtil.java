package com.cn.hnny.util;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisTemplateUtil {
	@SuppressWarnings("restriction")
	@Resource  
    private RedisTemplate<String, Object> redisTemplate;  
	
	
	
	/**ָ������ʧЧʱ��
     * @param key
     * @param time
     * @return
     */
    public boolean expire(String key,long time) {    
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
    
    /**����key��ȡ����ʱ��
     * @param key
     * @return
     */
    public long getExpire(String key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }
        
    /**�ж�key�Ƿ����
     * @param key
     * @return
     */
    public boolean hasKey(String key) {
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {            
            e.printStackTrace();
            return false;
        }
    }
        
    /**ɾ������
     * @param key ���Դ�һ��ֵ����
     */
    public void del(String ... key) {
        if(key!=null&&key.length>0) {
            if(key.length==1) {
                redisTemplate.delete(key[0]);
            }else {
                redisTemplate.delete(Arrays.asList(key));
            }
        }
    }

//  ==========================String============================    
    /**��ͨ�����ȡ
     * @param key
     * @return
     */
    public Object get(String key) {
        try {
            Object object = redisTemplate.opsForValue().get(key);        
            return object;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }        
    }
        
    /**��ͨ�������
     * @param key
     * @param value
     * @return
     */
    public boolean set(String key,Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
        
    /**��ͨ������벢����ʱ��
     * @param key
     * @param value
     * @param time time���С�ڵ���0��������������
     * @return
     */
    public boolean set(String key,Object value,long time) {
        try {
            if(time>0) {
                redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            }else {
                set(key,value);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
        
    /**������ݼ�
     * @param key
     * @param delta
     * @return
     */
    public long incre(String key,long delta) {        
        return redisTemplate.opsForValue().increment(key, delta);
    }
    
 //==============================Map==================================
    /**HashMap��HashSet�����ȡ�����value
     * @param key
     * @param item
     * @return
     */
    public Object hget(String key,String item) {
        return redisTemplate.opsForHash().get(key, item);
    }
    
    /**��ȡ���м�ֵ��
     * @param key
     * @return
     */
    public Map<Object,Object> hmget(String key) {
        return redisTemplate.opsForHash().entries(key);
    }
    
    /**hashmap���뻺��
     * @param key
     * @param map
     * @return
     */
    public boolean hmset(String key,Map<Object,Object> map) {
        try {
            redisTemplate.opsForHash().putAll(key, map);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /**hashmap���뻺�沢����ʱ��
     * @param key
     * @param map
     * @param time
     * @return
     */
    public boolean hmset(String key,Map<Object,Object> map,long time) {
        try {
            redisTemplate.opsForHash().putAll(key, map);
            if(time>0) {
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /**��һ��hash���з������ݣ�����������򴴽�
     * @param key
     * @param item
     * @param value
     * @return
     */
    public boolean hset(String key,String item,Object value) {
        try {
            redisTemplate.opsForHash().put(key, item, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /**��һ��hash���з������ݲ�����ʱ�䣬����������򴴽�
     * @param key
     * @param item
     * @param value
     * @param time
     * @return
     */
    public boolean hset(String key,String item,Object value,long time) {
        try {
            redisTemplate.opsForHash().put(key, item, value);
            if(time>0) {
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    /**ɾ��hash���е�ֵ
     * @param key
     * @param item
     */
    public void hdel(String key,Object...item ) {
        redisTemplate.opsForHash().delete(key, item);
    }
    
    /**�ж�hash�����Ƿ��и����ֵ
     * @param key
     * @param item
     * @return
     */
    public boolean hHasKey(String key,String item) {
        return redisTemplate.opsForHash().hasKey(key, item);
    }
    
//==========================List=================================
    /**
     * ��ȡlist���������
     * @param key ��
     * @param start ��ʼ
     * @param end ����  0 �� -1��������ֵ
     * @return
     */
    public List<Object> lGet(String key,long start, long end){
        try {
            return redisTemplate.opsForList().range(key, start, end);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
     
    /**
     * ��ȡlist����ĳ���
     * @param key ��
     * @return
     */
    public long lGetListSize(String key){
        try {
            return redisTemplate.opsForList().size(key);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
     
    /**
     * ͨ������ ��ȡlist�е�ֵ
     * @param key ��
     * @param index ����  index>=0ʱ�� 0 ��ͷ��1 �ڶ���Ԫ�أ��������ƣ�index<0ʱ��-1����β��-2�����ڶ���Ԫ�أ���������
     * @return
     */
    public Object lGetIndex(String key,long index){
        try {
            return redisTemplate.opsForList().index(key, index);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
     
    /**
     * ��list���뻺��
     * @param key ��
     * @param value ֵ
     * @param time ʱ��(��)
     * @return
     */
    public boolean lSet(String key, Object value) {
        try {
            redisTemplate.opsForList().rightPush(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
     
    /**
     * ��list���뻺��
     * @param key ��
     * @param value ֵ
     * @param time ʱ��(��)
     * @return
     */
    public boolean lSet(String key, Object value, long time) {
        try {
            redisTemplate.opsForList().rightPush(key, value);
            if (time > 0) expire(key, time);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
     
    /**
     * ��list���뻺��
     * @param key ��
     * @param value ֵ
     * @param time ʱ��(��)
     * @return
     */
    public boolean lSet(String key, List<Object> value) {
        try {
            redisTemplate.opsForList().rightPushAll(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
     
    /**
     * ��list���뻺��
     * @param key ��
     * @param value ֵ
     * @param time ʱ��(��)
     * @return
     */
    public boolean lSet(String key, List<Object> value, long time) {
        try {
            redisTemplate.opsForList().rightPushAll(key, value);
            if (time > 0) expire(key, time);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
     
    /**
     * ���������޸�list�е�ĳ������
     * @param key ��
     * @param index ����
     * @param value ֵ
     * @return
     */
    public boolean lUpdateIndex(String key, long index,Object value) {
        try {
            redisTemplate.opsForList().set(key, index, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
     
    /**
     * �Ƴ�N��ֵΪvalue
     * @param key ��
     * @param count �Ƴ����ٸ�
     * @param value ֵ
     * @return �Ƴ��ĸ���
     */
    public long lRemove(String key,long count,Object value) {
        try {
            Long remove = redisTemplate.opsForList().remove(key, count, value);
            return remove;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
	
}
