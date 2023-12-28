class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int targetColor) {
        int currentColor = image[sr][sc];
        if(currentColor == targetColor)
            return image;
        dfs(image, sr, sc,targetColor, currentColor);
        return image;
    }
    private void dfs(int[][] image, int sr, int sc, int targetColor, int currentColorNeedsToPaint){
        if(sr < 0|| sc<0|| sr >= image.length || sc >= image[0].length || image[sr][sc] != currentColorNeedsToPaint)
            return;
        image[sr][sc] = targetColor;
        dfs(image, sr+1, sc, targetColor, currentColorNeedsToPaint);
        dfs(image, sr-1, sc,targetColor, currentColorNeedsToPaint);
        dfs(image, sr, sc+1,targetColor, currentColorNeedsToPaint);
        dfs(image, sr, sc-1,targetColor, currentColorNeedsToPaint);
    }
}