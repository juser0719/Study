<template>
  <div>
    <b-container v-if="house != null" class="bv-example-row">
      <b-row>
        <b-col
          ><h3>{{ house.aptName }}</h3></b-col
        >
      </b-row>
      <b-row class="mb-2 mt-1">
        <b-col
          ><b-img :src="require('@/assets/apt.png')" fluid-grow></b-img
        ></b-col>
      </b-row>
      <b-row>
        <b-col>
          <b-alert show variant="secondary">
            일련번호 : {{ house.aptCode }}
          </b-alert>
        </b-col>
      </b-row>
      <b-row>
        <b-col>
          <b-alert show variant="primary"
            >아파트 이름 : {{ house.aptName }}
          </b-alert>
        </b-col>
      </b-row>
      <b-row>
        <b-col>
          <b-alert show variant="info">법정동 : {{ house.dongName }} </b-alert>
        </b-col>
      </b-row>
      <b-row>
        <b-col>
          <b-alert show variant="danger"
            >거래금액 :
            {{
              (parseInt(house.recentPrice.replace(",", "")) * 10000) | price
            }}원</b-alert
          >
        </b-col>
      </b-row>
    </b-container>
    <b-container v-else class="bv-example-row">
      <b-row>
        <b-col><b-alert show>상세 정보</b-alert></b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>
import { mapState } from "vuex";

const houseStore = "houseStore";

export default {
  name: "HouseDetail",
  computed: {
    ...mapState(houseStore, ["house"]),
  },
  updated() {
    console.log("updated");
  },
  filters: {
    price(value) {
      if (!value) return value;
      return value.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    },
  },
};
</script>

<style></style>
