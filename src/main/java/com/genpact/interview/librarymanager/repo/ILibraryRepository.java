package com.genpact.interview.librarymanager.repo;

import org.springframework.data.repository.CrudRepository;

import com.genpact.interview.librarymanager.entities.Library;

public interface ILibraryRepository extends CrudRepository<Library, Long>{

}
