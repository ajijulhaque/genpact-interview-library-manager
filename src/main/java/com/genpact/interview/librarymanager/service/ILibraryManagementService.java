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
	 * 
	 * @param bookModel
	 * @return
	 * @throws Exception
	 */
	public ItemEntryResponseModel createItemEntry(ItemModel bookModel) throws Exception;

	/**
	 * 
	 * @param bookModel
	 * @param id 
	 * @return
	 * @throws Exception
	 */
	public ItemEntryResponseModel updateItemEntry(ItemModel bookModel, Long id) throws Exception;

	/**
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<ItemResponse> getItemEntryByLibraryId(Long id) throws Exception;

	/**
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public ItemResponse getItemEntryByItemId(Long id) throws Exception;

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<ItemResponse> getAllItemEntries() throws Exception;

}
