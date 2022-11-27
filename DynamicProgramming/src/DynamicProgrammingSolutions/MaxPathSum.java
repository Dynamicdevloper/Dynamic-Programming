package DynamicProgrammingSolutions;

//Problem Link- https://www.codingninjas.com/codestudio/problems/maximum-path-sum-in-the-matrix_797998?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0

public class MaxPathSum {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int getMaxPathSum(int[][] matrix) {
		// Write your code here
//******************Recursion***************************//
//         int max=Integer.MIN_VALUE;
//         for(int i=0; i<matrix[0].length; i++){
//             int ans=getMaxPathS(matrix, 0, i);
//             //System.out.println(ans);
//             max=Math.max(max,ans);
//         }
//         return max;
//*****************************************************//
        int m=matrix.length;
        int n=matrix[0].length;//dynamic
        int dp[][] =new int[m+1][n+1];
        
        
        
        for(int i=0; i<m; i++){
            dp[i][n]=(int)-1e9;
        }
        
        for(int i=0; i<n; i++){
            dp[m][i]=(int)-1e9;
        }
        
        for(int i=0; i<n; i++){
            dp[m-1][i]=matrix[m-1][i];
        }
        int max=(int)-1e8;
        for(int i=m-2; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                int left=matrix[i][j]+(int)-1e8;
                if(j>0)
                    left=matrix[i][j]+dp[i+1][j-1];
                int right=matrix[i][j]+dp[i+1][j+1];
                int down=matrix[i][j]+dp[i+1][j];
                dp[i][j]=Math.max(left,Math.max(right,down));
                
            }
        }
        
        for(int i=0; i<n; i++){
            max=Math.max(max, dp[0][i]);
        }
        return max;
	}
    
    public static int getMaxPathS(int[][] matrix, int i, int j){
        
        if(j<0 || i>=matrix.length || j>=matrix[0].length){
            return (int)-1e9;
        }
        
        if(i==matrix.length-1){
            return matrix[i][j];
        }
        
        int leftD=matrix[i][j]+getMaxPathS(matrix,i+1,j-1);
        int down=matrix[i][j]+getMaxPathS(matrix, i+1, j);
        int rightD=matrix[i][j]+getMaxPathS(matrix,i+1,j+1);
        return Math.max(leftD,Math.max(down,rightD));
        
    }

}
