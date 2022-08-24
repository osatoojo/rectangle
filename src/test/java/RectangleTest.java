import com.osatodev.rectangle.Point;
import com.osatodev.rectangle.Rectangle;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.List;

public class RectangleTest {

    @InjectMocks
    private Rectangle rectangle;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }




    @Test
    public void test_GivenRectangleCoordinates_then_NoContainmentAndIntersection() {
        Point a1 = new Point(), a2 = new  Point(), a3 = new  Point(), a4 = new  Point(), b1 = new  Point(), b2 = new  Point(), b3 = new  Point(), b4 = new  Point();
        a1.setX(3); a1.setY(8);
        a2.setX(9); a2.setY(8);
        a3.setX(3); a3.setY(2);
        a4.setX(9); a4.setY(2);

        b1.setX(9); b1.setY(7);
        b2.setX(12); b2.setY(7);
        b3.setX(9); b3.setY(3);
        b4.setX(12); b4.setY(3);

        final String containment = rectangle.containment(a1, a4, b1, b4);

        Assert.assertNotEquals("containment",containment );
        Assert.assertEquals("no containment and intersection",containment );
    }

    @Test
    public void test_GivenRectangleCoordinates_then_ContainmentExists() {
        Point a1 = new Point(), a2 = new  Point(), a3 = new  Point(), a4 = new  Point(), b1 = new  Point(), b2 = new  Point(), b3 = new  Point(), b4 = new  Point();
        a1.setX(3); a1.setY(8);
        a2.setX(9); a2.setY(8);
        a3.setX(3); a3.setY(2);
        a4.setX(9); a4.setY(2);

        b1.setX(5); b1.setY(7);
        b2.setX(7); b2.setY(7);
        b3.setX(5); b3.setY(5);
        b4.setX(7); b4.setY(5);

        final String containment = rectangle.containment(a1, a4, b1, b4);

        Assert.assertEquals("containment",containment );
    }


    @Test
    public void test_GivenRectangleCoordinates_then_PartialAdjacencyExists() {
        Point a1 = new Point(), a2 = new  Point(), a3 = new  Point(), a4 = new  Point(), b1 = new  Point(), b2 = new  Point(), b3 = new  Point(), b4 = new  Point();
        a1.setX(3); a1.setY(8);
        a2.setX(9); a2.setY(8);
        a3.setX(3); a3.setY(2);
        a4.setX(9); a4.setY(2);

        b1.setX(9); b1.setY(9);
        b2.setX(12); b2.setY(9);
        b3.setX(9); b3.setY(3);
        b4.setX(12); b4.setY(3);

        final String adjacency = rectangle.adjacency(a1, a4, b1, b4);

        Assert.assertEquals("partial adjacency",adjacency );
        Assert.assertNotEquals("no adjacency",adjacency );
    }

    @Test
    public void test_GivenRectangleCoordinates_then_SublineAdjacencyExists() {
        Point a1 = new Point(), a2 = new  Point(), a3 = new  Point(), a4 = new  Point(), b1 = new  Point(), b2 = new  Point(), b3 = new  Point(), b4 = new  Point();
        a1.setX(3); a1.setY(8);
        a2.setX(9); a2.setY(8);
        a3.setX(3); a3.setY(2);
        a4.setX(9); a4.setY(2);

        b1.setX(9); b1.setY(7);
        b2.setX(12); b2.setY(7);
        b3.setX(9); b3.setY(3);
        b4.setX(12); b4.setY(3);

        final String adjacency = rectangle.adjacency(a1, a4, b1, b4);

        Assert.assertEquals("sub-line adjacency",adjacency );
        Assert.assertNotEquals("proper adjacency",adjacency );

    }

    @Test
    public void test_GivenRectangleCoordinates_then_ProperAdjacencyExists() {
        Point a1 = new Point(), a2 = new  Point(), a3 = new  Point(), a4 = new  Point(), b1 = new  Point(), b2 = new  Point(), b3 = new  Point(), b4 = new  Point();
        a1.setX(3); a1.setY(8);
        a2.setX(9); a2.setY(8);
        a3.setX(3); a3.setY(2);
        a4.setX(9); a4.setY(2);

        b1.setX(9); b1.setY(8);
        b2.setX(12); b2.setY(8);
        b3.setX(9); b3.setY(2);
        b4.setX(12); b4.setY(2);

        final String adjacency = rectangle.adjacency(a1, a4, b1, b4);

        Assert.assertEquals("proper adjacency",adjacency );
        Assert.assertNotEquals("no adjacency",adjacency );
    }

    @Test
    public void test_GivenRectangleCoordinates_then_ReturnNoAdjacencyExists() {
        Point a1 = new Point(), a2 = new  Point(), a3 = new  Point(), a4 = new  Point(), b1 = new  Point(), b2 = new  Point(), b3 = new  Point(), b4 = new  Point();
        a1.setX(3); a1.setY(8);
        a2.setX(9); a2.setY(8);
        a3.setX(3); a3.setY(2);
        a4.setX(9); a4.setY(2);

        b1.setX(10); b1.setY(7);
        b2.setX(12); b2.setY(7);
        b3.setX(10); b3.setY(3);
        b4.setX(12); b4.setY(3);

        final String adjacency = rectangle.adjacency(a1, a4, b1, b4);

        Assert.assertNotEquals("adjacency exists",adjacency );
        Assert.assertEquals("no adjacency",adjacency );
    }

    @Test
    public void test_GivenRectangleCoordinates_LeftIntersecting1_then_ReturnList() {
        Point a1 = new Point(), a2 = new  Point(), a3 = new  Point(), a4 = new  Point(), b1 = new  Point(), b2 = new  Point(), b3 = new  Point(), b4 = new  Point();
        //case 2
        a1.setX(3); a1.setY(8);
        a2.setX(9); a2.setY(8);
        a3.setX(3); a3.setY(2);
        a4.setX(9); a4.setY(2);

        b1.setX(1); b1.setY(9);
        b2.setX(5); b2.setY(9);
        b3.setX(1); b3.setY(7);
        b4.setX(5); b4.setY(7);

        List<Point> points = rectangle.intersection(a1, a2, a3, a4, b1, b2, b3, b4);

        Assert.assertEquals(2,points.size() );
        Assert.assertEquals(7.0,points.get(1).getY(),0.0);

        b1.setX(1); b1.setY(9);
        b2.setX(2); b2.setY(9);
        b3.setX(1); b3.setY(7);
        b4.setX(2); b4.setY(7);


        List<Point> points2 = rectangle.intersection(a1, a2, a3, a4, b1, b2, b3, b4);
        //todo case 3 : check this test
        Assert.assertEquals(0,points2.size() );
        Assert.assertNotEquals(7.0,points2.get(1).getY(),0.0);

    }

    @Test
    public void test_GivenRectangleCoordinates_LeftIntersecting2_then_ReturnIntersectionList() {
        Point a1 = new Point(), a2 = new  Point(), a3 = new  Point(), a4 = new  Point(), b1 = new  Point(), b2 = new  Point(), b3 = new  Point(), b4 = new  Point();
        //case 4
        a1.setX(3); a1.setY(8);
        a2.setX(9); a2.setY(8);
        a3.setX(3); a3.setY(2);
        a4.setX(9); a4.setY(2);

        b1.setX(2); b1.setY(5);
        b2.setX(4); b2.setY(5);
        b3.setX(4); b3.setY(6);
        b4.setX(2); b4.setY(6);

        List<Point> points = rectangle.intersection(a1, a2, a3, a4, b1, b2, b3, b4);

        Assert.assertEquals(2,points.size() );
        Assert.assertEquals(6.0,points.get(1).getY(),0.0);


    }

    @Test
    public void test_GivenRectangleCoordinates_LeftIntersecting3_then_ReturnIntersectionList() {
        Point a1 = new Point(), a2 = new  Point(), a3 = new  Point(), a4 = new  Point(), b1 = new  Point(), b2 = new  Point(), b3 = new  Point(), b4 = new  Point();

        //case 5
        a1.setX(3); a1.setY(8);
        a2.setX(9); a2.setY(8);
        a3.setX(3); a3.setY(2);
        a4.setX(9); a4.setY(2);

        b1.setX(2); b1.setY(3);
        b2.setX(4); b2.setY(3);
        b3.setX(2); b3.setY(1);
        b4.setX(4); b4.setY(1);

        List<Point> points = rectangle.intersection(a1, a2, a3, a4, b1, b2, b3, b4);

        Assert.assertNotEquals(0,points.size() );
        Assert.assertEquals(2,points.size() );
        Assert.assertEquals(4.0,points.get(0).getX(),0.0);


    }

    @Test
    public void test_GivenRectangleCoordinates_BottomIntersecting_then_ReturnIntersectionList() {
        Point a1 = new Point(), a2 = new  Point(), a3 = new  Point(), a4 = new  Point(), b1 = new  Point(), b2 = new  Point(), b3 = new  Point(), b4 = new  Point();

        //case 6
        a1.setX(3); a1.setY(8);
        a2.setX(9); a2.setY(8);
        a3.setX(3); a3.setY(2);
        a4.setX(9); a4.setY(2);

        b1.setX(5); b1.setY(3);
        b2.setX(7); b2.setY(3);
        b3.setX(5); b3.setY(1);
        b4.setX(7); b4.setY(1);

        List<Point> points = rectangle.intersection(a1, a2, a3, a4, b1, b2, b3, b4);

        Assert.assertNotEquals(0,points.size() );
        Assert.assertEquals(2,points.size() );
        Assert.assertEquals(5.0,points.get(0).getX(),0.0);

        //case 7
        b1.setX(8); b1.setY(3);
        b2.setX(10); b2.setY(3);
        b3.setX(8); b3.setY(1);
        b4.setX(10); b4.setY(1);

        List<Point> points2 = rectangle.intersection(a1, a2, a3, a4, b1, b2, b3, b4);

        Assert.assertNotEquals(0,points2.size() );
        Assert.assertEquals(2,points2.size() );
        Assert.assertEquals(8.0,points2.get(0).getX(),0.0);


    }


}
