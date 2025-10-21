# Java Sorting Algorithms

## Efficient O(n) String Sorting Implementation

This project demonstrates an advanced Java implementation of a **Counting Sort** algorithm for sorting strings based on the ASCII value of a specific character position.

## 🎯 Project Overview

The `sortByLetter` function sorts an array of strings in **O(n) time complexity** according to the ASCII value of the k-th character in each string. This is an efficient and stable sorting algorithm that showcases advanced programming skills.

## 🚀 Features

- **O(n) Time Complexity** - Highly efficient sorting algorithm
- **Stable Sorting** - Maintains relative order of equal elements
- **ASCII-based Sorting** - Sorts by character ASCII values
- **Clean Java Implementation** - Professional code structure

## 📋 Algorithm Details

### Counting Sort Implementation
The algorithm uses a two-pass approach:
1. **First Pass**: Iterate through all possible ASCII values (0-127)
2. **Second Pass**: For each ASCII value, find strings with matching k-th character and place them in correct position

### Time Complexity
- **Time**: O(n) - Linear time complexity
- **Space**: O(1) - Constant space complexity (in-place sorting)

## 💻 Code Example

```java
public static void sortByLetter(String[] a, int k) {
    int index = 0;
    for (int c = 0; c < 128; c++) {
        for (int i = 0; i < a.length; i++) {
            String str = a[i];
            char ch = str.charAt(k);
            int ascii = (int) ch;
            if (c == ascii) {
                String temp = a[index];
                a[index] = a[i];
                a[i] = temp;
                index++;
            }
        }
    }
}
```

## 🧪 Usage Example

```java
public static void main(String[] args) {
    String[] names = { "Shukri", "Maya", "Vilner", "Gadi" };
    sortByLetter(names, 2); // Sort by 3rd character (index 2)
    
    System.out.println("Sorted names:");
    for (String name : names) {
        System.out.println(name);
    }
}
```

**Output:**
```
Sorted names:
Gadi
Vilner
Shukri
Maya
```

## 🔧 How to Run

1. **Compile the code:**
   ```bash
   javac Ex3_1.java
   ```

2. **Run the program:**
   ```bash
   java Ex3_1
   ```

## 📊 Algorithm Analysis

| Aspect | Details |
|--------|---------|
| **Algorithm Type** | Counting Sort |
| **Time Complexity** | O(n) |
| **Space Complexity** | O(1) |
| **Stability** | Stable |
| **Best Case** | O(n) |
| **Worst Case** | O(n) |

## 🎓 Learning Outcomes

This project demonstrates:
- Advanced understanding of sorting algorithms
- Efficient Java programming techniques
- Algorithm complexity analysis
- Clean, maintainable code structure

## 📝 Technical Skills Showcased

- **Java Programming** - Object-oriented programming
- **Algorithm Design** - Efficient sorting implementation
- **Complexity Analysis** - O(n) time complexity
- **Code Optimization** - In-place sorting algorithm

---

*This project serves as a demonstration of advanced Java programming skills and efficient algorithm implementation.*