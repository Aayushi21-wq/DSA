class Solution {
    /* XOR gives the sum, AND gives the carry — shift it, loop it
    */
    public int getSum(int a, int b) {
    while (b != 0) {
        int carry = (a & b) << 1;  // carry
        a = a ^ b;                 // sum without carry
        b = carry;                // move carry to b
    }
    return a;
}
}