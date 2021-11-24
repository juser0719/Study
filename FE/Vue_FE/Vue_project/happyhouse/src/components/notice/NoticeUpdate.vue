<template>
  <b-container class="bv-example-row mt-3">
    <b-row>
      <b-col>
        <b-alert show><h3>글수정</h3></b-alert>
      </b-col>
    </b-row>
    <qna-write-form type="modify" />
  </b-container>
</template>

<script>
import QnaWriteForm from "@/components/notice/child/NoticeWriteForm.vue";

export default {
  name: "NoticeUpdate",
  components: {
    QnaWriteForm,
  },
};
</script>

<style></style>
