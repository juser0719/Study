const router = new VueRouter({
    routes: [
        { path: '/', component: list },
        { path: '/detail/:id', component: detail }
    ]
});
