<template>
  <v-container>
    <template>
      <v-card outlined class="overflow-hidden">
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
                <v-card style="margin-top:8px;"
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
                            v-for="(wordExample, exIndex) in mean.wordExamples" v-bind:key="exIndex">
                      <v-card-text>
                        <v-card class="d-flex flex-row-reverse" flat tile>
                          <v-btn x-small color="secondary" dark @click="delWordExample(meanIndex, exIndex)" >del</v-btn>
                          <v-btn x-small color="secondary" dark @click="addWordExample(meanIndex)" class="mx-1">add</v-btn>
                        </v-card>
                        <v-text-field
                                label="Sentence"
                                v-model="wordExample.sentence"
                        ></v-text-field>
                        <v-text-field
                                label="Translate"
                                v-model="wordExample.translate"
                        ></v-text-field>
                      </v-card-text>
                    </v-card>
                  </v-card-text>
                </v-card>
              </v-col>
            </v-row>
          </v-card-text>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn small outlined @click="cancel">Cancel</v-btn>
            <v-btn small outlined color="primary" @click="save">Save</v-btn>
          </v-card-actions>
          <v-snackbar
                  v-model="hasSaved"
                  absolute
                  centered
          >
            {{ message }}
            <template v-slot:action="{ attrs }">
              <v-btn
                      color="blue"
                      text
                      v-bind="attrs"
                      @click="goWordListPage"
              >
                Close
              </v-btn>
            </template>
          </v-snackbar>
        </v-form>
      </v-card>
    </template>
  </v-container>
</template>

<script lang="ts">
    import { Component, Vue } from 'vue-property-decorator';
    import AxiosService from '@/service/axios.service';
    import AxiosResponse from '@/service/axios.service';

    interface WordExample {
        sentence: string;
        translate: string;
    }

    interface MeanList {
        part: string;
        mean: string;
        wordExamples: WordExample[];
    }

    @Component
    export default class WordForm extends Vue {
        public isEditing: boolean = true;
        public hasSaved: boolean = false;
        public message: string = '';
        public langCodes: string[] = ['English', 'Japanese'];
        public parts: string[] = ['noun', 'verb', 'abjective', 'adverb'];

        public langCode: string = '';
        public word: string = '';
        public meanList: MeanList[] = [];

        public created() {
            this.meanList = [{part: '', mean: '', wordExamples: [{sentence: '', translate: ''}]}];
        }

        public addMean() {
            this.meanList.push({part: '', mean: '', wordExamples: [{sentence: '', translate: ''}]});
        }

        public delMean(meanIndex: number) {
            this.meanList = this.meanList.filter((item, vIndex) => vIndex !== meanIndex);
        }

        public addWordExample(meanIndex: number) {
            this.meanList[meanIndex].wordExamples.push({sentence: '', translate: ''});
        }

        public delWordExample(meanIndex: number, exIndex: number) {
            this.meanList[meanIndex].wordExamples
                = this.meanList[meanIndex].wordExamples.filter((item, vIndex) => vIndex !== exIndex);
        }

        public cancel() {
            this.$router.push('/');
        }

        public goWordListPage() {
            this.hasSaved = false;
            this.$router.push('/word/list');
        }

        public async save() {
            const params = {
                langCode: this.langCode,
                word: this.word,
                means: this.meanList,
            };
            const response: AxiosResponse = await AxiosService.instance.post('/api/word', params);
            if (response.status === 200) {
                this.message = '성공적으로 저장했습니다.';
            } else {
                this.message = '저장에 실패했습니다.';
            }
            this.hasSaved = true;
        }
    }
</script>