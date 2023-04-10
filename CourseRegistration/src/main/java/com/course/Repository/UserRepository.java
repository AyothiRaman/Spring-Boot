package com.course.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.Entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
	Optional<UserEntity> findByUserName(String username);

}
