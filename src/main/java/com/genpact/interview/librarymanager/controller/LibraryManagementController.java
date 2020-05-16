package com.genpact.interview.librarymanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.genpact.interview.librarymanager.exceptions.ValidationException;
import com.genpact.interview.librarymanager.models.ItemEntryResponseModel;
import com.genpact.interview.librarymanager.models.ItemModel;
import com.genpact.interview.librarymanager.models.ItemResponse;
import com.genpact.interview.librarymanager.models.ResponseWrapper;
import com.genpact.interview.librarymanager.service.ILibraryManagementService;
import com.genpact.interview.librarymanager.utils.Constants;

/**
 * 
 * @author Ajijul
 *
 */
@RestController
@RequestMapping(value="/lib-manager")
public class LibraryManagementController {
	
	@Autowired
	@Qualifier("bookManagementService")
	private ILibraryManagementService libraryManagementService;
	
	/**
	 * 
	 * @param bookModel
	 * @return
	 */
	@RequestMapping(value="/book", method = RequestMethod.POST)
	public ResponseWrapper<ItemEntryResponseModel> createBookEntry(@RequestBody final ItemModel body){
		ResponseWrapper<ItemEntryResponseModel> resp = new ResponseWrapper<ItemEntryResponseModel>();
		try {
			resp.setBody(libraryManagementService.createItemEntry(body));
			resp.setStatusCode(Constants.BOOK_SUCCESS);
			resp.setMsg(Constants.BOOK_SUCCESS_MSG);
		} catch(ValidationException ve) {
			resp.setStatusCode(Constants.BOOK_INVALID_REQ);
			resp.setMsg(ve.getMessage());
		} catch(Exception e) {
			resp.setStatusCode(Constants.BOOK_ERROR_PROCESSING);
			resp.setMsg(Constants.BOOK_ERROR_PROCESSING_MSG);
		}
		return resp;
	}
	
	@RequestMapping(value="/book/{id}", method = RequestMethod.PUT)
	public ResponseWrapper<ItemEntryResponseModel> updateBookEntry(@RequestBody final ItemModel body, @PathVariable final Long id){
		ResponseWrapper<ItemEntryResponseModel> resp = new ResponseWrapper<ItemEntryResponseModel>();
		try {
			resp.setBody(libraryManagementService.updateItemEntry(body, id));
			resp.setStatusCode(Constants.BOOK_SUCCESS);
			resp.setMsg(Constants.BOOK_SUCCESS_MSG);
		} catch(ValidationException ve) {
			resp.setStatusCode(Constants.BOOK_INVALID_REQ);
			resp.setMsg(ve.getMessage());
		} catch(Exception e) {
			resp.setStatusCode(Constants.BOOK_ERROR_PROCESSING);
			resp.setMsg(Constants.BOOK_ERROR_PROCESSING_MSG);
		}
		return resp;
	}
	
	@RequestMapping(value="/book/{id}", method = RequestMethod.GET)
	public ResponseWrapper<ItemResponse> getBookEntryByBookId(@PathVariable final Long id){
		ResponseWrapper<ItemResponse> resp = new ResponseWrapper<ItemResponse>();
		try {
			resp.setBody(libraryManagementService.getItemEntryByItemId(id));
			resp.setStatusCode(Constants.BOOK_SUCCESS);
			resp.setMsg(Constants.BOOK_SUCCESS_MSG);
		} catch(ValidationException ve) {
			resp.setStatusCode(Constants.BOOK_INVALID_REQ);
			resp.setMsg(ve.getMessage());
		} catch(Exception e) {
			resp.setStatusCode(Constants.BOOK_ERROR_PROCESSING);
			resp.setMsg(Constants.BOOK_ERROR_PROCESSING_MSG);
		}
		return resp;
	}
	
	@RequestMapping(value="/book", method = RequestMethod.GET)
	public ResponseWrapper<List<ItemResponse>> getAllBookEntries(){
		ResponseWrapper<List<ItemResponse>> resp = new ResponseWrapper<List<ItemResponse>>();
		try {
			resp.setBody(libraryManagementService.getAllItemEntries());
			resp.setStatusCode(Constants.BOOK_SUCCESS);
			resp.setMsg(Constants.BOOK_SUCCESS_MSG);
		} catch(ValidationException ve) {
			resp.setStatusCode(Constants.BOOK_INVALID_REQ);
			resp.setMsg(ve.getMessage());
		} catch(Exception e) {
			resp.setStatusCode(Constants.BOOK_ERROR_PROCESSING);
			resp.setMsg(Constants.BOOK_ERROR_PROCESSING_MSG);
		}
		return resp;
	}
	
	@RequestMapping(value="/libs/{id}", method = RequestMethod.GET)
	public ResponseWrapper<List<ItemResponse>> getBookEntryByLibraryId(@PathVariable final Long id){
		ResponseWrapper<List<ItemResponse>> resp = new ResponseWrapper<List<ItemResponse>>();
		try {
			resp.setBody(libraryManagementService.getItemEntryByLibraryId(id));
			resp.setStatusCode(Constants.BOOK_SUCCESS);
			resp.setMsg(Constants.BOOK_SUCCESS_MSG);
		} catch(ValidationException ve) {
			resp.setStatusCode(Constants.BOOK_INVALID_REQ);
			resp.setMsg(ve.getMessage());
		} catch(Exception e) {
			resp.setStatusCode(Constants.BOOK_ERROR_PROCESSING);
			resp.setMsg(Constants.BOOK_ERROR_PROCESSING_MSG);
		}
		return resp;
	}
}
