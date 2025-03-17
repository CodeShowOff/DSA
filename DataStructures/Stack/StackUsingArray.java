public class StackUsingArray {

    static class Stack{
        int top;
        int[] stackArr;

        public Stack(){
            this.top = -1;
            this.stackArr = new int[100]; // max size = 100
        }

        public void push(int num){
            this.stackArr[++top] = num;
        }

        public int pop(){
            if(top == -1){
                throw new IndexOutOfBoundsException();
            }
            return this.stackArr[top--];
        }

        public int top(){
            if(top == -1){
                throw new IndexOutOfBoundsException();
            }
            return this.stackArr[top];
        }

        public int size(){
            return this.top + 1;
        }
    }

    public static void main(String[] args) {
        Stack obj = new Stack();
        obj.push(10);
        obj.push(11);
        obj.push(12);
        System.out.println(obj.pop());
        System.out.println(obj.size());
    }
}