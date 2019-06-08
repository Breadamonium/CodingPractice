/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Codec {

    // Encodes a tree to a single string.
    public String serialize(Node root) {
        String answer = "";
        if(root==null) {
            return answer;
        }
        Queue<Node> seen = new LinkedList<Node>();
        seen.add(root);
        while(!seen.isEmpty()){
            int currentSize = seen.size();
            for (int i = 0; i < currentSize; i++) {
                Node current = seen.poll();
                if (current == null) {
                    answer += "|,";
                    continue;
                }
                answer += current.val + " ";
                List<Node> childsOfCurrent = current.children;
                if(childsOfCurrent.size()>0){
                    for(Node child : childsOfCurrent) {
                        seen.add(child);
                    }
                }
                else{
                    seen.add(null);
                }
            }
            answer += ",";
        }
        System.out.println(answer);
        return answer;
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if(data.equals("")) {
            return null;
        }
        String[] eachLevel = data.split(",");
        Queue<Node> seen = new LinkedList<Node>();
        Node root = null;
        if(eachLevel.length>0) {
            root = new Node(Integer.parseInt(eachLevel[0].split(" ")[0]), new ArrayList<Node>());
            seen.add(root);
        }
        for(int j = 1; j < eachLevel.length; j++) {
            String[] separateNode = eachLevel[j].split(" ");
            Node parent = seen.poll();
            if (parent!=null) {
                for(String aNode : separateNode){
                    if(aNode.equals("|")) {
                        seen.add(null);
                    }
                    else{
                        Node child = new Node(Integer.parseInt(aNode), new ArrayList<Node>());
                        seen.add(child);
                        parent.children.add(child);
                    }
                }
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));