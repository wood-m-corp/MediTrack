package com.example.code;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
    private static final String LOG_FILE = System.getenv("APPDATA") + "/MediTrack/log.txt";

    public static void log(String message) {
        try (PrintWriter out = new PrintWriter(new FileWriter(LOG_FILE, true))) {
            out.println("[LOG] " + message);
        } catch (IOException e) {
            // fallback in case logging fails
            e.printStackTrace();
        }
    }

    public static void error(String message, Throwable throwable) {
        try (PrintWriter out = new PrintWriter(new FileWriter(LOG_FILE, true))) {
            out.println("[ERROR] " + message);
            throwable.printStackTrace(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}