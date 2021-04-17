<template >
  <v-container>
    <v-card outlined elevation="0" class="mx-auto" style="margin-bottom:10px;">
      <v-card-text>
        <v-form ref="form">
          <v-row>
            <v-col cols="12" md="4">
              <v-select v-model="searchLangCode" :items="langCodes" label="langCode"></v-select>
            </v-col>
            <v-col cols="12" md="4">
              <v-text-field v-model="searchWord" label="word"></v-text-field>
            </v-col>
            <v-col cols="12" md="4">
              <v-text-field v-model="searchMean" label="mean"></v-text-field>
            </v-col>
            <v-col cols="12" md="4">
              <v-btn elevation="1" small outlined @click="handleClickSearch()">Search</v-btn>
            </v-col>
          </v-row>
        </v-form>
      </v-card-text>
    </v-card>
    <v-card outlined elevation="0" class="mx-auto">
      <div style="text-align: right; margin: 10px;">
        <v-btn
                elevation="1"
                @click="handleClickAddWord"
                small
                outlined>Add Word</v-btn>
      </div>
      <v-data-table
              :headers="headers"
              :items="datas"
              :items-per-page="5"
              class="elevation-1"
              :search="search"
              :custom-filter="filterOnlyCapsText"
      >
        <template v-slot:top>
          <v-text-field
                  v-model="search"
                  label="Search (Word)"
                  class="mx-4"
          ></v-text-field>
        </template>
        <template v-slot:item.means="{ item }">
          <div v-for="(mean, index) in item.means" :key="index">
            <v-chip dark x-small>
              {{ mean.part }}
            </v-chip>
            {{ mean.mean }}
          </div>
        </template>
      </v-data-table>
    </v-card>
  </v-container>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';
import AxiosService from '../../service/axios.service';
import AxiosResponse from '../../service/axios.service';

@Component
export default class WordList extends Vue {
  public headers: object[] = [
    // { text: 'ID', value: 'id' },
    { text: 'Language', value: 'langCode' },
    { text: 'Word', value: 'word' },
    { text: 'Mean', value: 'means' },
  ];

  public datas: object[] = [];
  public search: string = '';

  public langCodes: string[] = ['English', 'Japanese'];

  public searchLangCode: string = '';
  public searchWord: string  = '';
  public searchMean: string  = '';

  public created() {
    this.getList();
  }

  public async getList() {
    const params = {
        langCode: this.searchLangCode,
        word: this.searchWord,
        mean: this.searchMean,
    };
    const response: AxiosResponse = await AxiosService.instance.get('/api/word/list', { params });
    if (response.status === 200) {
      this.datas = response.data;
    } else {
      alert('List search fail.');
    }
  }

  public filterOnlyCapsText(value: string, search: string, item: string) {
      return value != null &&
          search != null &&
          typeof value === 'string' &&
          value.toString().toLocaleUpperCase().indexOf(search.toString().toLocaleUpperCase()) !== -1;
  }

  public handleClickSearch() {
      console.log(this.searchLangCode, this.searchWord, this.searchMean);
      this.getList();
  }

  public handleClickAddWord() {
      this.$router.push('/word/form');
  }
}
</script>