package opengl.panjq.com.opengl_demo;

import android.opengl.GLSurfaceView.Renderer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.content.Context;
import android.content.res.AssetManager;
import android.opengl.GLSurfaceView;
import android.util.Log;

/**
 * Created by Administrator on 2018/8/24.
 */


public class RendererJNI implements GLSurfaceView.Renderer {
    static {
        System.loadLibrary("gltest-lib");
    }
    private AssetManager mAssetMgr = null;
    private final String mLogTag = "ndk-build";

    public native void glesInit();
    public native void glesRender();
    public native void glesResize(int width, int height);

    public native void readShaderFile(AssetManager assetMgr);

    public RendererJNI(Context context) {
        mAssetMgr = context.getAssets();
        if (null == mAssetMgr) {
            Log.e(mLogTag, "getAssets() return null !");
        }
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        // TODO Auto-generated method stub
        readShaderFile(mAssetMgr);
        glesInit();
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        // TODO Auto-generated method stub
        glesResize(width, height);
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        // TODO Auto-generated method stub
        glesRender();
    }
}