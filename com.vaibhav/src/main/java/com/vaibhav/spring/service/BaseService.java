package com.vaibhav.spring.service;

import java.util.List;
import com.vaibhav.spring.model.Topic;

public interface BaseService {

	List<Topic> getAllTopics();

	Topic findOneTopic(String id);

	void addTopic(Topic topic);

	void updateTopic(Topic topic, String id);

	void deleteTopic(String id);

}
