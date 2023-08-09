package com.example.springbootdatabase.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;  // Created Instance of Class Service

    @RequestMapping("/topics")
    public List<Topics> getAllTopics(){

        return topicService.getAllTopics();
    }

    @RequestMapping("/topics/{id}")    //Added {id} for the path
    public Topics getInfoById(@PathVariable String id){         // @PathVariable knows the "id" that we are expecting info
        return topicService.getTopicById(id);
    }
    /*
    POST Request Method for adding Topic in JSON
    @Request Method Important or else it will add null to the list
     */
    @RequestMapping(method = RequestMethod.POST , value = "/topics")
    public void addTopic(@RequestBody Topics topics){
        topicService.addTopics(topics);
    }

    @RequestMapping(method = RequestMethod.PUT , value = "/topics/{id}")
    public void updateTopic(@RequestBody Topics topics,@PathVariable String id){
        topicService.updateTopic(id,topics);
    }

    @RequestMapping(method = RequestMethod.DELETE , value = "topics/{id}")
    public void deleteTopic(@PathVariable String id){
        topicService.deleteTopic(id);
    }
}
