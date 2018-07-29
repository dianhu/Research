package dh01.research.design.chain;

/**
 * Time : 18-7-29 下午9:29
 * Author : hcy
 * Description : 敏感词处理器
 */
public class SensitiveWordsHandler extends PostHandler {
    public void handle(Post post) {
        //屏蔽敏感词
        String content = post.getContent();
        //.....
        content = content.replace("敏感词","**");
        post.setContent(content);

        System.out.println("过滤敏感词...");
        //传递给下一个处理器
        next(post);
    }
}
