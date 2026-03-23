package com.example.myapplicationmovie;

public class Movie {
    private String title;
    private int year;
    private String genre;
    private int posterResId;

    public Movie(String title, int year, String genre, int posterResId) {
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.posterResId = posterResId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPosterResId() {
        return posterResId;
    }

    public void setPosterResId(int posterResId) {
        this.posterResId = posterResId;
    }
}
