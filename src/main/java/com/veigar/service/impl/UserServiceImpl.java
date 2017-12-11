package com.veigar.service.impl;

/**
 * Created by Administrator on 2017/10/9.
 */
import com.veigar.dao.IUserDao;
import com.veigar.model.DrivingLicense;
import com.veigar.model.User;
import com.veigar.model.ViolationRecord;
import com.veigar.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;

    public User selectUser(long userId) {
        return this.userDao.selectUser(userId);
    }

    @Override
    public DrivingLicense selectDriver(String carNum) {
        return this.userDao.selectDriver(carNum);
    }

    @Override
    public ViolationRecord selectRecord(String carNum) {
        return this.userDao.selectRecord(carNum);
    }

}