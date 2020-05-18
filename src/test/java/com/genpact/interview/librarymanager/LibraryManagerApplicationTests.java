package com.genpact.interview.librarymanager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import com.genpact.interview.librarymanager.enums.BOOK_TYPE;
import com.genpact.interview.librarymanager.enums.GENRE;
import com.genpact.interview.librarymanager.enums.LIB_ITEM_TYPE;
import com.genpact.interview.librarymanager.models.BookModel;
import com.genpact.interview.librarymanager.models.ItemEntryResponseModel;
import com.genpact.interview.librarymanager.models.ItemModel;
import com.genpact.interview.librarymanager.models.LibraryModel;
import com.genpact.interview.librarymanager.service.ILibraryManagementService;
import com.genpact.interview.librarymanager.service.ILibraryService;

@SpringBootTest
class LibraryManagerApplicationTests {

	@Autowired
	@Qualifier("bookManagementService")
	private ILibraryManagementService libraryManagementService;
	
	@Autowired
	private ILibraryService libraryService;
	
	@Test
	void contextLoads() {
	}
	
	/**
	 * Tests book entry functionality in a library
	 * @throws Exception
	 */
	@Test
	void createBookTest() throws Exception {
		ItemModel bookModel = new ItemModel();
		bookModel.setAuthor("TestAuthor");
		bookModel.setCode("Book-1");
		bookModel.setDescription("description");
		bookModel.setGenre(GENRE.FICTION);
		bookModel.setName("Book-i");
		bookModel.setPublishers("Publisher-1");
		
		LibraryModel lib = new LibraryModel();
		lib.setDescription("lib-desc 1");
		lib.setName("Lib01");
		lib.setType(LIB_ITEM_TYPE.BOOK);
		bookModel.setLibrary(lib);
		
		BookModel book = new BookModel();
		book.setType(BOOK_TYPE.EBOOK);
		book.setIsbnNo("ddd12301");
		bookModel.setBook(book);
		ItemEntryResponseModel res =  libraryManagementService.createItemEntry(bookModel);
		assertNotNull(res);
		assertEquals(res.getItemId()>0, true);
		assertNotNull(libraryManagementService.updateItemEntry(bookModel, res.getItemId()));
		
	}
	
	/**
	 * Tests fetching all the libraries
	 * @throws Exception
	 */
	@Test
	void getLibrariesTest() throws Exception {
		assertNotNull(libraryService.getAllLibraries());
	}
}
