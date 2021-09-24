package programmers;

import java.util.HashMap;


public class Hash1_1 {

	public static void main(String[] args) {
		// 완주하지 못한 선수
		/*
		 * 수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다. 마라톤에 참여한
		 * 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의
		 * 이름을 return 하도록 solution 함수를 작성해주세요.
		 * 
		 * 제한사항 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다. completion의 길이는 participant의
		 * 길이보다 1 작습니다. 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다. 참가자 중에는 동명이인이 있을 수
		 * 있습니다.
		 * 
		 * 입출력 예 participant completion return ["leo", "kiki", "eden"] ["eden", "kiki"]
		 * "leo" ["marina", "josipa", "nikola", "vinko", "filipa"] ["josipa", "filipa",
		 * "marina", "nikola"] "vinko" ["mislav", "stanko", "mislav", "ana"] ["stanko",
		 * "ana", "mislav"] "mislav"
		 * 
		 * 입출력 예 설명 예제 #1 "leo"는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.
		 * 
		 * 예제 #2 "vinko"는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.
		 * 
		 * 예제 #3 "mislav"는 참여자 명단에는 두 명이 있지만, 완주자 명단에는 한 명밖에 없기 때문에 한명은 완주하지 못했습니다.
		 */

		String[] participant = { "marina", "josipa", "nikola", "vinko", "filipa" };
		String[] completion = { "josipa", "filipa", "marina", "nikola" };

		String answer = solution(participant, completion);
		System.out.println(answer);

	}

	public static String solution(String[] participant, String[] completion) {

		String answer = "";
		HashMap<String, Integer> hm = new HashMap<>();
		
									
		for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1); //
		//getOrDefault() => 찾는 키가 존재한다면 찾는 키의 값을 반환하고 없다면 기본 값을 반환하는 메서드
		//				 => player이 존재하면 player값 + 1 , 없으면 0+1 저장 => 이름 중복 방지
		
		/*
		for (String key : hm.keySet()) {
			System.out.print(key);
			System.out.println("--"+hm.get(key));
		}
		*/
		
		
		for (String player : completion) hm.put(player, hm.get(player) - 1); 
		// player있으면 player 값 -1 => 완주못한 선수는 0보다 큰 수로 존재
		
		/*
		for (String key : hm.keySet()) {
			System.out.print(key);
			System.out.println("--"+hm.get(key));
		}
		*/
		
		for (String key : hm.keySet()) {
			if (hm.get(key) != 0) { //0보다 큰 값이면 완주 못한 선수
				answer = key;
				break;
			}
		}
		return answer;

	}

}
