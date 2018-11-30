package com.example.user.a3dcubeapp;

/**
 * Created by gr on 11/12/2017.
 */

public class Point3D extends Point {

    private double  z;
    public final static int DIST = -1500;

    public Point3D(double x, double y, double z) {
        super(x,y);
        this.z = z;
    }



    public Point3D(Point3D p) {

        this.x = p.getX();
        this.y = p.getY();
        this.z = p.getZ();
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getZ() {
        return this.z;
    }

    public void setX(double newX) {
        this.x = newX;
    }

    public void setY(double newY) {
        this.y = newY;
    }

    public void setZ(double newZ) {
        this.z = newZ;
    }

    public void move(double dx, double dy, double dz) {
        this.x += dx;
        this.y += dy;
        this.z += dz;
    }

    public void scale(double sx, double sy, double sz) {
        this.x = this.x * sx;
        this.y = this.y * sy;
        this.z = this.z * sz;
    }

    public void turnX(double ang) {
        double y1 = this.y;
        double z1 = this.z;
        this.y = y1 * Math.cos(ang * Math.PI / 180) - z1 * Math.sin(ang * Math.PI / 180);
        this.z = y1 * Math.sin(ang * Math.PI / 180) + z1 * Math.cos(ang * Math.PI / 180);
    }

    public void turnY(double ang) {
        double x1 = this.x;
        double z1 = this.z;
        this.x = x1 * Math.cos(ang * Math.PI / 180) - z1 * Math.sin(ang * Math.PI / 180);
        this.z = x1 * Math.sin(ang * Math.PI / 180) + z1 * Math.cos(ang * Math.PI / 180);
    }

    public void turnZ(double ang) {
        double x1 = this.x;
        double y1 = this.y;
        this.x = y1 * Math.sin(ang * Math.PI / 180) + x1 * Math.cos(ang * Math.PI / 180);
        this.y = y1 * Math.cos(ang * Math.PI / 180) - x1 * Math.sin(ang * Math.PI / 180);
    }
    public void TurnPointY(double a,Point3D p) {
        double xc, yc, zc;
        xc = p.getX();
        yc = p.getY();
        zc = p.getZ();
        this.move(-xc, -yc, -zc);
        this.turnY(a);
        this.move(xc, yc, zc);
    }
    public void TurnPointZ(double a,Point3D p) {
        double xc, yc, zc;
        xc = p.getX();
        yc = p.getY();
        zc = p.getZ();
        this.move(-xc, -yc, -zc);
        this.turnZ(a);
        this.move(xc, yc, zc);
    }

    public void TurnPointX(double a,Point3D p) {
        double xc, yc, zc;
        xc = p.getX();
        yc = p.getY();
        zc = p.getZ();
        this.move(-xc, -yc, -zc);
        this.turnX(a);
        this.move(xc, yc, zc);
    }

    public Point perspectivePointProjection() {
        Point p2d = new Point((this.x * DIST) / (this.z + DIST), (this.y * DIST) / (this.z + DIST));
        return p2d;
    }
}
