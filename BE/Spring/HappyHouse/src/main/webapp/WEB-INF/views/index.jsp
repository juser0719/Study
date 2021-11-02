<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
<%@ include file="../include/header.jsp"%>
<body>

   <!-- ======= Hero Section ======= -->
   <section id="hero" style='background-image: none'>
      <div class="hero-container" data-aos="fade-in">
         <h1 style='color: #6ad0f7'>행복한 우리집</h1>
         <h2>HAPPY HOUSE</h2>

         <section id="index_section">
            <div
               class="sorting-filters text-center mb-20 d-flex justify-content-center">
               <div class="form-group md pr-3">
                  <select class="form-control" name="sido" id="sido">
                     <option value="0">시도</option>
                  </select>
               </div>
               <div class="form-group md-1 pr-3">
                  <select class="form-control" name="gugun" id="gugun">
                     <option value="0">구군</option>
                  </select>
               </div>
               <div class="form-group md-1">
                  <select class="form-control" name="dong" id="dong">
                     <option value="0">읍면동</option>
                  </select>
               </div>
               <div class="form-group md-1 pr-3">
                  <button class="form-control" type="button" id="aptSearchBtn">검색</button>
               </div>
            </div>

            <table class="table mt-2">
               <colgroup>
                  <col width="100">
                  <col width="150">
                  <col width="*">
                  <col width="120">
                  <col width="120">
               </colgroup>
               <thead>
                  <tr>
                     <th>번호</th>
                     <th>아파트이름</th>
                     <th class="text-center">주소</th>
                     <th>건축연도</th>
                     <th>최근거래금액</th>
                  </tr>
               </thead>
               <tbody id="searchResult"></tbody>
            </table>
         </section>

         <div id="map" style="width: 50%; height: 500px;"></div>
         <script type="text/javascript"
            src="//dapi.kakao.com/v2/maps/sdk.js?appkey=07bd44f83383ec8e4128a3369397c653&libraries=services"></script>
         <script type="text/javascript" src="js/map.js"></script>
         <script type="text/javascript">
            let colorArr = ['table-primary','table-success','table-danger'];
            $(document).ready(function(){               
               $.get(root + "/map/sido"
                  ,function(data, status){
                     $.each(data, function(index, vo) {
                        $("#sido").append("<option value='"+vo.sidoCode+"'>"+vo.sidoName+"</option>");
                     });
                  }
                  , "json"
               );
            });
            $(document).on("change", "#sido", function() {
               $.get(root + "/map/gugun"
                     ,{sido: $("#sido").val()}
                     ,function(data, status){
                        $("#gugun").empty();
                        $("#gugun").append('<option value="0">선택</option>');
                        $.each(data, function(index, vo) {
                           $("#gugun").append("<option value='"+vo.gugunCode+"'>"+vo.gugunName+"</option>");
                        });
                     }
                     , "json"
               );
            });
            $(document).on("change", "#gugun", function() {
               $.get(root + "/map/dong"
                     ,{gugun: $("#gugun").val()}
                     ,function(data, status){
                        $("#dong").empty();
                        $("#dong").append('<option value="0">선택</option>');
                        $.each(data, function(index, vo) {
                           $("#dong").append("<option value='"+vo.dongCode+"'>"+vo.dongName+"</option>");
                        });
                     }
                     , "json"
               );
            });
            $(document).on("change", "#dong", function() {
               $.get(root + "/map/apt"
                     ,{dong: $("#dong").val()}
                     ,function(data, status){
                        $("tbody").empty();
                        $.each(data, function(index, vo) {
                        	console.log(vo);
                           let str = `
                              <tr class=${"${colorArr[index%3]}"}>
                              <td>${"${vo.aptCode}"}</td>
                              <td>${"${vo.aptName}"}</td>
                              <td>${"${vo.sidoName} ${vo.gugunName} ${vo.dongName} ${vo.jibun}"}</td>
                              <td>${"${vo.buildYear}"}</td>
                              <td>${"${vo.recentPrice}"}</td>
                              </tr>
                           `;
                           console.log(str);
                           $("tbody").append(str);
                        });
                        displayMarkers(data);
                     }
                     , "json"
               );
            });
            
            $(document).on("click", "#aptSearchBtn", function() {
               var param = {
                     serviceKey:'5N6DG8ycmqNJJ/WMTmS0amKZ081n1/j/gwo54VAuAvGh7ceK+Y1pUWWA6H5DnvoRoAXwFaS88u7djOw1IU9TWQ==',
                     pageNo:encodeURIComponent('1'),
                     numOfRows:encodeURIComponent('10'),
                     LAWD_CD:encodeURIComponent($("#gugun").val()),
                     DEAL_YMD:encodeURIComponent('202110')
               };
               $.get('http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev'
                     ,param
                     ,function(data, status){
                        var items = $(data).find('item');
                        var jsonArray = new Array();
                        items.each(function() {
                           var jsonObj   = new Object();
                           jsonObj.aptCode = $(this).find('일련번호').text();
                           jsonObj.aptName = $(this).find('아파트').text();
                           jsonObj.dongCode = $(this).find('법정동읍면동코드').text();
                           jsonObj.buildYear = $(this).find('건축년도').text();
                           jsonObj.jibun = $(this).find('지번').text();
                           jsonObj.recentPirce = $(this).find('거래금액').text();
                              
                           jsonObj = JSON.stringify(jsonObj);
              
                           jsonArray.push(JSON.parse(jsonObj));
                        });
                        console.log(jsonArray);
                     }
                     , "xml"
               );
               
            });
            </script>
      </div>
   </section>
   <!-- End Hero Section -->
   <%@ include file="../include/footer.jsp"%>
</body>
<%@ include file="../include/vendorjs.jsp"%>
</html>