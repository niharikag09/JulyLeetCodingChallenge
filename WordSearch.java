/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
 

Constraints:

board and word consists only of lowercase and uppercase English letters.
1 <= board.length <= 200
1 <= board[i].length <= 200
1 <= word.length <= 10^3
*/

class Solution {
    public boolean exist(char[][] board, String word) {
        
        int row=board.length;
        int col=board[0].length;
        
        //find starting character for the word in the grid and call DFS on that position
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]==word.charAt(0)){
                    boolean[][] visited=new boolean[row][col];
                    boolean found=findWord(i,j,board,visited, 0, word);
                    if(found) return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean findWord(int i, int j, char[][] board, boolean[][] visited, int currIndex, String word){
        
        if(currIndex==word.length()) return true;
        
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || visited[i][j]) return false;
        
        if(board[i][j]!=word.charAt(currIndex)) return false;
            
        visited[i][j]=true;

        boolean found= findWord(i-1,j,board, visited, currIndex+1,word)
            || findWord(i,j+1,board, visited, currIndex+1,word)
            || findWord(i+1,j,board, visited, currIndex+1,word)
            || findWord(i,j-1,board, visited, currIndex+1,word);

        if(!found) visited[i][j]=false;

        return found;
        
    }
}
