package com.tdrive.api.v1.member.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tdrive.api.v1.member.request.MemberRequest;
import com.tdrive.api.v1.member.response.MemberResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/members")
@RestController
@RequiredArgsConstructor
public class MemberController {

    private final ObjectMapper objectMapper;

    @GetMapping
    public ResponseEntity<MemberResponse> getMember(@RequestBody MemberRequest request) {
        var response = objectMapper.convertValue(request, MemberResponse.class);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/file")
    public ResponseEntity<MemberResponse> file() {
        return ResponseEntity.ok(new MemberResponse(1L, "aa", 1));
    }
}
