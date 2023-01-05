// Реализуйте 3 метода, чтобы в каждом из них получить разные исключения
// Посмотрите на код, и подумайте сколько разных типов исключений вы тут сможете получить?

package HW.HW1;

import java.util.Scanner;

import javax.management.RuntimeErrorException;

public class Task1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Input an integer number: ");
        int num = sc.nextInt();
        int[] newArray1 = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int[] newArray2 = new int[] { -1, -2, -3, -4, -5, -6, -7 };

        System.out.println("------======RESULTS======------");

        try {
            getLog(num);
        } catch (RuntimeException ex) {
            System.out.println(ex.getLocalizedMessage());
        }

        try {
            getFactorial(num);
        } catch (RuntimeException ex) {
            System.out.println(ex.getLocalizedMessage());
        }

        try {
            getArray(newArray1, newArray2, num);
        } catch (RuntimeException ex) {
            System.out.println(ex.getLocalizedMessage());
        }

    }

    // Метод №1. Отрицательные числа и ноль логарифма не имеют.
    // Для простоты будем принимать интовые значения (как вариант можно
    // было бы обработать исключение ввода неинтового значения).
    public static void getLog(int n) throws RuntimeException {
        if (n <= 0)
            throw new RuntimeException("Log(" + n + ")" + " doesn\'t exist.");
        System.out.println("log(" + n + ") = " + Math.log(n));
    }

    // Метод №2. Вычисление логарифма.
    // Для слишком больших и отрицательных числел будем выводить исключения.
    public static void getFactorial(int n) throws RuntimeException {
        if (n > 15)
            throw new RuntimeException(n + "! is too large. Try another number.");
        if (n < 0)
            throw new RuntimeException(n + "! doesn\'t exist.");
        int result = 1;
        for (int i = 1; i < n; i++) {
            result *= i;
        }
        System.out.println(n + "! = " + result);
    }

    // Метод №3. Извлечение из двух массивов значений согласно введенному индексу.
    public static void getArray(int[] array1, int[] array2, int index) throws RuntimeErrorException {
        if ((index >= array1.length) || (index >= array2.length) || index < 0)
            throw new RuntimeException("Index is out of range.");
        System.out.println("(" + array1[index] + "; " + array2[index] + ")");
    }

}
