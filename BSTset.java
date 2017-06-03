/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queue;

/**
 *
 * @author Admin
 * @param <T>
 */
public class BSTset<T extends Comparable> implements Set<T> {

    private TreeNode<T> root;
    private int size;

    public BSTset() {
        root = null;
        size = 0;
    }

    @Override
    public void add(T value) {
        if (size == 0) {
            root = new TreeNode(value);
            size++;

        } else if (!contains(value)) {

            addHelper(root, value);
        }
    }

    private void addHelper(TreeNode<T> node, T value) {
        if (node.getValue().compareTo(value) > 0) {
            if (node.getLeft() == null) {
                node.setLeft(new TreeNode(value));
                size++;
            } else {
                addHelper(node.getLeft(), value);
            }
        } else if (node.getRight() == null) {
            node.setRight(new TreeNode(value));
            size++;
        } else {
            addHelper(node.getRight(), value);
        }
    }

    @Override
    public boolean contains(T value) {
        return containsHelper(root, value);
    }

    private boolean containsHelper(TreeNode<T> node, T value) {

        if (node == null) {
            return false;
        } else {
            int c = node.getValue().compareTo(value);
            if (c < 0) {
                return containsHelper(node.getRight(), value);
            } else if (c > 0) {
                return containsHelper(node.getLeft(), value);

            } else {
                return true;
            }

        }
    }

    @Override
    public boolean remove(T value) {
        TreeNode<T> parent = root;
        TreeNode<T> current = root;
        boolean isLeftChild = false;
        while (current.getValue() != value) {
            parent = current;
            if (current.getValue().compareTo(value) > 0) {
                isLeftChild = true;
                current = current.getLeft();
            } else {
                isLeftChild = false;
                current = current.getRight();
            }
            if (current == null) {
                return false;
            }
        }

        if (current.getLeft() == null && current.getRight() == null) {
            if (current == root) {
                root = null;
            }
            if (isLeftChild == true) {
                parent.setLeft(null);
            } else {
                parent.setRight(null);
            }
        } else if (current.getRight() == null) {
            if (current == root) {
                root = current.getLeft();
            } else if (isLeftChild) {
                parent.setLeft(current.getLeft());
            } else {
                parent.setRight(current.getLeft());
            }
        } else if (current.getLeft() == null) {
            if (current == root) {
                root = current.getRight();
            } else if (isLeftChild) {
                parent.setLeft(current.getRight());
            } else {
                parent.setRight(current.getRight());
            }
        } else if (current.getLeft() != null && current.getRight() != null) {

            TreeNode<T> successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.setLeft(successor);
            } else {
                parent.setRight(successor);
            }
            successor.setLeft(current.getLeft());
        }
        return true;
    }

    public TreeNode<T> getSuccessor(TreeNode<T> deleleNode) {
        TreeNode<T> successsor = null;
        TreeNode<T> successsorParent = null;
        TreeNode<T> current = deleleNode.getRight();
        while (current != null) {
            successsorParent = successsor;
            successsor = current;
            current = current.getLeft();
        }
        if (successsor != deleleNode.getRight()) {
            successsorParent.setLeft(successsor.getRight());
            successsor.setRight(deleleNode.getRight());
        }
        return successsor;
    }

    @Override
    public T removeAny() throws Exception {
        T i = root.getValue();
        remove(root.getValue());
        return i;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        size = 0;
    }

    public String toString() {
        return toStringHelper(root);
    }

    public String toStringHelper(TreeNode<T> node) {
        if (node == null) {
            return "";
        }
        return toStringHelper(node.getLeft())
                + " " + node.getValue()
                + toStringHelper(node.getRight());
    }
}
