package com.veigar.service.impl;

/**
 * Created by Administrator on 2017/10/9.
 */
import com.veigar.dao.IUserDao;
import com.veigar.model.Driver;
import com.veigar.model.DrivingLicense;
import com.veigar.model.ViolationRecord;
import com.veigar.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

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


}