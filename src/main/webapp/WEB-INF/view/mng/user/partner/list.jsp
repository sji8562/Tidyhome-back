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
				<h4 class="page-title">유저 관리</h4>
			</div>
			<div class="col-7 align-self-center">
				<div class="d-flex align-items-center justify-content-end">
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="#">Home</a></li>
							<li class="breadcrumb-item active" aria-current="page">Basic
								Table</li>
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
									<h4 class="card-title">파트너 조회</h4>
									<form class="row g-3">
										<div class="col-auto">
											<input type="text" class="form-control" id="keyword" placeholder="이메일을 입력해주세요">
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
											<th scope="col">파트너이름</th>
											<th scope="col">일 종류</th>
											<th scope="col">성별</th>
											<th scope="col">생성날짜</th>
											<th scope="col">회원관리</th>
										</tr>
<%--										insert into partner_tb(tel,username,pic_url,category_id,gender,level,created_at) values ('01095951234','페이퍼컴퍼니',null,null,'m',9,now());--%>
										</thead>
										<tbody>
										<c:choose>
										<c:when test="${not empty partnerPG.content }">

											<c:forEach var="partnerPG" items="${partnerPG.content}">
												<tr>
													<th class="applyDetail" scope="row"><a href="/mng/user/${partnerPG.id}/partner-detail">${partnerPG.id}</a></th>
													<td class="applyDetail"><a href="/mng/user/${partnerPG.id}/partner-detail">${partnerPG.tel }</a></td>
													<td class="applyDetail"><a href="/mng/user/${partnerPG.id}/partner-detail">${partnerPG.username }</a></td>
													<td class="applyDetail"><a href="/mng/user/${partnerPG.id}/partner-detail">${partnerPG.categoryId }</a></td>
													<c:if test="${partnerPG.gender == null ||empty partnerPG.gender}">
														<td class="applyDetail"><a href="/mng/user/${partnerPG.id}/partner-detail">업체</a></td>
													</c:if>
													<c:if test="${partnerPG.gender == 'f'}">
														<td class="applyDetail"><a href="/mng/user/${partnerPG.id}/partner-detail">여자</a></td>
													</c:if>
													<c:if test="${partnerPG.gender == 'm'}">
														<td class="applyDetail"><a href="/mng/user/${partnerPG.id}/partner-detail">남자</a></td>
													</c:if>

													<td class="applyDetail"><a href="/mng/user/${partnerPG.id}/partner-detail"><fmt:formatDate value="${partnerPG.createdAt}" pattern="yyyy. MM. dd" /></a></td>
													<td>
														<div>
															<button class="btn btn-success"
																	style="border: 1px solid black"
																	onclick="location.href='/mng/user/${partnerPG.id}/partner-update'">수정</button>
															&nbsp;&nbsp;
															<button class="btn-danger btn"
																	onclick="location.href='/mng/user/${partnerPG.id}/partner-delete'">삭제</button>
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
											<c:if test="${partnerPG.first}">disabled</c:if>"><a class="page-link" href="?keyword=${keyword}&page=${prevPage}">Previous</a>
											</li>

											<li class="page-item
											<c:if test="${partnerPG.last}">disabled</c:if>"><a class="page-link" href="?keyword=${keyword}&page=${nextPage}">Next</a></li>
										</ul>
									</c:if>
									<c:if test="${empty keyword}">
										<ul class="pagination d-flex justify-content-center">
											<li class="page-item <c:if test="${partnerPG.first}">disabled</c:if>"><a class="page-link"
																													 href="?page=${prevPage}">Previous</a>
											</li>
											<li class="page-item <c:if test="${partnerPG.last}">disabled</c:if>"><a class="page-link"
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
<%@ include file="/WEB-INF/view/mng/layout/mngFooter.jsp"%>