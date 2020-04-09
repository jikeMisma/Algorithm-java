package dynamic;

public class KnapsaackProblem {

	public static void main(String[] args) {
		
		int[] w = {1,4,3};//������Ʒ������
		int[] val = {1500,3000,2000};//��¼��Ʒ��ֵ�����val[i] = v[i]
		int m = 4;//��������
		int n = val.length;//��Ʒ����
		
		
		//������λ���飬
		//v[i][j]��ʾ��ǰi����Ʒ���ܹ�װ������Ϊj�ı����е�����ֵ
		int[][] v =new  int[n+1][m+1];
		//Ϊ�˼�¼������Ʒ�����������һ����ά����
		int[][] path = new int[n+1][m+1];
	
		
		//��ʼ����һ�к͵�һ��
		for(int i = 0;i<v.length;i++) {
			v[i][0] = 0;//����һ������Ϊ0
		}
		for(int i = 0;i<v[0].length;i++) {
			v[0][i] = 0;//����һ������Ϊ0
		}
		
		//����ǰ��õ��Ĺ�ʽ��̬����
		for(int i = 1;i<v.length;i++) {//�������һ��
			for(int j=1;j<v[0].length;j++) {//���������һ��
				//��ʽ
				if(w[i-1] >j) {//��Ϊ���ǵĳ���i�Ǵ�1��ʼ�����ԭ����w[i]Ҫ�޸ĳ�w[i-1]
					v[i][j] = v[i-1][j];
				}else {//
					//˵������Ϊi��1��ʼ����˹�ʽ��Ҫ���������
					 //v[i][j]=Math.max(v[i-1][j], val[i-1]+v[i-1][j-w[i-1]]);
					//Ϊ�˼�¼��Ʒ��ŵı�������������ǲ��ܼ�ʵ�����湫ʽ����Ҫ��if-else����
					if(v[i-1][j] < val[i-1]+v[i-1][j-w[i-1]] ) {
						v[i][j] =  val[i-1]+v[i-1][j-w[i-1]];
						//�ѵ�ǰ�����¼����
						path[i][j] = 1;
					}else {
						v[i][j] =v[i-1][j];
					}
				}
			}
		}
		
		//���v,
		for(int i = 0;i<v.length;i++) {
			for(int j = 0;j<v[i].length;j++) {
				System.out.print(v[i][j]+"\t");
			}
			System.out.println();
		}
		
		//������Ƿ��������Щ��Ʒ
		//�����������������ݣ�����ֻ��Ҫ���ķ������
//		for(int i = 0;i<path.length;i++) {
//			for(int j = 0;j<path[i].length;j++) {
//				if(path[i][j] ==1) {
//					System.out.printf("��%d����Ʒ�����˱���\n",i);
//				}
//			}
//		}
		
		int i= path.length-1;//�е�����±�
		int j =path[0].length -1;//�е�����±�
		while(i>0 && j>0) {
			if(path[i][j] ==1) {
				System.out.printf("��%d����Ʒ�����˱���\n",i);
				j -=w[i-1];
			}
			i--;
		}
		
	}

}
