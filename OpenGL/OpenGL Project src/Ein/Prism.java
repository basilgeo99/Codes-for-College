/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ein;

/**
 *
 * @author tulsi
 */
import java.awt.DisplayMode;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;

import javax.swing.JFrame;

import com.jogamp.opengl.util.FPSAnimator;

public class Prism implements GLEventListener {

    private float[][] vertexList = {{0, 0, 1}, {1, 0, -1}, {-1, 0, -1}, {-1, 0, 1}, {0, 1, 0}};
    private int[][] faceList = {{4, 3, 3}, {4, 0, 3}, {4, 1, 2}, {4, 2, 3}, {0, 3, 2, 1}};
    private double[][] faceColors = {{.0, 0.0, 1.0}, {0.0, 0.0, 0.5}, {0., 0.0, 0.8}, {0.0, 0.0, 0.6}, {0.0, 0.0, 0.2},};

    public static DisplayMode dm, dm_old;
    private GLU glu = new GLU();
    private float rquad = 0.0f;
    float r = 0.0f, g = 0.0f, b = 0.0f;

    @Override
    public void display(GLAutoDrawable drawable) {

        final GL2 gl = drawable.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrtho(-1, 1, -1, 1, -2, 2);
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();
        gl.glRotatef(rquad, 1.0f, 1.0f, 1.0f);
        drawIFS(gl, vertexList, faceList, faceColors);

        rquad -= 0.50f;
    }

    public void drawIFS(GL2 gl, float[][] vertexList, int[][] faceList, double[][] faceColors) {
        for (int i = 0; i < faceList.length; i++) {
            gl.glColor3dv(faceColors[i], 0);
            gl.glBegin(GL2.GL_POLYGON);
            int[] faceData = faceList[i]; //List of vertices for this face
            for (int j = 0; j < faceData.length; j++) {
                int vertexIndex = faceData[j]; //Location of j-th vertex in list
                float[] vertex = vertexList[vertexIndex];
                gl.glVertex3fv(vertex, 0);
            }
            gl.glEnd();
        }
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
        // TODO Auto-generated method stub
    }

    @Override
    public void init(GLAutoDrawable drawable) {

        final GL2 gl = drawable.getGL().getGL2();
        gl.glShadeModel(GL2.GL_SMOOTH);
        gl.glClearColor(0f, 0f, 0f, 0f);
        gl.glClearDepth(1.0f);
        gl.glEnable(GL2.GL_DEPTH_TEST);
        gl.glDepthFunc(GL2.GL_LEQUAL);
        gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST);
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {

        // TODO Auto-generated method stub
        final GL2 gl = drawable.getGL().getGL2();
        if (height == 0) {
            height = 1;
        }

        final float h = (float) width / (float) height;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();

        glu.gluPerspective(45.0f, h, 1.0, 20.0);
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    public static void main(String[] args) {

        final GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);

        // The canvas
        final GLCanvas glcanvas = new GLCanvas(capabilities);
        Prism prism = new Prism();

        glcanvas.addGLEventListener(prism);
        glcanvas.setSize(400, 400);

        final JFrame frame = new JFrame(" Multicolored Prism");
//        int pbn = ControlGUI.getProgressnumber();
//        frame.setDefaultCloseOperation(--pbn);
//        ControlGUI.setProgressnumber(pbn);
        frame.setLocation(600, 300);
        frame.getContentPane().add(glcanvas);
        frame.setSize(frame.getContentPane().getPreferredSize());
        frame.setVisible(true);
        final FPSAnimator animator = new FPSAnimator(glcanvas, 60, true);

        animator.start();
    }

}
