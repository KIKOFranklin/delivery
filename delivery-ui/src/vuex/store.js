import Vue from 'vue'
import Vuex from 'vuex'


Vue.use(Vuex);

//状态管理
export default new Vuex.Store({
    state: {
      token: "",
    },
    mutations: {
      setToken(state, token){
        state.token = token;
      }
    },
    getters:{
      getToken(state){
        console.log('当前token:'+state.token)
        return state.token;
      }
    }
})