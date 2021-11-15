<template>
  <b-row class="mt-4 mb-4 text-center">
    <b-col class="sm-3">
      <b-form-input
        v-model.trim="dongCode"
        placeholder="동코드 입력...(예 : 11110)"
        @keypress.enter="sendKeyword"
      ></b-form-input>
    </b-col>
    <b-col class="sm-3" align="left">
      <b-button variant="outline-primary" @click="sendKeyword">검색</b-button>
    </b-col>
  </b-row>
</template>

<script>
export default {
  name: "HouseSearchBar",
  data() {
    return {
      dongCode: "",
    };
  },
  methods: {
    sendKeyword() {},
  },
};
</script>

<style></style>
