
insert into admin_tb(admin_name,admin_password, created_at) values ('admin','1234',now());


insert into user_tb(tel,created_at) values ('1234',now());
insert into user_tb(tel,created_at) values ('01093971773',now());
insert into user_tb(tel,created_at) values ('01012345678',now());
insert into user_tb(tel,created_at) values ('01051515151',now());
insert into user_tb(tel,created_at) values ('01051519595',now());
insert into user_tb(tel,created_at) values ('01095953535',now());
insert into user_tb(tel,created_at) values ('01095959595',now());



insert into partner_tb(tel,username,pic_url,category_id,created_at) values ('01095959595','쌀컴퍼니',null,'1,4',now());
insert into partner_tb(tel,username,pic_url,category_id,created_at) values ('01058288562','송재익',null,'1,2',now());



insert into first_category_tb(name) values ( '가사도우미');
insert into first_category_tb(name) values ( '사무실청소');
insert into first_category_tb(name) values ('이사청소');

insert into second_category_tb(first_category_id, name) values ( 1, '방/거실');
insert into second_category_tb(first_category_id, name) values ( 1, '주방');
insert into second_category_tb(first_category_id, name) values ( 1, '욕실');
insert into second_category_tb(first_category_id, name) values ( 1, '기타사항');
insert into second_category_tb(first_category_id, name) values ( 2, '사무실');
insert into second_category_tb(first_category_id, name) values ( 2, '탕비실');
insert into second_category_tb(first_category_id, name) values ( 2, '화장실');
insert into second_category_tb(first_category_id, name) values ( 2, '기타사항');
insert into second_category_tb(first_category_id, name) values ( 3, '방/거실');
insert into second_category_tb(first_category_id, name) values ( 3, '주방/욕실');
insert into second_category_tb(first_category_id, name) values ( 3, '현관/베란다');
insert into second_category_tb(first_category_id, name) values ( 3, '창/바닥');

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
insert into option_tb(second_category_id, name, price) values (9, '9평이하', 150000);
insert into option_tb(second_category_id, name, price) values (9, '10-18평', 200000);
insert into option_tb(second_category_id, name, price) values (10, '9평이하', 150000);
insert into option_tb(second_category_id, name, price) values (10, '9평이하', 150000);
insert into option_tb(second_category_id, name, price) values (10, '10-18평', 200000);
insert into option_tb(second_category_id, name, price) values (11, '9평이하', 150000);
insert into option_tb(second_category_id, name, price) values (11, '10-18평', 200000);
insert into option_tb(second_category_id, name, price) values (12, '9평이하', 150000);
insert into option_tb(second_category_id, name, price) values (12, '10-18평', 200000);




<<<<<<< HEAD
insert into info_tb(option_id, reservation_date, reservation_time, pet, enter, enter_password, special, other_request, created_at) values (1, '2024년1월30일', '오후 2시~오후 4시', true, '자유출입', '1234', '싱크대쪽 잘 청소해주세요', '없음', now());
insert into info_tb(option_id, reservation_date, reservation_time, pet, enter, enter_password, special, other_request, created_at) values (2, '2024년2월12일', '오후 2시~오후 4시', true, '자유출입', '1234', '싱크대쪽 잘 청소해주세요', '없음', now());
insert into info_tb(option_id, reservation_date, reservation_time, pet, enter, enter_password, special, other_request, created_at) values (17, '2024년01월20일', '오후 4시~오후 6시', false,'자유출입', '1234', '싱크대쪽 잘 청소해주세요', '없음', now());
insert into info_tb(option_id, reservation_date, reservation_time, pet, enter, enter_password, special, other_request, created_at) values (18, '2024년02월20일', '오후 4시~오후 6시', true,'자유출입', '1234', '싱크대쪽 잘 청소해주세요', '없음', now());
insert into info_tb(option_id, reservation_date, reservation_time, pet, enter, enter_password, special, other_request, created_at) values (34, '2024년1월23일', '오전 9시~오후 11시', true, '자유출입', '1234', '싱크대쪽 잘 청소해주세요', '없음', now());
insert into info_tb(option_id, reservation_date, reservation_time, pet, enter, enter_password, special, other_request, created_at) values (35, '2024년3월23일', '오전 9시~오후 11시', false, '자유출입', '1234', '싱크대쪽 잘 청소해주세요', '없음', now());
insert into info_tb(option_id, reservation_date, reservation_time, pet, enter, enter_password, special, other_request, created_at) values (8, '2024년3월23일', '오전 9시~오후 11시', true, '자유출입', '1234', '싱크대쪽 잘 청소해주세요', '없음', now());
=======
insert into info_tb(option_id, reservation_date, reservation_time, pet, enter, enter_password, special, other_request, created_at) values (1, '2024년1월30일', '오후 2시~오후 4시', true, '자유출입', '1234', '싱크대쪽 잘 청소해주세요', '깨끗하게해주세요', now());
insert into info_tb(option_id, reservation_date, reservation_time, pet, enter, enter_password, special, other_request, created_at) values (17, '2024년01월20일', '오후 4시~오후 6시', true,'자유출입', '1234', '싱크대쪽 잘 청소해주세요', '깨끗하게해주세요', now());
insert into info_tb(option_id, reservation_date, reservation_time, pet, enter, enter_password, special, other_request, created_at) values (34, '2024년1월23일', '오전 9시~오후 11시', true, '자유출입', '1234', '싱크대쪽 잘 청소해주세요', '깨끗하게해주세요', now());
>>>>>>> e8ab1a166e66e9882218a771e685c04f24382d1b


