package com.veigar.service.impl;

/**
 * Created by Administrator on 2017/10/9.
 */
import com.veigar.dao.IUserDao;
import com.veigar.model.Admin;
import com.veigar.model.Driver;
import com.veigar.model.DrivingLicense;
import com.veigar.model.ViolationRecord;
import com.veigar.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;

    @Override
    public DrivingLicense selectDriver(String carNum) {
        return this.userDao.selectDriver(carNum);
    }

    @Override
    public List<ViolationRecord> selectRecord(String carNum) {
        return  this.userDao.selectRecord(carNum);
    }

    @Override
    public String dataFilter(DrivingLicense drivingLicense) {
        String message="";
        DrivingLicense dl = selectDriver(drivingLicense.getCarNum());
        if(dl != null){
            dl.setCarEngineNum(dl.getCarEngineNum().substring(5));
            dl.setCarIdentificantionCode(dl.getCarIdentificantionCode().substring(11));
        }

        if(this.userDao.selectDriver(drivingLicense.getCarNum()) == null){
            message="车辆不存在";
        }else if(!dl.getCarType().equals(drivingLicense.getCarType())){
            message="车辆类型有误";
        }else if(!dl.getCarEngineNum().equals(drivingLicense.getCarEngineNum())){
            message="发动机号有误";
        }else if(!dl.getCarIdentificantionCode().equals(drivingLicense.getCarIdentificantionCode())){
            message="车架号有误";
        }else{
            message=dl.getCarNum();
        }
        return message;
    }

    @Override
    public List<Driver> selectAllDriver(int page,int rows) {
        HashMap map = new HashMap();
        map.put("page",page);
        map.put("rows",rows);
        return this.userDao.selectAllDriver(map);
    }

    @Override
    public List<DrivingLicense> selectAllDL(int page, int rows) {
        HashMap map = new HashMap();
        map.put("page",page);
        map.put("rows",rows);
        return this.userDao.selectAllDL(map);
    }

    @Override
    public List<ViolationRecord> selectAllVR(int page, int rows) {
        HashMap map = new HashMap();
        map.put("page",page);
        map.put("rows",rows);
        return this.userDao.selectAllVR(map);
    }

    @Override
    public int getCount_Driver() {
        return this.userDao.getCount_Driver();
    }

    @Override
    public int getCount_DL() {
        return this.userDao.getCount_DL();
    }

    @Override
    public int getCount_VR() {
        return this.userDao.getCount_VR();
    }

    @Override
    public void delById(int id) {
        this.userDao.delById(id);
    }

    @Override
    public void delDLById(int id) {
        this.userDao.delDLById(id);
    }

    @Override
    public void delVRById(int id) {
        this.userDao.delVRById(id);
    }

    @Override
    public void addDriver(Driver driver) {
        Map<String,Object> map = driverMap(driver);
        this.userDao.addDriver(map);
    }

    @Override
    public void addDL(DrivingLicense drivingLicense) {
        Map<String,Object> map = drivingLicenseMap(drivingLicense);
        this.userDao.addDL(map);
    }

    @Override
    public void addVR(ViolationRecord violationRecord) {
        Map<String,Object> map = violationRecordMap(violationRecord);
        this.userDao.addVR(map);
    }

    @Override
    public int checkDriver(Driver driver) {
        Map<String,Object> map = new HashMap<>();
        map.put("idCard",driver.getIdCard());
        map.put("carNum",driver.getCarNum());
        return this.userDao.checkDriver(map);
    }

    @Override
    public int checkDL(DrivingLicense drivingLicense) {
        Map<String,Object> map = new HashMap<>();
        map.put("carNum",drivingLicense.getCarNum());
        map.put("carIdentificantionCode",drivingLicense.getCarIdentificantionCode());
        map.put("carEngineNum",drivingLicense.getCarEngineNum());
        return this.userDao.checkDL(map);
    }

    @Override
    public int checkUser(String username) {

        return this.userDao.checkUser(username);
    }

    @Override
    public Map<String, Object> driverMap(Driver driver) {
        Map<String,Object> map = new HashMap<>();
        map.put("name",driver.getName());
        map.put("address",driver.getAddress());
        map.put("sex",driver.getSex());
        map.put("carNum",driver.getCarNum());
        map.put("idCard",driver.getIdCard());
        map.put("birth_Date",driver.getBirth_Date());
        map.put("issue_Date",driver.getIssue_Date());
        map.put("permit_Type",driver.getPermit_Type());
        map.put("expiration_Date",driver.getExpiration_Date());
        return map;
    }

    @Override
    public Map<String, Object> drivingLicenseMap(DrivingLicense drivingLicense) {
        Map<String,Object> map = new HashMap<>();
        map.put("carNum",drivingLicense.getCarNum());
        map.put("carType",drivingLicense.getCarType());
        map.put("carProperty",drivingLicense.getCarProperty());
        map.put("carBrand",drivingLicense.getCarBrand());
        map.put("carIdentificantionCode",drivingLicense.getCarIdentificantionCode());
        map.put("carEngineNum",drivingLicense.getCarEngineNum());
        map.put("registerDate",drivingLicense.getRegisterDate());
        map.put("issuingDate",drivingLicense.getIssuingDate());
        map.put("loadNum",drivingLicense.getLoadNum());
        return map;
    }

    @Override
    public Map<String, Object> violationRecordMap(ViolationRecord violationRecord) {
        Map<String,Object> map = new HashMap<>();
        map.put("carNum",violationRecord.getCarNum());
        map.put("vDate",violationRecord.getvDate());
        map.put("vContent",violationRecord.getvContent());
        map.put("vState",violationRecord.getvState());
        map.put("vPoints",violationRecord.getvPoints());
        map.put("vAddress",violationRecord.getvAddress());
        map.put("vMoney",violationRecord.getvMoney());
        map.put("vSMoney",violationRecord.getvSMoney());
        return map;
    }

    @Override
    public void registerAdmin(Admin admin) {
        HashMap<String ,Object> map = new HashMap<>();
        map.put("username",admin.getUsername());
        map.put("password",admin.getPassword());
        this.userDao.registerAdmin(map);
    }

    @Override
    public void modifyDriver(Driver driver) {
        Map<String,Object> map = driverMap(driver);
        map.put("id",driver.getId());
        this.userDao.modifyDriver(map);
    }

    @Override
    public void modifyDL(DrivingLicense drivingLicense) {
        Map<String,Object> map = drivingLicenseMap(drivingLicense);
        map.put("id",drivingLicense.getId());
        this.userDao.modifyDL(map);
    }

    @Override
    public int login(Admin admin) {
        Map<String,Object> map = new HashMap<>();
        map.put("username",admin.getUsername());
        map.put("password",admin.getPassword());
        return this.userDao.login(map);
    }

    @Override
    public void modifyPW(Admin admin) {
        Map<String,Object> map = new HashMap<>();
        map.put("username",admin.getUsername());
        map.put("password",admin.getPassword());
        this.userDao.modifyPW(map);
    }

    @Override
    public Driver selectDriverById(int i) {

        return this.userDao.selectDriverById(i);
    }

    @Override
    public DrivingLicense selectDLById(int i) {

        return this.userDao.selectDLById(i);
    }

    @Override
    public ViolationRecord selectVRById(int i) {
        return this.userDao.selectVRById(i);
    }

    @Override
    public void modifyVR(ViolationRecord violationRecord) {
        Map<String,Object> map = violationRecordMap(violationRecord);
        map.put("id",violationRecord.getId());
        this.userDao.modifyVR(map);
    }


}