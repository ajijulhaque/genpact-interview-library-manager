package com.genpact.interview.librarymanager.service;

import java.util.List;

import com.genpact.interview.librarymanager.entities.Library;

public interface ILibraryService {

	/**
	 * This methods gets all the libraries in the system.
	 * @return
	 * @throws Exception
	 */
	List<Library> getAllLibraries() throws Exception;

}
