package com.ishan.courseapi.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

//    private List<Topic> topicList = new ArrayList<>(Arrays.asList(
//            new Topic("spring","Spring Framework","Spring Framework Description"),
//            new Topic("java","Java","Java Description"),
//            new Topic("django","Django Framework","Django Description")
//    ));

    public List<Topic> getAllTopics(){
//        return topicList;
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public Optional<Topic> getTopic(String id){
//        return topicList.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return topicRepository.findById(id);
    }

    public void addTopic(Topic topic) {
//        topicList.add(topic);
        topicRepository.save(topic);
    }

    public void updateTopic(String id, Topic topic) {
//        for(int i=0;i<topicList.size();i++){
//            Topic t = topicList.get(i);
//            if(t.getId().equals(id)){
//                topicList.set(i,topic);
//                return;
//            }
//        }
        topicRepository.save(topic);
    }

    public void deleteTopic(String id) {
//        topicList.removeIf(t -> t.getId().equals(id));
        topicRepository.deleteById(id);
    }

}
