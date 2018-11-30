package com.example.user.a3dcubeapp;

import android.graphics.Canvas;
import android.graphics.Color;

import java.util.ArrayList;

public class Cube {

    private ArrayList al;
    public Point3D p1, p2, p3, p4, p5, p6, p7, p8;

    public Cube(double x1, double y1, double z1, double x2, double y2, double z2) {
        //  super();

        al = new ArrayList();

        Face tri;

        this.p1 = new Point3D(x2, y1, z1);
        this.p2 = new Point3D(x1, y1, z1);
        this.p3 = new Point3D(x1, y2, z1);
        this.p4 = new Point3D(x2, y2, z1);
        this.p5 = new Point3D(x2, y1, z2);
        this.p6 = new Point3D(x1, y1, z2);
        this.p7 = new Point3D(x1, y2, z2);
        this.p8 = new Point3D(x2, y2, z2);

        tri = new Face(p1, p2, p3, Color.BLUE);
        al.add(tri);
        tri = new Face(p3, p4, p1, Color.BLUE);
        al.add(tri);
        tri = new Face(p5, p1, p4, Color.CYAN);
        al.add(tri);
        tri = new Face(p4, p8, p5, Color.CYAN);
        al.add(tri);
        tri = new Face(p6, p5, p8, Color.RED);
        al.add(tri);
        tri = new Face(p8, p7, p6, Color.RED);
        al.add(tri);
        tri = new Face(p2, p6, p7, Color.WHITE);
        al.add(tri);
        tri = new Face(p7, p3, p2, Color.WHITE);
        al.add(tri);
        tri = new Face(p5, p6, p2, Color.YELLOW);
        al.add(tri);
        tri = new Face(p2, p1, p5, Color.YELLOW);
        al.add(tri);
        tri = new Face(p4, p3, p7, Color.GREEN);
        al.add(tri);
        tri = new Face(p7, p8, p4, Color.GREEN);

        al.add(tri);

    }
    public Cube(double x1, double y1, double z1, double x2, double y2, double z2,int col) {
        //  super();

        al = new ArrayList();

        Face tri;

        this.p1 = new Point3D(x2, y1, z1);
        this.p2 = new Point3D(x1, y1, z1);
        this.p3 = new Point3D(x1, y2, z1);
        this.p4 = new Point3D(x2, y2, z1);
        this.p5 = new Point3D(x2, y1, z2);
        this.p6 = new Point3D(x1, y1, z2);
        this.p7 = new Point3D(x1, y2, z2);
        this.p8 = new Point3D(x2, y2, z2);

        tri = new Face(p1, p2, p3, col);
        al.add(tri);
        tri = new Face(p3, p4, p1,col);
        al.add(tri);
        tri = new Face(p5, p1, p4,col);
        al.add(tri);
        tri = new Face(p4, p8, p5,col);
        al.add(tri);
        tri = new Face(p6, p5, p8, col);
        al.add(tri);
        tri = new Face(p8, p7, p6, col);
        al.add(tri);
        tri = new Face(p2, p6, p7, col);
        al.add(tri);
        tri = new Face(p7, p3, p2, col);
        al.add(tri);
        tri = new Face(p5, p6, p2, col);
        al.add(tri);
        tri = new Face(p2, p1, p5, col);
        al.add(tri);
        tri = new Face(p4, p3, p7, col);
        al.add(tri);
        tri = new Face(p7, p8, p4, col);

        al.add(tri);

    }
    public void move(double dx, double dy, double dz) {
        for (int i = 0; i < al.size(); i++) {
            Face tritemp = (Face) al.get(i);
            tritemp.move(dx, dy, dz);
        }
    }

    public void scale(double sx, double sy, double sz) {
        for (int i = 0; i < al.size(); i++) {
            Face tri = (Face) al.get(i);
            tri.scale(sx, sy, sz);
        }
    }

