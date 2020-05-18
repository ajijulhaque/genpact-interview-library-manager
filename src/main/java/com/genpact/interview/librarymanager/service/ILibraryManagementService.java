package com.genpact.interview.librarymanager.service;

import java.util.List;

import com.genpact.interview.librarymanager.models.ItemEntryResponseModel;
import com.genpact.interview.librarymanager.models.ItemModel;
import com.genpact.interview.librarymanager.models.ItemResponse;

/**
 * 
 * @author Ajijul
 *
 */
public interface ILibraryManagementService {
	/**
	 * This method created an item entry in a particular library. Creates library if librray id is not sent.
	 * @param bookModel
	 * @return
	 * @throws Exception
	 */
	public ItemEntryResponseModel createItemEntry(ItemModel bookModel) throws Exception;

	/**
	 * This method updates a books entry in the library. 'id' represents the book's id
	 * @param bookModel
	 * @param id 
	 * @return
	 * @throws Exception
	 */
	public ItemEntryResponseModel updateItemEntry(ItemModel bookModel, Long id) throws Exception;

	/**
	 * This method gets all the books in a particular library. id represents library id.
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<ItemResponse> getItemEntryByLibraryId(Long id) throws Exception;

	/**
	 * This method return book entity. id represents book id.
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public ItemResponse getItemEntryByItemId(Long id) throws Exception;

	/**
	 * This method return all the books exist in the system.
	 * @return
	 * @throws Exception
	 */
	public List<ItemResponse> getAllItemEntries() throws Exception;

}
