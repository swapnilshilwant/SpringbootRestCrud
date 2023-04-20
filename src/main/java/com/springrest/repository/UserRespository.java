package com.springrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.entity.User;

public interface UserRespository extends JpaRepository<User, Long>{

}
