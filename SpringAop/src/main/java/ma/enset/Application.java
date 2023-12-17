package ma.enset;

import ma.enset.service.IMetier;
import ma.enset.service.SecurityContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


//@ComponentScan(value = {"ma.enset"})
public class Application {
    public static void main(String[] args) {

        try {
            SecurityContext.authenticate("root", "1234", new String[]{"USER"});
            //ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
            ApplicationContext context = new AnnotationConfigApplicationContext(Myconfig.class);
            IMetier metier = context.getBean(IMetier.class);
            System.out.println("******************************");
            System.out.println(metier.getClass().getName());
            System.out.println("******************************");
            metier.process();
            System.out.println(metier.compute());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
@ComponentScan(value = { "ma.enset"})
@Configuration
class Myconfig {

}