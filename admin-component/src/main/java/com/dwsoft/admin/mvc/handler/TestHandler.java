package com.dwsoft.admin.mvc.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.dwsoft.admin.entity.Admin;
import com.dwsoft.admin.entity.ParamData;
import com.dwsoft.admin.entity.Student;
import com.dwsoft.admin.service.api.AdminService;
import com.dwsoft.admin.util.CrowdUtil;
import com.dwsoft.admin.util.ResultEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestHandler {

    @Autowired
    private AdminService adminService;

    private Logger logger = LoggerFactory.getLogger(TestHandler.class);

    @ResponseBody
    @RequestMapping("/send/compose/object.json")
    public ResultEntity<Student> testReceiveComposeObject(@RequestBody Student student, HttpServletRequest request) {

        boolean judgeResult = CrowdUtil.judgeRequestType(request);

        logger.info("judgeResult=" + judgeResult);

        logger.info(student.toString());

        // 将“查询”到的Student对象封装到ResultEntity中返回
        ResultEntity<Student> resultEntity = ResultEntity.successWithData(student);

        String a = null;

        System.out.println(a.length());

        return resultEntity;
    }

    @ResponseBody
    @RequestMapping("/send/array/three.html")
    public String testReceiveArrayThree(@RequestBody List<Integer> array) {

        for (Integer number : array) {
            logger.info("number=" + number);
        }

        return "success";
    }

    @ResponseBody
    @RequestMapping("/send/array/two.html")
    public String testReceiveArrayTwo(ParamData paramData) {

        List<Integer> array = paramData.getArray();

        for (Integer number : array) {
            System.out.println("number=" + number);
        }

        return "success";
    }

    @ResponseBody
    @RequestMapping("/send/array/one.html")
    public String testReceiveArrayOne(@RequestParam("array[]") List<Integer> array) {

        for (Integer number : array) {
            System.out.println("number=" + number);
        }

        return "success";
    }

    @RequestMapping("/test/ssm.html")
    public String testSsm(ModelMap modelMap, HttpServletRequest request) {

        boolean judgeResult = CrowdUtil.judgeRequestType(request);

        logger.info("judgeResult=" + judgeResult);
        Admin admin = new Admin(null, "123", "456", "tom", "tom@qq.com", null);
        adminService.saveAdmin(admin);
//

        admin = adminService.getAdminByID(1);


        List<Admin> adminList = adminService.getAll();
//
        modelMap.addAttribute("adminList", adminList);

        String a = null;

        System.out.println(a.length());

        return "target";
    }

    @ResponseBody
    @RequestMapping("/get/one.json")
    public ResultEntity getAdmin(@RequestParam("id") Integer id) {

        Admin admin = adminService.getAdminByID(id);

        ResultEntity<Admin> resultEntity = ResultEntity.successWithData(admin);
        return resultEntity;
    }
    @ResponseBody
    @RequestMapping("/get/student.json")
    public ResultEntity getStudent(@RequestBody Student student) {

//        Admin admin = adminService.getAdminByID(id);
        System.out.println(student);
        String a = null;

        System.out.println(a.length());
        ResultEntity<Student> resultEntity = ResultEntity.successWithData(student);
        return resultEntity;
    }

}
