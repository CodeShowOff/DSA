class Solution {
    public int countPrimes(int n) {
        if(n < 2) return 0;
        boolean[] isNotPrime = new boolean[n];
        isNotPrime[0] = true;
        isNotPrime[1] = true;
        for(int i = 2; i * i < n; i++) {
            if(!isNotPrime[i]) {
                for(int j = i * i; j < n; j+=i) isNotPrime[j] = true;
            }
        }
        int count = 0;
        for(boolean i: isNotPrime) {
            if(!i) count++;
        }
        return count;
    }
}