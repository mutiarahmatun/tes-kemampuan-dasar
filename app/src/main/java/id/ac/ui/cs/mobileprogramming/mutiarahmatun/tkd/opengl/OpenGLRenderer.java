package id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.opengl;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class OpenGLRenderer implements GLSurfaceView.Renderer {

    private float greenValue = 0.3f;
    private float blueValue = 0.3f;
    private static final double DURATION_FLASH = 2000;

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        GLES20.glClearColor(0, 0.3f, 0.3f, 1f);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {

    }

    @Override
    public void onDrawFrame(GL10 gl) {
        GLES20.glClearColor(0, greenValue, blueValue, 1f);
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);

        greenValue = (float) ((Math.sin(System.currentTimeMillis()
                * 2 * Math.PI / DURATION_FLASH) * 0.5 ));
        blueValue = (float) ((Math.sin(System.currentTimeMillis()
                * 2 * Math.PI / DURATION_FLASH) * 0.5 ) + 0.1);
    }
}
