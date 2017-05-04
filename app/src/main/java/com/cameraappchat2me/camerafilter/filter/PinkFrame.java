package com.cameraappchat2me.camerafilter.filter;

import android.content.Context;
import android.opengl.GLES20;

import com.cameraappchat2me.camerafilter.MyGLUtils;
import com.cameraappchat2me.camerafilter.R;

/**
 * @author Seemagiri (smartermeyou@gmail.com)
 */

public class PinkFrame extends CameraFilter {
    private int program;
    private int texture2Id;

    public PinkFrame(Context context) {
        super(context);

        // Build shaders
        program = MyGLUtils.buildProgram(context, R.raw.vertext, R.raw.pink_light);

        // Load the texture will need for the shader
        texture2Id = MyGLUtils.loadTexture(context, R.raw.tex08, new int[2]);
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