    public void turnX(double ang) {
        double midX, midY, midZ;
        Face tri1, tri2;

        tri1 = (Face) al.get(0);
        tri2 = (Face) al.get(al.size() - 1);
        midX = (tri1.p2.getX() + tri2.p2.getX()) / 2;
        midY = (tri1.p2.getY() + tri2.p2.getY()) / 2;
        midZ = (tri1.p2.getZ() + tri2.p2.getZ()) / 2;

        this.move(-midX, -midY, -midZ);
        for (int i = 0; i < al.size(); i++) {
            Face tri = (Face) al.get(i);
            tri.turnX(ang);
        }
        this.move(midX, midY, midZ);
    }

    public void turnY(double ang) {
        double midX, midY, midZ;
        Face tri1, tri2;

        tri1 = (Face) al.get(0);
        tri2 = (Face) al.get(al.size() - 1);
        midX = (tri1.p2.getX() + tri2.p2.getX()) / 2;
        midY = (tri1.p2.getY() + tri2.p2.getY()) / 2;
        midZ = (tri1.p2.getZ() + tri2.p2.getZ()) / 2;

        this.move(-midX, -midY, -midZ);
        for (int i = 0; i < al.size(); i++) {
            Face tri = (Face) al.get(i);
            tri.turnY(ang);
        }
        this.move(midX, midY, midZ);
    }

    public void turnZ(double ang) {
        double midX, midY, midZ;
        Face tri1, tri2;

        tri1 = (Face) al.get(0);
        tri2 = (Face) al.get(al.size() - 1);
        midX = (tri1.p2.getX() + tri2.p2.getX()) / 2;
        midY = (tri1.p2.getY() + tri2.p2.getY()) / 2;
        midZ = (tri1.p2.getZ() + tri2.p2.getZ()) / 2;

        this.move(-midX, -midY, -midZ);
        for (int i = 0; i < al.size(); i++) {
            Face tri = (Face) al.get(i);
            tri.turnZ(ang);
        }
        this.move(midX, midY, midZ);
    }

    private float getDist(Point3D p1, Point3D p2) {

        return (float) Math.sqrt((p1.getX() - p2.getX()) * (p1.getX() - p2.getX()) + (p1.getY() -
                p2.getY()) * (p1.getY() - p2.getY()) + (p1.getZ() - p2.getZ()) * (p1.getZ() - p2.getZ()));

    }

    public void zoom(double k) {
        double midX, midY, midZ;
        Face tri1, tri2;
        tri1 = (Face) al.get(0);
        tri2 = (Face) al.get(al.size() - 1);
       // float d = getDist(tri1.p1, tri1.p2);
        //if ((d > 5) ) {
            midX = (tri1.p2.getX() + tri2.p2.getX()) / 2;
            midY = (tri1.p2.getY() + tri2.p2.getY()) / 2;
            midZ = (tri1.p2.getZ() + tri2.p2.getZ()) / 2;

            this.move(-midX, -midY, -midZ);
            this.scale(k, k, k);
            this.move(midX, midY, midZ);
        //}
    }

    public void turnCenter(double k) {
        double midX, midY, midZ;
        Face tri1, tri2;

        tri1 = (Face) al.get(0);
        tri2 = (Face) al.get(al.size() - 1);
        midX = (tri1.p2.getX() + tri2.p2.getX()) / 2;
        midY = (tri1.p2.getY() + tri2.p2.getY()) / 2;
        midZ = (tri1.p2.getZ() + tri2.p2.getZ()) / 2;

        this.move(-midX, -midY, -midZ);
        this.turnX(k);
        this.turnY(k * 1.1);
        this.turnZ(k * 1.2);
        this.move(midX, midY, midZ);
    }

    public void drawCube(Canvas g) {
        for (int i = 0; i < al.size(); i++) {
            Face tri = (Face) al.get(i);
            if (HowSeen(tri) < 0) {

                new Face(tri.p1, tri.p2, tri.p3, setRGBColor(tri, HowSeen(tri))).drawFace(g);

            }
        }
    }

      public void drawSolidCube(Canvas g) {
          for (int i = 0; i < al.size(); i++) {
              Face tri = (Face) al.get(i);

              if (HowSeen(tri) < 0) {

                  new Face(tri.p1, tri.p2, tri.p3,  setBlueColor(tri, HowSeen(tri))).drawSolidFace(g);
              }
          }
      }

