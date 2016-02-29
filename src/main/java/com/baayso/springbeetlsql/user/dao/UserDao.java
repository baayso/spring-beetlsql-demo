package com.baayso.springbeetlsql.user.dao;

import java.util.List;

import org.beetl.sql.core.annotatoin.Param;
import org.beetl.sql.core.mapper.BaseMapper;

import com.baayso.springbeetlsql.user.entity.User;

/**
 * User Data Access Object.
 *
 * @author ChenFangjie (2016/2/27 20:27)
 * @since 1.0.0
 */
public interface UserDao extends BaseMapper<User> {

    List<User> queryList(@Param("phone") String phone);

}
