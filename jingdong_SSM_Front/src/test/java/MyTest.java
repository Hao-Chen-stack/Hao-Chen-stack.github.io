import com.cykj.bean.Tblgoods;
import com.cykj.mapper.TblgoodsMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {
    @Test
    public void t1(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//        String[] names = ac.getBeanDefinitionNames();
//        for (String name : names) {
//            System.out.println(name);
//        }
        TblgoodsMapper mapper = ac.getBean(TblgoodsMapper.class);
        List<Tblgoods> goodsList = mapper.findGoodsList();
        for (Tblgoods tblgoods : goodsList) {
            System.out.println(tblgoods);
        }
    }
}
