package com.company.userappws.userappcrud.uiController;

import com.company.userappws.userappcrud.model.request.userDetailsRequest;
import com.company.userappws.userappcrud.model.response.userDetailsResponse;
import com.company.userappws.userappcrud.model.updateRequest.UpdateUserDetailsRequest;
import com.company.userappws.userappcrud.userservice.Impl.userServiceImpl;
import com.company.userappws.userappcrud.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class Usercontroller {

    Map<String,userDetailsResponse> newUser;

    @Autowired
    UserService userService;

    @GetMapping
    public String getUser(@RequestParam(value="page",defaultValue = "1",required = false)int page, @RequestParam(value="limit",defaultValue = "50")int limit,@RequestParam(value="sort",defaultValue ="desc",required = false)String sort){
        return "get User was called! with page =" + page + " and limit = "+limit+ " sort :"+sort;
    }

    @GetMapping(path="/{userId}",produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<userDetailsResponse> getUser(@PathVariable String userId){

        userDetailsResponse user = userService.getUser(userId);

        if(user!=null){
            return new ResponseEntity<>(user,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<userDetailsResponse>  createUser(@Valid @RequestBody userDetailsRequest userRequest){
        userDetailsResponse user =userService.createUser(userRequest);
        return new ResponseEntity<userDetailsResponse>(user,HttpStatus.OK);
    }

    @PutMapping(path="/{userId}",consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<userDetailsResponse> updateUser(@PathVariable String userId,@RequestBody UpdateUserDetailsRequest updateUserRequest){

        userDetailsResponse userUpdate = userService.upateUser(userId,updateUserRequest);

        return new ResponseEntity<userDetailsResponse>(userUpdate,HttpStatus.OK);

    }
    @DeleteMapping(path="/{Id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String Id){
        userService.deleteUser(Id);
        return ResponseEntity.ok().build();
    }


    //for Returning Object as json or xml

//    @GetMapping(path="/{userId}",
//            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
//    public userRest getUser(@PathVariable String userId){
//        userRest user = new userRest();
//        user.setUserId(userId);
//        user.setEmail("Digi@gmail.com");
//        user.setFirstName("Sumit");
//        user.setLastName("Pradhan");
//        return user;
//      return new ResponseEntity<userRest>(HttpStatus.BAD_REQUEST); For sending bad request as status
//        return new ResponseEntity<userRest>(HttpStatus.OK); For sending ok as the status
//    return new ResponseEntity<userDetailsResponse>(user,HttpStatus.OK);//For Sending object with status as ok
//    }



}
