<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/view/mng/layout/mngHeader.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
    google.charts.load('current', {'packages':['corechart']});
    google.charts.setOnLoadCallback(drawChart);

    function drawChart() {

        var data = google.visualization.arrayToDataTable([
            ['Reason', 'Count'],
            ${result}
        ]);

        var options = {
            title: '월별 건수'
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);
    }
</script>
<div class="page-wrapper">
    <!-- ============================================================== -->
    <!-- Bread crumb and right sidebar toggle -->
    <!-- ============================================================== -->
    <div class="page-breadcrumb">
        <div class="row">
            <div class="col-5 align-self-center">
                <h4 class="page-title">Dashboard</h4>
            </div>
            <div class="col-7 align-self-center">
                <div class="d-flex align-items-center justify-content-end">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item">
                                <a href="#">Home</a>
                            </li>
                            <li class="breadcrumb-item active" aria-current="page">Dashboard</li>
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
        <!-- Email campaign chart -->
        <!-- ============================================================== -->
        <div class="row">
            <div class="col-lg-8">
                <div class="card" >
                    <div class="card-body">
                        <h4 class="card-title">월별 실적</h4>
                        <h3 class="font-light" style="padding-bottom: 5px;">총 ${payOff} 원</h3>
                        <div class=""></div>
                        <div class="sales ct-charts mt-3"></div>
                        <input type="hidden" id="dtos" value="${dtos}">
                    </div>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="card" >
                    <div class="card-body" >
                        <h5 class="card-title mb-1">월별 건수</h5>
                        <h3 class="font-light" style="padding-top: 10px;">총 ${count} 건</h3>
                        <div class="mt-3 text-center">
                            <div id="earnings">
                                <div class="mt-5">
                                    <div class="row text-center">
<%--                                        <div class="col-5">--%>
<%--                                            <h4 class="mb-0">${countList.get(0)} 건</h4>--%>
<%--                                            <span class="font-14 text-muted">가사도우미</span>--%>
<%--                                        </div>--%>
<%--                                        <div class="col-5" style="padding-bottom: 65px">--%>
<%--                                            <h4 class="mb-0">${countList.get(1)} 건</h4>--%>
<%--                                            <span class="font-14 text-muted">사무실청소</span>--%>
<%--                                        </div>--%>
<%--                                        <div class="col-5" style="padding-bottom: 45px">--%>
<%--                                            <h4 class="mb-0">${countList.get(2)} 건</h4>--%>
<%--                                            <span class="font-14 text-muted">이사청소</span>--%>
<%--                                        </div>--%>
                                        <div id="piechart" style="width: 450px; height: 250px;"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- ============================================================== -->
        <!-- Email campaign chart -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- Ravenue - page-view-bounce rate -->
        <!-- ============================================================== -->
        <div class="row">
            <!-- column -->
            <div class="col-12">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">결제내역</h4>
                    </div>
                    <div class="table-responsive">
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th class="border-top-0">NAME</th>
                                <th class="border-top-0">STATUS</th>
                                <th class="border-top-0">DATE</th>
                                <th class="border-top-0">PRICE</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:choose>
                                <c:when test="${payList != null }">
                                    <c:forEach var="pay" items="${payList}">
                                        <tr>
                                            <td class="txt-oflo">${pay.sale.user.tel}</td>
                                                <td><span class="label label-success label-rounded">${pay.status}</span></td>
                                                <td class="txt-oflo"><fmt:formatDate value="${pay.sale.createdAt}" pattern="yyyy. MM. dd"/></td>
                                                <td><span class="font-medium"><fmt:formatNumber value="${pay.sale.price}" pattern="###,###"/></span></td>
                                        </tr>

                                    </c:forEach>

                                </c:when>
                                <c:otherwise>
                                    내역이 없습니다.
                                </c:otherwise>
                            </c:choose>

                            </tbody>
                        </table>
                        <div style="display: block; text-align: center; padding-bottom: 20px">
                            <c:if test="${paging.startPage != paging.nowPage }">
                                <a href="index?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}&keyword=${keyword}">&lt;</a>
                            </c:if>
                            <c:forEach begin="${paging.startPage }"
                                       end="${paging.endPage }" var="p">
                                <c:choose>
                                    <c:when test="${p == paging.nowPage }">
                                        <b>${p }</b>
                                    </c:when>
                                    <c:when test="${p != paging.nowPage }">
                                        <a href="index?nowPage=${p }&cntPerPage=${paging.cntPerPage}&keyword=${keyword}" style="color: black; font-weight: bold">${p + 1}</a>
                                    </c:when>
                                </c:choose>
                            </c:forEach>
                            <c:if test="${paging.endPage != paging.lastPage}">
                                <a
                                        href="index?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}&keyword=${keyword}">&gt;</a>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- ============================================================== -->
        <!-- Ravenue - page-view-bounce rate -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- Recent comment and chats -->
        <!-- ============================================================== -->


        </div>
        <!-- ============================================================== -->
        <!-- Recent comment and chats -->
        <!-- ============================================================== -->
    </div>
    <!-- ============================================================== -->
    <!-- End Container fluid  -->
    <!-- ============================================================== -->
    <!-- ============================================================== -->
    <!-- footer -->
    <!-- ============================================================== -->
<%@ include file="/WEB-INF/view/mng/layout/mngFooter.jsp" %>