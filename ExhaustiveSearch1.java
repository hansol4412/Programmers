package programmers;

import java.util.ArrayList;

public class ExhaustiveSearch1 {

	public static void main(String[] args) {
		// 모의고사
		/*
		 * 수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막
		 * 문제까지 다음과 같이 찍습니다.
		 * 
		 * 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ... 2번 수포자가 찍는 방식: 2, 1, 2, 3,
		 * 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ... 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4,
		 * 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
		 * 
		 * 1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에
		 * 담아 return 하도록 solution 함수를 작성해주세요.
		 * 
		 * 제한 조건 시험은 최대 10,000 문제로 구성되어있습니다. 문제의 정답은 1, 2, 3, 4, 5중 하나입니다. 가장 높은 점수를 받은
		 * 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요. 입출력 예 answers return [1,2,3,4,5] [1]
		 * [1,3,2,4,2] [1,2,3] 입출력 예 설명 입출력 예 #1
		 * 
		 * 수포자 1은 모든 문제를 맞혔습니다. 수포자 2는 모든 문제를 틀렸습니다. 수포자 3은 모든 문제를 틀렸습니다. 따라서 가장 문제를 많이
		 * 맞힌 사람은 수포자 1입니다.
		 * 
		 * 입출력 예 #2
		 * 
		 * 모든 사람이 2문제씩을 맞췄습니다.
		 */

		int[] so = { 1, 2, 3, 4, 5, 1, 2, 3, 4, 5 };
		int[] solution = solution(so);
		for (int i = 0; i < solution.length; i++) {
			System.out.println(solution[i] + "번째 학생이 가장 많은 문제를 맞췄습니다.");
		}

	}

	public static int[] solution(int[] answers) {

		// 찍기 규칙배열로 설정해주기
		int[] p1 = { 1, 2, 3, 4, 5 };
		int[] p2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] p3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

		int[] cnt = { 0, 0, 0 }; // 각 사람 당 찍는 규칙의 순서를 파악하기 위한 변수
		int[] cntScore = { 0, 0, 0 }; // 각 사람 당 점수
		int[] queNum = { 0, 0, 0 }; //채점한 문제 파악하기 위한 변수

		while (queNum[0] < answers.length) {  //채점 문제가 전체 문제 수보다 크면 탈출
			if (cnt[0] == p1.length) { //규칙적으로 숫자를 증가시켰을 때 마지막에 도달했을 때 다시 0으로 만들어 줘서 규칙 순환하기
				cnt[0] = 0;
			}
			if (p1[cnt[0]] == answers[queNum[0]]) {//답과 맞았을 때 점수 증가
				cntScore[0]++;
			}
			cnt[0]++; //규칙순서 증가
			queNum[0]++; //전체 채점 갯수 증가
		}
		System.out.println(cntScore[0]);

		while (queNum[1] < answers.length) {
			if (cnt[1] == p2.length) {
				cnt[1] = 0;
			}
			if (p2[cnt[1]] == answers[queNum[1]]) {
				cntScore[1]++;
			}
			cnt[1]++;
			queNum[1]++;
		}
		System.out.println(cntScore[1]);

		while (queNum[2] < answers.length) {
			if (cnt[2] == p3.length) {
				cnt[2] = 0;
			}
			if (p3[cnt[2]] == answers[queNum[2]]) {
				cntScore[2]++;
			}
			cnt[2]++;
			queNum[2]++;
		}
		System.out.println(cntScore[2]);

		ArrayList<Integer> max = new ArrayList<Integer>(); //최고점 사람을 파악하기 위한 arraylist

		int maxnum = 0; //최고점수 찾기
		for (int i = 0; i < 3; i++) {
			if (cntScore[i] > maxnum) {
				maxnum = cntScore[i];
			}
		}
		System.out.println(maxnum);

		for (int i = 0; i < 3; i++) { //최고점수와 같은 점수를 가진 사람을 list에 추가하기
			if (cntScore[i] == maxnum) {
				max.add(i + 1);
			}
		}

		int[] answer = new int[max.size()]; 
		//리스트를 배열로 변환하기
		for (int i = 0; i < max.size(); i++) {
			answer[i] = max.get(i);
		}

		return answer;
	}

}
