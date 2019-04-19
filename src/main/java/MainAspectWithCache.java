import chap07.Calculator;
import config.AppCtxWithCache;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainAspectWithCache {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
            new AnnotationConfigApplicationContext(AppCtxWithCache.class);

        Calculator c = ctx.getBean("calculator", Calculator.class);
        c.factorial(7);
        c.factorial(7);
        c.factorial(5);
        c.factorial(5);

        ctx.close();
    }
}
