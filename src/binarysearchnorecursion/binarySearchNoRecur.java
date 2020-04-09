/**
 * 	title:二分查找的非递归实现
 * 	date：2020.4.8
 */
package binarysearchnorecursion;

public class binarySearchNoRecur {

	public static void main(String[] args) {
		
		//测试
		int[]  arr = {1,3,8,10,11,67,100};
		int index = binarySrarch(arr,1);
		System.out.println(index);
	}
	
	//二分查找的非递归实现
	/**
	 * 
	 * @param arr	待查找的数组,数组是升序的
	 * @param target	需要查找的
	 * @return
	 */
	public static int binarySrarch(int[] arr,int target) {
		
		int left = 0;
		int  right = arr.length-1;
		while(left <= right) {//说明继续查找
			int mid =(left+right) / 2;
			if(arr[mid] == target) {
				return mid;
			}else if(arr[mid] >target) {
				right = mid -1;//需要向左查找
			}else {
				left = mid +1;//需要向右查找
			}
			
		}
		return -1;
	}

}
