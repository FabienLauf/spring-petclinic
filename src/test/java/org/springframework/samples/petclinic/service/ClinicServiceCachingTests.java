package org.springframework.samples.petclinic.service;

import java.util.Collection;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.samples.petclinic.application.PetClinicApplication;
import org.springframework.samples.petclinic.configuration.CachingConfiguration;
import org.springframework.samples.petclinic.model.Vet;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.CollectionUtils;

/**
 * <p> Unit test for the ehCache caching system of the application.
 * The "Spring Data Jpa" profile is used. </p>
 * @author Fabien Lauf
 */

@SpringApplicationConfiguration(classes = PetClinicApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("spring-data-jpa")
// @DirtiesContext
public class ClinicServiceCachingTests {
	
	@Autowired
    protected ClinicService clinicService;
	
	@Autowired
    protected CacheManager cacheManager;
	
	@Before
	public void before() {
		cacheManager.getCache(CachingConfiguration.VETS_CACHE_NAME).flush();
	}
	 
	@Test
	public void findVets() {
		assertCacheSize(CachingConfiguration.VETS_CACHE_NAME, 0);
		
		Collection<Vet> vets = this.clinicService.findVets();
		Assert.assertFalse("There is no vets in database...", CollectionUtils.isEmpty(vets));
		
		assertCacheSize(CachingConfiguration.VETS_CACHE_NAME, vets.size());
	}
	
	@SuppressWarnings("unchecked")
	private void assertCacheSize(String cacheName, int size) {
		Cache cache = cacheManager.getCache(cacheName);
		Assert.assertNotNull(String.format("cache [%s] is null!", cache.getName()), cache);
		if (CollectionUtils.isEmpty(cache.getKeys())) {
			Assert.assertEquals(String.format("cache [%s] is not empty!", cache.getName()), 0, size);
			return;
		}
		
		Element element = cache.get(cache.getKeys().get(0));
		if (element.getObjectValue() == null) {
			Assert.assertEquals(String.format("cache [%s] is not empty!", cache.getName()), 0, size);
			return;
		}

		Assert.assertNotNull(String.format("the element of key [%s] is null!", element.getObjectKey()), element.getObjectValue());
		if (size == 1) {
			Assert.assertFalse(element.getObjectValue() instanceof Collection);
			return;
		}
		Collection<Object> collectionValue = ((Collection<Object>) element.getObjectValue());
		Assert.assertEquals(size, collectionValue.size());
	}
}