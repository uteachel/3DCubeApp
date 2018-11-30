package com.example.user.a3dcubeapp;

/**
 * Created by gr on 11/12/2017.
 */

public class Point {

    public double x;
    public  double y;
    public Point() {
        this.x = 0;
        this.y = 0;
    }
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public  double  GetX(){
        return this.x;
    }
    public  double  GetY(){
        return this.y;
    }

    public void Move(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    public void Scale(double sx, double sy) {
        this.x *= sx;
        this.y *= sy;
    }
    public void Turn(double ang ) {
        double x1 = this.x;
        double y1 = this.y;
        this.x = x1*Math.cos(ang*Math.PI/180) - y1*Math.sin(ang*Math.PI/180);
        this.y = x1*Math.sin(ang*Math.PI/180) + y1*Math.cos(ang*Math.PI/180);
    }
}