// Если необходимо, исправьте данный код

// try {
//     int d = 0;
//     double catchedRes1 = intArray[8] / d;
//     System.out.println("catchedRes1 = " + catchedRes1);
//  } catch (ArithmeticException e) {
//     System.out.println("Catching exception: " + e);
//  }

package HW.HW2;

public class Task2 {
    public static void main(String[] args) {
        try {
            int[] intArray = { 1, 20, 5, 4, 11 }; // добавил массив

            int d = 0;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Catching exception: " + e); // добавил исключение
        }
    }
}
