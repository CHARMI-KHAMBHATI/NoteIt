package com.charmi.noteit;

import android.graphics.Paint;
import android.graphics.Path;

/**
 * Created by ADMIN on 1/5/2017.
 */
public class PathWithPaint {

    private Path path;

    public Path getPath()
    {
        return path;
    }

    public void setPath(Path path)
    {
        this.path=path;
    }

    private Paint mPaint;

    public Paint getmPaint() {
        return mPaint;
    }

    public void setmPaint(Paint mpaint) {
        this.mPaint = mpaint;
    }
}
