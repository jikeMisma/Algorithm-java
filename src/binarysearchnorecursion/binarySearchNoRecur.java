/**
 * 	title:���ֲ��ҵķǵݹ�ʵ��
 * 	date��2020.4.8
 */
package binarysearchnorecursion;

public class binarySearchNoRecur {

	public static void main(String[] args) {
		
		//����
		int[]  arr = {1,3,8,10,11,67,100};
		int index = binarySrarch(arr,1);
		System.out.println(index);
	}
	
	//���ֲ��ҵķǵݹ�ʵ��
	/**
	 * 
	 * @param arr	�����ҵ�����,�����������
	 * @param target	��Ҫ���ҵ�
	 * @return
	 */
	public static int binarySrarch(int[] arr,int target) {
		
		int left = 0;
		int  right = arr.length-1;
		while(left <= right) {//˵����������
			int mid =(left+right) / 2;
			if(arr[mid] == target) {
				return mid;
			}else if(arr[mid] >target) {
				right = mid -1;//��Ҫ�������
			}else {
				left = mid +1;//��Ҫ���Ҳ���
			}
			
		}
		return -1;
	}

}
