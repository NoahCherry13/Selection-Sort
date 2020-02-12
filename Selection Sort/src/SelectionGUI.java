import BreezySwing.*;

import javax.swing.*;

public class SelectionGUI extends GBFrame {

	JMenuItem addMI = addMenuItem("Menu", "Add Student");
	JMenuItem outputMI = addMenuItem("Menu", "Output");
	ButtonGroup listOp = new ButtonGroup();
	JRadioButton og = addRadioButton("Sort by Name", 3, 1, 1, 1);
	JRadioButton sorted = addRadioButton("Sort by Grades", 3, 2, 1, 1);
	JTextArea ListArea = addTextArea("", 4, 1, 2, 1);
	JTextField FNameFld = addTextField("First Name", 1, 1, 1, 1);
	JTextField LNameFld = addTextField("Last Name", 2, 1, 1, 1);
	JList<String> StudentList = addList(2, 1, 1, 1);

	public static void main(String[] args) {
		JFrame frm = new SelectionGUI();
		frm.setTitle("Ace Program");
		frm.setSize(500, 425);
		frm.setVisible(true);
	}

	public void menuItemSelected(JMenuItem mi) {
		if (mi == addMI) {

		} else if (mi == outputMI) {

		}
	}
	
	private void populateList() {
		DefaultListModel DLM = new DefaultListModel();
		for (Books b : books) {
			DLM.addElement(b.getTitle());
		}
		bookList.setModel(DLM);
	}

}
