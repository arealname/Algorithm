package org.example.Basic;

public class LC1914 {

    public int[][] rotateGrid(int[][] grid, int k) {
        int[][] result = new int[grid.length][grid[0].length];


        //对于每一圈，先定位四个角

        int circle = Math.min(grid.length, grid[0].length) / 2;

        for (int i = 0; i < circle; i++) {
            int top = i;
            int left = i;
            int right = grid[0].length - 1 - i;
            int bottom = grid.length - 1 - i;

            //将这一圈的元素放入一个一维数组中
            int[] arr = new int[2 * (right - left + bottom - top)];
            int index = 0;
            for (int j = left; j <= right; j++) {
                arr[index++] = grid[top][j];
            }
            for (int j = top + 1; j <= bottom; j++) {
                arr[index++] = grid[j][right];
            }
            for (int j = right - 1; j >= left; j--) {
                arr[index++] = grid[bottom][j];
            }
            for (int j = bottom - 1; j > top; j--) {
                arr[index++] = grid[j][left];
            }

            //旋转这个一维数组
            int s = k % arr.length;
            int[] rotatedArr = new int[arr.length];
            for (int j = 0; j < arr.length; j++) {
                rotatedArr[j] = (arr[(j + s) % arr.length]);
            }

            //将旋转后的元素放回原来的位置
            index = 0;
            for (int j = left; j <= right; j++) {
                result[top][j] = rotatedArr[index++];
            }
            for (int j = top + 1; j <= bottom; j++) {
                result[j][right] = rotatedArr[index++];
            }
            for (int j = right - 1; j >= left; j--) {
                result[bottom][j] = rotatedArr[index++];
            }
            for (int j = bottom - 1; j > top; j--) {
                result[j][left] = rotatedArr[index++];
            }
        }

        return result;


    }
}
