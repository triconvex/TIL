package ch2;

public enum Verb {

    IS("is"),
    ARE("are");

    private String word;

    Verb(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }
}
