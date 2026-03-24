Certainly! Here's a complete **note-style explanation** covering **directional movement techniques** for both **4-directional** and **8-directional** traversal in grid-based problems (like n4_Traversal Techniques.BFS.BFS, n4_Traversal Techniques.DFS.DFS, pathfinding, flood fill, etc.). This is commonly used in problems like **Number of Islands**, **Maze traversal**, **Shortest Path in Grid**, and more.

---

## 🧭 Grid Traversal Techniques (4-directional & 8-directional)

### 📌 Why We Need Directions in Grid Problems

When working with 2D matrices (grids), many problems require exploring **neighboring cells** of a given cell `(i, j)`.
To avoid repetitive code and handle boundaries easily, we use **direction arrays** to standardize how we move in those directions.

---

## 🔢 Cell Coordinates

Each cell in a matrix is denoted by `(row, col)`.

---

## ✅ 4-Directional Movement

The 4 cardinal directions are:

| Direction | Row Change | Column Change |
| --------- | ---------- | ------------- |
| Up        | -1         | 0             |
| Right     | 0          | +1            |
| Down      | +1         | 0             |
| Left      | 0          | -1            |

### 🔧 Implementation Using Arrays

```java
int[] dRow = {-1, 0, 1, 0};  // row offsets: up, right, down, left
int[] dCol = {0, 1, 0, -1};  // col offsets

for (int k = 0; k < 4; k++) {
    int newRow = row + dRow[k];
    int newCol = col + dCol[k];

    // check bounds and conditions
}
```

This is compact and avoids writing 4 separate if-statements.

---

## ✅ 8-Directional Movement

Adds the 4 diagonal directions to the 4 cardinal ones:

| Direction    | Row Change | Column Change |
| ------------ | ---------- | ------------- |
| Up           | -1         | 0             |
| Down         | +1         | 0             |
| Left         | 0          | -1            |
| Right        | 0          | +1            |
| Top-left     | -1         | -1            |
| Top-right    | -1         | +1            |
| Bottom-left  | +1         | -1            |
| Bottom-right | +1         | +1            |

### 🔧 Implementation Using Arrays

```java
int[] dRow = {-1, -1, -1, 0, 0, 1, 1, 1};
int[] dCol = {-1, 0, 1, -1, 1, -1, 0, 1};

for (int k = 0; k < 8; k++) {
    int newRow = row + dRow[k];
    int newCol = col + dCol[k];

    // check bounds and conditions
}
```

This makes 8-directional n4_Traversal Techniques.BFS.BFS/n4_Traversal Techniques.DFS.DFS traversal easy and scalable.

---

## 🔁 Alternative Using Nested Loops (less preferred but educational)

### ➤ 4-Direction Using Loops (with manual condition)

```java
int[] dRow = {-1, 0, 1, 0};
int[] dCol = {0, 1, 0, -1};

for (int i = 0; i < 4; i++) {
    int newRow = row + dRow[i];
    int newCol = col + dCol[i];
}
```

---

### ➤ 8-Direction Using Nested Loops

```java
for (int i = -1; i <= 1; i++) {
    for (int j = -1; j <= 1; j++) {
        if (i == 0 && j == 0) continue; // skip the current cell itself
        int newRow = row + i;
        int newCol = col + j;
    }
}
```

This nested loop covers all 8 directions, but includes a check to skip the center.

---

## 🧠 Summary Table

| Type        | Directions            | Implementation Style     | Use Cases                          |
| ----------- | --------------------- | ------------------------ | ---------------------------------- |
| 4-dir       | Up, Down, Left, Right | 2 arrays or 1 loop       | Standard n4_Traversal Techniques.BFS.BFS/n4_Traversal Techniques.DFS.DFS in grid problems  |
| 8-dir       | Includes Diagonals    | 2 arrays or nested loops | Advanced n4_Traversal Techniques.BFS.BFS/n4_Traversal Techniques.DFS.DFS, image processing |
| Nested loop | `(-1,-1)` to `(1,1)`  | Manual skip for (0,0)    | Educational, easy to visualize     |

---

## 🚨 Important Notes

* Always **check boundaries**: `0 <= newRow < rows` and `0 <= newCol < cols`
* Diagonal movement can connect islands diagonally — only use when the problem **explicitly allows it**.
* Direction arrays help avoid repeating code and reduce errors.

---

Would you like example problems to practice each type of movement?
