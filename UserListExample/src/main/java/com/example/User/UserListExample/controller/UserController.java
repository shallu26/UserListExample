//package com.example.User.UserListExample.controller;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.User.UserListExample.UserModel.User;
//import com.example.User.UserListExample.service.UserService;
//@ControllerAdvice
//@RestController
//@RequestMapping("/user")
//public class UserController {
//	@Autowired
//	UserService userService;
//	
//	@GetMapping
//	public ResponseEntity<List<User>>getUsers(){
//		List<User>user=userService.getUsers();
//		return new ResponseEntity<List<User>>(user,HttpStatus.OK);
//		
//	}
//	@GetMapping("/{id}")
//	public ResponseEntity<User>getUserById(@PathVariable int userId){
//		User user=userService.getUserById(userId);
//		return new ResponseEntity<User>(user,HttpStatus.OK);
//	}
//	@PostMapping
//	public ResponseEntity<List<User>>addUser(@RequestBody List<User> user){
//	   List<User> use=userService.addUser(user);
//	   return new ResponseEntity<List<User>>(use,HttpStatus.CREATED);
//	}
//	
//	@PutMapping
//	public ResponseEntity<User>updateUser(@RequestBody User user){
//		User use=userService.updateUser(user);
//		return new ResponseEntity<User>(use,HttpStatus.OK);
//	}
//	@DeleteMapping("/{id}")
//	public String deleteUser(@PathVariable int userId){
//		userService.deleteUser(userId);
//		return "Delete Record";
//	
//		
//	}
//	
//
//}
package com.example.User.UserListExample.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.User.UserListExample.UserModel.User;
import com.example.User.UserListExample.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
//http://localhost:8080/user
    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userService.getUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
   //http://localhost:8080/user/1
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") int userId) {
        Optional<User> user = userService.getUserById(userId);
        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
//http://localhost:8080/user
    @PostMapping
    public ResponseEntity<List<User>> addUser(@RequestBody List<User> users) {
        List<User> createdUsers = userService.addUser(users);
        return new ResponseEntity<>(createdUsers, HttpStatus.CREATED);
    }
//http://localhost:8080/user/3
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") int userId, @RequestBody User user) {
        Optional<User> updatedUser = userService.updateUser(userId, user);
        if (updatedUser.isPresent()) {
            return new ResponseEntity<>(updatedUser.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
 // http://localhost:8080/user/3

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") int userId) {
        boolean isDeleted = userService.deleteUser(userId);
        if (isDeleted) {
            return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }
}

