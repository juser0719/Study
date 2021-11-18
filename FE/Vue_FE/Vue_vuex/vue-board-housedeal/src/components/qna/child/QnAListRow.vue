<template>
  <b-tr>
    <b-td>{{ qnAno }}</b-td>
    <b-th class="text-left">
      <router-link :to="{ name: 'QnAView', params: { qnAno: qnAno } }">{{
        subject
      }}</router-link>
    </b-th>
    <b-td>{{ hit }}</b-td>
    <b-td>{{ userid }}</b-td>
    <b-td>{{ regtime }}</b-td>
  </b-tr>
</template>

<script>
// import moment from "moment";

export default {
  name: "QnAListRow",
  props: {
    qnAno: Number,
    userid: String,
    subject: String,
    hit: Number,
    regtime: String,
  },
  computed: {},
  created() {
    console.log(this.props);
  },
};
</script>

<style></style>
