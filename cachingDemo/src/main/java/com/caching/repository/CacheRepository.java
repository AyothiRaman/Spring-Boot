package com.caching.repository;

import com.caching.entity.CacheEntity;
import org.springframework.data.repository.CrudRepository;

public interface CacheRepository extends CrudRepository<CacheEntity,Integer> {
}
