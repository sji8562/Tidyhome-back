<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/view/mng/layout/mngHeader.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- ============================================================== -->
<!-- End Left Sidebar - style you can find in sidebar.scss -->
<!-- ============================================================== -->
<!-- ============================================================== -->
<!-- Page wrapper -->
<!-- ============================================================== -->
<style>
    /*.ellipsis {*/
    /*    overflow: hidden;*/
    /*    text-overflow: ellipsis;*/
    /*    display: -webkit-box;*/
    /*    -webkit-line-clamp: 1;*/
    /*    -webkit-box-orient: vertical;*/
    /*}*/
</style>

<div class="page-wrapper">
    <!-- ============================================================== -->
    <!-- Bread crumb and right sidebar toggle -->
    <!-- ============================================================== -->
    <div class="page-breadcrumb">
        <div class="row">
            <div class="col-5 align-self-center">
                <h4 class="page-title">자주 묻는 질문</h4>
            </div>
            <div class="col-7 align-self-center">
                <div class="d-flex align-items-center justify-content-end">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <a href="/mng/board/faq-submit"><button class="btn btn-primary">등록하기</button></a>
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
                                <form class="row g-3" action="/mng/board/faq-list" method="get">
                                    <div class="card-body m--search-inline">
                                        <h4 class="card-title">자주 묻는 질문 조회</h4>
                                            <div class="m--search-inline">
                                                <div class="col-auto">
                                                    <input type="text" class="form-control" id="keyword" name="keyword" placeholder="제목을 입력해주세요" value="${keyword}">
                                                </div>
                                                <div class="col-auto">
                                                    <button type="submit" class="btn btn-primary mb-3">검색</button>
                                                </div>
                                            </div>
                                    </div>
                                    <c:choose>
                                        <c:when test="${faqListDTOList != null }">
                                                <div class="table-responsive">
                                                        <table class="table" style="width: 100%;">
                                                            <thead class="table-light">
                                                            <tr>
                                                                <th scope="col">#</th>
                                                                <th scope="col">name</th>
                                                                <th scope="col">제목</th>
                                                                <th scope="col">유형</th>
                                                                <th scope="col">공지사항 관리</th>
                                                            </tr>
                                                            </thead>
                                                            <tbody>
                                                                <c:forEach var="faqListDTOList" items="${faqListDTOList}">
                                                                    <tr>
                                                                        <th class="applyDetail" scope="row">
                                                                            <a href="/mng/board/${faqListDTOList.id}/notice-detail">${faqListDTOList.id}</a>
                                                                        </th>
                                                                        <%--<td class="ellipsis" style="width: 60%; white-space: nowrap; overflow:hidden; text-overflow:ellipsis;">${noticeList.title}</td>--%>
                                                                        <td class="ellipsis">${faqListDTOList.title}</td>
                                                                        <%--<td>${noticeList.content}</td>--%>
                                                                        <td>관리자</td>
                                                                        <td>
                                                                            <c:if test="${faqListDTOList.code == 1}">
                                                                                서비스 이용
                                                                            </c:if>
                                                                            <c:if test="${faqListDTOList.code == 2}">
                                                                                서비스 요금
                                                                            </c:if>

                                                                        </td>
                                                                        <td>
                                                                            <div>
                                                                                <button class="btn btn-success"
                                                                                        style="border: 1px solid black"
                                                                                        type="button"
                                                                                        onclick="location.href='/mng/board/${faqListDTOList.id}/faq-update'">
                                                                                    수정
                                                                                </button>
                                                                                &nbsp;&nbsp;
                                                                                <button class="btn-danger btn"
                                                                                        type="button"
                                                                                        onclick="location.href='/mng/board/${faqListDTOList.id}/faq-delete'">
                                                                                    삭제
                                                                                </button>
                                                                            </div>
                                                                        </td>
                                                                    </tr>
                                                                </c:forEach>
                                                            </tbody>
                                                        </table>
                                                </div>

                                        </c:when>
                                        <c:otherwise>
                                            <p>등록된 게시글이 없습니다</p>
                                        </c:otherwise>
                                        </c:choose>
                                </form>
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