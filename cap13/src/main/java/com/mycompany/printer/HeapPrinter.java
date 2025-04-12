package com.mycompany.printer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.nio.charset.StandardCharsets;

/**
 * A utility class for printing array-based binary heaps in a visual tree format
 * with explicit Unicode character handling.
 */
public class HeapPrinter<T> {
    private final T[] heap;
    private final boolean showIndices;

    private static final String PIPE = "│";
    private static final String TEE = "├";
    private static final String CORNER = "└";
    private static final String HORIZONTAL = "──";

    public HeapPrinter(T[] heap, boolean showIndices) {
        this.heap = heap;
        this.showIndices = showIndices;

        System.setProperty("file.encoding", "UTF-8");
        try {
            System.setOut(new java.io.PrintStream(System.out, true, StandardCharsets.UTF_8.name()));
        } catch (Exception e) {
            System.err.println("Warning: Cannot set UTF-8 output encoding: " + e.getMessage());
        }
    }

    public HeapPrinter(T[] heap) {
        this(heap, false);
    }

    public void print() {
        if (heap.length == 0) {
            System.out.println("Empty heap");
            return;
        }

        TreeNode root = heapToTreeNode(0);
        if (root == null) {
            System.out.println("Heap contains only nulls");
        } else {
            System.out.println(root);
        }
    }

    private TreeNode heapToTreeNode(int index) {
        if (index >= heap.length || heap[index] == null) {
            return null;
        }

        String nodeValue = showIndices ? index + ":" + heap[index] : String.valueOf(heap[index]);
        List<TreeNode> children = new ArrayList<>();

        int leftChildIdx = 2 * index + 1;
        TreeNode leftChild = heapToTreeNode(leftChildIdx);
        if (leftChild != null) {
            children.add(leftChild);
        } else if (leftChildIdx < heap.length) {
            children.add(new TreeNode("null", new ArrayList<>()));
        }

        int rightChildIdx = 2 * index + 2;
        TreeNode rightChild = heapToTreeNode(rightChildIdx);
        if (rightChild != null) {
            children.add(rightChild);
        } else if (rightChildIdx < heap.length) {
            children.add(new TreeNode("null", new ArrayList<>()));
        }

        return new TreeNode(nodeValue, children);
    }

    private class TreeNode {
        final String name;
        final List<TreeNode> children;

        public TreeNode(String name, List<TreeNode> children) {
            this.name = name;
            this.children = children;
        }

        public String toString() {
            StringBuilder buffer = new StringBuilder(100);
            print(buffer, "", "");
            return buffer.toString();
        }

        private void print(StringBuilder buffer, String prefix, String childrenPrefix) {
            buffer.append(prefix);
            buffer.append(name);
            buffer.append('\n');
            for (Iterator<TreeNode> it = children.iterator(); it.hasNext();) {
                TreeNode next = it.next();
                if (it.hasNext()) {
                    next.print(buffer, childrenPrefix + TEE + HORIZONTAL, childrenPrefix + PIPE + "   ");
                } else {
                    next.print(buffer, childrenPrefix + CORNER + HORIZONTAL, childrenPrefix + "    ");
                }
            }
        }
    }

    public void printAscii() {
        if (heap.length == 0) {
            System.out.println("Empty heap");
            return;
        }

        ASCIITreeNode root = heapToASCIITreeNode(0);
        if (root == null) {
            System.out.println("Heap contains only nulls");
        } else {
            System.out.println(root);
        }
    }

    private ASCIITreeNode heapToASCIITreeNode(int index) {
        if (index >= heap.length || heap[index] == null) {
            return null;
        }

        String nodeValue = showIndices ? index + ":" + heap[index] : String.valueOf(heap[index]);
        List<ASCIITreeNode> children = new ArrayList<>();

        int leftChildIdx = 2 * index + 1;
        ASCIITreeNode leftChild = heapToASCIITreeNode(leftChildIdx);
        if (leftChild != null) {
            children.add(leftChild);
        } else if (leftChildIdx < heap.length) {
            children.add(new ASCIITreeNode("null", new ArrayList<>()));
        }

        int rightChildIdx = 2 * index + 2;
        ASCIITreeNode rightChild = heapToASCIITreeNode(rightChildIdx);
        if (rightChild != null) {
            children.add(rightChild);
        } else if (rightChildIdx < heap.length) {
            children.add(new ASCIITreeNode("null", new ArrayList<>()));
        }

        return new ASCIITreeNode(nodeValue, children);
    }

    private class ASCIITreeNode {
        final String name;
        final List<ASCIITreeNode> children;

        public ASCIITreeNode(String name, List<ASCIITreeNode> children) {
            this.name = name;
            this.children = children;
        }

        public String toString() {
            StringBuilder buffer = new StringBuilder(50);
            print(buffer, "", "");
            return buffer.toString();
        }

        private void print(StringBuilder buffer, String prefix, String childrenPrefix) {
            buffer.append(prefix);
            buffer.append(name);
            buffer.append('\n');
            for (Iterator<ASCIITreeNode> it = children.iterator(); it.hasNext();) {
                ASCIITreeNode next = it.next();
                if (it.hasNext()) {
                    next.print(buffer, childrenPrefix + "+-- ", childrenPrefix + "|   ");
                } else {
                    next.print(buffer, childrenPrefix + "+-- ", childrenPrefix + "    ");
                }
            }
        }
    }

    public byte[] getUTF8Output() {
        if (heap.length == 0) {
            return "Empty heap".getBytes(StandardCharsets.UTF_8);
        }

        TreeNode root = heapToTreeNode(0);
        if (root == null) {
            return "Heap contains only nulls".getBytes(StandardCharsets.UTF_8);
        }

        return root.toString().getBytes(StandardCharsets.UTF_8);
    }

    public static void main(String[] args) {
        Integer[] heap = {32, 25, 44, 1, null, null, 50, null, 20, null, null, 5, null, null, 19};
        HeapPrinter<Integer> printer = new HeapPrinter<>(heap, true);

        System.out.println("Unicode tree view:");
        printer.print();

        System.out.println("\nASCII tree view:");
        printer.printAscii();
    }
}
