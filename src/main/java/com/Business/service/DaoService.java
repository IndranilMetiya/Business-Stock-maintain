package com.Business.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Business.DTO.CategoryDTO;
import com.Business.DTO.PriceTrackerDTO;
import com.Business.DTO.PriceTrackerUpdateDTO;
import com.Business.DTO.PropertyDTO;
import com.Business.DTO.StockDTO;
import com.Business.DTO.SubCategoryDTO;
import com.Business.DTO.TransactionDTO;
import com.Business.entity.Category;
import com.Business.entity.Customer;
import com.Business.entity.PriceTracker;
import com.Business.entity.PriceTrackerUpdate;
import com.Business.entity.Property;
import com.Business.entity.Stock;
import com.Business.entity.SubCategory;
import com.Business.entity.TransactionData;
import com.Business.repository.CategoryRepo;
import com.Business.repository.CustomerRepo;
import com.Business.repository.PriceTrackerRepo;
import com.Business.repository.PriceTrackerUpdateRepo;
import com.Business.repository.PropertyRepo;
import com.Business.repository.StockRepo;
import com.Business.repository.SubCategoryRepo;
import com.Business.repository.TransactionDataRepo;

import jakarta.transaction.Transactional;

@Service
public class DaoService {
	
	@Autowired
	CategoryRepo categoryRepo;
	
	@Autowired
	SubCategoryRepo subCategoryRepo;
	
	@Autowired
	PropertyRepo propertyRepo;
	
	@Autowired
	StockRepo stockRepo;
	
	@Autowired
	TransactionDataRepo transactionDataRepo;
	
	@Autowired
	CustomerRepo customerRepo;
	
	@Autowired
	PriceTrackerRepo priceTrackerRepo;
	
	@Autowired
	PriceTrackerUpdateRepo priceTrackerUpdateRepo;
	
	@Transactional
	public String createCatagory(CategoryDTO catagoryDto) {
		Category catagory = new Category();
		catagory.setCategoryName(catagoryDto.getCategoryName()); // wood / glue / ply
		catagory.setRemarks(catagoryDto.getRemarks());
		Category category2 = categoryRepo.findByCategoryName(catagoryDto.getCategoryName());
		if (category2 == null) {
			categoryRepo.save(catagory);
			System.out.println("Catagory saved with name - " + "' " + catagoryDto.getCategoryName() + " '");
			return "Catagory saved with name - " + "' " + catagoryDto.getCategoryName() + " '";
		} else {
			return "Data Already present with same category";
		}
	}
	
	public List<CategoryDTO> getCategories(){
		List<Category> categories=new ArrayList<>();
		categories=categoryRepo.findAll();
		List<CategoryDTO> categoryDTOs=new ArrayList<>();
		CategoryDTO categoryDTO=new CategoryDTO();
		for (Category category : categories) {
			categoryDTO=new CategoryDTO();
			categoryDTO.setCategoryName(category.getCategoryName());
			categoryDTO.setRemarks(category.getRemarks());
			categoryDTOs.add(categoryDTO);			
		}
		return categoryDTOs;
		
	}
	
	@Transactional
	public String createSubCategory(SubCategoryDTO subCategoryDTO) {
		
		SubCategory subCategory = new SubCategory();
		
		Category catagory=categoryRepo.findByCategoryName(subCategoryDTO.getCatagoryName());
		if (catagory==null) {
			return "There is no category assosociated  with this sub-category Please add category first";			
		}
		subCategory.setCategory(catagory); // saal segun
		
		subCategory.setSubCatagoryName(subCategoryDTO.getSubCatagoryName());
		
		SubCategory subCategory2 = subCategoryRepo.findBySubCatagoryName(subCategoryDTO.getSubCatagoryName());
		if (subCategory2 == null) {
			subCategoryRepo.save(subCategory);
			System.out.println("Sub-Catagory saved with name - " + "' " + subCategoryDTO.getSubCatagoryName() + " '");
			return "Sub-Catagory saved with name - " + "' " + subCategoryDTO.getSubCatagoryName()+ " '";
		} else {
			return "Data Already present with same Sub-category";
		}
		
	}
	
