package com.springActuator.endPoint;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id="release-notes")
public class CustomEndpoint {
	
	Map<String, List<String>> releaseNoteMap = new LinkedHashMap<>();
	
	@PostConstruct
	public void initNotes() {
		releaseNoteMap.put("version 1", Arrays.asList("home page created successfully"));
	}
	
	@ReadOperation
	public Map<String,List<String>> getReleaaseNote(){
		return releaseNoteMap;
	}

}
