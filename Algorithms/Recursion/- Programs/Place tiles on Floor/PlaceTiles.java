// By me
public class PlaceTiles {
    static int placeTilesOnFloor(int m, int n, int capacity){
        // The below code will give correct answer but to reduce time complexity, we'll add two more base cases:
        // 1:
        if(m==n)
            return 2;
        // 2:
        if(m>n)
            return 1;

        // Main Base case;
        if(capacity==n)
            return 1;

        int horizontal=0;
        int vertical=0;

        if((capacity+1)<=n)
            horizontal=placeTilesOnFloor(m, n, capacity+1);

        if((capacity+m)<=n)
            vertical=placeTilesOnFloor(m, n, capacity+m);

        return horizontal+vertical;

    }

    public static void main(String[] args) {
        int n=5, m=4;
        // Tile size: 1*m
        int result= placeTilesOnFloor(m, n, 0);
        System.out.println(result);
    }
}
