package dh01.research.basic.jdk.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Time : 18-10-7 下午7:38
 * Author : hcy
 * Description :
 */
public class ProxyCreatorTest {
    @Test
    public void getJdkProxy() throws Exception {
        Object target = new UserServiceImpl();
        InvocationHandler handler = (Object proxy, Method method, Object[] args)->{
            System.out.println(System.currentTimeMillis() + " - " + method.getName() + " method start");
            // 调用目标方法
            Object retVal = method.invoke(target, args);
            System.out.println(System.currentTimeMillis() + " - " + method.getName() + " method over");

            return retVal;
        };
        ProxyCreator proxyCreator = new JdkProxyCreator(target,handler);
        UserService userService = (UserService) proxyCreator.getProxy();

        System.out.println("proxy type = " + userService.getClass());
        System.out.println();
        userService.save(null);
        System.out.println();
        userService.update(null);
    }

    @Test
    public void getCglibProxy() throws Exception {
        Object target = new UserServiceImpl();
        MethodInterceptor interceptor = (Object o, Method method, Object[] objects, MethodProxy methodProxy)->{
            System.out.println(System.currentTimeMillis() + " - " + method.getName() + " method start");
            // 调用目标方法
            Object retVal = methodProxy.invokeSuper(o, objects);
            System.out.println(System.currentTimeMillis() + " - " + method.getName() + " method over");

            return retVal;
        };
        ProxyCreator proxyCreator = new CglibProxyCreator(target,interceptor);
        UserService userService = (UserService) proxyCreator.getProxy();

        System.out.println("proxy type = " + userService.getClass());
        System.out.println();
        userService.save(null);
        System.out.println();
        userService.update(null);
    }

}
