package com.Mapping.OneToManyMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.Mapping.OneToManyMapping.Entity.Comment;
import com.Mapping.OneToManyMapping.Entity.Post;
import com.Mapping.OneToManyMapping.repository.PostRepository;

@SpringBootApplication
public class OneToManyMappingApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(OneToManyMappingApplication.class, args);
	}

	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {

//		Post post = new Post();
//		post.setTitle("one to many mapping demo");
//		post.setDescription("good move");
//
//		Comment comment1 = new Comment("good");
//		Comment comment2 = new Comment("beauty");
//		Comment comment3 = new Comment("nice");
//
//		post.getComments().add(comment1);
//		post.getComments().add(comment2);
//		post.getComments().add(comment3);
//
//		postRepository.save(post);
	}

}
