package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class Sort2 {

	public static void main(String[] args) {
		// 가장 큰 수
		/*
		 * 0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
		 * 
		 * 예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고,
		 * 이중 가장 큰 수는 6210입니다.
		 * 
		 * 0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어
		 * return 하도록 solution 함수를 작성해주세요.
		 * 
		 * 제한 사항 numbers의 길이는 1 이상 100,000 이하입니다. numbers의 원소는 0 이상 1,000 이하입니다. 
		 * 정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다. 
		 * 입출력 예 
		 * numbers 				return 
		 * [6, 10, 2] 			"6210" 
		 * [3, 30, 34, 5, 9] 	"9534330"
		 */
		int[] array = {3, 30, 34, 5, 9};
		String num = solution(array);
		System.out.println(num);
	}

	public static String solution(int[] numbers) {
		//숫자형 배열을 문자열 배열로 변환하기
		String[] strArr = new String[numbers.length];
		for(int i =0; i<numbers.length; i++) {
			strArr[i] = String.valueOf(numbers[i]);
		}
		
		Arrays.sort(strArr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				//앞, 뒤 문자를 서로 순서를 바꿔가면서 문자열을 만든 뒤 크기비교
				//compareTo => 앞에 수에서 뒤의 수를 빼서 0이면 동일, 음수이면 앞에 수가 작은 것, 양수이면 앞에 수가 큰 것
				return ((o2 + o1).compareTo(o1 + o2));
			}
		});
		
		//들어온 배열 전부 다 0일 때, 정렬된 배열의 처음 숫자가 0일 경우 0을 리턴
		if(strArr[0].equals("0")) {
			return "0";
		}
		
		//배열을 문자열로 합치기
		String answer = "";
		for(String str : strArr) {
			answer = answer + str;
		}
		return answer;
	}


}
