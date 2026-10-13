import java.util.PriorityQueue;

public class HuffmanCoding {

    static class Node implements Comparable<Node> {
        char ch;
        int freq;
        Node left, right;

        Node(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }

        Node(int freq, Node left, Node right) {
            this.ch = '\0';
            this.freq = freq;
            this.left = left;
            this.right = right;
        }

        public int compareTo(Node other) {
            return this.freq - other.freq;
        }
    }

    static void printCodes(Node root, String code) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            System.out.println("  " + root.ch + " : " + code + "  (freq=" + root.freq + ")");
            return;
        }
        printCodes(root.left, code + "0");
        printCodes(root.right, code + "1");
    }

    static int totalBits(Node root, int depth) {
        if (root == null) return 0;
        if (root.left == null && root.right == null)
            return root.freq * depth;
        return totalBits(root.left, depth + 1) + totalBits(root.right, depth + 1);
    }

    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'c', 'd', 'e', 'f'};
        int[] freqs  = { 5,  9,  12, 13, 16, 45};

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < chars.length; i++)
            pq.add(new Node(chars[i], freqs[i]));

        while (pq.size() > 1) {
            Node left  = pq.poll();
            Node right = pq.poll();
            pq.add(new Node(left.freq + right.freq, left, right));
        }

        Node root = pq.poll();
        System.out.println("Huffman Codes:");
        printCodes(root, "");
        System.out.println("\nTotal encoded bits: " + totalBits(root, 0));
    }
}
