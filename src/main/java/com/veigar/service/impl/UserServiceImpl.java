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
    public DrivingLicense dataFilter(DrivingLicense drivingLicense) {
        DrivingLicense drivingLicense1 = selectDriver(drivingLicense.getCarNum());
        if(drivingLicense1 != null){
            drivingLicense1.setCarEngineNum(drivingLicense1.getCarEngineNum().substring(5));
            drivingLicense1.setCarIdentificantionCode(drivingLicense1.getCarIdentificantionCode().substring(11));
        }
        return drivingLicense1;
    }

    @Override
    public List<Driver> selectAllDriver(int page,int rows) {
        HashMap map = new HashMap();
        map.put("page",page);
        map.put("rows",rows);
        return this.userDao.selectAllDriver(map);
    }

    @Override
    public int getCount_Driver() {
        return this.userDao.getCount_Driver();
    }

    @Override
    public void delById(int id) {
        this.userDao.delById(id);
    }

    @Override
    public int addDriver(Driver driver) {
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
        return this.userDao.addDriver(map);
    }

    @Override
    public int checkDriver(Driver driver) {
        Map<String,Object> map = new HashMap<>();
        map.put("idCard",driver.getIdCard());
        map.put("carNum",driver.getCarNum());
        return this.userDao.checkDriver(map);
    }

    @Override
    public int login(Admin admin) {
        Map<String,Object> map = new HashMap<>();
        map.put("username",admin.getUsername());
        map.put("password",admin.getPassword());
        return this.userDao.login(map);
    }


}