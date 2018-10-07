package dh01.research.basic.jdk.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Time : 18-10-7 下午7:35
 * Author : hcy
 * Description :
 */
public class JdkProxyCreator implements ProxyCreator {
    private Object target;
    private InvocationHandler invocationHandler;
    public JdkProxyCreator(Object target,InvocationHandler handler){
        assert target != null;
        Class<?>[] interfaces = target.getClass().getInterfaces();
        if (interfaces.length == 0) {
            throw new IllegalArgumentException("target class don`t implement any interface");
        }
        this.target = target;
        this.invocationHandler = handler;
    }

    @Override
    public Object getProxy() {
        Class<?> clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this.invocationHandler);
    }
}
