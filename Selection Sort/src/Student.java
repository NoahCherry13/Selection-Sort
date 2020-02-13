
public class Student {

	private String firstName;
	private String lastName;
	private double quizGrade = 0;
	private double testGrade = 0;
	private double hwGrade = 0;
	private double average = 0;
	private double quizCount = 0;
	private double hwCount = 0;
	private double testCount = 0;
	public Student(String FN, String LN) {
		lastName = LN;
		firstName = FN;
	}
	
	public Student() {
		
	}
	
	public void addQuizGrade(int qg) {
		quizCount ++;
		quizGrade += qg;
	}
	
	public void addTestGrade(int tg) {
		testCount ++;
		testGrade += tg;
	}
	
	public void addHWGrade(int hg) {
		hwCount ++;
		hwGrade += hg;
	}
	
	public double getAverage() {
		average = 0.5*(testGrade/testCount)+0.3*(quizGrade/quizCount)+0.2*(hwGrade/hwCount);
		return average;
	}
	
	public String getFName() { 
		return firstName;
	}
	
	public String getLName() {
		return lastName;
	}
}
