/**
 * title��̰���㷨
 * date:2020.4.13
 */
package greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class GreedyAlgorithm {

	public static void main(String args[]) {
		
		//�����㲥��̨�����뵽map��
		HashMap<String,HashSet<String>> broadcasts = new  HashMap<String,HashSet<String>>();
		//��������̨���뵽broadcasts��
		HashSet<String> hashSet1 = new HashSet<String>();
		hashSet1.add("����");
		hashSet1.add("�Ϻ�");
		hashSet1.add("���");
		
		HashSet<String> hashSet2 = new HashSet<String>();
		hashSet2.add("����");
		hashSet2.add("����");
		hashSet2.add("����");
		
		HashSet<String> hashSet3 = new HashSet<String>();
		hashSet3.add("�ɶ�");
		hashSet3.add("�Ϻ�");
		hashSet3.add("����");
		
		
		HashSet<String> hashSet4 = new HashSet<String>();
		hashSet4.add("�Ϻ�");
		hashSet4.add("���");
		
		HashSet<String> hashSet5 = new HashSet<String>();
		hashSet5.add("����");
		hashSet5.add("����");
	
		//���뵽map
		broadcasts.put("K1", hashSet1);
		broadcasts.put("K2", hashSet2);
		broadcasts.put("K3", hashSet3);
		broadcasts.put("K4", hashSet4);
		broadcasts.put("K5", hashSet5);
		
		//allAreas ������еĵ���
		HashSet<String> allAreas = new HashSet<String>();
		allAreas.add("����");
		allAreas.add("�Ϻ�");
		allAreas.add("���");
		allAreas.add("����");
		allAreas.add("����");
		allAreas.add("�ɶ�");
		allAreas.add("����");
		allAreas.add("����");
		 
		 //��������һ��selects���ѡ��ĵ�̨
		 ArrayList<String> selects = new  ArrayList<String>();
		 
		 //����һ����ʱ�ļ��ϣ������ڱ��������У���ű��������е�̨���ǵ����ͻ�û�и��ǵ����Ľ���
		 HashSet<String> tempSet = new HashSet<String>();
		 
		 //����msxkey��������һ�α��������У��ܹ����ǵ������δ���ǵ�����Ӧ�ĵ�̨key
		 //���maxkey��ΪNUll����ӵ�selects
		 String maxKey = null;
		 while(allAreas.size() != 0) {//���allAreas��Ϊ0����ʾ��û�и��ǵ����е���
			 //ÿ����һ��while����Ҫmaxkey�ÿ�
			 maxKey = null;
			 
			 //����broadcasts
			 for(String key:broadcasts.keySet()) {
				//û����һ��for����Ҫ��tempset���
				 tempSet.clear();
				 //��ǰ���key�ܹ����ǵĵ���
				 HashSet<String> arreas = broadcasts.get(key);
				 tempSet.addAll(arreas);
				 //���tempSet �� allAreas�Ľ����������Ḳ��tempset
				 tempSet.retainAll(allAreas);
				 //�����ǰ������ϰ�����δ���ǵ�����������maxKeyָ��ļ��ϵĵ�������
				 //����Ҫ����maxKey
				 //tempSet.size() > broadcasts.get(maxKey).size()���haul���ֳ�̰���㷨ÿ��ѡ�����ŵ�
				 if(tempSet.size() > 0 && (maxKey == null || tempSet.size() > broadcasts.get(maxKey).size())) {
					 maxKey = key ;
				 }
			 }
			 
			 //maxKey != null,�ͽ�maxKey���뵽selects
			 if(maxKey != null) {
				 selects.add(maxKey);
				 //��maxKeyָ��Ĺ㲥��̨���ǵĵ�����allAreas��ȥ��
				 allAreas.removeAll(broadcasts.get(maxKey));
			 }
			 
		 }
		 
		System.out.println("�õ���ѡ����Ϊ��"+selects); 

	}

}
