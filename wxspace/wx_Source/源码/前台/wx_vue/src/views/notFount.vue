<template>
    <div id="not_fount_div">
        <div id="back_div" @click="back_home">

        </div>
    </div>
</template>
<script>
export default {
    data(){
        return{

        }
    },
    methods:{
        back_home(){
            //跳转到首页
            this.$router.push("/Index");
            //返回上一级
            // this.@$router.go(-1);
        }
    }
}
</script>
<style scoped>
    #not_fount_div{
        width: 100%;
        height: 100%;
        background-image: url("../../static/imgs/notfound.jpg");
        background-repeat: no-repeat;
        background-size: 100% 100%;
        position: relative;
    }
    #back_div{
        width:230px;
        height: 80px;
        /* background-color: aqua; */
        position: absolute;
        left: 42%;
        bottom: 110px;
        cursor:pointer;
    }
</style>