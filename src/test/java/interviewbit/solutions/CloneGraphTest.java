package interviewbit.solutions;

import org.junit.Test;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class CloneGraphTest {


    @Test
    public void shouldCloneNonCyclicGraph() {
        CloneGraph.UndirectedGraphNode node1 = new CloneGraph.UndirectedGraphNode(1);
        CloneGraph.UndirectedGraphNode node2 = new CloneGraph.UndirectedGraphNode(2);
        CloneGraph.UndirectedGraphNode node3 = new CloneGraph.UndirectedGraphNode(3);
        CloneGraph.UndirectedGraphNode node4 = new CloneGraph.UndirectedGraphNode(4);
        CloneGraph.UndirectedGraphNode node5 = new CloneGraph.UndirectedGraphNode(5);
        CloneGraph.UndirectedGraphNode node6 = new CloneGraph.UndirectedGraphNode(6);

        node1.neighbors.add(node2);
        node1.neighbors.add(node3);

        node2.neighbors.add(node4);
        node2.neighbors.add(node5);
        node2.neighbors.add(node1);

        node3.neighbors.add(node6);
        node3.neighbors.add(node1);

        node4.neighbors.add(node2);

        node5.neighbors.add(node2);

        node6.neighbors.add(node3);

        CloneGraph.UndirectedGraphNode clonedNode1 = new CloneGraph().solve(node1);
        Optional<CloneGraph.UndirectedGraphNode> clonedNode2Opt = clonedNode1.neighbors.stream().filter(undirectedGraphNode -> undirectedGraphNode.label == 2).findFirst();
        assertTrue(clonedNode2Opt.isPresent());
        CloneGraph.UndirectedGraphNode clonedNode2 = clonedNode2Opt.get();
        Optional<CloneGraph.UndirectedGraphNode> clonedNode3Opt = clonedNode1.neighbors.stream().filter(undirectedGraphNode -> undirectedGraphNode.label == 3).findFirst();
        assertTrue(clonedNode3Opt.isPresent());
        CloneGraph.UndirectedGraphNode clonedNode3 = clonedNode3Opt.get();
        Optional<CloneGraph.UndirectedGraphNode> clonedNode4Opt = clonedNode2.neighbors.stream().filter(undirectedGraphNode -> undirectedGraphNode.label == 4).findFirst();
        assertTrue(clonedNode4Opt.isPresent());
        CloneGraph.UndirectedGraphNode clonedNode4 = clonedNode4Opt.get();
        Optional<CloneGraph.UndirectedGraphNode> clonedNode5Opt = clonedNode2.neighbors.stream().filter(undirectedGraphNode -> undirectedGraphNode.label == 5).findFirst();
        assertTrue(clonedNode5Opt.isPresent());
        CloneGraph.UndirectedGraphNode clonedNode5 = clonedNode5Opt.get();
        Optional<CloneGraph.UndirectedGraphNode> clonedNode6Opt = clonedNode3.neighbors.stream().filter(undirectedGraphNode -> undirectedGraphNode.label == 6).findFirst();
        assertTrue(clonedNode6Opt.isPresent());
        CloneGraph.UndirectedGraphNode clonedNode6 = clonedNode6Opt.get();

        assertNotSame(node1, clonedNode1);
        assertNotSame(node2, clonedNode2);
        assertNotSame(node3, clonedNode3);
        assertNotSame(node4, clonedNode4);
        assertNotSame(node5, clonedNode5);
        assertNotSame(node6, clonedNode6);

        assertEquals(node1.label, clonedNode1.label);
        assertEquals(node2.label, clonedNode2.label);
        assertEquals(node3.label, clonedNode3.label);
        assertEquals(node4.label, clonedNode4.label);
        assertEquals(node5.label, clonedNode5.label);
        assertEquals(node6.label, clonedNode6.label);

        assertTrue(clonedNode1.neighbors.stream().map(undirectedGraphNode -> undirectedGraphNode.label).collect(Collectors.toList()).containsAll(Arrays.asList(2, 3)));
        assertTrue(clonedNode2.neighbors.stream().map(undirectedGraphNode -> undirectedGraphNode.label).collect(Collectors.toList()).containsAll(Arrays.asList(1, 4, 5)));
        assertTrue(clonedNode3.neighbors.stream().map(undirectedGraphNode -> undirectedGraphNode.label).collect(Collectors.toList()).containsAll(Arrays.asList(1, 6)));
        assertTrue(clonedNode4.neighbors.stream().map(undirectedGraphNode -> undirectedGraphNode.label).collect(Collectors.toList()).contains(2));
        assertTrue(clonedNode5.neighbors.stream().map(undirectedGraphNode -> undirectedGraphNode.label).collect(Collectors.toList()).contains(2));
        assertTrue(clonedNode6.neighbors.stream().map(undirectedGraphNode -> undirectedGraphNode.label).collect(Collectors.toList()).contains(3));


    }

    @Test
    public void shouldCloneCyclicGraph() {
        CloneGraph.UndirectedGraphNode node1 = new CloneGraph.UndirectedGraphNode(1);
        CloneGraph.UndirectedGraphNode node2 = new CloneGraph.UndirectedGraphNode(2);
        CloneGraph.UndirectedGraphNode node3 = new CloneGraph.UndirectedGraphNode(3);
        CloneGraph.UndirectedGraphNode node4 = new CloneGraph.UndirectedGraphNode(4);
        CloneGraph.UndirectedGraphNode node5 = new CloneGraph.UndirectedGraphNode(5);
        CloneGraph.UndirectedGraphNode node6 = new CloneGraph.UndirectedGraphNode(6);

        node1.neighbors.add(node2);
        node1.neighbors.add(node3);

        node2.neighbors.add(node4);
        node2.neighbors.add(node5);
        node2.neighbors.add(node1);

        node3.neighbors.add(node6);
        node3.neighbors.add(node1);

        node4.neighbors.add(node2);

        node5.neighbors.add(node2);
        node5.neighbors.add(node6);

        node6.neighbors.add(node3);
        node6.neighbors.add(node5);

        CloneGraph.UndirectedGraphNode clonedNode1 = new CloneGraph().solve(node1);
        Optional<CloneGraph.UndirectedGraphNode> clonedNode2Opt = clonedNode1.neighbors.stream().filter(undirectedGraphNode -> undirectedGraphNode.label == 2).findFirst();
        assertTrue(clonedNode2Opt.isPresent());
        CloneGraph.UndirectedGraphNode clonedNode2 = clonedNode2Opt.get();
        Optional<CloneGraph.UndirectedGraphNode> clonedNode3Opt = clonedNode1.neighbors.stream().filter(undirectedGraphNode -> undirectedGraphNode.label == 3).findFirst();
        assertTrue(clonedNode3Opt.isPresent());
        CloneGraph.UndirectedGraphNode clonedNode3 = clonedNode3Opt.get();
        Optional<CloneGraph.UndirectedGraphNode> clonedNode4Opt = clonedNode2.neighbors.stream().filter(undirectedGraphNode -> undirectedGraphNode.label == 4).findFirst();
        assertTrue(clonedNode4Opt.isPresent());
        CloneGraph.UndirectedGraphNode clonedNode4 = clonedNode4Opt.get();
        Optional<CloneGraph.UndirectedGraphNode> clonedNode5Opt = clonedNode2.neighbors.stream().filter(undirectedGraphNode -> undirectedGraphNode.label == 5).findFirst();
        assertTrue(clonedNode5Opt.isPresent());
        CloneGraph.UndirectedGraphNode clonedNode5 = clonedNode5Opt.get();
        Optional<CloneGraph.UndirectedGraphNode> clonedNode6Opt = clonedNode3.neighbors.stream().filter(undirectedGraphNode -> undirectedGraphNode.label == 6).findFirst();
        assertTrue(clonedNode6Opt.isPresent());
        CloneGraph.UndirectedGraphNode clonedNode6 = clonedNode6Opt.get();

        assertNotSame(node1, clonedNode1);
        assertNotSame(node2, clonedNode2);
        assertNotSame(node3, clonedNode3);
        assertNotSame(node4, clonedNode4);
        assertNotSame(node5, clonedNode5);
        assertNotSame(node6, clonedNode6);

        assertEquals(node1.label, clonedNode1.label);
        assertEquals(node2.label, clonedNode2.label);
        assertEquals(node3.label, clonedNode3.label);
        assertEquals(node4.label, clonedNode4.label);
        assertEquals(node5.label, clonedNode5.label);
        assertEquals(node6.label, clonedNode6.label);

        assertTrue(clonedNode1.neighbors.stream().map(undirectedGraphNode -> undirectedGraphNode.label).collect(Collectors.toList()).containsAll(Arrays.asList(2, 3)));
        assertTrue(clonedNode2.neighbors.stream().map(undirectedGraphNode -> undirectedGraphNode.label).collect(Collectors.toList()).containsAll(Arrays.asList(1, 4, 5)));
        assertTrue(clonedNode3.neighbors.stream().map(undirectedGraphNode -> undirectedGraphNode.label).collect(Collectors.toList()).containsAll(Arrays.asList(1, 6)));
        assertTrue(clonedNode4.neighbors.stream().map(undirectedGraphNode -> undirectedGraphNode.label).collect(Collectors.toList()).contains(2));
        assertTrue(clonedNode5.neighbors.stream().map(undirectedGraphNode -> undirectedGraphNode.label).collect(Collectors.toList()).containsAll(Arrays.asList(2, 6)));
        assertTrue(clonedNode6.neighbors.stream().map(undirectedGraphNode -> undirectedGraphNode.label).collect(Collectors.toList()).containsAll(Arrays.asList(3, 5)));


    }

    @Test
    public void shouldSupportNull() {
        assertNull(new CloneGraph().solve(null));
    }

    @Test
    public void shouldSupportDisjointedNode() {
        CloneGraph.UndirectedGraphNode node1 = new CloneGraph.UndirectedGraphNode(1);
        CloneGraph.UndirectedGraphNode clonedNode = new CloneGraph().solve(node1);
        assertNotSame(clonedNode, node1);
        assertEquals(clonedNode.label, node1.label);
        assertTrue(clonedNode.neighbors.isEmpty());
    }

}