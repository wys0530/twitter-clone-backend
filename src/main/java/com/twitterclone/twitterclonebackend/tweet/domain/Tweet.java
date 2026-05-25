package com.twitterclone.twitterclonebackend.tweet.domain;

import com.twitterclone.twitterclonebackend.global.domain.BaseEntity;
import com.twitterclone.twitterclonebackend.user.domain.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Tweet extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tweetId;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private int viewCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Tweet(String content, User user) {
        this.content = content;
        this.user = user;
        this.viewCount = 0;
    }

    //조회수 증가
    public void increaseViewCount() {
        this.viewCount++;
    }

    //작성자 검증
    public boolean isWrittenBy(Long userId) {
        return this.user.getUserId().equals(userId);
    }
}