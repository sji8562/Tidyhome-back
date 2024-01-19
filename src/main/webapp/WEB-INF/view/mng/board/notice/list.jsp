<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/view/mng/layout/mngHeader.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
                <h4 class="page-title">공지사항 관리

                </h4>
            </div>

            <div class="col-7 align-self-center">
                <div class="d-flex align-items-center justify-content-end">
                    <button class="btn btn-primary btn-sm ml-2"
                            onclick="location.href='/mng/notice/save'">
                        등록하기
                    </button>
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
                                <div class="card-body">
                                    <h4 class="card-title">공지사항 조회</h4>
                                    <h6 class="card-subtitle"></h6>
                                </div>
                                <div class="table-responsive">
                                    <table class="table">
                                        <thead class="table-light">
                                        <tr>
                                            <th scope="col">#</th>
                                            <th scope="col">제목</th>

                                            <th scope="col">작성자</th>
                                            <th scope="col">생성날짜</th>
                                            <th scope="col">공지사항 관리</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:choose>
                                        <c:when test="${noticeList != null }">

                                            <c:forEach var="noticeList" items="${noticeList.content}">
                                                <tr>
                                                    <th class="applyDetail" scope="row"><a
                                                            href="/mng/notice/${noticeList.id}/detail">${noticeList.id}</a>
                                                    </th>
                                                    <td class="applyDetail"><a
                                                            href="/mng/notice/${noticeList.id}/detail">${noticeList.title}</a>
                                                    </td>

                                                    <td class="applyDetail"><a
                                                            href="/mng/notice/${noticeList.id}/detail">관리자</a>
                                                    </td>
                                                    <td class="applyDetail"><a
                                                            href="/mng/notice/${noticeList.id}/detail"><fmt:formatDate value="${noticeList.createdAt }" pattern="yyyy. MM. dd" /></a>
                                                    </td>

                                                    <td>
                                                        <div>
                                                            <button class="btn btn-success"
                                                                    onclick="location.href='/mng/notice/${noticeList.id}/update'">
                                                                수정
                                                            </button>
                                                            &nbsp;&nbsp;
                                                            <button class="btn-danger btn"
                                                                    onclick="location.href='/mng/notice/${noticeList.id}/delete'">
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
                                    <ul class="pagination d-flex justify-content-center">
                                        <li class="page-item <c:if test="${noticeList.first}">disabled</c:if>"><a class="page-link"
                                                                                                                 href="?page=${prevPage}">Previous</a>
                                        </li>
                                        <li class="page-item <c:if test="${noticeList.last}">disabled</c:if>"><a class="page-link"
                                                                                                                href="?page=${nextPage}">Next</a></li>
                                    </ul>
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