package bar.kitchen.common.domain.entity.waiter;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by rafvimar on 02/08/16.
 */

@Aspect
public class WaiterAspect {

  @Before("execution(* bar.kitchen.common.domain.entity.waiter.Waiter.handle(..))")
  public void handle(JoinPoint joinPoint) {
    /*System.out.println(joinPoint.getClass().getCanonicalName());
    System.exit(20);*/
  }

}
