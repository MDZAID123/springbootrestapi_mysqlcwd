package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;


@Service
public class CourseServiceimpl implements CourseService {
	
	
	
//	note that we cannot make an object of an interface
//	 
//	variable
	@Autowired
	private CourseDao courseDao;
	
	
//	List<Course>list;
	public CourseServiceimpl() {
//		this is the constructor of this class
//		list=new ArrayList<>();
//		list.add(new Course(145,"Java core Course","this course"));	
//		list.add(new Course(4343,"spring boot course","creating "));
		
		
	
	
	}

	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		return courseDao.findAll();
	}

	@SuppressWarnings("deprecation")
	@Override
	public Course getCourse(long courseId) {
		// TODO Auto-generated method stub
		
//		Course c=null;
//		for (Course course:list) {
//			if(course.getId()==courseId) {
//				c=course;
//				break;
//			}
//		}
//		return c;
		return courseDao.getById(courseId);
	}

	@Override
	public Course addCourse(Course course) {
		// TODO Auto-generated method stub
//		list.add(course);
		courseDao.save(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		// TODO Auto-generated method stub
//		list.forEach(e->{
//			if(e.getId()== course.getId()) {
//				e.setTitle(course.getTitle());
//				e.setDescription(course.getDescription());
//			}
//		});
		courseDao.save(course);
		return course;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void deleteCourse(long parseLong) {
//		list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
		// TODO Auto-generated method stub
//		for deleting we need to load the entity from courseDao
		Course entity=courseDao.getOne(parseLong);
		courseDao.delete(entity);
		
	}

}
