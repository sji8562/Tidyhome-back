<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/mng/layout/mngHeader.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- ============================================================== -->
<!-- End Left Sidebar - style you can find in sidebar.scss  -->
<!-- ============================================================== -->
<!-- ============================================================== -->
<!-- Page wrapper  -->
<!-- ============================================================== -->
<div class="page-wrapper">
    <!-- ============================================================== -->
    <!-- Bread crumb and right sidebar toggle -->
    <!-- ============================================================== -->
    <div class="page-breadcrumb">
        <div class="row">
            <div class="col-5 align-self-center">
                <h4 class="page-title">결제 관리</h4>
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
                                    <h4 class="card-title">결제 내역 조회</h4>
                                </div>
                                <div style="padding-bottom: 20px">
                                    <select id="categoryDropdown">
                                        <option value="">전체</option>
                                        <option value="가사도우미">가사도우미</option>
                                        <option value="사무실청소">사무실청소</option>
                                        <option value="이사청소">이사청소</option>
                                        <option value="가전/침대청소">가전/침대청소</option>
                                        <!-- 여러 카테고리 옵션 추가 -->
                                    </select>
                                </div>
                                <div class="table-responsive">
                                    <c:choose>
                                        <c:when test="${payList != null}">
                                            <table class="table">
                                                <thead class="table-light">
                                                    <tr>
                                                        <th scope="col" style="width: 80px;">번호</th>
                                                        <th scope="col">구분</th>
                                                        <th scope="col">사용자</th>
                                                        <%--<th scope="col">제품번호</th>--%>
                                                        <%--<th scope="col">제품이름</th>--%>
                                                        <th scope="col">금액</th>
                                                        <th scope="col">날짜</th>
                                                        <th scope="col">상태</th>
                                                        <th scope="col"></th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach var="pay" items="${payList}" varStatus="loop">
                                                        <tr>
                                                            <%--<th>${pay.transactionType}</th>--%>
                                                            <td>${pay.sale.id}</td>
                                                            <td>${pay.categoryName}</td>
                                                            <td>${pay.sale.user.tel}</td>
                                                            <%--<td>1</td>--%>
                                                            <%--<td>${pay.}</td>--%>

                                                            <td><fmt:formatNumber value="${pay.sale.price}" pattern="###,###"/></td>
                                                            <%--<td>${pay.price}</td>--%>

                                                            <td><fmt:formatDate value="${pay.sale.createdAt}" pattern="yyyy. MM. dd" /></td>
                                                            <%--<td>${pay.createdAt}</td>--%>
                                                            <td>상태코드</td>
                                                            <td>
                                                                <div>
                                                                    <form id="cancelForm${pay.sale.id}" action="/mng/pay/cancel" method="post">
                                                                        <input type="hidden" name="saleId" value="${pay.sale.id}">
                                                                        <button class="btn-danger btn" type="button" onclick="openConfirm(event, ${pay.sale.id})">
                                                                            결제 취소
                                                                        </button>
                                                                    </form>
                                                                </div>
                                                            </td>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        </c:when>
                                        <c:otherwise>
                                            <p>결제 내역이 없습니다</p>
                                        </c:otherwise>
                                    </c:choose>

                                </div>
                                <div style="display: block; text-align: center;">
                                    <c:if test="${paging.startPage != 1 }">
                                        <a
                                                href="/mng/pay/list?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}">&lt;</a>
                                    </c:if>
                                    <c:forEach begin="${paging.startPage }"
                                               end="${paging.endPage }" var="p">
                                        <c:choose>
                                            <c:when test="${p == paging.nowPage }">
                                                <b>${p }</b>
                                            </c:when>
                                            <c:when test="${p != paging.nowPage }">
                                                <a href="/mng/pay/list?nowPage=${p }&cntPerPage=${paging.cntPerPage}">${p }</a>
                                            </c:when>
                                        </c:choose>
                                    </c:forEach>
                                    <c:if test="${paging.endPage != paging.lastPage}">
                                        <a
                                                href="/mng/pay/list?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}">&gt;</a>
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

    <script>
        function openConfirm(event, saleId) {
            var clickButton = event.target;
            if(confirm('결제를 취소하겠습니까?')) {
                document.getElementById('cancelForm' + saleId).submit();
                alert('취소되었습니다');

                clickButton.innerText = '환불완료';
                clickButton.style.backgroundColor = 'grey';
                clickButton.style.cursor = 'default';
            }
        }
    </script>

    <script>
        // 드롭다운이 변경될 때 실행되는 함수
        function filterTableByCategory() {
            // 선택된 드롭다운 값 가져오기
            var selectedCategory = $("#categoryDropdown").val();

            // 모든 행 숨기기
            $(".table tbody tr").hide();

            // 선택된 구분에 해당하는 행만 표시
            if (selectedCategory !== "") {
                $(".table tbody td:nth-child(2):contains('" + selectedCategory + "')").parent().show();
            } else {
                // 전체 구분이 선택된 경우 모든 행 표시
                $(".table tbody tr").show();
            }
        }

        // 드롭다운 변경 이벤트에 함수 연결
        $(document).ready(function () {
            $("#categoryDropdown").on("change", filterTableByCategory);
        });
    </script>

<%@ include file="/WEB-INF/view/mng/layout/mngFooter.jsp"%>
