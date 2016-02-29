package com.baayso.springbeetlsql.user.entity;

import org.apache.commons.lang3.StringUtils;

/**
 * 用户性别枚举。
 *
 * @author ChenFangjie (2015年2月3日 上午10:29:28)
 * @since 1.0.0
 */
public enum UserGender {

    /** 保密 */
    SECRET("保密"),

    /** 男 */
    MALE("男"),

    /** 女 */
    FEMALE("女");

    private String desc;

    /**
     * 返回当前性别的描述。
     *
     * @since 1.0.0
     */
    public String getDesc() {
        return desc;
    }

    private UserGender(String desc) {
        this.desc = desc;
    }

    /**
     * 返回指定序数的枚举常量。
     *
     * @param ordinal 枚举常量的序数
     *
     * @return 枚举序数对应的枚举
     *
     * @throws IllegalArgumentException 如果该序数没有指定的枚举
     * @since 1.0.0
     */
    public static UserGender valueOf(int ordinal) {
        for (UserGender gender : values()) {
            if (gender.ordinal() == ordinal) {
                return gender;
            }
        }

        throw new IllegalArgumentException("No matching constant for [" + ordinal + "]");
    }

    /**
     * 返回指定描述的枚举常量。
     *
     * @param desc 枚举常量的描述
     *
     * @return 枚举描述对应的枚举
     *
     * @throws IllegalArgumentException 如果该描述没有指定的枚举
     * @since 1.0.0
     */
    public static UserGender valueOfDesc(String desc) {
        for (UserGender gender : values()) {
            if (gender.getDesc().equals(desc)) {
                return gender;
            }
        }

        throw new IllegalArgumentException("No matching constant for [" + desc + "]");
    }

    /**
     * 是否包含指定名称的枚举项。
     *
     * @param name 指定名称
     *
     * @return 当传入的名称包含在枚举项中时返回true，否则返回false
     *
     * @since 1.0.0
     */
    public static boolean contains(String name) {
        if (StringUtils.isNotBlank(name)) {
            // 所有的枚举值
            UserGender[] values = UserGender.values();
            // 遍历查找
            for (UserGender gender : values) {
                if (gender.name().equals(name)) {
                    return true;
                }
            }
        }

        return false;
    }

}
