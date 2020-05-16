package com.genpact.interview.librarymanager.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.genpact.interview.librarymanager.entities.Book;
import com.genpact.interview.librarymanager.entities.Library;
import com.genpact.interview.librarymanager.exceptions.ValidationException;
import com.genpact.interview.librarymanager.models.BookModel;
import com.genpact.interview.librarymanager.models.ItemEntryResponseModel;
import com.genpact.interview.librarymanager.models.ItemModel;
import com.genpact.interview.librarymanager.models.ItemResponse;
import com.genpact.interview.librarymanager.models.LibraryModel;
import com.genpact.interview.librarymanager.repo.IBookRepository;
import com.genpact.interview.librarymanager.repo.ILibraryRepository;
import com.genpact.interview.librarymanager.service.ILibraryManagementService;
import com.genpact.interview.librarymanager.utils.Constants;

/**
 * 
 * @author Ajijul
 *
 */
@Service
public class BookManagementService implements ILibraryManagementService{

	@Autowired
	private IBookRepository bookRepository;
	@Autowired
	private ILibraryRepository libraryRepository;
	
	@Override
	public ItemEntryResponseModel createItemEntry(ItemModel itemModel) throws Exception {
		ItemEntryResponseModel resp = null;
		Book entity = null;
		try {
			entity = validateBookModelRequest(itemModel, null);
			entity = bookRepository.save(entity);
			resp = new ItemEntryResponseModel();
			resp.setItemId(entity.getBookId());
			resp.setLibraryId(entity.getLibrary().getLibraryId());
		} catch(ValidationException ve) {
			throw ve;
		} catch(Exception e) {
			throw e;
		}
		return resp;
	}

	private Book validateBookModelRequest(ItemModel bookModel, Book entity) throws ValidationException{
		if(bookModel == null)
			throw new ValidationException("Request body not present");
		if(entity == null)
			entity = new Book();
		Library libEntity = new Library();
		StringBuilder mandatroy = new StringBuilder();
		if(bookModel.getAuthor() != null && bookModel.getAuthor().trim().length()>0) {
			entity.setAuthor(bookModel.getAuthor());
		} else {
			mandatroy.append(Constants.FIELD_BOOK_AUTHOR);
		}
		if(bookModel.getCode() != null && bookModel.getCode().trim().length()>0) {
			entity.setCode(bookModel.getCode());
		} else {
			mandatroy.append(Constants.FIELD_BOOK_CODE);
		}
		if(bookModel.getGenre() != null && bookModel.getGenre().ordinal()>0) {
			entity.setGenre(bookModel.getGenre());
		} else {
			mandatroy.append(Constants.FIELD_BOOK_GENRE);
		}
		if(bookModel.getName() != null && bookModel.getName().trim().length()>0) {
			entity.setName(bookModel.getName().trim());
		} else {
			mandatroy.append(Constants.FIELD_BOOK_NAME);
		}
		if(bookModel.getBook() != null) {
			if(bookModel.getBook().getType() != null && bookModel.getBook().getType().ordinal()>0) {
				entity.setType(bookModel.getBook().getType());
			} else {
				mandatroy.append(Constants.FIELD_BOOK_TYPE);
			}
		} else {
			mandatroy.append(Constants.FIELD_BOOK);
		}
		
		if(bookModel.getLibrary() != null) {
			LibraryModel lib = bookModel.getLibrary();
			if(lib.getName() != null && lib.getName().trim().length()>0) {
				libEntity.setName(lib.getName());
			} else {
				mandatroy.append(Constants.FIELD_LIBRARY_NAME);
			}
			if(lib.getType() != null && lib.getType().ordinal()>0) {
				libEntity.setType(lib.getType());
			} else {
				mandatroy.append(Constants.FIELD_LIBRARY_TYPE);
			}
		} else {
			mandatroy.append(Constants.FIELD_LIBRARY);
		}
		if(mandatroy.length()>0) {
			mandatroy.append(Constants.MANDATORY_MSG);
			throw new ValidationException(mandatroy.toString());
		}
		entity.setLibrary(libEntity);
		
		return entity;
	}

	@Override
	public ItemEntryResponseModel updateItemEntry(ItemModel bookModel, Long id) throws Exception {
		ItemEntryResponseModel resp = null;
		Book entity = null;
		try {
			Optional<Book> opts = bookRepository.findById(id);
			if(opts != null && opts.isPresent()) {
				entity = validateBookModelRequest(bookModel, opts.get());
				entity = bookRepository.save(entity);
				resp = new ItemEntryResponseModel();
				resp.setItemId(entity.getBookId());
				resp.setLibraryId(entity.getLibrary().getLibraryId());
			} else {
				throw new ValidationException(Constants.ITEM_NOT_FOUND);
			}
		} catch(ValidationException ve) {
			throw ve;
		} catch(Exception e) {
			throw e;
		}
		return resp;
	}

