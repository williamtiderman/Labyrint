import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class mazeGen extends JComponent {
	private int dims, thickness, margin;

    public mazeGen(int dims, int thickness, int margin){
        this.dims = dims;
        this.thickness = thickness;
        this.margin = margin;
    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        BasicStroke stroke = new BasicStroke(thickness);
        g2.setStroke(stroke);
        int j = 0;

        for (int i = 0; i < dims*dims; i++) { 
            g2.drawLine(Labyrinth.starts[i][j] * (500/dims) + margin, 
                        Labyrinth.starts[i][j+1] * (500/dims) + margin, 
                        Labyrinth.ends[i][j] * (500/dims) + margin, 
                        Labyrinth.ends[i][j+1] * (500/dims) + margin);
        }
    }
}
