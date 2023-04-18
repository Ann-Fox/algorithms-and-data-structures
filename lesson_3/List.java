package lesson_3;

// Задание 1
// 1.Реализуем простой односвязный список.
// 2.Пишем только структуру, никаких методов не требуется.
public class List {

    private Node head;


    private class Node {

        private int value;

        private Node next;
    }
// Задание 1

public void print(){
    Node node = head;
    while(node != null){
        System.out.println(node.value + " -> ");
        node = node.next;
    }
}

// Задание 2
public void addFirst(int value){  // 1.Реализуем метод добавления новых элементов в начало списка и удаление первого элемента связного списка.

    Node node = new Node();
    node.value = value;

    if(head != null){
        node.next = head;
    } 
        head = node;
    }

// 2.Односвязный список всегда имеет ссылку на первый элемент последовательности, потому именно с реализации методов для первого элемента последовательности стоит начать
public void removeFirst(){

    if(head != null){
        head = head.next;
    }
}
// Задание 2

// Задание 3 
// 1.Реализуем метод поиска элемента в односвязном списке для проверки наличия элемента внутри списка.
// 2.Для корректной работы со связным список необходимо понимать, как именно можно обходить все значения внутри связного списка.
// 3.Для нашего примера проще всего будет написать метод поиска значения в связном списке и возвращения из метода информации о наличии искомого
// внутри списка.
public boolean find(int value){
    Node currentNode = head;
    while(currentNode != null){
        if(currentNode.value == value) return true;
        currentNode = currentNode.next;
    }
    return false;
}
// Задание 3 


// Задание 4 
// 1.Реализуем метод добавления новых элементов в конец списка и удаление
// последнего элемента связного списка.

public void addLast(int value){
    Node currentNode = new Node();
    currentNode.value = value;
    if(head == null){
        head = currentNode;
    } else {
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }

        last.next = currentNode;

    }
}
// 2.Теперь, когда мы понимаем, как можно искать значения внутри связного
// списка, мы можем сделать методы добавления и удаления элементов в конец
// нашего односвязного списка.
public void removeLast(){
    if(head.next == null){
        head = null;
        return;
    }
    if(head != null){
        Node node = head;
        while(node.next != null){
            if(node.next.next == null){
                node.next = null;
                return;
            }
            node = node.next;
        }
    }
}
// Задание 4 

}
