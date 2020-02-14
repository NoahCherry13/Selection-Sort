import BreezySwing.*;
import javax.swing.*;
public class InputDialog extends GBDialog{

	IntegerField inputArea = addIntegerField(0, 2, 1, 1, 1);
	private int status;
	JLabel iLbl = addLabel("",1,1,1,1);
	
	public InputDialog(JFrame parent,int s) {
		super(parent);
		status = s;
		setLabel();
	}
	
	public void setLabel() {
		if (status==0) {
			iLbl.setText("Enter a Test Grade");
		}else if (status == 1) {
			iLbl.setText("Enter a Quiz Grade");
		}else if (status==2) {
			iLbl.setText("Enter a Homework Grade");
		}
	}
	
	
}
