// Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
// и возвращающий новый массив, каждый элемент которого равен разности элементов двух
// входящих массивов в той же ячейке. Если длины массивов не равны, необходимо как-то
// оповестить пользователя.

package HW.HW1;

public class Task2 {
    public static void main(String[] args) {
        int[] arr1 = new int[] { 1, 2, 10 };
        int[] arr2 = new int[] { 5, 2, 5, 10 };

        try {
            int[] newArr = arraySubstr(arr1, arr2);
            for (int i : newArr) {
                System.out.print(i + " ");
            }
        } catch (RuntimeException ex) {
            System.out.println(ex.getLocalizedMessage());
        }

    }

    public static int[] arraySubstr(int[] array1, int[] array2) throws RuntimeException {
        if (array1.length != array2.length)
            throw new RuntimeException("The lengths of arrays do not equal.");
        int[] result = new int[array1.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = array1[i] - array2[i];
        }
        return result;

    }
}
