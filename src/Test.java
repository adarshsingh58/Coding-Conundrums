import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        List<String> rapReturnOrderDOSs = new ArrayList<>();
        rapReturnOrderDOSs.add("bhjnoin");
        rapReturnOrderDOSs.add("poijhbjk");
        rapReturnOrderDOSs.add("876567");
        rapReturnOrderDOSs.add("bvfgyhjk");
        String listOfRO = rapReturnOrderDOSs.stream().map(rapReturnOrderDO -> rapReturnOrderDO.toUpperCase()).collect(Collectors.joining(","));
        System.out.println(listOfRO);
    }


    static class BinaryTree {

        BinaryTree.Node root;

        public void add(int x) {
            if (null == root)
                root = new Node(x);
            else
                add(x, root);
        }

        public void add(int x, Node node) {
            {
                if (node.left == null) {
                    node.left = new Node(x);
                } else if (node.right == null) {
                    node.right = new Node(x);
                } else {
                    if (node.data % 2 == 0) {
                        add(x, node.left);
                    } else {
                        add(x, node.right);
                    }
                }
            }

        }

        public void removePath(int inp) {

            findPath(root, inp, Collections.emptyList(), 0);
        }

        private void findPath(Node node, int inp, List<Node> list, int sum) {
            if (sum > inp) {
                markNodesAsVisited(root, list);
                return;
            }
            if (node.left == null && node.right == null) {
                deletedNodesInPath(root, list);
                return;
            }
            list.add(node);
            sum = sum + node.data;
            findPath(node.left, inp, list, sum);
            findPath(node.right, inp, list, sum);
        }

        private void deletedNodesInPath(Node node, List<Node> list) {
            for (Node n : list) {
                if (!node.visited) {
                    //deleteNode
                }
            }
        }

        private void markNodesAsVisited(Node node, List<Node> list) {
            for (Node n : list) {
                node.visited = true;
            }
        }

        static class Node {
            int data;
            Node left;
            Node right;
            boolean visited;

            public Node(int data) {
                this.data = data;
            }

        }
    }
}

