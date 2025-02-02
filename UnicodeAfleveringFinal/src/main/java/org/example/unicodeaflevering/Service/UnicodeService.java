package org.example.unicodeaflevering.Service;

import org.example.unicodeaflevering.Repository.UnicodeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UnicodeService {

    private final UnicodeRepository unicodeRepository;

    public UnicodeService(UnicodeRepository unicodeRepository) {
        this.unicodeRepository = unicodeRepository;
    }

}
