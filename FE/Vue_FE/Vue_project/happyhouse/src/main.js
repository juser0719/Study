import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import { BootstrapVue, IconsPlugin } from "bootstrap-vue";

// Import Bootstrap an BootstrapVue CSS files (order is important)
import "bootstrap/dist/css/bootstrap.css";
import "bootstrap-vue/dist/bootstrap-vue.css";
import store from "./store";
// import memberStore from "./store/modules/memberStore";

Vue.use(BootstrapVue);
Vue.use(IconsPlugin);

Vue.config.productionTip = false;

new Vue({
  router,
  store,
  async beforeCreate() {
    let token = sessionStorage.getItem("access-token");
    if (store.memberStore.state.userInfo == null && token) {
      await store.memberStore.dispatch("getUserInfo", token);
    }
  },
  render: (h) => h(App),
}).$mount("#app");
