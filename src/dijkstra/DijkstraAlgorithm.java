package dijkstra;

import java.util.Arrays;

public class DijkstraAlgorithm {

	public static void main(String[] args) {
		

	}

}
class Graph {
	private char[] vertex;//顶点数组
	private int[][] matrix;//邻接矩阵
	
	public Graph(char[] vertex,int[][] matrix) {
		this.vertex = vertex;
		this.matrix = matrix;
		
	}
	
	//显示图
	public void showGraph() {
		for(int[] link:matrix) {
			System.out.println(Arrays.toString(link));
		}
	}
	
	
}
