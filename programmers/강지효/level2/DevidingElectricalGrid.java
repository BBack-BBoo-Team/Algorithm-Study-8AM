package programmers.강지효.level2;


import java.util.LinkedList;
import java.util.Stack;

//전력망 나누기
public class DevidingElectricalGrid {
    public static void main(String[] args) {
        int n = 4;
        int[][] wires = new int[][]{{1,2}, {2,3}, {3,4}};

        int min = n;
        int cnt = 0;
        Graph g ;
        for(int i = 0; i < wires.length;i++){
            g = new Graph(n+1);
            for(int j =0;j <wires.length;j++){
                if(j != i){
                    g.addEdge(wires[j][0],wires[j][1]);
                }
            }
            cnt = g.dfs(1);
            min = Math.min(min, Math.abs((n -cnt) - cnt));
        }

        System.out.println(min);


    }
}

class Graph{
    class Node{
        int data;
        LinkedList<Node> adjacent;
        boolean marked;
        Node (int data){
            this.data =data;
            this.marked = false;
            adjacent = new LinkedList<Node>();
        }
    }
    Node[] nodes;
    Graph(int size){
        nodes = new Node[size+1];
        for(int i = 0; i < size+1; i++){
            nodes[i] = new Node(i);
        }
    }

    void addEdge(int i1, int i2){
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];
        if(!n1.adjacent.contains(n2)){
            n1.adjacent.add(n2);
        }
        if(!n2.adjacent.contains(n1)){
            n2.adjacent.add(n1);
        }
    }

//    void dfs(){
//        dfs(0);
//    }
    int dfs(int index){
        Node root = nodes[index];
        Stack<Node> stack = new Stack<Node>();
        int cnt = 0;
        stack.push(root);
        root.marked = true;
        while (!stack.isEmpty()){
            cnt++;
            Node r = stack.pop();
            for(Node n : r.adjacent){
                if(n.marked == false){
                    n.marked=true;
                    stack.push(n);
                }
            }
//            visit(r);
        }
        return cnt;
    }

//    void bfs(){
//        bfs(1);
//    }
//
//    void bfs(int index){
//        Node root = nodes[index];
//        Queue<Node> queue = new LinkedList<>();
//        queue.add(root);
//        root.marked = true;
//        while(!queue.isEmpty()){
//            Node r = queue.poll();
//            for(Node n : r.adjacent){
//                if(n.marked == false){
//                    n.marked = true;
//                    queue.add(n);
//                }
//            }
//            visit(r);
//        }
//
//    }
//
//    void visit(Node n){
//        System.out.println(n.data + " ");
//    }

}
