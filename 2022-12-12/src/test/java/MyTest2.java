import com.cykj.utils.DbUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MyTest2 {
    /**
     * @description:注入测试
     * @author: chenhao
     * @date: 2022/12/7 11:49
     * @param: []
     * @return: void
     **/
    @Test
    public void t3(){
        Scanner sc = new Scanner(System.in);
        System.out.println("账号");
        String acc = sc.next();
        System.out.println("密码");
        String pwd = sc.next();

        DbUtils dbUtils = DbUtils.getInstance();
        Connection connection = dbUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from tblmanager where managerAcc="+acc+"and managerPwd"+pwd;
        System.out.println(sql);
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String managerAcc = resultSet.getString("managerAcc");
                String managerPwd = resultSet.getString("managerPwd");
                String realName = resultSet.getString("realName");
                System.out.println(managerAcc+"\t"+managerPwd+"\t"+realName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
