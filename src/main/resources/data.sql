INSERT INTO member(`id`, `name`, `email`, `create_at`, `update_at`) VALUES (1, '원영호', '원영호@개미조.com', now(), now());
INSERT INTO member(`id`, `name`, `email`, `create_at`, `update_at`) VALUES (9, '원영호', 'asdf@asdf.com', now(), now());
INSERT INTO member(`id`, `name`, `email`, `create_at`, `update_at`) VALUES (2, '투영호', '투영호@roalwh.com', now(), now());
INSERT INTO member(`id`, `name`, `email`, `create_at`, `update_at`) VALUES (3, '삼영호', '삼영호@개미조.com', now(), now());
INSERT INTO member(`id`, `name`, `email`, `create_at`, `update_at`) VALUES (4, '사영호', '사영호@roalwh.com', now(), now());
INSERT INTO member(`id`, `name`, `email`, `create_at`, `update_at`) VALUES (5, '오영호', '오형호@개미조.com', now(), now());
INSERT INTO member(`id`, `name`, `email`, `create_at`, `update_at`) VALUES (6, '호영호', '호영호@roalwh.com', now(), now());
INSERT INTO member(`id`, `name`, `email`, `create_at`, `update_at`) VALUES (7, '원박사', '원park@개미조.com', now(), now());
INSERT INTO member(`id`, `name`, `email`, `create_at`, `update_at`) VALUES (8, '오박사', '오park@roalwh.com', now(), now());

INSERT INTO crew(`id`, `name`, `email`) VALUES (1, '홍길동', 'Hdong@crews.net');
INSERT INTO crew(`id`, `name`, `email`) VALUES (2, '김길동', 'Gdong@crews.net');
INSERT INTO crew(`id`, `name`, `email`) VALUES (3, '고길동', 'goDong@crews.net');

INSERT INTO publisher(`id`, `name`) VALUES (1, "문상혁 출판사");
INSERT INTO publisher(`id`, `name`) VALUES (2, "상문 출판소");
INSERT INTO publisher(`id`, `name`) VALUES (3, "출판원 영호");

INSERT INTO book(`id`, `name`, `publisher_id`) VALUES (1, 'Funny Spring Boot', 3);
INSERT INTO book(`id`, `name`, `publisher_id`) VALUES (2, 'Hard Spring Boot', 3);
INSERT INTO book(`id`, `name`, `publisher_id`) VALUES (3, 'How to get new member', 2);
INSERT INTO book(`id`, `name`, `publisher_id`) VALUES (4, 'What a good day!', 1);
