package com.veigar.service;

/**
 * Created by Administrator on 2017/10/9.
 */
import com.veigar.model.Admin;
import com.veigar.model.Driver;
import com.veigar.model.DrivingLicense;
import com.veigar.model.ViolationRecord;

import java.util.List;
import java.util.Map;

public interface IUserService {

     DrivingLicense selectDriver(String carNum);
     List<ViolationRecord> selectRecord(String carNum);
     String dataFilter(DrivingLicense drivingLicense);
     List<Driver> selectAllDriver(int page,int rows);
     List<DrivingLicense> selectAllDL(int page,int rows);
     List<ViolationRecord> selectAllVR(int page,int rows);
     int getCount_Driver();
     int getCount_DL();
     int getCount_VR();
     void delById(int id);
     void delDLById(int id);
     void delVRById(int id);
     void addDriver(Driver driver);
     void addDL(DrivingLicense drivingLicense);
     void addVR(ViolationRecord violationRecord);
     int checkDriver(Driver driver);
     int checkDL(DrivingLicense drivingLicense);
     int checkUser(String username);
     Map<String,Object> driverMap(Driver driver);
     Map<String,Object> drivingLicenseMap(DrivingLicense drivingLicense);
     Map<String,Object> violationRecordMap(ViolationRecord violationRecord);
     void registerAdmin(Admin admin);
     void modifyDriver(Driver driver);
     void modifyDL(DrivingLicense drivingLicense);
     int login(Admin admin);
     void modifyPW(Admin admin);
     Driver selectDriverById(int i);
     DrivingLicense selectDLById(int i);
     ViolationRecord selectVRById(int i);
     void modifyVR(ViolationRecord violationRecord);
}
