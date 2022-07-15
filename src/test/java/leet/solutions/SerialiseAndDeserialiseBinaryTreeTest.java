package leet.solutions;

import ds.util.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class SerialiseAndDeserialiseBinaryTreeTest {

    @Test
    public void shouldSerialiseAndDeserialiseCompleteBinaryTree()
    {
        SerialiseAndDeserialiseBinaryTree.Codec codec = new SerialiseAndDeserialiseBinaryTree.Codec();
        TreeNode rootNode
                = new TreeNode(1);
        rootNode.left = new TreeNode(2);
        rootNode.right = new TreeNode(3);
        rootNode.left.left = new TreeNode(4);
        rootNode.left.right = new TreeNode(5);
        rootNode.right.left = new TreeNode(6);
        rootNode.right.right = new TreeNode(7);
        String serialisedStringExpectation = "1(2(4()[3]())[2](5()[3]()))[1](3(6()[3]())[2](7()[3]()))";
        String serializedString = codec.serialize(rootNode);
        assertEquals(serialisedStringExpectation, serializedString);
        TreeNode deserializedRoot = codec.deserialize(serialisedStringExpectation);
        assertEquals(1, deserializedRoot.val);
        assertEquals(2, deserializedRoot.left.val);
        assertEquals(3, deserializedRoot.right.val);
        assertEquals(4, deserializedRoot.left.left.val);
        assertEquals(5, deserializedRoot.left.right.val);
        assertEquals(6, deserializedRoot.right.left.val);
        assertEquals(7, deserializedRoot.right.right.val);
    }

    @Test
    public void shouldSerialiseAndDeserializeSingleNodeTree()
    {
        TreeNode root =
                new TreeNode(1);
        SerialiseAndDeserialiseBinaryTree.Codec codec = new SerialiseAndDeserialiseBinaryTree.Codec();
        String serializedString = codec.serialize(root);
        TreeNode deserializedRoot = codec.deserialize(serializedString);
        assertEquals(1, deserializedRoot.val);
        assertNull(deserializedRoot.left);
        assertNull(deserializedRoot.right);
    }

    @Test
    public void shouldSerializeAndDeserializeLeftOnlyTree()
    {
        TreeNode treeNode =
                new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(3);
        SerialiseAndDeserialiseBinaryTree.Codec codec = new SerialiseAndDeserialiseBinaryTree.Codec();
        String serializedString = codec.serialize(treeNode);
        TreeNode deserializedRoot = codec.deserialize(serializedString);
        assertEquals(1, deserializedRoot.val);
        assertEquals(2, deserializedRoot.left.val);
        assertEquals(3, deserializedRoot.left.left.val);
        assertNull(deserializedRoot.right);
        assertNull(deserializedRoot.left.right);
        assertNull(deserializedRoot.left.left.right);
    }


}