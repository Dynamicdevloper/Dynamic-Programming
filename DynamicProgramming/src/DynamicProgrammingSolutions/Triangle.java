package DynamicProgrammingSolutions;

public class Triangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	}
	
	public static int minimumPathSum(int[][] triangle, int n) {
        // Write your code here.
        int dp[][] =new int[n+1][n+1];
        for(int i=0; i<n; i++){
            dp[n-1][i]=triangle[n-1][i];
        }
        
        for(int i=n-2; i>=0; i--){
            for(int j=i; j>=0; j--){
                int d=triangle[i][j]+dp[i+1][j];
                int dg=triangle[i][j]+dp[i+1][j+1];
                dp[i][j]=Math.min(d,dg);
            }
        }
        return dp[0][0];
        //return minPathSum(triangle, 0,0,n-1);
    }
    
    public static int minPathSum(int[][] triangle,int row,int column,int len){
        if(row==len){
            return triangle[row][column];
        }
        
        return triangle[row][column]+Math.min(minPathSum(triangle,row+1,column,len),minPathSum(triangle, row+1, column+1,len));
    }

}
