package hcy.graphs.common;

/**
 * Time : 17-1-12 上午10:42
 * Author : hcy
 * Description :基础边
 */
public class Edge {
    /**
     * 花费
     */
    public double weight;

    /**
     * 节点名字，调试用
     */
    String name;

    public Edge(double weight,String name){
        this.weight=weight;
        this.name=name;
    }

}
