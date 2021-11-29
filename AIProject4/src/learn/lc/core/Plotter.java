package learn.lc.core;


import java.awt.Dimension;

import javax.swing.JFrame;
public class Plotter extends JFrame {
	
	
	
	public Canvas canvas;
	
	public int lx;
	public int ly;
	
	public Plotter() {
		
		canvas = new Canvas();
		
		canvas.setPreferredSize(new Dimension(480, 480));
		add(canvas);
		pack();
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void addPoint(double x, double y) {
		int fx = (int)(x * getWidth());
		int fy = (int)((1.0-y) * getHeight());
		canvas.getGraphics().drawLine(lx, ly, fx, fy);
		lx = fx;
		ly = fy;
	}
	

}
