package com.genpact.interview.librarymanager.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genpact.interview.librarymanager.entities.Library;
import com.genpact.interview.librarymanager.exceptions.ValidationException;
import com.genpact.interview.librarymanager.repo.ILibraryRepository;
import com.genpact.interview.librarymanager.service.ILibraryService;
import com.genpact.interview.librarymanager.utils.Constants;

@Service
public class LibraryService implements ILibraryService{

	@Autowired
	private ILibraryRepository libraryRepository;
	
	@Override
	public List<Library> getAllLibraries() throws Exception {
		List<Library> resp = new ArrayList<>();
		try {
			Iterable<Library> its = libraryRepository.findAll();
			if(its == null)
				throw new ValidationException(Constants.ITEM_NOT_FOUND);
			its.forEach(resp::add);
		} catch(ValidationException ve) {
			throw ve;
		} catch(Exception e) {
			throw e;
		}
		return resp;
	}

}
