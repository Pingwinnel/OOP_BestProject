package test;

import java.io.IOException;


import staff.Manager;
import student.Student;
import teacher.UrgencyLevel;
import utilities.News;

public class TestNews {
	public static void main(String[] args) throws IOException {
        News news1 = new News("Research 1", UrgencyLevel.HIGH, "Text 1", null);
        News news2 = new News("Research 2", UrgencyLevel.MEDIUM, "Text 2", null);
        News news3 = new News("Other News", UrgencyLevel.LOW, "Text 3", null);

        // Добавляем данные в DataSingleton (предполагается, что у вас есть DataSingleton.INSTANCE)
//        DataSingleton.INSTANCE.addNews(news3);
//        DataSingleton.INSTANCE.addNews(news2);
//        DataSingleton.INSTANCE.addNews(news1);
//       
        
        Manager m1 = new Manager();

//        System.out.println(m1.viewNews());

//        System.out.println(m1.sortNews());
        //good job, Tuba, ap-barekeldi
        
        Student s = new Student("Test", "Pest");
        System.out.println(s.viewNews());

	}
}