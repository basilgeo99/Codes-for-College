import com.jogamp.opengl.util.FPSAnimator;
import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.GLEventListener;
import javax.swing.JFrame;

public class RotateTriangle implements GLEventListener{
	private float rti=0;

	@Override
	public void display(GLAutoDrawable arg0) {
		GL2 gl = arg0.getGL().getGL2();
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
		
		gl.glLoadIdentity();                //loading the identitiy matrix
		gl.glRotatef(rti,0.0f,1.0f,0.0f);
		gl.glBegin(GL2.GL_TRIANGLES);
		gl.glColor3f(1.0f, 0.0f, 0.0f);
		gl.glVertex3f(0.5f,0.7f, 0.0f);
		gl.glColor3f(0.0f, 1.0f, 0.0f);
		gl.glVertex3f(-0.2f, -0.5f, 0.0f);
		gl.glColor3f(0.0f, 0.0f, 1.0f);
		gl.glVertex3f(0.5f, -0.5f, 0.0f);
		gl.glEnd();
		rti+=2f;
	}
	

	

	@Override
	public void dispose(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(GLAutoDrawable arg0) {
		GL2 gl = arg0.getGL().getGL2();
		GLU glu = new GLU();
		gl.glClearColor(0.0f,0.0f,0.0f,1.0f);
		gl.glViewport(-250,-250,250,250);
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		glu.gluOrtho2D(-250, 250, -250, 250);
		
	}

	@Override
	public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3,
			int arg4) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	public static void main(String[] args){
		final GLProfile profile =GLProfile.get(GLProfile.GL2);
		GLCapabilities capabilities = new GLCapabilities(profile);
		final GLCanvas canvas = new GLCanvas(capabilities);
		
		RotateTriangle P = new RotateTriangle();
		
		canvas.addGLEventListener(P);
		canvas.setSize(400,400);
		
		final JFrame window = new JFrame("Translation");
		
		window.add(canvas);
                window.setDefaultCloseOperation(3);
		window.setSize(640,480);
		window.setVisible(true);
		final FPSAnimator animator = new FPSAnimator(canvas,100,true);
		animator.start();
		
	}
}
