package lesson_4_RedBlackTree;


public class RBTree<T extends Comparable<T>> {
    private Node root;

    /**
     * Обработка рутовой ноды
     * Если рутовая нода уже существует, то мы создаем новую ноду относительно рута,
     * обязательно сам рут тоже балансируем и назначаем руту черный цвет
     *
     * Если рутового элемента нет, генерируем его и назначаем ему черный цвет
     * (это единственная ситуация, когда мы создаем новую ноду и она НЕ красная)
     */
    public boolean add(T value) {
        if (root != null) {
            boolean result = addNode(root, value);
            root = rebalance(root);
            root.color = Color.BLACK;
            return result;
        } else {
            root = new Node();
            root.color = Color.BLACK;
            root.value = value;
            return true;
        }
    }

    // печать дерева
    public void printTree() {
        if (root != null) {
            root.printNode(1, "Root");
        }
    }

     /**
     * Добавление новой ноды
     * Значения ноды уникальны. Не получится создать 2 с одинаковыми значениями
     *
     * Если значение ноды больше искомого значения, при этом левый ребенок существует, запускаем
     * рекурсивный поиск в глубину по левому ребенку на предмет можно ли создать новую ноду там
     *
     * Если левой ноды не существует, считаем что подходящее место для создания новой ноды найдено, присваиваем ей красный цвет
     *
     * Если правого ребенка нет, то генерируем значение.
     * Если правый ребенок на месте, запускаем рекурсивный поиск в глубину по правому ребенку на предмет создания там новой ноды
     */
    private boolean addNode(Node node, T value) {
        if (node.value == value) {
            return false;
        } else {
            if (node.value.compareTo(value) > 0) {
                if (node.left != null) {
                    boolean result = addNode(node.left, value);
                    node.left = rebalance(node.left);
                    return result;
                } else {
                    node.left = new Node();
                    node.left.color = Color.RED;
                    node.left.value = value;
                    return true;
                }
            } else {
                if (node.rigth != null) {
                    boolean result = addNode(node.rigth, value);
                    node.rigth = rebalance(node.rigth);
                    return result;
                } else {
                    node.rigth = new Node();
                    node.rigth.color = Color.RED;
                    node.rigth.value = value;
                    return true;
                }
            }
        }
    }

    /**
     * Ребалансировка
     * Если есть правый ребенок красного цвета, при этом левый ребенок черного цвета,
     * тогда мы производим правый поворот и говорим, что балансировка д.б. выполнена ещё раз;
     *
     * Если есть левый ребенок красного цвета, при этом у него есть
     * свой левый ребенок красного цвета, тогда мы производим левый поворот;
     *
     * Если и правый и левый дети имеют красный цвет, мы выполняем colorSwap.
     *
     * Как только условия перестанут выполняться, выйдем из цикла и получим результат
     */
    private Node rebalance(Node node) {
        Node result = node;
        boolean needRebalance;
        do {
            needRebalance = false;
            if (result.rigth != null && result.rigth.color == Color.RED &&
                    (result.left == null || result.left.color == Color.BLACK)) {
                needRebalance = true;
                result = rightSwap(result);
            }
            if (result.left != null && result.left.color == Color.RED &&
                    result.left.left != null && result.left.left.color == Color.RED) {
                needRebalance = true;
                result = leftSwap(result);
            }
            if (result.left != null && result.left.color == Color.RED &&
                    result.rigth != null && result.rigth.color == Color.RED) {
                needRebalance = true;
                colorSwap(result);
            }
        } while (needRebalance);

        return result;
    }

    // правый малый разворот
    private Node rightSwap(Node node) {
        Node rightChild = node.rigth;
        Node betweenChild = rightChild.left;
        rightChild.left = node;
        node.rigth = betweenChild;
        rightChild.color = node.color;
        node.color = Color.RED;
        return rightChild;
    }

    // левый малый разворот
    private Node leftSwap(Node node) {
        Node leftChild = node.left;
        Node betweenChild = leftChild.rigth;
        leftChild.rigth = node;
        node.left = betweenChild;
        leftChild.color = node.color;
        node.color = Color.RED;
        return leftChild;
    }

      /**
     * Смена цвета
     * Если нужно произвести смену цвета указанной ноды, мы присваиваем её детям
     * (левому и правому) чёрные цвета, а сама нода становится красной
     * Ситуация возможна только когда у ноды два красных ребенка
     */
    private void colorSwap(Node node) {
        node.rigth.color = Color.BLACK;
        node.left.color = Color.BLACK;
        node.color = Color.RED;
    }

    private class Node {
        private T value;
        private Color color;

        private Node left;
        private Node rigth;

        // печать Node о самой себе информацию
        public void printNode(int level, String typeBranch) {
            String text = typeBranch + " Value = " + value.toString() + " Color = " + color.toString();
            int padCount = level;
            if (level > 1) {
                padCount = level + 5; // уровень отступа для визуализации ветвей
            }
            text = padLeft(text, padCount);
            System.out.println(text);

            printChild(level + 1); // уровень дерева
        }

        // печать информация о детях + информация какая ветка
        public void printChild(int level) {
            if (rigth != null) {
                rigth.printNode(level, "Right");
            }
            if (left != null) {
                left.printNode(level, "Left");
            }
        }

        // отступы слева
        public static String padLeft(String s, int n) {
            n = n + s.length();
            return String.format("%" + n + "s", s);
        }
    }

    private enum Color {
        RED, BLACK;
    }
}
