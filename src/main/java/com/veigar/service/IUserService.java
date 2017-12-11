package com.veigar.service;

/**
 * Created by Administrator on 2017/10/9.
 */
import com.veigar.model.DrivingLicense;
import com.veigar.model.User;
import com.veigar.model.ViolationRecord;

public interface IUserService {

     User selectUser(long userId);
     DrivingLicense selectDriver(String carNum);
     ViolationRecord selectRecord(String carNum);
}
