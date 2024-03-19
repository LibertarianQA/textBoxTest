package pages.components;

import com.github.javafaker.Faker;


import java.util.ArrayList;
import java.util.Collections;

public class TestDataGenerator {

    private static final Faker faker = new Faker();

    public static String generateFirstName() {
        return faker.name().firstName();
    }

    public static String lastName() {
        return faker.name().lastName();
    }

    public static String userEmail() {
        return faker.internet().emailAddress();
    }
    public static String userGander() {
        return faker.options().option("Male", "Female", "Other");
    }
    public static String userPhone() {
        return faker.phoneNumber().subscriberNumber(10);
    }
    public static String currentAddress() {
        return faker.address().fullAddress();
    }
    public static String dayBirthDate() {
        return String.format("%02d", faker.number().numberBetween(1, 28));
    }
    public static String monthBirthDate() {
        return faker.options().option("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
    }

    public static String yearBirthDate() {
        return String.valueOf(faker.number().numberBetween(1950, 2020));
    }
    public static String subjectsInput() {
        return faker.options().option("Economics", "English", "Arts", "History", "Hindi");
    }
    public static String hobbiesWrapper() {

        return faker.options().option("Sports", "Reading", "Music");
    }
    public static String uploadFileFromClasspath() {

        return "img/"+faker.options().option("1.png", "2.jpeg","3.pdf");
    }
    public static String state() {

        return faker.options().option("Uttar Pradesh", "NCR", "Haryana", "Rajasthan");
    }

    public static String setRandomCity(String state){
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
    }
