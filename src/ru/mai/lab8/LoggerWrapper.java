package ru.mai.lab8;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Класс-обертка для логирования
 */
public class LoggerWrapper {
    /**
     *
     */
    private Logger logger;

    /**
     * Конструктор класса
     * @param name
     */
    public LoggerWrapper(String name) {
        logger = getLogger(name);
    }

    /**
     * Создает файл в котором будут записываться логи программы
     * @param name название файла
     * @return объект для логирования
     */
    private Logger getLogger(String name) {
        Logger logger = Logger.getLogger(name);
        try {
            FileHandler fh = new FileHandler(name + ".log");
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            logger.addHandler(fh);

        } catch (SecurityException e) {
            System.out.println("Не удалось создать файл лога" + name + ".log" + " из-за политики безопасности.");
        } catch (IOException e) {
            System.out.println("Не удалось создать файл лога" + name + ".log" + " из-за ошибки ввода-вывода.");
        }

        return logger;
    }

    /**
     * Метод для логирования информации
     * @param warning Уровень предупреждения
     * @param message Сообщение
     */
    public void log(Level warning, String message) {
        logger.log(warning, message);
    }
}