    public boolean isSeen(Face face, int x0, int y0, int z0) {
        double dist = Point3D.DIST;
        Point3D k1 = face.p1;
        Point3D k2 = face.p2;
        Point3D k3 = face.p3;
        double a = k1.getY() * (k2.getZ() + dist - k3.getZ() + dist)
                + k2.getY() * (k3.getZ() + dist - k1.getZ() + dist)
                + k3.getY() * (k1.getZ() + dist - k2.getZ() + dist);
        double b = (k1.getZ() + dist) * (k2.getX() - k3.getX())
                + (k2.getZ() + dist) * (k3.getX() - k1.getX())
                + (k3.getZ() + dist) * (k1.getX() - k2.getX());
        double c = k1.getX() * (k2.getY() - k3.getY()) + k2.getX() * (k3.getY()
                - k1.getY()) + k3.getX() * (k1.getY() - k2.getY());
        double d = -k1.getX() * (k2.getY() * (k3.getZ()
                + dist) - k3.getY() * (k2.getZ() + dist))
                - k2.getX() * (k3.getY() * (k1.getZ() + dist)
                - k1.getY() * (k3.getZ() + dist))
                - k3.getX() * (k1.getY() * (k2.getZ() + dist)
                - k2.getY() * (k1.getZ() + dist));
        return a * x0 + b * y0 + c * z0 + d >= 0;

    }

    public double HowSeen(Face face) {
        Point3D normal;
        Point3D facecenter;
        double ln, l;
        double ScalarProduct;

        facecenter = face.getSideCenter();
        facecenter.move(0, 0, Point3D.DIST);
        l = Math.sqrt((facecenter.getX() * facecenter.getX()) + (facecenter.getY() * facecenter.getY()) + (facecenter.getZ() * facecenter.getZ()));
        facecenter.setX(facecenter.getX() / l);
        facecenter.setY(facecenter.getY() / l);
        facecenter.setZ(facecenter.getZ() / l);

        double x1 = face.p1.getX();
        double y1 = face.p1.getY();
        double z1 = face.p1.getZ();
        double x2 = face.p2.getX();
        double y2 = face.p2.getY();
        double z2 = face.p2.getZ();
        double x3 = face.p3.getX();
        double y3 = face.p3.getY();
        double z3 = face.p3.getZ();



        normal = new Point3D((y1 - y2) * (z1 - z3) - (z1 - z2) * (y1 - y3), (z1 - z2) * (x1 - x3) - (x1 - x2) * (z1 - z3), (x1 - x2) * (y1 - y3) - (y1 - y2) * (x1 - x3));

        ln = Math.sqrt((normal.getX() * normal.getX()) + (normal.getY() * normal.getY()) + (normal.getZ() * normal.getZ()));
        normal.setX(normal.getX() / ln);
        normal.setY(normal.getY() / ln);
        normal.setZ(normal.getZ() / ln);


        ScalarProduct = (normal.getX() * facecenter.getX() + normal.getY() * facecenter.getY() + normal.getZ() * facecenter.getZ());
        return ScalarProduct;
    }

    public int setRGBColor(Face face, double coefficient) {
        coefficient = Math.abs(coefficient);
        int col = face.color;
        int red = (int) (100 + ((col & 0xff0000) >>> 16) * (coefficient)) - 100;
        int green = (int) (100 + ((col & 0x00ff00) >>> 8) * (coefficient)) - 100;
        int blue = (int) (100 + ((col & 0x0000ff)) * (coefficient)) - 100;
//System.out.println("red = "+red+" green = "+green+" blue = "+blue );

        return Color.argb(255, red, green, blue);//new Color(red, green, blue);

    }
    public int setBlueColor(Face face, double coefficient) {
        coefficient = Math.abs(coefficient);
        int col = Color.BLUE;
      //  int red = (int) (100 + ((col & 0xff0000) >>> 16) * (coefficient)) - 100;
       // int green = (int) (100 + ((col & 0x00ff00) >>> 8) * (coefficient)) - 100;
        int blue = (int) (100 + ((col & 0x0000ff)) * (coefficient)) - 100;
//System.out.println("red = "+red+" green = "+green+" blue = "+blue );

        return Color.argb(255,0, 0, blue);//new Color(red, green, blue);

    }
}