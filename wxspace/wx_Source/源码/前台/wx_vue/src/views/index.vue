<template>
    <el-container class="main_container">
        <el-header>
            <div>管理系统</div>
            <el-button type="info" @click="exit">退出</el-button>
        </el-header>
        <el-container>
            <el-aside width="200px">
                <el-menu default-active="2" class="el-menu-vertical-demo" 
                    background-color="#545c64"  @open="handleOpen" @close="handleClose" 
                    text-color="#fff" active-text-color="#409eef" :unique-opened="true" :router="true">
                    <el-submenu :index="single.id" v-for="single in menuList" :key="single.id">
                        
                        <template slot="title">
                            <i :class="single.icon"></i>
                            <span>{{single.menuName}}</span>
                        </template>
                        
                        <el-menu-item :index="singleChid.path" v-for="singleChid in single.children" :key="singleChid.id">
                            <i :class="singleChid.icon"></i>
                            <span>{{singleChid.menuName}}</span>
                        </el-menu-item>
                        
                    </el-submenu>
                </el-menu>
            </el-aside>
            <el-main>
                <router-view></router-view>
            </el-main>
        </el-container>
    </el-container>
</template>
<script>
    export default {
        name:"index",
        data(){
          return{
            menuList: []
            //   {"id":"101","menuName":"用户管理","icon":"el-icon-user-solid","path":"",
            //     "children":[
            //       {"id":"1011","menuName":"用户列表","icon":"el-icon-menu","path":"/UserMsg"}
            //     ]
            //   },
            //   {"id":"102","menuName":"商品管理","icon":"el-icon-s-goods","path":"",
            //     "children":[
            //       {"id":"2011","menuName":"商品列表","icon":"el-icon-menu","path":"/Goods",},
            //       {"id":"2012","menuName":"购物列表","icon":"el-icon-menu","path":"/Order",}
            //     ]
            //   },
            //   {"id":"103","menuName":"订单管理","icon":"el-icon-sell","path":"",}
            // ]
          }
        },
        methods:{
            handleOpen(key, keyPath) {
                console.log(key, keyPath);
            },
            handleClose(key, keyPath) {
                console.log(key, keyPath);
            },
            queryMeuns(){
              this.$axios.get("/queryMenus").then((res)=>{
                this.menuList=res.data;
              })
            },
            exit(){
                window.sessionStorage.setItem("token","");
                this.$router.push("/Login");
            }
        },
        created:function(){
            this.queryMeuns();
        }
    }
</script>
<style scoped>
    .el-header{
        background-color: #3d4850;
        display: flex;
        justify-content: space-between;
        align-items: center;
        font-size:20px;
        color:#ffffff;
    }
    .el-header div{
        display: flex;
        align-items: center;
        
    }
    .el-aside {
        background-color: #545c64;
    }
    .el-main{
        background-color: #cccccc;
    }
    .main_container{
        height:100%;
    }
    .el-menu{
        border:0px;
    }
</style>