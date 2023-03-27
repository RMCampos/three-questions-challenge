package blog.ricardocampos;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

class Third {

  private static final Logger logger = Logger.getLogger(Third.class.getName());

  public static BigDecimal closestPointPair(int[][] p) {
    List<Point> points = new ArrayList<>();

    // Create a list of points
    for (int i = 0; i < p.length; i++) {
      // BigDecimal x = new BigDecimal(String.valueOf(p[i][0]));
      // BigDecimal y = new BigDecimal(String.valueOf(p[i][1]));

      // logger.info("x=[" + x + "], y=[" + y + "]");
      points.add(new Point(p[i][0], p[i][1]));
    }

    List<BigDecimal> distances = new ArrayList<>();

    // Find out the closest one
    for (int i = 0; i < points.size(); i++) {
      Point pointA = points.get(i);

      for (int j = 0; j < points.size(); j++) {
        if (i == j) {
          continue;
        }

        Point pointB = points.get(j);
        BigDecimal distance = getDistance(pointA, pointB);

        if (!distances.contains(distance)) {
          distances.add(distance);
          logger.info(String.format("Points: %s - %s", pointA, pointB));
          logger.info(String.format("Distance: %s", distance));
        }
      }
    }

    distances.sort(BigDecimal::compareTo);

    return distances.get(0).setScale(9, RoundingMode.HALF_UP);
  }

  private static BigDecimal getDistance(Point a, Point b) {
    BigDecimal xResult = new BigDecimal(String.valueOf(b.getX() - a.getX())).pow(2);
    BigDecimal yResult = new BigDecimal(String.valueOf(b.getY() - a.getY())).pow(2);
    BigDecimal partial = xResult.add(yResult);
    return new BigDecimal(String.valueOf(Math.sqrt(partial.doubleValue())));
  }
}
