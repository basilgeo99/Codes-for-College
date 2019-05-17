
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
			
public class Translation implements GLEventListener{			
			
	private float tx=0,ty=0;		
			
	/* (non-Javadoc)		
	 * @see com.jogamp.opengl.GLEventListener#display(com.jogamp.opengl.GLAutoDrawable)		
	 */		
	@Override		
	public void display(GLAutoDrawable arg0) {		
		GL2 gl = arg0.getGL().getGL2();	
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT);	
			
		gl.glPushMatrix();	
		gl.glTranslatef(tx, ty, 1);	
			
		gl.glBegin(GL2.GL_TRIANGLES);	
		gl.glColor3f(1.0f, 0.0f, 0.0f);	
		gl.glVertex3f(50, 50, 0);	
		gl.glColor3f(0.0f, 1.0f, 0.0f);	
		gl.glVertex3f(150, 50, 0);	
		gl.glColor3f(0.0f, 0.0f, 1.0f);	
		gl.glVertex3f(150, 200, 0);	
			
			
		gl.glEnd();	
			
		
		gl.glPopMatrix();	
			
		
			
		tx-=5f;	
		ty-=5f;	
			
		if(tx==-200){	
			
			tx=0;
			ty=0;
			
		}	
			
			
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
			
		Translation P = new Translation();	
			
		canvas.addGLEventListener(P);	
		canvas.setSize(400,400);	
			
		final JFrame window = new JFrame("Translation");	
			
		window.add(canvas);	
			
		window.setSize(640,480);	
		window.setVisible(true);	
		final FPSAnimator animator = new FPSAnimator(canvas,100,true);	
		animator.start();	
			
	}		
			
}			
