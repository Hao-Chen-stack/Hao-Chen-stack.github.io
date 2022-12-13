import com.cykj.bean.Tbladdress;
import com.cykj.bean.Tblmanager;
import com.cykj.bean.Tblrole;
import com.cykj.mapper.TblmanagerMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.DriverManager;

public class ApplicationTest {

    @Test
    public void t1() {
        //获取Spring容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取容器中指定的对象
//        Tbladdress bean = ac.getBean("address1",Tbladdress.class);
//        System.out.println(bean.hashCode());
//        Tbladdress bean2 = ac.getBean("address1",Tbladdress.class);
//        System.out.println(bean2.hashCode());

        //返回容器中所有对象的名字
        String[] names = ac.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        //返回容器中所有对象的数量
        int count = ac.getBeanDefinitionCount();
        System.out.println(count);

        Tblmanager tblmanager = ac.getBean(Tblmanager.class);
        System.out.println(tblmanager);
    }

    @Test
    public void t2() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Tblrole user = ac.getBean("user", Tblrole.class);
        System.out.println(user);
    }

    @Test
    public void t3() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Tblmanager manager2 = ac.getBean("manager2", Tblmanager.class);
        System.out.println(manager2);
    }

    @Test
    public void t4() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Tblmanager manager3 = ac.getBean("manager3", Tblmanager.class);
        System.out.println(manager3);
    }

    @Test
    public void t5() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext2.xml");
        //返回容器中所有对象的名字
        String[] names = ac.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
//        Tbladdress tbladdress = ac.getBean("tbladdress", Tbladdress.class);
////        System.out.println(tbladdress);
//        Tblmanager tblmanager = ac.getBean(Tblmanager.class);
//        System.out.println(tblmanager);
        DriverManagerDataSource datasource = ac.getBean("datasource", DriverManagerDataSource.class);
        System.out.println(datasource.getUsername());
        System.out.println(datasource.getPassword());
        System.out.println(datasource.getUrl());
        System.out.println(datasource);
    }
}
