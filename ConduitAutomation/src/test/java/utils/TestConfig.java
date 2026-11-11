package utils;

public class TestConfig {

    public static void main(String[] args) {

        ConfigReader config = new ConfigReader();

        System.out.println(config.getProperty("url"));

        System.out.println(config.getProperty("username"));

        System.out.println(config.getProperty("password"));
    }
}
