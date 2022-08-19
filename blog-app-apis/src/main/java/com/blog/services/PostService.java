package com.blog.services;

import java.util.List;
import com.blog.payloads.PostDto;
import com.blog.payloads.PostResponse;

public interface PostService {
	
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
	
	PostDto updatePost(PostDto postDto, Integer postId);
	
	void deletePost(Integer postId);
	
	PostResponse getAllPosts(Integer pageNumber,Integer pageSize, String sortBy,String sortDirection);
	
	PostDto getPostById(Integer postId);
	
	PostResponse getPostsByCategory(Integer categoryid, Integer pageNumber,Integer pageSize);
	
	//get all posts by user
	List<PostDto> getPostsByUser(Integer userId);
	
	//Search Post
	List<PostDto> searchPost(String keyword);
	
}
