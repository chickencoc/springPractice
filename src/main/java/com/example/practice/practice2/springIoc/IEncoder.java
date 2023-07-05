package com.example.practice.practice2.springIoc;

public interface IEncoder {
    String encodeString(String message);
    byte[] encodeByte(String message);
}
