import com.cykj.bean.Tblbill;
import com.cykj.bean.Tblpower;
import com.cykj.bean.Tbluser;
import com.cykj.mapper.TblbillMapper;
import com.cykj.mapper.TblpowerMapper;
import com.cykj.utils.BuildTree;
import com.cykj.utils.TreeVo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Demo {
//    @Test
//    public void t1(){
//        ApplicationContext ac  = new ClassPathXmlApplicationContext("applicationContext.xml");
////        for (String name : ac.getBeanDefinitionNames()) {
////            System.out.println(name);
////        }
//        TblpowerMapper tblpowerMapper = ac.getBean(TblpowerMapper.class);
//        List<Tblpower> list = tblpowerMapper.findDistributedPower("1001");
//
//        List<TreeVo<Tblpower>> trees = new ArrayList<TreeVo<Tblpower>>();
//        for (Tblpower power : list) {
//            //循环遍历
//            //定义一个数据节点类
//            TreeVo<Tblpower> vo = new TreeVo<>();
//            //赋值
//            vo.setId(power.getpowerid()+ "");
//            vo.setText(power.getPowerName());//节点名称
//            vo.setParentId(power.getParentId() + "");
//            trees.add(vo);
//        }
//        List<TreeVo<Tblpower>> treeVos = BuildTree.buildList(trees, "0");
//
//        System.out.println(treeVos);
//    }

//    @Test
//    public void t2(){
//        ApplicationContext ac  = new ClassPathXmlApplicationContext("applicationContext.xml");
//        TblbillMapper tblbillMapper = ac.getBean(TblbillMapper.class);
//        List<Tblbill> billListByManagerAcc = tblbillMapper.findBillListByManagerAcc("1002");
//
//        for (Tblbill tblbill : billListByManagerAcc) {
//            System.out.println(tblbill.getManagerBalance());
//        }
//
//        System.out.println(billListByManagerAcc);
//    }
}
