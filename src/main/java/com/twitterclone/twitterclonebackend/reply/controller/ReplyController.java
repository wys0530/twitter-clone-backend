package com.twitterclone.twitterclonebackend.reply.controller;

import com.twitterclone.twitterclonebackend.reply.dto.request.ReplyCreateRequest;
import com.twitterclone.twitterclonebackend.reply.dto.response.ReplyCreateResponse;
import com.twitterclone.twitterclonebackend.reply.dto.response.ReplyListResponse;
import com.twitterclone.twitterclonebackend.reply.service.ReplyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService replyService;

    //답글 작성
    @PostMapping("/tweets/{tweetId}/replies")
    public ResponseEntity<ReplyCreateResponse> createReply(
            @PathVariable Long tweetId,
            @RequestHeader("Auth-id") Long userId,
            @Valid @RequestBody ReplyCreateRequest request
    ) {
        ReplyCreateResponse response = replyService.createReply(tweetId, userId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    //트윗별 답글 조회
    @GetMapping("/tweets/{tweetId}/replies")
    public ResponseEntity<ReplyListResponse> getReplies(@PathVariable Long tweetId) {
        return ResponseEntity.ok(replyService.getReplies(tweetId));
    }

    //답글 삭제
    @DeleteMapping("/replies/{replyId}")
    public ResponseEntity<Void> deleteReply(
            @PathVariable Long replyId,
            @RequestHeader("Auth-id") Long userId
    ) {
        replyService.deleteReply(replyId, userId);
        return ResponseEntity.noContent().build();
    }
}