package com.pulga.searchautocomplete;

import java.util.Objects;

public class InsertDTO {
    private String word;


    public InsertDTO() {
    }

    public InsertDTO(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InsertDTO insertDTO = (InsertDTO) o;
        return Objects.equals(word, insertDTO.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word);
    }

    @Override
    public String toString() {
        return "InsertDTO{" +
                "word='" + word + '\'' +
                '}';
    }
}
