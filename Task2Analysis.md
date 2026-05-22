# Task 2 — ConcurrentModificationException Analysis

## 1. What is the exact cause of ConcurrentModificationException in Java?

ConcurrentModificationException occurs when a collection is modified while it is being iterated using an Iterator or enhanced for-loop.

Example:

- Removing elements from a list while looping through it using for-each loop.

---

## 2. What code pattern at line 142 most likely triggered this error?

Most likely code pattern:

```java
for (Transaction t : transactions) {
    if (condition) {
        transactions.remove(t);
    }
}
```
