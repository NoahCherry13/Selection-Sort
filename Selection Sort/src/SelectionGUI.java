import BreezySwing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SelectionGUI extends GBFrame implements ItemListener, FocusListener {

	JMenuItem addMI = addMenuItem("Menu", "Add Student");
	JMenuItem outputMI = addMenuItem("Menu", "Output");
	JMenuItem editMI = addMenuItem("Menu", "Edit Student");
	JButton meanButton = addButton ("Mean",2,1,1,1);
	JButton modeButton = addButton ("Mode",2,2,1,1);
	JButton medianButton = addButton ("Median",3,1,1,1);
	JButton sdButton = addButton ("Standard Deviation",3,2,1,1);
	ButtonGroup listOp = new ButtonGroup();
	JRadioButton sortNameButton = addRadioButton("Sort by Name", 1, 1, 1, 1);
	JRadioButton sortGradesButton = addRadioButton("Sort by Grades", 1, 2, 1, 1);
//	JTextArea ListArea = addTextArea("", 4, 1, 2, 1);
	JTextField FNameFld = addTextField("First Name", 1, 1, 1, 1);
	JTextField LNameFld = addTextField("Last Name", 2, 1, 1, 1);
	IntegerField gradeFld = addIntegerField(0, 1, 1, 1, 1);
	JComboBox options = addComboBox(1, 2, 1, 1);
	JList<String> StudentList = addList(4, 1, 2, 1);
	JButton EnterNameButton = addButton("Enter", 3, 1, 1, 1);
	JButton enterGradesButton = addButton("Enter Grade", 2, 1, 1, 1);
	ArrayList<Student> studentSList;
	ArrayList<Student> studentFList;
	ArrayList<Student> studentLList;
	AllStudents as = new AllStudents();
	Statistics s = new Statistics(as);
	int count = 0;
	int status;

	public SelectionGUI() {
		meanButton.setVisible(false);
		medianButton.setVisible(false);
		modeButton.setVisible(false);
		sdButton.setVisible(false);
		options.addItem("Test Grade");
		options.addItem("Quiz Grade");
		options.addItem("Homework Grade");
		FNameFld.addFocusListener(this);
		LNameFld.addFocusListener(this);
		sortNameButton.addItemListener(this);
		sortGradesButton.addItemListener(this);
		gradeFld.setVisible(false);
		listOp.add(sortNameButton);
		listOp.add(sortGradesButton);
		sortNameButton.setVisible(false);
		sortGradesButton.setVisible(false);
		LNameFld.setVisible(false);
//		ListArea.setVisible(false);
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
			status = 0;
			meanButton.setVisible(false);
			medianButton.setVisible(false);
			modeButton.setVisible(false);
			sdButton.setVisible(false);
			gradeFld.setVisible(false);
			sortNameButton.setVisible(false);
			sortGradesButton.setVisible(false);
			LNameFld.setVisible(true);
//			ListArea.setVisible(true);
			FNameFld.setVisible(true);
			StudentList.setVisible(true);
			EnterNameButton.setVisible(true);
			enterGradesButton.setVisible(false);
			sortNameButton.setVisible(false);
			sortGradesButton.setVisible(false);
			options.setVisible(false);
		} else if (mi == outputMI) {
			status = 1;
			meanButton.setVisible(true);
			medianButton.setVisible(true);
			modeButton.setVisible(true);
			sdButton.setVisible(true);
			gradeFld.setVisible(false);
			sortNameButton.setVisible(true);
			sortGradesButton.setVisible(true);
			LNameFld.setVisible(false);
//			ListArea.setVisible(true);
			FNameFld.setVisible(false);
			StudentList.setVisible(true);
			EnterNameButton.setVisible(false);
			enterGradesButton.setVisible(false);
			options.setVisible(false);

		} else if (mi == editMI) {
			populateListFName();
			status = 2;
			meanButton.setVisible(false);
			medianButton.setVisible(false);
			modeButton.setVisible(false);
			sdButton.setVisible(false);
			gradeFld.setVisible(true);
			sortNameButton.setVisible(false);
			sortGradesButton.setVisible(false);
			LNameFld.setVisible(false);
//			ListArea.setVisible(true);
			FNameFld.setVisible(false);
			StudentList.setVisible(true);
			EnterNameButton.setVisible(false);
			enterGradesButton.setVisible(true);
			sortNameButton.setVisible(false);
			sortGradesButton.setVisible(false);
			options.setVisible(true);
		}
	}

	public void buttonClicked(JButton b) {
		if (b == EnterNameButton) {
			if (FNameFld.getText().isEmpty() || LNameFld.getText().isEmpty()) {
				messageBox("Please Enter a First and Last Name");
				return;
			}
			if (count >= 15) {
				messageBox("Cannot enter more than 15 Students");
				return;
			}
			as.addStudent(new Student(FNameFld.getText(), LNameFld.getText()));
			count++;
			as.sortFName();
			setFList();
			populateListFName();

		} else if (b == enterGradesButton) {
			if (!gradeFld.isValidNumber()) {
				messageBox("Please Enter a Valid Grade");
				return;
			}
			if (StudentList.getSelectedIndex() == -1) {
				messageBox("Please Select a Student From the List to Edit");
			}
			if (options.getSelectedItem().equals("Test Grade")) {
				try {
					as.getFList().get(StudentList.getSelectedIndex()).addTestGrade(gradeFld.getNumber());
				} catch (GradeOverflowException e) {
					messageBox(e.getMessage());
				}
			} else if (options.getSelectedItem().equals("Quiz Grade")) {
				try {
					as.getFList().get(StudentList.getSelectedIndex()).addQuizGrade(gradeFld.getNumber());
				} catch (GradeOverflowException e) {
					messageBox(e.getMessage());
				}
			} else if (options.getSelectedItem().equals("Homework Grade")) {
					as.getFList().get(StudentList.getSelectedIndex()).addHWGrade(gradeFld.getNumber());
			}
		}else if(b == meanButton) {
			messageBox("The Mean is: "+ s.mean());
		}else if (b == modeButton) {
			String str = "";
			try {
				s.mode();
			
			for (int i = 0; i < s.getModeList().size(); i ++) {
				str+=((double)s.getModeList().get(i)+", ");
			}
			messageBox("The mode is: "+ str);
			str = "";
			} catch (InvalidModeException e) {
				// TODO Auto-generated catch block
				messageBox(e.getMessage());
			}
		}else if (b == medianButton) {
			messageBox("The Median is: "+ s.median());
		}else if (b == sdButton) {
			messageBox("The Standard Deviation is: "+ s.SD());
		}
	}

	private void populateListFName() {
		DefaultListModel DLM = new DefaultListModel();
		for (Student s : studentFList) {
			DLM.addElement(s.getFName()+" "+s.getLName());
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

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {

			if (sortNameButton.isSelected()) {
				setFList();
				populateListFName();
			} else if (sortGradesButton.isSelected()) {
				setSList();
				populateListScore();
			}
		}

	}

	@Override
	public void focusGained(FocusEvent e) {
		if (FNameFld.hasFocus()) {
			FNameFld.selectAll();
		} else if (LNameFld.hasFocus()) {
			LNameFld.selectAll();
		}

	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub

	}

}
