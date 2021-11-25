<!--
<template>
  <div>
    <b-row>
      <b-container id="map" style="width: 100%; height: 500px"></b-container>
    </b-row>
    <b-container v-if="houses" class="bv-example-row mt-3">
      <house-list-row
        v-for="(house, index) in houses"
        :key="index"
        :house="house"
      />
    </b-container>
    <b-container v-else class="bv-example-row mt-3">
      <b-row>
        <b-col><b-alert show>아파트 목록이 없습니다.</b-alert></b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>
import HouseListRow from "@/components/house/HouseListRow.vue";
import { mapState, mapGetters } from "vuex";

const houseStore = "houseStore";
export default {
  name: "HouseList",
  components: {
    HouseListRow,
  },
  data() {
    return {
      map: null,
      markers: [],
    };
  },
  computed: {
    ...mapGetters(houseStore, ["houseInfo"]),
    ...mapState(houseStore, ["houses"]),
  },
  updated() {
    console.log("make start");
    this.displayMarker(this.houseInfo);
    console.log("make end");
  },
  mounted() {
    if (window.kakao && window.kakao.maps) {
      this.initMap();
    } else {
      const script = document.createElement("script");
      /* global kakao */
      script.onload = () => kakao.maps.load(this.initMap);
      script.src =
        "//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=6990eed65ef1b708187bd62ce4f1afe6";
      document.head.appendChild(script);
    }
  },
  methods: {
    initMap() {
      const container = document.getElementById("map");
      const options = {
        center: new kakao.maps.LatLng(33.450701, 126.570667),
        level: 5,
      };
      this.map = new kakao.maps.Map(container, options);
    },
    displayMarker(places) {
      //var fragment = document.createDocumentFragment();
      var bounds = new kakao.maps.LatLngBounds();

      // 지도에 표시되고 있는 마커를 제거합니다
      this.removeMarker();
      console.log("places 길이 : " + places.length);
      for (var i = 0; i < places.length; i++) {
        var placePosition = new kakao.maps.LatLng(places[i].lat, places[i].lng);
        console.log("places positions : " + placePosition);
        // var marker = this.addMarker(placePosition, i);
        // var itemEl = getListItem(i, places[i]); // 검색 결과 항목 Element를 생성합니다

        // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
        // LatLngBounds 객체에 좌표를 추가합니다
        bounds.extend(placePosition);
        this.addMarker(placePosition, i);
        // 마커와 검색결과 항목에 mouseover 했을때
        // 해당 장소에 인포윈도우에 장소명을 표시합니다
        // mouseout 했을 때는 인포윈도우를 닫습니다

        // (function (marker, title, code, place) {
        //   kakao.maps.event.addListener(marker, "click", function () {
        //     displayInfowindow(marker, title, place);
        //     console.log(title + " " + code);
        //   });

        //   kakao.maps.event.addListener(map, "click", function () {
        //     console.log(customOverlay);
        //     customOverlay.setMap(null);
        //   });

        // itemEl.onmouseover = function () {
        //   displayInfowindow(marker, title);
        // };

        // itemEl.onmouseout = function () {
        //   customOverlay.setMap(null);
        // };
        // })(marker, places[i].aptName, places[i].aptCode, places[i]);

        // fragment.appendChild(itemEl);
      }
      // 마커를 생성하고 지도에 표시합니다

      // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
      this.map.setBounds(bounds);
    },
    addMarker(position, idx) {
      var imageSrc =
          "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png", // 마커 이미지 url, 스프라이트 이미지를 씁니다
        imageSize = new kakao.maps.Size(36, 37), // 마커 이미지의 크기
        imgOptions = {
          spriteSize: new kakao.maps.Size(36, 691), // 스프라이트 이미지의 크기
          spriteOrigin: new kakao.maps.Point(0, idx * 46 + 10), // 스프라이트 이미지 중 사용할 영역의 좌상단 좌표
          offset: new kakao.maps.Point(13, 37), // 마커 좌표에 일치시킬 이미지 내에서의 좌표
        },
        markerImage = new kakao.maps.MarkerImage(
          imageSrc,
          imageSize,
          imgOptions
        ),
        marker = new kakao.maps.Marker({
          position: position, // 마커의 위치
          image: markerImage,
        });

      marker.setMap(this.map); // 지도 위에 마커를 표출합니다
      this.markers.push(marker); // 배열에 생성된 마커를 추가합니다

      return marker;
    },
    removeMarker() {
      for (var i = 0; i < this.markers.length; i++) {
        this.markers[i].setMap(null);
      }
      this.markers = [];
    },
  },
};
</script>

<style scoped>
#map {
  width: 400px;
  height: 400px;
}

.button-group {
  margin: 10px 0px;
}

