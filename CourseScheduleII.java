/*
There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

Example 1:

Input: 2, [[1,0]] 
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished   
             course 0. So the correct course order is [0,1] .
Example 2:

Input: 4, [[1,0],[2,0],[3,1],[3,2]]
Output: [0,1,2,3] or [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both     
             courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. 
             So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
Note:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.

*/

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        int[] res=new int[numCourses];
        if(numCourses==0) return res;
        
        HashMap<Integer,ArrayList<Integer>> adj=createAdjacency(numCourses, prerequisites);
    
        boolean[] visited=new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses]; 
        Stack<Integer> stack=new Stack<>();
        
        for(int i=0;i<numCourses;i++){
                boolean cycle=DFSUtil(i, visited,recStack,adj,stack);
                if(cycle) return new int[]{};
        }
        
        int index=0;
        
        while(!stack.isEmpty()){
            res[index++]=stack.pop();
        }
        
        return res;
    }
    
    private boolean DFSUtil(int course, boolean[] visited, boolean[] recStack, HashMap<Integer,ArrayList<Integer>> adj,  Stack<Integer> stack ){
        
        if(recStack[course]) return true;
        
        if(visited[course]) return false;
        
        visited[course]= true;
        recStack[course]=true;
        
        for(int n: adj.get(course)){
                boolean cycle=DFSUtil(n, visited, recStack, adj, stack);
                if(cycle) return true;
        }
        
        recStack[course]=false;
        
        stack.push(course);
        
        return false;
    }
    
    private HashMap<Integer,ArrayList<Integer>> createAdjacency(int numCourses, int[][] prerequisites){
        
        HashMap<Integer,ArrayList<Integer>> adj=new HashMap<>();
        
        for(int i=0;i<numCourses;i++){
            adj.put(i,new ArrayList<Integer>());
        }
        
        for(int i=0;i<prerequisites.length;i++){
            
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        return adj;
    }
}
