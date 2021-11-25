import { getComment } from '@/api/comment.js'
const noticeStore = {
  namespaced: true,
  state: { comments: [] },
  getters: {
    comments(state) {
      return state.comments;
    }
  },
  mutations: {
    setComments(state, payload) {
      // state의 comments에 서버에서 얻어온 도서평 목록 세팅.
      state.comments = payload;
    }
  },
  actions: {
    getComments(context, payload) {
      getComment(payload, ({ data }) => {
        context.commit("setComments", data);
      });
    }
  },
};

export default noticeStore;
