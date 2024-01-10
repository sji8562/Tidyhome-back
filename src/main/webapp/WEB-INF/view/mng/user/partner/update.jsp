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
                                      action="/mng/user/${partner.id}/partner-update">
                                    <input type="hidden" name="id" value="${partner.id}" id="id">
                                    <div class="form-group">
                                        <label class="col-md-12">이름</label>
                                        <div class="col-md-12">
                                            <input type="text" value="${partner.username}"
                                                   class="form-control form-control-line" name="username"
                                                   id="userName">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-12">사업자번호</label>
                                        <div class="col-md-12">
                                            <input type="text" value="111-1111-111111-1111-1"
                                                   class="form-control form-control-line" name="businessNumber"
                                                   id="businessNumber">
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
                                        <label for="file">썸네일</label>
                                        <div style="width: 500px;">
                                            <input type="file" id="file" name="file">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-md-12">성별</label>
                                        <div class="col-md-12">
                                            <select class="form-select" aria-label="Disabled select example" id="gender"
                                                    name="gender">
                                                <option value="f" ${partner.gender == 'f' ? 'selected' : ''}>여자</option>
                                                <option value="m" ${partner.gender == 'm' ? 'selected' : ''}>남자</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-12">분야</label>
                                        <div class="col-md-12 cate-div">
                                            <c:choose>
                                                <c:when test="${firstCategoryList != null}">
                                                    <c:forEach var="firstCategoryList" items="${firstCategoryList}">
                                                        <button onclick="cateButtonClick(this)"
                                                                id="cate${firstCategoryList.id}"
                                                                name="cate${firstCategoryList.id}" type="button"
                                                                class="btn"
                                                                value="${firstCategoryList.id}">${firstCategoryList.name}</button>
                                                    </c:forEach>
                                                </c:when>
                                            </c:choose>
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="form-group">
                                        <label class="col-md-12">선택됨</label>
                                        <div class="col-md-12 selected-div">
                                            <c:choose>
                                                <c:when test="${firstCategoryList != null}">
                                                    <c:forEach var="firstCategoryList" items="${firstCategoryList}">
                                                        <button onclick="selectedButtonClick(this)"
                                                                id="selectedCate${firstCategoryList.id}"
                                                                name="cate${firstCategoryList.id}" type="button"
                                                                class="btn hide"
                                                                value="${firstCategoryList.id}">${firstCategoryList.name}</button>
                                                    </c:forEach>
                                                </c:when>
                                            </c:choose>
                                        </div>
                                    </div>
                                    <input type="text" id="category" name="category" hidden="hidden">
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
<!-- End Container fluid -->
<!-- ============================================================== -->
<!-- ============================================================== -->
<!-- footer -->
<!-- ============================================================== -->
<script>

    function cateButtonClick(button) {
        // 버튼을 숨깁니다.
        button.style.display = 'none';

        // 아래에 있는 동일한 ID를 가진 버튼을 찾아 표시합니다.
        var categoryId = button.id.replace(/\D/g, '');
        var categoryInput = document.getElementById("category");
        var selectedButton = document.getElementById('selectedCate' + categoryId);

        selectedButton.style.display = 'inline';
        if (categoryInput.value === null || categoryInput.value === "") {
            categoryInput.value = categoryId;
        } else {
            categoryInput.value += categoryId;
        }
    }

    function selectedButtonClick(button) {
        // 선택된 버튼을 숨깁니다.
        button.style.display = 'none';

        // 아래에 있는 동일한 ID를 가진 버튼을 찾아 표시합니다.
        var categoryId = button.id.replace(/\D/g, '');
        var cateButton = document.getElementById('cate' + categoryId);
        var categoryInput = document.getElementById("category");
        cateButton.style.display = 'inline';
        categoryInput.value = categoryInput.value.replace(categoryId, '');
    }

</script>

<%@ include file="/WEB-INF/view/mng/layout/mngFooter.jsp" %>