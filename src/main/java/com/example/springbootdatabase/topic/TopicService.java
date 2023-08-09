package com.example.springbootdatabase.topic;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    private List<Topics> topicsList = new ArrayList<>(Arrays.asList(
            new Topics("spring","Spring Framework","Spring Framework Description"),
            new Topics("java","Java Core","Java Core Description"),
            new Topics("javaScript","JavaScript","Javascript Description")
    ));

    public List<Topics> getAllTopics(){
        return topicsList;
    }

    /* Method Service to getTopicsById using Lambda Function Stream, Filter ,FindFirst */
    public Topics getTopicById(String id){
        return topicsList.stream().filter(topics -> topics.getId().equals(id)).findFirst().get();
    }

    public void addTopics(Topics topics) {
        topicsList.add(topics);
    }

    public void updateTopic(String id, Topics topics) {
       /*  for ( int i = 0; i < topicsList.size(); i++){
            Topics t = topicsList.get(i);
            if(t.getId().equals(id)){
                topicsList.set(i,topics);
                return;
            }
        } */
        /* Lambda Function */
        topicsList.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .ifPresent(t -> topicsList.set(topicsList.indexOf(t), topics));

    }

    public void deleteTopic(String id) {
        topicsList.removeIf(topics -> topics.getId().equals(id));
    }
}
