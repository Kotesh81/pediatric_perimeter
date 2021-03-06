package application;

import java.awt.Point;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class Quads 
{
	int[] flagq;
	int clicked_quad;
	Arc[] q;
	float[] quad_angle = { 0.0f, 90.0f, 180.0f, 270.0f };
	float[] quad_center = { 740.0f, 450.0f };
	float quad_diameter = 45.0f;
	
	Button buttonq;
	int done2;
	
	public Quads() {
		q = new Arc[8];
		buttonq=new Button("quad");
		flagq=new int[8];
	}
	
	
	public void drawQuads(float[] quad_center, float[] quad_angle,
			float quad_diameter, Group g) {

		q[0] = new Arc(quad_center[0], quad_center[1], quad_diameter,
				quad_diameter, quad_angle[0], 90.0f);
		q[1] = new Arc(quad_center[0] - 4.0f, quad_center[1], quad_diameter,
				quad_diameter, quad_angle[1], 90.0f);
		q[2] = new Arc(quad_center[0] - 4.0f, quad_center[1] + 4.0f,
				quad_diameter, quad_diameter, quad_angle[2], 90.0f);
		q[3] = new Arc(quad_center[0], quad_center[1] + 4.0f, quad_diameter,
				quad_diameter, quad_angle[3], 90.0f);

		quad_diameter = quad_diameter - 15;

		q[4] = new Arc(quad_center[0], quad_center[1], quad_diameter,
				quad_diameter, quad_angle[0], 90.0f);
		q[5] = new Arc(quad_center[0] - 4.0f, quad_center[1], quad_diameter,
				quad_diameter, quad_angle[1], 90.0f);
		q[6] = new Arc(quad_center[0] - 4.0f, quad_center[1] + 4.0f,
				quad_diameter, quad_diameter, quad_angle[2], 90.0f);
		q[7] = new Arc(quad_center[0], quad_center[1] + 4.0f, quad_diameter,
				quad_diameter, quad_angle[3], 90.0f);

		for (int i = 0; i < 8; i++) {
			q[i].setOnMouseEntered(mouseHandler_enter_quad);
			q[i].setOnMouseExited(mouseHandler_exit_quad);
			q[i].setOnMouseClicked(mouseHandler_click_quad);
			flagq[i]=0;
			new GUI_Components().colorQuadsHemis(q[i], g);
		}
		buttonq.setOnKeyPressed(keyHandler_press_quad);
		// g.getChildren().add(buttonq);
	}
	EventHandler<KeyEvent> keyHandler_press_quad=new EventHandler<KeyEvent>()
	{
		public void handle(KeyEvent key)
		{
			if(key.getCode()==KeyCode.SPACE)
			{
				for(int i=0;i<8;i++)
				{
					if(flagq[i] == 1)
					{
						System.out.println("Space pressed");
						q[clicked_quad].setFill(Color.BLUE);//q[clicked_quad].setFill(Color.BLUE);
						flagq[i]=3;
						//clicked_mer=28;
					}
				}
			}
		}
	};
	
	EventHandler<MouseEvent> mouseHandler_click_quad=new EventHandler<MouseEvent>()
	{
		public void handle(MouseEvent mouseEvent)
		{
			Arc a=(Arc) mouseEvent.getSource();
			for(int i=0;i<8;i++)
			{
				if(q[i]==a)
				{
					flagq[i]=1;
					clicked_quad=i;
					System.out.println(i);
				}
			}
			a.setFill(Color.GREEN);
		}
		
	};
	
	EventHandler<MouseEvent> mouseHandler_enter_quad = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			Arc a = (Arc) mouseEvent.getSource();
			for(int i=1;i<8;i++)
			{
				if(q[i]==a)
					System.out.println(i);
			}
			if(a.getFill()==Color.WHITE)
				a.setFill(Color.CYAN);
			else if(a.getFill()==Color.BLUE)
			{
				a.setFill(Color.CYAN);
				done2=1;
			}
		}
	};

	EventHandler<MouseEvent> mouseHandler_exit_quad = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			Arc a = (Arc) mouseEvent.getSource();
			for(int i=0;i<8;i++)
			{
				if(q[i]==a)
					System.out.println(i);
			}
			if(a.getFill()==Color.CYAN && done2==1)
			{
				a.setFill(Color.BLUE);
				done2=0;
			}
			else if(a.getFill()==Color.CYAN)
				a.setFill(Color.WHITE);
		}
	};


}
