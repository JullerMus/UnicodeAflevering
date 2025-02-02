package org.example.unicodeaflevering.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "unicodes")
public class Unicode {

    @Id
    int unicode;
    char chara;
    String description;

    protected Unicode() {}

    public Unicode(int unicode, char character, String description) {
        this.unicode = unicode;
        this.chara = character;
        this.description = description;
    }

    public int getUnicode() {
        return unicode;
    }

    public char getChara() {
        return chara;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
