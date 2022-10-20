package com.curdoperation.service;

import com.curdoperation.dto.UserRequest;
import com.curdoperation.entity.User;
import com.curdoperation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;


    public User saveUser(UserRequest userRequest){
        User user = User.build
                (0, userRequest.getName(), userRequest.getEmail(), userRequest.getMobile(),
                        userRequest.getGender(), userRequest.getAge(), userRequest.getNationality());
        return repository.save(user);
    }

    public List<User> getAllUsers(){
        return repository.findAll();
    }

    public User getUser(int id){
        return repository.findByUserId(id);
    }
}
