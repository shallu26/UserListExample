package com.example.User.UserListExample.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.User.UserListExample.UserModel.User;
@Repository
public interface UserRepo extends JpaRepository<User,Integer>{

	//Optional<User> findById(String userName);

	//Optional<User> findById(String userName);
	


}
