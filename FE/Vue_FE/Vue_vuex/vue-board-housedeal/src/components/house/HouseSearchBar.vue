<template>
  <b-row class="mt-4 mb-4 text-center">
    <b-col class="sm-3">
      <b-form-select v-model="sidoCode" :options="sidos" @change="gugunList">
      </b-form-select>
    </b-col>
    <b-col class="sm-3">
      <b-form-select v-model="gugunCode" :options="guguns" @change="searchApt">
      </b-form-select>
    </b-col>
  </b-row>
</template>

<script>
import { mapState, mapActions, mapMutations } from "vuex";
export default {
  name: "HouseSearchBar",
  data() {
    return {
      sidoCode: null,
      gugunCode: null,
    };
  },
  computed: {
    // store에 있는 state 이름을 매핑해서 가져옴.
    ...mapState(["sidos", "guguns", "houses"]),
  },
  created() {
    // 들어오자 마자 가져온걸 options에 넣어줘야함.
    // mapAction 없을떄 : this.$store.dispatch("getSido");
    this.sidoList();
    this.getGugun();
  },
  methods: {
    ...mapActions(["getSido", "getGugun", "getHouseList"]),
    ...mapMutations(["CLEAR_GUGUN_LIST", "CLEAR_SIDO_LIST"]),
    sidoList() {
      this.CLEAR_SIDO_LIST();
      this.getSido();
    },
    gugunList() {
      this.CLEAR_GUGUN_LIST();
      this.gugunCode = null;
      if (this.sidoCode) this.getGugun(this.sidoCode);
    },
    searchApt() {
      if (this.gugunCode) this.getHouseList(this.gugunCode);
    },
    sendKeyword() {},
  },
};
</script>

<style></style>
