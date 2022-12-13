import com.cykj.bean.Tblmanager;
import com.cykj.mapper.TblmanagerMapper;
import com.cykj.utils.MybatisUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Scanner;

public class ManagerLoginRegTest {
    SqlSession session = MybatisUtils.getSession();
    TblmanagerMapper mapper = session.getMapper(TblmanagerMapper.class);

    //登录
    @Test
    public void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入管理员账号：");
        String managerAcc = scanner.next();
        System.out.println("请输入管理员密码：");
        String managerPwd = scanner.next();
        Tblmanager tblmanager = mapper.login(managerAcc);
        if (tblmanager == null) {
            System.out.println("账号输入有误");
        } else {
            if (tblmanager.getManagerPwd().equals(managerPwd)) {
                System.out.println("登录成功");
            } else {
                System.out.println("登录失败");
            }
        }
    }

    //注册
    @Test
    public void logon() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入角色id：");
        int roleId = scanner.nextInt();
        System.out.println("请输入管理员账号：");
        String managerAcc = scanner.next();
        System.out.println("请输入管理员密码：");
        String managerPwd = scanner.next();
        System.out.println("请输入管理员名字：");
        String realName = scanner.next();

        Tblmanager tblmanager = new Tblmanager();
        tblmanager.setRoleId(roleId);
        tblmanager.setManagerAcc(managerAcc);
        tblmanager.setManagerPwd(managerPwd);
        tblmanager.setRealName(realName);
        tblmanager.setManagerStatus(1);

        int i = mapper.logonAcc(managerAcc);
        if (i<=0){
            int logon = mapper.logon(tblmanager);
            System.out.println(logon);
            System.out.println("注册成功");
            session.commit();
        }else {
            System.out.println("该账户已存在");
        }

    }

}
