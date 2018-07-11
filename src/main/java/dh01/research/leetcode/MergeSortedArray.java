package dh01.research.leetcode;// Source : https://oj.leetcode.com/problems/merge-sorted-array/
// Author : H.C.Y
// Date   : 2015-02-09

/********************************************************************************** 
* 
*Given two sorted integer arrays A and B, merge B into A as one sorted array.
*
*Note:
*You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B. 
*The number of elements initialized in A and B are m and n respectively.
*
* 
*               
**********************************************************************************/
public class MergeSortedArray {
	public void merge(int A[], int m, int B[], int n) {
        int resultIndex=0;
        int aIndex=m-1;
        int bIndex=n-1;
        for(resultIndex=m+n-1;resultIndex>=0;resultIndex--){
            if(bIndex<0){
                break;
            }
            if(aIndex>=0&&A[aIndex]>=B[bIndex]){
                A[resultIndex]=A[aIndex];
                aIndex--;
            }else{
                A[resultIndex]=B[bIndex];
                bIndex--;
            }
        }
    }
	public static void main(String[] args) {
		int arrayA [] = {1,5,7,9,10,0,0,0};
		int arrayB [] = {2,4,6};
		new MergeSortedArray().merge(arrayA, 5,arrayB, 3);
		for(int i=0;i<arrayA.length;i++){
			System.out.println(arrayA[i]);
		}
		
	}

}
