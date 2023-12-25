package test;

import java.io.IOException;


import staff.Manager;
import student.Student;
import teacher.UrgencyLevel;
import utilities.News;

public class TestNews {
	public static void main(String[] args) throws IOException {
        News news1 = new News("Research 1", UrgencyLevel.HIGH, "Text 1");
        News news2 = new News("Research 2", UrgencyLevel.MEDIUM, "Text 2");
        News news3 = new News("Other News", UrgencyLevel.LOW, "Text 3");

// Добавляем данные в DataSingleton (предполагается, что у вас есть DataSingleton.INSTANCE)
        Manager m = new Manager();
        m.addNews(news1);
        m.addNews(news2);
        m.addNews(news3);
      
        Student s = new Student("Test", "Pest");
        System.out.println(s.viewNews());

	}
}