package com.twitterclone.twitterclonebackend.user.dto.response;

import com.twitterclone.twitterclonebackend.user.domain.User;

public record UserSummaryResponse(
        Long userId,
        String username,
        String handle,
        String profileImage
) {
    public static UserSummaryResponse from(User user) {
        return new UserSummaryResponse(
                user.getUserId(),
                user.getUsername(),
                user.getHandle(),
                user.getProfileImage()
        );
    }
}