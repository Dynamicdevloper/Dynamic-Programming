package DynamicProgrammingSolutions;

public class MinimumPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public static int minSumPath(int[][] grid) {
	    	// Write your code here.
	        int n=grid.length;
	        int m=grid[0].length;
	        int[][] dp=new int[n+1][m+1];
	        
	        for(int i=0; i<n+1; i++){
	            dp[i][m]=Integer.MAX_VALUE;
	        }
	        
	        for(int i=0; i<m+1; i++){
	            dp[n][i]=Integer.MAX_VALUE;
	        }
	        
	        dp[n-1][m-1]=grid[n-1][m-1];
	        for(int i=n-1; i>=0; i--){
	            for(int j=m-1; j>=0; j--){
	                if(i==n-1 && j==m-1){
	                    continue;
	                }
	                
	                dp[i][j]=grid[i][j]+Math.min(dp[i+1][j],dp[i][j+1]);
	            }
	        }
	        return dp[0][0];
	    }

}
