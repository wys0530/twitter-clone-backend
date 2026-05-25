package com.twitterclone.twitterclonebackend.reply.controller;

import com.twitterclone.twitterclonebackend.reply.dto.request.ReplyCreateRequest;
import com.twitterclone.twitterclonebackend.reply.dto.response.ReplyCreateResponse;
import com.twitterclone.twitterclonebackend.reply.service.ReplyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tweets/{tweetId}/replies")
public class ReplyController {

    private final ReplyService replyService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReplyCreateResponse createReply(
            @PathVariable Long tweetId,
            @RequestHeader("Auth-id") Long userId,
            @Valid @RequestBody ReplyCreateRequest request
    ) {
        return replyService.createReply(tweetId, userId, request);
    }
}