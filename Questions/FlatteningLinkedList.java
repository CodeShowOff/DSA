public class FlatteningLinkedList {
    // Function to flatten a linked list
    Node flatten(Node root) {
        if(root == null || root.next == null){
            return root;
        }
        Node head = root;
        root = root.next;
        while(root != null){
            head = mergeTwo(head, root);
            root = root.next;
        }
        return head;
    }

    Node mergeTwo(Node head1, Node head2){
        Node crap = new Node(-1);
        Node temp = crap;

        while(head1 != null && head2 != null){
            if(head1.data < head2.data){
                temp.bottom = head1;
                head1 = head1.bottom;
            }else{
                temp.bottom = head2;
                head2 = head2.bottom;
            }
            temp = temp.bottom;
        }

        if(head1 != null){
            temp.bottom = head1;
        }else if(head2 != null){
            temp.bottom = head2;
        }
        return crap.bottom;
    }
}