package DynamicProgrammingSolutions;

import java.util.*;

public class PartitionSubsetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean canPartition(int[] arr, int n) {
		// Write your code here.
        int sum=0;
        
        for(int i=0; i<n; i++) sum+=arr[i];
        
        if(sum % 2 != 0) return false;
        
        int k=sum/2;
        
        boolean[][] dp=new boolean[n+1][k+1];
        
        for(boolean[] row: dp) Arrays.fill(row,false);
        
        for(int i=0; i<=n; i++) dp[i][0]=true;
        
        for(int i=1; i<n; i++){
            for(int j=1; j<=k; j++){
                boolean notTake=dp[i-1][j];
                boolean take=false;
                if(arr[i]<=j) take=dp[i-1][j-arr[i]];
                
                dp[i][j]=take || notTake;
            }
        }
   
        return dp[n-1][k];
	}
    
    public static boolean subSetSum(int[] arr, int n, int sum,int[][] dp){
        
        if(sum==0) return true;
        if(n==0) return arr[0]==sum;
        
        if(dp[n][sum]!=-1) return true;
        boolean take=false;
        
        if(arr[n]<=sum) take= subSetSum(arr, n-1, sum-arr[n],dp);
        boolean notTake=subSetSum(arr, n-1, sum,dp);
        
        if(take || notTake) dp[n][sum]=0;
        return take || notTake;
    }

}
