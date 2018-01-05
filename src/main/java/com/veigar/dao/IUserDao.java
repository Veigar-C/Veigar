package com.veigar.dao;
import com.veigar.model.Driver;
import com.veigar.model.DrivingLicense;
import com.veigar.model.ViolationRecord;
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
    int getCount_Driver();
    void delById(int id);
    int addDriver(Map<String,Object> map);
    int checkDriver(Map<String,Object> map);
}
