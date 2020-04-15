﻿## 普利姆算法应用场景
![在这里插入图片描述](https://img-blog.csdnimg.cn/2020041410521389.png)
**问题转化**

**最小生成树**
修路问题本质就是就是最小生成树问题， 先介绍一下最小生成树(Minimum Cost Spanning Tree)，简称MST。
1. 给定一个带权的无向连通图,如何选取一棵生成树,使树上所有边上权的总和为最小,这叫最小生成树 
2.N个顶点，一定有N-1条边
2. 包含全部顶点
3. N-1条边都在图中
4. 举例说明(如图:)
5. 求最小生成树的算法主要是普里姆算法和克鲁斯卡尔算法
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200414105520551.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L216Y19sb3Zl,size_16,color_FFFFFF,t_70#pic_center)

## 普利姆算法介绍
1. 从< A >点开始分析处理 ====><A,G>
A-C[7]	A-B[5]	A-G[2]
2. 从<A，G>开始，将A和G顶点和他们的相邻的还没有访问的顶点进行处理 ====><A,G,B>
A-C[7]	A-B[5]	G-B[3]	G-E[4]	G-F[6]
3. 从<A,G,B>开始，将顶点A，G，B和他们的相邻的还没有访问的顶点进行处理 ====><A,G,B,E>
A-C[7]	G-E[4]	G-F[6]	B-D[9]
4. 以此类推
5. 最后得到完整集合<A,G,B,E,F,D,C>
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200414111347243.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L216Y19sb3Zl,size_16,color_FFFFFF,t_70#pic_center)
**代码实现**

```java
/**
 * title：普利姆算法
 * date：2020.4.14
 */

package prim;

import java.util.Arrays;

public class PrimAlgorithm {

	public static void main(String[] args) {
		
		//测试看看图是否创建成功
		char[] data = new char[] {'A','B','C','D','E','F','G',};
		int verxs = data.length;
		//邻接矩阵的关系使用二维数组描述,10000这个大数表示两点不连通
		int[][] weight = new int[][] {
			{10000,5,7,10000,10000,10000,2},
			{5,10000,10000,9,10000,10000,3},
			{7,10000,10000,10000,8,10000,10000},
			{10000,9,10000,10000,10000,4,10000},
			{10000,10000,8,10000,10000,5,4},
			{10000,10000,10000,4,5,10000,6},
			{2,3,10000,10000,4,6,10000},
		};
		
		//创建MGraph的对象
		MGraph mGraph = new MGraph(verxs);
		//创建一个minterr对象
		MinTree minTree = new MinTree();
		minTree.createGraph(mGraph,verxs,data,weight);
		//输出
		minTree.showGraph(mGraph);
		
		
		//测试prim算法
		minTree.prim(mGraph,0);
		
	}

}

//创建最小生成树-》村庄的树
class MinTree{
	//创建图的邻接矩阵
	/**
	 * 
	 * @param graph	图对象
	 * @param verxs	图对应的顶点个数
	 * @param data	图的各个顶点的值
	 * @param weight	图的邻接矩阵
	 */
	public void createGraph(MGraph graph,int verxs,char[] data,int[][] weight) {
		
		int i,j;
		for( i = 0;i<verxs;i++) {//顶点
			graph.data[i] = data[i];
			for(j = 0;j<verxs;j++) {
				graph.weight[i][j] = weight[i][j] ;
			}
		}
	}
	//显示图的方法:显示图的邻接矩阵
	public void showGraph(MGraph graph) {
		for(int[] link:graph.weight) {
			System.out.println(Arrays.toString(link));
		}
	}
	
	//编写一个prim算法，得到最小生成树
	/**
	 * 
	 * @param graph	图
	 * @param v	表示从图的第几个顶点开始生成
	 */
	public  void prim(MGraph graph,int v) {
		// visit[] 标记结点是否被访问过
		int visit[] = new int[graph.verxs];
		// visit[] 默认元素都是0，表示没有被访问符
		//把当前结点标记为已访问
		 visit[v] = 1;
		 //用h1 h2记录两个顶点的坐标
		 int h1 = -1;
		 int h2 = -1;
		 int minWeight = 10000;//minWeight 初始为一个大数，后面遍历的时候会被替换
		 for(int k= 1;k<graph.verxs;k++) {//因为有graph.verxs顶点，prim算法结束后，会有graph.verxs-1条边
			 
			 //这个是确定每一次生成的子图和哪个结点的距离最近
			 for(int i = 0;i<graph.verxs;i++) {//i结点表示被访问过的结点
				 for(int j = 0;j<graph.verxs;j++) {//j结点表示没有被访问的结点
					 if(visit[i] ==1 && visit[j] ==0 && graph.weight[i][j] <minWeight){
						 //替换minWeight,寻找已经访问过结点和未访问过的结点间权值最小的边
						 minWeight = graph.weight[i][j];
						 h1 = i;
						 h2 = j;
					 }
				 }
			 }
			 //找到一条边是最小
			 System.out.println("边<" + graph.data[h1]+","+graph.data[h2]+">权值："+minWeight);
			 //将当前结点标记为已经访问过
			 visit[h2] = 1;
			 //minWeight重新设置为最大值10000
			 minWeight = 10000;
		 }
	}
}


class MGraph{
	int verxs;//表示结点个数
	char[] data;//存放结点数据
	int[][] weight;//存放边，这就是邻接矩阵
	
	public MGraph(int verxs) {
		this.verxs = verxs;
		data = new char[verxs];
		weight = new int[verxs][verxs];
		
		
	}
}

```
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200415110807552.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L216Y19sb3Zl,size_16,color_FFFFFF,t_70)
