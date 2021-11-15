<template>
  <h2>{{ total }}</h2>
</template>

<script>
export default {
  // props: ["total"],
  computed: {
    // 차피 store에 있는 state값을 직접 바꿀 수 없기 떄문에, mutations만 가능하고 mutation을 action이 불러옴.
    total() {
      return this.$store.state.count;
    },
  },
};
</script>

<style></style>
