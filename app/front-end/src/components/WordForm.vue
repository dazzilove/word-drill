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
      <v-icon small>mdi-wrench</v-icon>
      <v-icon small>mdi-edit</v-icon>
      ddd
      <v-awesome-icon name="edit"/>
      <v-awesome-icon name="coffee" />
      <v-awesome-icon name="sync" spin/>
      <v-awesome-icon name="flag"/>
      <v-awesome-icon name="comment" flip="horizontal"/>
      <v-awesome-icon name="code-branch" label="Forked Repository"/>
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
  public isEditing: boolean = true;
  public hasSaved: boolean = false;

  public save() {
    alert('save');
  }
}
</script>