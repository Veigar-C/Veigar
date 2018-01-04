package com.veigar.service;

/**
 * Created by Administrator on 2017/10/9.
 */
import com.veigar.model.Driver;
import com.veigar.model.DrivingLicense;
import com.veigar.model.ViolationRecord;

import java.util.List;

public interface IUserService {

     DrivingLicense selectDriver(String carNum);
     List<ViolationRecord> selectRecord(String carNum);
     DrivingLicense dataFilter(DrivingLicense drivingLicense);
     List<Driver> selectAllDriver(int page,int rows);
     int getCount_Driver();
     void delById(int id);
}
