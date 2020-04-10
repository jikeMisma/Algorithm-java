/**
 * title:暴力匹配算法实现
 * date：2020.4010
 */
package kmp;

public class VolenceMetch {

	public static void main(String[] args) {

		//测试暴力匹配
		String str1 = "你你好 你好吗吗马志成 你好马志成 哈哈哈";
		String str2 =" 你好马志成";
		int index = vilenceMatch(str1,str2);
		System.out.println(index);
		

	}
	
	//暴力匹配算法实现
	public static int vilenceMatch(String str1,String str2){
		char[] s1=str1.toCharArray();
		char[] s2=str2.toCharArray();
		int  s1Len = s1.length;
		int  s2Len = s2.length;
		
		int i = 0;//索引指s1
		int j = 0;//索引指向s2
		while(i<s1Len && j<s2Len) {//保证匹配时不会越界
			if(s1[i] ==s2[j]) {//匹配成功
				i++;
				j++;
			}else {//没有匹配成功
				//如果失配（即str1[i]! = str2[j]），令i = i - (j - 1)，j = 0
				i = i-(j-1);
				j = 0;
				
			}
		}
		
		//判断是否匹配成功
		if(j == s2Len) {
			return i -j;
		}else {
			return -1;
		}
		
	}

}
