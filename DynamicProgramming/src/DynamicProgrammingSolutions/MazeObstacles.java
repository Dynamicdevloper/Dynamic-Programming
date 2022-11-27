package DynamicProgrammingSolutions;

import java.util.*;
public class MazeObstacles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}
	
	 static int mod=(int)(1e9+7);
	    static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {
	        // Write your code here.
	        return uniquePaths(n,m,mat);
	    }

	    public static int uniquePaths(int m, int n,ArrayList<ArrayList<Integer>> mat) {
	        // Write your code here.
	        int[][] dp=new int[m+1][n+1];
	        for(int i=m-1; i>=0; i--){
	            for(int j=n-1; j>=0; j--){
	                if(mat.get(i).get(j)==-1){
	                    dp[i][j]=0;
	                    continue;
	                }
	                if(i==m-1 && j==n-1){
	                    dp[i][j]=1;
	                    continue;
	                }
	                dp[i][j]=(dp[i+1][j]%mod+dp[i][j+1]%mod)%mod;
	            }
	        }
	        return dp[0][0]%mod;
	    }

}
