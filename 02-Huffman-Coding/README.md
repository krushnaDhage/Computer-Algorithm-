## Aim
Demonstrate Huffman Coding by constructing an optimal prefix-free binary tree using a priority queue (min-heap) and calculating the total bit length of the encoded data.

### How to Execute
- **Prerequisites:** Java Development Kit (JDK 8 or higher).
- **Navigate to directory:**
  ```bash
  cd Computer-Algorithms-Practical/02-Huffman-Coding
  ```
- **Compilation Command:**
  ```bash
  javac HuffmanCoding.java
  ```
- **Execution Command:**
  ```bash
  java HuffmanCoding
  ```
- **Verification:** Ensure that variable-length binary codes are printed for all characters and the total encoded bit count equals `224`.
- **Notes:** The class has no package declaration and runs directly without additional classpath configuration.

## Input
Predefined character-frequency pairs. No runtime user input is required.

```java
chars = {'a', 'b', 'c', 'd', 'e', 'f'};
freqs = { 5,   9,  12,  13,  16,  45 };
```

## Algorithm
1. Create a leaf node for each character and its corresponding frequency.
2. Insert all leaf nodes into a min-heap (`PriorityQueue<Node>`).
3. While more than one node remains in the heap:
   a. Extract the two nodes with the lowest frequencies (`left` and `right`).
   b. Create a new internal parent node with frequency equal to the sum of both nodes' frequencies.
   c. Set its left and right children and insert the new node back into the min-heap.
4. The sole remaining node in the heap becomes the root of the Huffman tree.
5. Traverse the tree from root to leaves, appending `'0'` for left branches and `'1'` for right branches to generate binary codes.
6. Multiply each character's frequency by its code length and sum them to obtain the total encoded bit count.

## Output
```text
Huffman Codes:
  f : 0  (freq=45)
  c : 100  (freq=12)
  d : 101  (freq=13)
  a : 1100  (freq=5)
  b : 1101  (freq=9)
  e : 111  (freq=16)

Total encoded bits: 224
```

## Complexity Explanation
- **Time Complexity:** O(N log N), where N is the number of distinct characters (6). Building the initial heap takes O(N) or O(N log N), and each of the N − 1 merge steps performs two `poll` operations and one `add` operation, each taking O(log N) time.
- **Auxiliary Space:** O(N) auxiliary space to store the priority queue and 2N − 1 nodes of the binary Huffman tree.
