class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Map = new int[26];
        int[] s2Map = new int[26];

        // Count frequency of first window
        for (int i = 0; i < s1.length(); i++) {
            s1Map[s1.charAt(i) - 'a']++;
            s2Map[s2.charAt(i) - 'a']++;
        }

        // Slide the window
        for (int i = 0; i < s2.length() - s1.length(); i++) {

            if (matches(s1Map, s2Map)) {
                return true;
            }

            // Add new character
            s2Map[s2.charAt(i + s1.length()) - 'a']++;

            // Remove old character
            s2Map[s2.charAt(i) - 'a']--;
        }

        // Check the last window
        return matches(s1Map, s2Map);
    }

    private boolean matches(int[] s1Map, int[] s2Map) {
        for (int i = 0; i < 26; i++) {
            if (s1Map[i] != s2Map[i]) {
                return false;
            }
        }
        return true;
    }
}