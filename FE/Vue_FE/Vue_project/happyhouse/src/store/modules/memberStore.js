import jwt_decode from "jwt-decode";
import { login } from "@/api/member.js";
import { register } from "@/api/member.js";
import { deleteMember } from "@/api/member.js";
import { updateMember } from "@/api/member.js";
import { idCheck } from "@/api/member.js";
import { findById } from "../../api/member";

const memberStore = {
  namespaced: true,
  state: {
    isLogin: false,
    isLoginError: false,
    userInfo: null,
    idChecked: false,
    isRegisterd: false,
    isDeleted: false,
  },
  getters: {
    checkUserInfo: function (state) {
      return state.userInfo;
    },
  },
  mutations: {
    SET_IS_LOGIN: (state, isLogin) => {
      state.isLogin = isLogin;
    },
    SET_IS_LOGIN_ERROR: (state, isLoginError) => {
      state.isLoginError = isLoginError;
    },
    SET_USER_INFO: (state, userInfo) => {
      state.isLogin = true;
      state.userInfo = userInfo;
    },
    ///////////////////////////
    SET_IS_REGISTERED: (state, isregistered) => {
      state.isRegisterd = isregistered;
    },

    SET_IS_DELETED: (state, isdeleted) => {
      state.isDeleted = isdeleted;
    },

    SET_IS_IDCHECKED: (state, idChecked) => {
      state.idChecked = idChecked;
    },
  },
  actions: {
    async idCheck({ commit }, user) {
      await idCheck(
        user,
        (response) => {
          //응답이 성공이면
          console.log(response);
          if (response.data.idcount === "0") {
            commit("SET_IS_IDCHECKED", true);
          } else {
            commit("SET_IS_IDCHECKED", false);
          }
        },
        (error) => {
          console.log(error);
        }
      );
    },

    //회원등록
    async regiterUser({ commit }, user) {
      await register(
        user,
        (response) => {
          //응답이 성공이면
          if (response.data.message === "success") {
            commit("SET_IS_REGISTERED", true);
          } else {
            commit("SET_IS_REGISTERED", false);
          }
        },
        (error) => {
          console.log(error);
          console.log("등록실패");
          commit("SET_IS_REGISTERED", false);
        }
      );
    },

    //회원 삭제
    async deleteMember({ commit }, user) {
      await deleteMember(
        user,
        (response) => {
          if (response.data.message === "success") {
            commit("SET_IS_DELETED", true);
            commit("SET_IS_LOGIN", false);
            commit("SET_USER_INFO", null);
          } else {
            commit("SET_IS_DELETED", false);
            console.log("실패");
          }
        },
        (error) => {
          console.log(error);
          console.log("탈퇴실패");
          commit("SET_IS_DELETED", false);
        }
      );
    },

    //회원 수정
    async updateMember({ commit }, user) {
      await updateMember(
        user,
        (response) => {
          //응답이 성공이면
          if (response.data.message === "success") {
            commit("SET_IS_REGISTERED", true);
          } else {
            commit("SET_IS_REGISTERED", false);
          }
        },
        (error) => {
          console.log(error);
          console.log("수정실패");
          commit("SET_IS_REGISTERED", false);
        }
      );
    },

    async userConfirm({ commit }, user) {
      await login(
        user,
        (response) => {
          if (response.data.message === "success") {
            let token = response.data["access-token"];
            commit("SET_IS_LOGIN", true);
            commit("SET_IS_LOGIN_ERROR", false);
            sessionStorage.setItem("access-token", token);
          } else {
            commit("SET_IS_LOGIN", false);
            commit("SET_IS_LOGIN_ERROR", true);
          }
        },
        (error) => {
          console.log(error);
        }
      );
    },
    getUserInfo({ commit }, token) {
      let decode_token = jwt_decode(token);
      findById(
        decode_token.userid,
        (response) => {
          if (response.data.message === "success") {
            commit("SET_USER_INFO", response.data.userInfo);
          } else {
            console.log("유저 정보 없음!!");
          }
        },
        (error) => {
          console.log(error);
        }
      );
    },
  },
};

export default memberStore;
