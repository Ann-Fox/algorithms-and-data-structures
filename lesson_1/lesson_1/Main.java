package lesson_1;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

/*О(N) + O(2) = O(N) + O(1) = O(N + 1) = O(N) */
public class Main 
{
    public static void main(String[] args) {
        /* task1 
 Необходимо написать алгоритм, считающий сумму всех чисел от 1 до N. 
Согласно свойствам линейной сложности, количество итераций цикла будет линейно
изменяться относительно изменения размера N.*/ 
      System.out.println("линейная сложность O(n) / сумма всех чисел " + sum(8) + "\n");  
    
    
    
    /*task 2
 Написать алгоритм поиска простых чисел (делятся только на себя и
на 1) в диапазоне от 1 до N. В алгоритме будет использоваться
вложенный for, что явно говорит о квадратичной сложности, на этом
стоит акцентировать внимание
     */
System.out.println("квадратичная сложность O(n^2)/простые числа " + simpleDigits(10) + "\n");

     /*task 3
1. Необходимо написать алгоритм поиска всех доступных комбинаций
(посчитать количество) для количества кубиков K с количеством граней N.
2. У вас есть 2 варианта на выбор – количество кубиков может быть строго
ограничено (4 кубика, например), либо их количество будет
динамическим. Выбор за вами.
3. Если вы реализуете простой вариант, обращает внимание, что данное
решение имеет сложность O(n4), но если количество кубиков сделать
переменной, то она трансформируется в O(nk
), что будет представлять собой экспоненциальную сложность. Для второго решения очевидно, что
его сложность O(nk
) с самого начала.
      */

    /* Task 4
     * 1. Пишем алгоритм поиска нужного числа последовательности Фибоначчи.
2. Считаем, что 1 и 2 значения последовательности равны 1.
3. Искать будем по формуле On=On-1+On-2 что предполагает использовать
рекурсивного алгоритма.
n
/ \
n-1 n-2 -------- 2^1 операций
/ \ / \
n-2 n-3 n-3 n-4 -------- 2^2 операций
/ \
n-3 n-4 -------- 2^3 операций
........ ........
n-n-1 n-n-2 -------- 2^(n-1) операций
     */

     /*task 5
      * 1.Пишем алгоритм поиска нужного числа последовательности Фибоначчи, но в этот
раз откажемся от рекурсии и воспользуемся обычным алгоритмом, что даст нам
линейную сложность, т.к. вычисление каждого из чисел последовательности будет
происходить ровно 1 раз.
1.Вариантов решения может быть несколько, но нужно предложить студентам
считать последовательность с первого числа и далее до тех пор, пока не доберемся
до нужного номера. При этом значение предыдущих элементов нужно сохранять,
чтобы не приходилось вычислять заново, как это происходило при рекурсивном
методе.
      */

      /*Task 6
       * Необходимо сравнить скорость работы 2 алгоритмов вычисления чисел
Фибоначчи и определить, какой из них работает быстрее. Так различия
начнутся уже с 40 члена последовательности.
       */
      long startTime1 = System.nanoTime();
    //   LocalTime localTime3 = LocalTime.now();
      System.out.println("'экспонентю сложность O(n)/Фиббоначи цикл " + fibFor(40));
      long stopTime1 = System.nanoTime();
    //   LocalTime localTime4 = LocalTime.now();
    //   Duration duration2 = Duration.between(localTime3, localTime4);
      System.out.println(", время выполнения - " + (stopTime1 - startTime1) + '\n');
    }

    System.out.print(dice2(2,6)); //
}


public static int sum(int digit) { //линейная
    int result = 0;
    for(int i=1;i<=digit;i++)
        result += 1;
    return result;
}


public static List <Integer> simpleDigits(int maxDigit) { //квадратичная
List<Integer> result = new ArrayList<>();

    for (int i = 1; i < maxDigit; i++){
    boolean isSimple = true;
    for(int j=2;j<i;j++){
        if (i%j ==0){
            isSimple = false;
            break;
        }
    }
    if(isSimple) result.add(i);
}
return result;

}

//from collection import array;
// boolean[] primes;
// public Main(int n) {
// primes=new boolean[n+1];
// }
// public void fillSieve() {
// Arrays.fill(primes, true);
// primes[0] = false;
// primes[1] = false;
// for (int i = 2; i < primes.length; ++i) {
// if (primes[i]) {
// for (int j = 2; i * j < primes.length; ++j) {
// primes[i * j] = false;
// }
// }
// }
// }

public static int dice(int side){
   int result  = 0;
   for (int i = 1; i <= side; i++){
    for (int j = 1; j <= side; j++){
        for (int k=1; k<= side; k++){
            result++;
        }
    }
   } 
   return result;
}


public static int recursiveCount(int depth, int maxDepth, int side){
    int count = 0;
    for (int = 1; i <= side; i++){
        if(depth == maxDepth) count++;
        else count += recursiveCount(depth+1, maxDepth, side);
    }
    return count;
}

public static int dice2(int k, int n)
{
    if(k<=0) return 0;
    return recursiveCount(1, k, n);
}


public static int fib(int n){
    if (n <= 1) return n;
    return fib(n-2) + fib(n-1);
}

private static int fibFor(int n) {
    int first = 0;
    int second = 1;
    int result = 1;
    for (int i =1; i < n; i++){
        result = first + second;
        first = second;
        second = result;
    }
    return result;
}