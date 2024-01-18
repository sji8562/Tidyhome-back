<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/view/mng/layout/mngHeader.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>
    /* 모달 스타일 */
    .modal {
        display: none;
        position: fixed;
        z-index: 1;
        left: 0;
        top: 0;
        width: 100%;
        height: 100%;
        overflow: auto;
        background-color: rgba(0,0,0,0.4);
    }

    .modal-content {
        background-color: #fefefe;
        margin: 15% auto;
        padding: 50px;
        border: 1px solid #888;
        width: 1000px;
        position: relative;
    }

    .close {
        color: #aaa;
        position: absolute;
        top: 0;
        right: 0;
        font-size: 28px;
        font-weight: bold;
        margin: 10px;
    }

    .close:hover,
    .close:focus {
        color: black;
        text-decoration: none;
        cursor: pointer;
    }
</style>
<!-- ============================================================== -->
<!-- End Left Sidebar - style you can find in sidebar.scss -->
<!-- ============================================================== -->
<!-- ============================================================== -->
<!-- Page wrapper -->
<!-- ============================================================== -->
<div class="page-wrapper">
    <!-- ============================================================== -->
    <!-- Bread crumb and right sidebar toggle -->
    <!-- ============================================================== -->
    <div class="page-breadcrumb">
        <div class="row">
            <div class="col-5 align-self-center">
                <h4 class="page-title">유저 관리</h4>
            </div>
            <div class="col-7 align-self-center">
                <div class="d-flex align-items-center justify-content-end">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="#">Home</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Basic
                                Table
                            </li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>
    <!-- ============================================================== -->
    <!-- End Bread crumb and right sidebar toggle -->
    <!-- ============================================================== -->
    <!-- ============================================================== -->
    <!-- Container fluid  -->
    <!-- ============================================================== -->
    <div class="container-fluid">
        <!-- ============================================================== -->
        <!-- Start Page Content -->
        <!-- ============================================================== -->
        <div class="row">
            <div class="col-12">
                <div class="card">
                    <div class="card-body">
                        <div class="col-12">
                            <div class="card">
                                <div class="card-body m--search-inline">
                                    <h4 class="card-title">유저 조회</h4>
                                    <form class="row g-3">
                                        <div class="col-auto">
                                            <input type="text" class="form-control" id="keyword"
                                                   placeholder="이메일을 입력해주세요">
                                        </div>
                                        <div class="col-auto">
                                            <button type="submit" class="btn btn-primary mb-3">검색</button>
                                        </div>
                                    </form>
                                </div>
                                <div class="table-responsive">
                                    <table class="table">
                                        <thead class="table-light">
                                        <tr>
                                            <th scope="col">#</th>
                                            <th scope="col">전화번호</th>
                                            <th scope="col">생성날짜</th>
                                            <th scope="col">회원관리</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:choose>
                                        <c:when test="${not empty userPG.content }">

                                            <c:forEach var="userPG" items="${userPG.content}">
                                                <tr>
                                                    <th class="applyDetail" scope="row">${userPG.id}</th>
                                                    <td class="applyDetail">${userPG.tel }</td>
                                                    <td class="applyDetail"><fmt:formatDate value="${userPG.createdAt}"
                                                                                    pattern="yyyy. MM. dd"/></td>
                                                    <td>
                                                        <div>
                                                            <!-- 주소 관리 버튼 -->
                                                            <button class="btn btn-success" onclick="openModal(${userPG.id})">주소관리</button>

                                                            <!-- 모달 -->
                                                            <div id="myModal" class="modal">
                                                                <!-- 모달 내용 -->
                                                                <div class="modal-content">
                                                                    <span class="close" id="closeModalBtn">&times;</span>
                                                                    <table class="table">
                                                                        <thead>
                                                                        <tr>
                                                                            <th>주소</th>
                                                                            <th>관리</th>
                                                                        </tr>
                                                                        </thead>
                                                                        <tbody id="myModalContent">
                                                                        <!-- 주소 목록이 여기에 동적으로 추가될 것입니다 -->
                                                                        </tbody>
                                                                    </table>
                                                                </div>
                                                            </div>

                                                            <script>
                                                                // 모달 열기
                                                                function openModal(userId) {
                                                                    // 서버에 사용자의 주소 목록 요청
                                                                    fetch(`/mng/user/${userId}/address-list`)
                                                                        .then(response => response.json())
                                                                        .then(addressList => {
                                                                            // 주소 목록을 모달에 표시
                                                                            const modalContent = document.getElementById('myModalContent');
                                                                            modalContent.innerHTML = ''; // 모달 내용 초기화

                                                                            addressList.forEach(address => {
                                                                                const row = document.createElement('tr');
                                                                                const addressCell = document.createElement('td');
                                                                                addressCell.textContent = address.address;

                                                                                const deleteCell = document.createElement('td');
                                                                                const deleteButton = document.createElement('button');
                                                                                deleteButton.textContent = '삭제';
                                                                                deleteButton.className = 'btn-danger btn';
                                                                                deleteButton.onclick = function() {
                                                                                    // 삭제 동작을 수행하는 함수 호출
                                                                                    deleteAddress(address.id);
                                                                                };

                                                                                deleteCell.appendChild(deleteButton);

                                                                                row.appendChild(addressCell);
                                                                                row.appendChild(deleteCell);

                                                                                modalContent.appendChild(row);
                                                                            });

                                                                            // 모달 열기
                                                                            document.getElementById('myModal').style.display = 'block';
                                                                        })
                                                                        .catch(error => console.error('주소 목록을 불러오는 중 오류 발생:', error));
                                                                }

                                                                // 모달 닫기
                                                                document.getElementById('closeModalBtn').onclick = function() {
                                                                    document.getElementById('myModal').style.display = 'none';
                                                                };

                                                                // 모달 외부 클릭 시 닫기
                                                                window.onclick = function(event) {
                                                                    var modal = document.getElementById('myModal');
                                                                    if (event.target == modal) {
                                                                        modal.style.display = 'none';
                                                                    }
                                                                };

                                                                // 주소 삭제
                                                                function deleteAddress(addressId) {
                                                                    // 서버에 주소 삭제 요청
                                                                    fetch(`/mng/user/delete-address/${addressId}`, {
                                                                        method: 'DELETE'
                                                                    })
                                                                        .then(response => {
                                                                            if (response.ok) {
                                                                                // 삭제 성공 시 모달 갱신
                                                                                openModal(/* 사용자 ID */);
                                                                            } else {
                                                                                console.error('주소 삭제 실패:', response.statusText);
                                                                            }
                                                                        })
                                                                        .catch(error => console.error('주소 삭제 중 오류 발생:', error));
                                                                }
                                                            </script>

                                                            <!-- 삭제 버튼 -->
                                                            <button class="btn-danger btn" onclick="location.href='/mng/user/${userPG.id}/user-delete'">삭제</button>
                                                        </div>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </c:when>
                                        <c:otherwise>
                                        <p>아직 생성된 계정이 없습니다.
                                            </c:otherwise>
                                            </c:choose>
                                        </tbody>
                                    </table>
                                </div>
                                <div style="display: block; text-align: center;">
                                    <c:if test="${not empty keyword}">

                                        <ul class="pagination d-flex justify-content-center">
                                            <li class="page-item
											<c:if test="${userPG.first}">disabled</c:if>"><a class="page-link"
                                                                                             href="?keyword=${keyword}&page=${prevPage}">Previous</a>
                                            </li>

                                            <li class="page-item
											<c:if test="${userPG.last}">disabled</c:if>"><a class="page-link"
                                                                                            href="?keyword=${keyword}&page=${nextPage}">Next</a>
                                            </li>
                                        </ul>
                                    </c:if>
                                    <c:if test="${empty keyword}">
                                        <ul class="pagination d-flex justify-content-center">
                                            <li class="page-item <c:if test="${userPG.first}">disabled</c:if>"><a
                                                    class="page-link"
                                                    href="?page=${prevPage}">Previous</a>
                                            </li>
                                            <li class="page-item <c:if test="${userPG.last}">disabled</c:if>"><a
                                                    class="page-link"
                                                    href="?page=${nextPage}">Next</a></li>
                                        </ul>
                                    </c:if>
                                </div>

                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
        <!-- ============================================================== -->
        <!-- End PAge Content -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- Right sidebar -->
        <!-- ============================================================== -->
        <!-- .right-sidebar -->
        <!-- ============================================================== -->
        <!-- End Right sidebar -->
        <!-- ============================================================== -->
    </div>
<%@ include file="/WEB-INF/view/mng/layout/mngFooter.jsp" %>