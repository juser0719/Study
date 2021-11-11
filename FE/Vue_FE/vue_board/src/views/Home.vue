<template>
  <div class="home">
      <Main :msg ="msg">
  </div>
</template>

<script>
export default {
    name: "Home",
    data() {
        return {
            msg = "From Home"
        }
    },
};
</script>

<style>
</style>