<template>
  <b-container class="mt-4" v-if="userInfo">
    <b-row>
      <b-col>
        <b-alert variant="secondary" show><h3>내정보</h3></b-alert>
      </b-col>
    </b-row>
    <b-row>
      <b-col></b-col>
      <b-col cols="8">
        <b-jumbotron>
          <template #header>My Page</template>

          <template #lead> 내 정보 수정페이지입니다. </template>

          <hr class="my-4" />

          <b-container class="mt-4">
            <b-form class="form-horizontal">
              <b-row class="col-8 offset-4"> </b-row>
              <b-row class="form-group row">
                <b-col class="col-form-label col-4">이름</b-col>
                <b-row class="col-8">
                  <b-row id="username" type="text" class="form-control">{{
                    this.userInfo.username
                  }}</b-row>
                </b-row>
              </b-row>
              <b-row class="form-group row">
                <b-col class="col-form-label col-4">아이디</b-col>
                <b-row class="col-8">
                  <b-row id="userid" type="text" class="form-control">{{
                    this.userInfo.userid
                  }}</b-row>
                  <!-- <b-alert show variant="danger" v-if="this.user.ispwdchecked"
              >아이디가 존재합니다.</b-alert
            > -->
                </b-row>
              </b-row>
              <b-row class="form-group row">
                <b-col class="col-form-label col-4">비밀번호</b-col>
                <b-row class="col-8">
                  <b-form-input
                    id="userpwd"
                    v-model="user.userpwd"
                    type="password"
                    class="form-control"
                    @keyup="checkpwd"
                    name="userPwd"
                    placeholder="영문 숫자 포함 5자리 이상"
                    minlength="5"
                    required="required"
                  />
                </b-row>
              </b-row>
              <b-row class="form-group row">
                <b-col class="col-form-label col-4">비밀번호확인</b-col>
                <b-row class="col-8">
                  <b-form-input
                    id="userpwdcheck"
                    v-model="user.userpwdcheck"
                    type="password"
                    class="form-control"
                    @keyup="checkpwd"
                    placeholder="영문 숫자 포함 5자리 이상"
                    minlength="5"
                    required="required"
                  />
                  <b-alert show variant="danger" v-if="this.join.ispwdchecked"
                    >비밀번호가 일치하지 않습니다.</b-alert
                  >
                </b-row>
              </b-row>
              <b-row class="form-group row">
                <b-col class="col-form-label col-4">이메일</b-col>
                <b-row class="col-8">
                  <b-form-input
                    v-model="user.email"
                    type="text"
                    class="form-control"
                    name="email"
                    placeholder="email"
                    required="required"
                  />
                </b-row>
              </b-row>
              <b-row class="form-group row">
                <b-col class="col-form-label col-4">전화번호</b-col>
                <b-row class="col-8">
                  <b-form-input
                    type="tel"
                    class="form-control"
                    name="tel"
                    placeholder="010-****-****"
                    required="required"
                  />
                </b-row>
              </b-row>

              <b-row class="form-group row">
                <b-row class="col-4 offset-4"> </b-row>
              </b-row>
            </b-form>
          </b-container>
          <hr class="my-4" />

          <b-button variant="primary" @click="update" @class="mr - 1"
            >정보수정</b-button
          >
        </b-jumbotron>
      </b-col>
      <b-col></b-col>
    </b-row>
  </b-container>
</template>

<script>
import { mapState, mapActions, mapMutations } from "vuex";

const memberStore = "memberStore";

export default {
  name: "MemberUpdate",
  data() {
    return {
      user: {
        username: null,
        userid: null,
        userpwd: null,
        userpwdcheck: null,
        email: null,
        userph: null,
      },
      join: {
        ispwdchecked: true,
      },
    };
  },
  computed: {
    ...mapState(memberStore, ["isLogin", "isLoginError", "userInfo"]),
  },

  methods: {
    ...mapMutations(memberStore, ["SET_IS_LOGIN", "SET_USER_INFO"]),
    ...mapActions(memberStore, ["userConfirm", "getUserInfo", "updateMember"]),

    //폼에 입력된 수정 내용으로 db업데이트
    async update() {
      if (this.join.ispwdchecked) {
        alert("비밀번호 확인!!!");
        return;
      }
      this.user.username = this.userInfo.username;
      this.user.userid = this.userInfo.userid;
      this.updateMember(this.user);
      let token = sessionStorage.getItem("access-token");
      alert("회원정보수정 성공!");
      if (this.isLogin) {
        await this.getUserInfo(token);
        this.$router.push({ name: "MyPage" });
      }
      // console.log(this.user);
    },

    checkpwd() {
      if (this.user.userpwd == this.user.userpwdcheck) {
        this.join.ispwdchecked = false;
      } else {
        this.join.ispwdchecked = true;
      }
    },

    movePage() {
      this.$router.push({ name: "SignUp" });
    },
  },
};
</script>

<style>
.form-control {
  border-color: #eee;
  min-height: 41px;
  box-shadow: none !important;
}

.form-control:focus {
  border-color: #5cd3b4;
}

.form-control,
.btn {
  border-radius: 3px;
}

.signup-form {
  margin: 0 auto;
  padding: 30px 0;
}

.signup-form h2 {
  color: #333;
  margin: 0 0 30px 0;
  display: inline-block;
  padding: 0 30px 10px 0;
  border-bottom: 3px solid #5cd3b4;
}

.signup-form form {
  color: #999;
  border-radius: 3px;
  margin-bottom: 15px;
  background: #fff;
  box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
  padding: 30px;
}

.signup-form .form-group row {
  margin-bottom: 20px;
}

.signup-form label {
  font-weight: normal;
  font-size: 14px;
  line-height: 2;
}

.signup-form input[type="checkbox"] {
  position: relative;
  top: 1px;
}

.signup-form .btn {
  font-size: 16px;
  font-weight: bold;
  background: #5cd3b4;
  border: none;
  margin-top: 20px;
  min-width: 140px;
}

.signup-form .btn:hover,
.signup-form .btn:focus {
  background: #41cba9;
  outline: none !important;
}

.signup-form a {
  color: #5cd3b4;
  text-decoration: underline;
}

.signup-form a:hover {
  text-decoration: none;
}

.signup-form form a {
  color: #5cd3b4;
  text-decoration: none;
}

.signup-form form a:hover {
  text-decoration: underline;
}
</style>
