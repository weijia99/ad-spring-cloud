package com.imooc.ad.index.adplan;

import ch.qos.logback.classic.Logger;
import com.imooc.ad.client.vo.AdPlan;
import com.imooc.ad.index.IndexAware;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


@Slf4j
@Component
public class AdPlanIndex  implements IndexAware<Long, AdPlanObject> {
//    实现上诉的方法，obj是索引的属性
//    使用map来进行记录索引
private static Map<Long, AdPlanObject> objectMap;
//单例墨水，进行静态生成
    static {
        objectMap = new ConcurrentHashMap<Long, AdPlanObject>() {
        };

}

    @Override
    public AdPlanObject get(Long key) {
        return objectMap.get(key);
    }

    @Override
    public void add(Long key, AdPlanObject value) {

        log.info("before add: {}", objectMap);
        objectMap.put(key, value);
        log.info("after add: {}", objectMap);
    }

    @Override
    public void update(Long key, AdPlanObject value) {
        log.info("before update: {}", objectMap);
        AdPlanObject oldObject = objectMap.get(key);
        if (null != oldObject) {
            objectMap.put(key, value);
        } else {
            oldObject.update(value);
        }

        log.info("after update: {}", objectMap);
    }

    @Override
    public void delete(Long key, AdPlanObject value) {
        log.info("before delete: {}", objectMap);
        objectMap.remove(key);
        log.info("after delete: {}", objectMap);
    }
}
