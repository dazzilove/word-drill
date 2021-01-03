import Vue from 'vue';
import App from './App.vue';
import router from './router';
import store from './store';
import vuetify from './plugins/vuetify';
import axios from 'axios';

import 'vue-awesome/icons';
import VueAwesomeIcon from 'vue-awesome/components/Icon.vue';

Vue.prototype.$axios = axios;
Vue.config.productionTip = false;
Vue.component('v-awesome-icon', VueAwesomeIcon);

new Vue({
  router,
  store,
  vuetify,
  render: (h) => h(App),
}).$mount('#app');
