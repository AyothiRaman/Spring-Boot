package com.ManyToManyMapping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ManyToManyMapping.entity.Post;
import com.ManyToManyMapping.entity.Tag;
import com.ManyToManyMapping.repository.PostRepository;
import com.ManyToManyMapping.repository.TagRepository;

@RestController
public class PostController {
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private TagRepository tagRepository;
	
	
	@PostMapping
	public Post savePostData(@RequestBody Post post) {
		return postRepository.save(post);
	}

	public Tag saveTagData(@RequestBody Tag tag) {
		return tagRepository.save(tag);
	}
}
