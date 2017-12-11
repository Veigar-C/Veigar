package com.veigar.dao;
import com.veigar.model.DrivingLicense;
import com.veigar.model.User;
import com.veigar.model.ViolationRecord;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/10/9.
 */

@Repository
public interface IUserDao {
    User selectUser(long id);
    DrivingLicense selectDriver(String carNum);
    ViolationRecord selectRecord(String carNum);
}
