package hcy.datastructure.queue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueTest {
	public static void main(String[] args) {
		Queue<Integer> pq = new PriorityQueue<Integer>(10,new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);//大元素优先返回
				//return o1.compareTo(o2);//小元素优先返回
			}
		});
		pq.add(5);
		pq.add(8);
		pq.add(1);
		pq.add(11);
		pq.add(23);
		pq.add(9);
		pq.add(6);
		while (!pq.isEmpty()) { 
			System.out.print(pq.poll() + ","); 
			}
	}

}
