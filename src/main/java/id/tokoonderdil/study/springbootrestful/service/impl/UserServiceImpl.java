package id.tokoonderdil.study.springbootrestful.service.impl;

import id.tokoonderdil.study.springbootrestful.model.request.UserRequest;
import id.tokoonderdil.study.springbootrestful.model.response.UserResponse;
import id.tokoonderdil.study.springbootrestful.service.UserService;

import id.tokoonderdil.study.springbootrestful.shared.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    Map<Integer, UserResponse> users;
    Utils utils;

    public UserServiceImpl() {}

    @Autowired
    public UserServiceImpl(Utils utils) {
        this.utils = utils;
    }

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        UserResponse returnUserResponse = new UserResponse();
        returnUserResponse.setFirstName(userRequest.getFirstName());
        returnUserResponse.setLastName(userRequest.getLastName());
        returnUserResponse.setEmail(userRequest.getEmail());
        returnUserResponse.setUserId(userRequest.getUserId());

        if(users == null) users = new HashMap<>();
        users.put(userRequest.getUserId(), returnUserResponse);

        return returnUserResponse;
    }
}
