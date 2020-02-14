import BreezySwing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
	ArrayList<Student> studentSList;
	ArrayList<Student> studentFList;
	ArrayList<Student> studentLList;
	AllStudents as = new AllStudents();
	int count = 0;
	
	
	public SelectionGUI(){
		options.addItem("Test Grade");
		options.addItem("Quiz Grade");
		options.addItem("Homework Grade");
		listOp.add(sortNameButton);
		listOp.add(sortGradesButton);
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
	
	public void setFList() {
		studentFList = as.getFList();
	}
	
	public void setLList() {
		studentLList = as.getLList();
	}
	
	public void setSList() {
		studentSList = as.getSList();
	}
	
	public static void main(String[] args) {
		JFrame frm = new SelectionGUI();
		frm.setTitle("Ace Program");
		frm.setSize(500, 425);
		frm.setVisible(true);
	}

	public void menuItemSelected(JMenuItem mi) {
		if (mi == addMI) {
			sortNameButton.setVisible(false);
			sortGradesButton.setVisible(false);
			LNameFld.setVisible(true);
			ListArea.setVisible(true);
			FNameFld.setVisible(true);
			StudentList.setVisible(true);
			EnterNameButton.setVisible(true);
			enterGradesButton.setVisible(false);
			sortNameButton.setVisible(false);
			sortGradesButton.setVisible(false);
			options.setVisible(false);
		} else if (mi == outputMI) {
			sortNameButton.setVisible(true);
			sortGradesButton.setVisible(true);
			LNameFld.setVisible(false);
			ListArea.setVisible(true);
			FNameFld.setVisible(false);
			StudentList.setVisible(true);
			EnterNameButton.setVisible(false);
			enterGradesButton.setVisible(false);
			options.setVisible(false);
		}else if ()
	}
	
	public void buttonClicked(JButton b) {
		if (b == EnterNameButton) {
			if (FNameFld.getText().isEmpty()||LNameFld.getText().isEmpty()) {
				messageBox("Please Enter a First and Last Name");
				return;
			}
			if (count >= 15) {
				messageBox("Cannot enter more than 15 Students");
				return;
			}
			as.addStudent(new Student(FNameFld.getText(),LNameFld.getText()));
			count++;
			as.sortFName();
			setFList();
			populateListFName();
		}
	}
	
	private void populateListFName() {
		DefaultListModel DLM = new DefaultListModel();
		for (Student s : studentFList) {
			DLM.addElement(s.getFName());
		}
		StudentList.setModel(DLM);
	}

	private void populateListLName() {
		DefaultListModel DLM = new DefaultListModel();
		for (Student s : studentFList) {
			DLM.addElement(s.getLName());
		}
		StudentList.setModel(DLM);
	}
	
	private void populateListScore() {
		DefaultListModel DLM = new DefaultListModel();
		for (Student s : studentFList) {
			DLM.addElement(s.getAverage());
		}
		StudentList.setModel(DLM);
	}
	
	

}
