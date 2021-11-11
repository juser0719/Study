<template>
  <div id="app">
    <div class="header">
      <router-link to="/">
        <img src="@/asset/ssafy_logo.png" class="ssafy_logo" />
      </router-link>
      <div>
        <router-link to="/board">게시판</router-link>
        <router-link to="/login">로그인</router-link>
      </div>
    </div>
    <router-view />
  </div>
</template>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
</style>
