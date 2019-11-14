import main.java.model.Pacman;
import main.java.model.World;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PacmanTest {

    private Pacman pacman = new Pacman();
    private World world = new World(5, 5);

    @Before
    public void before() {
        pacman.setWorld(world);
    }

    @Test
    public void placeTest1() {
        pacman.place("-1,-1,NORTH");
        Assert.assertFalse(pacman.getStatus());
    }

    @Test
    public void placeTest2() {
        pacman.place("5,5,NORTH");
        Assert.assertFalse(pacman.getStatus());
    }

    @Test
    public void placeTest3() {
        pacman.place("1,1,NORTH");
        Assert.assertTrue(pacman.getStatus());
    }

    @Test
    public void placeTest4() {
        pacman.place("1,1,xxx");
        Assert.assertFalse(pacman.getStatus());
    }

    @Test
    public void turnTest1() {
        pacman.place("2,2,NORTH");
        pacman.turn("LEFT");
        Assert.assertEquals(pacman.report(), "Output: 2,2,WEST");
    }

    @Test
    public void turnTest2() {
        pacman.place("2,2,NORTH");
        pacman.turn("RIGHT");
        Assert.assertEquals(pacman.report(), "Output: 2,2,EAST");
    }

    @Test
    public void turnTest3() {
        pacman.place("2,2,WEST");
        pacman.turn("RIGHT");
        Assert.assertEquals(pacman.report(), "Output: 2,2,NORTH");
    }

    @Test
    public void moveTest1() {
        pacman.place("2,2,WEST");
        pacman.move();
        Assert.assertEquals(pacman.report(), "Output: 1,2,WEST");
    }

    @Test
    public void moveTest2() {
        pacman.place("0,0,WEST");
        pacman.move();
        Assert.assertEquals(pacman.report(), "Output: 0,0,WEST");
    }

    @Test
    public void moveTest3() {
        pacman.place("4,4,EAST");
        pacman.move();
        Assert.assertEquals(pacman.report(), "Output: 4,4,EAST");
    }

}

