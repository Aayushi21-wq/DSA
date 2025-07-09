import java.util.*;

class TextEditor {
    Deque<Character> left, right;

    public TextEditor() {
        left = new ArrayDeque<>();
        right = new ArrayDeque<>();
    }

    public void addText(String text) {
        for (char c : text.toCharArray()) {
            left.addLast(c); // use addLast to simulate a queue
        }
    }

    public int deleteText(int k) {
        int deleted = 0;
        while (k-- > 0 && !left.isEmpty()) {
            left.pollLast(); // remove from the end (cursor position)
            deleted++;
        }
        return deleted;
    }

    public String cursorLeft(int k) {
        while (k-- > 0 && !left.isEmpty()) {
            right.addFirst(left.pollLast());
        }
        return getLast10Chars();
    }

    public String cursorRight(int k) {
        while (k-- > 0 && !right.isEmpty()) {
            left.addLast(right.pollFirst());
        }
        return getLast10Chars();
    }

    private String getLast10Chars() {
        StringBuilder sb = new StringBuilder();
        Iterator<Character> iter = left.descendingIterator();
        int count = 0;
        while (iter.hasNext() && count++ < 10) {
            sb.append(iter.next());
        }
        return sb.reverse().toString();
    }
}


/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */