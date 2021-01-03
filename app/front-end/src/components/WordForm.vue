<template>
  <v-container>
<template>
  <v-card class="overflow-hidden">
    <v-form ref="form">
      <v-toolbar flat dense dark>
        <v-awesome-icon name="edit" />
        <v-toolbar-title class="font-weight-light mx-2">
          Add Word
        </v-toolbar-title>
      </v-toolbar>
      <v-card-text>
        <v-row>
          <v-col cols="12">
            <h3>Word</h3>
            <v-select
              :items="langCodes"
              label="Language"
              v-model="langCode"
            ></v-select>
            <v-text-field
              label="Word"
              v-model="word"
            ></v-text-field>
          </v-col>
          <v-col cols="12">
            <h3>Means</h3>
            <v-card outlined style="margin-top:8px;" 
               v-for="(mean, meanIndex) in meanList" :key="meanIndex">
              <v-card-text>
                <v-card class="d-flex flex-row-reverse" flat tile>
                    <v-btn fab outlined dark x-small color="blue">
                      <v-awesome-icon name="plus" @click="addMean" />
                    </v-btn>
                    <v-btn class="mx-1" fab outlined dark x-small color="pink">
                      <v-awesome-icon name="minus" @click="delMean(meanIndex)" />
                    </v-btn>    
                </v-card>
                <v-select
                  :items="parts"
                  label="Part of Speech"
                  v-model="mean.part"
                ></v-select>
                <v-text-field
                  label="Mean"
                  v-model="mean.mean"
                ></v-text-field>
                <h4>Examples</h4>
                <v-card outlined style="margin-top:10px;" 
                  v-for="(example, exIndex) in mean.examples" v-bind:key="exIndex">
                  <v-card-text>
                    <v-card class="d-flex flex-row-reverse" flat tile>
                      <v-btn x-small color="secondary" dark @click="delExample(meanIndex, exIndex)" >del</v-btn>
                      <v-btn x-small color="secondary" dark @click="addExample(meanIndex)" class="mx-1">add</v-btn>
                    </v-card>
                    <v-text-field
                      label="Sentence"
                      v-model="example.sentence"
                    ></v-text-field>
                    <v-text-field
                      label="Translate"
                      v-model="example.translate"
                    ></v-text-field>
                  </v-card-text>
                </v-card>
              </v-card-text>
              <v-card-text>
              </v-card-text>
            </v-card>
          </v-col>
        </v-row>
      </v-card-text>
      <v-divider></v-divider>
      <v-card-actions>
        <v-spacer></v-spacer>
        <v-btn @click="cancel">Cancel</v-btn>
        <v-btn color="success" @click="save">Save</v-btn>
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


    </v-form>
  </v-card>
</template>
  </v-container>
</template>    

<script lang="ts">
import Vue from 'vue';
import Component from 'vue-class-component';

interface Example {
  sentence: string;
  translate: string;
}

interface MeanList {
  part: string;
  mean: string;
  examples: Example[];
}

@Component
export default class WordForm extends Vue {
  public isEditing: boolean = true;
  public hasSaved: boolean = false;
  public langCodes: string[] = ['English', 'Japanese'];
  public parts: string[] = ['noun', 'verb', 'abjective', 'adverb'];

  public langCode: string = '';
  public word: string = '';
  public meanList: MeanList[] = [];

  public created() {
    this.meanList = [{part: '', mean: '', examples: [{sentence: '', translate: ''}]}];
  }

  public addMean() {
    this.meanList.push({part: '', mean: '', examples: [{sentence: '', translate: ''}]});
  }

  public delMean(meanIndex: number) {
    this.meanList = this.meanList.filter((item, vIndex) => vIndex !== meanIndex);
  }

  public addExample(meanIndex: number) {
    this.meanList[meanIndex].examples.push({sentence: '', translate: ''});
  }

  public delExample(meanIndex: number, exIndex: number) {
    this.meanList[meanIndex].examples = this.meanList[meanIndex].examples.filter((item, vIndex) => vIndex !== exIndex);
  }

  public cancel() {
    this.$router.push('/');
  }

  public save() {
    alert('save');
  }
}
</script>