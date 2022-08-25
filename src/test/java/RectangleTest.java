import com.osatodev.rectangle.Point;
import com.osatodev.rectangle.Rectangle;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class RectangleTest {

    @InjectMocks
    private Rectangle rectangle;


    @Test
    public void test_GivenRectangleCoordinates_then_NoContainmentAndIntersection() {
        Point rect1Point1 = new Point(3,8);
        Point rect1Point2 = new Point(9,2);
        Point rect2Point1 = new Point(9,7);
        Point rect2Point2 = new Point(12,3);

        final String containment = rectangle.containment(rect1Point1, rect1Point2, rect2Point1, rect2Point2);

        Assert.assertNotEquals("containment", containment);
        Assert.assertEquals("no containment and intersection", containment);
    }

    @Test
    public void test_GivenRectangleCoordinates_then_ContainmentExists() {
        Point rect1Point1 = new Point(3,8);
        Point rect1Point2 = new Point(9,2);
        Point rect2Point1 = new Point(5,7);
        Point rect2Point2 = new Point(7,5);

        final String containment = rectangle.containment(rect1Point1, rect1Point2, rect2Point1, rect2Point2);

        Assert.assertEquals("containment", containment);
    }


    @Test
    public void test_GivenRectangleCoordinates_then_PartialAdjacencyExists() {
        Point rect1Point1 = new Point(3,8);
        Point rect1Point2 = new Point(9,2);
        Point rect2Point1 = new Point(9,9);
        Point rect2Point2 = new Point(12,3);

        final String adjacency = rectangle.adjacency(rect1Point1, rect1Point2, rect2Point1, rect2Point2);

        Assert.assertEquals("partial adjacency", adjacency);
        Assert.assertNotEquals("no adjacency", adjacency);
    }

    @Test
    public void test_GivenRectangleCoordinates_then_SublineAdjacencyExists() {
        Point rect1Point1 = new Point(3,8);
        Point rect1Point2 = new Point(9,2);
        Point rect2Point1 = new Point(9,7);
        Point rect2Point2 = new Point(12,3);

        final String adjacency = rectangle.adjacency(rect1Point1, rect1Point2, rect2Point1, rect2Point2);

        Assert.assertEquals("sub-line adjacency", adjacency);
        Assert.assertNotEquals("proper adjacency", adjacency);

    }

    @Test
    public void test_GivenRectangleCoordinates_then_ProperAdjacencyExists() {
        Point rect1Point1 = new Point(3,8);
        Point rect1Point2 = new Point(9,2);
        Point rect2Point1 = new Point(9,8);
        Point rect2Point2 = new Point(12,2);

        final String adjacency = rectangle.adjacency(rect1Point1, rect1Point2, rect2Point1, rect2Point2);

        Assert.assertEquals("proper adjacency", adjacency);
        Assert.assertNotEquals("no adjacency", adjacency);
    }

    @Test
    public void test_GivenRectangleCoordinates_then_ReturnNoAdjacencyExists() {
        Point rect1Point1 = new Point(3,8);
        Point rect1Point2 = new Point(9,2);
        Point rect2Point1 = new Point(10,7);
        Point rect2Point2 = new Point(12,3);

        final String adjacency = rectangle.adjacency(rect1Point1, rect1Point2, rect2Point1, rect2Point2);

        Assert.assertNotEquals("adjacency exists", adjacency);
        Assert.assertEquals("no adjacency", adjacency);
    }

    @Test
    public void test_GivenRectangleCoordinates_NoSideIntersecting_then_ReturnEmptyList() {
        Point rect1Point1 = new Point(3,8);
        Point rect1Point2 = new Point(9,2);
        //case 3
        Point rect2Point1 = new Point(2,9);
        Point rect2Point2 = new Point(2,7);

        List<Point> points2 = rectangle.intersection(rect1Point1, rect1Point2, rect2Point1, rect2Point2);

        Assert.assertEquals(0, points2.size());
        assert (points2.isEmpty());

    }
    @Test
    public void test_GivenRectangleCoordinates_LeftSideIntersecting1_then_ReturnList() {
        Point rect1Point1 = new Point(3,8);
        Point rect1Point2 = new Point(9,2);
        //case 2
        Point rect2Point1 = new Point(1,9);
        Point rect2Point2 = new Point(5,7);

        List<Point> points = rectangle.intersection(rect1Point1, rect1Point2, rect2Point1, rect2Point2);

        Assert.assertEquals(2, points.size());
        Assert.assertEquals(7.0, points.get(1).getY(), 0.0);

    }

    @Test
    public void test_GivenRectangleCoordinates_LeftSideIntersecting2_then_ReturnIntersectionList() {
        Point rect1Point1 = new Point(3,8);
        Point rect1Point2 = new Point(9,2);
        //case 4
        Point rect2Point1 = new Point(2,5);
        Point rect2Point2 = new Point(2,6);

        List<Point> points = rectangle.intersection(rect1Point1, rect1Point2, rect2Point1, rect2Point2);
        Assert.assertEquals(2, points.size());
        Assert.assertEquals(6.0, points.get(1).getY(), 0.0);


    }

    @Test
    public void test_GivenRectangleCoordinates_LeftSideIntersecting3_then_ReturnIntersectionList() {
        Point rect1Point1 = new Point(3,8);
        Point rect1Point2 = new Point(9,2);
        //case 5
        Point rect2Point1 = new Point(2,3);
        Point rect2Point2 = new Point(4,1);

        List<Point> points = rectangle.intersection(rect1Point1, rect1Point2, rect2Point1, rect2Point2);
        Assert.assertNotEquals(0, points.size());
        Assert.assertEquals(2, points.size());
        Assert.assertEquals(4.0, points.get(0).getX(), 0.0);


    }

    @Test
    public void test_GivenRectangleCoordinates_BottomIntersecting_then_ReturnIntersectionList() {
        Point rect1Point1 = new Point(3,8);
        Point rect1Point2 = new Point(9,2);
        //case 6
        Point rect2Point1 = new Point(5,3);
        Point rect2Point2 = new Point(7,1);

        List<Point> points = rectangle.intersection(rect1Point1, rect1Point2, rect2Point1, rect2Point2);
        Assert.assertNotEquals(0, points.size());
        Assert.assertEquals(2, points.size());
        Assert.assertEquals(5.0, points.get(0).getX(), 0.0);


    }

    @Test
    public void test_GivenRectangleCoordinates_RightSideIntersecting1_then_ReturnIntersectionList() {
        Point rect1Point1 = new Point(3,8);
        Point rect1Point2 = new Point(9,2);
        //case 7
        Point rect2Point1 = new Point(8,3);
        Point rect2Point2 = new Point(10,1);

        List<Point> points2 = rectangle.intersection(rect1Point1, rect1Point2, rect2Point1, rect2Point2);

        Assert.assertNotEquals(0, points2.size());
        Assert.assertEquals(2, points2.size());
        Assert.assertEquals(8.0, points2.get(0).getX(), 0.0);


    }

    @Test
    public void test_GivenRectangleCoordinates_RightSideIntersecting2_then_ReturnIntersectionList() {
        Point rect1Point1 = new Point(3,8);
        Point rect1Point2 = new Point(9,2);
        //case 8
        Point rect2Point1 = new Point(8,5);
        Point rect2Point2 = new Point(10,6);

        List<Point> points2 = rectangle.intersection(rect1Point1, rect1Point2, rect2Point1, rect2Point2);

        assert (!points2.isEmpty());
        Assert.assertEquals(5.0, points2.get(0).getY(), 0.0);

    }

    @Test
    public void test_GivenRectangleCoordinates_RightSideIntersecting3_then_ReturnIntersectionList() {
        Point rect1Point1 = new Point(3,8);
        Point rect1Point2 = new Point(9,2);
        //case 9
        Point rect2Point1 = new Point(8,9);
        Point rect2Point2 = new Point(10,7);

        List<Point> points2 = rectangle.intersection(rect1Point1, rect1Point2, rect2Point1, rect2Point2);

        assert (!points2.isEmpty());
        Assert.assertEquals(8.0, points2.get(0).getY(), 0.0);

    }

    @Test
    public void test_GivenRectangleCoordinates_TopSideIntersecting_then_ReturnIntersectionList() {

        Point rect1Point1 = new Point(3,8);
        Point rect1Point2 = new Point(9,2);

        Point rect2Point1 = new Point(5,9);
        Point rect2Point2 = new Point(7,7);


        List<Point> points2 = rectangle.intersection(rect1Point1, rect1Point2, rect2Point1, rect2Point2);

        assert (!points2.isEmpty());
        Assert.assertEquals(2, points2.size());
        Assert.assertEquals(5.0, points2.get(0).getX(), 0.0);

    }

}
