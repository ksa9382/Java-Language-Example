package org.gtikim.securityfeatures.cryptography;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class MessageDigestTest {

    @Test
    @DisplayName("MessageDigest SHA1 테스트")
    public void testMessageDigestSha1() throws NoSuchAlgorithmException {
        // SHA-1
        MessageDigest mdSha1 = MessageDigest.getInstance("SHA-1");
        byte[] hashedPasswordSha1 = mdSha1.digest("password".getBytes());

        log.info("mdSha1: [" + mdSha1 + "]");

        assertThat(mdSha1.getAlgorithm()).isEqualTo("SHA-1");
        assertThat(mdSha1.getDigestLength()).isEqualTo(20);
        assertThat(hashedPasswordSha1.length).isEqualTo(20);
    }

    @Test
    @DisplayName("MessageDigest SHA256 테스트")
    public void testMessageDigestSha256() throws NoSuchAlgorithmException {
        // SHA-256
        MessageDigest mdSha256 = MessageDigest.getInstance("SHA-256");
        byte[] hashedPasswordSha256 = mdSha256.digest("password".getBytes());

        log.info("mdSha256: [" + mdSha256 + "]");

        assertThat(mdSha256.getAlgorithm()).isEqualTo("SHA-256");
        assertThat(mdSha256.getDigestLength()).isEqualTo(32);
        assertThat(hashedPasswordSha256.length).isEqualTo(32);
    }

    @Test
    @DisplayName("MessageDigest SHA512 테스트")
    public void testMessageDigestSha512() throws NoSuchAlgorithmException {
        // SHA-512
        MessageDigest mdSha512 = MessageDigest.getInstance("SHA-512");
        byte[] hashedPasswordSha256 = mdSha512.digest("password".getBytes());

        log.info("mdSha512: [" + mdSha512 + "]");

        assertThat(mdSha512.getAlgorithm()).isEqualTo("SHA-512");
        assertThat(mdSha512.getDigestLength()).isEqualTo(64);
        assertThat(hashedPasswordSha256.length).isEqualTo(64);
    }

    @Test
    @DisplayName("MessageDigest NoSuchAlgorithm 테스트")
    public void testMessageDigestUnknown() throws NoSuchAlgorithmException {
        MessageDigest unknown;

        org.junit.jupiter.api.Assertions.assertThrows(NoSuchAlgorithmException.class,
                () -> MessageDigest.getInstance("unknown"));

//        byte[] hashedPasswordSha256 = unknown.digest("password".getBytes());
//
//        log.info("unknown: [" + unknown + "]");
//
//        assertThat(unknown.getAlgorithm()).isEqualTo("unknown");
//        assertThat(unknown.getDigestLength()).isEqualTo(0);
//        assertThat(hashedPasswordSha256.length).isEqualTo(0);
    }
}