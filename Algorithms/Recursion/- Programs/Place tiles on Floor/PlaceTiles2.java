// By Shraddha Khapra
public class PlaceTiles2 {

    static int placeTilesOnFloor2(int n, int m){

        if(n==m)
            return 2;
        if(n<m)
            return 1;

        int verticalPlace= placeTilesOnFloor2(n-m, m);

        int horizontalPlace= placeTilesOnFloor2(n-1, m);

        return verticalPlace+horizontalPlace;

    }
    public static void main(String[] args) {
        int n=15, m=4;
        System.out.println(placeTilesOnFloor2(n, m));
    }
}