	@Override
	public List<ItemResponse> getItemEntryByLibraryId(Long id) throws Exception {
		List<ItemResponse> dataList = new ArrayList<>();
		try {
			Optional<Library> opts = libraryRepository.findById(id);
			if(opts != null && opts.isPresent()) {
				Library lib = opts.get();
				lib.getBooks().forEach(x->{
					ItemResponse model = new ItemResponse();
					BookModel book = new BookModel();
					LibraryModel library = new LibraryModel();
					
					library.setDeescription(lib.getDeescription());
					library.setName(lib.getName());
					library.setType(lib.getType());
					
					book.setIsbnNo(x.getIsbnNo());
					book.setType(x.getType());
					
					model.setBook(book);
					model.setLibrary(library);
					model.setAuthor(x.getAuthor());
					model.setCode(x.getCode());
					model.setCreatedBy(x.getCreatedBy());
					model.setCreatedOn(x.getCreatedOn());
					model.setDescription(x.getDescription());
					model.setGenre(x.getGenre());
					model.setId(x.getBookId());
					model.setLastUpdatedBy(x.getLastUpdatedBy());
					model.setLastUpdatedOn(x.getLastUpdatedOn());
					model.setName(x.getName());
					model.setPublishers(x.getPublishers());
					
					dataList.add(model);
				});
			} else {
				throw new ValidationException(Constants.ITEM_NOT_FOUND);
			}
		} catch(ValidationException ve) {
			throw ve;
		} catch(Exception e) {
			throw e;
		}
		return dataList;
	}

	@Override
	public ItemResponse getItemEntryByItemId(Long id) throws Exception {
		ItemResponse model = new ItemResponse();
		try {
			Optional<Book> opts = bookRepository.findById(id);
			if(opts != null && opts.isPresent()) {
				Book entity = opts.get();
				BookModel book = new BookModel();
				LibraryModel library = new LibraryModel();
				
				library.setDeescription(entity.getLibrary().getDeescription());
				library.setName(entity.getLibrary().getName());
				library.setType(entity.getLibrary().getType());
				
				book.setIsbnNo(entity.getIsbnNo());
				book.setType(entity.getType());
				
				model.setBook(book);
				model.setLibrary(library);
				model.setAuthor(entity.getAuthor());
				model.setCode(entity.getCode());
				model.setCreatedBy(entity.getCreatedBy());
				model.setCreatedOn(entity.getCreatedOn());
				model.setDescription(entity.getDescription());
				model.setGenre(entity.getGenre());
				model.setId(entity.getBookId());
				model.setLastUpdatedBy(entity.getLastUpdatedBy());
				model.setLastUpdatedOn(entity.getLastUpdatedOn());
				model.setName(entity.getName());
				model.setPublishers(entity.getPublishers());
				
			} else {
				throw new ValidationException(Constants.ITEM_NOT_FOUND);
			}
		} catch(ValidationException ve) {
			throw ve;
		} catch(Exception e) {
			throw e;
		}
		return model;
	}

	@Override
	public List<ItemResponse> getAllItemEntries() throws Exception {
		List<ItemResponse> dataList = new ArrayList<>();
		try {
			Iterable<Book> books = bookRepository.findAll();
			if(books != null) {
				books.forEach(x->{
					ItemResponse model = new ItemResponse();
					BookModel book = new BookModel();
					LibraryModel library = new LibraryModel();
					
					library.setDeescription(x.getLibrary().getDeescription());
					library.setName(x.getLibrary().getName());
					library.setType(x.getLibrary().getType());
					
					book.setIsbnNo(x.getIsbnNo());
					book.setType(x.getType());
					
					model.setBook(book);
					model.setLibrary(library);
					model.setAuthor(x.getAuthor());
					model.setCode(x.getCode());
					model.setCreatedBy(x.getCreatedBy());
					model.setCreatedOn(x.getCreatedOn());
					model.setDescription(x.getDescription());
					model.setGenre(x.getGenre());
					model.setId(x.getBookId());
					model.setLastUpdatedBy(x.getLastUpdatedBy());
					model.setLastUpdatedOn(x.getLastUpdatedOn());
					model.setName(x.getName());
					model.setPublishers(x.getPublishers());
					
					dataList.add(model);
				});
			} else {
				throw new ValidationException(Constants.ITEM_NOT_FOUND);
			}
		} catch(ValidationException ve) {
			throw ve;
		} catch(Exception e) {
			throw e;
		}
		return dataList;
	}


}
