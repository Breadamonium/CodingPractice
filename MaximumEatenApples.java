import java.util.Map;

class Solution {
    public int eatenApples(int[] apples, int[] days) {
        int answerTotalApples = 0;
        Map<Integer, Integer> appleTracker = new HashMap<Integer, Integer>();
        for (int currentDay = 0; currentDay < apples.length; currentDay++) {
            int numProducedToday = apples[currentDay];
            int rottingDateOfTodaysBatch = currentDay + days[currentDay];
            if (appleTracker.containsKey(rottingDateOfTodaysBatch)) {
                int prevAmount = appleTracker.get(rottingDateOfTodaysBatch);
                prevAmount += numProducedToday;
                appleTracker.put(rottingDateOfTodaysBatch, prevAmount);
                //check nonzero
                // if (rottingDateOfTodaysBatch<=bestDayToEatFrom) {
                //     bestDayToEatFrom = rottingDateOfTodaysBatch;
                // }
            }
            else {
                appleTracker.put(rottingDateOfTodaysBatch, numProducedToday);
                // if (rottingDateOfTodaysBatch<=bestDayToEatFrom) {
                //     bestDayToEatFrom = rottingDateOfTodaysBatch;
                // }
            }
            int dayToEatFrom = 0;
            boolean appleFound = true;
            for (Map.Entry<Integer, Integer> entry : appleTracker.entrySet()) {
                int currentKey = entry.getKey();
                int currentValue = entry.getValue();
                if (currentKey >= currentDay || currentValue > 0) {
                    answerTotalApples++;
                    appleTracker.put(currentKey, currentValue--);
                    appleFound = false;
                    break;
                }
            }
            if (appleFound) {
                return answerTotalApples;
            }

            // int currentStock = appleTracker.get(bestDayToEatFrom);
            // if (currentStock<=0) {
            //     return answerTotalApples;
            // }
            // else {
            //     answerTotalApples++;
            //     int newStock = currentStock--;
            //     appleTracker.put(bestDayToEatFrom, newStock);
            //     // if putting in a zero thing, then the best day is increased or infinity or seomthing+
            // }
        }
    }
}

// apple tracker [{4,0} {10,10} {5,0}]