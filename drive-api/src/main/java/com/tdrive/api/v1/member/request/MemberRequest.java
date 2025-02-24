package com.tdrive.api.v1.member.request;

public record MemberRequest(
    Long id,
    String name,
    Integer age
)
{
}
