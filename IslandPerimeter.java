/*
ou are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

 

Example:

Input:
[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Output: 16

Explanation: The perimeter is the 16 yellow stripes in the image below:
*/
class Solution {
    public int islandPerimeter(int[][] grid) {
        
        int row=grid.length;
        if(row==0) return 0;
        int col=grid[0].length;
        
        boolean[][] visited=new boolean[row][col];
        
        for(int i=0;i<row;i++){
            
            for(int j=0;j<col;j++){
                
                if(grid[i][j]==1){
                    return DFSUtil(i,j,grid,visited);
                }
            }
        }
        
        return 0;
    }
    
    private int DFSUtil(int i, int j, int[][] grid, boolean[][] visited){
        
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length) return 1;
        if(grid[i][j]==0) return 1;
        if(visited[i][j]) return 0;
        
        visited[i][j]=true;
        int perimeter=0;
        
        perimeter+=DFSUtil(i+1,j,grid,visited);
        perimeter+=DFSUtil(i-1,j,grid,visited);
        perimeter+=DFSUtil(i,j+1,grid,visited);
        perimeter+=DFSUtil(i,j-1,grid,visited);
        
        return perimeter;
    }
}
