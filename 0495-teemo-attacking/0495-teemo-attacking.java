class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) return 0; // 如果没有攻击，直接返回 0
        
        int totalDuration = 0;

        for (int i = 0; i < timeSeries.length - 1; i++) {
            // 计算两次攻击的时间间隔
            int interval = timeSeries[i + 1] - timeSeries[i];
            
            // 如果间隔小于持续时间，累加间隔时间；否则累加完整持续时间
            totalDuration += Math.min(interval, duration);
        }

        // 最后一次攻击的中毒时间一定是完整的持续时间
        totalDuration += duration;

        return totalDuration;
    }
}
