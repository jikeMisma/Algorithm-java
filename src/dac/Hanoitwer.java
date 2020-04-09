/**
 * 	title:分治算法实现汉若塔
 * 	date:2020.4.8
 */

package dac;

public class Hanoitwer {

	public static void main(String[] args) {
		
		hannoiTower(5,'A','B','C');

	}
	
	//汉若塔的移动方法
	//使用分分治算法
	public static void hannoiTower(int num,char a,char b,char c) {
		//如果只有一个
		if(num == 1) {
			System.out.println("第1个盘从"+a +"->"+c);
		}else {
			//如果num》=2，可以总是看做两个盘，最下面的是一个，除了最下面的其他的是一个盘
			//1.先把 最上面的盘 A->B,移动过程会用到c
			hannoiTower(num-1,a,c,b);
			
			//2.把最下边的盘 A->C
			System.out.println("第"+num+"个盘从"+a+"->"+c);
			
			
			//3.把B塔的所有盘 从 B->C  ,移动过程使用到a塔
			hannoiTower(num-1,b,c,a);
		}
		
	}

}
