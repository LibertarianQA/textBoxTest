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

        /*
        "English", "Arts", "History", "Hindi"
        "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"
        hobbies = setRandomValue("Sports", "Reading", "Music")
         public String setRandomCity (String state){
        String item = null;
        ArrayList<String> values = new ArrayList<>();
        if (state.equals("NCR")){
            Collections.addAll(values,"Delhi", "Gurgaon", "Noida");
            item = values.get(faker.random().nextInt(0,values.size()-1));
        }
        else if (state.equals("Uttar Pradesh")){
            Collections.addAll(values,"Agra", "Lucknow", "Merrut");
            item = values.get(faker.random().nextInt(0,values.size()-1));
        }
        else if (state.equals("Haryana")){
            Collections.addAll(values,"Karnal", "Panipat");
            item = values.get(faker.random().nextInt(0,values.size()-1));
        }
        else if  (state.equals("Rajasthan")){
            Collections.addAll(values,"Jaipur", "Jaiselmer");
            item = values.get(faker.random().nextInt(0,values.size()-1));
        }
        return item;
    }

         */
    }
}