	public List<SubCategoryDTO> getAllSubCategories(){
		List<SubCategoryDTO> subCategoryDTOs=new ArrayList<>();
		List<SubCategory> subCategories=new ArrayList<>();
		subCategories=subCategoryRepo.findAll();
		SubCategoryDTO subCategoryDTO=new SubCategoryDTO();
		for (SubCategory subCategory : subCategories) {
			subCategoryDTO=new SubCategoryDTO();
			subCategoryDTO.setCatagoryName(subCategory.getCategory().getCategoryName());
			subCategoryDTO.setSubCatagoryName(subCategory.getSubCatagoryName());
			subCategoryDTOs.add(subCategoryDTO);
			
		}
		return subCategoryDTOs;
	}
	
	public List<SubCategoryDTO> getAllSubCategoryFromAcategory(CategoryDTO categoryDTO){
		
		Category category=categoryRepo.findByCategoryName(categoryDTO.getCategoryName());
		
		List<SubCategory> subCategories= subCategoryRepo.findByCategory(category);
		List<SubCategoryDTO> allSubCategories=new ArrayList<>();
		SubCategoryDTO subCategoryDTO=new SubCategoryDTO();
		for (SubCategory subCategory : subCategories) {
			subCategoryDTO=new SubCategoryDTO();
			subCategoryDTO.setCatagoryName(subCategory.getCategory().getCategoryName());
			subCategoryDTO.setSubCatagoryName(subCategory.getSubCatagoryName());
			allSubCategories.add(subCategoryDTO);
			
		}
		
		return allSubCategories;	
	}
	
	public List<String> getAllSubCategoryFromAcategoryAsList(CategoryDTO categoryDTO){
		List<SubCategoryDTO> subCategoryDTOs=new ArrayList<>();
		subCategoryDTOs=getAllSubCategoryFromAcategory(categoryDTO);
		 List<String> subCategorieStrings=new ArrayList<>();
		for (SubCategoryDTO subCategoryDTO : subCategoryDTOs) {
			subCategorieStrings.add(subCategoryDTO.getSubCatagoryName());
			
		}
		return subCategorieStrings;
		
	}

	@Transactional
	public String createProperty(PropertyDTO propertyDTO) {
		
		Property property=new Property();
		
		property.setPropertyName(propertyDTO.getPropertyName());
		property.setUnitType(propertyDTO.getUnitType());
		property.setProductType(propertyDTO.getProductType());
		property.setHeight(propertyDTO.getHeight());
		property.setWidth(propertyDTO.getWidth());
		property.setWeight(propertyDTO.getWeight());
		property.setRemarks(propertyDTO.getRemarks());
		
		SubCategory subCategory=new SubCategory();
		subCategory=subCategoryRepo.findBySubCatagoryName(propertyDTO.getSubCategoryName());
		if (subCategory==null) {
			return " The provided Sub-Category is not present, Please add this Sub Category and then proceed ";			
		}
		int subcategoryId=subCategory.getSubCatagoryId();
		property.setSubCategory(subCategory);
		if (subCategory.getCategory().getCategoryName().equalsIgnoreCase(propertyDTO.getCategoryName())) {
			property.setCategoryName(subCategory.getCategory().getCategoryName());
		}
		else {
			return "This Provided category is not associated with sub-category, Please add this sub-category with this category first";
		}
		
		
		//now check if same property present in DB then dont save if not present then save
		
		Property checkExistingProperty = new Property();
		checkExistingProperty= propertyRepo.findByProductTypeAndPropertyNameAndUnitTypeAndSubCategoryAndDetails(
				property.getProductType(),
				property.getPropertyName(),
				property.getUnitType(),
				subcategoryId,
				property.getHeight(),
				property.getWidth(),
				property.getWeight());
		
		if(checkExistingProperty==null) {
			propertyRepo.save(property);
			System.out.println("New Property Saved Successfully");
			Stock stock=new Stock();
			stock.setProperty(property);
			stockRepo.save(stock);
			System.out.println("Stock Created for new property, named = "+property.getPropertyName());
			return "Property created and Stock also Created for new property";
		}
		else {
			System.out.println("This property is already present");
			return "This property is already present so no stock created nor the property created";

		}
	}

