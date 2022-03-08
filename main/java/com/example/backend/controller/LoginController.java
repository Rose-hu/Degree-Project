package com.example.backend.controller;

import com.example.backend.result.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import com.example.backend.pojo.User;

import java.util.Objects;

@Controller
public class LoginController {

@CrossOrigin
@PostMapping(value = "api/login")
@ResponseBody
public Result login(@RequestBody User requestUser) {
    // 对 html 标签进行转义，防止 XSS 攻击
    String username = requestUser.getUsername();
    username = HtmlUtils.htmlEscape(username);

    if (!Objects.equals("admin", username) || !Objects.equals("123456", requestUser.getPassword())) {
        String message = "账号密码错误";
        System.out.println("test");
        return new Result(400);
    } else {
        return new Result(200);
    }
}
}