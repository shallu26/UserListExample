//package com.example.User.UserListExample.service;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.User.UserListExample.UserModel.User;
//import com.example.User.UserListExample.repo.UserRepo;
//@Service
//public class UserService {
//	@Autowired
//	UserRepo userRepo;
//
//	public List<User> getUsers() {
//		List<User>user=userRepo.findAll();
//		if(user.isEmpty()) {
//			System.out.println("no records");
//
//	}	
//        return user;
//	}
//	public User getUserById1(int userId) {
//		Optional <User> user=userRepo.findById(userId);
//		if(user.isPresent()) {
//			User us=user.get();
//		return us;
//            
//		}else {
//		//return null;	
//            System.out.println("No records found for the given ID");
//
//		}
//		return null;
//		
//	}
//
//	public List<User> addUser(List<User> user) {
//		List<User> u=userRepo.saveAll(user);
//		return u;
//	}
//
//	public User updateUser(User user) {
//		Optional <User>use =userRepo.findById(user.getUserId());
//		if(use.isPresent()) {
//			User u=use.get();
//			if(user.getUserName()!=null) {
//				u.setUserName(user.getUserName());
//			}
//			if(user.getUser_FatherName()!=null) {
//				u.setUser_FatherName(user.getUser_FatherName());
//			}
//			if(user.getUser_MotherName()!=null) {
//				u.setUser_MotherName(user.getUser_MotherName());
//			}
//			if(user.getEmail_id()!=null) {
//				u.setEmail_id(user.getEmail_id());
//			}
//			if(user.getMob_num()!=0) {
//				u.setMob_num(user.getMob_num());
//			}
//			userRepo.save(u);
//			return u;
//		}
//		else {
//			System.out.println("no records");
//		}
//		return null;
//	}
//
//	public void deleteUser(int userId) {
//		userRepo.deleteById(userId);
//		
//	}
//	public User getUserById(int userId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//}
package com.example.User.UserListExample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.User.UserListExample.UserModel.User;
import com.example.User.UserListExample.repo.UserRepo;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public List<User> getUsers() {
        return userRepo.findAll();
    }

    public Optional<User> getUserById(int userId) {
        return userRepo.findById(userId);
    }

    public List<User> addUser(List<User> users) {
        return userRepo.saveAll(users);
    }

    public Optional<User> updateUser(int userId, User user) {
        Optional<User> optionalUser = userRepo.findById(userId);
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            if (user.getUserName() != null) {
                existingUser.setUserName(user.getUserName());
            }
            if (user.getUser_FatherName() != null) {
                existingUser.setUser_FatherName(user.getUser_FatherName());
            }
            if (user.getUser_MotherName() != null) {
                existingUser.setUser_MotherName(user.getUser_MotherName());
            }
            if (user.getEmail_id() != null) {
                existingUser.setEmail_id(user.getEmail_id());
            }
            if (user.getMob_num() != 0) {
                existingUser.setMob_num(user.getMob_num());
            }
            userRepo.save(existingUser);
            return Optional.of(existingUser);
        } else {
            return Optional.empty();
        }
    }

    public boolean deleteUser(int userId) {
        if (userRepo.existsById(userId)) {
            userRepo.deleteById(userId);
            return true;
        }
        return false;
    }
}
