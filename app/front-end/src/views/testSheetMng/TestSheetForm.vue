<template>
    <v-container>
        <template>
            <v-card outlined class="overflow-hidden">
                <v-form ref="form">
                    <v-toolbar flat dense dark>
                        <v-awesome-icon name="edit" />
                        <v-toolbar-title class="font-weight-light mx-2">
                            Test Sheet
                        </v-toolbar-title>
                    </v-toolbar>
                    <v-card-text>
                        <v-row>
                            <v-col cols="12">
                                <v-select
                                        :items="langCodes"
                                        label="Language"
                                        v-model="langCode"
                                ></v-select>
                                <v-text-field
                                        label="Title"
                                        v-model="title"
                                ></v-text-field>
                            </v-col>
                        </v-row>
                        <v-card outlined >
                            <v-data-table
                                    :headers="headers"
                                    :items="desserts"
                                    sort-by="word"
                                    class="elevation-1"
                            >
                            </v-data-table>
                        </v-card>
                    </v-card-text>
                    <v-card-actions>
                        <v-spacer></v-spacer>
                        <v-btn small outlined @click="cancel">Cancel</v-btn>
                        <v-btn small outlined color="primary" @click="save">Save</v-btn>
                    </v-card-actions>
                    <v-snackbar
                            v-model="showAlert"
                            absolute
                            centered
                    >
                        {{ message }}
                        <template v-slot:action="{ attrs }">
                            <v-btn
                                    color="blue"
                                    text
                                    v-bind="attrs"
                                    @click="goListPage"
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
import AxiosService from '../../service/axios.service';
import AxiosResponse from '../../service/axios.service';

@Component
export default class TestSheetForm extends Vue {
    public showAlert: boolean = false;
    public message: string = '';
    public langCodes: string[] = ['English', 'Japanese'];

    public id: string = '';
    public langCode: string = '';
    public title: string = '';
    public headers: any[] = [
        { text: 'Language', value: 'langCode' },
        { text: 'Word', value: 'word' },
        { text: 'Mean', value: 'means' },
        { text: 'Actions', value: 'actions', sortable: false },
    ];
    public desserts: any[] = [];


    public descriptionLimit: number = 60;
    public entries: any[] = [];
    public isLoading: boolean = false;
    public model: any[] = [];
    // public search: string = '';


    public mounted() {
        // this.id = this.$route.query.id;
        // if (this.id) {
        //     this.getTestSheet();
        // }
    }

    public cancel() {
        this.goListPage();
    }

    public goListPage() {
        this.showAlert = false;
        this.$router.push('/testSheet/list');
    }

    public async getTestSheet() {
        const response: AxiosResponse = await AxiosService.instance.get('/api/testSheet?id=' + this.id);
        if (response.status === 200) {
            if (response.data) {
                this.langCode = response.data.langCode;
                this.title = response.data.title;
            }
        } else {
            this.message = 'TestSheet 조회에 실패했습니다.';
            this.showAlert = true;
        }
    }

    public async save() {
        const params = {
            langCode: this.langCode,
            title: this.title,
        };
        const response: AxiosResponse = await AxiosService.instance.post('/api/testSheet', params);
        if (response.status === 200) {
            this.message = '성공적으로 저장했습니다.';
        } else {
            this.message = '저장에 실패했습니다.';
        }
        this.showAlert = true;
    }

    get items() {
        return this.entries.map((entry) => {
            const Description = entry.Description.length > this.descriptionLimit
                ? entry.Description.slice(0, this.descriptionLimit) + '...'
                : entry.Description;

            return Object.assign({}, entry, { Description });
        });
    }

    // public search(val: string) {
    //     // Items have already been loaded
    //     if (this.items.length > 0) { return; }
    //
    //     // Items have already been requested
    //     if (this.isLoading) { return; }
    //
    //     this.isLoading = true;
    //
    //     // Lazily load input items
    //     fetch('https://api.publicapis.org/entries')
    //         .then((res) => res.json())
    //         .then((res) => {
    //             const { count, entries } = res;
    //             this.count = count;
    //             this.entries = entries;
    //         })
    //         .catch((err) => {
    //             console.log(err);
    //         })
    //         .finally(() => (this.isLoading = false));
    // }
}
</script>