package OnlineQuestions;

public class LeetcodeFindNearestPointThatHasTheSameXorYCoordinate {
    /**
     * Given a point, find the nearest point that is not on the same row or column
     *
     * @param x      The x coordinate of the point you want to find the nearest neighbor for.
     * @param y      The y-coordinate of the point to check.
     * @param points an array of points
     * @return The index of the point that is closest to the given point.
     */
    public static int nearestValidPoint(int x, int y, int[][] points) {

        int minMat = Integer.MAX_VALUE; //Store Manhattan value
        int minDis = Integer.MAX_VALUE; //Store distance
        for (int i = 0; i < points.length; i++) {

            if (points[i][0] == x || points[i][1] == y) { //Check valid row, col

                int value = Math.abs(points[i][0] - x) + Math.abs(points[i][1] - y); //Calculate Manhattan value
                if (value < minMat) { //Update manhattan and index
                    minDis = i;
                    minMat = value;
                }
            }
        }

        return minDis == Integer.MAX_VALUE ? -1 : minDis;
    }

    public static void main(String[] args) {
        System.out.println(nearestValidPoint(0, 0, new int[][]{{1,2},{1,2}}));
    }
}
