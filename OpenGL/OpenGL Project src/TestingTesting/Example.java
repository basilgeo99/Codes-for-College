/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestingTesting;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.Animator;
import com.jogamp.opengl.util.gl2.GLUT;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;

public class Example implements GLEventListener, MouseMotionListener{
    private float rquad = 0.0f;
    private float rotateX = 0f, rotateY = 0f;
    private int lastX, lastY;
    private float[][] vertexList = {{1,0,1}, {1,0,-1}, {-1,0,-1}, {-1,0,1}, {0,1,0}};
    private int[][] faceList = {{4,3,0},{4,0,1}, {4,1,2}, {4,2,3}, {0,3,2,1}};
    private double[][] faceColors = {{0.0, 0.0, 1.0},{0.0, 1.0, 0.5},{1.0, 0.4, 0.2},{0.0, 0.5, 0.5},{1.0, 1.0, 0.2},};
    
    public static void main(String[] args){
        final GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);
        final GLCanvas canvas = new GLCanvas(capabilities);
        Example cube = new Example();
        canvas.addGLEventListener(cube);
        canvas.addMouseMotionListener(cube);
        canvas.setSize(400, 400);
        
        JFrame frame = new JFrame("Mouse Move");
        frame.add(canvas);
        frame.setSize(640, 480);
        frame.setVisible(true);
        final Animator animator = new Animator(canvas);
        animator.start();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    @Override
    public void init(GLAutoDrawable glad) {
        GL2 gl = glad.getGL().getGL2();
        GLU glu = new GLU();
        gl.glClearColor(0.8f,0.8f,0.8f,1.0f);
        gl.glViewport(-250, -250, 250, 250);
        gl.glEnable(GL.GL_DEPTH_TEST);
        //gl.glEnable(GL2.GL_LIGHTING);
        //gl.glEnable(GL2.GL_LIGHT2);
        gl.glEnable(GL2.GL_COLOR_MATERIAL);
        gl.glEnable(GL2.GL_NORMALIZE);
    }

    @Override
    public void dispose(GLAutoDrawable glad) {
        
    }

    
    @Override
    public void reshape(GLAutoDrawable glad, int i, int i1, int i2, int i3) {
    
    }
    
    @Override
    public void display(GLAutoDrawable arg0) {
        GL2 gl = arg0.getGL().getGL2();
        gl.glClearColor(0, 0, 0, 0);
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrtho(-1, 1, -1, 1, -2, 2);
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();
        gl.glRotatef(rotateX, 0.0f, 1.0f, 0.0f);
        gl.glRotatef(rotateY, 1.0f, 0.0f, 0.0f);
      //  GLUT glut = new GLUT();
      //  gl.glColor3f(1.0f,0.0f,0.0f);
       // glut.glutSolidOctahedron();
      // glut.glutWireSphere(1, 16, 16);
       //GLU glu = new GLU();
       //glutSwapBuffers();
      // glut.glutWireCube(5.0f);
      drawIFS(gl, vertexList, faceList, faceColors);
        //rquad -= 1.0f;
    }
    
    public void drawIFS(GL2 gl, float[][] vertexList, int[][] faceList, double[][] faceColors){
        for(int i= 0; i<faceList.length; i++){
            gl.glColor3dv(faceColors[i], 0);
            gl.glBegin(GL2.GL_POLYGON);
            int[] faceData = faceList[i]; //List of vertices for this face
            for(int j=0; j<faceData.length; j++){
                int vertexIndex = faceData[j]; //Location of j-th vertex in list
                float[] vertex = vertexList[vertexIndex];
                gl.glVertex3fv(vertex, 0);
            }
            gl.glEnd();
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        rotateX += e.getX() - lastX;
        rotateY += e.getY() - lastY;
        lastX = e.getX();
        lastY = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        lastX = e.getX();
        lastY = e.getY();  
    }
}