	public List<PropertyDTO> getProperties(){
		
		List<PropertyDTO> propertyDTOs=new ArrayList<>();
		PropertyDTO pDTO=new PropertyDTO();
		List<Property> properties=new ArrayList<>();
		properties=propertyRepo.findAll();
		for (Property property : properties) {
			pDTO=new PropertyDTO();
			pDTO.setCategoryName(property.getCategoryName());
			pDTO.setHeight(property.getHeight());
			pDTO.setProductType(property.getProductType());
			pDTO.setPropertyName(property.getPropertyName());
			pDTO.setRemarks(property.getRemarks());
			pDTO.setSubCategoryName(property.getSubCategory().getSubCatagoryName());
			pDTO.setUnitType(property.getUnitType());
			pDTO.setWeight(property.getWeight());
			pDTO.setWidth(property.getWidth());
			
			propertyDTOs.add(pDTO);
			
		}
		
		return propertyDTOs;
		
	}

	public List<StockDTO> getStocks(){
		List<StockDTO> stockDTOs=new ArrayList<>();
		StockDTO stockDTO=new StockDTO();
		List<Stock> stocks=new ArrayList<>();
		stocks=stockRepo.findAll();
		for (Stock stock : stocks) {
			stockDTO=new StockDTO();
			stockDTO.setPropertyName(stock.getProperty().getPropertyName());
			stockDTO.setQantityAal(stock.getQuantityAvailable());
			stockDTO.setStockId(stock.getStockId());
			stockDTOs.add(stockDTO);
		}
		
		return stockDTOs;
	}

	@Transactional
	public String createTransactionData(TransactionDTO tDTO) {
		
		TransactionData tData = new TransactionData();
		tData.setTransactionType(tDTO.getTransactionType());
		Property property= propertyRepo.findByPropertyName(tDTO.getPropertyName());
		tData.setProperty(property);
		
		tData.setTransactionType(tData.getTransactionType());
		tData.setQuantity(tDTO.getQuantity());
		//-------- updating stock----------------
		String tranActionType=tData.getTransactionType();
		Stock stock= new Stock();
		stock=stockRepo.findByProperty(property);
		if (tranActionType.equalsIgnoreCase("buy") && stock!=null) {
			stock.setQuantityAvailable(stock.getQuantityAvailable()+tDTO.getQuantity());
			stockRepo.save(stock);
		}
		else if (tranActionType.equalsIgnoreCase("sell") && stock!=null) {
			if (stock.getQuantityAvailable()>tDTO.getQuantity()) {
				stock.setQuantityAvailable(stock.getQuantityAvailable()-tDTO.getQuantity());
				stockRepo.save(stock);
			}
			else {
				return "NO SUFFICIENT STOCKS TO SELL";
			}
		}
		else if (stock==null) {
			return "There is an error can't find the property in stocks ";
		}
		else {
			return "Please provide a valid Transaction Type Buy / Sell ";
		}
		
		//---------------------------------------
		tData.setQuantity(tDTO.getQuantity());
		tData.setPricePerUnit(tDTO.getPricePerUnit());
		tData.setDate(tDTO.getDate());
		//--------	customer detect / add ------
		if(tDTO.getCustomerPhNo()!=null && !tDTO.getCustomerPhNo().isEmpty() && !tDTO.getCustomerPhNo().isBlank())
		{
			Customer customer= new Customer();
		customer=customerRepo.findByPhNo(tDTO.getCustomerPhNo());
		if(customer==null) {
			System.out.println("new Customer, so adding the details to th Database");
				Customer customer2=new Customer();
				if (tDTO.getCustomerAddress()!=null && !tDTO.getCustomerAddress().isBlank() && !tDTO.getCustomerAddress().isEmpty()) 
				{
					customer2.setAddress(tDTO.getCustomerAddress());
				}
				if (tDTO.getCustomerName()!=null && !tDTO.getCustomerName().isBlank() && !tDTO.getCustomerName().isEmpty()) 
					{
						customer2.setName(tDTO.getCustomerName());
					}
					if (tDTO.getCustomerPhNo()!=null && !tDTO.getCustomerPhNo().isBlank() && !tDTO.getCustomerPhNo().isEmpty()) 
						{
							customer2.setPhNo(tDTO.getCustomerPhNo());
						}
				customerRepo.save(customer2);
				tData.setCustomer(customer2);
			}
		else {
			System.out.println("Old customer detected");
			tData.setCustomer(customer);
			}
		}
		//-----------------------------------------
		
		tData.setTransactionIdfromFE(tDTO.getTransactionIdfromFE());
		tData.setRemarks(tDTO.getRemarks());
		tData.setCurrentBuyPrice(tDTO.getCurrentBuyPriceFromFE());
		
		transactionDataRepo.save(tData);
		
		return "Transaction list created sucessfully";
	
	}

