package com.baayso.springbeetlsql.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baayso.springbeetlsql.common.service.CommonService;
import com.baayso.springbeetlsql.user.dao.UserDao;
import com.baayso.springbeetlsql.user.entity.User;

/**
 * User Service.
 *
 * @author ChenFangjie (2016/2/27 19:33)
 * @since 1.0.0
 */
@Service
public class UserService extends CommonService<User, Long> {

    public List<User> queryList(String phone) {
        UserDao userDao = super.getSQLManager().getMapper(UserDao.class);

        return userDao.queryList(phone);
    }

}
