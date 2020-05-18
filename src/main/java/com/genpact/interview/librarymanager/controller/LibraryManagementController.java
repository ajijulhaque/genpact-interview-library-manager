package com.genpact.interview.librarymanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.genpact.interview.librarymanager.entities.Library;
import com.genpact.interview.librarymanager.exceptions.ValidationException;
import com.genpact.interview.librarymanager.models.ItemEntryResponseModel;
import com.genpact.interview.librarymanager.models.ItemModel;
import com.genpact.interview.librarymanager.models.ItemResponse;
import com.genpact.interview.librarymanager.models.ResponseWrapper;
import com.genpact.interview.librarymanager.service.ILibraryManagementService;
import com.genpact.interview.librarymanager.service.ILibraryService;
import com.genpact.interview.librarymanager.utils.Constants;

/**
 * This controller exposes service endpoints for library application
 * @author Ajijul
 *
 */
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(value="/lib-manager")
public class LibraryManagementController {
	
	/**
	 * Autowring donw based on qualifier as 2 concrete class implements same interface. This has been done to accomodate 
	 * other media than book in library. This has been done keeping future scope in mind. Then based on LIB_ITEM_TYPE the 
	 * which service to be used will be decided. 
	 */
	@Autowired
	@Qualifier("bookManagementService")
	private ILibraryManagementService libraryManagementService;
	
	/**
	 * This service is for solely Library related operation 
	 */
	@Autowired
	private ILibraryService libraryService;
	
	/**
	 * This creates a book entry into a specific library. If library id is not passed then it will create a library.
	 * @param bookModel
	 * @return
	 */
	@RequestMapping(value="/book", method = RequestMethod.POST)
	public ResponseWrapper<ItemEntryResponseModel> createBookEntry(@RequestBody final ItemModel body){
		ResponseWrapper<ItemEntryResponseModel> resp = new ResponseWrapper<ItemEntryResponseModel>();
		try {
			resp.setBody(libraryManagementService.createItemEntry(body));
			resp.setStatusCode(Constants.SUCCESS);
			resp.setMsg(Constants.SUCCESS_MSG);
		} catch(ValidationException ve) {
			resp.setStatusCode(Constants.INVALID_REQ);
			resp.setMsg(ve.getMessage());
		} catch(Exception e) {
			resp.setStatusCode(Constants.ERROR_PROCESSING);
			resp.setMsg(Constants.ERROR_PROCESSING_MSG);
		}
		return resp;
	}
	
	/**
	 * This method updates a books entry in the library. 'id' represents the book's id
	 * @param body
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/book/{id}", method = RequestMethod.PUT)
	public ResponseWrapper<ItemEntryResponseModel> updateBookEntry(@RequestBody final ItemModel body, @PathVariable final Long id){
		ResponseWrapper<ItemEntryResponseModel> resp = new ResponseWrapper<ItemEntryResponseModel>();
		try {
			resp.setBody(libraryManagementService.updateItemEntry(body, id));
			resp.setStatusCode(Constants.SUCCESS);
			resp.setMsg(Constants.SUCCESS_MSG);
		} catch(ValidationException ve) {
			resp.setStatusCode(Constants.INVALID_REQ);
			resp.setMsg(ve.getMessage());
		} catch(Exception e) {
			resp.setStatusCode(Constants.ERROR_PROCESSING);
			resp.setMsg(Constants.ERROR_PROCESSING_MSG);
		}
		return resp;
	}
	
	/**
	 * This method return book entity. id represents book id.
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/book/{id}", method = RequestMethod.GET)
	public ResponseWrapper<ItemResponse> getBookEntryByBookId(@PathVariable final Long id){
		ResponseWrapper<ItemResponse> resp = new ResponseWrapper<ItemResponse>();
		try {
			resp.setBody(libraryManagementService.getItemEntryByItemId(id));
			resp.setStatusCode(Constants.SUCCESS);
			resp.setMsg(Constants.SUCCESS_MSG);
		} catch(ValidationException ve) {
			resp.setStatusCode(Constants.INVALID_REQ);
			resp.setMsg(ve.getMessage());
		} catch(Exception e) {
			resp.setStatusCode(Constants.ERROR_PROCESSING);
			resp.setMsg(Constants.ERROR_PROCESSING_MSG);
		}
		return resp;
	}
	
	/**
	 * This method return all the books exist in the system.
	 * @return
	 */
	@RequestMapping(value="/book", method = RequestMethod.GET)
	public ResponseWrapper<List<ItemResponse>> getAllBookEntries(){
		ResponseWrapper<List<ItemResponse>> resp = new ResponseWrapper<List<ItemResponse>>();
		try {
			resp.setBody(libraryManagementService.getAllItemEntries());
			resp.setStatusCode(Constants.SUCCESS);
			resp.setMsg(Constants.SUCCESS_MSG);
		} catch(ValidationException ve) {
			resp.setStatusCode(Constants.INVALID_REQ);
			resp.setMsg(ve.getMessage());
		} catch(Exception e) {
			resp.setStatusCode(Constants.ERROR_PROCESSING);
			resp.setMsg(Constants.ERROR_PROCESSING_MSG);
		}
		return resp;
	}
	
	
	/**
	 * This method gets all the books in a particular library. id represents library id.
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/libs/{id}", method = RequestMethod.GET)
	public ResponseWrapper<List<ItemResponse>> getBookEntryByLibraryId(@PathVariable final Long id){
		ResponseWrapper<List<ItemResponse>> resp = new ResponseWrapper<List<ItemResponse>>();
		try {
			resp.setBody(libraryManagementService.getItemEntryByLibraryId(id));
			resp.setStatusCode(Constants.SUCCESS);
			resp.setMsg(Constants.SUCCESS_MSG);
		} catch(ValidationException ve) {
			resp.setStatusCode(Constants.INVALID_REQ);
			resp.setMsg(ve.getMessage());
		} catch(Exception e) {
			resp.setStatusCode(Constants.ERROR_PROCESSING);
			resp.setMsg(Constants.ERROR_PROCESSING_MSG);
		}
		return resp;
	}
	
	/**
	 * This methods gets all the libraries in the system.
	 * @return
	 */
	@RequestMapping(value="/libs", method = RequestMethod.GET)
	public ResponseWrapper<List<Library>> getAllLibraries(){
		ResponseWrapper<List<Library>> resp = new ResponseWrapper<List<Library>>();
		try {
			resp.setBody(libraryService.getAllLibraries());
			resp.setStatusCode(Constants.SUCCESS);
			resp.setMsg(Constants.SUCCESS_MSG);
		} catch(ValidationException ve) {
			resp.setStatusCode(Constants.INVALID_REQ);
			resp.setMsg(ve.getMessage());
		} catch(Exception e) {
			resp.setStatusCode(Constants.ERROR_PROCESSING);
			resp.setMsg(Constants.ERROR_PROCESSING_MSG);
		}
		return resp;
	}
}
