package ru.job4j.cache.menu;

import ru.job4j.cache.DirFileCache;

import java.util.Scanner;

public class Emulator extends DirFileCache {

    private static final int ADD_DIRECTORY = 1;
    private static final int DOWNLOAD_FILE_IN_CACHE = 2;
    private static final int DOWNLOAD_FILE_FROM_CACHE = 3;
    private static final String SELECT = "Выберите меню:";
    private static final String DIRECTORY = "Введите кешируемую директорию:";
    private static final String FILE_NAME = "Введите имя и расширение файла:";
    private static final String EXIT = "Конец работы.";
    private static final String MENU = """
                Введите 1, для ввода кешируемой директории.
                Введите 2, чтобы загрузить содержимое файла в кеш.
                Введите 3, чтобы получить содержимое файла из кеша.
                Введите любое другое число для выхода.
            """;

    public Emulator(String cachingDir) {
        super(cachingDir);
    }

    public static void main(String[] args) {
        Emulator emulator = null;
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println(MENU);
            System.out.println(SELECT);
            int userChoice = Integer.parseInt(scanner.nextLine());
            System.out.println(userChoice);
            if (ADD_DIRECTORY == userChoice) {
                System.out.println(DIRECTORY);
                String text = scanner.nextLine();
                emulator = new Emulator(text);
                System.out.println("Кешируемая директория: " + text);
            } else if (DOWNLOAD_FILE_IN_CACHE == userChoice) {
                System.out.println(FILE_NAME);
                String text = scanner.nextLine();
                emulator.load(text);
                System.out.println("Файл " + text + " загружен в кеш.");
            } else if (DOWNLOAD_FILE_FROM_CACHE == userChoice) {
                System.out.println(FILE_NAME);
                String text = scanner.nextLine();
                String value = emulator.get(text);
                if (value == null) {
                    System.out.println("Файл отсутствует в кеше.");
                } else {
                    System.out.println("Содержимое файла: " + value);
                }
            } else {
                run = false;
                System.out.println(EXIT);
            }
        }
    }
}
