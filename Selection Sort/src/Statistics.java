import java.util.ArrayList;

public class Statistics {
	AllStudents as;
	ArrayList<Double> modeList;
	private ArrayList<Double> list = new ArrayList<Double>();

	public Statistics(AllStudents a) {
		as = a;
		for (Student s : as.getSList()) {
			list.add((double) s.getAverage());
		}

	}

	public double median() {
		list.clear();
		for (Student s : as.getSList()) {
			list.add((double) s.getAverage());
		}
		if (list.size() % 2 == 1) {
			return (double) list.get(list.size() / 2);
		} else {
			return (((double) (double) list.get(list.size() / 2) + (double) (double) (list.get(list.size() / 2 - 1))) / 2.0);
		}
	}

	public boolean inList(double d,ArrayList<Double> arr) {
		for (Double i: arr) {
			if ((double)i == d) {
				return true;
			}
		}
		return false;
	}
	
	public double mean() {
		list.clear();
		for (Student s : as.getSList()) {
			list.add((double) s.getAverage());
		}double sum = 0;
		for (Object o: list) {
			sum+=(double)o;
		}
		return (double)sum/(double)list.size();
	}
	
	public double SD () {
		list.clear();
		for (Student s : as.getSList()) {
			list.add((double) s.getAverage());
		}
		double average = mean();
		double total = 0;
		for (Object o: list) {
			total += Math.pow((double)o - average,2);
		}
		double av2 = total /list.size();
		return Math.sqrt(av2);
		
	}
	
	public ArrayList<Double> getModeList(){
		return modeList;
	}
	
	public void mode() throws InvalidModeException{
		list.clear();
		for (Student s : as.getSList()) {
			list.add((double) s.getAverage());
		}
		int count = 2;
		int oc = 0;
		modeList = new ArrayList<Double>();
		modeList.clear();
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.size(); j++) {
				if ((double) list.get(i) == (double) list.get(j) && !inList((double) list.get(i), modeList)) {
					oc++;
				}
			}
			if (oc > count) {
				modeList.clear();
				modeList.add((Double) list.get(i));
				count = oc;
				oc = 0;
			} else if (oc == count) {
				oc = 0;
				modeList.add((Double) list.get(i));
			}
			oc = 0;
		}
		if (modeList.size() == 0) {
			throw new InvalidModeException("There is no Mode");
		}
	}
}
