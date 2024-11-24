package com.in.cafe.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.in.cafe.POJO.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	User findByEmailId(@Param("email") String email);
}
