package programmers;

import java.util.HashMap;

public class ExhaustiveSearch3_1 {

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
		int sqrtNumY = (int)Math.sqrt(yellow);
		for(int c = 1; c <= sqrtNumY; c++) {
	           if(yellow % c == 0) {
	                int r = yellow / c;
	                if((r + 2) * (c + 2) == yellow + brown)
	                    return new int[] {r + 2, c + 2};
	            }
	       }
		
	    return new int[] {};
    }

}
