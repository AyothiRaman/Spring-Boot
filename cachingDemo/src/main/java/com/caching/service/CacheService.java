package com.caching.service;

import com.caching.entity.CacheEntity;
import com.caching.exception.ResourceNotFoundException;
import com.caching.repository.CacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CacheService {

    @Autowired
    private CacheRepository cacheRepository;


    public List<CacheEntity> getAllCacheDetails() {
        return (List<CacheEntity>) cacheRepository.findAll();
    }


    public CacheEntity saveCacheDetails(CacheEntity cacheEntity) {
        return cacheRepository.save(cacheEntity);
    }

    @Cacheable(key = "#id",value = "${some.cache.name}",unless = "#result.rollNo > 3")
    public ResponseEntity<CacheEntity> getData(int id) {
    	
    	System.out.println("called the details based on the id from DB");
        CacheEntity entity = cacheRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Details are not available" + id));
        return ResponseEntity.ok(entity);
    }


    public ResponseEntity<CacheEntity> updateData(int id, CacheEntity entity){
        CacheEntity cacheEntity = cacheRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("details Are not updated"+id));

        cacheEntity.setName(entity.getName());
        cacheEntity.setRollNo(entity.getRollNo());
        cacheEntity.setLocation(entity.getLocation());

        cacheRepository.save(cacheEntity);

        return ResponseEntity.ok(cacheEntity);
    }

    @CacheEvict(key = "#id",value = "${some.cache.name}")
    public ResponseEntity<HttpStatus> deleteData(int id){
        CacheEntity entity = cacheRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("details Are not Available"+id));

        cacheRepository.delete(entity);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}