package dh01.research.design.adapter;

/**
 * Time : 18-7-28 下午9:21
 * Author : hcy
 * Description : 旧接口，被适配者
 */
public class ExistPlayer {
    public void playMp3(String filename) {
        System.out.println("play mp3 : " + filename);
    }

    public void playWma(String filename) {
        System.out.println("play wam : " + filename);
    }
}
