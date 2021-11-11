import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import Login from "../views/Login.vue";
import Board from "../views/Board.vue";
import BoardList from "../components/board/BoardList.vue";
import BoardWrite from "../components/board/BoardWrite.vue";
import BoardView from "../components/board/BoardView.vue";
import BoardModify from "../components/board/BoardModify.vue";
import BoardDelete from "../components/board/BoardDelete.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/login",
    name: "Login",
    component: Login,
  },
  {
    path: "/board",
    name: "Board",
    component: Board,
    redirect: "/board/list",
    children: [
      {
        path: "/list",
        name: "BoardList",
        component: BoardList,
      },
      {
        path: "/register",
        name: "BoardWrite",
        component: BoardWrite,
      },
      {
        path: "/view/:no",
        name: "BoardView",
        component: BoardView,
      },
      {
        path: "/update/:no",
        name: "BoardModify",
        component: BoardModify,
      },
      {
        path: "/delete/:no",
        name: "BoardDelete",
        component: BoardDelete,
      },
    ],
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
