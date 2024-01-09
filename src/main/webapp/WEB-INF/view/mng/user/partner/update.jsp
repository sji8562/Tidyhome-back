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
<div class="page-wrapper">
    <!-- ============================================================== -->
    <!-- Bread crumb and right sidebar toggle -->
    <!-- ============================================================== -->
    <div class="page-breadcrumb">
        <div class="row">
            <div class="col-5 align-self-center">
                <h4 class="page-title">파트너 정보</h4>
            </div>
            <div class="col-7 align-self-center">
                <div class="d-flex align-items-center justify-content-end">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="#">Home</a></li>
                            <li class="breadcrumb-item active" aria-current="page">회원정보</li>
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
        <!-- Row -->
        <div class="row">

            <div class="col-lg-8 col-xlg-9">
                <div class="card">
                    <div class="card-body">
                        <c:choose>
                            <c:when test="${partner != null }">
                                <form class="form-horizontal form-material mx-2" method="post"
                                      action="/mng/user/${partner.id}/update">

                                    <div class="form-group">
                                        <label for="example-email" class="col-md-12">이름</label>
                                        <div class="col-md-12">
                                            <input type="text" value="${partner.username}"
                                                   class="form-control form-control-line" name="username"
                                                   id="userName" id="example-email">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-12">전화번호</label>
                                        <div class="col-md-12">
                                            <input type="text" value="${partner.tel}"
                                                   name="phoneNumber" id="phoneNumber"
                                                   class="form-control form-control-line">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-12">사진</label>
                                        <div class="col-md-12">
                                                <%--							<img src="${partner.picUrl()}" >--%>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-12">성별</label>
                                        <div class="col-md-12">
                                            <input type="text" value="${partner.gender}"
                                                   name="phoneNumber" id="gender"
                                                   class="form-control form-control-line" >
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-12">분야</label>
                                        <div class="col-md-12">
                                            <input type="text" value="${partner.categoryId}"
                                                   name="phoneNumber" id="categoryId"
                                                   class="form-control form-control-line" >
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-12">
                                            <button type="submit" class="btn btn-success text-white">수정</button>
                                            <button class="btn btn-danger text-white">삭제</button>
                                        </div>
                                    </div>
                                </form>
                            </c:when>
                            <c:otherwise>
                                <h1>잘못된 아이디 값입니다.</h1>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </div>
            <!-- Column -->
        </div>
        <!-- Row -->
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
    <!-- ============================================================== -->
    <!-- End Container fluid  -->
    <!-- ============================================================== -->
    <!-- ============================================================== -->
    <!-- footer -->
    <!-- ============================================================== -->
<%@ include file="/WEB-INF/view/mng/layout/mngFooter.jsp" %>