import com.cykj.bean.Tblregion;
import com.cykj.mapper.RegionMapper;
import com.cykj.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Scanner;

public class RegionTest {
    SqlSession session = MybatisUtils.getSession();
    RegionMapper mapper = session.getMapper(RegionMapper.class);
    /**
     * @description:查询
     * @author: chenhao
     * @date: 2022/12/8 15:46
     * @param: []
     * @return: void
     **/
    @Test
    public void findRegionList(){
        //分页显示
//        RowBounds rowBounds = new RowBounds(0,3);
//        List<Tblgoodtype> tblgoodtypeList = session.selectList("com.cykj.mapper.GoodTypeMapper.findGoodTypeList",null,rowBounds);
        List<Tblregion> tblregionList = session.selectList("com.cykj.mapper.RegionMapper.findRegionList");
        for (Tblregion tblregion : tblregionList) {
            System.out.println(tblregion);
        }

    }

    /**
     * @description:插入
     * @author: chenhao
     * @date: 2022/12/8 15:47
     * @param: []
     * @return: void
     **/
    @Test
    public void addRegion(){
        //获取键盘输入
        Scanner sc = new Scanner(System.in);
        System.out.println("区域名称");
        String regionName = sc.next();
        System.out.println("父级id");
        String parentId = sc.next();
        System.out.println("区域状态");
        int regionStatus = sc.nextInt();

        Tblregion tblregion = new Tblregion();
        tblregion.setRegionName(regionName);
        tblregion.setParentId(parentId);
        tblregion.setRegionStatus(regionStatus);

        int i = mapper.addRegion(tblregion);
        //提交事务
        session.commit();
        System.out.println(tblregion.getRegionId());
        System.out.println(i);
    }

    /**
     * @description:修改
     * @author: chenhao
     * @date: 2022/12/8 15:47
     * @param: []
     * @return: void
     **/
    @Test
    public void updateRegion(){
        //获取键盘输入
        Scanner sc = new Scanner(System.in);
        System.out.println("需要修改的区域id");
        int regionId = sc.nextInt();
        System.out.println("修改后的区域名称");
        String regionName = sc.next();
        System.out.println("修改后的父级id");
        String parentId = sc.next();
        System.out.println("修改后的区域状态");
        int regionStatus = sc.nextInt();

        Tblregion tblregion = new Tblregion();
        tblregion.setRegionId(regionId);
        tblregion.setRegionName(regionName);
        tblregion.setParentId(parentId);
        tblregion.setRegionStatus(regionStatus);

        int i = mapper.updateRegion(tblregion);
        //提交事物
        session.commit();
        System.out.println(i);

    }

    /**
     * @description:删除
     * @author: chenhao
     * @date: 2022/12/8 15:47
     * @param: []
     * @return: void
     **/
    @Test
    public void delRegion(){
        //获取键盘输入
        Scanner sc = new Scanner(System.in);
        System.out.println("需要删除的区域id");
        int regionId = sc.nextInt();

        int i = mapper.delRegion(regionId);
        //提交事务
        session.commit();
        System.out.println(i);
    }
}
