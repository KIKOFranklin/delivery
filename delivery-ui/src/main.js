import Vue from 'vue'
import App from './App.vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css';
import router from './router'
import store from './vuex/store';


Vue.config.productionTip = false

Vue.use(ElementUI);


// 引入echarts
import echarts from 'echarts'
Vue.prototype.$echarts = echarts

// 引入axios
import axios from 'axios';
Vue.prototype.$axios = axios;



// 路由守卫核心代码
router.beforeEach((to, from, next) => {
  // 先判断浏览器中是否已经有token了，有则true，否则false
  const isLogin = window.sessionStorage.getItem("token") ? true : false
  
  //然后判断要去往的页面，如果是去往login和register页面的，就直接放行
  //如果不是去往login和register页面，则判断有没有token，如果有token就放行，否则就跳转login页面
  if (to.path == '/login') {
    next();
  }else {
    isLogin ? next() : next('/login')
  }
})


new Vue({
  router,
  render: h => h(App),
  store
}).$mount("#app")



