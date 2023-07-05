package com.example.practice.practice2.springIoc2;

import java.util.Base64;

public class Base64Encoder2 implements IEncoder2 {

    @Override
    public String encodeStr(String message) {
        return Base64.getEncoder().encodeToString(message.getBytes());
    }


    public byte[] encodeByte(String message) {
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] encodedBytes = encoder.encode(message.getBytes());

        return encodedBytes;
    }
}
