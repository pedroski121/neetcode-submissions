/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
   Map<Node, Node> visits = new HashMap<>();

    public Node cloneGraph(Node node) {
        return dfs(node);
    }

    public Node dfs(Node old){
        if(old == null){
            return old;
        }
        if(visits.containsKey(old)){
            return visits.get(old);
        }

        Node newNode = new Node(old.val);

        visits.put(old, newNode);

        for(Node curr:old.neighbors){
            newNode.neighbors.add(dfs(curr));
        }

        return newNode;
    }
}