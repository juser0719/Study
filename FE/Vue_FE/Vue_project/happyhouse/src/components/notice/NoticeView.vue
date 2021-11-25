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
          :header-html="`<h3>${notice.noticeno}.
          ${notice.subject} [${notice.hit}]</h3><div><h6>${notice.userid}</div><div>${notice.regtime}</h6></div>`"
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
    <!-- 도서정보 상세보기 Component -->
    <comment-write :noticeno="this.noticeno" />
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
  </b-container>
</template>

<script>
import { getArticle, deleteArticle } from "@/api/notice";
import { getComment } from "@/api/comment.js";
import { mapGetters } from "vuex";
import CommentWrite from "@/components/notice/comment/CommentWrite.vue";
import Comment from "@/components/notice/comment/Comment.vue";

export default {
  name: "NoticeView",
  components: {
    CommentWrite,
    Comment,
  },
  data() {
    return {
      notice: {},
      noticeno: "",
      comments: [],
      isModifyShow: false,
      modifyComment: Object,
    };
  },
  computed: {
    message() {
      if (this.notice.content)
        return this.notice.content.split("\n").join("<br>");
      return "";
    },

    ...mapGetters(["comments"]),
  },
  watch: {
    comments: function () {
      this.listComment();
    },
  },
  created() {
    getArticle(
      Number(this.$route.params.noticeno),
      (response) => {
        this.notice = response.data;
      },
      (error) => {
        console.log("삭제시 에러발생!!", error);
      }
    );
    this.listComment();
    // url이 query에서 noticeno 얻기.
    this.noticeno = this.$route.query.noticeno;
    // 도서평(댓글) 얻기.
    this.$store.dispatch("getComments", `/comment/${this.noticeno}`);
  },
  methods: {
    listArticle() {
      this.$router.push({ name: "NoticeList" });
    },
    listComment() {
      getComment(
        Number(this.$route.params.noticeno),
        (response) => {
          this.comments = response.data;
        },
        (error) => {
          console.log("댓글 불러오기 에러! ", error);
        }
      );
    },
    moveModifyArticle() {
      this.$router.replace({
        name: "NoticeUpdate",
        params: { noticeno: this.notice.noticeno },
      });
      //   this.$router.push({ path: `/board/modify/${this.article.articleno}` });
    },
    removeArticle() {
      if (confirm("정말로 삭제?")) {
        deleteArticle(this.notice.noticeno, () => {
          this.$router.push({ name: "NoticeList" });
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
