/*
Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1, and return them in any order.

The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  graph[i] is a list of all nodes j for which the edge (i, j) exists.

Example:
Input: [[1,2], [3], [3], []] 
Output: [[0,1,3],[0,2,3]] 
Explanation: The graph looks like this:
0--->1
|    |
v    v
2--->3
There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
Note:

The number of nodes in the graph will be in the range [2, 15].
You can print different paths in any order, but you should keep the order of nodes inside one path.
*/

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        List<List<Integer>> paths=new ArrayList<>();
        
        ArrayList<Integer> path=new ArrayList<>();
        
        path.add(0);
        
        dfsUtil(0,graph.length-1,graph,paths,path);
        
        return paths;
        
    }
    
    private void dfsUtil(int source, int destination, int[][] graph, List<List<Integer>> paths, ArrayList<Integer> path){
                    
        if(source==destination) {
            paths.add(new ArrayList<>(path));
            return;
        }
       
        for(int node: graph[source]){
            path.add(node);
            dfsUtil(node, destination, graph, paths, path); 
            path.remove(path.size()-1);
        }
        
    }
}
