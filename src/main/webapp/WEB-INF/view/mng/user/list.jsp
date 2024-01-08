<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/view/mng/layout/mngHeader.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
            <div class="col-6">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">유저 조회</h4>
                    </div>
                    <div class="table-responsive">
                        <table class="table">
                            <thead class="table-light">
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">전화번호</th>
                                <th scope="col">생성날짜</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:choose>
                            <c:when test="${not empty userPG }">
                                <c:forEach var="userPG" items="${userPG}">

                                    <tr>
                                        <th scope="row" class="applyDetail"><a href="/mng/user/user/${userPG.id}/detail">${userPG.id}</a></th>
                                        <td class="applyDetail"><a href="/mng/user/user/${userPG.id}/detail">${userPG.tel }</a></td>
                                        <td class="applyDetail"><a href="/mng/user/user/${userPG.id}/detail"><fmt:formatDate value="${userPG.createdAt}"
                                                                        pattern="yyyy. MM. dd"/></a></td>
                                    </tr>
                                    </a>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                            <p>아직 생성된 계정이 없습니다.
                                </c:otherwise>
                                </c:choose>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="col-6">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">파트너 조회</h4>
                    </div>
                    <div class="table-responsive">
                        <table class="table">
                            <thead class="table-light">
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">전화번호</th>
                                <th scope="col">생성날짜</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:choose>
                            <c:when test="${not empty partnerPG}">
                                <c:forEach var="partnerPG" items="${partnerPG}">

                                    <tr>
                                        <th scope="row" class="applyDetail"><a href="/mng/user/partner/${partnerPG.id}/detail">${partnerPG.id}</a></th>
                                        <td class="applyDetail"><a href="/mng/user/partner/${partnerPG.id}/detail">${partnerPG.tel }</a></td>
                                        <td class="applyDetail"><a href="/mng/user/partner/${partnerPG.id}/detail"><fmt:formatDate value="${partnerPG.createdAt}"
                                                                        pattern="yyyy. MM. dd"/></a></td>
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
<%--	<script>--%>
<%--		async function searching() {--%>
<%--			// 1. DOM으로 부터 값 가져오기--%>
<%--			let keyword = document.querySelector("#keyword").value;--%>
<%--			console.log("키워드", keyword);--%>
<%--			// 2. 통신하기--%>
<%--			let response = await fetch(`/user/list?keyword=${keyword}`, {--%>
<%--				method: "get",--%>
<%--				headers: {--%>
<%--					"Content-Type": "application/json"--%>
<%--				},--%>
<%--			});--%>
<%--			console.log(response);--%>
<%--			// 3. 파싱하기--%>
<%--			let responseBody = await response.json(); // response.json();--%>
<%--			console.log(responseBody);--%>
<%--			// 4. 상태코드 확인--%>
<%--			// let btnJoin = document.querySelector("#btnJoin");--%>
<%--			// if (responseBody.sucuess) {--%>
<%--			//     console.log(responseBody);--%>
<%--			// usernameSameCheck = true;--%>
<%--			// btnJoin.removeAttribute("disabled");--%>

<%--			// } else {--%>
<%--			//     alert(responseBody.data);--%>
<%--			// usernameSameCheck = false;--%>
<%--			// btnJoin.setAttribute("disabled", "disabled");--%>
<%--			// }--%>
<%--		}--%>
<%--	</script>--%>
<%@ include file="/WEB-INF/view/mng/layout/mngFooter.jsp" %>