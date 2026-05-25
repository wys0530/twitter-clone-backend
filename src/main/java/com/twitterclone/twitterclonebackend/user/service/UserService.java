package com.twitterclone.twitterclonebackend.user.service;

import com.twitterclone.twitterclonebackend.global.exception.CustomException;
import com.twitterclone.twitterclonebackend.global.exception.ErrorCode;
import com.twitterclone.twitterclonebackend.user.domain.User;
import com.twitterclone.twitterclonebackend.user.dto.UserResponse;
import com.twitterclone.twitterclonebackend.user.dto.UserResponse;
import com.twitterclone.twitterclonebackend.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponse getUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));

        return UserResponse.from(user);
    }
}