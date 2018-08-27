package com.timsheltech.sample.MyApp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TopicController {

    @Autowired
    TopicService topicService;
    @RequestMapping(value = "/alltopics",method = RequestMethod.GET)
    public List<Topic> returnTopic(){
        return topicService.getAllTopics();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Optional<Topic> getTopicById(@PathVariable String id){
        return topicService.getTopic(id);
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public void addTopicToDb(@RequestBody Topic topic){
        topicService.addTopic(topic);
    }

    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
    public void update(@RequestBody Topic topic,@PathVariable String id){
        topicService.updateTopic(topic,id);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id){
        topicService.deleteTopic(id);
    }
}
