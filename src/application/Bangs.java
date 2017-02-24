package application;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.IOException;

import javafx.embed.swing.SwingNode;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Bangs 
{
	Slider ls, br;
	Label lsl, brl;
	Button pinfo,finish;
	JLabel rt,rt_value, cur_test,cur_test_value,test_status,test_status_value;
	public void addBangs(Group g)
	{
		Bangs bb = new Bangs();
		bb.flagAndNote(g);
		bb.ledSpeed(g);
		bb.fixBrightness(g);
		bb.patInfo(g);
		bb.finish(g);
		bb.test_det(g);
	}
	public void flagAndNote(Group g)
	{
		SwingNode[] fn=new SwingNode[2];
		for(int i=0;i<2;i++)
		{
			fn[i]=new SwingNode();
		}
		fan(fn[0],fn[1]);
		float xx=970,yy=420;
		for(int i=0;i<2;i++)
		{
			fn[i].setLayoutX(xx);
			fn[i].setLayoutY(yy);
			xx+=50;
			g.getChildren().add(fn[i]);
		}
	}
	public void fan(SwingNode s,SwingNode p) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	try{
            		s.setContent(new JLabel(new ImageIcon("E:\\Sonu_16thDec\\New_GUI\\PediPeri_MainScreen\\src\\application\\flagB.png")));
            		p.setContent(new JLabel(new ImageIcon("E:\\Sonu_16thDec\\New_GUI\\PediPeri_MainScreen\\src\\application\\noteB.png")));
            	}
            	catch(Exception e)
            	{
            		System.out.println(e);
            	}
                
            }
        });
    }
	
	
	public void ledSpeed(Group g)
	{
		ls = new Slider(0,10,3);
		ls.setShowTickMarks(true);
		ls.setShowTickLabels(true);
		ls.setMajorTickUnit(0.25f);
		ls.setBlockIncrement(0.1f);
		ls.setLayoutX(840);
		ls.setLayoutY(580);
		g.getChildren().add(ls);
		lsl = new Label("LED Speed (deg/sec)");
		lsl.setLayoutX(840);
		lsl.setLayoutY(560);
		g.getChildren().add(lsl);
	}
	public void fixBrightness(Group g)
	{
		br = new Slider(0,10,3);
		br.setShowTickMarks(true);
		br.setShowTickLabels(true);
		br.setMajorTickUnit(0.25f);
		br.setBlockIncrement(0.1f);
		br.setLayoutX(1010);
		br.setLayoutY(580);
		g.getChildren().add(br);
		brl = new Label("FIXATION Br. (cd/sq.mt)");
		brl.setLayoutX(1010);
		brl.setLayoutY(560);
		g.getChildren().add(brl);
	}
	public void patInfo(Group g)
	{
		pinfo = new Button("Patient's Info");
		pinfo.setLayoutX(880);
		pinfo.setLayoutY(650);
		pinfo.setPrefSize(110, 35);
		g.getChildren().add(pinfo);
	}
	public void finish(Group g)
	{
		finish = new Button("Finish");
		finish.setLayoutX(1010);
		finish.setLayoutY(650);
		finish.setPrefSize(110, 35);
		finish.setOnMouseClicked(finished);
		g.getChildren().add(finish);
	}
	EventHandler<MouseEvent> finished=new EventHandler<MouseEvent>()
	{
		public void handle(MouseEvent m)
		{
			try {
				Process p = Runtime.getRuntime().exec("C:\\Windows\\System32\\cmd.exe /c start taskkill /IM ffmpeg.exe /f ");
				// StreamGobbler.StreamGobblerLOGProcess(p);
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.exit(0);
		}
	};

	public void test_det(Group g)
	{
		SwingNode k=new SwingNode();
		test_details(k);
		g.getChildren().add(k);
		
	}
	public void test_details(SwingNode s) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	try{
            		JPanel j=new JPanel(new GridLayout(3,2,10,10));
            		rt = new JLabel("Reactio Time : ");
            		rt_value=new JLabel("Value");
            		cur_test=new JLabel("Present Test : ");
            		cur_test_value=new JLabel("Value");
            		test_status=new JLabel("Test Status : ");
            		test_status_value=new JLabel("Value");
            		j.add(rt);
            		j.add(rt_value);
            		j.add(cur_test);
            		j.add(cur_test_value);
            		j.add(test_status);
            		j.add(test_status_value);
            		s.setLayoutX(570);
            		s.setLayoutY(613);
            		s.setContent(j);
            		System.out.println("Sonu");
            		
            	}
            	catch(Exception e)
            	{
            		System.out.println(e);
            	}
                
            }
        });
    }
	
	
}
