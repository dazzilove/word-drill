<template >
    <v-container>
        <div style="text-align: right; padding-bottom: 10px;">
            <v-btn
                    elevation="1"
                    @click="handleClickNewTestSheet"
                    small
                    outlined>New Test Sheet</v-btn>
        </div>
        <v-data-table
                :headers="headers"
                :items="datas"
                :items-per-page="5"
                class="elevation-1"
        >
            <template v-slot:item.title="{ item }">
                <a :href="'/testSheet/form?id=' + item.id">{{item.title}}</a>
            </template>
        </v-data-table>
    </v-container>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';
import AxiosService from '../../service/axios.service';
import AxiosResponse from '../../service/axios.service';

@Component
export default class TestSheetList extends Vue {
    public headers: object[] = [
        // { text: 'ID', value: 'id' },
        { text: 'Language', value: 'langCode' },
        { text: 'Title', value: 'title' },
    ];

    public datas: object[] = [];

    public created() {
        this.getList();
    }

    public async getList() {
        const response: AxiosResponse = await AxiosService.instance.get('/api/testSheet/list');
        if (response.status === 200) {
            this.datas = response.data;
        } else {
            alert('List search fail.');
        }
    }

    public goDetail(id: string) {
        this.$router.push('/testSheet/form?id=' + id);
    }

    public handleClickNewTestSheet() {
        this.$router.push('/testSheet/form');
    }
}
</script>