	@Transactional
	public String deleteTransactionData(TransactionDTO tDTO) {
		
		String propertyName=tDTO.getPropertyName();
		Property property = propertyRepo.findByPropertyName(propertyName);
		
	//	transactionDataRepo.deleteByProperty(property);
		transactionDataRepo.deleteByTransactionIdfromFE(tDTO.getTransactionIdfromFE());
		System.out.println("Transactions deleted successfully");
		Stock stock=stockRepo.findByProperty(property);
		if(tDTO.getTransactionType().equalsIgnoreCase("Buy")) {
			stock.setQuantityAvailable(stock.getQuantityAvailable()-tDTO.getQuantity());
			System.out.println("Stocks re-Reduced");
		}
		else {
			stock.setQuantityAvailable(stock.getQuantityAvailable()+tDTO.getQuantity());
			System.out.println("Stocks re-Added");
		}
		
		return "Transaction deleted successfully";
		
	}
	
	@Transactional
	public String updateTransactionData(TransactionDTO tDTO) {

		
		deleteTransactionData(tDTO);
		createTransactionData(tDTO);
		
		return"Transaction Data updated sucessfully";
		
	}

	public List<TransactionDTO> getTransactionData(){
		
		List<TransactionDTO> dtos=new ArrayList<>();
		List<TransactionData> tDatas=new ArrayList<>();
		tDatas=transactionDataRepo.findAll();
		TransactionDTO tDto=new TransactionDTO();
		for (TransactionData tData : tDatas) {
			tDto=new TransactionDTO();
			tDto.setPropertyName(tData.getProperty().getPropertyName());
			tDto.setTransactionType(tData.getTransactionType());
			tDto.setQuantity(tData.getQuantity());
			tDto.setPricePerUnit(tData.getPricePerUnit());
			tDto.setDate(tData.getDate());
			tDto.setCustomerName(tData.getCustomer().getName());
			tDto.setCustomerAddress(tData.getCustomer().getAddress());
			tDto.setCustomerPhNo(tData.getCustomer().getPhNo());
			tDto.setTransactionIdfromFE(tData.getTransactionIdfromFE());
			tDto.setRemarks(tData.getRemarks());
			tDto.setCurrentBuyPriceFromFE(tData.getCurrentBuyPrice());
			
			dtos.add(tDto);
			
		}
		
		return dtos;
		
	}
	
