package programmers;

public class Sort1 {

	public static void main(String[] args) {
		// k번째 수
		/*
		배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.
		
		예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면
		array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
		1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
		2에서 나온 배열의 3번째 숫자는 5입니다.
		배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때, 
		commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.

		입출력 예
		array					commands							return
		[1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]	[5, 6, 3]
		입출력 예 설명
		[1, 5, 2, 6, 3, 7, 4]를 2번째부터 5번째까지 자른 후 정렬합니다. [2, 3, 5, 6]의 세 번째 숫자는 5입니다.
		[1, 5, 2, 6, 3, 7, 4]를 4번째부터 4번째까지 자른 후 정렬합니다. [6]의 첫 번째 숫자는 6입니다.
		[1, 5, 2, 6, 3, 7, 4]를 1번째부터 7번째까지 자릅니다. [1, 2, 3, 4, 5, 6, 7]의 세 번째 숫자는 3입니다.
		*/
		
		int[] array =  {1, 5, 2, 6, 3, 7, 4};
		
		int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};
		
		int[] answer = solution(array, commands); 
		
		for(int i =0; i<answer.length; i++) {
			System.out.println(answer[i]);
		}
		
	}
	
	public static int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
        int answerNum = 0;
		for(int i=0; i<commands.length; i++) {
			int[] innerArray = new int[(commands[i][1]+1)-commands[i][0]]; //내부 array 초기화해주기
			int seqNum = 0;
			for(int j = commands[i][0]-1 ; j<commands[i][1]; j++) { //k부터 n까지의 수를 배열로 만들어 주기
				innerArray[seqNum] = array[j];
				seqNum++;
			}
			sort(innerArray); //만든 inner array를 정렬하기
			answer[answerNum] = innerArray[commands[i][2]-1]; 
			//정렬한 배열에서 원하는 순서의 수를 찾아내기
			//리턴해야 할 배열에 수 추가하기
			
			answerNum++;
		}
        return answer;
    }
	
	public static void sort(int[] innerArray) { //삽입정렬로 정렬하기
		for(int i = 0; i<innerArray.length; i++) {
			int min = innerArray[i];
			int minPos = i;
			for(int j=i+1; j <innerArray.length; j++) {
				if(min>innerArray[j]) {
					min = innerArray[j];
					minPos = j;
				}
			}
			
			int temp = innerArray[i];
			innerArray[i] = min;
			innerArray[minPos] = temp;
		}
	}

}
