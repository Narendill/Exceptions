// Реализуйте метод, который запрашивает у пользователя ввод
// дробного числа (типа float), и возвращает введенное значение.
// Ввод текста вместо числа не должно приводить к падению приложения,
// вместо этого, необходимо повторно запросить у пользователя ввод данных.

package HW.HW2;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        float a = getFloat();
        System.out.println("a = " + a);
    }

    public static float getFloat() {
        Scanner sc = new Scanner(System.in);
        boolean end = false;
        float floatNumber = 0;
        System.out.println("Input a float number:");

        while (!end) {
            String numStr = sc.nextLine();
            try {
                floatNumber = Float.parseFloat(numStr);
                end = true;
                return floatNumber;
            } catch (Exception e) {
                System.out.println("Input a FLOAT number!");
            }
        }
        return floatNumber;
    }
}
