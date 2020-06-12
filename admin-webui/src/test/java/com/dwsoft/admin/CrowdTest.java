package com.dwsoft.admin;

import com.dwsoft.admin.entity.Admin;
import com.dwsoft.admin.mapper.AdminMapper;
import com.dwsoft.admin.service.api.AdminService;
import org.apache.ibatis.jdbc.Null;
import org.apache.taglibs.standard.tag.common.core.ForTokensSupport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sun.font.FontRunIterator;
import sun.text.resources.cldr.rm.FormatData_rm;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author tlk
 * @date 2020/5/16-15:25
 */
// 指定 Spring 给 Junit 提供的运行器类
@RunWith(SpringJUnit4ClassRunner.class)
// 加载 Spring 配置文件的注解
@ContextConfiguration(locations = {"classpath:spring-persist-mybatis.xml","classpath:spring-persist-tx.xml"})
public class CrowdTest {
    @Autowired
    private  DataSource dataSource;
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private AdminService adminService;
    @Test
    public  void  testDataSource() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println(connection);


    }
    @Test
    public  void  testAdminMapperInsert() throws SQLException {
        Admin admin=new Admin(null,"123","456","tom","tom@qq.com",null);
        adminMapper.insert(admin);
    }
    @Test
    public  void  testAdminServiceInsert() throws SQLException {
        Admin admin=new Admin(null,"123","456","tom","tom@qq.com",null);
        adminService.saveAdmin(admin);
    }
    @Test
    public  void  testAdminServiceAll() throws SQLException {
//        List<Admin> adminList = adminService.getAll();
//        System.out.println(adminList);
    }
    @Test
    public void testList(){
        List<Menu> list=new ArrayList();
        Menu m1= new Menu();
        m1.setId(1);
        m1.setPid(null);
        m1.setName("m1");
        list.add(m1);
        Menu m2= new Menu();
        m2.setId(2);
        m2.setPid(1);
        m2.setName("m2");
        list.add(m2);
        Menu m3= new Menu();
        m3.setId(3);
        m3.setPid(1);
        m3.setName("m3");
        list.add(m3);
        Menu m4= new Menu();
        m4.setId(4);
        m4.setPid(2);
        m4.setName("m4");
        list.add(m4);
        Menu root=null;
        for (Menu m:list){
            Integer pid = m.getPid();
            if(pid==null){
                root=m;
            continue;
            }
            for (Menu m_:list){
                Integer id = m_.getId();
                if(Objects.equals(pid,id)){
                    m_.getChild().add(m);
                    continue;
                }

            }
        }
        System.out.println(root);
        Menu t1=null;
        Menu t2=null;
        for (Menu n1:list){
            if(n1.getId()==2){
                t1=n1;
            }
        }
        for (Menu n2:list){
            if(n2.getId()==2){
                t2=n2;
            }
        }

        System.out.println(t1);
        System.out.println(t2);
        t2.getChild().add(m3);
        System.out.println(t1);
        System.out.println(t2);
    }

}