	public String createPriceTrackerData(PriceTrackerDTO pDto) {
		
		PriceTracker pTracker=new PriceTracker();
		pTracker.setCurrentBuyingPrice(pDto.getCurrentBuyingPrice());
		pTracker.setCurrentSellingPrice(pDto.getCurrentSellingPrice());
		pTracker.setDate(pDto.getDate());
		Property property=new Property();
		property=propertyRepo.findByPropertyName(pDto.getPropertyName());
		if (property!=null) {
			pTracker.setProperty(property);
		}
		else {
			return "No product found with this property name";
		}
		PriceTracker pTracker2=priceTrackerRepo.findByProperty(property);
		if (pTracker2!=null) {
			PriceTracker priceTracker=new PriceTracker();
			PriceTracker priceTrackerOld=new PriceTracker();
			priceTracker=priceTrackerRepo.findByProperty(property);
			priceTrackerOld=priceTracker;
			priceTracker.setCurrentBuyingPrice(pDto.getCurrentBuyingPrice());
			priceTracker.setCurrentSellingPrice(pDto.getCurrentSellingPrice());
			priceTracker.setDate(pDto.getDate());
			priceTracker.setProperty(property);
			priceTrackerRepo.save(priceTracker);
			
			
			PriceTrackerUpdate pTrackerUpdate=new PriceTrackerUpdate();
			pTrackerUpdate.setCurrentBuyingPrice(priceTrackerOld.getCurrentBuyingPrice());
			pTrackerUpdate.setCurrentSellingPrice(priceTrackerOld.getCurrentSellingPrice());
			pTrackerUpdate.setDate(priceTrackerOld.getDate());
			pTrackerUpdate.setPriceTracker(priceTrackerOld);
			pTrackerUpdate.setPropertyName(priceTrackerOld.getProperty().getPropertyName());
			priceTrackerUpdateRepo.save(pTrackerUpdate);
			return "Price was added before for this product so price history Updated succesfully";
			
			
		}
		else {
			PriceTrackerUpdate pTrackerUpdate=new PriceTrackerUpdate();
			pTrackerUpdate.setCurrentBuyingPrice(pTracker.getCurrentBuyingPrice());
			pTrackerUpdate.setCurrentSellingPrice(pTracker.getCurrentSellingPrice());
			pTrackerUpdate.setDate(pTracker.getDate());
			pTrackerUpdate.setPriceTracker(pTracker);
			pTrackerUpdate.setPropertyName(pTracker.getProperty().getPropertyName());
			priceTrackerUpdateRepo.save(pTrackerUpdate);
			
		priceTrackerRepo.save(pTracker);
		return "Price Added succesfully";
		}
		
	}

	public List<PriceTrackerDTO> getAllPrices(){

		List<PriceTrackerDTO> pDtos=new ArrayList<>();
		PriceTrackerDTO pDto=new PriceTrackerDTO();
		List<PriceTracker> pTrackers=new ArrayList<>();
		pTrackers=priceTrackerRepo.findAll();
		for (PriceTracker priceTracker : pTrackers) {
			pDto=new PriceTrackerDTO();
			pDto.setCurrentBuyingPrice(priceTracker.getCurrentBuyingPrice());
			pDto.setCurrentSellingPrice(priceTracker.getCurrentSellingPrice());
			pDto.setDate(priceTracker.getDate());
			pDto.setPropertyName(priceTracker.getProperty().getPropertyName());
			pDtos.add(pDto);		
		}
		return pDtos;
	}
	
	public List<PriceTrackerUpdateDTO> getAllPricesbyProperty(String propertyName) {

		Property property = new Property();
		property = propertyRepo.findByPropertyName(propertyName);
		List<PriceTrackerUpdateDTO> pDtos = new ArrayList<>();
		PriceTrackerUpdateDTO pUpdateDTO = new PriceTrackerUpdateDTO();
		List<PriceTrackerUpdate> pUpdates = new ArrayList<>();

		if (property != null) {
			pUpdates = priceTrackerUpdateRepo.findByPropertyName(propertyName);
			PriceTracker priceTracker = new PriceTracker();
			priceTracker = priceTrackerRepo.findByProperty(property);
			if (pUpdates != null) {
				for (PriceTrackerUpdate priceTrackerUpdate : pUpdates) {
					pUpdateDTO = new PriceTrackerUpdateDTO();

					pUpdateDTO.setCurrentBuyingPrice(priceTrackerUpdate.getCurrentBuyingPrice());
					pUpdateDTO.setCurrentSellingPrice(priceTrackerUpdate.getCurrentSellingPrice());
					pUpdateDTO.setDate(priceTrackerUpdate.getDate());
					pUpdateDTO.setPriceTrackerId(priceTracker.getPriceTrackerId());
					pUpdateDTO.setPropertyName(propertyName);

					pDtos.add(pUpdateDTO);
				}
			}
			return pDtos;
		}
		
		return pDtos;

	}

	
	
}
