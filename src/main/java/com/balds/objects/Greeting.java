package com.balds.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Greeting {

	private long id;
	private String content;
	
	public Greeting() {
		this.setId(-1);
		this.setContent("I\'m the content");	
	}
	
	public Greeting(long id, @JsonProperty("content") String content) {
		this.setId(id);
		this.setContent(content);	
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
