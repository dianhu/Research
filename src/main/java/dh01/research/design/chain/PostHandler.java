package dh01.research.design.chain;

/**
 * Time : 18-7-29 下午9:23
 * Author : hcy
 * Description : 帖子处理器
 */
public abstract class PostHandler {
    //后继处理者
    protected PostHandler successor;
    public void setSuccessor(PostHandler successor){
        this.successor = successor;
    }
    public abstract void handle(Post post);
    protected final void next(Post post){
        if(this.successor!=null){
            this.successor.handle(post);
        }
    }
}
