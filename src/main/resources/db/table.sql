CREATE TABLE `user_tb` (
                           `id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
                           `tel` varchar(255),
                           `created_at` timestamp DEFAULT "now()"
);

CREATE TABLE `partner_tb` (
                              `id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
                              `tel` varchar(255),
                              `username` varchar(255),
                              `pic_url` varchar(255),
                              `category_id` String,
                              `gender` char,
                              `level` integer COMMENT '1 일하는사람 9 관리자',
                              `created_at` timestamp DEFAULT "now()"
);

CREATE TABLE `reservation_tb` (
                                  `id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
                                  `address_info_id` integer,
                                  `info_id` integer,
                                  `created_at` timestamp DEFAULT "now()"
);

CREATE TABLE `reservation_suc_tb` (
                                      `id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
                                      `reservation_id` integer,
                                      `sale_id` integer,
                                      `created_at` timestamp DEFAULT "now()"
);

CREATE TABLE `wait_tb` (
                           `id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
                           `reservation_suc_id` integer,
                           `etc_info_id` integer,
                           `created_at` timestamp DEFAULT "now()"
);

CREATE TABLE `match_tb` (
                            `id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
                            `wait_id` integer,
                            `partner_id` integer,
                            `created_at` timestamp DEFAULT "now()"
);

CREATE TABLE `info_tb` (
                           `option_id` integer,
                           `id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
                           `reservation_date` date,
                           `reservation_time` time,
                           `pet` boolean COMMENT '반려동물(없음/있음)',
                           `created_at` timestamp DEFAULT "now()"
);

CREATE TABLE `etc_info_tb` (
                               `id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
                               `info_id` integer,
                               `enter` varchar(255) COMMENT '들어가는 방법',
                               `special` varchar(255) COMMENT '특별히 신경쓸곳',
                               `other_request` varchar(255) COMMENT '기타 요청사항'
);

CREATE TABLE `address_info_tb` (
                                   `id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
                                   `user_id` integer,
                                   `post_number` varchar(255),
                                   `address` varchar(255),
                                   `address_detail` varchar(255),
                                   `choice` boolean COMMENT '(대표)',
                                   `created_at` timestamp DEFAULT "now()"
);

CREATE TABLE `sale_tb` (
                           `id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
                           `user_id` integer,
                           `price` integer,
                           `card_id` integer,
                           `created_at` timestamp DEFAULT "now()",
                           `tid` varchar(255)
);

CREATE TABLE `cancel_tb` (
                             `id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
                             `sale_id` integer,
                             `created_at` timestamp DEFAULT "now()",
                             `update_at` timestamp DEFAULT "now()",
                             `price` integer
);

CREATE TABLE `notice_tb` (
                             `id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
                             `title` varchar(255),
                             `content` varchar(10000),
                             `created_at` timestamp DEFAULT "now()"
);

CREATE TABLE `service_tb` (
                              `id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
                              `code` integer COMMENT '1: 자주묻는 질문 2:서비스 상세정보 3:계정탈퇴,4:서비스 약관 5:버전 정보',
                              `created_at` timestamp DEFAULT "now()"
);

CREATE TABLE `first_category_tb` (
                                     `id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
                                     `name` varchar(255) COMMENT '1: 가사도우미, 2: 사무실청소 ,3: 가전/침대청소, 4: 이사청소 '
);

CREATE TABLE `second_category_tb` (
                                      `id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
                                      `first_category_id` integer,
                                      `name` varchar(255) COMMENT '1: 서비스 시간, 2: 공급 면적 ,3: 에어컨, 4: 세탁기 ,5: 메트릭스 '
);

CREATE TABLE `option_tb` (
                             `second_category_id` integer,
                             `id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
                             `name` varchar(255),
                             `price` integer
);

CREATE TABLE `question_tb` (
                               `id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
                               `from_id` integer,
                               `to_id` integer,
                               `subject` varchar(255),
                               `status` varchar(255),
                               `created_at` timestamp DEFAULT "now()"
);

CREATE TABLE `message` (
                           `id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
                           `question_id` integer,
                           `is_from_sender` integer,
                           `content` text,
                           `read_status` integer,
                           `created_at` timestamp
);

CREATE TABLE `card_tb` (
                           `id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
                           `user_id` integer,
                           `provider` varchar(255),
                           `card_number` varchar(255),
                           `ex_date` varchar(255),
                           `card_password` varchar(255),
                           `birth` varchar(255),
                           `created_at` timestamp DEFAULT "now()"
);

ALTER TABLE `second_category_tb` ADD FOREIGN KEY (`first_category_id`) REFERENCES `first_category_tb` (`id`);

ALTER TABLE `option_tb` ADD FOREIGN KEY (`second_category_id`) REFERENCES `second_category_tb` (`id`);

ALTER TABLE `address_info_tb` ADD FOREIGN KEY (`user_id`) REFERENCES `user_tb` (`id`);

ALTER TABLE `card_tb` ADD FOREIGN KEY (`user_id`) REFERENCES `user_tb` (`id`);

ALTER TABLE `reservation_tb` ADD FOREIGN KEY (`address_info_id`) REFERENCES `address_info_tb` (`id`);

ALTER TABLE `info_tb` ADD FOREIGN KEY (`option_id`) REFERENCES `option_tb` (`id`);

ALTER TABLE `reservation_tb` ADD FOREIGN KEY (`info_id`) REFERENCES `info_tb` (`id`);

ALTER TABLE `reservation_suc_tb` ADD FOREIGN KEY (`reservation_id`) REFERENCES `reservation_tb` (`id`);

ALTER TABLE `reservation_suc_tb` ADD FOREIGN KEY (`sale_id`) REFERENCES `sale_tb` (`id`);

ALTER TABLE `wait_tb` ADD FOREIGN KEY (`reservation_suc_id`) REFERENCES `reservation_suc_tb` (`id`);

ALTER TABLE `wait_tb` ADD FOREIGN KEY (`etc_info_id`) REFERENCES `etc_info_tb` (`id`);

ALTER TABLE `match_tb` ADD FOREIGN KEY (`wait_id`) REFERENCES `wait_tb` (`id`);

ALTER TABLE `match_tb` ADD FOREIGN KEY (`partner_id`) REFERENCES `partner_tb` (`id`);

ALTER TABLE `cancel_tb` ADD FOREIGN KEY (`sale_id`) REFERENCES `sale_tb` (`id`);

ALTER TABLE `sale_tb` ADD FOREIGN KEY (`card_id`) REFERENCES `card_tb` (`id`);
