package com.veigar.controller;
import javax.servlet.http.HttpServletRequest;

import com.veigar.model.DataGrid;
import com.veigar.model.Driver;
import com.veigar.model.DrivingLicense;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.veigar.model.ViolationRecord;
import com.veigar.service.IUserService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/checkDriver")
    public void  checkDriver(HttpServletRequest request, HttpServletResponse response,@RequestBody DrivingLicense drivingLicense) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        //AJAX传入的值
        String carType = drivingLicense.getCarType();
        String carNum = drivingLicense.getCarNum();
        String carEngineNum= drivingLicense.getCarEngineNum();
        String carFrame = drivingLicense.getCarIdentificantionCode();

        //过滤后的对象
        DrivingLicense dl = this.userService.dataFilter(drivingLicense);

        ObjectMapper mapper = new ObjectMapper();
        if(this.userService.selectDriver(carNum) == null ){
            response.getWriter().write(mapper.writeValueAsString("车辆不存在"));
        }else if(!carType.equals(dl.getCarType())){
            response.getWriter().write(mapper.writeValueAsString("车辆类型有误"));
        }else if(!carEngineNum.equals(dl.getCarEngineNum())){
            response.getWriter().write(mapper.writeValueAsString("发动机号有误"));
        }else if(!carFrame.equals(dl.getCarIdentificantionCode())){
            response.getWriter().write(mapper.writeValueAsString("车架号有误"));
        }else{
            response.getWriter().write(mapper.writeValueAsString(carNum));
            //System.out.println("vrd:"+vrd.toString());
        }
        response.getWriter().close();
    }

    @RequestMapping("/selectDriver.do")
    public String checkDriver(@RequestParam String carNum,Model model){
        List<ViolationRecord> vrd = this.userService.selectRecord(carNum);
        //ViolationRecord vrd = this.userService.selectRecord(carNum);
        model.addAttribute("violationRecord",vrd);
        return "drivingLicense";
    }

    @RequestMapping("/manager")
    public String toManager(){
        return "manager";
    }

    @RequestMapping("/toDriver")
    public String toDriver(){
        return "driver_table";
    }

    @RequestMapping("/testJson")
    @ResponseBody
    public DataGrid testJson(HttpServletRequest request, HttpServletResponse response,@RequestParam int page,int rows) throws IOException {
        System.out.println("page:"+page+",rows:"+rows);
        int count = this.userService.getCount_Driver();
        System.out.println(count);
        List<Driver> list  = this.userService.selectAllDriver(page, rows);

        DataGrid dg = new DataGrid();
        dg.setTotal(count);
        dg.setDriver(list);

        return dg;
    }
}
