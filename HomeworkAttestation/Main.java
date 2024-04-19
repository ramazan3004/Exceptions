import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите Фамилию Имя Отчество дата_рождения номер_телефона пол (разделенные пробелом):");
        String input = scanner.nextLine();

        String[] data = input.split(" ");
        if (data.length != 6) {
            System.out.println("Ошибка: недостаточно или слишком много данных, требуется 6 значений");
            return;
        }

        String surname = data[0];
        String name = data[1];
        String patronymic = data[2];
        String birthDate = data[3];
        long phoneNumber;
        String gender = data[5];

        try {
            phoneNumber = Long.parseLong(data[4]);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: номер телефона должен быть целым числом");
            return;
        }

        if (!gender.equals("ж") && !gender.equals("м")) {
            System.out.println("Ошибка: пол должен быть символом 'ж' или 'м'");
            return;
        }

        try {
            FileWriter fileWriter = new FileWriter(surname + ".txt", true);
            fileWriter.write(surname + " " + name + " " + patronymic + " " + birthDate + " " + phoneNumber + " " + gender + "\n");
            fileWriter.close();
            System.out.println("Данные успешно записаны в файл " + surname + ".txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
