/**
 * title:����ƥ���㷨ʵ��
 * date��2020.4010
 */
package kmp;

public class VolenceMetch {

	public static void main(String[] args) {

		//���Ա���ƥ��
		String str1 = "����� ���������־�� �����־�� ������";
		String str2 =" �����־��";
		int index = vilenceMatch(str1,str2);
		System.out.println(index);
		

	}
	
	//����ƥ���㷨ʵ��
	public static int vilenceMatch(String str1,String str2){
		char[] s1=str1.toCharArray();
		char[] s2=str2.toCharArray();
		int  s1Len = s1.length;
		int  s2Len = s2.length;
		
		int i = 0;//����ָs1
		int j = 0;//����ָ��s2
		while(i<s1Len && j<s2Len) {//��֤ƥ��ʱ����Խ��
			if(s1[i] ==s2[j]) {//ƥ��ɹ�
				i++;
				j++;
			}else {//û��ƥ��ɹ�
				//���ʧ�䣨��str1[i]! = str2[j]������i = i - (j - 1)��j = 0
				i = i-(j-1);
				j = 0;
				
			}
		}
		
		//�ж��Ƿ�ƥ��ɹ�
		if(j == s2Len) {
			return i -j;
		}else {
			return -1;
		}
		
	}

}
