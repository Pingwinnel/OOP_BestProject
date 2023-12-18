package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import staff.Manager;
import teacher.UrgencyLevel;
import utilities.DataSingleton;
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
<<<<<<< HEAD
        System.out.println(m1.viewNews());
=======
//        System.out.println(m1.sortNews());
        //good job, Tuba
        
        System.out.println(DataSingleton.INSTANCE.getNews());
>>>>>>> 2f1010d4573164c258b49ce0e49451f52c5b16ef
	}
}