package org.example.normal;

public class LC788 {


        public int rotatedDigits(int n) {
            int count = 0;
            for (int i = 1; i <= n; i++) {
                if (isGood(i)) {
                    count++;
                }
            }
            return count;
        }

        private boolean isGood(int num) {
            boolean hasValidDigit = false;
            while (num > 0) {
                int digit = num % 10;
                if (digit == 3 || digit == 4 || digit == 7) {
                    return false; // 包含无效数字
                }
                if (digit == 2 || digit == 5 || digit == 6 || digit == 9) {
                    hasValidDigit = true; // 包含有效数字
                }
                num /= 10;
            }
            return hasValidDigit; // 必须包含至少一个有效数字
        }

}
