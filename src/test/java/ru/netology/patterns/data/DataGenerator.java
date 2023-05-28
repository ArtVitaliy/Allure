package ru.netology.patterns.data;


import com.github.javafaker.Faker;
import lombok.Data;
import lombok.Value;
import lombok.val;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

@Data

    public class DataGenerator {
        private DataGenerator() {
        }

        public static String generateDate(int shift) {
            LocalDate today = LocalDate.now();
            LocalDate method = today.plusDays(shift);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            return method.format(formatter);

            // TODO: добавить логику для объявления переменной date и задания её значения, для генерации строки с датой
            // Вы можете использовать класс LocalDate и его методы для получения и форматирования даты
//            return date;
        }

        public static String generateCity() {
            var cities = new String[] {"Москва", "Краснодар", "Чебоксары", "Астрахань", "Смоленск", "Барнаул", "Ярославль", "Новосибирск", "Самара",
                    "Севастополь", "Кострома", "Тамбов", "Красноярск"};
            return cities[new Random().nextInt(cities.length)];


            // TODO: добавить логику для объявления переменной city и задания её значения, генерацию можно выполнить
            // с помощью Faker, либо используя массив валидных городов и класс Random
//            return city;
        }

        public static String generateName(String locale) {
            Faker faker = new Faker(new Locale(locale));
                    String name = faker.name().lastName() + " " + faker.name().firstName();
                    return name;
            // TODO: добавить логику для объявления переменной name и задания её значения, для генерации можно
            // использовать Faker
//            return name;
        }

        public static String generatePhone(String locale) {
            Faker faker = new Faker(new Locale(locale));
                   String phone = faker.phoneNumber().phoneNumber();
                   return phone;

            // TODO: добавить логику для объявления переменной phone и задания её значения, для генерации можно
            // использовать Faker
//            return phone;
        }

        @Data

        public static class Registration {
            private Registration() {
            }

            public static UserInfo generateUser(String locale) {
                return new UserInfo(generateCity(), generateName(locale), generatePhone(locale));
                // TODO: добавить логику для создания пользователя user с использованием методов generateCity(locale),

            }
        }

        @Value
        public static class UserInfo {
            String city;
            String name;
            String phone;
        }
    }

