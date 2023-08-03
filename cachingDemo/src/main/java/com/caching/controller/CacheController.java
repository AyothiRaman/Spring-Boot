package com.caching.controller;

import com.caching.entity.CacheEntity;
import com.caching.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cache")
public class CacheController {

    @Autowired
    private CacheService cacheService;

    @GetMapping("/getDetails")
    public List<CacheEntity> getAllDetails(){
        return cacheService.getAllCacheDetails();
    }

    @PostMapping("/saveDetails")
    public CacheEntity saveAllData(@RequestBody CacheEntity cacheEntity){
        return cacheService.saveCacheDetails(cacheEntity);
    }

    @GetMapping("{id}")
    public ResponseEntity<CacheEntity> findDetailsById(@PathVariable int id){
        return  cacheService.getData(id);

    }

    @PutMapping("{id}")
    public ResponseEntity<CacheEntity> updateDetailsById(@PathVariable int id, @RequestBody CacheEntity entity){
        return cacheService.updateData(id,entity);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteDetailsById(@PathVariable int id){
        return cacheService.deleteData(id);
    }
}
