package primitives;

public class Vector{
    Point3D _head;
    private Object Point3D;

// ----------------------------constuctors----------------------------//

    public Vector(Point3D point) throws IllegalAccessException {
        if(point.equals(point.ZERO)){
            throw new IllegalAccessException("Point3D(0.0,0.0,0.0) not Valid for vector head");

        }

        this._head = new Point3D (point._x._coord,point._y._coord,point._z._coord);
    }

    public Vector (Point3D p1, Point3D p2) throws IllegalAccessException {
        this(p1.substract(p2));
    }

    public Vector (double x, double y, double z) throws IllegalAccessException {
        this._head=new Point3D(x,y,z);
        if(_head.equals(this._head.ZERO)){
            throw new IllegalAccessException("Point3D(0.0,0.0,0.0) not valid for vecto head");
        }


    }

    public Vector(Vector vector) throws IllegalAccessException {
        this(vector._head);
    }


//----------------------------getters and setters----------------------------//

    public Point3D getHead() {
       // if(point.equals(Point3D))
        return _head;
    }

    public void setHead(Point3D head) {
        _head = head;
    }

// ----------------------------funcions----------------------------//

    public Vector add(Vector vector) throws IllegalAccessException {
        return new Vector(
                this._head._x._coord + vector._head._x._coord,
                this._head._y._coord + vector._head._y._coord,
                this._head._z._coord + vector._head._z._coord);
    }
    public  Vector substract(Vector vector) throws IllegalAccessException {
        return new Vector(
                this._head._x._coord - vector._head._x._coord,
                this._head._y._coord - vector._head._y._coord,
                this._head._z._coord - vector._head._z._coord);

}
    public Vector scale (double scalingFactor) throws IllegalAccessException {
        return new Vector(
                scalingFactor * _head._x._coord,
                scalingFactor * _head._y._coord,
                scalingFactor * _head._z._coord);

    }
    public Vector crossProduct(Vector v) throws IllegalAccessException {
        double w1 = this._head._y._coord * v._head._z._coord - this._head._z._coord * v._head._y._coord;
        double w2 = this._head._z._coord * v._head._x._coord - this._head._x._coord * v._head._z._coord;
        double w3 = this._head._x._coord * v._head._y._coord - this._head._y._coord * v._head._x._coord;

        return new Vector(w1, w2, w3);
    }
    public double dotProduct(Vector v) {
        return (this._head._x._coord * v._head._x._coord +
                this._head._y._coord * v._head._y._coord +
                this._head._z._coord * v._head._z._coord);
    }
    public double lengthSquared() {
        double xx = this._head._x._coord * this._head._x._coord;
        double yy = this._head._y._coord * this._head._y._coord;
        double zz = this._head._z._coord * this._head._z._coord;

        return xx + yy + zz;

    }
    public double length() {
        return Math.sqrt(lengthSquared());
    }
    public Vector normalize() {

        double x = this._head._x._coord;
        double y = this._head._y._coord;
        double z = this._head._z._coord;

        double length = this.length();

        if (length == 0)
            throw new ArithmeticException("divide by Zero");

        this._head = new Point3D(x / length, y / length, z / length);
        return this;
    }
    public Vector normalized() throws IllegalAccessException {
        Vector vector = new Vector(this);
        return vector.normalize();
    }



    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector vector = (Vector) o;
        return _head.equals(vector._head);
    }
    public String toString() {
        return _head.toString();
    }


    private class ZERO {
    }
}