insert into address_info_tb(user_id, address, address_detail, choice) values (1, 'test 주소1', 'test1동 test1호', true);
insert into address_info_tb(user_id, address, address_detail) values (1, 'test 주소2', 'test2동 test2호');
insert into address_info_tb(user_id, address, address_detail) values (1, 'test 주소3', 'test3동 test3호');
insert into address_info_tb(user_id, address, address_detail) values (1, 'test 주소4', 'test4동 test4호');
insert into address_info_tb(user_id, address, address_detail) values (2, 'test2 주소1', 'test2동 test1호');
insert into address_info_tb(user_id, address, address_detail) values (3, 'test3 주소1', 'test3동 test1호');
insert into address_info_tb(user_id, address, address_detail) values (4, 'test4 주소1', 'test4동 test1호');

insert into service_tb(name) values ('자주묻는 질문');
insert into service_tb(name) values ('서비스 상세정보');
insert into service_tb(name) values ('계정 탈퇴');
insert into service_tb(name) values ('서비스 약관');
insert into service_tb(name) values ('버전 정보');

insert into faq_tb(service_id, name) values (1,'결제/예약');
insert into faq_tb(service_id, name) values (1,'개인정보/환경설정');
insert into faq_tb(service_id, name) values (1,'가사도우미');
insert into faq_tb(service_id, name) values (1,'사무실청소');
insert into faq_tb(service_id, name) values (1,'이사청소');


