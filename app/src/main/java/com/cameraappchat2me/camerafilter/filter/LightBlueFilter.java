package com.cameraappchat2me.camerafilter.filter;

import android.content.Context;
import android.opengl.GLES20;

import com.cameraappchat2me.camerafilter.MyGLUtils;
import com.cameraappchat2me.camerafilter.R;

/**
 * Created by Machine Vision on 09-05-2017.
 */

public class LightBlueFilter extends CameraFilter {
    private int program;
    private int texture2Id;

    public LightBlueFilter(Context context) {
        super(context);

        // Build shaders
        program = MyGLUtils.buildProgram(context, R.raw.vertext, R.raw.mapping);

        // Load the texture will need for the shader
        texture2Id = MyGLUtils.loadTexture(context, R.raw.blue, new int[2]);
    }

    @Override
    public void onDraw(int cameraTexId, int canvasWidth, int canvasHeight) {
        setupShaderInputs(program,
                new int[]{canvasWidth, canvasHeight},
                new int[]{cameraTexId, texture2Id},
                new int[][]{});
        GLES20.glDrawArrays(GLES20.GL_TRIANGLE_STRIP, 0, 4);
    }
}



