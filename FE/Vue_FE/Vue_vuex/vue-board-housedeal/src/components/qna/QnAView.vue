<template>
  <b-container class="bv-example-row mt-3">
    <b-row>
      <b-col>
        <b-alert show><h3>글보기</h3></b-alert>
      </b-col>
    </b-row>
    <b-row class="mb-1">
      <b-col class="text-left">
        <b-button variant="outline-primary" @click="listArticle">목록</b-button>
      </b-col>
      <b-col class="text-right">
        <b-button
          variant="outline-info"
          size="sm"
          @click="moveModifyArticle"
          class="mr-2"
          >글수정</b-button
        >
        <b-button variant="outline-danger" size="sm" @click="deleteArticle"
          >글삭제</b-button
        >
      </b-col>
    </b-row>
    <b-row class="mb-1">
      <b-col>
        <b-card
          :header-html="`<h3>${article.qnAno}.
          ${article.subject} [${article.hit}]</h3><div><h6>${article.userid}</div><div>${article.regtime}</h6></div>`"
          class="mb-2"
          border-variant="dark"
          no-body
        >
          <b-card-body class="text-left">
            <div v-html="message"></div>
          </b-card-body>
        </b-card>
      </b-col>
    </b-row>
    <!-- comment -->
    <!-- <comment-write :isbn="this.isbn" /> -->
    <comment-write :qnAno="article.qnAno" />
    <comment-write
      v-if="isModifyShow && this.modifyComment != null"
      :modifyComment="this.modifyComment"
      @modify-comment-cancel="onModifyCommentCancel"
    />
    <comment
      v-for="(comment, index) in comments"
      :key="index"
      :comment="comment"
      @modify-comment="onModifyComment"
    />
    <!--  -->
  </b-container>
</template>

<script>
// import moment from "moment";
import http from "@/util/http-common";
import Comment from "./child/Comment.vue";
import CommentWrite from "./child/CommentWrite.vue";
export default {
  components: {
    Comment,
    CommentWrite,
  },
  data() {
    return {
      article: {},
      comments: {},
      qnAno: "",
      isModifyShow: false,
      modifyComment: Object,
    };
  },
  computed: {
    message() {
      if (this.article.content)
        return this.article.content.split("\n").join("<br>");
      return "";
    },
  },
  created() {
    this.qnAno = this.article.qnAno;

    http.get(`/qna/${this.$route.params.qnAno}`).then(({ data }) => {
      this.article = data;
      console.log(data);
    });
    http.get(`/comment/${this.$route.params.qnAno}`).then(({ data }) => {
      this.comments = data;
    });
  },
  methods: {
    listArticle() {
      this.$router.push({ name: "QnAList" });
    },
    moveModifyArticle() {
      this.$router.replace({
        name: "QnAUpdate",
        params: { qnAno: this.article.qnAno },
      });
    },
    deleteArticle() {
      if (confirm("정말로 삭제?")) {
        this.$router.replace({
          name: "QnADelete",
          params: { qnAno: this.article.qnAno },
        });
      }
    },
    onModifyComment(comment) {
      this.modifyComment = comment;
      this.isModifyShow = true;
    },
    onModifyCommentCancel(isShow) {
      this.isModifyShow = isShow;
    },
  },
};
</script>

<style></style>
