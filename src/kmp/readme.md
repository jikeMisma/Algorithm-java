## 应用场景-字符串匹配问题
字符串匹配问题：：
1. 有一个字符串 str1= ""硅硅谷 尚硅谷你尚硅 尚硅谷你尚硅谷你尚硅你好""，和一个子串 str2="尚硅谷你尚硅你"
2. 现在要判断 str1 是否含有 str2, 如果存在，就返回第一次出现的位置, 如果没有，则返回-1

## 暴力匹配算法
如果用暴力匹配的思路，并假设现在str1匹配到 i 位置，子串str2匹配到 j 位置，则有:

1. 如果当前字符匹配成功（即str1[i] == str2[j]），则i++，j++，继续匹配下一个字符
2. 如果失配（即str1[i]! = str2[j]），令i = i - (j - 1)，j = 0。相当于每次匹配失败时，i 回溯，j 被置为0。
3. 用暴力方法解决的话就会有大量的回溯，每次只移动一位，若是不匹配，移动到下一位接着判断，浪费了大量的时间。(不可行!)
4. 暴力匹配算法实现.

**代码实现**

```java
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

```
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200410114931873.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L216Y19sb3Zl,size_16,color_FFFFFF,t_70)
## KMP算法
**KMP算法介绍**

1. KMP是一个解决模式串在文本串是否出现过，如果出现过，最早出现的位置的经典算法
2. Knuth-Morris-Pratt 字符串查找算法，简称为 “KMP算法”，常用于在一个文本串S内查找一个模式串P 的出现位置，这个算法由Donald Knuth、Vaughan Pratt、James H. Morris三人于1977年联合发表，故取这3人的姓氏命名此算法.
3. KMP方法算法就利用之前判断过信息，通过一个next数组，保存模式串中前后最长公共子序列的长度，每次回溯时，通过next数组找到，前面匹配过的位置，省去了大量的计算时间
4. [参考资料](https://www.cnblogs.com/ZuoAndFutureGirl/p/9028287.html)

**KMP算法最佳应用-字符串匹配问题**

字符串匹配问题：
有一个字符串 str1= "BBC ABCDAB ABCDABCDABDE"，和一个子串 str2="ABCDABD"
现在要判断 str1 是否含有 str2, 如果存在，就返回第一次出现的位置, 如果没有，则返回-1
要求：使用KMP算法完成判断，不能使用简单的暴力匹配算法.

**KMP算法中很重要的一步是计算《部分匹配表》**
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200410160002939.png#pic_center)
**部分分配表的计算最重要的是找字符串的前后缀**
![在这里插入图片描述](https://img-blog.csdnimg.cn/202004101600129.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L216Y19sb3Zl,size_16,color_FFFFFF,t_70#pic_center)

**代码实现**

```java
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

```
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200410160056521.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L216Y19sb3Zl,size_16,color_FFFFFF,t_70#pic_center)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200410160111262.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L216Y19sb3Zl,size_16,color_FFFFFF,t_70#pic_center)


