
import main.LoopResult;
import main.Node;
import main.SinglyLinkedList;
import org.junit.Test;

import static org.junit.Assert.*;

public class SinglyLinkedListTest {

    SinglyLinkedList list = new SinglyLinkedList();
    LoopResult result;

    @Test
    public void testEmptyList() {
        result = list.findLoop();
        assertFalse(result.isCycleExists());
    }

    @Test
    public void testSingleElementList() {
            list.add(1);
        result = list.findLoop();
        assertFalse(result.isCycleExists());
    }


    @Test
    public void testListWithoutLoop() {
        for (int i = 0; i <= 5; i++) {
            list.add(i);
        }
        result = list.findLoop();
        assertFalse(result.isCycleExists());
       // assertEquals(null, list.findNextNodeAfterLoop().getElement());
    }

    @Test
    public void testListWithLoop() {
        for (int i = 0; i <= 5; i++) {
            list.add(i);
        }
        Node n11 = new Node<>("11");
        list.addNode(n11, list.getNode(3));

        result = list.findLoop();
        assertTrue(result.isCycleExists());
        assertEquals(2, list.findNextNodeAfterLoop().getElement());

    }
}
