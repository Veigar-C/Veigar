package com.veigar.dao;
import com.veigar.model.ComplainRecord;
import com.veigar.model.Driver;
import com.veigar.model.DrivingLicense;
import com.veigar.model.ViolationRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/9.
 */

@Repository
public interface IUserDao {
    DrivingLicense selectDriver(String carNum);
    List<ViolationRecord> selectRecord(String carNum);
    List<Driver> selectAllDriver(HashMap map);
    List<DrivingLicense> selectAllDL(HashMap map);
    List<ViolationRecord> selectAllVR(HashMap map);
    List<ComplainRecord> selectAllCR();
    int getCount_Driver();
    int getCount_DL();
    int getCount_VR();
    void delById(int id);
    void delDLById(int id);
    void delVRById(int id);
    void delCRById(int id);
    void addDriver(Map<String,Object> map);
    void addDL(Map<String,Object> map);
    void addVR(Map<String,Object> map);
    void modifyDL(Map<String,Object> map);
    void modifyDriver(Map<String,Object> map);
    void registerAdmin(Map<String,Object> map);
    int checkDriver(Map<String,Object> map);
    int checkDL(Map<String,Object> map);
    int checkUser(String username);
    int login(Map<String,Object> map);
    Driver selectDriverById(int i);
    DrivingLicense selectDLById(int i);
    ViolationRecord selectVRById(int i);
    void modifyPW(Map<String,Object> map);
    void modifyVR(Map<String,Object> map);
    void submitCR(@Param("code") String code,@Param("phone") String phone,@Param("content") String content);
}