button {
  margin: 0 3px;
}
</style>
-->
<template>
  <div>
    <b-row>
      <b-container id="map" style="width: 100%; height: 500px"></b-container>
    </b-row>
    <b-container v-if="houses" class="bv-example-row mt-3">
      <house-list-row
        v-for="(house, index) in houses"
        :key="index"
        :house="house"
      />
    </b-container>
    <b-container v-else class="bv-example-row mt-3">
      <b-row>
        <b-col><b-alert show>아파트 목록이 없습니다.</b-alert></b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>
import HouseListRow from "@/components/house/HouseListRow.vue";
import { mapState, mapGetters } from "vuex";

const houseStore = "houseStore";
export default {
  name: "HouseList",
  components: {
    HouseListRow,
  },
  data() {
    return {
      map: null,
      markers: [],
      geocoder: null,
    };
  },
  computed: {
    ...mapGetters(houseStore, ["houseInfo"]),
    ...mapState(houseStore, ["houses"]),
  },
  updated() {
    // console.log("make start");
    this.displayMarker(this.houseInfo);
    // console.log("make end");
  },
  mounted() {
    if (window.kakao && window.kakao.maps) {
      this.initMap();
    } else {
      const script = document.createElement("script");
      /* global kakao */
      script.onload = () => kakao.maps.load(this.initMap);
      script.src =
        "//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=6990eed65ef1b708187bd62ce4f1afe6&libraries=services";
      document.head.appendChild(script);
    }
  },
  methods: {
    initMap() {
      const container = document.getElementById("map");
      const options = {
        center: new kakao.maps.LatLng(33.450701, 126.570667),
        level: 5,
      };
      this.map = new kakao.maps.Map(container, options);
      this.geocoder = new kakao.maps.services.Geocoder();
    },
    async displayMarker(places) {
      console.log("displayMarker");
      //var fragment = document.createDocumentFragment();
      var bounds = await new kakao.maps.LatLngBounds();
      var list = [];
      // 지도에 표시되고 있는 마커를 제거합니다
      this.removeMarker();
      console.log(places);
      places.forEach((p) => {
        var addr = p.roadName + " " + parseInt(p.buildingCode);
        console.log("addr", addr, "\n", "places : ", p);
        // var position = await new kakao.maps.LatLng(places[i].y, places[i].x);
        // list.push(position);
        if (p.roadName !== null) {
          console.log("in!!!!");
          this.geocoder.addressSearch(addr, (result, status) => {
            if (status === kakao.maps.services.Status.OK) {
              var position = new kakao.maps.LatLng(result[0].y, result[0].x);
              list.push(position);
              console.log("result", result);
            }
          });
        }
      });
      // for (var i = 0; i < places.length; i++) {
      //   var addr = places[i].roadName + " " + parseInt(places[i].buildingCode);
      //   console.log("addr", addr, "\n", "places : ", places[i]);
      //   // var position = await new kakao.maps.LatLng(places[i].y, places[i].x);
      //   // list.push(position);
      //   if (places[i].roadName !== null) {
      //     console.log("in!!!!");
      //     await this.geocoder.addressSearch(addr, (result, status) => {
      //       if (status === kakao.maps.services.Status.OK) {
      //         var position = new kakao.maps.LatLng(result[0].y, result[0].x);
      //         list.push(position);
      //         console.log("result", result);
      //       }
      //     });
      //   }
      // }

      console.log("displayMarker list length: " + list.length);
      this.addMarker(list);
      this.map.setBounds(bounds);
    },
    addMarker(list) {
      console.log("addMarker list : " + list);
      for (var idx = 0; idx < list.length; idx++) {
        var imageSrc =
            "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png", // 마커 이미지 url, 스프라이트 이미지를 씁니다
          imageSize = new kakao.maps.Size(36, 37), // 마커 이미지의 크기
          imgOptions = {
            spriteSize: new kakao.maps.Size(36, 691), // 스프라이트 이미지의 크기
            spriteOrigin: new kakao.maps.Point(0, idx * 46 + 10), // 스프라이트 이미지 중 사용할 영역의 좌상단 좌표
            offset: new kakao.maps.Point(13, 37), // 마커 좌표에 일치시킬 이미지 내에서의 좌표
          },
          markerImage = new kakao.maps.MarkerImage(
            imageSrc,
            imageSize,
            imgOptions
          ),
          marker = new kakao.maps.Marker({
            position: list[idx], // 마커의 위치
            image: markerImage,
          });

        marker.setMap(this.map); // 지도 위에 마커를 표출합니다
        this.markers.push(marker); // 배열에 생성된 마커를 추가합니다
      }
    },
    removeMarker() {
      for (var i = 0; i < this.markers.length; i++) {
        this.markers[i].setMap(null);
      }
      this.markers = [];
    },
  },
};
</script>

<style scoped>
#map {
  width: 400px;
  height: 400px;
}

.button-group {
  margin: 10px 0px;
}

button {
  margin: 0 3px;
}
</style>