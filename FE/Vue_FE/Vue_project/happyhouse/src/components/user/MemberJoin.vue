<template>
  <!-- ======= Hero Section ======= -->
  <b-container id="hero" style="background-image: none">
    <b-row class="signup-form">
      <b-form class="form-horizontal">
        <b-row class="col-8 offset-4">
          <h2>회원 가입</h2>
        </b-row>
        <b-row class="form-group row">
          <b-col class="col-form-label col-4">이름</b-col>
          <b-row class="col-8">
            <b-form-input
              id="username"
              v-model="user.username"
              type="text"
              class="form-control"
              placeholder="User Name"
              required
            />
          </b-row>
        </b-row>
        <b-row class="form-group row">
          <b-col class="col-form-label col-4">아이디</b-col>
          <b-row class="col-8">
            <b-form-input
              id="userid"
              v-model="user.userid"
              type="text"
              class="form-control"
              @keyup="idcheck"
              required
            />
            <!-- <b-alert show variant="danger" v-if="this.user.ispwdchecked"
              >아이디가 존재합니다.</b-alert
            > -->
            <b-row id="idresult" class="mt-1">{{ join.idcheck }}</b-row>
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
              placeholder="영문 숫자 포함 5자리 이상"
              minlength="5"
              required="required"
              @keyup="checkpwd"
            />
            <b-alert show variant="danger" v-if="this.join.ispwdchecked"
              >비밀번호가 일치하지 않습니다.</b-alert
            >
          </b-row>
        </b-row>
        <b-row class="form-group row">
          <b-col class="col-form-label col-4">주소</b-col>
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
          <b-row class="col-4 offset-4">
            <b-button
              type="button"
              class="btn btn-primary btn-lg"
              @click="register"
              >등록 &nbsp; &#10003;</b-button
            >
          </b-row>
        </b-row>
      </b-form>
    </b-row>
  </b-container>
</template>

<script>
import { mapState, mapActions } from "vuex";
const memberStore = "memberStore";

export default {
  name: "MemberJoin",
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
        idcheck: "",
        idlengthchecked: false,
        ispwdchecked: true,
      },
    };
  },
  computed: {
    ...mapState(memberStore, [
      "isLogin",
      "isLoginError",
      "isRegisterd",
      "idChecked",
    ]),
  },
  methods: {
    ...mapActions(memberStore, [
      "regiterUser",
      "userConfirm",
      "getUserInfo",
      "idCheck",
    ]),
    async register() {
      if (!this.user.username) {
        alert("이름 입력!!!");
        return;
      } else if (!this.idChecked || !this.join.idlengthchecked) {
        alert("아이디 확인!!!");
        return;
      } else if (this.join.ispwdchecked) {
        alert("비밀번호 확인!!!");
        return;
      } else {
        await this.regiterUser(this.user);
        if (this.isRegisterd) {
          alert("회원가입성공!!!");
          this.movePage();
        } else alert("회원가입 실패!!!");
      }
    },
    checkpwd() {
      if (this.user.userpwd == this.user.userpwdcheck) {
        this.join.ispwdchecked = false;
      } else {
        this.join.ispwdchecked = true;
      }
    },
    async idcheck() {
      var ckid = this.user.userid;
      if (ckid.length < 6 || ckid.length > 16) {
        this.join.idcheck = "아이디는 6자이상 16자이하입니다.";
        this.join.idlengthchecked = false;
      } else {
        this.join.idcheck = null;
        this.join.idlengthchecked = true;
        await this.idCheck(this.user.userid);
        if (this.idChecked) {
          this.join.idcheck = "";
          console.log(this.idChecked);
        } else {
          this.join.idcheck = "해당 아이디는 존재합니다.";
          console.log(this.idChecked);
        }
      }
    },

    movePage() {
      this.$router.push({ name: "SignIn" });
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
