package main.it.sevenbits;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int NUMBER_OF_SEGMENTS = 10;
        int BOUND_FOR_CARTESIAN_COORDINATE_SYSTEM = 10;

        Random random = new Random();
        Segment[] segments = new Segment[NUMBER_OF_SEGMENTS];
        double maxLength = Double.MIN_VALUE;

        for(int i = 0; i < NUMBER_OF_SEGMENTS; i++) {
            segments[i] = new Segment(
                            new Point(random.nextInt(2 * BOUND_FOR_CARTESIAN_COORDINATE_SYSTEM) - BOUND_FOR_CARTESIAN_COORDINATE_SYSTEM,
                                    random.nextInt(2 * BOUND_FOR_CARTESIAN_COORDINATE_SYSTEM) - BOUND_FOR_CARTESIAN_COORDINATE_SYSTEM),
                            new Point(random.nextInt(2 * BOUND_FOR_CARTESIAN_COORDINATE_SYSTEM) - BOUND_FOR_CARTESIAN_COORDINATE_SYSTEM,
                                    random.nextInt(2 * BOUND_FOR_CARTESIAN_COORDINATE_SYSTEM) - BOUND_FOR_CARTESIAN_COORDINATE_SYSTEM));
            double lengthOfCurrentSegment = segments[i].getLengthOfSegment();
            System.out.println("The length of current segment №" + i +" is " + lengthOfCurrentSegment);
            if(lengthOfCurrentSegment > maxLength) {
                maxLength = lengthOfCurrentSegment;
            }

        }
        System.out.println("The max length is " + maxLength);
    }
}
