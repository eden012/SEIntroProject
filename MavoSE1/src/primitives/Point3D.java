package primitives;
import static primitives.Util.*;

import static java.lang.Math.pow;

import primitives.Coordinate;
import primitives.Vector;
/**
 * @author Eden
 */
public class Point3D {

    public final static Point3D ZERO = new Point3D(0.0,0.0,0.0);
    final Coordinate _x;
    final Coordinate _y;
    final Coordinate _z;

  //----------------------constructors----------------------------//
    public Point3D(Coordinate x, Coordinate y, Coordinate z) {
        this._x = x;
        this._y = y;
        this._z = z;
    }
    public Point3D(double x, double y, double z) {
        this._x = new Coordinate(x);
        this._y = new Coordinate(y);
        this._z = new Coordinate(z);
    }

    public Point3D (Point3D point3D){
        this(point3D._x._coord,point3D._y._coord,point3D._z._coord );
    }
    //------------------getters and setters----------------------------//

//only getters because the filds are final.
    public Coordinate getX() { return _x;}

    public Coordinate getY() { return _y; }

    public Coordinate getZ() { return _z; }


    
 //------------------functions----------------------------//
   

    /**
     *

     * @return    squere distance
     */
    public Point3D add(Vector vector){
        return new Point3D(
                this._x._coord + vector._head._x._coord,
                this._y._coord + vector._head._y._coord,
                this._z._coord + vector._head._z._coord);
        /*return new Point3D(
                this._x._coord + point3D._x._coord,
                this._y._coord + point3D._y._coord,
                this._z._coord + point3D._z._coord);*/

    }
// two substract function, Vector, Point3D.
    public Vector subtract(Point3D otherPoint3D) throws IllegalAccessException {
        return new Vector(
                this._x._coord - otherPoint3D._x._coord,
                this._y._coord - otherPoint3D._y._coord,
                this._z._coord - otherPoint3D._z._coord);
    }

   public Point3D substract(Vector vector) {
        return new Point3D(
                this._x._coord - vector._head._x._coord,
                this._y._coord - vector._head._y._coord,
                this._z._coord - vector._head._z._coord);


    }
    public double distanceSquare(Point3D other){
        return   Math.pow(this._x.get() - other._x.get(),2)
                +Math.pow(this._y.get() - other._y.get(),2)
                +Math.pow(this._z.get() - other._z.get(),2);
    }
    public double distance(Point3D other){
          return Math.sqrt(distanceSquare(other));
    }

    public boolean equals (Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point3D point3D = (Point3D) o;
        return _x.equals(point3D._x) &&
                _y.equals(point3D._y) &&
                _z.equals(point3D._z);
    }







    @Override
    public String toString() {
        return "Point3D{" +
                "_x=" + _x +
                ", _y=" + _y +
                ", _z=" + _z +
                '}';
    }


}
