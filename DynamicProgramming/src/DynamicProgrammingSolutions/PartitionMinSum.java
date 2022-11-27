package DynamicProgrammingSolutions;

public class PartitionMinSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int minSubsetSumDifference(int[] arr, int n) {
		// Write your code here.
        
        int sum=0;
        for(int a: arr) sum+=a;
        boolean[][] dp=new boolean[n+1][sum+1];
        
        for(int j=0; j<=sum; j++) dp[0][j]=false;
        for(int i=0; i<=n; i++) dp[i][0]=true;
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=sum; j++){
                boolean notTake=dp[i-1][j];
                boolean take =false;
                if(arr[i-1]<=j) take=dp[i-1][j-arr[i-1]];
                dp[i][j]=take | notTake;
            }
        }
        int min=(int)1e9;
        for(int j=0; j<=sum/2; j++){
            if(dp[n][j]){
                min=Math.min(min, Math.abs((sum-j)-j));
            }
        }
        return min;
	}

}
