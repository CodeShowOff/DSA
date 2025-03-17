import java.util.ArrayList;

public class findAllSubsets {

    static void findSubsets(int n, ArrayList<Integer> subsets){

        if(n==0){
            printSubset(subsets);
            return;
        }
        // add hoga
        subsets.add(n);
        findSubsets(n-1, subsets);

        // add nhi hoga
        subsets.remove(subsets.size()-1);
        findSubsets(n-1, subsets);
    }

    static void printSubset(ArrayList<Integer> subsets){
        for (int i = 0; i < subsets.size(); i++) {
            System.out.print(subsets.get(i)+" ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int n=3;
        findSubsets(n, new ArrayList<>());
    }
}
