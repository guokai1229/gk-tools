package top.guokaicn.tools.lang.tree;

import org.junit.Test;

import java.util.*;

public class TreeUtilsTest
{

    @Test
    public void testTestBuild()
    {
        Tree<String> tree = new Tree<>();

        tree.setParentId("0");
        tree.setId("1");

        Tree<String> tree2 = new Tree<>();

        tree2.setParentId("0");
        tree2.setId("2");

        Tree<String> tree3 = new Tree<>();

        tree3.setParentId("0");
        tree3.setId("3");

        Tree<String> tree4 = new Tree<>();

        tree4.setParentId("3");
        tree4.setId("4");

        List<TreeNode> list= new ArrayList<>(Arrays.asList(tree, tree2, tree3, tree4));

        List<TreeNode> result = TreeUtils.build(list,"0");
        System.out.println(result);
    }

    @Test
    public void testTestBuild1()
    {
        Map<String,String> item = new HashMap<>();

        item.put("uid","1");
        item.put("pid","0");

        Map<String,String> item2 = new HashMap<>();

        item2.put("uid","2");
        item2.put("pid","0");

        Map<String,String> item3 = new HashMap<>();

        item3.put("uid","32");
        item3.put("pid","0");

        Map<String,String> item4 = new HashMap<>();

        item4.put("uid","322");
        item4.put("pid","32");

        List<Map<String,String>> list=  new ArrayList<>(Arrays.asList(item, item2, item3, item4));

        List<TreeNode> result = TreeUtils.build(list, "0", (object, treeNode) -> {
            treeNode.setId(object.get("uid"));
            treeNode.setParentId(object.get("pid"));
        });

        System.out.println(result);
    }
}