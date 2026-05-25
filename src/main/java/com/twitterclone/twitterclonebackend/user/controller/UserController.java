package com.twitterclone.twitterclonebackend.user.controller;

import com.twitterclone.twitterclonebackend.user.dto.UserResponse;
import com.twitterclone.twitterclonebackend.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}")
    public UserResponse getUser(@PathVariable Long userId) {
        return userService.getUser(userId);
    }
}