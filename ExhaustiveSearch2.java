package programmers;

import java.util.HashSet;

public class ExhaustiveSearch2 {

	public static void main(String[] args) {
		// 소수찾기
		/*
		 * 	한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.

			각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
			
			제한사항
			numbers는 길이 1 이상 7 이하인 문자열입니다.
			numbers는 0~9까지 숫자만으로 이루어져 있습니다.
			"013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
			
			입출력 예
			numbers	return
			"17"	3
			"011"	2
			
			입출력 예 설명
			예제 #1
			[1, 7]으로는 소수 [7, 17, 71]를 만들 수 있습니다.
			
			예제 #2
			[0, 1, 1]으로는 소수 [11, 101]를 만들 수 있습니다.
			
			11과 011은 같은 숫자로 취급합니다.
		 */
		
		String numbers = "011";
		int answer = solution(numbers);
		System.out.println(answer);
	}
	public static int solution(String numbers) {
		int answer = 0;
		String[] separateString = numbers.split(""); // 들어온 문자열 쪼개기
		int[] separateNum = new int[numbers.length()]; // 쪼갠 문자열을 숫자형 배열로 옮기기

		for (int i = 0; i < separateString.length; i++) {
			separateNum[i] = Integer.parseInt(separateString[i]);
		}

		int[] check = new int[separateNum.length]; //방문했던 수 확인하기 위한 배열

		DFS(separateNum, check, 0, ""); // 숫자 조합 만들어 내기

		for (int i : num) {
			if (ckeckPrime(i)) { //소수체크해서 소수이면 증가
				answer++;
			}
		}
		return answer;
	}

	public static HashSet<Integer> num = new HashSet<Integer>(); // 숫자 중복 거르기

	public static void DFS(int[] numbers, int[] check, int level, String finalNum) {
		if (level >= numbers.length) {
			if (finalNum == "" || finalNum.startsWith("0")) { //빈칸과 0제거
			} else {
				// System.out.println(finalNum);
				num.add(Integer.parseInt(finalNum)); //해쉬셋에 넣어서 중복제거
			}
		} else {
			for (int i = 0; i < numbers.length; i++) {
				if (check[i] == 0) {
					check[i] = 1; //갔던 수 체크
					DFS(numbers, check, level + 1, finalNum + numbers[i]);
					DFS(numbers, check, level + 1, finalNum);
					check[i] = 0; //다시 풀기
				}
			}
		}
	}

	public static boolean ckeckPrime(int n) {
//		System.out.println(num);

		int sqrtNum = (int) Math.sqrt(n);

		if (n == 2) { //소수 중 유일한 짝수
			return true;
		}

		if (n == 1 || n % 2 == 0) { //1과 짝수 제거
			return false;
		}

		for (int i = 3; i <= sqrtNum; i = i + 2) { //제곱근까지만 체크, 짝수 제거했기에 2씩 증가
			if (n % i == 0) { //나눠지면 소수 아님
				return false;
			}
		}

		return true;

	}

}

