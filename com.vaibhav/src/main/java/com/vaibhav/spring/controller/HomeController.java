package com.vaibhav.spring.controller;

import java.util.List;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vaibhav.spring.model.Topic;
import com.vaibhav.spring.service.BaseService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;


@RestController
public class HomeController {
	
	final private String HOME = "/";
	final private String TOPIC = "/topics";
	final private String TOPIC_BY_ID = "/topics/{id}";
	
	@Autowired
	private BaseService baseService;
	
	
	@RequestMapping(value = HOME, method = RequestMethod.GET)
	public String getHello(){
		return "Hello There !";
	}
	
	@RequestMapping(value = TOPIC, method = RequestMethod.GET)
	public List<Topic> getAllTopic(){
		return baseService.getAllTopics();
	}
	
	@RequestMapping(value = TOPIC_BY_ID, method = RequestMethod.GET)
	public Topic findOneTopic(@PathVariable String id) {
		return baseService.findOneTopic(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = TOPIC)
	public void addTopic(@RequestBody Topic topic) {
		 baseService.addTopic(topic);
	}
	
	@PUT
	@Path(value=TOPIC_BY_ID)
	@CrossOrigin
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		 baseService.updateTopic(topic, id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = TOPIC_BY_ID)
	public void deleteTopic(@PathVariable String id) {
		 baseService.deleteTopic(id);
	}

}
