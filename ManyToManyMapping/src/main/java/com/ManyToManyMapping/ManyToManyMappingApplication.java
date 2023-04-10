package com.ManyToManyMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ManyToManyMapping.entity.Post;
import com.ManyToManyMapping.entity.Tag;
import com.ManyToManyMapping.repository.PostRepository;

@SpringBootApplication
public class ManyToManyMappingApplication  implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ManyToManyMappingApplication.class, args);
	}

	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Post post = new Post("image", "insta", "feed");
		
		Tag tag = new Tag("FaceBook");
		Tag tag1 = new Tag("Messanger");
		Tag tag2 = new Tag("telegram");
		
		// add tag references post
		post.getTags().add(tag);
		post.getTags().add(tag1);
		post.getTags().add(tag2);
		
		//add post reference to post
		tag.getPosts().add(post);
		tag1.getPosts().add(post);
		tag2.getPosts().add(post);
		
		postRepository.save(post);
		
	}

}
