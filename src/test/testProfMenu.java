package test;

import MenuPages.ProfessorMenu;
import student.Schools;
import teacher.Professor;

public class testProfMenu {

	public static void main(String[] args) {
        Professor professor = new Professor("Djumadildaev", "Askar", 480000.0, Schools.SAM);
        ProfessorMenu professorMenu = new ProfessorMenu(professor, null);
        professorMenu.run();
	}

}
