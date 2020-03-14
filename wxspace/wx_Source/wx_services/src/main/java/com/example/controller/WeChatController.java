package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class WeChatController {
    /*
     author:chenhongyu
     date:2020/03/14
    * 微信url验证接入
    * @param signature 加密签名
    * @param timestamp
    * @param nonce
    * @param echostr
    * @return
    * */
    @RequestMapping(value = "WeChat",method = RequestMethod.GET)
    @ResponseBody
    public String validateGet(String signature,String timestamp,String nonce,String echostr){
        //将token timestamp nonce排序
        //String[] arr={timestamp,nonce,WeChatUtil.TOKEN};
//        System.out.println("进来了");
        System.out.println("signature:"+signature+"timestamp:"+timestamp+",nonce:"+nonce+",echostr:"+echostr);
        return echostr;
    }
    @RequestMapping(value = "WeChat",method = RequestMethod.POST)
    @ResponseBody
    public String validatePost(){
        //将token timestamp nonce排序
        //String[] arr={timestamp,nonce,WeChatUtil.TOKEN};
        System.out.println("进来了");

        return "1";
    }

}
