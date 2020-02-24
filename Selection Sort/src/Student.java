
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
	
	public void addQuizGrade(int qg) throws GradeOverflowException{
		quizCount ++;
		if (quizCount >8) {
			throw new GradeOverflowException("Too Many Quiz Scores");
		}
		quizGrade += qg;
	}
	
	public void addTestGrade(int tg) throws GradeOverflowException{
		testCount ++;
		if (testCount >5) {
			throw new GradeOverflowException("Too Many Test Scores");
		}
		testGrade += tg;
	}
	
	public void addHWGrade(int hg) {
		hwCount ++;
		hwGrade += hg;
	}
	
	public double calculateQuiz() {
		if (quizCount > 0) {
			return 0.3*(quizGrade/quizCount);
		}
		return 0;
	}
	
	public double calculateTest() {
		if (testCount > 0) {
			return 0.5*(testGrade/testCount);
		}
		return 0;
	}
	public double calculateHW() {
		if (hwCount > 0) {
			return 0.2*(hwGrade/hwCount);
		}
		return 0;
	}
	
	public double getAverage() {
		average = calculateTest()+calculateQuiz()+calculateHW();
		return average;
	}
	
	public String getFName() { 
		return firstName;
	}
	
	public String getLName() {
		return lastName;
	}
}
