
import Vue from 'vue'
import App from './App'
//引入路由
import router from './router'
//引入element-ui
import ElementUI from 'element-ui';
//引入element-ui的css
import 'element-ui/lib/theme-chalk/index.css';
//引入axios
import axios from 'axios'
import VueAxios from 'vue-axios'
import qs from 'qs'
axios.interceptors.request.use(config => {
  config.headers.Authorization=window.sessionStorage.getItem("token");
  return config;
})
//使用axios
// Vue.use(VueAxios, axios)
Vue.prototype.$axios = axios
//设置默认请求路径
axios.defaults.baseURL="/liyi"

//引入公共样式
import './assets/global.css'

Vue.config.productionTip = false
//使用路由
Vue.use(router)
//使用element-ui
Vue.use(ElementUI)
//配全局属性配置，在任意组件内可以使用this.$qs获取qs对象
Vue.prototype.$qs = qs
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
