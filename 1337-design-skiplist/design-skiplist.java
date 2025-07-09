import java.util.*;

class Skiplist {

    static final int MAX_LEVEL = 16;
    static final double P = 0.5;
    private final Node head = new Node(-1, MAX_LEVEL);
    private int level = 0;
    private final Random rand = new Random();

    static class Node {
        int val;
        Node[] forward;
        Node(int val, int level) {
            this.val = val;
            this.forward = new Node[level];
        }
    }

    public boolean search(int target) {
        Node curr = head;
        for (int i = level - 1; i >= 0; i--) {
            while (curr.forward[i] != null && curr.forward[i].val < target) {
                curr = curr.forward[i];
            }
        }
        curr = curr.forward[0];
        return curr != null && curr.val == target;
    }

    public void add(int num) {
        Node curr = head;
        Node[] update = new Node[MAX_LEVEL];
        for (int i = level - 1; i >= 0; i--) {
            while (curr.forward[i] != null && curr.forward[i].val < num) {
                curr = curr.forward[i];
            }
            update[i] = curr;
        }

        int newLevel = randomLevel();
        if (newLevel > level) {
            for (int i = level; i < newLevel; i++) {
                update[i] = head;
            }
            level = newLevel;
        }

        Node newNode = new Node(num, newLevel);
        for (int i = 0; i < newLevel; i++) {
            newNode.forward[i] = update[i].forward[i];
            update[i].forward[i] = newNode;
        }
    }

    public boolean erase(int num) {
        Node curr = head;
        Node[] update = new Node[MAX_LEVEL];
        for (int i = level - 1; i >= 0; i--) {
            while (curr.forward[i] != null && curr.forward[i].val < num) {
                curr = curr.forward[i];
            }
            update[i] = curr;
        }

        curr = curr.forward[0];
        if (curr == null || curr.val != num) return false;

        for (int i = 0; i < level; i++) {
            if (update[i].forward[i] != curr) break;
            update[i].forward[i] = curr.forward[i];
        }

        while (level > 0 && head.forward[level - 1] == null) {
            level--;
        }

        return true;
    }

    private int randomLevel() {
        int lvl = 1;
        while (Math.random() < P && lvl < MAX_LEVEL) lvl++;
        return lvl;
    }
}

/**
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist obj = new Skiplist();
 * boolean param_1 = obj.search(target);
 * obj.add(num);
 * boolean param_3 = obj.erase(num);
 */