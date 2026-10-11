# Data Structures and Algorithms - Complexity Report

## 1. Project Overview

This project implements fundamental data structures and algorithms in Java. The implementations include a singly linked list, stack, queue using two stacks, balanced brackets checker, array and string algorithms, and an LRU (Least Recently Used) Cache.

The purpose of this report is to analyze the time and space complexity of each method and explain how these structures are used in real-world backend systems.

### Complexity notation

- **O(1):** Constant time; the operation takes approximately the same amount of time regardless of input size.
- **O(n):** Linear time; the operation's work increases with the number of elements.
- **O(log n):** Logarithmic time; the number of operations grows logarithmically with input size.
- **O(c):** Space proportional to the cache capacity.
- **Amortized O(1):** Constant time on average over a sequence of operations, even if occasional operations take longer.

Here, `n` represents the number of elements, and `c` represents the LRU Cache capacity. HashMap operations are analyzed using their average-case complexity.

## 2. Part 1: Singly Linked List

A singly linked list stores elements in nodes, where each node points to the next node. It is useful when elements need to be inserted or removed without shifting the remaining elements.

| Method | Time Complexity | Auxiliary Space | Explanation |
|---|---|---|---|
| `addFirst(value)` | O(1) | O(1) | Creates a node and inserts it at the beginning. |
| `addLast(value)` | O(1) | O(1) | Uses the tail reference to append a node. |
| `removeFirst()` | O(1) | O(1) | Removes the first node and updates the head. |
| `get(index)` | O(n) | O(1) | Traverses the list to find the requested index. |
| `size()` | O(1) | O(1) | Returns the stored size counter. |
| `reverse()` | O(n) | O(1) | Reverses node links in place using three references. |
| `findMiddle()` | O(n) | O(1) | Uses slow and fast pointers to locate the middle node. |
| `display()` | O(n) | O(1) | Visits and prints every node. |

**Backend application:** Linked lists can support internal data structures such as navigation histories and queues. A linked list is also useful in an LRU Cache, where a doubly linked list maintains usage order.

## 3. Part 2A: Stack

A stack follows the Last In, First Out (LIFO) principle. The last element inserted is the first element removed.

| Method | Time Complexity | Auxiliary Space | Explanation |
|---|---|---|---|
| `push(value)` | O(1) | O(1) per insertion | Adds an element to the top of the stack. |
| `pop()` | O(1) | O(1) | Removes and returns the top element. |
| `peek()` | O(1) | O(1) | Returns the top element without removing it. |
| `isEmpty()` | O(1) | O(1) | Checks whether the stack contains elements. |
| `size()` | O(1) | O(1) | Returns the number of elements. |

**Backend application:** Stacks are used in undo/redo features, expression evaluation, and tracking nested operations. They can also help manage function calls and backtracking.

## 4. Part 2B: Queue Using Two Stacks

A queue follows the First In, First Out (FIFO) principle. The first element inserted is the first element removed.

| Method | Time Complexity | Auxiliary Space | Explanation |
|---|---|---|---|
| `enqueue(value)` | O(1) | O(1) per insertion | Pushes a new element onto the input stack. |
| `dequeue()` | Amortized O(1); worst-case O(n) | O(1) auxiliary per call | Transfers elements when needed, then removes the front element. |
| `peek()` | Amortized O(1); worst-case O(n) | O(1) auxiliary per call | Finds the front element, transferring elements if necessary. |
| `isEmpty()` | O(1) | O(1) | Checks whether both stacks are empty. |
| `size()` | O(1), if implemented using stack sizes | O(1) | Returns the combined number of queued elements. |
| Transfer helper | O(n) per transfer | O(1) auxiliary per call | Moves elements between stacks when the output stack is empty. |

**Backend application:** Queues are used to organize background jobs, incoming tasks, and asynchronous processing. For example, a backend service may queue email-sending jobs so they can be processed in order.

The queue's `dequeue()` and `peek()` operations are amortized O(1) because each element is transferred between the two stacks at most once in each direction over its lifetime.

## 5. Part 2C: Balanced Brackets

The balanced brackets algorithm uses a stack to verify whether opening and closing brackets match in the correct order.

| Method | Time Complexity | Auxiliary Space | Explanation |
|---|---|---|---|
| `isBalanced(expression)` | O(n) | O(n) | Processes each character and stores unmatched opening brackets. |

**Backend application:** Bracket validation is useful in code editors, expression parsers, and systems that validate structured expressions before processing them.

