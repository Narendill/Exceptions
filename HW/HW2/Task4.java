// Разработайте программу, которая выбросит Exception, когда пользователь
// вводит пустую строку. Пользователю должно показаться сообщение,
// что пустые строки вводить нельзя.

package HW.HW2;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        getMessage();

    }

    public static void getMessage() throws RuntimeException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input something:");
        String input = sc.nextLine();
        if (input.length() == 0) {
            throw new RuntimeException("You can\'t input nothing!");
        }
        System.out.println("Your input: " + input);
    }

}
