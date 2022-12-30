package pl.coderslab.beans;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class FileCustomerLogger implements CustomerLogger {
    String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public FileCustomerLogger() {
    }

    public FileCustomerLogger(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void log() {
        System.out.println(LocalDateTime.now() + " File override: " + fileName);
    }
}
