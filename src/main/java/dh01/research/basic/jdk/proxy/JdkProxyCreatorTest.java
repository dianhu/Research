package dh01.research.basic.jdk.proxy;

import org.junit.Test;

/**
 * Time : 18-10-7 下午7:38
 * Author : hcy
 * Description :
 */
public class JdkProxyCreatorTest {
    @Test
    public void getProxy() throws Exception {
        ProxyCreator proxyCreator = new JdkProxyCreator(new UserServiceImpl());
        UserService userService = (UserService) proxyCreator.getProxy();

        System.out.println("proxy type = " + userService.getClass());
        System.out.println();
        userService.save(null);
        System.out.println();
        userService.update(null);
    }
}
