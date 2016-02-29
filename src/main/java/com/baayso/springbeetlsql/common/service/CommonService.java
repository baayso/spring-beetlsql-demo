package com.baayso.springbeetlsql.common.service;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.inject.Inject;

import org.beetl.sql.core.SQLManager;
import org.beetl.sql.ext.spring.SpringBeetlSql;

/**
 * Common Service.
 *
 * @author ChenFangjie (2016/2/27 19:37)
 * @since 1.0.0
 */
public abstract class CommonService<T, ID extends Serializable> {

    @Inject
    protected SpringBeetlSql beetlsql;

    protected Class<T> entityClass;

    public CommonService() {
        // 通过反射获取子类类型以确定T的类型
        ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
        Type[] types = parameterizedType.getActualTypeArguments();

        this.entityClass = (Class<T>) types[0];
    }

    protected SQLManager getSQLManager() {
        return this.beetlsql.getSQLMananger();
    }

    /**
     * 保存一个实体，null的属性不会保存，会使用数据库默认值。
     *
     * @param entity 需要保存的实体
     *
     * @return 受影响的行数
     *
     * @since 1.0.0
     */
    public <S extends T> int save(S entity) {
        return this.getSQLManager().insert(entity);
    }

    /**
     * 根据主键进行删除。
     *
     * @param key 主键
     *
     * @return 受影响的行数
     *
     * @since 1.0.0
     */
    public int delete(ID key) {
        return this.getSQLManager().deleteById(this.entityClass, key);
    }

    /**
     * 根据主键更新实体属性不为null的值。
     *
     * @param entity 封装了更新条件和更新内容的实体
     *
     * @return 受影响的行数
     *
     * @since 1.0.0
     */
    public int update(T entity) {
        return this.getSQLManager().updateTemplateById(entity);
    }

    /**
     * 根据主键查询，获取唯一记录，如果纪录不存在则返回null。
     *
     * @param key 主键
     *
     * @return 查询到的实体
     *
     * @since 1.0.0
     */
    public T findOne(ID key) {
        T entity;

        try {
            entity = this.getSQLManager().unique(this.entityClass, key);
        }
        catch (Exception e) {
            entity = null;
        }

        return entity;
    }

    /**
     * 查询全部数据。
     *
     * @return 查询到的全部数据
     *
     * @since 1.0.0
     */
    public List<T> findAll() {
        return this.getSQLManager().all(this.entityClass);
    }

}
