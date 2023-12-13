package Student;

import java.io.Serializable;
import java.util.HashSet;

public class Course implements Serializable {
 String name;
 String code;
 Schools school;
 Integer credits;
 HashSet<Course> prerequisities;
 
 
}
