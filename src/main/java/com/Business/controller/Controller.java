package com.Business.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Business.DTO.CategoryDTO;
import com.Business.DTO.PriceTrackerDTO;
import com.Business.DTO.PriceTrackerUpdateDTO;
import com.Business.DTO.PropertyDTO;
import com.Business.DTO.StockDTO;
import com.Business.DTO.SubCategoryDTO;
import com.Business.DTO.TransactionDTO;
import com.Business.service.DaoService;


@RestController
@RequestMapping("/api")
public class Controller {
	
	@Autowired
	DaoService daoService;
	
	   @PostMapping("/createCatagory")
	    public ResponseEntity<String> createCatagory(@RequestBody CategoryDTO catagoryDto) {
	    String msg	=  daoService.createCatagory(catagoryDto);
	        return ResponseEntity.ok(msg);
	}
	   
	   @GetMapping("/getCategories")
	   public ResponseEntity<List<CategoryDTO>> getCategories(){
		   
		   List<CategoryDTO> categoryDTOs=daoService.getCategories();
		   return ResponseEntity.ok(categoryDTOs);
	   }
	   
	   @PostMapping("/createSubCatagory")
	   public ResponseEntity<String> createSubCatagory(@RequestBody SubCategoryDTO subCategoryDTO) {
		    String msg	=  daoService.createSubCategory(subCategoryDTO);
		        return ResponseEntity.ok(msg);
		}
	   
	   @GetMapping("/getSubCategories")
	   public ResponseEntity<List<SubCategoryDTO>> getSubCategories(){	   
		   List<SubCategoryDTO> subCategoryDTOs=daoService.getAllSubCategories();
		   return ResponseEntity.ok(subCategoryDTOs);
	   }
	   
	   @PostMapping("/getSubCategoriesByCategory")
	   public ResponseEntity<List<SubCategoryDTO>> getSubCategoriesByCategory(@RequestBody CategoryDTO categoryDTO){	   
		   List<SubCategoryDTO> subCategoryDTOs=daoService.getAllSubCategoryFromAcategory(categoryDTO);
		   return ResponseEntity.ok(subCategoryDTOs);
	   }
	   
	   @PostMapping("/getAllSubCategoryFromAcategoryAsList")
	    public ResponseEntity<List<String>> getAllSubCategoryFromAcategoryAsList(@RequestBody CategoryDTO catagoryDto) {
		   List<String> msg	=  daoService.getAllSubCategoryFromAcategoryAsList(catagoryDto);
	        return ResponseEntity.ok(msg);
	}
	   
	   @PostMapping("/createProperty")
	   public ResponseEntity<String> createProperty(@RequestBody PropertyDTO propertyDTO) {
		    String msg	=  daoService.createProperty(propertyDTO);
		        return ResponseEntity.ok(msg);
		}

	   @GetMapping("/getProperties")
	   public ResponseEntity<List<PropertyDTO>> getProperties(){	   
		   List<PropertyDTO> propertyDTOs=daoService.getProperties();
		   return ResponseEntity.ok(propertyDTOs);
	   }
	   
	   @GetMapping("/getStocks")
	   public ResponseEntity<List<StockDTO>> getStocks(){	   
		   List<StockDTO> stockDTOs=daoService.getStocks();
		   return ResponseEntity.ok(stockDTOs);
	   }
	   
	   @PostMapping("/createTransactionData")
	   public ResponseEntity<String> createTransactionData(@RequestBody TransactionDTO tDTO) {
		    String msg	=  daoService.createTransactionData(tDTO);
		        return ResponseEntity.ok(msg);
		}

	   @DeleteMapping("/deleteTransactionData")
	   public ResponseEntity<String> deleteTransactionData(@RequestBody TransactionDTO tDTO) {
		    String msg	=  daoService.deleteTransactionData(tDTO);
		        return ResponseEntity.ok(msg);
		}
	   
	   @PutMapping("/updateTransactionData")
	   public ResponseEntity<String> updateTransactionData(@RequestBody TransactionDTO tDTO) {
		    String msg	=  daoService.updateTransactionData(tDTO);
		        return ResponseEntity.ok(msg);
		}
	   
	   @GetMapping("/getTransactionData")
	   public ResponseEntity<List<TransactionDTO>> getTransactionData(){		   
		   List<TransactionDTO> tDtos= new ArrayList<>();
		   tDtos=daoService.getTransactionData();
		   return ResponseEntity.ok(tDtos);
		   
	   }	
	   
	   @PostMapping("/createPriceTrackerData")
	   public ResponseEntity<String> createPriceTrackerData(@RequestBody PriceTrackerDTO pDto) {
		    String msg	=  daoService.createPriceTrackerData(pDto);
		        return ResponseEntity.ok(msg);
		}
	   
	   @GetMapping("/getAllPrices")
	   public ResponseEntity<List<PriceTrackerDTO>> getAllPrices(){		   
		   List<PriceTrackerDTO> tDtos= new ArrayList<>();
		   tDtos=daoService.getAllPrices();
		   return ResponseEntity.ok(tDtos);
		   
	   }
	   
	   @PostMapping("/getAllPricesbyProperty")
	   public ResponseEntity<List<PriceTrackerUpdateDTO>> getAllPricesbyProperty(@RequestBody String propertyName) {
		   List<PriceTrackerUpdateDTO> pList	=  daoService.getAllPricesbyProperty(propertyName);
		        return ResponseEntity.ok(pList);
		}

}
