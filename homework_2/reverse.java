package homework_2;
// Реализовать метод разворота связного списка (двухсвязного или односвязного на выбор)
public class reverse {
    Node head;

    Node tail;

     // // Разворот связного списка
    // public void revert(){
    //     Node currentNode = head;
    //     while(currentNode != null){
    //         Node next = currentNode.next;
    //         Node previous = currentNode.previous;
    //         currentNode.next = previous;
    //         currentNode.previous = next;
           
    //         if(previous == null){
    //             tail = currentNode;
    //         }
    //         if(next == null){
    //             head = currentNode;
    //         }

    //         currentNode = next;
    //     }

    // }

    


    // Разворот односвязного списка
public void revert(){
    if(head != null && head.next != null){
        Node temp = head;
        revert(head.next, head);
        temp.next = null;
    }
}

    private void revert(Node currentNode, Node previousNode){
        if(currentNode.next == null){
            head = currentNode;
        } else {
            revert(currentNode.next, previousNode);
        }
        currentNode.next = previousNode;
        previousNode.next = null;
    }
       

    public class Node{
        int value;
        Node next;

        Node previous;

    }
}
