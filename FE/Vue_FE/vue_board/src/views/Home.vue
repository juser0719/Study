<template>
  <div class="home">
    <Main :msg="msg" />
  </div>
</template>

<script>
import Main from "@/components/Main";
export default {
  name: "Home",
  components: {
    Main,
  },
  data() {
    return {
      msg: "안녕하세요 싸피6기입니다.",
    };
  },
};
</script>

<style></style>
