package dh01.research.basic.sort;

/**
 * @author chengyuan.hu
 * 
 * Apr 21, 20142:58:19 PM create
 * 
 * 冒泡排序,两两比较，每次都会把当前循环最大的元素排在最后
 *
 */
public class BubbleSort {
	
	static int nrs[] = {5,8,4,3,7,2,6,1};
	
	public static void main(String args[]){
		
		BubbleSort bs = new BubbleSort();
		bs.bubbleSort(nrs);	
		for(int i=0;i<nrs.length;i++){
			
			System.out.println(nrs[i]);
		}
	}
	
	private void bubbleSort(int[] n){
		if(null==n) return;
		int temp=0;
		for (int i=0;i<n.length-1;i++){
			for(int j=0;j<n.length-1-i;j++){
				temp=n[j];
				if(n[j+1]<n[j]){
					n[j]=n[j+1];
					n[j+1]=temp;
				}
			}
		}
	}

}
