package test;

import MenuPages.ProfessorMenu;
import student.Schools;
import teacher.Professor;

public class testProfMenu {

	public static void main(String[] args) {
        Professor professor = new Professor("Smith", "John", 80000.0, Schools.SITE);
        ProfessorMenu professorMenu = new ProfessorMenu(professor, null);
        professorMenu.run();
	}

}
