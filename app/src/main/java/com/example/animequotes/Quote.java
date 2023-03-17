package com.example.animequotes;

public class Quote {

    private String anime;
    private String character;
    private String quote;

    Quote(){
    }

    public Quote(String anime, String character, String quote) {
        this.anime = anime;
        this.character = character;
        this.quote = quote;
    }

    public void setAnime(String anime) {
        this.anime = anime;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getAnime() {
        return anime;
    }

    public String getCharacter() {
        return character;
    }

    public String getQuote() {
        return quote;
    }

    @Override
    public String toString() {
        return "\n" + "Anime : " + anime + "\n" +
                "Character : " + character + "\n" +
                "Quote : " + quote + "\n";
    }
}
