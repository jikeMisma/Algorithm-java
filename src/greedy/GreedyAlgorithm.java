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
