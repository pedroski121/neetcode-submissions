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
    Map<Node, Node> nodes = new HashMap<>();
    public Node cloneGraph(Node node) {
        // create a hashmap to keep track of all old nodes
        // return dfs(node)
            // dfs
            // if node is null return 
            // if nodes is in hashmap return the new value 
            // create a new node 
            // set the value 
            // for each value in the neighbor list of old node call dfs(node)
    return dfs(node);
         
    }

    public Node dfs(Node node){
        if(node == null){
            return node;
        }
        if(nodes.containsKey(node)){
            return nodes.get(node);
        }

        Node newNode = new Node(node.val);

        nodes.put(node, newNode);

        for(Node n: node.neighbors){
            newNode.neighbors.add(dfs(n));
        }
        return newNode;
    }
}