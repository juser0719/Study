<template>
  <b-container v-if="apts && apts.length != 0" class="bv-example-row mt-3">
    <house-list-row v-for="(apt, index) in apts" :key="index" :apt="apt" />
  </b-container>
  <b-container v-else class="bv-example-row mt-3">
    <b-row>
      <b-col><b-alert show>아파트 목록이 없습니다.</b-alert></b-col>
    </b-row>
  </b-container>
</template>

<script>
import HouseListRow from "@/components/house/HouseListRow.vue";

export default {
  name: "HouseList",
  components: {
    HouseListRow,
  },
  data() {
    return {
      apts: ["a"],
    };
  },
};
</script>

<style></style>
