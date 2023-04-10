package com.Mapping.OneToManyMapping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Mapping.OneToManyMapping.Entity.Post;
import com.Mapping.OneToManyMapping.service.PostService;


@RestController
public class PostController {
	

	@Autowired
	private PostService postService;
	
	@GetMapping
	public List<Post>getAllData(){
		return postService.findPostData();
	}
	
	@PostMapping
	public Post savePodata(@RequestBody Post posts) {
		return postService.savePostData(posts);
	}


}
