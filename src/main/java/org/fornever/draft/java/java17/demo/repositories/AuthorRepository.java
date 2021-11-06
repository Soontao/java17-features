package org.fornever.draft.java.java17.demo.repositories;

import org.fornever.draft.java.java17.demo.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
