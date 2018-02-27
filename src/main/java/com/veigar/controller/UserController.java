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
        this.userService.delById(ids[0]);
        return ids[0];
    }

    @RequestMapping("/delDLById.do")
    @ResponseBody
    public int delDLById(int[] ids){
        this.userService.delDLById(ids[0]);
        return ids[0];
    }

    @RequestMapping("/addDriver.do")
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

    @RequestMapping("/addDL.do")
    @ResponseBody
    public Boolean addDL(@RequestBody DrivingLicense drivingLicense){
        int i = this.userService.checkDL(drivingLicense);
        Boolean flag=true;
        if(i==0){
            this.userService.addDL(drivingLicense);
        }else{
            flag=false;
        }
        return flag;
    }

    @RequestMapping("/modifyDriver.do")
    @ResponseBody
    public Boolean modifyDriver(@RequestBody Driver driver){
        System.out.println("modifyDriver");
        Boolean flag=true;
        this.userService.modifyDriver(driver);
        return flag;
    }

    @RequestMapping("/modifyDL.do")
    @ResponseBody
    public Boolean modifyDL(@RequestBody DrivingLicense drivingLicense){
        Boolean flag=true;
        this.userService.modifyDL(drivingLicense);
        return flag;
    }

    @RequestMapping("/toDriveForm.do")
    public String toDriveForm(){
        return "driver_form";
    }

    @RequestMapping("/toDLForm.do")
    public String toDLForm(){
        return "driverLicense_form";
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

    @RequestMapping("/toModifyDriver.do")
    public String modifyDriver(int id,Model model){
        Driver driver = this.userService.selectDriverById(id);
        model.addAttribute("driver",driver);
        return "driver_form";
    }

    @RequestMapping("/toModifyDL.do")
    public String toModifyDL(int id,Model model){
        DrivingLicense drivingLicense = this.userService.selectDLById(id);
        model.addAttribute("drivingLicense",drivingLicense);
        return "driverLicense_form";
    }

    @RequestMapping("/modifyPassword.do")
    public String modifyPassword(){
        return "modifyPassword_form";
    }

    @RequestMapping("/modifyPW.do")
    @ResponseBody
    public String modifyPW(String pass1,String pass2,HttpSession httpSession){
        String message;
        String username = (String) httpSession.getAttribute("username");
        System.out.println(pass1 + ","+username +","+pass2);
        Admin admin = new Admin(username,pass1);
        int i = this.userService.login(admin);
        System.out.print("i:"+i);
        if(i==0){
            message = "ERROR";
        }else{
            message = "MODIFIED";
            //修改密码
            admin = new Admin(username,pass2);
            this.userService.modifyPW(admin);
            return message;
        }
        return message;
    }

    @RequestMapping("/toDL.do")
    public String toDL(){
        return "driverLicense_table";
    }

    @RequestMapping("/selectDL.do")
    @ResponseBody
    public Map<String,Object> selectDL(@RequestParam int page, int rows) throws IOException {
        System.out.println("page:"+page+",rows:"+rows);
        int count = this.userService.getCount_DL();
        System.out.println(count);
        List<DrivingLicense> list  = this.userService.selectAllDL(page-1, rows);

        Map<String,Object> map = new HashMap<>();
        map.put("total",count);
        map.put("rows",list);
        return map;
    }

    @RequestMapping("toRegister")
    public String toRegister(){
        return "registerAdmin";
    }

    @RequestMapping("/registerAdmin.do")
    @ResponseBody
    public Boolean registerAdmin(@RequestBody Admin admin){
        int i = this.userService.checkUser(admin.getUsername());
        System.out.println("i:"+i);
        Boolean flag;
        if(i==0){
            flag = true;
            this.userService.registerAdmin(admin);
        }else {
            flag = false;
        }
        return flag;
    }

    @RequestMapping("/toViolationRecord")
    public String toViolationRecord(){
        return "violationRecord";
    }

    @RequestMapping("/selectVR.do")
    @ResponseBody
    public Map<String,Object> selectVR(@RequestParam int page, int rows) throws IOException {
        System.out.println("page:"+page+",rows:"+rows);
        int count = this.userService.getCount_VR();
        System.out.println(count);
        List<ViolationRecord> list  = this.userService.selectAllVR(page-1, rows);

        Map<String,Object> map = new HashMap<>();
        map.put("total",count);
        map.put("rows",list);
        return map;
    }

    @RequestMapping("/toVRForm")
    public String toVRForm(){
        return "vR_form";
    }

    @RequestMapping("/toModifyVRForm.do")
    public String toModifyVRForm(int id,Model model){
        ViolationRecord violationRecord = this.userService.selectVRById(id);
        model.addAttribute("violationRecord",violationRecord);
        return "vR_form";
    }

    @RequestMapping("/modifyVR.do")
    @ResponseBody
    public Boolean modifyVR(@RequestBody ViolationRecord violationRecord){
        System.out.println("modifyVR");
        Boolean flag=true;
        this.userService.modifyVR(violationRecord);
        return flag;
    }

    @RequestMapping("/addVR.do")
    @ResponseBody
    public Boolean addVR(@RequestBody ViolationRecord violationRecord){
        Boolean flag=true;
        this.userService.addVR(violationRecord);
        return flag;
    }

    @RequestMapping("/delVRById.do")
    @ResponseBody
    public int delVRById(int[] ids){
        this.userService.delVRById(ids[0]);
        return ids[0];
    }
}
