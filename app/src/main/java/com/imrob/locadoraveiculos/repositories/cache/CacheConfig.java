package com.imrob.locadoraveiculos.repositories.cache;

import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheManagerBuilder;

import java.io.File;

public class CacheConfig {
    private static CacheManager cacheManager;

    public static synchronized CacheManager getInstance() {
        if (cacheManager == null) {
            try {
                    File cacheDir = new File(System.getProperty("user.dir"), "ehcache");
                try {
                    if (!cacheDir.exists()) {
                        if (cacheDir.mkdirs()) {
                            System.out.println("Diretório criado com sucesso!");
                        }
                    }
                } catch (Exception e) {
                    throw new RuntimeException("Não foi possível criar o diretório do cache: " + cacheDir.getAbsolutePath());
                }
                cacheManager = CacheManagerBuilder.newCacheManagerBuilder()
                        .with(CacheManagerBuilder.persistence(cacheDir))
                        .build(true);
            } catch (Exception e) {
                throw new RuntimeException("Não foi possível inicializar o cache", e);
            }
        }
        return cacheManager;
    }

    public static synchronized void closeCacheManager() {
        if (cacheManager != null) {
            cacheManager.close();
            cacheManager = null;
        }
    }
}