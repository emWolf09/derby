package com.derby.caching;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cache")
public class ProfileMSCacheController {

    @Autowired
    CacheManager cacheManager;
    @GetMapping("/evictAllCaches")
    public void evictAllCaches() {
        cacheManager.getCacheNames()
                .parallelStream()
                .forEach(cacheName -> cacheManager.getCache(cacheName).clear());
    }
    @Scheduled(fixedDelay =500000 )
    public void evictAllcachesAtIntervals() {
        evictAllCaches();
    }
}
