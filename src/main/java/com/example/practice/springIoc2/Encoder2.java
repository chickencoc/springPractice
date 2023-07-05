package com.example.practice.springIoc2;

import com.example.practice.springIoc2.IEncoder2;

public class Encoder2 implements IEncoder2 {

    private IEncoder2 iEncoder2;

    public Encoder2(IEncoder2 iEncoder) {
        this.iEncoder2 = iEncoder;
    }
    @Override
    public String encodeStr(String message) {
        return iEncoder2.encodeStr(message);
    }

    @Override
    public byte[] encodeByte(String message) {
        return iEncoder2.encodeByte(message);
    }
}
