<template>
  <div>
    <div>
      <h2>{{ msg }}</h2>
      <ul>
        <li><router-link to="/register">글 등록</router-link></li>
        <li><router-link to="/list">글 목록</router-link></li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  name: "Main",
  props: {
    msg: String,
  },
};
</script>

<style></style>
