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
                                                            <button class="btn-danger btn"
                                                                    onclick="location.href='/mng/user/${userPG.id}/user-delete'">
                                                                삭제
                                                            </button>
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