package top.guokaicn.tools.lang.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeListTest
{

    @Test
    public void getData()
    {
        Tree tree = new Tree();

        tree.setParentId("0");
        tree.setId("1");

        Tree tree2 = new Tree();

        tree2.setParentId("0");
        tree2.setId("2");

        Tree tree3 = new Tree();

        tree3.setParentId("0");
        tree3.setId("3");

        Tree tree4 = new Tree();

        tree4.setParentId("3");
        tree4.setId("4");

        List<TreeNode> list= new ArrayList<TreeNode>(Arrays.asList(tree, tree2, tree3, tree4));

        TreeList treeList = new TreeList(list);

        System.out.println(treeList.getData());
    }
}