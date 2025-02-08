package org.example.unicodeaflevering.Controller;

import org.antlr.v4.runtime.tree.Tree;
import org.example.unicodeaflevering.Model.Unicode;
import org.example.unicodeaflevering.Repository.UnicodeRepository;
import org.example.unicodeaflevering.Service.UnicodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public class UnicodeRestController {
    @Autowired
    private UnicodeRepository unicodeRepository;

    @Autowired
    private UnicodeService unicodeService;

    @GetMapping("/unicode/{i}")
    public String unicodeToChar(@PathVariable int i) {
        return "unicode=" + i + " char=" + (char)i;
    }

    /**
     * Returns the character, corresponding to the given Unicode
     * @param i the Unicode
     * @return the given character
     */
    @GetMapping("/char/{i}")
    public String charToUnicode(@PathVariable char i) {
        return "char=" + i + " unicode=" + (int)i;
    }

    /** 
     * Initialises all Unicode characters, in the interval 1 - 150.
     * Using LinkedHashSet to maintain correct order, instead of sorting
     * @return ResponseEntity
     */
    @GetMapping("unicode/initdata")
    public ResponseEntity<String> initdata() {
        return unicodeService.initData();
    }

    /**
     * Retrieves a Set of Unicodes from the MySQL database
     * @return a Set of Unicodes
     */
    @GetMapping("unicode/unicodeset")
    public Set<Unicode> unicodeSet() {
       return unicodeService.unicodeSet();
    }

    /**
     * Deletes all entries in the 'unicodes' table
     * in the database
     * @return A ResponseEntity
     */
    @GetMapping("/unicode/deleteunicodes")
    public ResponseEntity<String> deleteunicodes() {
        return unicodeService.deleteUnicodeSet();
    }
}
