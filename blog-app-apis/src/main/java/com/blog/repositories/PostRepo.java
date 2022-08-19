package com.blog.repositories;

import java.util.List;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import com.blog.entities.Category;
import com.blog.entities.Post;
import com.blog.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer> {

//	//custom finder methods

	List<Post> findByUser(User user);

//	

	List<Post> findByCategory(Category category);

	Page<Post> findByCategory(Category category, Pageable pageable);

	List<Post> findByTitleContaining(String Title);

//	@Query("select p from Post p wherep.title like : key")
//	List<Post> findByTitle(@Param("key") String title);
//	

}
