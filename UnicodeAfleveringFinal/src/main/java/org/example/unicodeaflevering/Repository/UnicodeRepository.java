package org.example.unicodeaflevering.Repository;

import org.example.unicodeaflevering.Model.Unicode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface UnicodeRepository extends JpaRepository<Unicode, Integer> {

    Set<Character> findAllByUnicode(int unicode);

}
