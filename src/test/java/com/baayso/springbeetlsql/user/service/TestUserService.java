package com.baayso.springbeetlsql.user.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.dbunit.DatabaseUnitException;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.baayso.springbeetlsql.test.utils.AbstractDbUnitTestCase;
import com.baayso.springbeetlsql.test.utils.EntitiesHelper;
import com.baayso.springbeetlsql.user.entity.User;

/**
 * Test class for {@linkplain com.baayso.springbeetlsql.user.service.UserService}.
 *
 * @author ChenFangjie (2016/2/28 11:55)
 * @since 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestUserService extends AbstractDbUnitTestCase {

    @Inject
    private UserService userService;

    @Before
    public void setUp() throws DataSetException, SQLException, IOException {
        super.backupAllTable();
    }

    @After
    public void tearDown() throws FileNotFoundException, DatabaseUnitException, SQLException {
        super.resumeTable();
    }

    @Test
    public void testFindOne() throws DatabaseUnitException, SQLException {
        IDataSet ds = super.createDateSet("t_user");
        DatabaseOperation.CLEAN_INSERT.execute(AbstractDbUnitTestCase.dbunitCon, ds);

        User user = this.userService.findOne(1L);

        System.out.println("toString: " + user);

        EntitiesHelper.assertUser(user);
    }

    @Test
    public void testFinds() throws DatabaseUnitException, SQLException {
        IDataSet ds = super.createDateSet("t_user");
        DatabaseOperation.CLEAN_INSERT.execute(AbstractDbUnitTestCase.dbunitCon, ds);

        List<User> users = this.userService.queryList("13712345678");

        System.out.println("======");
        System.out.println(users);
    }

}
