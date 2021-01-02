<template>
  <v-app>
    <v-app-bar
      app
      color="primary"
      dark
    >
      <div class="d-flex align-center">Word Drill</div>
    </v-app-bar> 

    <v-main>
      <Main/>
    </v-main>
  </v-app>
</template>

<script lang="ts">
import Vue from 'vue';
import Main from './components/Main.vue';

export default Vue.extend({
  name: 'App',

  components: {
    Main,
  },

  data: () => ({
    //
  }),
});
</script>
