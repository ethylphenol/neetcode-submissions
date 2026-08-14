class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int diff = 0;
        List<Integer> index = new ArrayList<>();
        for (int i = 0; i < position.length; i++) {
            index.add(i);
        }
        index.sort(Comparator.comparingInt(prev -> position[prev]));
        if (index.size() == 1) return 1;
        int last = index.get(index.size() - 1);

float currentFleetTime =
    (float) (target - position[last]) / speed[last];
        for (int i = index.size()-2; i >= 0; i--) {
            int j = index.get(i);
            float time = (float) (target - position[j])/speed[j];
            if (time > currentFleetTime) { // nije
                currentFleetTime = time;
                diff++;
            } 
        }
        return diff + 1;
    }
}
