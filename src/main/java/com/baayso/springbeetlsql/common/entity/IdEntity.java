package com.baayso.springbeetlsql.common.entity;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * 统一定义主键（id）的Entity基类。
 *
 * @author ChenFangjie (2016/2/27 18:50)
 * @since 1.0.0
 */
@Getter
@Setter
public abstract class IdEntity implements Serializable {

    private static final long serialVersionUID = 6612949044163144696L;

    /** 主键 */
    protected Long id;

}
