package infrastructure.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

/**
 * Created by IONER on 02/07/2016.
 */
@SpringBootApplication
public class GeoApplication {
    private static ApplicationContext ctx;

    public static void main(String[] args) {
        ctx = SpringApplication.run(GeoApplication.class, args);

        System.out.println("Let's inspect the beans provided by Spring Boot:");

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
    }

    public static int exit(){
        return SpringApplication.exit(ctx);
    }
}
