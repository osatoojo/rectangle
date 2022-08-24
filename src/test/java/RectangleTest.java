import com.osatodev.rectangle.Point;
import com.osatodev.rectangle.Rectangle;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

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
}
