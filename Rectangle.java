package programmers;

import java.util.HashMap;

public class Rectangle {

	public static void main(String[] args) {
		//직사각형
		/*
		 *  직사각형을 만드는 데 필요한 4개의 점 중 3개의 좌표가 주어질 때, 나머지 한 점의 좌표를 구하려고 합니다. 점 3개의 좌표가 들어있는 배열 v가 매개변수로 주어질 때, 직사각형을 만드는 데 필요한 나머지 한 점의 좌표를 return 하도록 solution 함수를 완성해주세요. 단, 직사각형의 각 변은 x축, y축에 평행하며, 반드시 직사각형을 만들 수 있는 경우만 입력으로 주어집니다.

			제한사항
			v는 세 점의 좌표가 들어있는 2차원 배열입니다.
			v의 각 원소는 점의 좌표를 나타내며, 좌표는 [x축 좌표, y축 좌표] 순으로 주어집니다.
			좌표값은 1 이상 10억 이하의 자연수입니다.
			직사각형을 만드는 데 필요한 나머지 한 점의 좌표를 [x축 좌표, y축 좌표] 순으로 담아 return 해주세요.
			입출력 예
			v							result
			[[1, 4], [3, 4], [3, 10]]	[1, 10]
			[[1, 1], [2, 2], [1, 2]]	[2, 1]
			입출력 예 설명
			입출력 예 #1
			세 점이 [1, 4], [3, 4], [3, 10] 위치에 있을 때, [1, 10]에 점이 위치하면 직사각형이 됩니다.
			
			입출력 예 #2
			세 점이 [1, 1], [2, 2], [1, 2] 위치에 있을 때, [2, 1]에 점이 위치하면 직사각형이 됩니다.
		 */
		
		int[][] v = {{1, 4}, {3, 4}, {3, 10}};
		int[] answer = solution(v);
		for(int i =0; i<answer.length; i++) {
			System.out.println(answer[i]);
		}

	}
	 public static int[] solution(int[][] v) {
	        
	        
	        HashMap<Integer, Integer> row = new HashMap<>();
	        HashMap<Integer, Integer> col = new HashMap<>();
	        
	        for(int i =0 ; i<v.length; i++){
	            row.put(v[i][0], row.getOrDefault(v[i][0],0)+1);
	            col.put(v[i][1], col.getOrDefault(v[i][1],0)+1);
	        }
	        
	        int r=0;
	        int c=0;
	        
	        for(int i =0 ; i<v.length; i++){
	            if (row.get(v[i][0]) == 1) { 
	                r = v[i][0];

	            }
	            if (col.get(v[i][1]) == 1) { 
	                c = v[i][1];

	            }
	        }
	        	        
	        int[] answer = {r,c};
	        
	        return answer;
	    }

}
