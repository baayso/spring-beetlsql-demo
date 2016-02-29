package com.baayso.springbeetlsql.test.utils;

import java.util.List;

import com.baayso.springbeetlsql.user.entity.User;

import junit.framework.Assert;

public class EntitiesHelper {

    private static User baseUser = null;

    static {
        baseUser = new User();
        baseUser.setId(1L);
        baseUser.setPhone("13712345678");
        baseUser.setName("admin1");
    }

    public static void assertUser(User expected, User actual) {
        Assert.assertNotNull(expected);
        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getPhone(), actual.getPhone());
        Assert.assertEquals(expected.getName(), actual.getName());
    }

    public static void assertUsers(List<User> expected, List<User> actual) {
        for (int i = 0; i < expected.size(); i++) {
            User eu = expected.get(i);
            User au = actual.get(i);
            assertUser(eu, au);
        }
    }

    public static void assertUser(User expected) {
        assertUser(expected, baseUser);
    }
}
