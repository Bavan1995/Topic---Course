package com.timsheltech.sample.MyCourse;


import com.timsheltech.sample.MyApp.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class    CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/topic/{id}/courses", method = RequestMethod.GET)
    public List<CourseODTO> getAll(@PathVariable String id){
        return CourseConverter.convert(courseService.getAllCourses(id));
    }

    @RequestMapping(value = "/topic/{topicId}/courses/{id}", method = RequestMethod.GET)
    public Optional<Course> getById(@PathVariable String id ){
        return courseService.getCourse(id);
    }

    @RequestMapping(value = "/topic/{topicId}/course/", method = RequestMethod.POST)
    public void add(@RequestBody Course course,@PathVariable String topicId){
        Topic topic = new Topic();
        topic.setId(topicId);
        course.setTopic(topic);
        courseService.addCourse(course);
    }

    @RequestMapping(value = "/topic/{topicId}/course/{id}", method = RequestMethod.PUT)
    public void update(@RequestBody Course course,@PathVariable String topicId){
        course.setTopic(new Topic(topicId,"",""));
        courseService.updateCourse(course);
    }

    @RequestMapping(value = "/topic/{topicId}/course/{id}", method = RequestMethod.POST)
    public void delete(@PathVariable String id){
        courseService.deleteCourse(id);
    }
}
