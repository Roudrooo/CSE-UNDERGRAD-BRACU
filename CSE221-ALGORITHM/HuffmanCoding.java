import java.util.*;

// Node of Huffman Tree
class HuffmanNode {
    char ch;
    int freq;
    HuffmanNode left, right;

    HuffmanNode(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
        this.left = null;
        this.right = null;
    }
}

// Comparator for PriorityQueue
class HuffmanComparator implements Comparator<HuffmanNode> {
    public int compare(HuffmanNode x, HuffmanNode y) {
        return x.freq - y.freq;
    }
}

public class HuffmanCoding {
    // Generate Huffman Codes
    static void generateCodes(HuffmanNode root, String code, Map<Character, String> huffmanCode) {
        if (root == null) return;

        // Leaf node (contains a character)
        if (root.left == null && root.right == null) {
            huffmanCode.put(root.ch, code.length() > 0 ? code : "0"); // edge case single char
        }

        generateCodes(root.left, code + "0", huffmanCode);
        generateCodes(root.right, code + "1", huffmanCode);
    }

    // Build Huffman Tree
    static HuffmanNode buildHuffmanTree(Map<Character, Integer> freqMap) {
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>(new HuffmanComparator());

        // Create leaf nodes
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            pq.add(new HuffmanNode(entry.getKey(), entry.getValue()));
        }

        // Merge nodes until one tree remains
        while (pq.size() > 1) {
            HuffmanNode left = pq.poll();
            HuffmanNode right = pq.poll();

            HuffmanNode newNode = new HuffmanNode('-', left.freq + right.freq);
            newNode.left = left;
            newNode.right = right;
            pq.add(newNode);
        }

        return pq.peek();
    }

    // Encode a string using Huffman coding
    static String encode(String text, Map<Character, String> huffmanCode) {
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            sb.append(huffmanCode.get(c));
        }
        return sb.toString();
    }

    // Decode a Huffman encoded string
    static String decode(String encoded, HuffmanNode root) {
        StringBuilder sb = new StringBuilder();
        HuffmanNode current = root;

        for (char bit : encoded.toCharArray()) {
            current = (bit == '0') ? current.left : current.right;

            // Reached leaf
            if (current.left == null && current.right == null) {
                sb.append(current.ch);
                current = root;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string to encode: ");
        String text = sc.nextLine();

        // Step 1: Count frequency
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : text.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Build Huffman Tree
        HuffmanNode root = buildHuffmanTree(freqMap);

        // Step 3: Generate codes
        Map<Character, String> huffmanCode = new HashMap<>();
        generateCodes(root, "", huffmanCode);

        System.out.println("\nHuffman Codes: " + huffmanCode);

        // Step 4: Encode
        String encoded = encode(text, huffmanCode);
        System.out.println("Encoded String: " + encoded);

        // Step 5: Decode
        String decoded = decode(encoded, root);
        System.out.println("Decoded String: " + decoded);

        sc.close();
    }
}