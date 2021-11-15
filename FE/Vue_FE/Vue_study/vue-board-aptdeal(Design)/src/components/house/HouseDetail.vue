<template>
  <b-container class="bv-example-row">
    <b-row>
      <b-col><h3>아파트이름</h3></b-col>
    </b-row>
    <b-row class="mb-2 mt-1">
      <b-col
        ><b-img :src="require('@/assets/apt.png')" fluid-grow></b-img
      ></b-col>
    </b-row>
    <b-row>
      <b-col>
        <b-alert show variant="secondary">일련번호 : 일련번호</b-alert>
      </b-col>
    </b-row>
    <b-row>
      <b-col>
        <b-alert show variant="primary">아파트 이름 : 아파트 </b-alert>
      </b-col>
    </b-row>
    <b-row>
      <b-col>
        <b-alert show variant="info">법정동 : 법정동 </b-alert>
      </b-col>
    </b-row>
    <b-row>
      <b-col>
        <b-alert show variant="warning">층수 : 층</b-alert>
      </b-col>
    </b-row>
    <b-row>
      <b-col>
        <b-alert show variant="danger">거래금액 : 원</b-alert>
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
export default {
  name: "HouseDetail",
  filters: {
    price(value) {
      if (!value) return value;
      return value.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    },
  },
};
</script>

<style></style>
