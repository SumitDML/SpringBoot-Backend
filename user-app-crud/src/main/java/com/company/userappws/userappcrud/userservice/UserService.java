package com.company.userappws.userappcrud.userservice;

import com.company.userappws.userappcrud.model.request.userDetailsRequest;
import com.company.userappws.userappcrud.model.response.userDetailsResponse;
import com.company.userappws.userappcrud.model.updateRequest.UpdateUserDetailsRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserService {
    userDetailsResponse createUser(userDetailsRequest userRequest);

    userDetailsResponse getUser(String userId);

    userDetailsResponse upateUser(String userId, UpdateUserDetailsRequest updateUserRequest);

    void deleteUser(String Id);
}
