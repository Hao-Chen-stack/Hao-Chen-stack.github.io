import com.cykj.bean.Tblgoodtype;
import com.cykj.mapper.GoodTypeMapper;
import com.cykj.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Scanner;

public class GoodTypeTest {
    SqlSession session = MybatisUtils.getSession();
    GoodTypeMapper mapper = session.getMapper(GoodTypeMapper.class);
    /**
     * @description:查询
     * @author: chenhao
     * @date: 2022/12/8 13:57
     * @param: []
     * @return: void
     **/
    @Test
    public void findGoodTypeList(){
        //分页显示
//        RowBounds rowBounds = new RowBounds(0,3);
//        List<Tblgoodtype> tblgoodtypeList = session.selectList("com.cykj.mapper.GoodTypeMapper.findGoodTypeList",null,rowBounds);
        List<Tblgoodtype> tblgoodtypeList = session.selectList("com.cykj.mapper.GoodTypeMapper.findGoodTypeList");
        for (Tblgoodtype tblgoodtype : tblgoodtypeList) {
            System.out.println(tblgoodtype);
        }

    }
    /**
     * @description:增加
     * @author: chenhao
     * @date: 2022/12/8 13:58
     * @param: []
     * @return: void
     **/
    @Test
    public void addGoodType(){
        //获取键盘输入
        Scanner sc = new Scanner(System.in);
        System.out.println("管理员id");
        int managerId = sc.nextInt();
        System.out.println("商品类型名称");
        String gtypeName = sc.next();
        System.out.println("父类id");
        int parentId = sc.nextInt();
        System.out.println("状态");
        int gtypeStatus = sc.nextInt();

        Tblgoodtype tblgoodtype = new Tblgoodtype();
        tblgoodtype.setManagerId(managerId);
        tblgoodtype.setGtypeName(gtypeName);
        tblgoodtype.setParentId(parentId);
        tblgoodtype.setGtypeStatus(gtypeStatus);

        int i = mapper.addGoodType(tblgoodtype);
        //提交事务
        session.commit();
        System.out.println(tblgoodtype.getGtypeId());
        System.out.println(i);
    }

    /**
     * @description:改
     * @author: chenhao
     * @date: 2022/12/8 14:42
     * @param: []
     * @return: void
     **/
    @Test
    public void updateGoodType(){
        //获取键盘输入
        Scanner sc = new Scanner(System.in);
        System.out.println("需要修改的商品类型id");
        int gtypeId = sc.nextInt();
        System.out.println("修改后的管理员id");
        int managerId = sc.nextInt();
        System.out.println("修改后的商品类型名称");
        String gtypeName = sc.next();
        System.out.println("修改后的父类id");
        int parentId = sc.nextInt();
        System.out.println("修改后的状态");
        int gtypeStatus = sc.nextInt();

        Tblgoodtype tblgoodtype = new Tblgoodtype();
        tblgoodtype.setGtypeId(gtypeId);
        tblgoodtype.setManagerId(managerId);
        tblgoodtype.setGtypeName(gtypeName);
        tblgoodtype.setParentId(parentId);
        tblgoodtype.setGtypeStatus(gtypeStatus);

        int i = mapper.updateGoodType(tblgoodtype);
        //提交事务
        session.commit();
        System.out.println(i);
    }

    /**
     * @description:删
     * @author: chenhao
     * @date: 2022/12/8 14:42
     * @param:
     * @return:
     **/
    @Test
    public void delGoodType(){
        //获取键盘输入
        Scanner sc = new Scanner(System.in);
        System.out.println("需要删除的商品类型id");
        int gtypeId = sc.nextInt();

        int i = mapper.delGoodType(gtypeId);
        //提交事务
        session.commit();
        System.out.println(i);
    }
}
