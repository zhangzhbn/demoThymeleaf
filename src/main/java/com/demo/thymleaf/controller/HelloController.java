package com.demo.thymleaf.controller;

import com.demo.thymleaf.model.Message;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * HelloController
 *
 * @author zhangzb
 * @date 2017-4-21
 */
@Controller
public class HelloController {


    @RequestMapping(value="/hello")
    public String hello(Model model) {
        model.addAttribute("name", "Dear");

        return "hello";
    }

    @RequestMapping(value="/add")
    public String add(Message message, ModelMap modelMap) {
        System.out.println("info====" + message.getInfo());


        return "add";
    }

    @RequestMapping(value="/showList")
    public String showList(Message message, Model model) {
        System.out.println("info=" + message.getInfo());

        Message mes1 = new Message();
        mes1.setInfo("1234");
        Message mes2 = new Message();
        mes2.setInfo("5678");

        List<Message> list = new ArrayList<Message>();
        list.add(mes1);
        list.add(mes2);

        model.addAttribute("list", list);

        return "add";
    }


    @RequestMapping(value="/ajaxReturnObject")
    public @ResponseBody String ajaxReturnObject(Message message) {

        try {

            System.out.println("AJAX 接收:" + message.getInfo());


            String ajaxStr = "{\"name\":\"小明\",\"sex\":\"男\",\"address\":\"北京\",\"job\":\"web前端工程师\"}";

            ObjectMapper objectMapper = new ObjectMapper();

            ajaxStr = objectMapper.writeValueAsString(message);


            return ajaxStr;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    @RequestMapping(value="ajaxReturnObjectList")
    public @ResponseBody List<Message> ajaxReturnObjectList(Message message) {

        System.out.println("AJAX 接收：" + message.getInfo());

        Message mes1 = new Message();
        mes1.setInfo("1234");
        Message mes2 = new Message();
        mes2.setInfo("5678");

        List<Message> list = new ArrayList<Message>();
        list.add(mes1);
        list.add(mes2);

        return list;
    }


}
