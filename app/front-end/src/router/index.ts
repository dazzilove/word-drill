import Vue from 'vue';
import VueRouter, { RouteConfig } from 'vue-router';
import Main from '../views/Main.vue';

Vue.use(VueRouter);

const routes: RouteConfig[] = [
  {
    path: '/',
    name: 'Main',
    component: Main,
  },
  {
    path: '/about',
    name: 'About',
    component: () => import('@/views/About.vue'),
  },
  {
    path: '/word/form',
    name: 'WordForm',
    component: () => import('@/views/wordMng/WordForm.vue'),
  },
  {
    path: '/word/list',
    name: 'WordList',
    component: () => import('@/views/wordMng/WordList.vue'),
  },
  {
      path: '/testSheet/list',
      name: 'TestSheetList',
      component: () => import('@/views/testSheetMng/TestSheetList.vue'),
  },
  {
      path: '/testSheet/form',
      name: 'TestSheetForm',
      component: () => import('@/views/testSheetMng/TestSheetForm.vue'),
  },
];

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes,
});

export default router;
