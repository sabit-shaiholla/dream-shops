package com.electroboy.dreamshops.service.user;

import com.electroboy.dreamshops.dto.UserDto;
import com.electroboy.dreamshops.model.User;
import com.electroboy.dreamshops.request.CreateUserRequest;
import com.electroboy.dreamshops.request.UserUpdateRequest;

public interface IUserService {
    User getUserById(Long userId);
    User createUser(CreateUserRequest request);
    User updateUser(UserUpdateRequest request, Long userId);
    void deleteUser(Long userId);
    UserDto convertUserToDto(User user);
    User getAuthenticatedUser();
}
