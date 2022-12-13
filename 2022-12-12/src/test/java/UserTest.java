import com.cykj.bean.Tbluser;
import com.cykj.mapper.UserMapper;
import com.cykj.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Scanner;

public class UserTest {
    SqlSession session = MybatisUtils.getSession();
    UserMapper mapper = session.getMapper(UserMapper.class);
    /**
     * @description:查询
     * @author: chenhao
     * @date: 2022/12/8 16:20
     * @param: []
     * @return: void
     **/
    @Test
    public void findUserList(){
        //分页显示
//        RowBounds rowBounds = new RowBounds(0,3);
//        List<Tblgoodtype> tblgoodtypeList = session.selectList("com.cykj.mapper.GoodTypeMapper.findGoodTypeList",null,rowBounds);
        List<Tbluser> tbluserList = session.selectList("com.cykj.mapper.UserMapper.findUserList");
        for (Tbluser tbluser : tbluserList) {
            System.out.println(tbluser);
        }

    }
    /**
     * @description:增加
     * @author: chenhao
     * @date: 2022/12/8 16:21
     * @param: []
     * @return: void
     **/
    @Test
    public void addUser(){
        //获取键盘输入
        Scanner sc = new Scanner(System.in);
        System.out.println("用户账号");
        String userAcc = sc.next();
        System.out.println("用户密码");
        String userPwd = sc.next();
        System.out.println("用户性别");
        int userSex = sc.nextInt();
        System.out.println("用户状态");
        int userStatus = sc.nextInt();
        System.out.println("用户手机号");
        String userPhone = sc.next();

        Tbluser tbluser = new Tbluser();
        tbluser.setUserAcc(userAcc);
        tbluser.setUserPwd(userPwd);
        tbluser.setUserSex(userSex);
        tbluser.setUserStatus(userStatus);
        tbluser.setUserPhone(userPhone);

        int i = mapper.addUser(tbluser);
        //提交事物
        session.commit();
        System.out.println(tbluser.getUserId());
        System.out.println(i);

    }

    /**
     * @description:修改
     * @author: chenhao
     * @date: 2022/12/8 16:21
     * @param: []
     * @return: void
     **/
    @Test
    public void updateUser(){
        //获取键盘输入
        Scanner sc = new Scanner(System.in);
        System.out.println("需要修改的用户id");
        int userId = sc.nextInt();
        System.out.println("修改后的用户账号");
        String userAcc = sc.next();
        System.out.println("修改后的用户密码");
        String userPwd = sc.next();
        System.out.println("修改后的用户性别");
        int userSex = sc.nextInt();
        System.out.println("修改后的用户状态");
        int userStatus = sc.nextInt();
        System.out.println("修改后的用户手机号");
        String userPhone = sc.next();

        Tbluser tbluser = new Tbluser();
        tbluser.setUserId(userId);
        tbluser.setUserAcc(userAcc);
        tbluser.setUserPwd(userPwd);
        tbluser.setUserSex(userSex);
        tbluser.setUserStatus(userStatus);
        tbluser.setUserPhone(userPhone);

        int i = mapper.updateUser(tbluser);
        //提交事务
        session.commit();
        System.out.println(i);
    }

    /**
     * @description:删除
     * @author: chenhao
     * @date: 2022/12/8 16:21
     * @param: []
     * @return: void
     **/
    @Test
    public void delUser(){
        //获取键盘输入
        Scanner sc = new Scanner(System.in);
        System.out.println("需要删除的用户id");
        int userId = sc.nextInt();

        int i = mapper.delUser(userId);
        //提交事务
        session.commit();
        System.out.println(i);
    }

    @Test
    public void findUserAddress(){
        List<Tbluser> tbluserList = mapper.findUserAddress(1);
        for (Tbluser tbluser : tbluserList) {
            System.out.println(tbluser);
        }
    }

    /**
     * @description:一对多查询用户收藏夹列表
     * @author: chenhao
     * @date: 2022/12/11 20:10
     **/
    @Test
    public void findUserCollection(){
        List<Tbluser> tblusers = mapper.findUserCollection(1);
        for (Tbluser tbluser : tblusers) {
            System.out.println(tbluser);
        }
    }
}
