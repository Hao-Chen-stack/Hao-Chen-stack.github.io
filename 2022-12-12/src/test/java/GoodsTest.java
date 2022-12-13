import com.cykj.bean.Tblgoods;
import com.cykj.mapper.GoodsMapper;
import com.cykj.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GoodsTest {
    SqlSession session = MybatisUtils.getSession();
    GoodsMapper mapper = session.getMapper(GoodsMapper.class);

    /**
     * @description:查询
     * @author: chenhao
     * @date: 2022/12/8 15:10
     * @param: []
     * @return: void
     **/
    @Test
    public void findGoodsList() {
        //分页显示
//        RowBounds rowBounds = new RowBounds(0,3);
//        List<Tblgoodtype> tblgoodtypeList = session.selectList("com.cykj.mapper.GoodTypeMapper.findGoodTypeList",null,rowBounds);
        List<Tblgoods> tblgoodsList = session.selectList("com.cykj.mapper.GoodsMapper.findGoodsList");
        for (Tblgoods tblgoods : tblgoodsList) {
            System.out.println(tblgoods);
        }

    }

    /**
     * @description:插入
     * @author: chenhao
     * @date: 2022/12/8 15:10
     * @param: []
     * @return: void
     **/
    @Test
    public void addGoods() {
        //获取键盘输入
        Scanner sc = new Scanner(System.in);
        System.out.println("商品类型id");
        int gtypeId = sc.nextInt();
        System.out.println("商品名称");
        String goodsName = sc.next();
        System.out.println("商品价格");
        double goodsPrice = sc.nextDouble();
        System.out.println("商品图片");
        String goodsImage = sc.next();
        System.out.println("商品详情");
        String goodsDetail = sc.next();
        System.out.println("商品库存");
        double goodsInventory = sc.nextDouble();

        Tblgoods tblgoods = new Tblgoods();
        tblgoods.setGtypeId(gtypeId);
        tblgoods.setGoodsName(goodsName);
        tblgoods.setGoodsPrice(goodsPrice);
        tblgoods.setGoodsImage(goodsImage);
        tblgoods.setGoodsDetail(goodsDetail);
        tblgoods.setGoodsInventory(goodsInventory);

        int i = mapper.addGoods(tblgoods);
        //提交事务
        session.commit();
        System.out.println(tblgoods.getGoodsId());
        System.out.println(i);
    }

    /**
     * @description:修改
     * @author: chenhao
     * @date: 2022/12/8 15:10
     * @param: []
     * @return: void
     **/
    @Test
    public void updateGoods() {
        //获取键盘输入
        Scanner sc = new Scanner(System.in);
        System.out.println("需要修改的商品id");
        int goodsId = sc.nextInt();
        System.out.println("修改后的商品类型id");
        int gtypeId = sc.nextInt();
        System.out.println("修改后的商品名称");
        String goodsName = sc.next();
        System.out.println("修改后的商品价格");
        double goodsPrice = sc.nextDouble();
        System.out.println("修改后的商品图片");
        String goodsImage = sc.next();
        System.out.println("修改后的商品详情");
        String goodsDetail = sc.next();
        System.out.println("修改后的商品库存");
        double goodsInventory = sc.nextDouble();

        Tblgoods tblgoods = new Tblgoods();
        tblgoods.setGoodsId(goodsId);
        tblgoods.setGtypeId(gtypeId);
        tblgoods.setGoodsName(goodsName);
        tblgoods.setGoodsPrice(goodsPrice);
        tblgoods.setGoodsImage(goodsImage);
        tblgoods.setGoodsDetail(goodsDetail);
        tblgoods.setGoodsInventory(goodsInventory);

        int i = mapper.updateGoods(tblgoods);
        //提交事务
        session.commit();
        System.out.println(i);

    }

    /**
     * @description:删除
     * @author: chenhao
     * @date: 2022/12/8 15:11
     * @param: []
     * @return: void
     **/
    @Test
    public void delGoods() {
        //获取键盘输入
        Scanner sc = new Scanner(System.in);
        System.out.println("需要删除的商品id");
        int goodsId = sc.nextInt();

        int i = mapper.delGoods(goodsId);
        //提交事务
        session.commit();
        System.out.println(i);

    }

    /**
     * @description:一对一映射：嵌套
     * @author: chenhao
     * @date: 2022/12/11 18:30
     **/

    @Test
    public void findGoods() {
        List<Tblgoods> tblgoods = mapper.findGoods(1, "苹");
        for (Tblgoods tblgood : tblgoods) {
            System.out.println(tblgood);
        }
    }

    @Test
    public void findGoods2() {
        List<Tblgoods> tblgoods = mapper.findGoods2();
        for (Tblgoods tblgood : tblgoods) {
            System.out.println(tblgood);
        }
    }

    @Test
    public void findGoods3() {
        List<Tblgoods> tblgoods = mapper.findGoods3();
        for (Tblgoods tblgood : tblgoods) {
            System.out.println(tblgood);
        }
    }

    /**
     * @description:动态sql
     * @author: chenhao
     * @date: 2022/12/11 19:38
     **/
    @Test
    public void findGoods4(){
        List<Tblgoods> tblgoods = mapper.findGoods4(1,"苹",12);
    }

    /**
     * @description:批量添加
     * @author: chenhao
     * @date: 2022/12/11 19:52
     **/
    @Test
    public void addGoodsList(){
        List<Tblgoods> goodsList = new ArrayList<>();
        goodsList.add(new Tblgoods("梨",13));
        goodsList.add(new Tblgoods("香蕉",18));
        goodsList.add(new Tblgoods("桃子",20));
        goodsList.add(new Tblgoods("西瓜",25));

        int i = mapper.addGoodsList(goodsList);
        session.commit();
        System.out.println(i);
    }
}