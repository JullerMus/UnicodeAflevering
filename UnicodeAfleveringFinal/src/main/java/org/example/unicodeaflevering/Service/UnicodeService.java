package org.example.unicodeaflevering.Service;

import org.example.unicodeaflevering.Model.Unicode;
import org.example.unicodeaflevering.Repository.UnicodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class UnicodeService {

    @Autowired
    private final UnicodeRepository unicodeRepository;

    public UnicodeService(UnicodeRepository unicodeRepository) {
        this.unicodeRepository = unicodeRepository;
    }

    public ResponseEntity<String> initData(){
        Set<Unicode> unicodeSet = new LinkedHashSet<>();
        int i = 1;
        while(i <= 150 ){
            unicodeSet.add(new Unicode(i, (char)i, "unicode: " + String.valueOf(i)));
            i++;
        }

        //List<Unicode> unicodesSorted = unicodeSet.stream().sorted(Comparator.comparing(Unicode::getUnicode)).toList();

        unicodeRepository.saveAll(unicodeSet);
        return ResponseEntity.ok("");
    }

    public Set<Unicode> unicodeSet(){
        Set<Unicode> unicodeSet = new LinkedHashSet<>();
        unicodeSet.addAll(unicodeRepository.findAll());
        return unicodeSet;
    }

}
