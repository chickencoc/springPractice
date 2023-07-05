package com.example.practice.practice2;

import java.net.URLEncoder;

public class UrlEncoder implements IEncoder {

    public UrlEncoder() {
    }

    @Override
    public String encodeString(String message) {
        try {
            return URLEncoder.encode(message, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public byte[] encodeByte(String message) {
        try {
            return URLEncoder.encode(message, "UTF-8").getBytes();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

