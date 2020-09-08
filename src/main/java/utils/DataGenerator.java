package utils;

import com.github.javafaker.Faker;

public class DataGenerator {

    Faker faker = new Faker();

    public String generateEmailAddress() {
    return  faker.name().firstName() + "@gmail.com";
    }
}
