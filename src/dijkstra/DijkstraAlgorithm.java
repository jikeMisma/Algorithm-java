package dijkstra;

import java.util.Arrays;

public class DijkstraAlgorithm {

	public static void main(String[] args) {
		

	}

}
class Graph {
	private char[] vertex;//��������
	private int[][] matrix;//�ڽӾ���
	
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
	
	
}
