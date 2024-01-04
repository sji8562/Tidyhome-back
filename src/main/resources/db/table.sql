

CREATE TABLE `user` (
                        `id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
                        `tel` String,
                        `level` Integer COMMENT '0: 사용자 1: 일하는 사람 9: 관리자'
);

CREATE TABLE `reservation` (
                               `id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
                               `menu` integer COMMENT '(1 가사도우미/2 사무실 청소/3 이사청소/4 가전,침대청소)',
                               `address_basic` varchar(255),
                               `address_detail` varchar(255),
                               `serviceHour` integer COMMENT '(2/3/4/8/9/10시간) ',
                               `charge` integer,
                               `reservation_date` date,
                               `reservation_time` time,
                               `pet` boolean COMMENT '(없음/있음)',
                               `entry_method` varchar(255),
                               `created_at` timestamp DEFAULT "now()"
);

CREATE TABLE `addressInfo` (
                               `id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
                               `user_id` integer,
                               `address_basic` varchar(255),
                               `address_detail` varchar(255),
                               `choice` boolean COMMENT '(대표)'
);

CREATE TABLE `sale` (
                        `id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
                        `user_id` integer,
                        `charge` intger,
                        `created_at` timestamp DEFAULT "now()",
                        `tid` varchar(255)
);

CREATE TABLE `cancel` (
                          `id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
                          `sale_id` integer,
                          `created_at` timestamp DEFAULT "now()",
                          `amount` integer
);

CREATE TABLE `Question` (
                            `id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
                            `writer` Integer
);

CREATE TABLE `Answer` (
                          `id` integer PRIMARY KEY NOT NULL AUTO_INCREMENT,
                          `answer` String
);
