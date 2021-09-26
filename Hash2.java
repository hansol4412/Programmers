package programmers;

import java.util.HashMap;

public class Hash2 {

	public static void main(String[] args) {
		// 전화번호 목록
		/*
		 * 	전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
			전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.
			
			구조대 : 119
			박준영 : 97674223
			지영석 : 1195524421
			전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때, 
			어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.
			
			제한 사항
			phone_book의 길이는 1 이상 1,000,000 이하입니다.
			각 전화번호의 길이는 1 이상 20 이하입니다.
			같은 전화번호가 중복해서 들어있지 않습니다.
			입출력 예제
			phone_book							return
			["119", "97674223", "1195524421"]	false
			["123","456","789"]					true
			["12","123","1235","567","88"]		false
			입출력 예 설명
			입출력 예 #1
			앞에서 설명한 예와 같습니다.
			
			입출력 예 #2
			한 번호가 다른 번호의 접두사인 경우가 없으므로, 답은 true입니다.
			
			입출력 예 #3
			첫 번째 전화번호, “12”가 두 번째 전화번호 “123”의 접두사입니다. 따라서 답은 false입니다.
		 */
		String[] phone_book = {"123","456","789"};
		boolean answer = solution(phone_book);
		System.out.println(answer);
	}
	
	public static boolean solution(String[] phoneBook) { // 효율성 테스트 3,4 통과x
		boolean answer = true; 
		// 1. HashMap 만들기 
		HashMap<String, Integer> map = new HashMap<>(); 
		// 2. 모든 전화번호 Hashing 하기 (Hash Map에 추가하기) 
		for(int i = 0; i < phoneBook.length; i++) 
			map.put(phoneBook[i], i); 
		
		// 3. 다시 돌며 각 전화번호의 일부가 HashMap에 있는지 확인하기 (접두어가 존재하는지 확인하기) 
		for(int i = 0; i < phoneBook.length; i++) { 
			for(int j = 1; j < phoneBook[i].length(); j++) { 
				if(map.containsKey(phoneBook[i].substring(0,j))) {
					answer = false; return answer; 
					} 
				} 
			} return answer;	
		}

}
