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
        String dateOfBirth = faker.date().birthday().toString();

        System.out.println(dateOfBirth);

        String i =faker.options().option( "English", "Arts", "History", "Hindi");
        System.out.println(i);


        String randomString = faker.regexify("[a-zA-Z0-9`'!@#$%^&*()_+-=<>?.,{}|\\[\\]~;:]{28}");
        System.out.println("Случайная строка: " + randomString);

        String randomDigits = faker.regexify("[1-28]{28}");
        System.out.println("Случайная строка: " + randomDigits);

        int randomYear = faker.number().numberBetween(1900, 2028);
        System.out.println("Случайный год: " + randomYear);
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
