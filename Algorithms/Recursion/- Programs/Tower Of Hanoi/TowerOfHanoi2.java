public class TowerOfHanoi2 {

    static void TowerOfHanoi(int num, char Source, char Helper, char Designation){
        // Base condition: move the last(largest) disk from source to designation
        if(num==1){
            System.out.println(Source+" -> "+Designation);
            return;
        }

        // First move n-1 disks from source to helper taking designation tower as helper, 
        // leaving the last largest disk in source only
        TowerOfHanoi(num-1, Source, Designation, Helper);

        // Then move the last(largest) disk from source to designation (this will go to the base case)
        TowerOfHanoi(1, Source, Helper, Designation);

        // Then again move those n-1 disk from helper to designation, 
        // (here helper will work as source and source as helper to move disks to designation)
        TowerOfHanoi(num-1, Helper, Source, Designation);
    }
    public static void main(String[] args) {
        TowerOfHanoi(3, 'A', 'B', 'C');
    }
}
/*

My Logic:Agar hum last wala ko chor kar sara disk helper tower me pahucha de to directly hum wo last wala
         utha ke designation tower me rakh denge(yhi base case hoga). Isi tarika se ab humare paas source me kuch nhi hai aur sara 
         helper tower me hai, ab hum helper tower ko main source tower bana denge aur source tower ko helper bana
         denge i.e. dono ko replace kar denge ek dusre se. Ab hum same apply karenge iske saath bhi, ab iska
         last wala ko chor kar sara helper tower me rakh denge aur last wala utha kr direct designation me...
         aur ye aise hi chalta rahega. Isi ko recursion aaram se solve kar dega.


ChatGPT:
Logic Breakdown:
Recursive Approach: The Tower of Hanoi problem is inherently recursive. 
The main idea is to move n-1 disks from the source rod to the auxiliary rod, 
then move the nth disk (the largest one) directly to the destination rod, 
and finally move the n-1 disks from the auxiliary rod to the destination rod.

Base Case: When there is only one disk (n == 1), it's straightforward:
Directly move the disk from the source rod to the destination rod.

Recursive Step: For n > 1:
Move n-1 disks from the source rod to the auxiliary rod using the destination rod as an auxiliary.
Move the nth disk (the largest one) from the source rod to the destination rod.
Move n-1 disks from the auxiliary rod to the destination rod using the source rod as an auxiliary.

Visualization: Imagine you have three rods (A, B, C) and you want to move 3 disks from rod A to rod C:
Step 1: Move 2 disks (n-1) from A to B using C.
Step 2: Move the largest disk (nth) from A to C.
Step 3: Move the 2 disks (n-1) from B to C using A.
This recursive pattern continues until all disks are moved from rod A to rod C.

Why This Logic is Used:
Efficiency: The recursive approach elegantly reduces the problem of moving n disks to moving n-1 disks, 
which in turn reduces to moving n-2 disks, and so on, until the base case of moving a single disk is reached. 
This significantly reduces the complexity of the problem.

Correctness: The logic ensures that no larger disk is ever placed on top of a smaller disk, 
which adheres to the rules of the Tower of Hanoi puzzle.
*/