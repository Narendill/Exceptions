// * Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
// и возвращающий новый массив, каждый элемент которого равен частному элементов двух
// входящих массивов в той же ячейке. Если длины массивов не равны, необходимо как-то
// оповестить пользователя. Важно: При выполнении метода единственное исключение,
// которое пользователь может увидеть - RuntimeException, т.е. ваше.

package HW.HW1;

public class Task3 {
    public static void main(String[] args) {
        int[] arr1 = new int[] { 10, 2, 10, 20 };
        int[] arr2 = new int[] { 3, 2, 6, 0 };

        try {
            float[] newArr = arrayDivision(arr1, arr2);
            for (float i : newArr) {
                System.out.print(i + " ");
            }
        } catch (RuntimeException ex) {
            System.out.println(ex.getLocalizedMessage());
        }

    }

    public static float[] arrayDivision(int[] array1, int[] array2) throws RuntimeException {
        if (array1.length != array2.length)
            throw new RuntimeException("The lengths of arrays do not equal.");
        
            float[] result = new float[array1.length];
        for (int i = 0; i < result.length; i++) {
            if(array2[i] == 0) throw new RuntimeException("There in 0 in 2nd array. I can\'t devide.");
            float a = (float)array1[i]  / array2[i];
            result[i] = a;
        }
        return result;

    }
}
