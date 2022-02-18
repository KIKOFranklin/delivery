import Vue from 'vue'
import Router from 'vue-router'
import index from '@/views/index';
import login from '@/views/login';
import moneyTable from '@/views/moneyTable/money-table';
import moneyForm from '@/views/moneyForm/money-form';

Vue.use(Router);

export default new Router({
    routes: [
        {
            path: "/index",
            name: "首页",
            component: index,
            children: [{
                path: '/moneytable',
                component: moneyTable
            },
            {
                path: '/moneyform',
                component: moneyForm
            }]
        },
        {
            path: "/login",
            name: "login",
            component: login
        }
    ]
})