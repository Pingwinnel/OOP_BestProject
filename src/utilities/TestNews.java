package utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import staff.Manager;
import teacher.UrgencyLevel;

public class TestNews {
	public static void main(String[] args) {
        News news1 = new News("Research 1", UrgencyLevel.HIGH, "Text 1", null);
        News news2 = new News("Research 2", UrgencyLevel.MEDIUM, "Text 2", null);
        News news3 = new News("Other News", UrgencyLevel.LOW, "Text 3", null);

        // Добавляем данные в DataSingleton (предполагается, что у вас есть DataSingleton.INSTANCE)
        DataSingleton.INSTANCE.getNews().add(news1);
        DataSingleton.INSTANCE.getNews().add(news2);
        DataSingleton.INSTANCE.getNews().add(news3);
        
        Manager m1 = new Manager();
        System.out.println(m1.sortNews());
	}
}