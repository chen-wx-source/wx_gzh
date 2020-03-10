<template>

    <el-menu default-active="2" class="el-menu-vertical-demo" background-color="#545c64"  @open="handleOpen" @close="handleClose" text-color="#fff" active-text-color="#409eef" unique-opened>
      <el-submenu :index="single.id" v-for="single in menuList" :key="single.id">
        <template slot="title">
          <i :class="single.icon"></i>
          <span>{{single.menuName}}</span>
        </template>
        <el-menu-item :index="singleChid.id" v-for="singleChid in single.children" :key="singleChid.id">
          <i :class="singleChid.icon"></i>
          <span>{{singleChid.menuName}}</span>
          
        </el-menu-item>
      </el-submenu>
    </el-menu>

</template>

<script>
    export default {
        name:"assid",
        data(){
          return{
            menuList: [
              {"id":"101","menuName":"用户管理","icon":"el-icon-user-solid",
                "children":[
                  {"id":"1011","menuName":"用户列表","icon":"el-icon-menu"}
                ]
              },
              {"id":"102","menuName":"商品管理","icon":"el-icon-s-goods",
                "children":[
                  {"id":"2011","menuName":"商品列表","icon":"el-icon-menu"},
                  {"id":"2012","menuName":"购物列表","icon":"el-icon-menu"}
                ]
              },
              {"id":"103","menuName":"订单管理","icon":"el-icon-sell"}
            ]
          }
        },
        methods: {
            handleOpen(key, keyPath) {
                console.log(key, keyPath);
            },
            handleClose(key, keyPath) {
                console.log(key, keyPath);
            },
            queryMeuns(){
              this.axios.get("/login",this.ruleForm).then((res)=>{
                this.menuList=res.data;
              })
            }
        }
    }
</script>
<style scoped>
  .el-menu-vertical-demo{
    height:100%;
  }
  .el-menu{
    border:0px;
  }
</style>