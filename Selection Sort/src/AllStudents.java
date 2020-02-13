import java.util.ArrayList;

public class AllStudents {

	private ArrayList<Student> studentList = new ArrayList<Student>();

	public void sortGrades() {
		
		int n = studentList.size();
		
		for (int i = 0; i < n - 1; i++) {

			int min_idx = i;
			for (int j = i + 1; j < n; j++) {
				if (studentList.get(j).getAverage() <studentList.get(min_idx).getAverage())
					min_idx = j;
			}

			Student temp = studentList.get(min_idx);
			studentList.set(min_idx, studentList.get(i));
			studentList.set(i, temp);
		}
	}
	
	public void sortName() {


		int n = studentList.size();
		
		for (int i = 0; i < n - 1; i++) {

			int min_idx = i;
			for (int j = i + 1; j < n; j++) {
				if (studentList.get(j).getFName() <studentList.get(min_idx).getFName());
					min_idx = j;
			}

			Student temp = studentList.get(min_idx);
			studentList.set(min_idx, studentList.get(i));
			studentList.set(i, temp);
		}
	}

}
