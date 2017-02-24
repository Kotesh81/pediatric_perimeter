package application;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.text.*;

public class Patient_Info 
{
		static String patient_name, patient_MR, patient_dob,
				patient_milestone_details, patient_OTC;

		public Patient_Info() {
			String workingDirectory = "E:\\Sonu_16thDec\\New_GUI\\PediPeri_MainScreen\\src\\application\\";
			String arduino = "", cam = "";
			JLabel lbl1, lbl2, lbl3, lbl4, lbl5;
			JTextField pname, pMR, pdob, pmilestone_details, potc;
			JPanel labels, btn;
			JFrame det = new JFrame();
			det.setSize(850, 640);
			JPanel panel = new JPanel();
			panel.setSize(850,640);
			panel.setLayout(new GridLayout(4, 1));
			JLabel ard = new JLabel("Arduino");
			JLabel camc = new JLabel("Camera");
			// 198-512.png

			JPanel hd = new JPanel();
			hd.setLayout(null);

			Label cap = new Label("Patients Info", Label.CENTER);
			cap.setFont(new Font("Serif", Font.BOLD, 30));
			cap.setForeground(Color.BLACK);

			cap.setLocation(240, 40);
			cap.setSize(250, 90);
			String path1 = workingDirectory + "Red.png";
			String path2 = workingDirectory + "Green.png";
			ImageIcon red, grn;
						
			if (arduino == null) {
				red = new ImageIcon(path1);
			} else {
				red = new ImageIcon(path2);
			}

			if (cam == null) {
				grn = new ImageIcon(path1);
			} else {
				grn = new ImageIcon(path2);
			}
			
			JLabel red1 = new JLabel();
			red1.setIcon(red);
			red1.setLocation(630, 40);
			red1.setSize(10, 10);
			JLabel grn1 = new JLabel(grn);
			grn1.setLocation(630, 25);
			grn1.setSize(10, 10);
			
			hd.add(red1);
			hd.add(grn1);
			hd.add(cap);
			ard.setLocation(650, 20);
			ard.setSize(160, 20);
			camc.setLocation(650, 35);
			camc.setSize(60, 20);
			hd.add(ard);
			hd.add(camc);

			panel.add(hd);

			lbl1 = new JLabel("Patient Name");
			lbl2 = new JLabel("MR Number");
			lbl3 = new JLabel("Date of Birth (dd/mm/yy)");
			lbl4 = new JLabel("Milestone details");
			lbl5 = new JLabel("Occipital Distance (0 - 28 cm)");

			pname = new JTextField(10);
			// pMR = new JTextField(10);
			pMR = new JTextField(10);

			DateFormat df = new SimpleDateFormat("dd/MM/yy");
			pdob = new JFormattedTextField(df);

			pmilestone_details = new JTextField(10);

			NumberFormat intFormat = NumberFormat.getIntegerInstance();
			NumberFormatter numberFormatter = new NumberFormatter(intFormat);
			numberFormatter.setValueClass(Integer.class); // optional, ensures you
															// will always get a int
															// value
			numberFormatter.setAllowsInvalid(false);
			numberFormatter.setMinimum(0); // Optional
			numberFormatter.setMaximum(28); // Optional
			potc = new JFormattedTextField(numberFormatter);

			JPanel setl = new JPanel(null);

			labels = new JPanel();
			labels.setLayout(new GridLayout(5, 2));
			labels.add(lbl1);
			labels.add(pname);
			labels.add(lbl2);
			labels.add(pMR);
			labels.add(lbl3);
			labels.add(pdob);
			labels.add(lbl4);
			labels.add(pmilestone_details);
			labels.add(lbl5);
			labels.add(potc);
			labels.setSize(600, 90);
			labels.setLocation(100, 10);
			
			setl.add(labels);

			JPanel instr = new JPanel(new GridLayout(0, 1));
			Label inscap = new Label("Instructions", Label.CENTER);
			inscap.setFont(new Font("Serif", Font.BOLD, 15));
			inscap.setForeground(Color.BLACK);
			instr.add(inscap);
			JLabel l1 = new JLabel(
					"                    1. Parents should be given informed consent for signing.");
			JLabel l2 = new JLabel(
					"	                    2. Only the parents and 3 (maximum) examiners would be allowed to stay inside the room during the testing.                   ");
			JLabel l3 = new JLabel(
					"                    3. Try re-connecting the arduino before you run the code ");
			instr.add(l1);
			instr.add(l2);
			instr.add(l3);

			panel.add(setl);
			panel.add(instr);
			
			
			
			int result = JOptionPane.showConfirmDialog(
				       det, // use your JFrame here
				       panel,
				       "Enter Correct Details",
				       JOptionPane.OK_CANCEL_OPTION,
				       JOptionPane.PLAIN_MESSAGE);

				    boolean firstTime = true;            //For validation message
				    if (result == JOptionPane.OK_OPTION) {

				     //This While loop is used for validation of form
				     while (pname.getText().length() == 0 || pMR.getText().length() == 0 || pdob.getText().length() == 0 || pmilestone_details.getText().length() == 0 || potc.getText().length() == 0) {
				      if (firstTime) {
				       JLabel l4 = new JLabel("Please fill the details correctly.");
				       l4.setForeground(Color.RED);
				       l4.setFont(new Font("Serif", Font.BOLD, 18));
				       instr.add(l4);
				       panel.add(instr);
				       firstTime = false;
				      }
				      result = JOptionPane.showConfirmDialog(
				    	       det, // use your JFrame here
				    	       panel,
				    	       "Enter Correct Details",
				    	       JOptionPane.OK_CANCEL_OPTION,
				    	JOptionPane.PLAIN_MESSAGE);
				      if (result == JOptionPane.CANCEL_OPTION) {
				       System.exit(0);
				       break;
				      }
				}

				     //det.getContentPane().add(panel);
						//det.setVisible(true);
			// Validation Ends here
			patient_name = pname.getText();
			patient_MR = pMR.getText();
			patient_dob = pdob.getText();
			patient_milestone_details = pmilestone_details.getText();
			patient_OTC = potc.getText();
		}
		}
	}

