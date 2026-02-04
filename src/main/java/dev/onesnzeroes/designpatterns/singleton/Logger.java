package dev.onesnzeroes.designpatterns.singleton;

import java.io.*;

public class Logger {

    private static Logger instance;

    private String filePath;
    private String fileName;
    private PrintWriter writer;

    private Logger() {
        this.filePath = "logs";
        this.fileName = "file.txt";
        this.setFileName(fileName);
    }

    public static Logger getInstance(){
        if(instance == null){
            instance = new Logger();
        }
        return instance;
    }

    public void setFileName(String fileName) {
        try {
            if (this.writer != null) {
                this.writer.close();
            }

            File dir = new File(this.filePath);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            File file = new File(dir, fileName);
            if (!file.exists()) {
                file.createNewFile();
            }

            this.fileName = fileName;
            System.out.println(file.getAbsolutePath());
            this.writer = new PrintWriter(file);

        } catch (IOException e) {
            System.out.println("Failed to create log file");
            this.writer = null;
        }
    }
    public void write(String message){
        System.out.println(message);
        this.writer.println(message);
        this.writer.flush();
    }

    public void close(){
        this.writer.flush();
        this.writer.close();
    }
}
