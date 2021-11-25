import { apiInstance } from "./index.js";

const api = apiInstance();

function listComment(param, success, fail) {
  api.get(`/comment`, { params: param }).then(success).catch(fail);
}

function writeComment(param, success, fail) {
  console.log(param);
  api.post(`/comment`, param).then(success).catch(fail);
}

function getComment(articleno, success, fail) {
  console.log(articleno);
  api.get(`/comment/${articleno}`).then(success).catch(fail);
}

function modifyComment(param, success, fail) {
  console.log(param)
  api.put(`/comment`, param).then(success).catch(fail);
}

function deleteComment(articleno, success, fail) {
  api.delete(`/comment/${articleno}`).then(success).catch(fail);
}

export { listComment, writeComment, getComment, modifyComment, deleteComment };
