package sdossey.algorithms.exercises;

import javax.swing.JFrame;
import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ruler extends JComponent {
	private static final long serialVersionUID = 1L;

	public Ruler() {
		super();
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Ruler App");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new Ruler());
		frame.setSize(1200, 100);
		frame.setResizable(false);
		frame.setVisible(true);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Rectangle r = this.getBounds();
		int width = (int) r.getWidth();

		markRuler(g, width);
	}

	public void makeMark(Graphics g, double xOffset, double size) {
		g.drawLine((int) xOffset, 0, (int) xOffset, (int) size);
	}

	public void markAtSteps(double step, double markSize, double width, Graphics g) {
		double stepSize = width / step;
		for (double x = stepSize; x < width; x += stepSize) {
			makeMark(g, x, markSize);
		}
	}

	public void markRuler(Graphics g, double width) {
		// Currently this code marks the ruler into
		// 10 equal divisions, each mark being 30 units long.

		double stepSize = width / 10.0;
		for (double x = stepSize; x < width; x += stepSize) {
			makeMark(g, x, 30.0);
		}
//
//		// Change the code so that:
//		// The ruler is marked as:
//		// 1/2 point on the ruler is marked 30 units long

		markAtSteps(2.0, 30.0, width, g);

		// 1/4 points on the ruler are marked 25 units long (if not already marked)

		markAtSteps(4.0, 25.0, width, g);

		// 1/8 points on the ruler are marked 20 untis long
		markAtSteps(8.0, 20.0, width, g);

		// 1/16 points on the ruler are marked 15 units long
		markAtSteps(16.0, 15.0, width, g);

		// 1/32 points on the ruler are marked 10 units long
		markAtSteps(32.0, 10.0, width, g);

		// 1/64 points on the ruler are marked 5 units long
		markAtSteps(64.0, 15.0, width, g);

		// It is okay to add methods.
	}
}
