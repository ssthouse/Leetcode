package Test.lintcode;

import lintcode.Path_Sum_III;
import lintcode.Path_Sum_III.TreeNode;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * Path_Sum_III Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Dec 15, 2016</pre>
 */
public class Path_Sum_IIITest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: pathSum(TreeNode root, int sum)
     */
    @Test
    public void testPathSum() throws Exception {
        Path_Sum_III.TreeNode rootNode = new TreeNode(10);
        rootNode.left = new TreeNode(5);
        rootNode.right = new TreeNode(-3);
        rootNode.left.left = new TreeNode(3);
        rootNode.left.right = new TreeNode(2);
        rootNode.right.right = new TreeNode(11);
        rootNode.left.left.left = new TreeNode(3);
        rootNode.left.left.right = new TreeNode(-2);
        rootNode.left.right.right = new TreeNode(1);
        assert 3 == new Path_Sum_III().pathSum(rootNode, 8);
    }


} 
