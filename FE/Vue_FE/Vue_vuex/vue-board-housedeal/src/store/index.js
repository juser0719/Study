import Vue from "vue";
import Vuex from "vuex";
import http from "@/util/http-common.js";
Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    sidos: [{ value: null, text: "선택하시오" }],
    guguns: [{ value: null, text: "선택하시오" }],
  },
  mutations: {
    GET_SIDO_LIST(state, sidos) {
      sidos.forEach((sido) => {
        state.sidos.push({ value: sido.sidoCode, text: sido.sidoName });
      });
    },
    GET_GUGUN_LIST(state, guguns) {
      guguns.forEach((gugun) => {
        state.guguns.push({ value: gugun.gugunCode, text: gugun.gugunName });
      });
    },
    CLEAR_SIDO_LIST(state) {
      state.sidos = [{ value: null, text: "선택하시오" }];
    },
    CLEAR_GUGUN_LIST(state) {
      state.guguns = [{ value: null, text: "선택하시오" }];
    },
  },
  actions: {
    getSido({ commit }) {
      http
        .get("/map/sido")
        .then((response) => {
          commit("GET_SIDO_LIST", response.data);
        })
        .catch((e) => {
          console.log(e);
        });
    },
    getGugun({ commit }, sidoCode) {
      const params = { sido: sidoCode };
      http
        .get(`/map/gugun`, { params })
        .then((response) => {
          console.log(response.data);
          commit("GET_GUGUN_LIST", response.data);
        })
        .catch((e) => {
          console.log(e);
        });
    },
    getHouseList({ commit }, gugunCode) {
      const SERVICE_URL = "http://openapi.molit.go.kr:8081/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTrade?_wadl&type=xml";
      const SERVICE_KEY = "g2YolZT8Qlmg232vIn7dgpwIHTLl5GYo9vZA1NTlba1ChIjreZLGg%2Bn9r%2BjXDpkCqB0M6pJIPC7L1MHAJiqglA%3D%3D";
      const params = {
        LAWD_CD: gugunCode,
        DEAL_YMD: "202110",
        serviceKey: decodeURIComponent(SERVICE_KEY),
      };
      http
        .get(SERVICE_URL, { params })
        .then((response) => {
          console.log(commit, response.data);
          // commit("GET_GUGUN_LIST", response.data);
        })
        .catch((e) => {
          console.log(e);
        });
    },
  },
  modules: {},
});
