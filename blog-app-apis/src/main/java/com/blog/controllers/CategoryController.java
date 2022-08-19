package com.blog.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.payloads.ApiResponse;
import com.blog.payloads.CategoryDto;
import com.blog.services.CategoryService;

@RestController
@RequestMapping("api/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	// Create
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto) {
		CategoryDto cat = this.categoryService.createCategory(categoryDto);
		return new ResponseEntity<CategoryDto>(cat, HttpStatus.CREATED);
	}

	// update
	@PutMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> updateCaregory(@Valid @RequestBody CategoryDto catgoryDto,
			@PathVariable Integer categoryId) {
		CategoryDto cat = this.categoryService.updateCategory(catgoryDto, categoryId);
		return ResponseEntity.ok(cat);
		// return new ResponseEntity<CategoryDto>(cat,HttpStatus.Ok);
	}

	// Delete
	@DeleteMapping("/{categoryId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer categoryId) {
		this.categoryService.deleteCategory(categoryId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("caregory Deleted Susscessfully", true), HttpStatus.OK);
	}

	// get by id
	@GetMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer categoryId) {
		CategoryDto cat = this.categoryService.getCategory(categoryId);
		return new ResponseEntity<CategoryDto>(cat, HttpStatus.OK);
	}

	// get all
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAllCategories() {
		List<CategoryDto> cat = this.categoryService.getCategories();
		return ResponseEntity.ok(cat);
	}

}
