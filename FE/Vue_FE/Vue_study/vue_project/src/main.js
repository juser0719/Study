import Vue from 'vue'
import App from './App.vue'
import router from './router'

Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App)
  // "App이라는 놈이 랜더링 될겁니다" 라는 뜻.
}).$mount('#app')
 // "#app"에.
