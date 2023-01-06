package HW.HWFinal;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class FinalHW {
    public static void main(String[] args) {

        try {
            String[] newArray = getData();
            String[] itog = parsData(newArray);
            for (int i = 0; i < itog.length; i++) {
                System.out.print(itog[i] + " ");
            }
            try (FileWriter writer = new FileWriter(itog[0] + ".txt", true)) {
                for (int j = 0; j < itog.length; j++) {
                    writer.write("<" + itog[j] + ">");
                }
                writer.append('\n');
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (RuntimeException e) {
            System.out.println(e.getLocalizedMessage());
        }

    }

    // Метод запрашивает пользовательский ввод и проверяет корректность
    // ввода по количеству значений.
    public static String[] getData() throws RuntimeException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input your Last Name, First Name, Father\'s Name, Day of Birth, Phone number and Gender:");
        String input = sc.nextLine();
        String[] array = input.split(" ");
        if (array.length < 6)
            throw new RuntimeException("You entered LESS information than required.");
        if (array.length > 6)
            throw new RuntimeException("You entered MORE information than required.");

        return array;

    }

    // Предполагаем, что Фамилию, Имя и Отчество все таки пользователь ввел в нужном
    // порядке, иначе если он ввел, например, Имя-Фамилия-Отчество - невозможно понять что есть что.
    // Индексация в списке result: 0 - Фамилия, 1 - Имя, 2 - Отчетство, 3 - Дата рождения, 4 - Телефон, 5 - Пол.
    public static String[] parsData(String[] array) throws RuntimeException {
        String[] result = new String[array.length];
        String patternForDate = "(\\d{2})([.])(\\d{2})([.])(\\d{4})";
        String patternForFIO = "([a-zA-zа-яА-Я]{1,})";
        String patternForPhone = "(\\d{11})"; // пусть будет российский номер строго с 11 цифрами

        for (int i = 0; i < array.length; i++) {
            if (array[i].toLowerCase().equals("m") || array[i].toLowerCase().equals("f")) {
                result[5] = array[i].toLowerCase();
            }
            if (Pattern.matches(patternForDate, array[i])) {
                result[3] = array[i];
            }
            // Хочется верить, что нет фамилий, имет и отчеств, состоящих из одной единственной
            // буквы "m" или "f" :)
            if ((i <= array.length - 3) && Pattern.matches(patternForFIO, array[i])
                    && Pattern.matches(patternForFIO, array[i + 1]) && Pattern.matches(patternForFIO, array[i + 2])
                    && array[i].toLowerCase() != "f" && array[i].toLowerCase() != "m") { 
                result[0] = array[i];
                result[1] = array[i + 1];
                result[2] = array[i + 2];
            }
            if (Pattern.matches(patternForPhone, array[i])) {
                result[4] = array[i];
            }

        }
        if (result[0] == null || result[1] == null || result[2] == null)
            throw new RuntimeException("You entered an invalid Personal Data.");
        if (result[3] == null)
            throw new RuntimeException("You entered an invalid Day of Birth. The correct format: dd.mm.yyy");
        if (result[4] == null)
            throw new RuntimeException("You entered an invalid Phone number (you had to enter 11 digits).");
        if (result[5] == null)
            throw new RuntimeException("You entered an invalid Gender (it can be M/m or F/f).");

        return result;
    }

}
