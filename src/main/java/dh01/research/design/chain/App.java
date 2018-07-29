package dh01.research.design.chain;

/**
 * Time : 18-7-29 下午9:29
 * Author : hcy
 * Description : 责任链模式为某个请求创建一个对象链，每个对象依次检查此请求，并对其进行处理，或者将它传给链中的下一个对象
 * 责任链模式将常用于过滤器，拦截器，事件（鼠标键盘事件，冒泡事件等）等场景
 */
public class App {
    public static void main(String[] args) {
        //创建责任对象
        PostHandler adHandler = new AdHandler();
        PostHandler yellowHandler = new YellowHandler();
        PostHandler swHandler = new SensitiveWordsHandler();

        //形成责任链
        yellowHandler.setSuccessor(swHandler);
        adHandler.setSuccessor(yellowHandler);

        Post post = new Post();
        post.setContent("我是正常内容，我是广告，我是涉黄，我是敏感词，我是正常内容");
        System.out.println("过滤前的内容为："+post.getContent());

        adHandler.handle(post);

        System.out.println("过滤后的内容为："+post.getContent());
    }
}
