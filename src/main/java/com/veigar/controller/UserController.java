package com.veigar.controller;
import javax.servlet.http.HttpServletRequest;

import com.veigar.model.Admin;
import com.veigar.model.Driver;
import com.veigar.model.DrivingLicense;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.veigar.model.ViolationRecord;
import com.veigar.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/checkDriver")
    @ResponseBody
    public void  checkDriver(HttpServletRequest request,HttpServletResponse response, @RequestBody DrivingLicense drivingLicense) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        //过滤后的对象
        String message = this.userService.dataFilter(drivingLicense);
        System.out.println(message);
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(message));
        response.getWriter().close();
    }

    @RequestMapping("/selectDriver")
    public String checkDriver(@RequestParam String carNum,Model model){
        List<ViolationRecord> vrd = this.userService.selectRecord(carNum);
        //ViolationRecord vrd = this.userService.selectRecord(carNum);
        model.addAttribute("violationRecord",vrd);
        return "drivingLicense";
    }

    @RequestMapping("/manager.do")
    public String toManager(){
        return "manager";
    }

    @RequestMapping("/toDriver.do")
    public String toDriver(){
        return "driver_table";
    }

    @RequestMapping("/testJson.do")
    @ResponseBody
    public Map<String,Object> testJson(@RequestParam int page, int rows) throws IOException {
        System.out.println("page:"+page+",rows:"+rows);
        int count = this.userService.getCount_Driver();
        System.out.println(count);
        List<Driver> list  = this.userService.selectAllDriver(page-1, rows);

        Map<String,Object> map = new HashMap<>();
        map.put("total",count);
        map.put("rows",list);
        return map;
    }

    @RequestMapping("/delById.do")
    @ResponseBody
    public int delById(int[] ids){
        System.out.println(ids[0]);
        this.userService.delById(ids[0]);
        return ids[0];
    }

    @RequestMapping("/testAdd.do")
    @ResponseBody
    public Boolean testAdd(@RequestBody Driver driver){
        int i = this.userService.checkDriver(driver);
        Boolean flag=true;
        if(i==0){
            this.userService.addDriver(driver);
        }else{
            flag=false;
        }
        return flag;
    }

    @RequestMapping("/toDriveForm.do")
    public String toDriveForm(){
        return "driver_form";
    }

    @RequestMapping("/toPhonePage")
    public String toPhonePage(){
        return "phone_page";
    }

    @RequestMapping("/login")
    @ResponseBody
    public Boolean login(HttpSession httpSession,@RequestBody Admin admin){
        int i = this.userService.login(admin);
        Boolean flag = false;
        if(i==0){
            System.out.println("账号或密码有误");
        }else{
            httpSession.setAttribute("username",admin.getUsername());
            flag=true;
            System.out.println("登录成功");
        }
        return flag;
    }

    @RequestMapping("/Logout.do")
    public void clientLoginOut( HttpServletResponse response,HttpSession httpSession) throws IOException {
        httpSession.invalidate();
        response.sendRedirect("index.jsp");
    }
}
