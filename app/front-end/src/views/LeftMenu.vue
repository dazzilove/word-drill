<template>
    <div style="height: 100%; padding: 20px; background-color: #eeeeee">
        <v-list>
            <v-list-item>
                <v-list-item-icon>
                    <v-icon>mdi-home</v-icon>
                </v-list-item-icon>
                <v-list-item-title>Home</v-list-item-title>
            </v-list-item>

            <v-list-group
                :value="true"
                prepend-icon="mdi-account">
                <template v-slot:activator>
                    <v-list-item-content>
                        <v-list-item-title>My</v-list-item-title>
                    </v-list-item-content>
                </template>
                <v-list-item>
                    <v-list-item-content>
                        <v-list-item-title><router-link to="/my/wordbook">My Wordbook</router-link></v-list-item-title>
                        <v-list-item-title><router-link to="/my/testSheet">My Test Sheet</router-link></v-list-item-title>
                        <v-list-item-title><router-link to="/my/report">Reports</router-link></v-list-item-title>
                        <v-list-item-title><router-link to="/my/account">Account</router-link></v-list-item-title>
                    </v-list-item-content>
                </v-list-item>
            </v-list-group>

            <v-list-group
                    :value="false"
                    prepend-icon="mdi-menu">
                <template v-slot:activator>
                    <v-list-item-content>
                        <v-list-item-title>Management</v-list-item-title>
                    </v-list-item-content>
                </template>
                <v-list-item>
                    <v-list-item-content>
                        <v-list-item-title><router-link to="/word/list">Words</router-link></v-list-item-title>
                        <v-list-item-title><router-link to="/testSheet/list">Test Sheets</router-link></v-list-item-title>
                    </v-list-item-content>
                </v-list-item>
            </v-list-group>

            <v-list-group
                    :value="false"
                    prepend-icon="mdi-menu">
                <template v-slot:activator>
                    <v-list-item-content>
                        <v-list-item-title>System</v-list-item-title>
                    </v-list-item-content>
                </template>
                <v-list-item>
                    <v-list-item-content>
                        <v-list-item-title><router-link to="/system/user">User Management</router-link></v-list-item-title>
                    </v-list-item-content>
                </v-list-item>
            </v-list-group>
        </v-list>
    </div>
</template>

<script lang="ts">
    import { Component, Vue } from 'vue-property-decorator';

    @Component
    export default class LeftMenu extends Vue {

    }
</script>

<style scoped="scoped">
    .menu_title {
        font-weight: bold;
    }
</style>