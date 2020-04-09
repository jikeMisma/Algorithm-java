## 二分查找算法(非递归)介绍

1. 前面我们讲过了二分查找算法，是使用递归的方式，下面我们讲解二分查找算法的非递归方式
2. 二分查找法只适用于从有序的数列中进行查找(比如数字和字母等)，将数列排序后再进行查找
3. 二分查找法的运行时间为对数时间O(㏒₂n) ，即查找到需要的目标位置最多只需要㏒₂n步，假设从[0,99]的队列(100个数，即n=100)中寻到目标数30，则需要查找步数为㏒₂100 , 即最多需要查找7次( 2^6 < 100 < 2^7)

## 二分查找算法(非递归)代码实现
数组 {1,3, 8, 10, 11, 67, 100}, 编程实现二分查找， 要求使用非递归的方式完成

**实现代码**

```java
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

```

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200408143731947.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L216Y19sb3Zl,size_16,color_FFFFFF,t_70#pic_center)
