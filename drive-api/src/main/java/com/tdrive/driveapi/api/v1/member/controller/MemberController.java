package com.tdrive.driveapi.api.v1.member.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tdrive.driveapi.api.v1.member.request.MemberRequest;
import com.tdrive.driveapi.api.v1.member.response.MemberResponse;
import com.tdrive.drivecore.member.entity.Member;
import com.tdrive.drivecore.storage.service.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/member")
@RestController
@RequiredArgsConstructor
public class MemberController {

    private final ObjectMapper objectMapper;
    private final StorageService storageService;

    @GetMapping
    public ResponseEntity<MemberResponse> getMember(@RequestBody MemberRequest request) {
        var member = objectMapper.convertValue(request, Member.class);
        var response = objectMapper.convertValue(member, MemberResponse.class);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/file")
    public ResponseEntity<MemberResponse> file() {
        storageService.get();
        return ResponseEntity.ok(new MemberResponse(1L, "aa", 1));
    }
}
