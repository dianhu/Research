package dh01.research.design.chain;

/**
 * Time : 18-7-29 下午9:27
 * Author : hcy
 * Description : 广告处理器
 */
public class AdHandler extends PostHandler {
    @Override
    public void handle(Post post) {
        //屏蔽广告内容
        String content = post.getContent();
        //.....
        content = content.replace("广告","**");
        post.setContent(content);

        System.out.println("过滤广告...");
        //传递给下一个处理器
        next(post);
    }
}
