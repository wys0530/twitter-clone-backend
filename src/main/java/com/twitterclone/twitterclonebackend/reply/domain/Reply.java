package com.twitterclone.twitterclonebackend.reply.domain;

import com.twitterclone.twitterclonebackend.global.domain.BaseEntity;
import com.twitterclone.twitterclonebackend.tweet.domain.Tweet;
import com.twitterclone.twitterclonebackend.user.domain.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Reply extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long replyId;

    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tweet_id", nullable = false)
    private Tweet tweet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Reply(String content, Tweet tweet, User user) {
        this.content = content;
        this.tweet = tweet;
        this.user = user;
    }

    //작성자 검증
    public boolean isWrittenBy(Long userId) {
        return this.user.getUserId().equals(userId);
    }
}