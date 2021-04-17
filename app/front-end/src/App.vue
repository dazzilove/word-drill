<template>
  <v-app id="inspire">
    <v-navigation-drawer v-model="drawer" app>
      <LeftMenu />
    </v-navigation-drawer>
    <v-app-bar app dark color="blue">
      <v-app-bar-nav-icon @click="drawer = !drawer"></v-app-bar-nav-icon>
      <v-toolbar-title>Word Drill</v-toolbar-title>
    </v-app-bar>
    <v-main>
      <router-view/>
    </v-main>
  </v-app>
</template>

<script lang="ts">
import Vue from 'vue';
import LeftMenu from '@/views/LeftMenu.vue';

export default Vue.extend({
  name: 'App',
    components: { LeftMenu },
  data: () => ({ drawer: null }),
  methods: {
    goHome() {
      this.$router.push('/');
    },
  },
});
</script>
