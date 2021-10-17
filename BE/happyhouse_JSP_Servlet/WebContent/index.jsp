<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<%@ include file="/include/header.jsp" %>

<body>
	<script>
	$(document).ready(function(){
		$("#city").change(function() {
			$.get("${pageContext.request.contextPath}/main"
					,{act:"gugun",sido:$("#city").val()}
					,function(data, status){
						$("#gugun").empty();
						$("#gugun").append('<option value="0">구/군</option>');
						$.each(data, function(index, vo) {
							console.log(vo);
							$("#gugun").append("<option value='"+vo.gugun_code+"'>"+vo.gugun_name+"</option>");
						});//each
					}//function
					, "json"
			);//get
		});//change
		$("#gugun").change(function() {
			$.get("${pageContext.request.contextPath}/main"
					,{ act:"dong",gugun:$("#gugun").val()}
					,function(data, status){
						$("#dong").empty();
						$("#dong").append('<option value="0">선택</option>');
						$.each(data, function(index, vo) {
							$("#dong").append("<option value='"+vo.dong_code+"'>"+vo.dong_name+"</option>");
						});//each
					}//function
					, "json"
			);//get
		});//change
		/* $("#dong").change(function() {
			$.get("${pageContext.request.contextPath}/dong"
					,{act:"apt", dong:$("#dong").val()}
					,function(data, status){
						$("tbody").empty();
						$.each(data, function(index, vo) {
							let str = "<tr class="+colorArr[index%3]+">"
							+ "<td>" + vo.apt_code + "</td>"
							+ "<td>" + vo.dong_name + "</td>"
							+ "<td>" + vo.apt_name + "</td>"
							+ "<td>" + vo.jibun + "</td>"
							+ "<td>" + vo.dong_code + "</td>"
							+ "<td id='lat_"+index+"'></td><td id='lng_"+index+"'></td></tr>";
							$("tbody").append(str);
							//$("#searchResult").append(vo.dong_name+" "+vo.apt_name+" "+vo.jibun+"<br>");
						});//each
						geocode(data);
					}//function
					, "json"
			);//get
		});//change */
	});//ready
	</script>
	<!-- ======= Hero Section ======= -->
	<section id="hero">
		<div class="hero-container" data-aos="fade-in">
			<h1>행복한 우리집</h1>
			<h2>HAPPY HOUSE</h2>

			<div
				class="sorting-filters text-center mb-20 d-flex justify-content-center">
				<form class="form-inline" id="frm" action="searchRecentHouseDeal.do">
					<div class="form-group md pr-3">
						<select class="form-control" name="city" id="city">
							<option value="all">도/광역시</option>
							<option value="1100000000">서울시</option>
							<option value="경기도">경기도</option>
							<option value="인천광역시">인천광역시</option>
							<option value="부산광역시">부산광역시</option>
							<option value="대전광역시">대전광역시</option>
							<option value="대구광역시">대구광역시</option>
							<option value="울산광역시">울산광역시</option>
							<option value="세종특별자치시">세종시</option>
							<option value="광주광역시">광주광역시</option>
							<option value="강원도">강원도</option>
							<option value="충청북도">충청북도</option>
							<option value="경상북도">경상북도</option>
							<option value="경상남도">경상남도</option>
							<option value="전라북도">전라북도</option>
							<option value="전라남도">전라남도</option>
							<option value="제주특별자치도">제주도</option>
						</select>
					</div>
					<div class="form-group md-1 pr-3">
						<select class="form-control" name="gu" id="gugun">
							<option value="all">구/군</option>
							<option value="도봉구">도봉구</option>
							<option value="은평구">은평구</option>
							<option value="동대문구">동대문구</option>
							<option value="동작구">동작구</option>
							<option value="금천구">금천구</option>
							<option value="구로구">구로구</option>
							<option value="종로구">종로구</option>
							<option value="강북구">강북구</option>
							<option value="중랑구">중랑구</option>
							<option value="강남구">강남구</option>
							<option value="강서구">강서구</option>
							<option value="중구">중구</option>
							<option value="강동구">강동구</option>
							<option value="광진구">광진구</option>
							<option value="마포구">마포구</option>
							<option value="서초구">서초구</option>
							<option value="성북구">성북구</option>
							<option value="노원구">노원구</option>
							<option value="송파구">송파구</option>
							<option value="서대문">서대문</option>
							<option value="양천구">양천구</option>
							<option value="영등포구">영등포구</option>
							<option value="관악구">관악구</option>
							<option value="성동구">성동구</option>
							<option value="용산구">용산구</option>
						</select>
					</div>
					<div class="form-group md-1">
						<select class="form-control" name="dong" id="dong">
							<option value="all" id="dongOption">동</option>
							<option> '태평로1가'</option>
						</select>
					</div>

				</form>
			</div>
			<br>
			<div id="map" style="height: 500px; width: 800px;"></div>
		</div>

	</section>
	<!-- End Hero Section -->
	<%@ include file="/include/footer.jsp" %>
</body>
	<%@ include file="/include/vendorjs.jsp" %>
</html>