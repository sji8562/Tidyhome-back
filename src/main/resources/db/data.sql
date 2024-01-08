insert into user_tb(tel, level) values ('01093971773', 0);
insert into user_tb(tel, level) values ('01012345678', 9);
insert into user_tb(tel, level) values ('01058288562', 0);

insert into first_category_tb(id, name) values (1, '가사도우미');
insert into first_category_tb(id, name) values (2, '사무실청소');
insert into first_category_tb(id, name) values (3, '가전/침대청소');
insert into first_category_tb(id, name) values (4, '이사청소');

insert into second_category_tb(id, first_category_id, name) values (1, 1, '방/거실');
insert into second_category_tb(id, first_category_id, name) values (2, 1, '주방');
insert into second_category_tb(id, first_category_id, name) values (3, 1, '욕실');
insert into second_category_tb(id, first_category_id, name) values (4, 1, '기타사항');
insert into second_category_tb(id, first_category_id, name) values (5, 2, '사무실');
insert into second_category_tb(id, first_category_id, name) values (6, 2, '탕비실');
insert into second_category_tb(id, first_category_id, name) values (7, 2, '화장실');
insert into second_category_tb(id, first_category_id, name) values (8, 2, '기타사항');
insert into second_category_tb(id, first_category_id, name) values (9, 3, '에어컨');
insert into second_category_tb(id, first_category_id, name) values (10, 3, '세타기');
insert into second_category_tb(id, first_category_id, name) values (11, 3, '매트리스');
insert into second_category_tb(id, first_category_id, name) values (12, 4, '방/거실');
insert into second_category_tb(id, first_category_id, name) values (13, 4, '주방/욕실');
insert into second_category_tb(id, first_category_id, name) values (14, 4, '현관/베란다');
insert into second_category_tb(id, first_category_id, name) values (15, 4, '창/바닥');

