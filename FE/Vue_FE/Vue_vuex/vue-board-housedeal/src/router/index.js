import Vue from "vue";
import VueRouter from "vue-router";
import Home from "@/views/Home.vue";
import Instargram from "@/views/Instargram.vue";

import Member from "@/views/Member.vue";
import MemberLogin from "@/components/user/MemberLogin.vue";
import MemberJoin from "@/components/user/MemberJoin.vue";

import QnA from "@/views/QnA.vue";
import QnAList from "@/components/qna/QnAList.vue";
import QnAWrite from "@/components/qna/QnAWrite.vue";
import QnAView from "@/components/qna/QnAView.vue";
import QnAUpdate from "@/components/qna/QnAUpdate.vue";
import QnADelete from "@/components/qna/QnADelete.vue";

import Board from "@/views/Board.vue";
import BoardList from "@/components/board/BoardList.vue";
import BoardWrite from "@/components/board/BoardWrite.vue";
import BoardView from "@/components/board/BoardView.vue";
import BoardUpdate from "@/components/board/BoardUpdate.vue";
import BoardDelete from "@/components/board/BoardDelete.vue";

import House from "@/views/House.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/instargram",
    name: "Instargram",
    component: Instargram,
  },
  {
    path: "/user",
    name: "Member",
    component: Member,
    children: [
      {
        path: "singin",
        name: "SignIn",
        component: MemberLogin,
      },
      {
        path: "singup",
        name: "SignUp",
        component: MemberJoin,
      },
    ],
  },
  {
    path: "/board",
    name: "Board",
    component: Board,
    redirect: "/board/list",
    children: [
      {
        path: "list",
        name: "BoardList",
        component: BoardList,
      },
      {
        path: "write",
        name: "BoardWrite",
        component: BoardWrite,
      },
      {
        path: "detail/:articleno",
        name: "BoardView",
        component: BoardView,
      },
      {
        path: "update/:articleno",
        name: "BoardUpdate",
        component: BoardUpdate,
      },
      {
        path: "delete/:articleno",
        name: "BoardDelete",
        component: BoardDelete,
      },
    ],
  },
  {
    path: "/qna",
    name: "QnA",
    component: QnA,
    redirect: "/qna/list",
    children: [
      {
        path: "list",
        name: "QnAList",
        component: QnAList,
      },
      {
        path: "write",
        name: "QnAWrite",
        component: QnAWrite,
      },
      {
        path: "detail/:qnano",
        name: "QnAView",
        component: QnAView,
      },
      {
        path: "update/:qnano",
        name: "QnAUpdate",
        component: QnAUpdate,
      },
      {
        path: "delete/:qnano",
        name: "QnADelete",
        component: QnADelete,
      },
    ],
  },
  {
    path: "/house",
    name: "House",
    component: House,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
