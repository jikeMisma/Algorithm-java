/**
 * 	title:�����㷨ʵ�ֺ�����
 * 	date:2020.4.8
 */

package dac;

public class Hanoitwer {

	public static void main(String[] args) {
		
		hannoiTower(5,'A','B','C');

	}
	
	//���������ƶ�����
	//ʹ�÷ַ����㷨
	public static void hannoiTower(int num,char a,char b,char c) {
		//���ֻ��һ��
		if(num == 1) {
			System.out.println("��1���̴�"+a +"->"+c);
		}else {
			//���num��=2���������ǿ��������̣����������һ�����������������������һ����
			//1.�Ȱ� ��������� A->B,�ƶ����̻��õ�c
			hannoiTower(num-1,a,c,b);
			
			//2.�����±ߵ��� A->C
			System.out.println("��"+num+"���̴�"+a+"->"+c);
			
			
			//3.��B���������� �� B->C  ,�ƶ�����ʹ�õ�a��
			hannoiTower(num-1,b,c,a);
		}
		
	}

}
