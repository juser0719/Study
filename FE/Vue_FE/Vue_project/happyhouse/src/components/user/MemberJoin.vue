<template>
  <b-container class="bv-example-row mt-3">
    <section>
      <b-row>
        <b-col>
          <b-alert variant="secondary" show><h3>회원가입</h3></b-alert>
        </b-col>
      </b-row>
      <b-field label="아이디">
        <b-input
          name="id"
          v-model="id"
          placeholder="아이디를 입력하세요."
        ></b-input>
      </b-field>

      <b-field label="비밀번호">
        <b-input
          type="password"
          value=""
          name="pw"
          v-model="pw"
          placeholder="비밀번호를 입력하세요."
          password-reveal
        >
        </b-input>
      </b-field>

      <b-field label="이름">
        <b-input
          name="name"
          v-model="name"
          placeholder="이름을 입력하세요."
        ></b-input>
      </b-field>

      <b-field label="전화번호">
        <b-input
          type="tel"
          name="tel"
          v-model="phoneNum"
          value=""
          placeholder="전화번호를 입력하세요."
        >
        </b-input>
      </b-field>

      <b-field label="Email">
        <b-input
          type="email"
          name="email"
          v-model="email"
          value=""
          placeholder="이메일을 입력하세요."
        >
        </b-input>
      </b-field>

      <b-field label="주소">
        <b-input
          maxlength="100"
          name="address"
          v-model="address"
          type="text"
          placeholder="ex. 대전광역시"
        ></b-input>
      </b-field>

      <b-field label="상세 주소">
        <b-input
          maxlength="100"
          name="address_detail"
          v-model="addressDetail"
          type="textarea"
          placeholder="ex. 유성구 봉명동"
        ></b-input>
      </b-field>

      <b-button
        @click="joinMember()"
        type="submit"
        name="button"
        variant="is-primary"
        >회원 가입</b-button
      >
    </section>
  </b-container>
</template>

<script>
import http from "@/util/http-common";
export default {
  name: "MemberJoin",
  data() {
    return {
      id: "",
      pw: "",
      name: "",
      phoneNum: "",
      email: "",
      address: "",
      addressDetail: "",
      submitted: false,
      loading: true,
      errored: false,
    };
  },
  methods: {
    joinMember() {
      if (this.id == "") {
        alert("아이디를 입력하세요.");
        return;
      }
      if (this.pw == "") {
        alert("비밀번호를 입력하세요.");
        return;
      }
      if (this.name == "") {
        alert("이름을 입력하세요.");
        return;
      }
      if (this.phoneNum == "") {
        alert("전화번호를 입력하세요.");
        return;
      }
      if (this.email == "") {
        alert("이메일을 입력하세요.");
        return;
      }
      if (this.address == "") {
        alert("주소를 입력하세요.");
        return;
      }
      if (this.addressDetail == "") {
        alert("상세 주소를 입력하세요.");
        return;
      }
      http
        .post("member/join", {
          id: this.id,
          pw: this.pw,
          name: this.name,
          email: this.email,
          phoneNum: this.phoneNum,
          address: this.address,
          addressDetail: this.addressDetail,
        })
        .then((response) => {
          if (response.data.state == "succ") {
            alert("회원 가입이 완료 되었습니다.");
            this.$router.push("/");
          } else {
            alert("중복된 아이디 값입니다.");
          }
        });
      this.submitted = true;
    },
  },
};
</script>

<style scoped>
section {
  width: 50%;
  padding-top: 5%;
  margin: 0 auto;
}
</style>
