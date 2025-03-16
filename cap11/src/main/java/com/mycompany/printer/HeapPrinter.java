package com.mycompany.printer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.nio.charset.StandardCharsets;

/**
 * A utility class for printing array-based binary heaps in a visual tree format
 * with explicit Unicode character handling.
 */
public class HeapPrinter {
    private final int[] heap;
    private final boolean showIndices;
    
    // Unicode box drawing characters as constants
    private static final String PIPE = "│";
    private static final String TEE = "├";
    private static final String CORNER = "└";
    private static final String HORIZONTAL = "──";

    /**
     * Creates a new HeapPrinter.
     * 
     * @param heap The array representation of the binary heap
     * @param showIndices Whether to show array indices alongside values
     */
    public HeapPrinter(int[] heap, boolean showIndices) {
        this.heap = heap;
        this.showIndices = showIndices;
        
        // Ensure proper Unicode output by setting console encoding if needed
        System.setProperty("file.encoding", "UTF-8");
        try {
            // Try to configure output stream to use UTF-8
            System.setOut(new java.io.PrintStream(System.out, true, StandardCharsets.UTF_8.name()));
        } catch (Exception e) {
            System.err.println("Warning: Cannot set UTF-8 output encoding: " + e.getMessage());
        }
    }

    /**
     * Creates a new HeapPrinter with default settings.
     * 
     * @param heap The array representation of the binary heap
     */
    public HeapPrinter(int[] heap) {
        this(heap, false);
    }

    /**
     * Prints the heap to the console.
     */
    public void print() {
        if (heap.length == 0) {
            System.out.println("Empty heap");
            return;
        }
        
        // Convert heap to TreeNode structure
        TreeNode root = heapToTreeNode(0);
        System.out.println(root);
    }

    /**
     * Recursively converts a heap node and its children to a TreeNode.
     * 
     * @param index The index of the heap node
     * @return A TreeNode representation of the heap subtree
     */
    private TreeNode heapToTreeNode(int index) {
        if (index >= heap.length) {
            return null;
        }
        
        // Format node value
        String nodeValue = showIndices ? index + ":" + heap[index] : String.valueOf(heap[index]);
        
        // Create children list
        List<TreeNode> children = new ArrayList<>();
        
        // Left child
        int leftChildIdx = 2 * index + 1;
        if (leftChildIdx < heap.length) {
            TreeNode leftChild = heapToTreeNode(leftChildIdx);
            if (leftChild != null) {
                children.add(leftChild);
            }
        }
        
        // Right child
        int rightChildIdx = 2 * index + 2;
        if (rightChildIdx < heap.length) {
            TreeNode rightChild = heapToTreeNode(rightChildIdx);
            if (rightChild != null) {
                children.add(rightChild);
            }
        }
        
        return new TreeNode(nodeValue, children);
    }
    
    /**
     * TreeNode class for visualizing the heap.
     */
    private class TreeNode {
        final String name;
        final List<TreeNode> children;

        public TreeNode(String name, List<TreeNode> children) {
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
    
    /**
     * Provides an ASCII fallback if special characters aren't displaying correctly.
     */
    public void printAscii() {
        if (heap.length == 0) {
            System.out.println("Empty heap");
            return;
        }
        
        ASCIITreeNode root = heapToASCIITreeNode(0);
        System.out.println(root);
    }
    
    /**
     * Converts heap to ASCII TreeNode.
     */
    private ASCIITreeNode heapToASCIITreeNode(int index) {
        if (index >= heap.length) {
            return null;
        }
        
        String nodeValue = showIndices ? index + ":" + heap[index] : String.valueOf(heap[index]);
        List<ASCIITreeNode> children = new ArrayList<>();
        
        int leftChildIdx = 2 * index + 1;
        if (leftChildIdx < heap.length) {
            ASCIITreeNode leftChild = heapToASCIITreeNode(leftChildIdx);
            if (leftChild != null) {
                children.add(leftChild);
            }
        }
        
        int rightChildIdx = 2 * index + 2;
        if (rightChildIdx < heap.length) {
            ASCIITreeNode rightChild = heapToASCIITreeNode(rightChildIdx);
            if (rightChild != null) {
                children.add(rightChild);
            }
        }
        
        return new ASCIITreeNode(nodeValue, children);
    }
    
    /**
     * ASCII fallback TreeNode.
     */
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
    
    /**
     * Gets the content encoded in UTF-8 as a byte array.
     */
    public byte[] getUTF8Output() {
        if (heap.length == 0) {
            return "Empty heap".getBytes(StandardCharsets.UTF_8);
        }
        
        TreeNode root = heapToTreeNode(0);
        return root.toString().getBytes(StandardCharsets.UTF_8);
    }
    
    /**
     * Example usage of HeapPrinter.
     */
    public static void main(String[] args) {
        // Example max-heap
        int[] maxHeap = {10, 7, 9, 5, 6, 8, 4};
        HeapPrinter printer = new HeapPrinter(maxHeap, true);
        
        System.out.println("Unicode tree view (default):");
        printer.print();
        
        System.out.println("\nASCII tree view (fallback):");
        printer.printAscii();
        
        System.out.println("\nUnicode test:");
        System.out.println("Box drawing characters: │ ├ └ ──");
    }
}