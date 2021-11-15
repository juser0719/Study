<template>
  <button v-on:click="addCount">{{ title }} - {{ count }}</button>
</template>

<script>
export default {
  name: "Subject",
  props: ["title"],
  data() {
    return {
      count: 0,
    };
  },
  methods: {
    addCount: function () {
      this.count += 1;
      // this.$emit("addtotcount"); 원래는 부모에게 변경한 값을 알려줬어야하는ㄷ...
      this.$store.state.count++;
      // 이곳에 count를 증가시키는 걸로 대신함. $는 뷰가 가지고 있는 내부 데이터.
    },
  },
};
</script>

<style></style>
