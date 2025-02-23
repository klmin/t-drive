package com.tdrive.driveinfra.storage.ceph.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CephS3User {

    ADMIN("admin", "TR0JLCLPLQEX2LBJYMT5", "ZQltNNTamP82eNDgS19ANPsvUGz4UY5DVYBhlJ8V"),
    TEST_USER("test_user", "LO8VXV2G9956PP1FG2ZJ", "ZEX0IqN5G9xHI8Iq6scKHCHDtAGwIfAhM80XEZzY"),
    TEST_USER2("test_user2", "EMZ2C53T6XHE96AR62AZ", "byhoJGCzfPVvQGskG9PNOW2h37DQoDArDuBtHUpW")
    ;


    private final String userId;
    private final String accessKey;
    private final String secretKey;

}
