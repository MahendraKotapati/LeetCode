class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int newPlants = 0;

        for(int i=0;i<flowerbed.length;i++) {

            // previous (i-1) and next plant (i+1) should be empty to plant new plant at position i
            if ((i-1 < 0 || flowerbed[i-1] == 0) && (i+1 >= flowerbed.length || flowerbed[i+1] == 0) && (flowerbed[i] == 0)) {
                newPlants++;
                flowerbed[i] = 1;
            }
        }
        return newPlants >= n;
    }
}