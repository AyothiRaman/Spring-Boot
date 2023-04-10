package com.Mapping.OneToManyMapping.Entity;


import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Builder;

@Entity
@Table(name="posts")

public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;
	
	
	// one post can have multiple comment so we use List
	@OneToMany(targetEntity = Comment.class, cascade = CascadeType.ALL)
	@JoinColumn(name="pc_id", referencedColumnName = "id")
	List<Comment> comments;
	
	
	public Post() {
		
	}


	public Post( String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public List<Comment> getComments() {
		return comments;
	}


	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

}
