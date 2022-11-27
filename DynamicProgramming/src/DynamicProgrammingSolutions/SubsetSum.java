package DynamicProgrammingSolutions;

public class SubsetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public static boolean subsetSumToK(int n, int k, int arr[]){
	        // Write your code here.
	        
	        boolean[][] dp=new boolean[n+1][k+1];
	        for(int i=0; i<=k; i++){
	            dp[0][i]=false;
	        }
	        
	        for(int i=0; i<=n; i++){
	            dp[i][0]=true;
	        }
	        
	        for(int i=1; i<=n; i++){
	            for(int j=0; j<=k; j++){
	                if(arr[i-1]<=j){
	                   dp[i][j]=dp[i-1][j-arr[i-1]] || dp[i-1][j]; 
	                }else{
	                    dp[i][j]=dp[i-1][j];
	                }
	            }
	        }
	        return dp[n][k];
	    }
	}
