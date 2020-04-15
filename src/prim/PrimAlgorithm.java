/**
 * title������ķ�㷨
 * date��2020.4.14
 */

package prim;

import java.util.Arrays;

public class PrimAlgorithm {

	public static void main(String[] args) {
		
		//���Կ���ͼ�Ƿ񴴽��ɹ�
		char[] data = new char[] {'A','B','C','D','E','F','G',};
		int verxs = data.length;
		//�ڽӾ���Ĺ�ϵʹ�ö�ά��������,10000���������ʾ���㲻��ͨ
		int[][] weight = new int[][] {
			{10000,5,7,10000,10000,10000,2},
			{5,10000,10000,9,10000,10000,3},
			{7,10000,10000,10000,8,10000,10000},
			{10000,9,10000,10000,10000,4,10000},
			{10000,10000,8,10000,10000,5,4},
			{10000,10000,10000,4,5,10000,6},
			{2,3,10000,10000,4,6,10000},
		};
		
		//����MGraph�Ķ���
		MGraph mGraph = new MGraph(verxs);
		//����һ��minterr����
		MinTree minTree = new MinTree();
		minTree.createGraph(mGraph,verxs,data,weight);
		//���
		minTree.showGraph(mGraph);
		
		
		//����prim�㷨
		minTree.prim(mGraph,0);
		
	}

}

//������С������-����ׯ����
class MinTree{
	//����ͼ���ڽӾ���
	/**
	 * 
	 * @param graph	ͼ����
	 * @param verxs	ͼ��Ӧ�Ķ������
	 * @param data	ͼ�ĸ��������ֵ
	 * @param weight	ͼ���ڽӾ���
	 */
	public void createGraph(MGraph graph,int verxs,char[] data,int[][] weight) {
		
		int i,j;
		for( i = 0;i<verxs;i++) {//����
			graph.data[i] = data[i];
			for(j = 0;j<verxs;j++) {
				graph.weight[i][j] = weight[i][j] ;
			}
		}
	}
	//��ʾͼ�ķ���:��ʾͼ���ڽӾ���
	public void showGraph(MGraph graph) {
		for(int[] link:graph.weight) {
			System.out.println(Arrays.toString(link));
		}
	}
	
	//��дһ��prim�㷨���õ���С������
	/**
	 * 
	 * @param graph	ͼ
	 * @param v	��ʾ��ͼ�ĵڼ������㿪ʼ����
	 */
	public  void prim(MGraph graph,int v) {
		// visit[] ��ǽ���Ƿ񱻷��ʹ�
		int visit[] = new int[graph.verxs];
		// visit[] Ĭ��Ԫ�ض���0����ʾû�б����ʷ�
		//�ѵ�ǰ�����Ϊ�ѷ���
		 visit[v] = 1;
		 //��h1 h2��¼�������������
		 int h1 = -1;
		 int h2 = -1;
		 int minWeight = 10000;//minWeight ��ʼΪһ�����������������ʱ��ᱻ�滻
		 for(int k= 1;k<graph.verxs;k++) {//��Ϊ��graph.verxs���㣬prim�㷨�����󣬻���graph.verxs-1����
			 
			 //�����ȷ��ÿһ�����ɵ���ͼ���ĸ����ľ������
			 for(int i = 0;i<graph.verxs;i++) {//i����ʾ�����ʹ��Ľ��
				 for(int j = 0;j<graph.verxs;j++) {//j����ʾû�б����ʵĽ��
					 if(visit[i] ==1 && visit[j] ==0 && graph.weight[i][j] <minWeight){
						 //�滻minWeight,Ѱ���Ѿ����ʹ�����δ���ʹ��Ľ���Ȩֵ��С�ı�
						 minWeight = graph.weight[i][j];
						 h1 = i;
						 h2 = j;
					 }
				 }
			 }
			 //�ҵ�һ��������С
			 System.out.println("��<" + graph.data[h1]+","+graph.data[h2]+">Ȩֵ��"+minWeight);
			 //����ǰ�����Ϊ�Ѿ����ʹ�
			 visit[h2] = 1;
			 //minWeight��������Ϊ���ֵ10000
			 minWeight = 10000;
		 }
	}
}


class MGraph{
	int verxs;//��ʾ������
	char[] data;//��Ž������
	int[][] weight;//��űߣ�������ڽӾ���
	
	public MGraph(int verxs) {
		this.verxs = verxs;
		data = new char[verxs];
		weight = new int[verxs][verxs];
		
		
	}
}
