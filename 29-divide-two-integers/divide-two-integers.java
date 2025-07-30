class Solution {
    public int divide(int dividend, int divisor) {
        // Edge case: overflow when result would be 2^31
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

        // Determine sign of the result
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // Work with positive longs to avoid overflow on abs(MIN_VALUE)
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);

        int result = 0;

        // Repeatedly subtract the largest doubled divisor we can (bit shifting)
        while (dvd >= dvs) {
            long temp = dvs;
            int multiple = 1;

            // Double until next doubling would exceed the remaining dividend
            while ((temp << 1) <= dvd) {
                temp <<= 1;        // temp = temp * 2
                multiple <<= 1;    // multiple = multiple * 2
            }

            dvd -= temp;
            result += multiple;
        }

        return negative ? -result : result;
    }
}