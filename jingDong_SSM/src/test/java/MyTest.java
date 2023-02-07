import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void t1(){
        ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"springmvc-servlet.xml","applicationContext.xml"});
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
    }
}
