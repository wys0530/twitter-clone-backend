package com.twitterclone.twitterclonebackend.user.dto;

import com.twitterclone.twitterclonebackend.user.domain.User;

import java.time.LocalDateTime;

public record UserResponse(
        Long userId,
        String username,
        String handle,
        String profileImage,
        int followersCount,
        int followingCount,
        LocalDateTime createdAt
) {
    public static UserResponse from(User user) {
        return new UserResponse(
                user.getUserId(),
                user.getUsername(),
                user.getHandle(),
                user.getProfileImage(),
                user.getFollowersCount(),
                user.getFollowingCount(),
                user.getCreatedAt()
        );
    }
}