package com.example.practice.springIoc;

public interface IEncoder {
    String encodeString(String message);
    byte[] encodeByte(String message);
}
