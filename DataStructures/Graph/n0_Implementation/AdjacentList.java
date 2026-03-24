package n0_Implementation;

import java.util.*;

public class AdjacentList {

    ArrayList<Integer>[] array;
    AdjacentList(int val){
        array = new ArrayList[val];
        for(int i = 0; i < val; i++){
            array[i] = new ArrayList<>();
        }
    }

    public void addEdge(int u, int v){
        array[u].add(v);
        array[v].add(u);
    }

    public void print(){
        int i = 0;
        for(ArrayList<Integer> arrayList: array){
            System.out.println(i + " -> " + arrayList);
            i++;
        }
    }

    public static void main(String[] args){

        // Way 1:
//        ArrayList<Integer>[] array = new ArrayList[5];
//
//        array[0] = new ArrayList<>();
//        array[0].add(1);
//        array[0].add(2);
//        array[0].add(3);
//
//        array[1] = new ArrayList<>();
//        array[1].add(0);
//        array[1].add(3);

        AdjacentList graph = new AdjacentList(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(3, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(2, 4);

        graph.print();

        // Way 2:
        Map<Integer, List<Integer>> graph2 = new HashMap<>();
        graph2.put(0, new ArrayList<>());
        graph2.get(0).add(10);
        graph2.get(0).add(32);

        graph2.put(1, new ArrayList<>());
        graph2.get(1).add(2);
        graph2.get(1).add(0);

        System.out.println(graph2);
    }

    private static class Edge{
        int u;
        int v;
        int w;
    }
    
}
