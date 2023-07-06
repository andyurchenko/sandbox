package main.it.sevenbits;

public class Segment {
    private Point pointOne;
    private Point pointTwo;

    public Segment(Point pointOne, Point pointTwo) {
        this.pointOne = pointOne;
        this.pointTwo = pointTwo;
    }

    public void setPointOne(Point pointOne) {
        this.pointOne = pointOne;
    }

    public void setPointTwo(Point pointTwo) {
        this.pointTwo = pointTwo;
    }

    double getLengthOfSegment() {
        return Math.sqrt(
                Math.pow( pointTwo.getX() - pointOne.getX(), 2) + Math.pow(pointTwo.getY() - pointOne.getY(), 2)
               );
    }
}
