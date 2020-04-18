package dijkstra;

import java.util.Arrays;

public class DijkstraAlgorithm {

	public static void main(String[] args) {
		
		char[] vertex = {'A','B','C','D','E','F','G'};
		//�ڽӾ���
		int[][] matrix = new int[vertex.length][vertex.length];
		final int N = 65535;//��ʾ����������
		matrix[0] = new int[]{N,5,7,N,N,N,2};  
		matrix[1] = new int[]{5,N,N,9,N,N,3};  
		matrix[2] = new int[]{7,N,N,N,8,N,N};  
		matrix[3] = new int[]{N,9,N,N,N,4,N};  
		matrix[4] = new int[]{N,N,8,N,N,5,4};  
		matrix[5] = new int[]{N,N,N,4,5,N,6};  
		matrix[6] = new int[]{2,3,N,N,4,6,N};
		
		//����Graph����
		Graph graph = new Graph(vertex,matrix);
		//����
		graph.showGraph();
		
		//����dsj
		graph.dsj(6);
		

	}

}
class Graph {
	private char[] vertex;//��������
	private int[][] matrix;//�ڽӾ���
	private Visited_vertex vv;//�Ѿ����ʽ��ļ���
	
	public Graph(char[] vertex,int[][] matrix) {
		this.vertex = vertex;
		this.matrix = matrix;
		
	}
	
	//��ʾͼ
	public void showGraph() {
		for(int[] link:matrix) {
			System.out.println(Arrays.toString(link));
		}
	}
	
	//�Ͻ�˹�����㷨ʵ��
	/**
	 * 
	 * @param index ��ʾ��������Ӧ���±�
	 */
	public void dsj(int index) {
		 vv = new Visited_vertex(vertex.length,index);
		 update(index);//����index�±궥�㵽��Χ����ľ����ǰ������
	}
	
	//�����±궥�㵽��Χ����ľ������Χ�����ǰ�����
	private void update(int index) {
		int len = 0;
		for(int j = 0;j<matrix[index].length;j++) {
			//len���壺�������㵽index����ľ���+ index���㵽j�������ĺ�
			len = vv.getDis(index)+matrix[index][j];
			//���j����û�б����ʹ�������lenС�ڳ������㵽j����ľ��룬����Ҫ����
			if(!vv.in(j) &&len<vv.getDis(j)) {
				vv.updatePre(j,index);//����j�����ǰ��Ϊindex�������
				vv.updateDis(j,len);//���³������㵽j�ľ���
				
			}
		}
	}
	
	
	
	
}

//�ѷ��ʶ��㼯��
class Visited_vertex {
	// ��¼���������Ƿ���ʹ� 1��ʾ���ʹ�,0δ����,�ᶯ̬����
	public int[] already_arr; 
	// ÿ���±��Ӧ��ֵΪǰһ�������±�, �ᶯ̬����
	public int[] pre_visited;
	// ��¼�������㵽�������ж���ľ���,����GΪ�������㣬�ͻ��¼G����������ľ��룬�ᶯ̬���£������̾���ͻ��ŵ�dis
	public int[] dis;
	
	//������
	/**
	 * 
	 * @param length  ��ʾ����ĸ���
	 * @param index	  ���������Ӧ�ĸ���
	 */
	public Visited_vertex(int length,int index) {
		this.already_arr = new int[length];
		this.pre_visited = new int[length];
		this.dis =  new int[length];
		
		//��ʼ��dis����
		Arrays.fill(dis,65535);
		this.already_arr[index] = 1;//���ó������㱻���ʹ�
		this.dis[index] = 0;//���ó�������ķ��ʾ���Ϊ0
		
	}
	
	/**
	 * ���ܣ��ж�index����ǹ����ʹ�
	 * 
	 * @param index
	 * @return  ������ʹ����ͷ���ture������false
	 */
	public boolean in(int index) {
		return already_arr[index] ==1;
	}
	
	/**
	 * ���ܣ����³�����㵽index���ľ���
	 * @param index
	 * @param len
	 */
	public void updateDis(int index,int len) {
		dis[index] = len;
	}
	
	/**
	 * ���ܣ����½���ǰ��Ϊindex���
	 * @param pre
	 * @param index
	 */
	public void updatePre(int pre,int index) {
		pre_visited[pre] = index;
	}
	
	/**
	 * ���ܣ����س�����㵽index���ľ���
	 * @param index
	 * @return
	 */
	public int getDis(int index) {
		return dis[index];
	}

}
