package com.veigar.controller;
import javax.servlet.http.HttpServletRequest;

import com.veigar.model.DrivingLicense;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.veigar.model.User;
import com.veigar.model.ViolationRecord;
import com.veigar.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/showUser.do")
    public void selectUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        long userId = Long.parseLong(request.getParameter("id"));
        User user = this.userService.selectUser(userId);
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(user.getUsername()));
        response.getWriter().close();
    }

    @RequestMapping("/selectDriver.do")
    public String  selectDriver(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String carType= request.getParameter("hmzl");
        String carNum= request.getParameter("cp_num");
        String carEngineNum= request.getParameter("fdj_num");
        String carFrame= request.getParameter("cj_num");
        String carEngineNum_4="";
        String carFrame_6="";

        DrivingLicense drivingLicense1 = this.userService.selectDriver(carNum);
        System.out.println("carNum:"+carNum);
        ViolationRecord vrd = this.userService.selectRecord(carNum);
        ObjectMapper mapper = new ObjectMapper();

        if("bigCar".equals(carType) ){
            carType="大型汽车";
        }else if("littleCar".equals(carType)){
            carType="小型汽车";
        }else if("outCar".equals(carType)){
            carType="外籍汽车";
        }else if("moto".equals(carType)){
            carType="摩托车";
        }

        if(drivingLicense1 != null){
            carEngineNum_4 = drivingLicense1.getCarEngineNum();
            carEngineNum_4 = carEngineNum_4.substring(5);
            carFrame_6 = drivingLicense1.getCarIdentificantionCode();
            carFrame_6 = carFrame_6.substring(11);

//            ViolationRecord vr = this.userService.selectRecord(carNum);
//            System.out.println("vr.to:"+vr.toString());
        }
        if(drivingLicense1 == null ){
            response.getWriter().write(mapper.writeValueAsString("车辆不存在"));
        }else if(!carType.equals(drivingLicense1.getCarType())){
            response.getWriter().write(mapper.writeValueAsString("车辆类型有误"));
        }else if(!carEngineNum_4.equals(carEngineNum)){
            response.getWriter().write(mapper.writeValueAsString("发动机号有误"));
        }else if(!carFrame_6.equals(carFrame)){
            response.getWriter().write(mapper.writeValueAsString("车架号有误"));
        }else{
            response.getWriter().write(mapper.writeValueAsString(""));
            response.getWriter().close();
            System.out.println("vrd.to:"+vrd.toString());
        }
        return null;
    }

}
