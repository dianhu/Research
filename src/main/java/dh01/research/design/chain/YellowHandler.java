package dh01.research.design.chain;

/**
 * Time : 18-7-29 下午9:28
 * Author : hcy
 * Description : 涉黄处理器
 */
public class YellowHandler extends PostHandler {
    @Override
    public void handle(Post post) {
        //屏蔽涉黄内容
        String content = post.getContent();
        //.....
        content = content.replace("涉黄","**");
        post.setContent(content);

        System.out.println("过滤涉黄内容...");
        //传递给下一个处理器
        next(post);
    }
}
