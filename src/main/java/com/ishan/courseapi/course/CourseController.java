package com.ishan.courseapi.course;

import com.ishan.courseapi.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/topics/{topicId}/courses")
    public List<Course> getAllCourses(@PathVariable String topicId){
        return courseService.getAllCourses(topicId);
    }

    @RequestMapping("/topics/{topicId}/courses/{courseId}")
    public Optional<Course> getCourse(@PathVariable("topicId") String topicId,
                                      @PathVariable("courseId") String courseId){
        return courseService.getCourse(courseId);
    }

    @RequestMapping(method = RequestMethod.POST, value="/topics/{topicId}/courses")
    public void addCourse(@RequestBody Course course, @PathVariable("topicId") String topicId){
        course.setTopic(new Topic(topicId,"",""));
        courseService.addCourse(course);
    }

    @RequestMapping(method = RequestMethod.PUT, value="/topics/{topicId}/courses/{courseId}")
    public void updateCourse(@RequestBody Course course, @PathVariable("topicId") String topicId){
        course.setTopic(new Topic(topicId,"",""));
        courseService.updateCourse(course);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/topics/{tokenId}/courses/{courseId}")
    public void deleteCourse(@PathVariable("courseId") String courseId){
        courseService.deleteCourse(courseId);
    }
}
