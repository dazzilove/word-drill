<template>
  <v-app>
    <v-app-bar app floating dark color="blue">
      <v-app-bar-nav-icon @click="goHome"></v-app-bar-nav-icon>
      <v-toolbar-title>Word Drill</v-toolbar-title>
    </v-app-bar>
    <v-main>
      <router-view/>
    </v-main>
  </v-app>
</template>

<script lang="ts">
import Vue from 'vue';

export default Vue.extend({
  name: 'App',
  data: () => ({
    //
  }),
  methods: {
    goHome() {
      this.$router.push('/');
    },
  },
});
</script>
