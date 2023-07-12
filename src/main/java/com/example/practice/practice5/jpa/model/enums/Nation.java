package com.example.practice.practice5.jpa.model.enums;

public enum Nation {
    // 데이터가 많으면 DB테이블로 관리
    // 데이터가 많지 않다면 enum 써도 좋다
    KOREA,
    JAPAN,
    CHINA,
    ENGLAND,
    OTHER
}

/*
    public enum Nation {
        기타(10),
        CHINA(30),
        KOREA(5),
        ENGLAND(6),
        JAPAN(8);

        private final int value;
        Nation(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
* */