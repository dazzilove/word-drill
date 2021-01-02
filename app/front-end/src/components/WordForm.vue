<template>
  <v-container>
<template>
  <v-card class="overflow-hidden">
    <v-toolbar flat color="grey lighten-1">
      <v-icon>mdi-account</v-icon>
      <v-toolbar-title class="font-weight-light">
        Word Form
      </v-toolbar-title>
    </v-toolbar>
    <v-card-text>
      card text area
    </v-card-text>
    <v-divider></v-divider>
    <v-card-actions>
      <v-spacer></v-spacer>
      <v-btn
        :disabled="!isEditing"
        color="success"
        @click="save"
      >
        Save
      </v-btn>
    </v-card-actions>
    <v-snackbar
      v-model="hasSaved"
      :timeout="2000"
      absolute
      bottom
      left
    >
      Your profile has been updated
    </v-snackbar>
  </v-card>
</template>
  </v-container>
</template>    

<script lang="ts">
import Vue from 'vue';
import Component from 'vue-class-component';

@Component
export default class WordForm extends Vue {
  isEditing: Boolean = true;
  word: String = "";
  langDiv: String = "English";
}
</script>