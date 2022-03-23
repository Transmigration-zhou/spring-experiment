import org.itee.se.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

public class TestSimpleDial {
    public static void main(String[] args) {
        ApplicationContext cpx = new ClassPathXmlApplicationContext("bean.xml");
        Person p = cpx.getBean("person", Person.class);
        String to = "10086";
        p.dial(to);
        String dialInfo = cpx.getMessage("dialInfo", new String[]{p.getName(), p.getPhone().getType(), to}, Locale.US);
        System.out.println(dialInfo);
    }
}
