package top.guokaicn.tools.lang.tree;

import org.junit.Test;


public class TreeTest
{
    @Test
    public void addChild()
    {
        Tree tree = new Tree();

        tree.setId("1");

        Tree tree2 = new Tree();

        tree2.setId("2");

        tree.addChild(tree2);

        System.out.println(tree);
    }

    @Test
    public void findChildById()
    {
        Tree tree = new Tree();

        tree.setId("1");

        Tree tree2 = new Tree();

        tree2.setId("2");

        Tree tree3 = new Tree();

        tree3.setId("3");

        tree.addChild(tree2);

        tree.addChild(tree3);

        TreeNode result = tree.findChildById("3");

        System.out.println(result);
    }
}