insert into faq_part_tb(faq_id, title,content, code) values (1,'카드 등록은 어떻게 하나요?','앱에서 신용카드 또는 카카오페이를 등록해 주세요\n카드 결제가 어렵다면 웹과 앱 내 실시간 문의를 통해\n미소로 문의하시길 바랍니다.\n\n\n 1.앱 \n2.내 정보\n3. 결제 수단 관리\n4.[카드 추가하기] 또는 [카카오페이 추가하기]\n\n * 체크카드 또는 타인 명의 카드도 등록 가능합니다.',1);
insert into faq_part_tb(faq_id, title,content, code) values (1,'결제는 언제 진행되나요?','서비스 별 결제 시기는 다를 수 있어요.

[가사도우미/사무실청소/가전청소]

1회서비스, 정기서비스 모두 최초는 예약 시 결제되어요.
정기서비스는 2회차부터 서비스 하루 전 오후 7시에 결제되어요.
등록해 주신 카드 정보는 나이스페이와 카카오페이에 의해 관리되니 안심하세요.
결제는 자동으로 진행되니 파트너님께 직접 서비스 비용을 지불하지 말아주세요.
결제 실패 시 예약이 안 이루어 질 수 있으니 카드 잔고와 사용 유무를 꼭 확인해 주세요.
미소 앱 또는 고객센터를 통해 요청하실 경우만 취소 가능하니 주의해주세요.
[소형이사]

서비스 예약 시 예약금만 미소를 통해 선불 결제 이루어지며, 잔금은 서비스 종료 후 고객이 파트너에게 카드결제/계좌이체를 진행되어요.
이사 잔금에 대한 부가세, 현금영수증, 세금계산서는 이사 업체에 문의해 주세요.
[가정이사]

미소 내 별도 결제 없이 예약금 및 잔금 결제를 파트너와 직접 진행해요.
[이사/입주청소]

간편예약:
미소 앱에서 예약 접수
예약 접수 24시간 내 미소 본사가 서비스 유선 안내
예약금 결제 후 예약 확정
서비스일 1~2일 전 방문할 청소팀이 출입 방법 확인 위해 고객님께 연락
서비스 수행 및 후불 결제 (예약금 환불 후 총 서비스 금액 재결제)
*예약금 환불 불가(단, 예약금은 결제하였지만 청소팀 배정 불가한 경우 예약금 환불)
*인테리어, 이사, 가전 설치 등과 동시에 진행할 수 없으며 서비스 접수 당시 고지되지 않은 경우 청소팀의 현장 철수 사유가 될 수 있으며 위약금이 발생해요.

      2. 무료견적: 마음에 드는 업체를 직접 선택하고 해당 업체에 직접 결제해요.

[다른 홈서비스]

미소 내 별도 결제 없이 견적 금액을 파트너와 직접 진행해요.',1);
insert into faq_part_tb(faq_id, title,content, code) values (1,'현금영수증 발급이 필요해요','계좌이체/가상계좌로 결제하신 경우 현금영수증(지출증빙영수증) 발급이 가능해요. 현금영수증 및 지출증빙영수증은 서비스 이용내역 기준으로 발급 되어요. 미소 실시간 문의를 통해 말씀해 주시면 도움드릴 수 있어요.',1);
insert into faq_part_tb(faq_id, title,content, code) values (1,'카드 결제 영수증이 필요해요','카드 결제 후 영수증을 원하신다면 주문 상세 화면에서 직접 받아 보실 수 있어요.
1. 앱
2. 예약내역
3. 완료된 서비스
4. 서비스 상세 > 결제 정보 > 영수증 [요청하기]',1);
insert into faq_part_tb(faq_id, title,content, code) values (1,'영수증 발급이 필요해요','미소에서 서비스를 받으신 후 계좌이체/가상계좌로 결제하신 경우 현금영수증(지출증빙영수증) 발급이 가능합니다. 미소 실시간 문의를 통해 말씀해 주시면 담당 부서에 전달하여 도움을 드리도록 하겠습니다. 카드 결제 후 영수증을 원하신다면 나이스 페이먼츠를 통해 확인할 수 있습니다.',1);
insert into faq_part_tb(faq_id, title,content, code) values (1,'쿠폰을 적용하고싶어요','미소 앱에서 예약을 진행 시 [쿠폰 사용]을 체크해주세요.
이미 예약을 하셨다면 서비스 내역에서 결제가 이뤄지지 않은 서비스에 사용 가능합니다.',1);
insert into faq_part_tb(faq_id, title,content, code) values (1,'예약 내역을 확인하고 싶어요','미소 앱에서 예약 내역을 확인할 수 있습니다.',2);
insert into faq_part_tb(faq_id, title,content, code) values (1,'예약을 변경, 취소하고 싶어요','앱에서 간편하게 예약을 변경할 수 있습니다. 예약된 서비스에서 일정을 눌러 변경해보세요.

(단, 정기 고객의 경우 청소 주기에 따라 해당 기능을 지원하지 않을 수 있습니다. 이 경우, 웹 또는 앱 내 실시간 문의를 통해 연락 주시면 취소 도와드리겠습니다.)

예약 취소·변경 요청 시점에 따라 수수료가 부과될 수 있습니다.


[가사도우미/사무실 청소]



전날 18:00 까지 앱에서 예약 변경·취소 가능
전날 18:00 이후 변경·취소 시 서비스 요금의 30% 수수료 부과
서비스 시작 1시간 전 변경·취소 시 서비스 요금 전액 부과
이미 결제되었다면 결제 취소 후 수수료만 별도로 결제되어요.


[가정이사]


‘2인 이상 거주’를 선택하신 경우, 미소는 고객님과 이사업체를 연결해드리는 역할만 하고 있습니다. 따라서 예약 변경/취소에 관련된 부분은 이사업체와 직접 소통해주셔야 합니다.



[소형이사]



예약금 결제 전 별도의 위약금 없이 변경·취소 가능
(단, 변경 시 견적금액이 변동 될 수 있습니다)
예약금 결제 후 가능 여부 확인하여 변경·취소는 가능하나 고객 변심으로 취소하는 경우 예약금 반환 불가
이사화물 표준약관 제9조에 의거하여,
1. 고객이 약정된 이사화물의 인수일 1일전까지 해제를 통지한 경우: 납부한 계약금 배상
2. 고객이 약정된 이사화물의 인수일 당일에 해제를 통지한 경우: 납부한 계약금의 배액


[이사/입주청소]



당일 예약, 당일 취소/변경: 없음 (단, 익일 서비스를 요청하였고 예약금을 결제한 경우 서비스 1일 전 취소/변경 규정에 따라 서비스 요금의 30% 위약금 발생)
청소일 이틀 전 취소/변경: 청소 요금의 20% 위약금 발생
하루 전 ~ 당일 취소/변경: 청소 요금의 30% 위약금 발생
청소 당일 이사 및 인테리어 등의 사유로 청소 시작이 지연될 경우 대기료 발생(30분 이상 대기 시 부터 발생하며, 청소 작업자 인당 1시간에 2만 원. 30분이상 1시간 이하 대기 시 1시간 대기로 간주)


*예약금 환불 불가(단, 예약금은 결제하였지만 청소팀 배정 불가한 경우 예약금 환불)
*인테리어, 이사, 가전 설치 등과 동시에 진행할 수 없으며 서비스 접수 당시 고지되지 않은 경우 청소팀의 현장 철수 사유가 될 수 있으며 위약금이 발생해요.



[가전/침대청소]



서비스일 2일 전 18시 이후 변경·취소 시 서비스 요금의 20% 수수료 부과
서비스 1시간 전 변경·취소 시 서비스 요금의 30% 수수료와 출장비 1만 원 부과',2);
insert into faq_part_tb(faq_id, title,content, code) values (1,'방문 전에 연락이 오나요 ?','서비스 진행이 확정되면 서비스 전날 3시에 문자 또는 카카오톡으로 안내 문자가 발송됩니다. 미소 또는 클리너가 전화로 방문 전 연락을 드리지는 않습니다. 요청사항 전달 등 용무가 있으신 경우 웹과 앱 내 실시간 문의를 통해 미소로 문의 주세요. (단, 이사는 필요에 따라 배정된 파트너가 사전에 연락하여 서비스 진행 관련 사항을 안내합니다.)',2);
insert into faq_part_tb(faq_id, title,content, code) values (1,'미소 파트너에게 요청 사항을 전달하고 싶어요','웹과 앱 내 실시간 문의로 요청 사항을 전달주시면, 미소 파트너(클리너)에게 안내해드립니다.',2);
insert into faq_part_tb(faq_id, title,content, code) values (1,'부재중일 때도 서비스가 가능한가요?','웹과 앱 내 실시간 문의로 현관 출입 방법을 전달해주세요. 고객님께서 부재중이시더라도 서비스를 받아보실 수 있도록 미소에서 클리너에게 출입 방법을 안내해드립니다.

고객님께서 집에 계시지 않아도 서비스 진행이 가능합니다!
많은 고객님들이 부재중에도 서비스를 받아보고 계십니다. 신원 확인과 검증을 마친 미소의 파트너가 방문하니 안심하세요.
부재중에 서비스를 받고 싶으신 경우, 예약 후 실시간 문의를 통해 출입 방법을 미소로 꼭 전달해주세요!',2);
insert into faq_part_tb(faq_id, title,content, code) values (1,'야간에도 서비스가 가능한가요?','파트너의 안전한 귀가를 위해 오후 10시에 모든 서비스가 종료 됩니다.
가사도우미/사무실 청소는 4시간 주문의 경우 오후 6시에 서비스 시작이 되어야합니다.',2);




insert into faq_part_tb(faq_id, title,content, code) values (2,'회원 정보를 변경하고 싶어요','이름, 연락처, 주소지, 카드 등 계정 정보 변경을 원하시는 경우, 웹과 앱 내 실시간 문의를 통해 전달주시면 처리를 도와드립니다.
단, 탈퇴 요청 시 고객님의 모든 정보가 사라집니다. 탈퇴 후에는 정보 복구가 불가능하니, 주의해주세요.',1);
insert into faq_part_tb(faq_id, title,content, code) values (2,'번호를 입력해도 인증 번호가 안와요','다음 세 가지 방법으로 시도해보세요.

1. 미소 어플 강제 종료 후 재시작
2. 휴대폰 재시작
3. 미소 어플 삭제 후 재설치

위 세가지 방법으로도 인증 번호 인증에 문제가 있으시다면, 웹과 앱 내 실시간 문의로 스마트폰 기종과 문제 상황을 전달해주세요. 신속히 해결 도와드리겠습니다.',1);
insert into faq_part_tb(faq_id, title,content, code) values (2,'앱에서 주소 입력이 안되요','다음 사항을 다시 한 번 확인해주세요.

1. 앱 내에 나와있는 검색 예시대로 입력하셨는지 확인해주세요.(“지역+지번”, “도로명+건물번호” 또는 “지역+아파트명”)
2. 정확한 주소를 입력하셨는지 확인해주세요. 오타 또는 잘못된 건물 명을 입력할 경우 주소 확인이 어려울 수 있습니다.

위 두가지 방법으로 시도한 후에도 동일한 문제가 발생하신다면 웹과 앱 내 [실시간 문의]로 연락주세요. 신속히 해결 도와드리겠습니다.',1);

insert into faq_part_tb(faq_id, title,content, code) values (3,'가사도우미 서비스 종류는 어떤 게 있나요?','1회 청소와 정기 청소 중 선택할 수 있습니다.
1회 청소는 고객 집에 한 번 방문하여 가정집 생활청소를 진행합니다.
정기 청소는 동일한 클리너가 정기적으로 고객님 댁을 방문하는 고객 맞춤형 서비스입니다.
원하실 경우 클리너는 언제든지 변경할 수 있습니다.',1);
insert into faq_part_tb(faq_id, title,content, code) values (3,'청소 범위가 굼금해요','가사도우미 서비스는 일반 가정집 생활청소를 제공합니다.


<서비스 가능 범위>

– 거실, 침실의 먼지 제거와 침구 정리

– 설거지, 주방 청소

– 욕실, 베란다 물청소

– 세탁기를 이용한 빨래

– 정리정돈


<서비스 불가 범위>
– 아기 돌봄, 간병
– 입주 빈집, 공사 후 청소
– 손빨래
– 바닥 손 걸레질
– 파손 위험이 있는 그릇정리
– 손이 닿지 않는 높은 곳 가구 이동, 재배치
– 소독, 방충
– 전문청소가 필요함 곰팡이, 찌든 때, 기름때, 물때 등
– 반려 동물 배변 청소
– 반찬 및 국/찌개 조리
– 다림질
– 입주,이사,퇴거 청소

*창문 창틀, 냉장고 청소 등 구체적인 사항은 실시간 문의를 통해 미소에 미리 요청해주세요.
*입주, 이사, 퇴거 등을 위한 청소는 생활청소 범위가 아니오니, 미소 이사 청소 서비스를 이용해 주세요.',1);
insert into faq_part_tb(faq_id, title,content, code) values (3,'우리 지역에서 미소를 이용할 수 있나요?','서울, 경기를 비롯해 전국 17개 시도에서 이용 가능합니다.

수도권 : 서울, 경기, 인천
경상권 : 부산, 울산, 창원, 거제, 김해, 사천, 양산, 진주, 통영, 대구, 경산, 경주, 구미, 포항
강원권 : 강릉, 동해, 속초, 원주, 춘천
충청권 : 대전, 세종, 아산, 천안, 제천, 청주, 충주
전라권 : 광주, 광양, 목포, 순천, 여수, 군산, 익산, 전주
제주권 : 서귀포, 제주',1);
insert into faq_part_tb(faq_id, title,content, code) values (3,'청소 도구는 무엇을 준비해야 하나요 ?','소지하고 계신 청소 도구를 사용합니다. 청소에 필요한 도구를 준비해주세요.

– 진공 청소기(또는 빗자루)
– 막대걸레
– 청소포(막대걸레 부착용)
– 걸레
– 고무장갑
– 세제
– 세척용품
– 쓰레기봉투 등



*청소 도구 미구비시 서비스 진행이 어려울 수 있습니다.',1);
insert into faq_part_tb(faq_id, title,content, code) values (3,'우리 집에 어떤 분이 방문하나요?','미소에서 신원 확인과 검증을 마친 클리너가 방문합니다. 고객 평가를 통해 검증된 클리너를 배정해드립니다.',1);
insert into faq_part_tb(faq_id, title,content, code) values (3,'서비스 시간을 추천해 주세요','클리너 한 분이 방문하여 생활 청소를 진행합니다. 집 규모와 청소 상황에 알맞은 서비스 시간을 지정해주세요.

– 2시간 : 1인 가구 또는 주 2회 이상 청소 시 추천합니다.
– 3시간 : 주기적으로 청소 시 추천합니다.
– 4시간 : 기본 서비스 시간으로, 20평 기준 주 1회 청소 시 추천합니다.
– 8시간 : 40평 이상 또는 청소 범위가 많을 경우 추천합니다.',1);
insert into faq_part_tb(faq_id, title,content, code) values (3,'클리너에게 휴식 시간을 드려야 하나요?','6시간 이상 서비스 시에는 보다 원할한 서비스를 위해 최소 30분의 식사·휴식시간을 보장해주세요.',1);
insert into faq_part_tb(faq_id, title,content, code) values (3,'부재중일 때도 서비스가 가능한가요?','앱 예약내역 페이지에서 파트너 출입방법을 직접 입력할 수 있습니다.   출입방법은 암호화되어 안전하게 관리되며 서비스 30분 전부터 종료 시까지 담당 파트너만 확인 가능합니다.
앱 하단 [예약내역] 리스트 페이지 선택
출입방법을 등록할 [서비스] 선택
[출입방법] 선택 후 입력하기
* 웹 예약 시 앱에서 간편하게 출입 방법을 입력해보세요.',1);
insert into faq_part_tb(faq_id, title,content, code) values (3,'집에 CCTV/홈카메라가 설치되어있어요','개인정보보호법 15조 2항에 따라 영상 촬영 시 고객님께서 클리너분께 CCTV 설치 여부를 알려드리고 동의를 받아야합니다.

예약 후 앱 내 부가정보를 입력하면 클리너가 사전에 확인할 수 있습니다.

앱 하단 [예약내역] 리스트 페이지 선택
부가정보를 입력할 [서비스] 선택
[기타 요청사항] 선택 후 CCTV 설치 유무 작성
* 웹 예약 시 앱에서 간편하게 입력해보세요.',1);
insert into faq_part_tb(faq_id, title,content, code) values (3,'반려동물 표기를 꼭 해야 되나요?','간혹 파트너님들께서 반려동물 공포 
혹은 알레르기가 있을 수 있습니다.
그렇기 때문에 예약 시 반려동물 유무를 꼭 선택해 주셔야 합니다.

반려동물 없음을 선택하였는데
방문 시 반려동물이 있는 경우, 서비스 진행이 어려워
취소 수수료가 발생될 수 있어요.
반려동물 있음을 선택하면
공포 및 알레르기가 없는 파트너님이 서비스 진행합니다.
서비스 중에 반려동물이 없더라도 파트너에게 알레르기가 발생할 수 있으니  반려동물 있음으로
선택해 주세요.',1);

insert into faq_part_tb(faq_id, title,content, code) values (3,'시간을 연장하고 싶어요.','서비스 중 시간 연장은 클리너와 사전 협의해야 하며, 클리너의 사정으로 연장이 불가할 수 있습니다. 필요할 경우 실시간 문의를 통해 알려주세요.
연장에 따른 추가금은 서비스 지역과 서비스 종류(정기/1회)에 따라 다르니 웹과 앱 내 [실시간 문의] 통해 미소로 문의해주세요.',2);
insert into faq_part_tb(faq_id, title,content, code) values (3,'클리너에게 식대를 제공해야하나요 ?','식사나 식대를 제공하지 않아도 됩니다. 다만 더 원활한 서비스를 위해 6시간 이상 서비스 시 최소 30분의 식사·휴식시간을 보장해주세요.',2);
insert into faq_part_tb(faq_id, title,content, code) values (4,'청소 범위가 궁금해요.','일반 생활청소를 제공하여 사무실 전반의 청결을 유지합니다.



<서비스 가능 범위>
– 사무실/회의실 먼지 제거
– 탕비실/흡연실 정리 및 청소
– 화장실/탈의실/샤워실 청소
– 정리정돈



<서비스 불가 범위>
– 손님 응대 및 식당 주방 청소
– 개업 청소 및 공사 후 청소
– 손빨래 및 바닥 손 걸레질
– 손이 닿지 않는 높은 곳 청소
– 소독, 방충
– 거미줄, 심한 찌든 때, 기름때 제거
– 장비, 약품이 필요한 카펫, 바닥 청소
– 주방 후드 및 배기관 청소
– 가전제품 분리 세척
– 무거운 기구를 이동해서 청소해야 하거나, 파손의 위험이 있는 고가의 기구',1);
insert into faq_part_tb(faq_id, title,content, code) values (4,'청소 도구는 무엇을 준비해야 하나요?','소지하고 계신 청소 도구를 사용합니다. 청소에 필요한 도구를 미리 준비해주세요.



– 진공 청소기(또는 빗자루)
– 막대걸레
– 청소포(막대걸레 부착용)
– 걸레
– 고무장갑
– 세제
– 세척용품
– 종량제 쓰레기봉투',1);
insert into faq_part_tb(faq_id, title,content, code) values (4,'사무실 청소 서비스 종류는 어떤게 있나요?','1회 청소와 정기 청소 중 선택할 수 있습니다.

1회 청소는 고객님의 사무실 또는 사업장에 한 번 방문하여 청소를 진행합니다.

정기 청소는 동일한 클리너가 정기적으로 고객님의 사무실 또는 사업장을 방문하는 고객 맞춤형 서비스입니다. 원하실 경우 클리너는 언제든지 변경할 수 있습니다.',1);
insert into faq_part_tb(faq_id, title,content, code) values (4,'적합한 서비스 시간을 추천해 주세요','클리너 한 분이 방문하여 생활청소를 진행합니다. 사무실 및 사업장 규모와 청소 상황에 알맞은 서비스 시간을 지정해주세요.



– 2시간: 소규모 사업장 또는 주 2회 이상 청소 시 추천합니다.

– 3시간: 기본 서비스 시간으로, 주 1회 청소 시 추천합니다.

– 4시간: 50평 또는 2층 이상의 사업장 및 청소 범위가 많은 경우 추천합니다.

– 8시간: 100평 이상 또는 청소 범위가 많은 경우 추천합니다.

* 미소는 시간제 서비스로, 사업장 및 요청사항에 따라 적정 서비스 시간이 상이할 수 있습니다.',1);
insert into faq_part_tb(faq_id, title,content, code) values (4,'법인카드로 결제할 수 있나요?','법인카드 결제 가능합니다. 카드정보와 사업자등록번호를 입력해 사용하실 법인카드를 등록해주세요. 서비스를 접수하시면 등록하신 카드로 자동 결제됩니다.',1);
insert into faq_part_tb(faq_id, title,content, code) values (4,'영수증 및 현금영수증 발행은 어떻게 하나요?','나이스 페이먼츠에서 사용하신 신용카드 영수증을 확인할 수 있습니다.

영수증 발급받기

계좌이체는 support@getmiso.com 으로 성함, 연락처 보내주시면 발급해드립니다.',1);
insert into faq_part_tb(faq_id, title,content, code) values (4,'비대면으로도 서비스가 가능한가요?','비대면 서비스 가능합니다. 앱 실시간 문의를 통해 사업장 출입 방법과 청소 도구 보관 위치, 쓰레기 배출 방법을 미리 전달해주세요. 출입 방법을 미리 전달해주지 않아 출입이 제한될 시 서비스는 당일 취소 처리되며 서비스 정책에 따라 취소 수수료가 부과됩니다.',1);
insert into faq_part_tb(faq_id, title,content, code) values (4,'클리너에게 휴식 시간을 드려야하나요?','6시간 이상 서비스를 신청하신 경우 보다 원활한 서비스를 위해 30분의 휴식시간을 보장해주세요.',1);
insert into faq_part_tb(faq_id, title,content, code) values (4,'우리 사무실/사업장에 어떤 분이 방문하나요?','미소에서 신원 확인과 검증을 마친 클리너가 방문합니다. 고객 평가를 통해 검증된 클리너를 배정해드립니다.',1);
insert into faq_part_tb(faq_id, title,content, code) values (4,'사무실에 CCTV/홈카메라가 설치되어 있어요.','개인정보보호법 15조 2항에 따라 영상 촬영 시 고객님께서 클리너분께 CCTV 설치 여부를 알려드리고 동의를 받아야합니다.

예약 후 앱 내 부가정보를 입력하면 클리너가 사전에 확인할 수 있습니다.

앱 하단 [예약내역] 리스트 페이지 선택
부가정보를 입력할 [서비스] 선택
[기타 요청사항] 선택 후 CCTV 설치 유무 작성
* 앱에서 간편하게 입력해보세요.',1);
insert into faq_part_tb(faq_id, title,content, code) values (4,'시간을 연장하고 싶어요','서비스 중 시간 연장은 클리너와 사전 협의해야 하며, 클리너의 사정으로 연장이 불가할 수 있습니다. 필요할 경우 실시간 문의를 통해 알려주세요.
연장에 따른 추가금은 서비스 지역과 서비스 종류(정기/1회)에 따라 다르니 웹과 앱 내 [실시간 문의] 통해 미소로 문의해주세요.',2);
insert into faq_part_tb(faq_id, title,content, code) values (4,'클리너에게 식대를 제공해야하나요?','식사나 식대를 제공하지 않아도 됩니다. 다만 더 원활한 서비스를 위해 6시간 이상 서비스 시 최소 30분의 식사·휴식시간을 보장해주세요.',2);
insert into faq_part_tb(faq_id, title,content, code) values (5,'[간편예약]과[무료견젹]이 어떻게 다른가요?','[간편예약]

미소 선정 우수 파트너가 서비스 진행
A/S 100% 보장
피톤치드 서비스 무료 제공(살균/탈취)
미소에 직접 결제


[무료견적]

최대 4개 업체와 직접 연락하고 협의
업체에 개별 결제',1);
insert into faq_part_tb(faq_id, title,content, code) values (5,'이사/입주청소 진행 과정이 궁금해요','1. 미소 앱에서 예약 접수
2. 예약 접수 24시간 내 미소 본사가 서비스 유선 안내
3. 예약금 결제 후 예약 확정
4. 서비스일 1~2일 전 방문할 청소팀이 출입 방법 확인 위해 고객님께 연락
5. 서비스 수행 및 후불 결제 (예약금 환불 후 총 서비스 금액 재결제)

*예약금 환불 불가(단, 예약금은 결제하였지만 청소팀 배정 불가한 경우 예약금 환불)
*인테리어, 이사, 가전 설치 등과 동시에 진행할 수 없으며 서비스 접수 당시 고지되지 않은 경우 청소팀의 현장 철수 사유가 될 수 있으며 위약금이 발생해요.',1);
insert into faq_part_tb(faq_id, title,content, code) values (5,'시간은 얼마나 걸리고 몇 명이 방문하시나요?','1~16평: 1명 이상 / 평균 3시간
17~29평: 2명 이상 / 평균 3~4시간
30평 이상: 3명 이상 /평균 4시간 이상


*청소 환경/인원에 따라 청소 시간은 달라질 수 있어요. 이사/입주청소는 시간제 서비스가 아니라 공간 1개에 대한 서비스를 제공함으로 청소 소요 시간을 보장하지 않아요.',1);
insert into faq_part_tb(faq_id, title,content, code) values (5,'청소 범위가 궁금해요','[서비스 범위]

모든 실내공간 바닥 물청소 (바닥 소재 특성상 물청소 불가한 경우 제외)
모든 실내공간 벽/천장 건식 청소
화장실/베란다/다용도실 타일 물청소
창문/창틀/샷시
문/문틀/바닥 걸레받이/천정몰딩
수납장 겉면/내부
가스렌지/후드
방충망 먼지떨이
배수구 내/외부
조명/스위치/각종 손잡이

*창문/샷시는 설치 상태 그대로 청소하는 것이 기본이에요.


[서비스 범위 외]

정리 정돈, 설거지, 빨래 등 일반 생활 청소(불가)
외창/샷시/창 탈거 청소, 이중창 바깥 면(불가)
방범창/현관문 바깥면(불가)
블라인드 청소, 3M 이상 높이의 구조물(옵션)
바닥 스팀 청소(옵션)
쓰레기/폐기물 처리(옵션)
가전제품 내부 청소(옵션)
붙박이장 2개 이상(옵션)
실외기실(옵션)
실외 모든 공간(옵션)


[짐이 있는 경우]

혼자서 옮길 수 있는 짐은 최대한 옮겨 가며 청소하지만 큰 가전/가구/작은 생활용품은 옮기지 않고 청소해요.
가전/가구 겉면 닦아 드려요.
수납장 내부 청소를 원하시면 수납장 내부 짐은 고객님께서 직접 비우고 청소 후 정리해 주셔야 해요.
설거지, 빨래, 정리 등 생활 청소는 해드리지 않아요.',1);
insert into faq_part_tb(faq_id, title,content, code) values (5,'냉장고,에어컨,세탁기와 같은 가전 청소도 가능한가요?','추가요금을 지불하시면 가능하며, 간단히 분리할 수 있는 구조물을 분리/청소하고 재조립하는 약식 청소에요.



냉장고: 개당 단문형 3만 원, 양문형 5만 원
세탁기: 개당 3만 원
에어컨: 개당 3만 원',1);
insert into faq_part_tb(faq_id, title,content, code) values (5,'이사/입주청소 전에 어떤 것을 준비해야 하나요?','1. 청소 공간

주문 접수 시 기재하신 정보와 청소 장소의 상태가 동일해야 하며, 다를 시 추가금이 발생할 수 있어요.
짐이 있는 상태에서 수납장 내부 청소를 원하시면 수납장 내부 짐은 고객님께서 직접 비우고 청소 후 정리해 주셔야 가능해요.


2. 주차 공간

주차비 발생 시 고객님이 부담해 주셔야 해요
건물까지 진입하는 환경이 열악한 경우 소정의 추가금이 발생할 수 있어요.


3. 청소 시간

이사/입주청소는 최소 3시간은 확보되어야 해요. 고객님의 사정에 의해 시간 제약이 발생하는 경우, 주어진 시간 동안 서비스를 제공해 드릴 수 있지만 청소 상태가 다소 미흡하더라도 A/S 제공은 불가해요.
인테리어, 이사, 가전/가구 설치 등과 동시에 진행할 수 없으며 사전에 고지되지 않은 경우 청소팀의 대기 혹은 현장 철수 사유가 될 수 있고 대기료/위약금이 발생할 수 있어요.',1);
insert into faq_part_tb(faq_id, title,content, code) values (5,'이사 후에도 이사/입주청소를 받을 수 있나요?','짐이 있는 상태에서도 가능해요. 하지만 공실 상태에서 하는 이사/입주청소보다 서비스 금액이 더 높아요.



혼자서 옮길 수 있는 짐은 최대한 옮겨 가며 청소하지만 큰 가전/가구/작은 생활용품은 옮기지 않고 청소해요.
수납장 내부 청소를 원하시면 수납장 내부 짐은 고객님께서 직접 빼고 청소 후 정리해 주셔야 해요.
설거지, 빨래, 정리 등 생활 청소는 해드리지 않아요.',1);
insert into faq_part_tb(faq_id, title,content, code) values (5,'추가금 항목이 궁금해요.','스티커/기름때/곰팡이 제거가 특별히 필요한 경우
해충 방역, 새집증후군
가전제품 내부 청소 (냉장고, 세탁기, 에어컨 등)
폐기물 처리 (가전/가구, 생활 쓰레기 배출 등)
층고가 3미터 이상인 경우
베란다 외창 청소
폴딩 도어
복층 / 베란다(3개 이상)/ 붙박이장(2개 세트 이상) / 평형대비 방 개수가 표준 범위를 벗어나는 경우(예약 접수 시 유선으로 안내드려요)
인테리어 이후 준공 청소가 이루어지지 않은 현장
접수한 정보와 실제 현장 정보가 다른 경우(평수, 베란다 개수, 짐 유무 등)',1);
insert into faq_part_tb(faq_id, title,content, code) values (5,'인테리어 및 도배 직후에 이사 청소를 할 수 있나요?','도배 시공 직후 벽지가 마르지 않거나, 바닥 걸레받이 실리콘이 마르지 않은 경우 서비스 제공에 제약이 있을 수 있어요. 인테리어/도배를 했다면 최소 1~2일 후 청소하는 것이 좋아요. 시간이 여의치 않다면 예약 접수 후 미소 상담원에게 문의해 주세요.

*이사/입주청소는 도배/인테리어와 함께 동시에 진행할 수 없어요.',1);
insert into faq_part_tb(faq_id, title,content, code) values (5,'A/S 기간이 궁금해요','청소 요청일 포함 3일간 A/S 접수하실 수 있어요. A/S 필요한 공간의 사진을 미소 고객센터  [문의하기]로 간단한 설명과 함께 전달 주시면 돼요.


*미소 앱 왼쪽 상단 [ 三 ] – [ 문의사항 ] – [문의하기]
*최초 서비스를 제공한 동일 청소팀이 A/S 해드려요.',1);
insert into faq_part_tb(faq_id, title,content, code) values (5,'예약 취소/변경에 따른 위약금이 있나요?','당일 예약, 당일 취소/변경: 없음 (단, 익일 서비스를 요청하였고 예약금을 결제한 경우 서비스 1일 전 취소/변경 규정에 따라 서비스 요금의 30% 위약금 발생)
청소일 이틀 전 취소/변경: 청소 요금의 20% 위약금 발생
하루 전 ~ 당일 취소/변경: 청소 요금의 30% 위약금 발생
청소 당일 이사 및 인테리어 등의 사유로 청소 시작이 지연될 경우 대기료 발생(30분 이상 대기 시 부터 발생하며, 청소 작업자 인당 1시간에 2만 원. 30분이상 1시간 이하 대기 시 1시간 대기로 간주)


*결제한 예약금은 환불 불가(단, 예약금은 결제하였지만 청소팀 배정 불가한 경우 예약금 환불) ',1);
insert into faq_part_tb(faq_id, title,content, code) values (5,'방문 전에 연락이 오나요?','서비스 요청일 1~2일 전에 방문할 청소팀이 유선 연락드리고 출입 방법을 확인해요. 청소 유의사항이 있다면 반드시 사전에 알려주세요. 주차 불가하다면 주차 방법 안내 부탁드려요.',1);
insert into faq_part_tb(faq_id, title,content, code) values (5,'부재중일 때도 서비스 가능한가요?','현장에 계시지 않아도 출입 방법만 알려주시면 서비스 제공해 드릴 수 있어요. 짐이 있는 경우 혹시 모를 분쟁 상황을 방지하기 위해 귀중품은 따로 챙겨주세요.',1);
insert into faq_part_tb(faq_id, title,content, code) values (5,'무료견적 절차가 어떻게 되나요 ?','고객님이 요청하신 서비스를 제공할 수 있는 최대 4개의 업체가 견적을 제공해 드려요. 직접 비교/소통해 보시고 마음에 드는 파트너를 선택하고 서비스 받으시면 돼요.



무료 견적 요청
24시간 이내 최대 4개의 견적 수령
파트너 프로필 조회 & 소통
파트너 선택
서비스 진행',1);
insert into faq_part_tb(faq_id, title,content, code) values (5,'이사청소 파트너 선택은 어떻게 하나요?','[파트너 선택하기]를 눌러 견적을 제출한 이사청소 파트너 중 마음에 드는 이사청소 파트너를 선택하세요.',1);
insert into faq_part_tb(faq_id, title,content, code) values (5,'예약 내역을 확인하고 싶어요.','미소 앱에서 예약 내용을 확인 할 수 있어요.

미소 앱이 없으신 경우 카카오톡으로 발송된 링크에서 예약 내용을 확인 할 수 있어요.',1);
insert into faq_part_tb(faq_id, title,content, code) values (5,'견적요청을 변경, 취소하고 싶어요','아직 견적을 받지 않으셨다면 앱 내에서 [예약 취소] 버튼을 눌러 취소하실 수 있어요.

견적을 받으신 후, 견적요청 변경 및 취소는 실시간 문의 부탁드려요.',1);
insert into faq_part_tb(faq_id, title,content, code) values (5,'분쟁 상황 발생시 어떻게 하나요?','[무료견적]을 통해 서비스를 이용하신 경우 고객님과 파트너님 사이에 발생한 문제에 대해 미소는 직접적으로 개입할 수 없는 점 양해부탁드립니다.',1);
insert into faq_part_tb(faq_id, title,content, code) values (5,'결제는 언제/어떻게 하나요?','서비스 진행하기로 한 파트너와 직접 결제 진행하시면 돼요.',1);

insert into faq_part_tb(faq_id, title,content, code) values (5,'결제는 언제/어떻게 하나요?','미소 앱에서 예약 접수
예약 접수 24시간 내 미소 본사가 서비스 유선 안내
예약금 결제 후 예약 확정
서비스일 1~2일 전 방문할 청소팀이 출입 방법 확인 위해 고객님께 연락
서비스 수행 및 후불 결제 (예약금 환불 후 총 서비스 금액 재결제)

*결제한 예약금은 환불 불가(단, 예약금은 결제하였지만 청소팀 배정 불가한 경우만 예약금 환불)',2);
insert into faq_part_tb(faq_id, title,content, code) values (5,'카드 등록은 어떻게 하나요?','앱에서 신용카드 또는 카카오페이를 등록해 주세요. 카드 결제가 어렵다면 미소앱 [실시간문의]를 통해 미소로 문의 부탁 드려요.



앱
내정보
결제 수단 관리
[카드 추가하기] 또는 [카카오페이 추가하기]


* 체크카드 또는 타인 명의 카드도 등록 가능해요.',2);
insert into faq_part_tb(faq_id, title,content, code) values (5,'영수증 발급이 필요해요.','미소는 서비스 중개 업체로 서비스 수수료 금액만 현금 영수증 처리되며 서비스 전액 증빙을 원하시면 카드 결제 후 나이스 페이먼츠에서 사용하신 신용카드 영수증을 확인할 수 있어요.



– 계좌이체 현금영수증(수수료) 처리는 고객센터 1577-8808 혹은 앱 내 [실시간 문의하기]로 요청해주세요.

– 잔금을 파트너에게 직접 결제 및 계좌이체한 경우 해당 업체에 문의해 주세요.',2);



insert into sale_tb(user_id, price, created_at) values (1, 25000, now());
insert into sale_tb(user_id, price, created_at) values (1, 37000, now());
insert into sale_tb(user_id, price, created_at) values (1, 17000, now());
insert into sale_tb(user_id, price, created_at) values (1, 17000, now());
insert into sale_tb(user_id, price, created_at) values (2, 17000, now());
insert into sale_tb(user_id, price, created_at) values (3, 17000, now());
insert into sale_tb(user_id, price, created_at) values (4, 17000, now());

insert into reservation_tb(address_info_id, info_id, sale_id, status, created_at) values (1, 1, 1, 2, now());
insert into reservation_tb(address_info_id, info_id, sale_id, status, created_at) values (4, 2, 2, 2, now());
insert into reservation_tb(address_info_id, info_id, sale_id, status, created_at) values (3, 3, 3, 3, now());
insert into reservation_tb(address_info_id, info_id, sale_id, status, created_at) values (2, 4, 4, 3, now());
insert into reservation_tb(address_info_id, info_id, sale_id, status, created_at) values (5, 5, 5, 2, now());
insert into reservation_tb(address_info_id, info_id, sale_id, status, created_at) values (6, 6, 6, 2, now());
insert into reservation_tb(address_info_id, info_id, sale_id, status, created_at) values (7, 7, 7, 2, now());



insert into notice_tb(title, content, created_at) values ('공지1', '공지1 내용', now());

insert into notice_tb(title, content, created_at) values ('공지2', '공지2 내용', now());
insert into notice_tb(title, content, created_at) values ('공지3', '공지3 내용', now());



insert into cancel_tb(sale_id, created_at, price) values (1, now(), 25000);
insert into cancel_tb(sale_id, created_at, price) values (2, now(), 37000);
insert into cancel_tb(sale_id, created_at, price) values (3, now(), 17000);
