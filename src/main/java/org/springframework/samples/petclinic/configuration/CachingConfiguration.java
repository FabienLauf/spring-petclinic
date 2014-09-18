package org.springframework.samples.petclinic.configuration;

import net.sf.ehcache.config.CacheConfiguration;
import net.sf.ehcache.config.PersistenceConfiguration;
import net.sf.ehcache.config.PersistenceConfiguration.Strategy;
import net.sf.ehcache.store.MemoryStoreEvictionPolicy;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for the caching system using EhCache.
 * 
 * @author Fabien Lauf
 */
@Configuration
@EnableCaching
public class CachingConfiguration implements CachingConfigurer {
	
	public static final String VETS_CACHE_NAME = "vets";
	
	@Bean(destroyMethod="shutdown")
    public net.sf.ehcache.CacheManager ehCacheManager() {
		CacheConfiguration cacheConfiguration = new CacheConfiguration();
		cacheConfiguration.name(CachingConfiguration.VETS_CACHE_NAME)
						.memoryStoreEvictionPolicy(MemoryStoreEvictionPolicy.LRU)
						.timeToLiveSeconds(60L)
						.eternal(false)
						.maxEntriesLocalHeap(100)
						.maxElementsOnDisk(10000000)
						.persistence(new PersistenceConfiguration().strategy(Strategy.NONE))
						.diskExpiryThreadIntervalSeconds(1);

		net.sf.ehcache.config.Configuration config = new net.sf.ehcache.config.Configuration();
		config.addCache(cacheConfiguration);

		return net.sf.ehcache.CacheManager.newInstance(config);
    }

    @Bean
    @Override
    public CacheManager cacheManager() {
        return new EhCacheCacheManager(ehCacheManager());
    }

    @Bean
    @Override
    public KeyGenerator keyGenerator() {
        return new SimpleKeyGenerator();
    }

}
