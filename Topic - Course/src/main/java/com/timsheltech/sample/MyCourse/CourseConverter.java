package com.timsheltech.sample.MyCourse;

import java.util.ArrayList;
import java.util.List;

public class CourseConverter {
    public static List<CourseODTO> convert(List<Course> courses){
        List<CourseODTO> response  = new ArrayList<>();
        for(Course course: courses){
            CourseODTO odto = new CourseODTO();
            odto.setId(course.getId());
            odto.setName(course.getName());
            odto.setDescription(course.getDescription());
            odto.setTopicId(course.getTopic().getId());
            response.add(odto);
        }
        return response;
    }
}
