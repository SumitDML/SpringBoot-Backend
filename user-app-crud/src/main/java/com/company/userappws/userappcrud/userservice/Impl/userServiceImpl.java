package com.company.userappws.userappcrud.userservice.Impl;

import com.company.userappws.userappcrud.model.request.userDetailsRequest;
import com.company.userappws.userappcrud.model.response.userDetailsResponse;
import com.company.userappws.userappcrud.model.updateRequest.UpdateUserDetailsRequest;
import com.company.userappws.userappcrud.shared.Utils;
import com.company.userappws.userappcrud.userservice.UserService;
import org.slf4j.helpers.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class userServiceImpl implements UserService {

    Map<String,userDetailsResponse> newUser;
    Utils util;
    @Autowired
    public userServiceImpl(Utils util){
        this.util = util;
    }

    @Override
    public userDetailsResponse createUser(userDetailsRequest userRequest) {
        userDetailsResponse user = new userDetailsResponse();

        user.setEmail(userRequest.getEmail());
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());

        String userId = util.generateUserId();
        user.setUserId(userId);

        if(newUser == null) newUser = new HashMap<>();

        newUser.put(userId,user);

        return user;
    }

    @Override
    public userDetailsResponse getUser(String userId) {
        if(newUser.containsKey(userId)){
            return newUser.get(userId);
        }
        return null;
    }

    @Override
    public userDetailsResponse upateUser(String userId, UpdateUserDetailsRequest updateUserRequest) {
        userDetailsResponse userUpdate = newUser.get(userId);

        userUpdate.setFirstName(updateUserRequest.getFirstName());
        userUpdate.setLastName(updateUserRequest.getLastName());

        newUser.put(userId,userUpdate);
        return userUpdate;
    }

    @Override
    public void deleteUser(String Id) {
        newUser.remove(Id);
    }
}
