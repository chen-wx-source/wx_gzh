import Vue from 'vue'
import Router from 'vue-router'
import Index from '../views/index'
import Login from '../views/login'
import UserMsg from '../views/user_msg'
import Goods from '../views/goods'
import Order from '../views/order'
import notFound from '../views/notFount'

Vue.use(Router)

const router=new Router({
// export default new Router({
  mode:'history',
  routes: [
    {path: '/',name: 'login',component: Login},
    {path: '/Index',name: 'index',component: Index,redirect:"/UserMsg",
      children:[
        {path: '/UserMsg',name: 'userMsg',component: UserMsg},
        {path: '/Goods',name: 'goods',component: Goods},
        {path: '/Order',name: 'order',component: Order}
      ]
    },
    {path: '/Login',name: 'login',component: Login},
    {path:'/404',name:'notFound',component:notFound},
    {path:'*',redirect:'/404'}
  ]
})
//挂载路由导航守卫
router.beforeEach((to, from, next) => {
  if(to.path==="/Login"){
    return next();
  }
  //获取token看是否已经登陆
  let tokenStr=window.sessionStorage.getItem("token");
  if(!tokenStr){
    return next("/Login")
  }else{
    next();
  }
})
//暴露对象
export default router
