package de.openvalue.modernjava.workshop.config;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties("library.rental-period-days")
public class RentalPeriodConfig {
    private int book;
    private int audioBook;
    private int defaultPeriod;

    public int getBook() {
        return book;
    }

    public void setBook(int book) {
        this.book = book;
    }

    public int getAudioBook() {
        return audioBook;
    }

    public void setAudioBook(int audioBook) {
        this.audioBook = audioBook;
    }

    public int getDefaultPeriod() {
        return defaultPeriod;
    }

    public void setDefaultPeriod(int defaultPeriod) {
        this.defaultPeriod = defaultPeriod;
    }
}
