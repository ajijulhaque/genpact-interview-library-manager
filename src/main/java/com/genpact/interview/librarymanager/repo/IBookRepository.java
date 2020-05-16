package com.genpact.interview.librarymanager.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.genpact.interview.librarymanager.entities.Book;
@Repository
public interface IBookRepository extends CrudRepository<Book, Long> {

}
