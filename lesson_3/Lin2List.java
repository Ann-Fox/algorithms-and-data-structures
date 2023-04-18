package lesson_3;
// Задание 5 
// 1.Расширяем структуру связного списка до двухсвязного.
// 2.Мы научились работать с односвязным список, теперь можно ближе
// познакомиться со структурой двухсвязного списка и особенностей его
// внутреннего строения.
// 3.Стоит напомнить, что двухсвязный список представляет из себя цепочку
// элементов, которые умеют ссылаться не только на следующий элемент
// последовательности, но и на предыдущий.
// 4.Вносить корректировки в уже готовые методы на текущий момент не стоит, их
// модификацией мы займемся позднее
public class Lin2List {
    private Node head;
    private Node tail;

    private class Node {
        private int value;

        private Node next;
        private Node previous;
    }

    public void print(){
        Node node = head;
        while(node != null){
            System.out.println(node.value + " -> ");
            node = node.next;
        }
        // System.out.println(tail.value);
    }
    
    // Задание 6 
    // 1.Обновляем методы согласно новой структуре.
    // 2.Появилась дополнительная переменная, которую необходимо отслеживать во всех операциях.
    // 3.Так же благодаря ссылке на последний элемент списка операции работы с
    // концом стали проще и их стоит заменить на логику аналогичную работе с
    // началом списка
    public void addFirst(int value){  

        Node node = new Node();
        node.value = value;
    
        if(head != null){
            node.next = head;
            head.previous = node;
        } else {
            tail = null;
            head = null;
        }
            head = node;
        }

    public void removeFirst(){
     if(head != null && head.next != null){
        head.next.previous = null;
        head = head.next;
        } else {
            tail = null;
            head = null;
        }
    }   


    public void addLast(int value){
        Node currentNode = new Node();
        currentNode.value = value;
        if(tail != null){
            currentNode.previous = tail;
            tail.next = currentNode;
        } else {
            head = currentNode;
        }
        tail = currentNode;
    }
    
    public void removeLast(){
        if(tail != null && tail.previous != null){
            tail.previous.next = null;
            tail = tail.previous;
        } else {
            head = null;
            tail = null;
        }
       
        }
}
