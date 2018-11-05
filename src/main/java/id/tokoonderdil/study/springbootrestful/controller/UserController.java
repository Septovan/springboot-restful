package id.tokoonderdil.study.springbootrestful.controller;

import id.tokoonderdil.study.springbootrestful.exception.UserServiceException;
import id.tokoonderdil.study.springbootrestful.model.request.UserRequest;
import id.tokoonderdil.study.springbootrestful.model.request.UserRequestUpdate;
import id.tokoonderdil.study.springbootrestful.model.response.UserResponse;
import id.tokoonderdil.study.springbootrestful.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    Map<Integer, UserResponse> users;
    UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getUser(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "limit", defaultValue = "50") int limit,
            @RequestParam(value = "sort", defaultValue = "DESC", required = false) String sort)
    {
        return "getUser() was Called with page = " + page + " and limit = " + limit + " and sort = " + sort;
    }

    /*
     * JSON Format Response (DEFAULT)
     */
    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getSpecifiedUser(@PathVariable Integer userId) {
//        UserResponse returnUserResponse = new UserResponse();
//        returnUserResponse.setFirstName("Septovan");
//        returnUserResponse.setLastName("Saian");
//        returnUserResponse.setEmail("septovan_suputra@tokoonderdil.id");
//        returnUserResponse.setUserId(userId);
//
//        return returnUserResponse;
        if(true) throw new UserServiceException("A User Service Exception is thrown");

        if(users.containsKey(userId)) {
            return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    /*
     * XML Format Response
     * Header Request -> Accept = application/xml
     */
    @GetMapping(value = "/{userId}/xml", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserResponse> getSpecifiedUserXml(@PathVariable(value = "userId") Integer userId) {
//        UserResponse returnUserResponse = new UserResponse();
//        returnUserResponse.setFirstName("Septovan");
//        returnUserResponse.setLastName("Saian");
//        returnUserResponse.setEmail("septovan_suputra@tokoonderdil.id");
//        returnUserResponse.setUserId(userId);
//
//        return returnUserResponse;

        if(users.containsKey(userId)) {
            return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    /*
     * Add Response Code
     */
    @GetMapping(value = "/{userId}/status", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserResponse> getUser(@PathVariable(value = "userId") Integer userId) {
//        UserResponse returnUserResponse = new UserResponse();
//        returnUserResponse.setFirstName("Septovan");
//        returnUserResponse.setLastName("Saian");
//        returnUserResponse.setEmail("septovan_suputra@tokoonderdil.id");
//        returnUserResponse.setUserId(userId);
        if(users.containsKey(userId)) {
            return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRequest userRequest) {

        return new ResponseEntity<>(userService.createUser(userRequest), HttpStatus.OK);
    }


    @PutMapping(value = "/{userId}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public UserResponse updateUser(@PathVariable Integer userId,
                                   @Valid @RequestBody UserRequestUpdate userRequestUpdate)
    {
        UserResponse storedUser = users.get(userId);
        storedUser.setFirstName(userRequestUpdate.getFirstName());
        storedUser.setLastName(userRequestUpdate.getLastName());

        users.put(userId, storedUser);

        return storedUser;
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer userId) {
        users.remove(userId);
        return ResponseEntity.noContent().build();
    }

}
