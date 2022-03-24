import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NodeTests
{
    List<Node> temp = new ArrayList<>();
    @BeforeEach
    void setUp() throws Exception
    {
        NodeImpl wonderland = new NodeImpl("Wonderland", 3);
        temp.add(wonderland);
        NodeImpl harvard = new NodeImpl("Harvard", 14);
        temp.add(harvard);
        NodeImpl central = new NodeImpl("Central", 21);
        temp.add(central);
    }

    @Test
    void getNameTest() throws Exception
    {
        String expected = "Harvard";
        String actual = temp.get(1).getNodeName();
        assertEquals(expected,actual);
    }
    @Test
    void getIDTest() throws Exception
    {
        int expected = 21;
        int actual = temp.get(2).getNodeID();
        assertEquals(expected,actual);
    }

}