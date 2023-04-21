package lecture_4;

public class RedBlackTree {

    private Node root;

    public boolean add(int value){

    }

// Создание новой ноды

    private boolean addNode(Node node, int value){

    }

    // Балансировка
    private Node rebalance(Node node){

    }

// Правосторонний поворот
    private Node rightSwap(Node node){

    }

    // Левосторонний поворот
    private Node leftSwap(Node node){

    }

    // Изменение цвета
    private void colorSwap(Node node){

    }



    
    private class Node{
        private int value;

        private Color color;

        private Node leftChild;

        private Node rightChild;

        @Override
        public String toString(){
            return "Node{" +
                    "value=" + value +
                    ", color=" + color +
                    '}';
        }
    }


    private enum Color{
        RED, BLACK
    }
}
