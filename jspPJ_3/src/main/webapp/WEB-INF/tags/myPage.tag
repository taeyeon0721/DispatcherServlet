<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:choose>
<c:when test="${mid != null}">
					<table><tr style="height: 200px;">
							<td>
								<div class="d-flex feature-h" style="width: 400px;">
									<a href="mSelectOne.do" class="wrap-icon me-3"> <span class="icon-person"></span>
									</a>
									<div class="feature-text">
										<h3 class="heading">내 정보 보기</h3>
										<p class="text-black-50">회원님의 개인정보를 변경하실 수 있습니다</p>
									</div>
								</div>
							</td>
						</tr>
						<tr style="height: 200px;">
							<td><div class="d-flex feature-h" style="width: 500px;">
									<a href="cSelectAll.do" class="wrap-icon me-3"> <span
										class="icon-mail_outline"></span>
									</a>
									<div class="feature-text">
										<h3 class="heading">상담 내역</h3>
										<p class="text-black-50">회원님의 상담 내역을 확인할 수 있습니다</p>
									</div>
								</div></td>
						</tr>
						<tr style="height: 200px;">
							<td><div class="d-flex feature-h" style="width: 400px;">
									<a href="jSelectAll.do" class="wrap-icon me-3"> <span class="icon-heart"></span>
									</a>
									<div class="feature-text">
										<h3 class="heading">찜한 목록</h3>
										<p class="text-black-50">회원님의 찜한 집들을 확인할 수 있습니다</p>
									</div>
								</div></td>
						</tr>
						<tr style="height: 200px;">
							<td><div class="d-flex feature-h" style="width: 400px;">
									<a href="main.do" class="wrap-icon me-3"> <span class="icon-home2"></span>
									</a>
									<div class="feature-text">
										<h3 class="heading">추천매물 확인</h3>
										<p class="text-black-50">설정한 거주지 주변의 추천매물을 확인합니다</p>
									</div>
								</div></td>
						</tr>
					</table>
</c:when>

<c:when test="${rid != null}">
<table>
						<tr style="height: 200px;">
							<td><div class="d-flex feature-h" style="width: 400px;">
									<a href="rSelectOne.do" class="wrap-icon me-3"> <span class="icon-person"></span>
									</a>
									<div class="feature-text">
										<h3 class="heading">내 정보 보기</h3>
										<p class="text-black-50">회원님의 개인정보를 변경하실 수 있습니다</p>
									</div>
								</div>
							</td>
						</tr>
						<tr style="height: 200px;">
							<td><div class="d-flex feature-h" style="width: 400px;">
									<a href="estateInsert.jsp" class="wrap-icon me-3"> <span class="icon-plus"></span>
									</a>
									<div class="feature-text">
										<h3 class="heading">매물 등록</h3>
										<p class="text-black-50">회원님의 매물을 등록할 수 있습니다</p>
									</div>
								</div>
							</td>
						</tr>
						<tr style="height: 200px;">
							<td>
								<div class="d-flex feature-h" style="width: 500px;">
									<a href="eMain.do?rid=${rid}" class="wrap-icon me-3"> <span class="icon-home2"></span>
									</a>
									<div class="feature-text">
										<h3 class="heading">매물 내역</h3>
										<p class="text-black-50">회원님의 등록한 매물을 확인할 수 있습니다</p>
									</div>
								</div>
							</td>
						</tr>
					</table>
</c:when>
</c:choose>