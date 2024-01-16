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
                                <td class="table-responsive">
                                    <table class="table">
                                        <thead class="table-light">
                                        <tr>
                                            <th scope="col" style="width: 80px;">번호</th>
                                            <th scope="col">구분</th>
                                            <th scope="col">사용자</th>
                                            <th scope="col">금액</th>
                                            <th scope="col">날짜</th>
                                            <th scope="col">상태</th>
                                            <th scope="col"></th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:choose>
                                            <c:when test="${payList != null}">
                                                <c:forEach var="pay" items="${payList}" varStatus="loop">
                                                    <tr id="payList">
                                                        <td>${pay.sale.id}</td>
                                                        <td>${pay.categoryName}</td>
                                                        <td>${pay.sale.user.tel}</td>
                                                        <td><fmt:formatNumber value="${pay.sale.price}"
                                                                              pattern="###,###"/></td>
                                                        <td><fmt:formatDate value="${pay.sale.createdAt}"
                                                                            pattern="yyyy. MM. dd"/></td>
                                                            <%--<td>${pay.createdAt}</td>--%>
                                                        <td>${pay.sale.statusToString()}</td>
                                                        <td>
                                                            <div>
                                                                <form id="cancelForm${pay.sale.id}"
                                                                      action="/mng/pay/cancel" method="post">
                                                                    <input type="hidden" name="saleId" value="${pay.sale.id}">
                                                                    <c:choose>
                                                                        <c:when test="${pay.sale.status eq 4}">
                                                                            <button class="btn-danger btn" type="button"
                                                                                    style="background-color: dimgray; border-color: dimgray;" disabled>
                                                                                환불 완료
                                                                            </button>
                                                                        </c:when>
                                                                        <c:when test="${pay.sale.status eq 3}">
                                                                            <button class="btn-danger btn" type="button"
                                                                                    style="background-color: dimgray; border-color: dimgray;" disabled>
                                                                                결제 취소
                                                                            </button>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <button class="btn-danger btn" type="button" onclick="openConfirm(${pay.sale.id})">
                                                                                결제 취소
                                                                            </button>
                                                                        </c:otherwise>
                                                                    </c:choose>
                                                                </form>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                                <tr style="display: none" id="noResultMessage">
                                                    <td colspan="7">
                                                        <p>결제된 내역이 없습니다.</p>
                                                    </td>
                                                </tr>
                                            </c:when>
                                            <c:otherwise>
                                                <tr id="noResultMessage">
                                                    <td colspan="7">
                                                        <p>결제된 내역이 없습니다.</p>
                                                    </td>
                                                </tr>
                                            </c:otherwise>
                                        </c:choose>
                                        </tbody>
                                    </table>
                                </div>
                                <div style="display: block; text-align: center;">
                                    <c:if test="${paging.startPage != paging.nowPage }">
                                        <a href="/mng/pay/list?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}">&lt;&ensp;</a>
                                    </c:if>
                                    <c:forEach begin="${paging.startPage }"
                                               end="${paging.endPage }" var="p">
                                        <c:choose>
                                            <c:when test="${p == paging.nowPage }">
                                                <b>${p }</b>
                                            </c:when>
                                            <c:when test="${p != paging.nowPage }">
                                                <a href="/mng/pay/list?nowPage=${p }&cntPerPage=${paging.cntPerPage}"
                                                   style="color: black; font-weight: bold">${p+1}</a>
                                            </c:when>
                                        </c:choose>
                                    </c:forEach>
                                    <c:if test="${paging.endPage != paging.lastPage}">
                                        <a href="/mng/pay/list?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}">&ensp;&gt;</a>
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
        function openConfirm(saleId) {
            if (confirm('결제를 취소하겠습니까?')) {
                document.getElementById('cancelForm' + saleId).submit();
                alert('취소되었습니다');
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
        $("#noResultMessage").hide();

        // 선택된 구분에 해당하는 행 찾기
        if (selectedCategory !== "") {
            var selectedRows = $(".table tbody td:nth-child(2):contains('" + selectedCategory + "')").parent();

            // 선택된 행이 있을 경우 표시, 없을 경우 메시지 표시
            if (selectedRows.length > 0) {
                selectedRows.show();
                $("#noResultMessage").hide();
            } else {
                $("#noResultMessage").show();
            }
        } else {
            // 전체 구분이 선택된 경우 모든 행 표시
            $(".table tbody tr").show();
            $("#noResultMessage").hide();
        }
    }

    // 드롭다운 변경 이벤트에 함수 연결
    $(document).ready(function () {
        $("#categoryDropdown").on("change", filterTableByCategory);
    });
</script>



<%@ include file="/WEB-INF/view/mng/layout/mngFooter.jsp" %>
