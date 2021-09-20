package programmers;

public class DFS1 {

	public static void main(String[] args) {
		// 타겟 넘버
		/*
		 * 	n개의 음이 아닌 정수가 있습니다. 
		 *  이 수를 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다. 예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.

			-1+1+1+1+1 = 3
			+1-1+1+1+1 = 3
			+1+1-1+1+1 = 3
			+1+1+1-1+1 = 3
			+1+1+1+1-1 = 3
			사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.
			
			제한사항
			주어지는 숫자의 개수는 2개 이상 20개 이하입니다.
			각 숫자는 1 이상 50 이하인 자연수입니다.
			타겟 넘버는 1 이상 1000 이하인 자연수입니다.
			입출력 예
			numbers				target	return
			[1, 1, 1, 1, 1]			3		5
		 */
		
		int[] numbers= {1, 1, 1, 1, 1};
		int target = 3;
		int num = solution(numbers, target);
		System.out.println(num);
	}
	
	public static int num=0; //전체 경우의 수 
	
	public static int solution(int[] numbers, int target) {
		int[] check = new int[numbers.length]; //더하기 경우인지, 빼기 경우인지 체크하기 위한 배열
	    int answer = DFS(numbers, target, check, 0, 0);
	    return answer;
	}
	
	public static int DFS(int[] numbers, int target, int[] check, int level, int sum) {
		//레벨은 계산이 되는 수의 갯수 ex) level이 3이면 numbers[0], numbers[1], numbers[2]가 계산된다.
		if(level >= numbers.length) { //레벨이 numbers의 마지막에 도달하면
			if(sum==target) { //계산된 값이 target과 같으면 경우의 수를 증가시킨다.
				num++;
			}
		} else {
			check[level]=1; // 더하기
			DFS(numbers, target, check, level+1, sum+numbers[level]); 
			//재귀함수 DFS를 부를 때마다 계산되는 숫자인 level은 증가되고, 레벨에 맞는 수가 총 합에 더해진다
			check[level]=-1; //빼기
			DFS(numbers, target, check, level+1, sum-numbers[level]);
			//재귀함수 DFS를 부를 때마다 계산되는 숫자인 level은 증가되고, 레벨에 맞는 수가 총 합에 빼진다
					
		}
		if(num==0) return 0;
		else return num;
	}
}
