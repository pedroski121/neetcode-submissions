class Solution {

    int count = 0;
    Map<Integer, Boolean> visited = new HashMap<>();


    public int countComponents(int n, int[][] edges) {


        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
            visited.put(i, false);
        }

        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int res = 0;
        for(int i = 0; i<n; i++){
            if(!visited.get(i)){
                dfs(i, -1, adj);
                res++;
            }
        }
        return res;



    }

    public void dfs(int curr, int parent, List<List<Integer>> adj){

        if(visited.get(curr)){
            return;
        }

        visited.put(curr, true);

        for(Integer node: adj.get(curr)){
            if(node == parent){
                continue;
            }
            dfs(node, curr, adj);
        }

    }
}
