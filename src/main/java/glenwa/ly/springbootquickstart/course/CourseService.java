package glenwa.ly.springbootquickstart.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;

/*	private List<Topic> Courses = new ArrayList<>(
			Arrays.asList(new Topic("1", "Nalin", "The owner"), new Topic("2", "All", "The users")

			));*/

	public List<Course> getAllCourses(String topicId) {
		List<Course> Courses = new ArrayList<>();
	
		courseRepository.findByTopicId(topicId).forEach(Courses::add);
		return Courses;
	}	
	

	public void addCourse(Course course) {
		courseRepository.save(course);
	}

	public Optional<Course> getCourse(String id) {
//		return Courses.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return courseRepository.findById(id);
	}
	
	public void updateCourse(Course course) {

/*		for (int i = 0; i < Courses.size(); i++) {
			Topic t = Courses.get(i);
System.out.println("In : " + t.getId());
System.out.println("id : " + id);
			if (t.getId().equals(id)) {
				System.out.println("In if" + i );

				Courses.set(i, topic);
				return;
			}
		}*/
		
		courseRepository.save(course);
	}

	public void deleteCourse(String id) {
//		Courses.removeIf(t-> t.getId().equals(id));
		courseRepository.deleteById(id);
	}

//	public void setCourses(List<Topic> Courses) {
//		this.Courses = Courses;
//	}
}
