package homework_1;

public class piramida_sort {
    public static void main(int[] array) {
        //Построение кучи (перегруппировка массива)
        for (int i = array.length / 2 - 1; i >=0;i--)
            heapify(array, i, i);

        //Один за другим извлекаем элементы из кучи
        for(int i = array.length - 1; i >= 0; i--) {
            //Перемещаем текущий корень в конец
            int temp = array[0];
            array[0] = array[1];
            array[i] = temp;

            //Вызываем  процедуре heapify нв уменьшенной куче
            heapify(array, i, i);
        }           
        
    }


private static void heapify(int[] array, int heapSize, int rootIndex) {
    int largest = rootIndex; //инициализируем наибольший элемент как корень
    int leftChild = 2 * rootIndex + 1; //левый = 2*rootIndex + 1
    int rightChild = 2 * rootIndex + 2; //правый = 2*rootIndex + 2

//Если левый дочерний элемент больше корня
if (leftChild < heapSize && array[leftChild] > array[largest])
    largest = leftChild;

//Если правый дочерний элемент больше, чем самый большой элемент на данный момент
    if (rightChild < heapSize && array[rightChild] > array[largest])
        largest = rightChild;

//Если самый большой элемент не корень
    if(largest != rootIndex){
        int temp = array[rootIndex];
        array[rootIndex] = array[largest];
        array[largest] = temp;

         //Рекурсивно преобразуем в двоичную кучу затронутое дерево
         heapify(array, heapSize, rootIndex);       
    }        
}
}