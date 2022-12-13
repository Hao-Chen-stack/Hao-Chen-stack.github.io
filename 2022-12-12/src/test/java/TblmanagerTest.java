import com.cykj.bean.Tblmanager;
import com.cykj.mapper.TblmanagerMapper;
import com.cykj.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TblmanagerTest {
    SqlSession session = MybatisUtils.getSession();
    TblmanagerMapper mapper = session.getMapper(TblmanagerMapper.class);
    @Test
    public void findManagerList(){
        List<Tblmanager> tblmanagerList = session.selectList("com.cykj.mapper.TblmanagerMapper.findManagerList");
//        List<Tblmanager> tblmanagerList = mapper.findManagerList();
        for (Tblmanager tblmanager : tblmanagerList) {
            System.out.println(tblmanager);
        }
    }

    @Test
    public void findManagerListByName(){
        List<Tblmanager> managerList = mapper.findManagerListByName("远");
        for (Tblmanager tblmanager : managerList) {
            System.out.println(tblmanager);
        }
    }

    @Test
    public void addManager(){
        Tblmanager tblmanager = new Tblmanager();
        tblmanager.setRoleId(1);
        tblmanager.setManagerAcc("7");
        tblmanager.setManagerPwd("123");
        tblmanager.setRealName("七七");
        tblmanager.setManagerStatus(1);


        int i = mapper.addManager(tblmanager);
        //提交事务
        session.commit();

        System.out.println(tblmanager.getManagerId());
        System.out.println(i);
    }

    @Test
    public void delManager(){
        int i = mapper.delManager(9);
        //提交事务
        session.commit();
        System.out.println(i);
    }

    @Test
    public void updateTblmanager(){
        Tblmanager tblmanager = new Tblmanager();
        tblmanager.setManagerId(8);
        tblmanager.setRoleId(999);
        tblmanager.setManagerAcc("7");
        tblmanager.setManagerPwd("123");
        tblmanager.setRealName("张菲菲");
        tblmanager.setManagerStatus(1);

        int i = mapper.updateManager(tblmanager);
        //提交事务
        session.commit();
        System.out.println(i);
    }

    /**
     * @description:一对一映射：嵌套
     * @author: chenhao
     * @date: 2022/12/9 9:28
     **/
    @Test
    public void findManager(){
        List<Tblmanager> manager = mapper.findManager(1);
        for (Tblmanager tblmanager : manager) {
            System.out.println(tblmanager);
        }
    }

    @Test
    public void findManager2(){
        List<Tblmanager> manager = mapper.findManager2();
        for (Tblmanager tblmanager : manager) {
            System.out.println(tblmanager);
        }
    }
    @Test
    public void findManager3(){
        List<Tblmanager> manager = mapper.findManager3();
        for (Tblmanager tblmanager : manager) {
            System.out.println(tblmanager);
        }
    }

    //动态sql
    @Test
    public void findManager4(){
        List<Tblmanager> manager4 = mapper.findManager4(2, null, -1);
    }

    //批量添加
    @Test
    public void addManagerList(){
        List<Tblmanager> managerList = new ArrayList<>();
        managerList.add(new Tblmanager(1,"张三"));
        managerList.add(new Tblmanager(2,"李四"));
        managerList.add(new Tblmanager(2,"王五"));
        managerList.add(new Tblmanager(1,"老六"));

        int i  = mapper.addManagerList(managerList);
        session.commit();
        System.out.println(i);
    }
}
