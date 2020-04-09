package dynamic;

public class KnapsaackProblem {

	public static void main(String[] args) {
		
		int[] w = {1,4,3};//保存物品的重量
		int[] val = {1500,3000,2000};//记录物品价值这里的val[i] = v[i]
		int m = 4;//背包容量
		int n = val.length;//物品个数
		
		
		//创建二位数组，
		//v[i][j]表示在前i个物品中能够装入容量为j的背包中的最大价值
		int[][] v =new  int[n+1][m+1];
		//为了记录放入商品的情况，定义一个二维数组
		int[][] path = new int[n+1][m+1];
	
		
		//初始化第一行和第一列
		for(int i = 0;i<v.length;i++) {
			v[i][0] = 0;//将第一列设置为0
		}
		for(int i = 0;i<v[0].length;i++) {
			v[0][i] = 0;//将第一行设置为0
		}
		
		//根据前面得到的公式动态处理
		for(int i = 1;i<v.length;i++) {//不处理第一行
			for(int j=1;j<v[0].length;j++) {//代表不处理第一列
				//公式
				if(w[i-1] >j) {//因为我们的程序i是从1开始，因此原来的w[i]要修改成w[i-1]
					v[i][j] = v[i-1][j];
				}else {//
					//说明：因为i从1开始，因此公式需要调成下面的
					 //v[i][j]=Math.max(v[i-1][j], val[i-1]+v[i-1][j-w[i-1]]);
					//为了记录商品存放的背包的情况，我们不能简单实用上面公式，需要用if-else体现
					if(v[i-1][j] < val[i-1]+v[i-1][j-w[i-1]] ) {
						v[i][j] =  val[i-1]+v[i-1][j-w[i-1]];
						//把当前情况记录下来
						path[i][j] = 1;
					}else {
						v[i][j] =v[i-1][j];
					}
				}
			}
		}
		
		//输出v,
		for(int i = 0;i<v.length;i++) {
			for(int j = 0;j<v[i].length;j++) {
				System.out.print(v[i][j]+"\t");
			}
			System.out.println();
		}
		
		//输出我们放入的是哪些物品
		//这样输出有冗余的数据，我们只需要最后的放入情况
//		for(int i = 0;i<path.length;i++) {
//			for(int j = 0;j<path[i].length;j++) {
//				if(path[i][j] ==1) {
//					System.out.printf("第%d个商品放入了背包\n",i);
//				}
//			}
//		}
		
		int i= path.length-1;//行的最大下标
		int j =path[0].length -1;//列的最大下标
		while(i>0 && j>0) {
			if(path[i][j] ==1) {
				System.out.printf("第%d个商品放入了背包\n",i);
				j -=w[i-1];
			}
			i--;
		}
		
	}

}
