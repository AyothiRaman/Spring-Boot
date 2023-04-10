package com.Mapping.OneToManyMapping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Mapping.OneToManyMapping.Entity.Comment;
import com.Mapping.OneToManyMapping.Entity.Post;
import com.Mapping.OneToManyMapping.service.CommentService;

@RestController
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	public Comment savePodata(@RequestBody Comment com) {
		return commentService.saveData(com);
	}
}
