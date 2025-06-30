class Solution {
        private final String[] BELOW_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                                       "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
                                       "Eighteen", "Nineteen"};

    private final String[] TENS = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        int i = 0;
        StringBuilder result = new StringBuilder();

        while (num > 0) {
            if (num % 1000 != 0) {
                String segment = helper(num % 1000).trim();
                if (!segment.isEmpty()) {
                    result.insert(0, segment + " " + THOUSANDS[i] + " ");
                }
            }
            num /= 1000;
            i++;
        }

        return result.toString().trim();
    }

    private String helper(int num) {
        if (num == 0)
            return "";
        else if (num < 20)
            return BELOW_20[num] + " ";
        else if (num < 100)
            return TENS[num / 10] + " " + helper(num % 10);
        else
            return BELOW_20[num / 100] + " Hundred " + helper(num % 100);
    }
}