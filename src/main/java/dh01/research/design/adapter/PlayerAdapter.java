package dh01.research.design.adapter;

/**
 * Time : 18-7-28 下午9:24
 * Author : hcy
 * Description : 适配器
 */
public class PlayerAdapter implements MusicPlayer {
    //引用被适配的对象
    ExistPlayer existPlayer;

    public PlayerAdapter() {
        this.existPlayer = new ExistPlayer();
    }

    @Override
    public void play(String type, String filename) {
        if ("mp3".equals(type)) {
            existPlayer.playMp3(filename);
        } else if ("wma".equals(type)) {
            existPlayer.playWma(filename);
        }

    }
}
