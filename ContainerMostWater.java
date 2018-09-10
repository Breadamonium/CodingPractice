class ContainerMostWater {
    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = height.length-1; j >= 0; j--) {
                int current = Math.min(height[i], height[j])*(j-i);
                if (current > maxArea) {
                    maxArea = current;
                }
            }
        }
        return maxArea;
    }
}