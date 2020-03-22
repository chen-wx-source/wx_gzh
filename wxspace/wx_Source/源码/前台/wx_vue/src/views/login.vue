<template>
    <div class="login_containter">
        <div class="login_box">
            <div class="head_box">
                <img src="../../static/imgs/loginphoto.jpg"/>  
            </div>
            <el-form class="login_form" :rules="rules" :model="ruleForm" ref="ruleForm">
                <el-form-item prop="userId">
                    <el-input  placeholder="请输入账号" v-model="ruleForm.userId" prefix-icon="el-icon-user"></el-input>
                </el-form-item>
                <el-form-item prop="password">
                    <el-input placeholder="请输入密码" v-model="ruleForm.password" prefix-icon="el-icon-lock" show-password></el-input>
                </el-form-item>
                <el-button  type="primary" @click="submitForm('ruleForm')"  >登录</el-button>
                <el-button  type="info" @click="resetForm('ruleForm')">重置</el-button>
            </el-form>
        </div>  
    </div>
</template>

<script>
    export default {
        data() {
            return {
                ruleForm: {
                    userId: '',
                    password: ''
                },
                rules: {
                    userId: [
                        { required: true, message: '请输入账号', trigger: 'blur' }
                    ],
                    password: [
                        { required: true, message: '请输入密码', trigger: 'blur' }
                    ]
                },
                
            };
        },
        methods:{
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                       
                        this.$axios.post("/wx/login",this.$qs.stringify(this.ruleForm)).then((res)=>{
                            
                            let result = res.data;
                            if(result.rtnCode=="1"){
                                this.$message.success("登录成功。");
                                window.sessionStorage.setItem("token",this.ruleForm.userId);
                                this.$router.push("/Index");
                            }else{
                                this.$message.error(result.rtnMsg);
                            }
                            console.log("获取结果==",result);
                        }),function(err){
                            console.log(err);
                           
                            this.$message.error("登录失败。");
                        }
                    }else{
                        //账号密码为空
                        this.$message.info("请输入账号和密码。");

                    } 
                });
            },
            resetForm(formName){
                this.$refs[formName].resetFields();
            }
        }
    }
</script>
<style scoped>
    .login_containter{
        /* background-color: #90aecc; */
        background-image: url("../../static/imgs/loginbj.jpg");
        background-repeat: no-repeat;
        background-size: 100% 100%;
        text-align: center;
        height:100%;
        
    }
    .login_box{
        height:400px;;
        width:400px;
        position: relative;
        top:50%;
        left:50%;
        transform: translate(-50%,-50%);
        background:rgba(206, 209, 207, 0.3);
        border-radius: 50%;
        
    }
    .head_box{
        border:1px solid #ccc;
        width:130px;
        height:130px;
        border-radius: 50%;
        /*阴影*/
        box-shadow: 0 0 10px #222;
        position: absolute;
        left:50%;
        transform: translate(-50%,-50%);
        background:rgba(206, 209, 207, 0.3);
        padding: 10px;
    }
    .head_box img{
        width:100%;
        height:100%;
        border-radius: 50%;
        background:rgba(206, 209, 207, 0.3);
    }
    .login_form{
        position: absolute;
        bottom:75px;
        width:100%;
        padding:30px 50px;
        box-sizing: border-box;
    }
</style>