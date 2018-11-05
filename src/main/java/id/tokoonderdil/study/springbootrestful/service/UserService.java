package id.tokoonderdil.study.springbootrestful.service;

import id.tokoonderdil.study.springbootrestful.model.request.UserRequest;
import id.tokoonderdil.study.springbootrestful.model.response.UserResponse;

public interface UserService {
    UserResponse createUser(UserRequest userRequest);
}
