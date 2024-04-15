package com.imrob.locadoraveiculos.repositories.cache;

import com.imrob.locadoraveiculos.config.DatabaseConfig;
import com.imrob.locadoraveiculos.repositories.impl.Identifiable;
import com.imrob.locadoraveiculos.repositories.impl.RobRepository;
import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.units.EntryUnit;
import org.ehcache.config.units.MemoryUnit;
import org.springframework.jdbc.core.simple.JdbcClient;
import java.util.ArrayList;
import java.util.List;

public class CachedRepository<ENTITY extends Identifiable<ID>, ID> implements RobRepository<ENTITY, ID> {
    private final Cache<ID, ENTITY> cache;

    public CachedRepository(Class<ENTITY> entityClass, Class<ID> idClass) {
        this.cache = createCache(idClass, entityClass);
    }

    @Override
    public List<ENTITY> findAll () {
        if (cache.iterator().hasNext()) {
            List<ENTITY> entities = new ArrayList<>();
            cache.forEach(entity -> entities.add(entity.getValue()));
            System.out.println("peguei do cache");
            return entities;
        } else {
            return null;
        }
    }


    @Override
    public ENTITY findById (ID id){
        return cache.get(id);
    }

    @Override
    public ID save (ENTITY entity){
        ID id = entity.getId();
        cache.put(id, entity);
        return id;
    }

    public void saveAll (List<ENTITY> entities){
        for (ENTITY entity : entities) {
            cache.put(entity.getId(), entity);
        }
    }

    @Override
    public void update (ENTITY entity){
        ID id = entity.getId();
        cache.put(id, entity);
    }

    @Override
    public void delete (ID id){
        cache.remove(id);
    }

    @Override
    public JdbcClient getConnection () {
        return DatabaseConfig.getConnection();
    }

    private Cache<ID, ENTITY> createCache(Class<ID> idClass, Class<ENTITY> entityClass) {
        CacheManager cacheManager = CacheConfig.getInstance();
        String cacheName = entityClass.getSimpleName().toLowerCase();
        Cache<ID, ENTITY> existingCache = cacheManager.getCache(cacheName, idClass, entityClass);

        if (existingCache != null) {
            return existingCache;
        } else {
            return cacheManager.createCache(cacheName,
                    CacheConfigurationBuilder.newCacheConfigurationBuilder(idClass, entityClass,
                            ResourcePoolsBuilder.newResourcePoolsBuilder()
                                    .heap(300, EntryUnit.ENTRIES)
                                    .disk(10, MemoryUnit.MB, true)));
        }
    }
}