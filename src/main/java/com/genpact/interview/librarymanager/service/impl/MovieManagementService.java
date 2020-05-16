package com.genpact.interview.librarymanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.genpact.interview.librarymanager.models.ItemEntryResponseModel;
import com.genpact.interview.librarymanager.models.ItemModel;
import com.genpact.interview.librarymanager.models.ItemResponse;
import com.genpact.interview.librarymanager.service.ILibraryManagementService;

@Service
public class MovieManagementService implements ILibraryManagementService{

	@Override
	public ItemEntryResponseModel createItemEntry(ItemModel movieModel) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemEntryResponseModel updateItemEntry(ItemModel movieModel, Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ItemResponse> getItemEntryByLibraryId(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemResponse getItemEntryByItemId(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ItemResponse> getAllItemEntries() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
