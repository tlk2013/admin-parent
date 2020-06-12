package com.dwsoft.admin.mvc.handler;

import com.dwsoft.admin.service.api.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author tlk
 * @date 2020/5/18-10:57
 */
@Controller
public class AdminHandler {
    @Autowired
    private AdminService adminService;
@RequestMapping("/admin/doLogin.html")
    public  String  doLogin(
            @RequestParam("loginAcct") String loginAcct,
            @RequestParam("userPswd") String userPswd){
    System.out.println(loginAcct);
    System.out.println(userPswd);
    return "admin-main";
    }
}
