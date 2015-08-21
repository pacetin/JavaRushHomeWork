package com.javarush.test.level26.lesson15.big01;


import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {


    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }


    public static String readString() {

        String message = "";

        try {
            message = reader.readLine();


        } catch (IOException e) {
            e.printStackTrace();
        }
        return message;
    }


    public static String askCurrencyCode() {

        String s;
        while (true) {
            writeMessage("Введите код валюты: ");
            s = readString();
            if (s.length() != 3) {
                writeMessage("Data incorrect. Retry");
            }
            else {
                s = s.toUpperCase();
                break;

            }

        }
        return s;
    }


    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {

        String[] array;
        writeMessage("Введите номинал и кол-во банкнот: ");

        while (true)
        {
            String s = readString();
            array = s.split(" ");
            int k;
            int l;
            try
            {
                k = Integer.parseInt(array[0]);
                l = Integer.parseInt(array[1]);
            }
            catch (Exception e)
            {
                writeMessage("incorrect data");
                continue;
            }
            if (k <= 0 || l <= 0 || array.length > 2)
            {
                writeMessage("incorrect data");
                continue;
            }
            break;
        }
        return array;
    }


    public static Operation askOperation() {

        while (true)
        {
            String line = readString();
            if (Integer.parseInt(line) > 0 && Integer.parseInt(line) < 5)
                return Operation.getAllowableOperationByOrdinal(Integer.parseInt(line));
            else
                writeMessage("incorrect data");
        }
    }


}
