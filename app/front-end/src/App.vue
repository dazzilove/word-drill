<template>
  <v-app>
    <v-app-bar app flat dense floating color="white">
      <div class="d-flex align-center">
        <v-icon middle>mdi-home</v-icon>
        <div>Word Drill</div>
      </div>
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
});
</script>
