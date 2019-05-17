package TestingTesting;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.FPSAnimator;
import javax.swing.JFrame;
/**
 *
 * @author tulsi
 */
public class Triangle2Prism implements GLEventListener{
   	@Override			
	public void display(GLAutoDrawable arg0) {			
		GL2 gl = arg0.getGL().getGL2();		
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT);		
				
		float tx=0,ty=0;		
				
		for(int i=0;i<=50;i++){		
			gl.glPushMatrix();	
			gl.glTranslatef(tx, ty, 1);	
			gl.glColor3f(0.1f, 0.5f, 0.5f);	
				
			if(i==50){	
				gl.glColor3f(1,0,0);
				
			}	
				
			drawtriangle(gl);	
			tx-=5.0f;	
			ty-=5.0f;	
			gl.glColor3f(1, 0.5f, 0.5f);	
			gl.glPopMatrix();	
		}		
				
		drawtriangle(gl);		
	}			
				
				
				
				
	public void drawtriangle(GL2 gl){			
				
		gl.glBegin(GL2.GL_POLYGON);		
		gl.glVertex3f(50, 50, 0);		
		gl.glVertex3f(150,50,0);		
		gl.glVertex3f(75, 150, 0);		
		gl.glEnd();		
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
				
		Triangle2Prism P = new Triangle2Prism();		
				
		canvas.addGLEventListener(P);		
		canvas.setSize(400,400);		
				
		final JFrame window = new JFrame("PRISM");		
				
		window.add(canvas);		
				
		window.setSize(640,480);		
		window.setVisible(true);		
		final FPSAnimator animator = new FPSAnimator(canvas,100,true);		
		animator.start();		
				
	}			
				
				
}				


