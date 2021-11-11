<template>
  <div>
    <h1 class="underline">글 목록</h1>
    <div style="text-align: right">
      <button @click="movePage">글 등록</button>
    </div>
    <div v-if="articles.length">
      <table id="book-list">
        <colgroup>
          <col style="width: 5%" />
          <col style="width: 45%" />
          <col style="width: 25%" />
          <col style="width: 25%" />
        </colgroup>
        <thead>
          <tr>
            <th>글번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성일</th>
          </tr>
        </thead>
        <tbody>
          <board-list-row
            v-for="(article, index) in articles"
            :key="index"
            v-bind="article"
          ></board-list-row>
        </tbody>
      </table>
    </div>
    <div v-else class="text-center">게시글이 없습니다.</div>
  </div>
</template>

<script>
import http from "@/util/http-common.js";
import BoardListRow from "@/components/board/BoardListRow";

export default {
  name: "BoardList",
  components: {
    BoardListRow,
  },
  data() {
    return {
      articles: [],
    };
  },
  created() {
    http.get("/api/board").then(({ data }) => {
      this.articles = data;
    });
  },
  methods: {
    movePage() {
      this.$router.push({ name: "BoardWrite" });
    },
  },
};
</script>

<style></style>
