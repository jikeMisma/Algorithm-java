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
	
	//写出kmp搜索算法
	/**
	 * 
	 * @param str1	搜寻的原字符串
	 * @param str2	需要找到的子串
	 * @param next	子串对应的部分匹配表
	 * @return	返回第一个匹配位置，没有匹配到返回-1
	 */
	public static int kmpSearch(String str1,String str2,int[] next) {
		
		//遍历
		for(int i = 0,j =0;i<str1.length();i++) {
			
			//需要处理str1.charAt(i) == str2.charAt(j),去调整j的大小
			//KMP的核心
			while(j >0 && str1.charAt(i) != str2.charAt(j)) {
				j = next[j-1];
			}
			
			if(str1.charAt(i) == str2.charAt(j)) {
				j++;
			}
			if(j == str2.length()) {//找到了
				return i - j+1;
			}
		}
		return -1;
	}
	
	//获取子串的部分匹配值
	public static int[] kmpNext(String dest) {
		//创建一个next数组保存部分匹配值
		int[] next = new int[dest.length()];
		next[0] = 0;//如果字符串长度为1，匹配值就位1
		for(int i =1,j =0;i<dest.length();i++) {
			//当当dest.cahrAt(i) ！== dest.charAt(j)），我们需要从next[j-1]获取新的j
			//直到dest.cahrAt(i) == dest.charAt(j)）成立时才退出
			//这是kmp算法的核心
			while(j>0 && dest.charAt(i)  != dest.charAt(j)) {
				j = next[j -1];
			}
			
			//当dest.cahrAt(i) == dest.charAt(j)）满足是，部分匹配值加一
			if(dest.charAt(i)  == dest.charAt(j)) {
				j++;
			}
			next[i] =j;
		}
		return next;
	}
	
	

}
