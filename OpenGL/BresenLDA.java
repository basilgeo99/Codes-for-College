package gl_lab;



import javax.swing.JFrame;
import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;


public class BresenLDA implements GLEventListener {

	private GLU glu;
	
	public void dispose(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub
		
	}
	public void init(GLAutoDrawable arg0){
		GL2 gl = arg0.getGL().getGL2();
		glu = new GLU();
		gl.glClearColor(0.0f,0.0f,0.0f,1.0f);
		gl.glViewport(-250, -150, 250, 150);
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		glu.gluOrtho2D(-250.0, 250.0, -150.0, 150.0);
				
	}
	
	public void display(GLAutoDrawable drawable){
		GL2 gl=drawable.getGL().getGL2();
		gl.glClear(GL.GL_COLOR_BUFFER_BIT);
	
		drawline(gl,20,10,30,18);
				
	}
	
	public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3,
			int arg4) {
		
	}
	
private void drawline(GL2 gl,int x1,int y1,int x2,int y2){
	gl.glPointSize(1.0f);
	gl.glBegin(GL2.GL_POINTS);
	
	int dx=(x2-x1),dy=(y2-y1),x=x1,y=y1,p=2*dy-dx;
	
	while(x<x2){
		if(p<0)
				p+=2*dy;
		else{
			p+=2*dy-2*dx;
			y++;
		}
		x++;
		gl.glVertex2i(x,y);
		System.out.println("x="+x+"y="+y);
	}
	gl.glEnd();
}

public static void main(String[] args){
	
	final GLProfile profile = GLProfile.get(GLProfile.GL2);
	GLCapabilities capabilities = new GLCapabilities(profile);
	
	final GLCanvas glcanvas = new GLCanvas(capabilities);
	BresenLDA b = new BresenLDA();
	glcanvas.addGLEventListener(b);
	glcanvas.setSize(400,400);
	
	final JFrame frame =  new JFrame("Basic Frame ");
	
	frame.add(glcanvas);
	frame.setSize(640,480);
	frame.setVisible(true);
        
	

	}
	
}
