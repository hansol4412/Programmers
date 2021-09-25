package programmers;

import java.util.HashMap;

public class ExhaustiveSearch3 {

	public static void main(String[] args) {
		// ī��
		/*
		 * 	Leo�� ī���� �緯 ���ٰ� �Ʒ� �׸��� ���� �߾ӿ��� ��������� ĥ���� �ְ� �׵θ� 1���� �������� ĥ���� �ִ� ���� ��� ī���� �ý��ϴ�.
		
			Leo�� ������ ���ƿͼ� �Ʊ� �� ī���� ������� �������� ��ĥ�� ������ ������ ���������, ��ü ī���� ũ��� ������� ���߽��ϴ�.
			
			Leo�� �� ī�꿡�� ���� ������ �� brown, ����� ������ �� yellow�� �Ű������� �־��� �� ī���� ����, ���� ũ�⸦ ������� �迭�� ���
			return �ϵ��� solution �Լ��� �ۼ����ּ���.
			
			���ѻ���
			���� ������ �� brown�� 8 �̻� 5,000 ������ �ڿ����Դϴ�.
			����� ������ �� yellow�� 1 �̻� 2,000,000 ������ �ڿ����Դϴ�.
			ī���� ���� ���̴� ���� ���̿� ���ų�, ���� ���̺��� ��ϴ�.
			����� ��
			brown	yellow		return
			10			2		[4, 3]
			8			1		[3, 3]
			24			24		[8, 6]
		 */
		
		int brown = 24;
		int yellow = 24;
		int[] answer = solution(brown, yellow);
		System.out.println(answer[0]);
		System.out.println(answer[1]);
	}
	
	public static int[] solution(int brown, int yellow) {
		HashMap<Integer,Integer> factorY = new HashMap<Integer,Integer>();
		HashMap<Integer,Integer> factorB = new HashMap<Integer,Integer>();
		
		int sqrtNumY = (int)Math.sqrt(yellow);
		
		for(int i =1; i<=sqrtNumY; i++) {
			if(yellow % i == 0) {
				factorY.put(i, yellow / i);
				factorB.put(i+2,(yellow / i)+2);
			}
		}
		
		//System.out.println(factorY);
		//System.out.println(factorB);
		
		int all = brown + yellow;
		HashMap<Integer,Integer> factorA = new HashMap<Integer,Integer>();
		int sqrtNumA = (int)Math.sqrt(all); 
		for(int i =1; i<=sqrtNumA; i++) {
			if(all % i == 0) {
				factorA.put(i, all / i);
			}
		}
		//System.out.println(factorA);
		
		
		int num1 = 0;
		int num2 = 0;
		
		for(int i =1; i<=sqrtNumY; i++) {
			if(yellow % i == 0) {
				if(factorB.get(i+2)==factorA.get(i+2)) {
					if((i+2)*(factorA.get(i+2)) == all){
						num1 = i+2;
						num2 = factorA.get(i+2); 
					}
					
				}
			}
		}
		
		//System.out.println(num1);
		//System.out.println(num2);

        int[] answer = {num2,num1};

        return answer;
    }

}
