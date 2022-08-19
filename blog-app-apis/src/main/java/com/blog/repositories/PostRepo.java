package com.blog.repositories;

import java.util.List;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.blog.entities.Category;
import com.blog.entities.Post;
import com.blog.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer> {

//	//custom finder methods
	@Query
	List<Post> findByUser(User user);

//	
	@Query
	List<Post> findByCategory(Category category);
	
	Page<Post> findByCategory(Category category,Pageable pageable);

}
