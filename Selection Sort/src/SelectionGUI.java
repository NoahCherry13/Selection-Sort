import BreezySwing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



public class SelectionGUI extends GBFrame{
	
	JMenuItem addMI = addMenuItem("Menu", "Add Student");
	JMenuItem outputMI = addMenuItem("Menu", "Output");
	JMenuItem editMI = addMenuItem("Menu", "Edit Student");
	ButtonGroup listOp = new ButtonGroup();
	JRadioButton sortNameButton = addRadioButton("Sort by Name", 1, 1, 1, 1);
	JRadioButton sortGradesButton = addRadioButton("Sort by Grades", 1, 2, 1, 1);
	JTextArea ListArea = addTextArea("", 4, 1, 2, 1);
	JTextField FNameFld = addTextField("First Name", 1, 1, 1, 1);
	JTextField LNameFld = addTextField("Last Name", 2, 1, 1, 1);
	JComboBox options = addComboBox(1, 2, 1, 1);
	JList<String> StudentList = addList(4, 1, 2, 1);
	JButton EnterNameButton = addButton("Enter",3,1,1,1);
	JButton enterGradesButton = addButton("Enter Grade",2,1,1,1);

	public SelectionGUI(){
		options.addItem("Test Grade");
		options.addItem("Quiz Grade");
		options.addItem("Homework Grade");
		sortNameButton.setVisible(false);
		sortGradesButton.setVisible(false);
		LNameFld.setVisible(false);
		ListArea.setVisible(false);
		FNameFld.setVisible(false);
		StudentList.setVisible(false);
		EnterNameButton.setVisible(false);
		enterGradesButton.setVisible(false);
		sortNameButton.setVisible(false);
		sortGradesButton.setVisible(false);
		options.setVisible(false);
	}
	
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
