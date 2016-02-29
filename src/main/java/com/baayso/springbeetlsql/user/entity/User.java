package com.baayso.springbeetlsql.user.entity;

import java.util.Date;

import org.beetl.sql.core.annotatoin.Table;

import com.baayso.springbeetlsql.common.entity.IdEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户实体。
 *
 * @author ChenFangjie (2016/2/27 18:48)
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "t_user")
public class User extends IdEntity {

    private static final long serialVersionUID = 7701299946925929051L;

    private String  phone;      // 手机号码
    private String  password;   // 密码
    private String  salt;       // 密码盐
    private String  email;      // 电子邮件
    private String  name;       // 真实姓名
    private String  username;   // 用户名
    private String  nickname;   // 昵称
    private Integer gender;     // 性别
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date    birthdate;  // 出生日期
    private String  intro;      // 简介
    private Date    createTime; // 简介

}
