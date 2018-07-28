package dh01.research.design.adapter;

/**
 * Time : 18-7-28 下午9:27
 * Author : hcy
 * Description : 适配器模式
 * 适配器模式将一个类的接口，转换成客户期望的另一个接口。适配器让原本接口不兼容的类可以合作无间
 * 适配器适合用于解决新旧系统（或新旧接口）之间的兼容问题，而不建议在一开始就直接使用
 */
public class App {
    public static void main(String[] args) {
        MusicPlayer musicPlayer = new PlayerAdapter();
        musicPlayer.play("mp3","xxx.mp3");
        musicPlayer.play("wma","xxx.wma");
    }
}
