package org.example.unicodeaflevering.Controller;

import org.antlr.v4.runtime.tree.Tree;
import org.example.unicodeaflevering.Model.Unicode;
import org.example.unicodeaflevering.Repository.UnicodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class UnicodeRestController {
    @Autowired
    private UnicodeRepository unicodeRepository;

    @GetMapping("/unicode/{i}")
    public String unicodeToChar(@PathVariable int i) {
        char c = (char)i;
        return "unicode=" + i + " char=" + c;
    }

    /**
     * Returns the character, corresponding to the given Unicode
     * @param i the Unicode
     * @return the given character
     */
    @GetMapping("/char/{i}")
    public String charToUnicode(@PathVariable char i) {
        return "char=" + i + " unicode=" + (int) i;
    }

    /**
     * Initialises all Unicode characters, in the interval 1 - 150.
     * Using LinkedHashSet to maintain correct order, instead of sorting
     * @return ResponseEntity
     */
    @GetMapping("unicode/initdata")
    public ResponseEntity<String> initdata() {
        Set<Unicode> unicodeSet = new LinkedHashSet<>();
        int i = 1;
        while(i <= 150 ){
            unicodeSet.add(new Unicode(i, (char)i, "unicode: " + String.valueOf(i)));
            i++;
        }

        unicodeRepository.saveAll(unicodeSet);
        return ResponseEntity.ok("");
    }

    @GetMapping("unicode/unicodeset")
    public Set<Unicode> unicodeSet() {
        Set<Unicode> unicodeSet = new LinkedHashSet<>();
        unicodeSet.addAll(unicodeRepository.findAll());
        return unicodeSet;
    }
}
