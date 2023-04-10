package com.ManyToManyMapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ManyToManyMapping.entity.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

}
