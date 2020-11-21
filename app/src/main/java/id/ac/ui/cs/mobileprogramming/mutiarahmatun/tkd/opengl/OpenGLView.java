package id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.opengl;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;

public class OpenGLView extends GLSurfaceView {

    public OpenGLView(Context context) {
        super(context);
        initiation();
    }

    public void initiation() {
        setEGLContextClientVersion(2);
        setPreserveEGLContextOnPause(true);
        setRenderer(new OpenGLRenderer());
    }

    public OpenGLView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initiation();
    }
}
