package com.example.user.a3dcubeapp;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
  //  public static Paint p;
    // SurfaceView can;
    Cube cube;
    DrawView dv;
    Bitmap bk;
    float history_angle = 1;
    float history_dist = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bk = BitmapFactory.decodeResource(getResources(), R.drawable.blackhole2);

        dv = new DrawView(this);
        setContentView(dv);
        dv.setOnTouchListener(this);


        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        cube = new Cube(200, 300, 0, 700, 800, 500);
        cube.zoom(0.7);
    }

    private float getDist(Point3D p1, Point3D p2) {

        return (float) Math.sqrt((p1.getX() - p2.getX()) * (p1.getX() - p2.getX()) + (p1.getY() -
                p2.getY()) * (p1.getY() - p2.getY()) + (p1.getZ() - p2.getZ()) * (p1.getZ() - p2.getZ()));

    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        float xd = 0;
        float yd = 0;
        float xu = 0;
        float yu = 0;
        float xm = 0;
        float ym = 0;

        if (event.getPointerCount() == 1) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    xd = event.getX();
                    yd = event.getY();
                    break;
                case MotionEvent.ACTION_UP:
                    xu = event.getX();
                    yu = event.getY();
                    break;
                case MotionEvent.ACTION_MOVE:
                    xm = event.getX();
                    ym = event.getY();
                    break;
                default:
                    break;
            }
            cube.turnX((-xd + xm) / 200);
            cube.turnY((-yd + ym) / 200);
            if (Math.abs(xd - dv.getWidth() / 2) < 10) cube.turnZ(xm / 200);
        } else if (event.getPointerCount() == 2) {

            if (event.getActionMasked() == MotionEvent.ACTION_POINTER_DOWN
                    || event.getActionMasked() == MotionEvent.ACTION_DOWN) {
                float diff_y = event.getY(0) - event.getY(1);
                float diff_x = event.getX(0) - event.getX(1);
                history_angle = (float) Math.toDegrees(Math.atan2(diff_y, diff_x));

                history_dist = (float) Math.sqrt(diff_x * diff_x + diff_y * diff_y);

            } else if (event.getActionMasked() == MotionEvent.ACTION_MOVE) {

                float diff_y = event.getY(0) - event.getY(1);
                float diff_x = event.getX(0) - event.getX(1);
                float angle = (float) Math.toDegrees(Math.atan2(diff_y, diff_x));
                float dist_angle = angle - history_angle;

                float distCurrent = (float) Math.sqrt(diff_x * diff_x + diff_y * diff_y);

                float curScale = distCurrent / history_dist;
                // System.out.println("distCurrent | history_dist: " + distCurrent + " | " + history_dist);
                double k;
                if (curScale > 1) {
                    k = 1.03;
                    cube.turnZ(dist_angle / 3);
                    cube.move(-2, -3, 0);
                } else {
                    k = 0.97;
                    cube.move(2, 3, 0);
                    cube.turnZ(-dist_angle / 3);
                }
                cube.zoom(k);


            }
        }

        dv.invalidate();
        return true;
    }




  /*  @Override
    public void onClick(View v) {
        switch (v.getLabelFor()) {
            case R.id.btnCol:
                cube = new Cube(200, 300, 0, 700, 800, 500);
                cube.zoom(0.7);
                break;
            case R.id.btnMono:
                cube = new Cube(200, 300, 0, 700, 800, 500, Color.BLUE);
                cube.zoom(0.7);
                break;
            case R.id.btnWire:
                cube = new Cube(200, 300, 0, 700, 800, 500);
                cube.zoom(0.7);
                break;
        }
    }
*/
    class DrawView extends View {
      Paint p;
            public DrawView(Context context) {
                super(context);
                p = new Paint();
                //    p.setStyle(Paint.Style.FILL);

            }

            protected void onDraw(Canvas canvas) {
//canvas.drawARGB(200,200,200,200);
              canvas.drawBitmap(bk, 0, 0, p);
                cube.drawCube(canvas);
                // cube.drawSolidCube(canvas);

            }
        }
    }
