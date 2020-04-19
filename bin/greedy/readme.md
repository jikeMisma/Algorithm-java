## 贪心算法介绍
1. 贪婪算法(贪心算法)是指在对问题进行求解时，在每一步选择中都采取最好或者最优(即最有利)的选择，从而希望能够导致结果是最好或者最优的算法

2. 贪婪算法所得到的结果**不一定是最优的结果(有时候会是最优解)** 但是都是相对近似(接近)最优解的结果

## 贪心算法最佳应用-集合覆盖
假设存在如下表的需要付费的广播台，以及广播台信号可以覆盖的地区。 如何选择最少的广播台，让所有的地区都可以接收到信号
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200413104513932.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L216Y19sb3Zl,size_16,color_FFFFFF,t_70#pic_center)

**思路分析:** 
使用贪婪算法，效率高:
目前并没有算法可以快速计算得到准备的值， 使用贪婪算法，则可以得到非常接近的解，并且效率高。选择策略上，因为需要覆盖全部地区的最小集合:
1. 遍历所有的广播电台, 找到一个覆盖了最多未覆盖的地区的电台(此电台可能包含一些已覆盖的地区，但没有关系） 
2. 将这个电台加入到一个集合中(比如ArrayList), 想办法把该电台覆盖的地区在下次比较时去掉。
3. 重复第1步直到覆盖了全部的地区


**代码实现**

```java
/**
 * title：贪心算法
 * date:2020.4.13
 */
package greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class GreedyAlgorithm {

	public static void main(String args[]) {
		
		//创建广播电台，放入到map中
		HashMap<String,HashSet<String>> broadcasts = new  HashMap<String,HashSet<String>>();
		//将各个电台放入到broadcasts中
		HashSet<String> hashSet1 = new HashSet<String>();
		hashSet1.add("北京");
		hashSet1.add("上海");
		hashSet1.add("天津");
		
		HashSet<String> hashSet2 = new HashSet<String>();
		hashSet2.add("广州");
		hashSet2.add("北京");
		hashSet2.add("深圳");
		
		HashSet<String> hashSet3 = new HashSet<String>();
		hashSet3.add("成都");
		hashSet3.add("上海");
		hashSet3.add("杭州");
		
		
		HashSet<String> hashSet4 = new HashSet<String>();
		hashSet4.add("上海");
		hashSet4.add("天津");
		
		HashSet<String> hashSet5 = new HashSet<String>();
		hashSet5.add("杭州");
		hashSet5.add("大连");
	
		//加入到map
		broadcasts.put("K1", hashSet1);
		broadcasts.put("K2", hashSet2);
		broadcasts.put("K3", hashSet3);
		broadcasts.put("K4", hashSet4);
		broadcasts.put("K5", hashSet5);
		
		//allAreas 存放所有的地区
		HashSet<String> allAreas = new HashSet<String>();
		allAreas.add("北京");
		allAreas.add("上海");
		allAreas.add("天津");
		allAreas.add("广州");
		allAreas.add("深圳");
		allAreas.add("成都");
		allAreas.add("杭州");
		allAreas.add("大连");
		 
		 //创建爱你一个selects存放选择的电台
		 ArrayList<String> selects = new  ArrayList<String>();
		 
		 //定义一个临时的集合，保存在遍历过程中，存放遍历过程中电台覆盖地区和还没有覆盖地区的交集
		 HashSet<String> tempSet = new HashSet<String>();
		 
		 //定义msxkey，保存在一次遍历过程中，能够覆盖地区最大未覆盖地区对应的电台key
		 //如果maxkey不为NUll，则加到selects
		 String maxKey = null;
		 while(allAreas.size() != 0) {//如果allAreas不为0，表示还没有覆盖到所有地区
			 //每进行一次while，需要maxkey置空
			 maxKey = null;
			 
			 //遍历broadcasts
			 for(String key:broadcasts.keySet()) {
				//没进行一次for，需要将tempset清空
				 tempSet.clear();
				 //当前这个key能够覆盖的地区
				 HashSet<String> arreas = broadcasts.get(key);
				 tempSet.addAll(arreas);
				 //求出tempSet 和 allAreas的交集，交集会覆给tempset
				 tempSet.retainAll(allAreas);
				 //如果当前这个集合包含的未覆盖地区的数量比maxKey指向的集合的地区还多
				 //就需要重置maxKey
				 //tempSet.size() > broadcasts.get(maxKey).size()这句haul体现出贪婪算法每次选择最优的
				 if(tempSet.size() > 0 && (maxKey == null || tempSet.size() > broadcasts.get(maxKey).size())) {
					 maxKey = key ;
				 }
			 }
			 
			 //maxKey != null,就将maxKey加入到selects
			 if(maxKey != null) {
				 selects.add(maxKey);
				 //将maxKey指向的广播电台覆盖的地区从allAreas中去除
				 allAreas.removeAll(broadcasts.get(maxKey));
			 }
			 
		 }
		 
		System.out.println("得到的选择结果为："+selects); 

	}

}

```
**贪心算法核心**
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200413114412400.png#pic_center)
**运行结果**
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200413114435975.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L216Y19sb3Zl,size_16,color_FFFFFF,t_70#pic_center)