insert into option_tb(second_category_id, name, price) values (1, '2시간', 38900);
insert into option_tb(second_category_id, name, price) values (1, '3시간', 51900);
insert into option_tb(second_category_id, name, price) values (1, '4시간', 64900);
insert into option_tb(second_category_id, name, price) values (1, '8시간', 112900);
insert into option_tb(second_category_id, name, price) values (2, '2시간', 38900);
insert into option_tb(second_category_id, name, price) values (2, '3시간', 51900);
insert into option_tb(second_category_id, name, price) values (2, '4시간', 64900);
insert into option_tb(second_category_id, name, price) values (2, '8시간', 112900);
insert into option_tb(second_category_id, name, price) values (3, '2시간', 38900);
insert into option_tb(second_category_id, name, price) values (3, '3시간', 51900);
insert into option_tb(second_category_id, name, price) values (3, '4시간', 64900);
insert into option_tb(second_category_id, name, price) values (3, '8시간', 112900);
insert into option_tb(second_category_id, name, price) values (4, '2시간', 38900);
insert into option_tb(second_category_id, name, price) values (4, '3시간', 51900);
insert into option_tb(second_category_id, name, price) values (4, '4시간', 64900);
insert into option_tb(second_category_id, name, price) values (4, '8시간', 112900);
insert into option_tb(second_category_id, name, price) values (5, '2시간', 43000);
insert into option_tb(second_category_id, name, price) values (5, '3시간', 59000);
insert into option_tb(second_category_id, name, price) values (5, '4시간', 72000);
insert into option_tb(second_category_id, name, price) values (5, '8시간', 112000);
insert into option_tb(second_category_id, name, price) values (6, '2시간', 43000);
insert into option_tb(second_category_id, name, price) values (6, '3시간', 59000);
insert into option_tb(second_category_id, name, price) values (6, '4시간', 72000);
insert into option_tb(second_category_id, name, price) values (6, '8시간', 112000);
insert into option_tb(second_category_id, name, price) values (7, '2시간', 43000);
insert into option_tb(second_category_id, name, price) values (7, '3시간', 59000);
insert into option_tb(second_category_id, name, price) values (7, '4시간', 72000);
insert into option_tb(second_category_id, name, price) values (7, '8시간', 112000);
insert into option_tb(second_category_id, name, price) values (8, '2시간', 43000);
insert into option_tb(second_category_id, name, price) values (8, '3시간', 59000);
insert into option_tb(second_category_id, name, price) values (8, '4시간', 72000);
insert into option_tb(second_category_id, name, price) values (8, '8시간', 112000);
insert into option_tb(second_category_id, name, price) values (9, '벽걸이 에어컨', 60000);
insert into option_tb(second_category_id, name, price) values (9, '스탠드 에어컨-일반', 95000);
insert into option_tb(second_category_id, name, price) values (9, '스탠드 에어컨-스마트', 95000);
insert into option_tb(second_category_id, name, price) values (9, '시스탬(천장형)에어컨-1 way', 80000);
insert into option_tb(second_category_id, name, price) values (9, '시스탬(천장형)에어컨-2 way', 80000);
insert into option_tb(second_category_id, name, price) values (9, '시스탬(천장형)에어컨-4 way', 119000);
insert into option_tb(second_category_id, name, price) values (10, '일반세탁기-14kg 이하', 89000);
insert into option_tb(second_category_id, name, price) values (10, '일반세탁기-15-17kg', 99000);
insert into option_tb(second_category_id, name, price) values (10, '일반세탁기-18kg 이상', 114000);
insert into option_tb(second_category_id, name, price) values (10, '드럼세탁기-14kg 이하', 89000);
insert into option_tb(second_category_id, name, price) values (10, '드럼세탁기-15-17kg', 99000);
insert into option_tb(second_category_id, name, price) values (10, '드럼세탁기-18kg 이상', 114000);
insert into option_tb(second_category_id, name, price) values (10, '빌트인세탁기', 139000); -- 삼성제품은(149000)이랍니다;
insert into option_tb(second_category_id, name, price) values (11, '싱글,슈퍼싱글', 40000);
insert into option_tb(second_category_id, name, price) values (11, '더블,퀸', 45000);
insert into option_tb(second_category_id, name, price) values (11, '킹', 50000);
insert into option_tb(second_category_id, name, price) values (12, '9평이하', 150000);
insert into option_tb(second_category_id, name, price) values (12, '10-18평', 200000);
insert into option_tb(second_category_id, name, price) values (12, '19평 이상', 10900); -- 이거 평당임 ㅋㅋ
insert into option_tb(second_category_id, name, price) values (12, '거주청소', 12900); -- 이것도 ㅋ
insert into option_tb(second_category_id, name, price) values (13, '9평이하', 150000);
insert into option_tb(second_category_id, name, price) values (13, '10-18평', 200000);
insert into option_tb(second_category_id, name, price) values (13, '19평 이상', 10900); -- 이거 평당임 ㅋㅋ
insert into option_tb(second_category_id, name, price) values (13, '거주청소', 12900); -- 이것도 ㅋ
insert into option_tb(second_category_id, name, price) values (14, '9평이하', 150000);
insert into option_tb(second_category_id, name, price) values (14, '10-18평', 200000);
insert into option_tb(second_category_id, name, price) values (14, '19평 이상', 10900); -- 이거 평당임 ㅋㅋ
insert into option_tb(second_category_id, name, price) values (14, '거주청소', 12900); -- 이것도 ㅋ
insert into option_tb(second_category_id, name, price) values (15, '9평이하', 150000);
insert into option_tb(second_category_id, name, price) values (15, '10-18평', 200000);
insert into option_tb(second_category_id, name, price) values (15, '19평 이상', 10900); -- 이거 평당임 ㅋㅋ
insert into option_tb(second_category_id, name, price) values (15, '거주청소', 12900); -- 이것도 ㅋ


