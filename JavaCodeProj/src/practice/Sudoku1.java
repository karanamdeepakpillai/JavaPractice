package practice;

import java.util.*;

public class Sudoku1 {

	public static void main(String[] args) {
		int a=5;
		int b=3;
		int c=a/b;
		//System.out.println(2/3);
		/*
		 * Integer[][] matrix= {{0,8,0,0,1,0,7,0,6}, {7,0,0,6,9,0,8,3,0},
		 * {0,6,4,0,0,0,2,0,0}, {2,9,0,0,8,7,0,0,3}, {0,5,0,2,0,3,0,6,0},
		 * {4,0,0,9,6,0,0,2,8}, {0,0,8,0,0,0,3,7,0}, {0,3,7,0,2,8,0,0,4},
		 * {6,0,5,0,3,0,0,8,0}};
		 */
		Integer[][] matrix={{5, 3, 0, 0, 7, 0, 0, 0, 0},
	            {6, 0, 0, 1, 9, 5, 0, 0, 0},
	            {0, 9, 8, 0, 0, 0, 0, 6, 0},
	            {8, 0, 0, 0, 6, 0, 0, 0, 3},
	            {4, 0, 0, 8, 0, 3, 0, 0, 1},
	            {7, 0, 0, 0, 2, 0, 0, 0, 6},
	            {0, 6, 0, 0, 0, 0, 2, 8, 0},
	            {0, 0, 0, 4, 1, 9, 0, 0, 5},
	            {0, 0, 0, 0, 8, 0, 0, 7, 9}};
		int zeroCount=0;
		do{
		zeroCount=0;
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				//if(matrix[i][j]==0)
					//getNumber(matrix, i, j);
					System.out.print((matrix[i][j]=getNumber(matrix, i, j))+" ");
					if(matrix[i][j]==0)
						zeroCount++;
					
			}
			System.out.println();
		}
		System.out.println(zeroCount);
		}while(zeroCount>0);
	}
	
	public static int getNumber(Integer[][] matrix,int x, int y) {
		if(matrix[x][y]>0) return matrix[x][y];
		
		Integer[] numArr = {1,2,3,4,5,6,7,8,9};
		List<Integer> numList = Arrays.asList(numArr);
		HashSet<Integer> numSet = new HashSet<>(numList);
		for(int i=0;i<matrix.length;i++) {
				numSet.remove(matrix[x][i]);
				numSet.remove(matrix[i][y]);
		}
		//System.out.println(x+":"+y+"===");
		for(int i=((x/3)*3);i<((x/3)*3)+3;i++) {
			for(int j=((y/3)*3);j<((y/3)*3)+3;j++) {
				numSet.remove(matrix[i][j]);
				//System.out.println(i+":"+j);
			}
		}
		if(numSet.size()==1) {
			return (int)(numSet.toArray())[0];
		}
		
		return 0;
		
	}
}
