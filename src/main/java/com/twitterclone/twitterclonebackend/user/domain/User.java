package com.twitterclone.twitterclonebackend.user.domain;

import com.twitterclone.twitterclonebackend.global.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false, unique = true)
    private String handle;

    private String profileImage;

    private int followersCount;

    private int followingCount;

    public User(String username, String handle, String profileImage, int followersCount, int followingCount) {
        this.username = username;
        this.handle = handle;
        this.profileImage = profileImage;
        this.followersCount = followersCount;
        this.followingCount = followingCount;
    }
}