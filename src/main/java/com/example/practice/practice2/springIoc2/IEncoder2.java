package com.example.practice.practice2.springIoc2;

import org.apache.logging.log4j.message.Message;

public interface IEncoder2 {
    String encodeStr(String message);
    byte[] encodeByte(String message);
}
