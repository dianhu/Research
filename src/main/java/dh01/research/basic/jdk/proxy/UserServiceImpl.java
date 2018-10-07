package dh01.research.basic.jdk.proxy;

/**
 * Time : 18-10-7 下午7:34
 * Author : hcy
 * Description :
 */
public class UserServiceImpl implements UserService {

    @Override
    public void save(String user) {
        System.out.println("save user info");
    }

    @Override
    public void update(String user) {
        System.out.println("update user info");
    }
}
