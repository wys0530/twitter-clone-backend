package com.twitterclone.twitterclonebackend.user.controller;

import com.twitterclone.twitterclonebackend.tweet.dto.response.TweetUserListResponse;
import com.twitterclone.twitterclonebackend.user.dto.UserResponse;
import com.twitterclone.twitterclonebackend.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getUser(userId));
    }

    @GetMapping("/{userId}/tweets")
    public ResponseEntity<TweetUserListResponse> getUserTweets(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getUserTweets(userId));
    }

}