public class TowerOfHanoi {
    public static void towerOfHanoi(int num, String source, String helper, String destination){ 
        if(num==1){
            System.out.println("Transfer disk 1 from "+ source+ " to "+destination);
            return;
        }
        towerOfHanoi(num-1, source, destination, helper);
        System.out.println("Transfer disk "+num+" from "+ source+ " to "+destination) ;
        towerOfHanoi(num-1, helper, source, destination);


    }
    public static void main(String[] args) {
        int num=3;
        towerOfHanoi(num, "source", "helper", "destination");
    }
} 