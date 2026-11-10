class Solution {
    public boolean validTree(int n, int[][] edges) {
        // valid tree -> no cycles and n == nodes
        // graph traversal - dfs/bfs
        // Algorithm:
        /*
            - Create an array mapping each node children. Each index in         the array should represent a node 
            - Utilize a hashset to keep track of the visited nodes
            - perform dfs starting from the first value in the in the     array

            return  dfs if not valid

            return visited == input size


        dfs
            input - current node, prev node, visited, children mapping
                -> return false - current node in visited 
                -> get the children and perform dfs on them 
                -> if curr == parent. Skip the loop
        */

        Set<Integer> visited = new HashSet<>();

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i<n; i++){
            adj.add(i, new ArrayList<>());
        }

        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        if(!dfs(0, -1, visited, adj)){
            return false;
        }

        return visited.size() == n;

    }

    public boolean dfs(int curr, int parent, Set<Integer> visited, List<List<Integer>> adj){
        if(visited.contains(curr)){
            return false;
        }

        visited.add(curr);

        for(int child: adj.get(curr)){
            if(child == parent){
                continue;
            }
            if(!dfs(child, curr, visited, adj)){
                return false;
            }
            
        }

        return true;
    }
}
