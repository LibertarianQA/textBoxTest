package demoqa.examples;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;

public class FakerExamples {
    public static void main(String[] args) {
        Faker faker = new Faker();

        // Генерация фейковой даты рождения
        Date dateOfBirth = faker.date().birthday();
        LocalDate localDateOfBirth = dateOfBirth.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        // Получение года, месяца и дня
        int year = localDateOfBirth.getYear();
        Month month = localDateOfBirth.getMonth();
        int day = localDateOfBirth.getDayOfMonth();
        String monthName = month.toString();  // То же, что и name(), возвращает название месяца в виде строки
        System.out.println("Month: " + monthName);
        // Вывод результата
        System.out.println("Year: " + year);
        System.out.println("Month: " + month);  // Получаем название месяца
        System.out.println("Day: " + day);
    }
}