## 6. Part 3A: Rotate Array Right

The array rotation algorithm moves elements to the right by `k` positions using the reversal technique.

| Method | Time Complexity | Auxiliary Space | Explanation |
|---|---|---|---|
| `rotateRight(array, k)` | O(n) | O(1) | Reverses sections of the array in place. |
| `reverse(array, start, end)` | O(n) for a section of length n | O(1) | Swaps elements from opposite ends of a section. |
| `printArray(array)` | O(n) | O(1) | Prints every array element. |

**Backend application:** Array rotation techniques can help with circular buffers, rotating schedules, and rearranging in-memory sequences.

## 7. Part 3B: Anagram Checker

The anagram algorithm checks whether two strings contain the same characters with the same frequencies. The implementation uses a fixed-size character frequency array.

| Method | Time Complexity | Auxiliary Space | Explanation |
|---|---|---|---|
| `isAnagram(a, b)` | O(n) | O(1) | Counts character frequencies using a fixed-size table. |

**Backend application:** Character-frequency comparisons can be used in text-processing services, word games, and data-validation tasks.

The O(1) auxiliary space classification assumes a fixed character table, such as an array covering all Java `char` values. The table uses a fixed amount of memory independent of the input length.

## 8. Part 3C: Two Sum on a Sorted Array

The two-sum algorithm finds two elements in an ascending sorted array whose sum equals a target value. It uses two pointers, one at each end of the array.

| Method | Time Complexity | Auxiliary Space | Explanation |
|---|---|---|---|
| `twoSumSorted(array, target)` | O(n) | O(1) | Moves two pointers based on the calculated sum. |

**Backend application:** Two-pointer techniques can support efficient searches in sorted datasets, financial data analysis, and finding pairs of values that satisfy a target condition.

The algorithm assumes the input array is sorted in ascending order.

## 9. Part 4: Hash Table / LRU Cache

An LRU Cache stores key-value pairs up to a specified capacity. It uses a HashMap for average O(1) key lookup and a custom doubly linked list to track which entry was used least recently.

| Method | Time Complexity | Auxiliary Space | Explanation |
|---|---|---|---|
| `LRUCache(capacity)` | O(1) | O(1) initially | Initializes the HashMap and sentinel nodes. |
| `get(key)` | Average O(1) | O(1) | Looks up a key and moves its node to the most-recently-used position. |
| `put(key, value)` | Average O(1) | O(1) per operation | Inserts or updates an entry and evicts the least recently used entry when necessary. |
| `removeNode(node)` | O(1) | O(1) | Removes a node by updating its neighboring pointers. |
| `addToEnd(node)` | O(1) | O(1) | Inserts a node before the tail sentinel. |
| `moveToMostRecent(node)` | O(1) | O(1) | Removes a node from its position and inserts it at the end. |
| `display()` | O(c) | O(1) | Traverses and prints the cache entries in usage order. |

**Backend application:** LRU Caches are used to keep frequently accessed data in memory, reducing repeated database queries and improving response times. For example, a web application may cache commonly requested user profiles or product information.

The cache uses O(c) total storage for up to `c` entries, including the HashMap and doubly linked list. The constant-space entries in the table refer to additional working space per operation, not the total memory occupied by the cache.

## 10. Overall Complexity Summary

| Data Structure or Algorithm | Main Operation | Time Complexity | Total Space Complexity |
|---|---|---|---|
| Singly linked list | Insert at beginning | O(1) | O(n) |
| Stack | Push or pop | O(1) | O(n) |
| Queue using two stacks | Enqueue or amortized dequeue | Amortized O(1) | O(n) |
| Balanced brackets | Validate expression | O(n) | O(n) |
| Array rotation | Rotate right | O(n) | O(1) auxiliary |
| Anagram checker | Compare character frequencies | O(n) | O(1) auxiliary |
| Two sum sorted | Find a pair | O(n) | O(1) auxiliary |
| LRU Cache | Get or put | Average O(1) | O(c) |

## 11. Conclusion

This project demonstrates how choosing an appropriate data structure improves algorithm efficiency. Linked lists support efficient insertion and removal at known positions, stacks and queues organize elements according to different processing orders, and array algorithms solve problems with limited extra memory.

The LRU Cache combines a HashMap and a doubly linked list to achieve average O(1) lookup, insertion, update, and eviction. This illustrates how multiple data structures can work together to solve a practical backend performance problem.

Understanding time and space complexity helps developers select efficient implementations for real-world applications, especially when processing large amounts of data or handling many requests.
