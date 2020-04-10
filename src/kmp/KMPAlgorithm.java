package kmp;

import java.util.Arrays;

public class KMPAlgorithm {

	public static void main(String[] args) {
		
		String str1 = "BBC ABCDAB ABCDABCDABDE";
		String str2 = "ABCDABD";
		//String str2 = "BBC";
		
		int[] next=kmpNext("ABCDABD");
		System.out.println("next = "+Arrays.toString(next));
		
		int index = kmpSearch(str1,str2,next);
		System.out.println("index = "+index);
	}
	
	//д��kmp�����㷨
	/**
	 * 
	 * @param str1	��Ѱ��ԭ�ַ���
	 * @param str2	��Ҫ�ҵ����Ӵ�
	 * @param next	�Ӵ���Ӧ�Ĳ���ƥ���
	 * @return	���ص�һ��ƥ��λ�ã�û��ƥ�䵽����-1
	 */
	public static int kmpSearch(String str1,String str2,int[] next) {
		
		//����
		for(int i = 0,j =0;i<str1.length();i++) {
			
			//��Ҫ����str1.charAt(i) == str2.charAt(j),ȥ����j�Ĵ�С
			//KMP�ĺ���
			while(j >0 && str1.charAt(i) != str2.charAt(j)) {
				j = next[j-1];
			}
			
			if(str1.charAt(i) == str2.charAt(j)) {
				j++;
			}
			if(j == str2.length()) {//�ҵ���
				return i - j+1;
			}
		}
		return -1;
	}
	
	//��ȡ�Ӵ��Ĳ���ƥ��ֵ
	public static int[] kmpNext(String dest) {
		//����һ��next���鱣�沿��ƥ��ֵ
		int[] next = new int[dest.length()];
		next[0] = 0;//����ַ�������Ϊ1��ƥ��ֵ��λ1
		for(int i =1,j =0;i<dest.length();i++) {
			//����dest.cahrAt(i) ��== dest.charAt(j)����������Ҫ��next[j-1]��ȡ�µ�j
			//ֱ��dest.cahrAt(i) == dest.charAt(j)������ʱ���˳�
			//����kmp�㷨�ĺ���
			while(j>0 && dest.charAt(i)  != dest.charAt(j)) {
				j = next[j -1];
			}
			
			//��dest.cahrAt(i) == dest.charAt(j)�������ǣ�����ƥ��ֵ��һ
			if(dest.charAt(i)  == dest.charAt(j)) {
				j++;
			}
			next[i] =j;
		}
		return next;
	}
	
	

}
