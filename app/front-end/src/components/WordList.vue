<template >
  <v-data-table
    :headers="headers"
    :items="datas"
    :items-per-page="5"
    class="elevation-1"
  >
    <template v-slot:item.means="{ item }">
      <div v-for="(mean, index) in item.means" :key="index">
        <v-chip dark x-small>
          {{ mean.part }}
        </v-chip>
        {{ mean.mean }}
      </div>
    </template>
  </v-data-table>
</template>

<script lang="ts">
  import Vue from 'vue';
  import Component from 'vue-class-component';
  import AxiosService from '@/service/axios.service';
  import AxiosResponse from '@/service/axios.service';

  @Component
  export default class WordList extends Vue {
    public headers: object[] = [
      { text: 'ID', value: 'id' },
      { text: 'Language', value: 'langCode' },
      { text: 'Word', value: 'word' },
      { text: 'Mean', value: 'means', },
    ];

    public datas: object[] = [];

    public created() {
      this.getList();
    }

    public async getList() {
      const response: AxiosResponse = await AxiosService.instance.get('/api/word/list');
      if (response.status === 200) {
        this.datas = response.data;
      } else {
        alert('List search fail.');
      }
    }
  }
</script>