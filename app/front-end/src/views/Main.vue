<template>
  <v-container>
    <div>Main Page</div>
    <v-list-item>
      <v-list-item-content>
        <v-list-item-title><router-link to="/word/form">Add Word</router-link></v-list-item-title>
        <v-list-item-title><router-link to="/word/list">Word List</router-link></v-list-item-title>
      </v-list-item-content>
    </v-list-item>
  </v-container>
</template>    

<script lang="ts">
import Vue from 'vue';
import Component from 'vue-class-component';

@Component
export default class Main extends Vue {

}
</script>