package utils;

import com.github.javafaker.Faker;
import java.util.Calendar;

public class DataGenerator {

    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();

    public String generateFirstName() {
        return firstName;
    }

    public String generateLastName() {
        return lastName;
    }

    public String generatePhoneNumber() {
        return "+" + faker.phoneNumber();
    }

    public String generateDateOfBirth() {
        int year = faker.number().numberBetween(1900, (Calendar.getInstance().get(Calendar.YEAR) - 18));
        int month = faker.number().numberBetween(1, 12);
        int day = 0;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                day = 31;
                break;

            case 4:
            case 6:
            case 9:
            case 11:
                day = 30;
                break;
        }
        if (month == 2) {

            if (year % 4 != 0 || (year % 100 == 0 && year % 400 != 0)) {
                day = 28;
            } else day = 29;
        }

        return month + "/" + day + "/" + year;

    }
    public String generateEmailAddress() {
        return firstName + "_" + lastName + "@gmail.com";
    }
}

