package com.example.user.a3dcubeapp;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

public class Face  {

    public Point3D p1, p2, p3;
    public int color;



    public Face(Point3D p1, Point3D p2, Point3D p3,int col) {
        this.p1 = new Point3D(p1.getX(), p1.getY(), p1.getZ());
        this.p2 = new Point3D(p2.getX(), p2.getY(), p2.getZ());
        this.p3 = new Point3D(p3.getX(), p3.getY(), p3.getZ());
        this.color = col;
    }
    public Face(Point3D p1, Point3D p2, Point3D p3) {
        this.p1 = new Point3D(p1.getX(), p1.getY(), p1.getZ());
        this.p2 = new Point3D(p2.getX(), p2.getY(), p2.getZ());
        this.p3 = new Point3D(p3.getX(), p3.getY(), p3.getZ());
        this.color =Color.GRAY;
    }
    public Face(double x1, double y1, double z1, double x2, double y2, double z2, double x3, double y3, double z3,int col) {
        this.p1 = new Point3D(x1, y1, z1);
        this.p2 = new Point3D(x2, y2, z2);
        this.p3 = new Point3D(x3, y3, z3);
        this.color = col;
    }


    public void move(double dx, double dy, double dz) {
        p1.move(dx, dy, dz);
        p2.move(dx, dy, dz);
        p3.move(dx, dy, dz);
    }

    public void scale(double sx, double sy, double sz) {
        p1.scale(sx, sy, sz);
        p2.scale(sx, sy, sz);
        p3.scale(sx, sy, sz);
    }

    public void zoom(double k) {
        Point3D mid = this.getCenterPoint();
        this.move(-(mid.getX()), -(mid.getY()), -(mid.getZ()));
        this.scale(k, k, k);
        this.move(mid.getX(), mid.getY(), mid.getZ());
    }

    public void turnX(double ang) {
        p1.turnX(ang);
        p2.turnX(ang);
        p3.turnX(ang);
    }

    public void turnY(double ang) {
        p1.turnY(ang);
        p2.turnY(ang);
        p3.turnY(ang);
    }

    public void turnZ(double ang) {
        p1.turnZ(ang);
        p2.turnZ(ang);
        p3.turnZ(ang);
    }

    public void turnCenter(double ang) {
        Point3D mid = this.getCenterPoint();
        this.move(-(mid.getX()), -(mid.getY()), -(mid.getZ()));
        this.turnX(ang);
        this.turnY(ang);
        this.turnZ(ang);
        this.move(mid.getX(), mid.getY(), mid.getZ());
    }

    public Point3D getCenterPoint() {
        Point3D mid = new Point3D((p1.getX() + p2.getX() + p3.getX()) / 3, (p1.getY() + p2.getY() + p3.getY()) / 3, (p1.getZ() + p2.getZ() + p3.getZ()) / 3);
        return mid;
    }

    public Point3D getSideCenter() {
        Point3D mid = new Point3D((p1.getX() + p3.getX()) / 2, (p1.getY() + p3.getY()) / 2, (p1.getZ() + p3.getZ()) / 2);
        return mid;
    }


    protected void drawFace(Canvas canvas) {
        Paint p = new Paint();


        Point ppj1 = p1.perspectivePointProjection();
        Point ppj2 = p2.perspectivePointProjection();
        Point ppj3 = p3.perspectivePointProjection();

        Path path = new Path();
        path.moveTo((float) ppj1.GetX(), (float) ppj1.GetY());
        path.lineTo((float) ppj2.GetX(), (float) ppj2.GetY());
        path.lineTo((float) ppj3.GetX(), (float) ppj3.GetY());
        path.lineTo((float) ppj1.GetX(), (float) ppj1.GetY());
        path.close();
        p.setColor(color);
        p.setStyle(Paint.Style.FILL);
        canvas.drawPath(path, p);


    }
    public void drawSolidFace(Canvas g) {
        Paint p = new Paint();
        Point ppj1 = p1.perspectivePointProjection();
        Point ppj2 = p2.perspectivePointProjection();
        Point ppj3 = p3.perspectivePointProjection();

        Path path = new Path();
        path.moveTo((float) ppj1.GetX(), (float) ppj1.GetY());
        path.lineTo((float) ppj2.GetX(), (float) ppj2.GetY());
        path.lineTo((float) ppj3.GetX(), (float) ppj3.GetY());
        path.lineTo((float) ppj1.GetX(), (float) ppj1.GetY());
        path.close();
        p.setColor(Color.BLUE);
       p.setStyle(Paint.Style.FILL);
       g.drawPath(path, p);
    }

    //public void paint(final Graphics g) {
    //    drawFace(g);
  //  }
}
