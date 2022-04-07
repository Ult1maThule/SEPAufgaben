import org.apache.commons.math3.geometry.euclidean.twod.Line;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

public class Calculator {
    public int calculate(int pointOne, int pointTwo) {
        Vector2D origin = new Vector2D(0, 0);
        Vector2D vector = new Vector2D(pointOne, pointTwo);

        Line line = new Line(origin, vector, 0);

        return (int) Math.toDegrees(line.getAngle());
    }
}
