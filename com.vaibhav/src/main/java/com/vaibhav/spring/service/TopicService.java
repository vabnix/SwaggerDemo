package com.vaibhav.spring.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;
import com.vaibhav.spring.model.Topic;

@Service
public class TopicService implements BaseService {
	
	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("1", "Vaibhav Srivastava", "Lives in Dallas Texas"),
			new Topic("2", "Pallavi Chakraborty", "Lives in Dallas Texas"),
			new Topic("3", "Aum C Srivastava", "Lives in Dallas Texas")));

	@Override
	public List<Topic> getAllTopics() {
		return topics;
	}

	@Override
	public Topic findOneTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}


	public void addTopic(Topic topic) {
		topics.add(topic);
		
	}

	@Override
	public void updateTopic(Topic topic, String id) {
		for(Topic updateTopic : topics) {
			if(updateTopic.getId().equals(id)) {
				updateTopic.setName("Tanvi Srivastava");
			}
		}
		
	}

	@Override
	public void deleteTopic(String id) {
		topics.removeIf(t -> t.getId().equals(id));
	}
}
