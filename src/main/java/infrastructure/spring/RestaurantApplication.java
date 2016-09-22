package infrastructure.spring;

import bar.kitchen.common.domain.entity.tab.command.OpenTab;
import bar.kitchen.common.domain.entity.waiter.Waiter;
import bar.kitchen.common.domain.entity.waiter.WaiterAspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by IONER on 02/07/2016.
 */
@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class RestaurantApplication {
    private static ApplicationContext ctx;

    public static void main(String[] args) {
        ctx = SpringApplication.run(RestaurantApplication.class, args);

        /*System.out.println("Let's inspect the beans provided by Spring Boot:");

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }*/

        //ctx.getBean(Waiter.class).handle(new OpenTab(42,"John")).stream().forEach(System.out::println);
    }

    public static int exit(){
        return SpringApplication.exit(ctx);
    }

    @Bean
    public Waiter waiter(){
        return new Waiter();
    }

    @Bean
    public WaiterAspect waiterHelper() {
        return new WaiterAspect();
    }
}
