# STRINGS — Complete Interview Prep (Java)
### Target: SDE roles, 4–8 LPA (India) | Format: Concept → Practice → OA Patterns → Interview Tiers → Revision

---

## 1. CONCEPT PRIMER

### 1.1 What a String actually is in Java
- A `String` in Java is an **immutable** sequence of characters, internally backed by a `char[]` (or `byte[]` since Java 9 with compact strings).
- "Immutable" means once created, a `String` object's content can never change. Every operation that looks like it "modifies" a string (`concat`, `substring`, `replace`, `toUpperCase`) actually **creates a brand-new String object**.
- Because of immutability, Java maintains a **String Pool** (part of heap memory). String literals (`"abc"`) are interned automatically — reused if the same literal appears again. Strings created with `new String("abc")` are NOT pooled automatically.

### 1.2 Time & Space Complexity Cheat Table

| Operation | Complexity | Notes |
|---|---|---|
| `charAt(i)` | O(1) | direct array access |
| `length()` | O(1) | cached |
| `substring(i, j)` | O(j-i) | Java 7+ copies the char array (older JDKs shared array — not anymore) |
| `s1 + s2` (concat) | O(n) | creates new string; **in a loop → O(n²)** |
| `s1.equals(s2)` | O(n) | char by char comparison |
| `s1.compareTo(s2)` | O(n) | lexicographic |
| `toCharArray()` | O(n) | copies into new char array |
| `StringBuilder.append()` | O(1) amortized | like ArrayList, resizes occasionally |
| `StringBuilder.insert(i, x)` | O(n) | shifts characters |
| `StringBuilder.reverse()` | O(n) | |
| `StringBuilder.toString()` | O(n) | |
| `Arrays.sort(char[])` | O(n log n) | used for anagram checks |
| HashMap frequency count | O(n) time, O(k) space | k = distinct chars |

**Golden Rule:** if you're building/modifying a string inside a loop, **never use `String +=`**. Always use `StringBuilder`. This single mistake turns an O(n) solution into O(n²) and is one of the most common reasons "correct" code Time Limit Exceeds (TLEs) in interviews and OAs.

### 1.3 Core Techniques used across String problems
1. **Two Pointers** — one from start, one from end (palindrome check, reverse).
2. **Sliding Window** — variable/fixed size window with a frequency map (longest substring without repeat, anagram search, min window substring).
3. **Frequency Array / HashMap** — count occurrences of each character. If only lowercase a-z, use `int[26]` (faster than HashMap).
4. **Prefix / Suffix precomputation** — palindrome checks, prefix sums of counts.
5. **Hashing (Rabin-Karp)** — rolling hash for substring search.
6. **KMP / Z-algorithm** — pattern matching in O(n+m), avoids re-checking characters.
7. **Dynamic Programming on strings** — LCS, edit distance, longest palindromic substring/subsequence.
8. **Stack** — balanced parentheses, expression evaluation, string decoding.

### 1.4 Java Built-ins You Must Know Cold

```java
// Common String methods
s.length()
s.charAt(i)
s.substring(i)            // from i to end
s.substring(i, j)         // [i, j)
s.indexOf('a')             s.indexOf("ab")
s.lastIndexOf('a')
s.equals(other)             s.equalsIgnoreCase(other)
s.compareTo(other)
s.toUpperCase()              s.toLowerCase()
s.trim()                     s.strip()          // strip is unicode-aware
s.split(" ")                 // regex based split
s.replace('a', 'b')          // char replace
s.contains("ab")
s.startsWith("ab")           s.endsWith("ab")
s.isEmpty()                  s.isBlank()
String.valueOf(123)          // int -> String
Integer.parseInt("123")      // String -> int
s.toCharArray()

// StringBuilder (mutable string, use this for building strings in loops)
StringBuilder sb = new StringBuilder();
sb.append("abc");
sb.append(5);
sb.insert(0, "x");
sb.deleteCharAt(2);
sb.reverse();
sb.toString();
sb.charAt(i);
sb.setCharAt(i, 'x');

// Arrays / Character helpers
Arrays.sort(charArray);
Character.isDigit(c);  Character.isLetter(c);  Character.isUpperCase(c);
Character.toLowerCase(c);  Character.toUpperCase(c);
```

### 1.5 Common Pitfalls (Interviewers actively probe these)
- Using `==` to compare string content instead of `.equals()` — `==` compares references.
- Using `String +=` inside a loop → hidden O(n²).
- Forgetting `substring(i, j)` upper bound `j` is **exclusive**.
- Assuming input is only lowercase letters — always ask/clarify (uppercase? spaces? unicode? digits?).
- Off-by-one errors in two-pointer / sliding window boundaries.
- Not handling empty string `""` or `null` as edge cases.
- Forgetting integer overflow when manually parsing numbers from strings (classic in "String to Integer (atoi)").
- Confusing "palindrome ignoring case/spaces" requirement — always clarify with interviewer.

---

## 2. SOLVED EXAMPLES (Beginner → Easy, 15 problems)

### Example 1 — Reverse a String
**Problem:** Given a string, reverse it.
**Approach:** Two pointers, swap characters from both ends moving inward. Use a char array since Strings are immutable.

```java
public class ReverseString {
    public static String reverse(String str) {
        char[] chars = str.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }
}
```
Time: O(n) | Space: O(n) for the char array (O(1) extra if in-place on char[])

---

### Example 2 — Check Palindrome
**Problem:** Check if a string reads the same forwards and backwards.
**Approach:** Two pointers from both ends, compare characters, stop early if mismatch.

```java
public class PalindromeCheck {
    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
```
Time: O(n) | Space: O(1)

---

### Example 3 — Count Vowels and Consonants
**Approach:** Loop through each char, check membership in a vowel set using if-else.

```java
public class CountVowelsConsonants {
    public static void count(String str) {
        int vowelCount = 0;
        int consonantCount = 0;
        String lower = str.toLowerCase();

        for (int i = 0; i < lower.length(); i++) {
            char ch = lower.charAt(i);
            if (Character.isLetter(ch)) {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowelCount++;
                } else {
                    consonantCount++;
                }
            }
        }
        System.out.println("Vowels: " + vowelCount + ", Consonants: " + consonantCount);
    }
}
```
Time: O(n) | Space: O(1)

---

### Example 4 — Check Anagram
**Problem:** Two strings are anagrams if they contain the same characters with same frequency.
**Approach:** Use a frequency array of size 26 (assume lowercase a-z). Increment for string 1, decrement for string 2. If all counts are zero at the end, they're anagrams.

```java
public class AnagramCheck {
    public static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] freq = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            freq[s2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
```
Time: O(n) | Space: O(1) (fixed 26-size array)

---

### Example 5 — First Non-Repeating Character
**Approach:** First pass builds frequency array. Second pass scans string in order and returns first char with frequency 1.

```java
public class FirstNonRepeating {
    public static char firstNonRepeatingChar(String str) {
        int[] freq = new int[256]; // handles extended ASCII

        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i)]++;
        }

        for (int i = 0; i < str.length(); i++) {
            if (freq[str.charAt(i)] == 1) {
                return str.charAt(i);
            }
        }
        return '\0'; // not found
    }
}
```
Time: O(n) | Space: O(1) (fixed 256-size array)

---

### Example 6 — Count Occurrences of Each Character
**Approach:** Use HashMap<Character, Integer> when character set is unknown/large (unicode); use int[] when restricted to a-z.

```java
import java.util.HashMap;

public class CharFrequency {
    public static HashMap<Character, Integer> countFrequency(String str) {
        HashMap<Character, Integer> freqMap = new HashMap<Character, Integer>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (freqMap.containsKey(ch)) {
                freqMap.put(ch, freqMap.get(ch) + 1);
            } else {
                freqMap.put(ch, 1);
            }
        }
        return freqMap;
    }
}
```
Time: O(n) | Space: O(k), k = distinct characters

---

### Example 7 — Remove Duplicate Characters (preserve first occurrence order)
**Approach:** Use a boolean "seen" array while building result with StringBuilder.

```java
public class RemoveDuplicates {
    public static String removeDuplicates(String str) {
        boolean[] seen = new boolean[256];
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!seen[ch]) {
                seen[ch] = true;
                result.append(ch);
            }
        }
        return result.toString();
    }
}
```
Time: O(n) | Space: O(1) fixed array + O(n) output

---

### Example 8 — Check if String Contains Only Digits
```java
public class OnlyDigitsCheck {
    public static boolean isNumeric(String str) {
        if (str.length() == 0) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
```
Time: O(n) | Space: O(1)

---

### Example 9 — String to Integer (simple atoi, no edge case handling)
**Approach:** Build the number digit by digit: `result = result * 10 + digit`. Handle leading `-` sign.

```java
public class StringToInt {
    public static int stringToInt(String str) {
        int result = 0;
        int sign = 1;
        int index = 0;

        if (str.length() > 0 && str.charAt(0) == '-') {
            sign = -1;
            index = 1;
        }

        for (int i = index; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!Character.isDigit(ch)) {
                break;
            }
            int digit = ch - '0';
            result = result * 10 + digit;
        }
        return result * sign;
    }
}
```
Time: O(n) | Space: O(1)

---

### Example 10 — Reverse Words in a Sentence
**Problem:** `"the sky is blue"` → `"blue is sky the"`
**Approach:** Split by spaces, then append words in reverse order using StringBuilder.

```java
public class ReverseWords {
    public static String reverseWords(String str) {
        String[] words = str.trim().split("\\s+");
        StringBuilder result = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            if (i != 0) {
                result.append(" ");
            }
        }
        return result.toString();
    }
}
```
Time: O(n) | Space: O(n)

---

### Example 11 — Check if Two Strings are Rotations of Each Other
**Problem:** `"waterbottle"` and `"erbottlewat"` → true
**Approach (classic trick):** If `s2` is a rotation of `s1`, then `s2` must be a substring of `s1 + s1`.

```java
public class StringRotation {
    public static boolean areRotations(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        String combined = s1 + s1;
        return combined.contains(s2);
    }
}
```
Time: O(n) (contains() is O(n) roughly) | Space: O(n)

---

### Example 12 — Convert to Upper/Lower Case Manually (without built-in methods)
**Approach:** Use ASCII arithmetic. Lowercase a-z = 97-122, Uppercase A-Z = 65-90, difference = 32.

```java
public class ManualCaseConvert {
    public static String toUpperManual(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch >= 'a' && ch <= 'z') {
                chars[i] = (char) (ch - 32);
            }
        }
        return new String(chars);
    }
}
```
Time: O(n) | Space: O(n)

---

### Example 13 — Longest Common Prefix
**Problem:** Given an array of strings, find the longest common prefix among them.
**Approach:** Take first string as reference prefix. For each subsequent string, shrink the prefix until it matches the start of that string.

```java
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.length() == 0) {
                    return "";
                }
            }
        }
        return prefix;
    }
}
```
Time: O(n*m), n = number of strings, m = length of shortest string | Space: O(1) extra

---

### Example 14 — Count Words in a Sentence
```java
public class CountWords {
    public static int countWords(String str) {
        String trimmed = str.trim();
        if (trimmed.length() == 0) {
            return 0;
        }
        String[] words = trimmed.split("\\s+");
        return words.length;
    }
}
```
Time: O(n) | Space: O(n)

---

### Example 15 — Balanced Parentheses (basic, only one bracket type)
**Approach:** Use a counter. Increment on `(`, decrement on `)`. If counter goes negative at any point, unbalanced. Must end at 0.

```java
public class BalancedParenthesesBasic {
    public static boolean isBalanced(String str) {
        int counter = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                counter++;
            } else if (ch == ')') {
                counter--;
            }
            if (counter < 0) {
                return false;
            }
        }
        return counter == 0;
    }
}
```
Time: O(n) | Space: O(1)

---

## 3. PRACTICE LINKS (Attempt Yourself — No Solutions Given)

| # | Problem | Platform | Difficulty | Hint |
|---|---|---|---|---|
| 1 | [Reverse String](https://leetcode.com/problems/reverse-string/) | LeetCode | Easy | Two pointers, in-place swap |
| 2 | [Valid Palindrome](https://leetcode.com/problems/valid-palindrome/) | LeetCode | Easy | Two pointers, skip non-alphanumeric |
| 3 | [Valid Anagram](https://leetcode.com/problems/valid-anagram/) | LeetCode | Easy | Frequency array of size 26 |
| 4 | [First Unique Character in a String](https://leetcode.com/problems/first-unique-character-in-a-string/) | LeetCode | Easy | Two-pass frequency count |
| 5 | [Longest Common Prefix](https://leetcode.com/problems/longest-common-prefix/) | LeetCode | Easy | Horizontal scanning / shrink prefix |
| 6 | [Reverse Words in a String](https://leetcode.com/problems/reverse-words-in-a-string/) | LeetCode | Medium | Split, trim extra spaces, reverse order |
| 7 | [Rotate String](https://leetcode.com/problems/rotate-string/) | LeetCode | Easy | s2 is rotation if substring of s1+s1 |
| 8 | [Roman to Integer](https://leetcode.com/problems/roman-to-integer/) | LeetCode | Easy | Compare current symbol value with next |
| 9 | [Isomorphic Strings](https://leetcode.com/problems/isomorphic-strings/) | LeetCode | Easy | Two hashmaps for bidirectional mapping |
| 10 | [Ransom Note](https://leetcode.com/problems/ransom-note/) | LeetCode | Easy | Frequency array, check magazine covers note |
| 11 | [Remove Duplicate Letters](https://leetcode.com/problems/remove-duplicate-letters/) | LeetCode | Medium | Stack + last occurrence index |
| 12 | [Check if two strings are Anagram of each other](https://www.geeksforgeeks.org/dsa/check-whether-two-strings-are-anagram-of-each-other/) | GFG | Easy | Sort both & compare, or frequency array |
| 13 | [Print Anagrams Together](https://www.geeksforgeeks.org/dsa/given-a-sequence-of-words-print-all-anagrams-together/) | GFG | Medium | Sort each word as a map key |
| 14 | [Second Most Repeated String](https://www.geeksforgeeks.org/dsa/find-the-second-most-repeated-word-in-a-sequence/) | GFG | Easy | HashMap frequency + track top 2 |
| 15 | [Count and Say](https://leetcode.com/problems/count-and-say/) | LeetCode | Medium | Build string iteratively, run-length encode previous term |

---

## 4. IMPORTANT OA / CONCEPTUAL PATTERN PROBLEMS (Brute → Better → Optimal)

### 4.1 Longest Substring Without Repeating Characters
**Problem:** Find length of the longest substring without repeating characters.
**Link:** https://leetcode.com/problems/longest-substring-without-repeating-characters/ (Medium)

**Brute Force** — check every substring for uniqueness.
```java
public class LongestSubstringBrute {
    public static int lengthOfLongestSubstring(String str) {
        int maxLength = 0;
        int n = str.length();

        for (int i = 0; i < n; i++) {
            boolean[] seen = new boolean[256];
            for (int j = i; j < n; j++) {
                char ch = str.charAt(j);
                if (seen[ch]) {
                    break;
                }
                seen[ch] = true;
                maxLength = Math.max(maxLength, j - i + 1);
            }
        }
        return maxLength;
    }
}
```
Time: O(n²) | Space: O(1) fixed array

**Better** — Sliding window, shrink one step at a time when duplicate found.
```java
public class LongestSubstringBetter {
    public static int lengthOfLongestSubstring(String str) {
        int left = 0;
        int maxLength = 0;
        boolean[] seen = new boolean[256];

        for (int right = 0; right < str.length(); right++) {
            char ch = str.charAt(right);
            while (seen[ch]) {
                seen[str.charAt(left)] = false;
                left++;
            }
            seen[ch] = true;
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
```
Time: O(n) (amortized, each char visited at most twice) | Space: O(1)

**Optimized** — Sliding window with last-seen-index map, jump `left` directly (no inner while loop).
```java
public class LongestSubstringOptimal {
    public static int lengthOfLongestSubstring(String str) {
        int[] lastIndex = new int[256];
        for (int i = 0; i < 256; i++) {
            lastIndex[i] = -1;
        }

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < str.length(); right++) {
            char ch = str.charAt(right);
            if (lastIndex[ch] >= left) {
                left = lastIndex[ch] + 1;
            }
            lastIndex[ch] = right;
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
```
Time: O(n) single pass | Space: O(1)

---

### 4.2 Longest Palindromic Substring
**Link:** https://leetcode.com/problems/longest-palindromic-substring/ (Medium)

**Brute Force** — check every substring.
```java
public class LongestPalinBrute {
    public static String longestPalindrome(String str) {
        int n = str.length();
        String result = "";

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                String sub = str.substring(i, j + 1);
                if (isPalindrome(sub) && sub.length() > result.length()) {
                    result = sub;
                }
            }
        }
        return result;
    }

    private static boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
```
Time: O(n³) | Space: O(n)

**Better** — DP table, `dp[i][j]` = true if `s[i..j]` is palindrome.
```java
public class LongestPalinDP {
    public static String longestPalindrome(String str) {
        int n = str.length();
        boolean[][] dp = new boolean[n][n];
        int startIndex = 0;
        int maxLength = 1;

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for (int length = 2; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;
                if (str.charAt(i) == str.charAt(j)) {
                    if (length == 2 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        if (length > maxLength) {
                            maxLength = length;
                            startIndex = i;
                        }
                    }
                }
            }
        }
        return str.substring(startIndex, startIndex + maxLength);
    }
}
```
Time: O(n²) | Space: O(n²)

**Optimized** — Expand Around Center (odd and even length centers).
```java
public class LongestPalinOptimal {
    public static String longestPalindrome(String str) {
        if (str.length() == 0) {
            return "";
        }
        int start = 0;
        int end = 0;

        for (int i = 0; i < str.length(); i++) {
            int len1 = expandAroundCenter(str, i, i);       // odd length
            int len2 = expandAroundCenter(str, i, i + 1);   // even length
            int maxLen = Math.max(len1, len2);
            if (maxLen > end - start + 1) {
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }
        return str.substring(start, end + 1);
    }

    private static int expandAroundCenter(String str, int left, int right) {
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
```
Time: O(n²) worst case but O(1) extra space, and much faster in practice than DP | Space: O(1)
*(Manacher's Algorithm gives true O(n) but is rarely expected for 4-8 LPA interviews — mention it if asked "can you do better?")*

---

### 4.3 String Compression (Run Length Encoding)
**Problem:** `"aabcccccaaa"` → `"a2b1c5a3"`
**Link:** https://leetcode.com/problems/string-compression/ (Medium)

**Brute Force** — build result using String concatenation (bad practice, shown for comparison).
```java
public class CompressBrute {
    public static String compress(String str) {
        String result = "";
        int count = 1;

        for (int i = 1; i <= str.length(); i++) {
            if (i < str.length() && str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                result += str.charAt(i - 1);   // O(n) per concat -> O(n^2) overall
                result += count;
                count = 1;
            }
        }
        return result;
    }
}
```
Time: O(n²) due to string concatenation | Space: O(n)

**Optimized** — Use StringBuilder, single pass.
```java
public class CompressOptimal {
    public static String compress(String str) {
        StringBuilder result = new StringBuilder();
        int n = str.length();
        int i = 0;

        while (i < n) {
            char currentChar = str.charAt(i);
            int count = 0;
            while (i < n && str.charAt(i) == currentChar) {
                count++;
                i++;
            }
            result.append(currentChar);
            result.append(count);
        }
        return result.length() < n ? result.toString() : str;
    }
}
```
Time: O(n) | Space: O(n) for result

---

### 4.4 Group Anagrams
**Link:** https://leetcode.com/problems/group-anagrams/ (Medium)

**Brute Force** — for each string, compare with every group's representative using isAnagram check (O(n²·k) overall).

**Better/Optimal** — sort each word to get a canonical "key", group in HashMap.
```java
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();

        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(strs[i]);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
```
Time: O(n * k log k), n = number of strings, k = max string length | Space: O(n*k)

*Optimized further (avoid sorting):* build key from a 26-length count array converted to string, giving O(n*k) instead of O(n*k log k). Mention this if interviewer pushes for "better than sorting."

---

### 4.5 Minimum Window Substring
**Problem:** Find smallest substring of `s` containing all characters of `t` (with frequency).
**Link:** https://leetcode.com/problems/minimum-window-substring/ (Hard)

**Brute Force** — check every substring, verify it contains all chars of `t`. O(n² * k). Not shown in full — too slow, avoid in interview.

**Optimized — Sliding Window with frequency map**
```java
import java.util.HashMap;

public class MinWindowSubstring {
    public static String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        HashMap<Character, Integer> need = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        int required = need.size();
        int formed = 0;
        HashMap<Character, Integer> windowCounts = new HashMap<Character, Integer>();

        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int minStart = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            windowCounts.put(ch, windowCounts.getOrDefault(ch, 0) + 1);

            if (need.containsKey(ch) && windowCounts.get(ch).intValue() == need.get(ch).intValue()) {
                formed++;
            }

            while (formed == required) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minStart = left;
                }
                char leftChar = s.charAt(left);
                windowCounts.put(leftChar, windowCounts.get(leftChar) - 1);
                if (need.containsKey(leftChar) && windowCounts.get(leftChar).intValue() < need.get(leftChar).intValue()) {
                    formed--;
                }
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
    }
}
```
Time: O(n + m) | Space: O(k), k = distinct characters in t

---

### 4.6 Find All Anagrams in a String (Sliding Window, fixed size)
**Link:** https://leetcode.com/problems/find-all-anagrams-in-a-string/ (Medium)

**Brute Force** — for each window of size `p.length()`, sort and compare. O(n * k log k).

**Optimized — Fixed sliding window with frequency array**
```java
import java.util.ArrayList;
import java.util.List;

public class FindAllAnagrams {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<Integer>();
        if (s.length() < p.length()) {
            return result;
        }

        int[] need = new int[26];
        int[] window = new int[26];

        for (int i = 0; i < p.length(); i++) {
            need[p.charAt(i) - 'a']++;
        }

        int windowSize = p.length();

        for (int i = 0; i < s.length(); i++) {
            window[s.charAt(i) - 'a']++;

            if (i >= windowSize) {
                window[s.charAt(i - windowSize) - 'a']--;
            }

            if (i >= windowSize - 1 && matches(need, window)) {
                result.add(i - windowSize + 1);
            }
        }
        return result;
    }

    private static boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}
```
Time: O(n * 26) ≈ O(n) | Space: O(1) fixed arrays

---

### 4.7 Implement strStr() — Pattern Matching (Naive vs KMP)
**Link:** https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/ (Easy, but KMP version is a classic Hard OA ask)

**Brute Force** — try every starting index.
```java
public class StrStrBrute {
    public static int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        for (int i = 0; i <= n - m; i++) {
            int j = 0;
            while (j < m && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i;
            }
        }
        return -1;
    }
}
```
Time: O(n*m) worst case | Space: O(1)

**Optimized — KMP Algorithm** (precompute LPS array to avoid re-scanning matched prefix).
```java
public class StrStrKMP {
    public static int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        if (m == 0) {
            return 0;
        }

        int[] lps = buildLPS(needle);
        int i = 0; // pointer for haystack
        int j = 0; // pointer for needle

        while (i < n) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if (j == m) {
                    return i - j;
                }
            } else if (j > 0) {
                j = lps[j - 1];
            } else {
                i++;
            }
        }
        return -1;
    }

    private static int[] buildLPS(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int length = 0;
        int i = 1;

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else if (length > 0) {
                length = lps[length - 1];
            } else {
                lps[i] = 0;
                i++;
            }
        }
        return lps;
    }
}
```
Time: O(n + m) | Space: O(m) for LPS array

---

### 4.8 Longest Palindromic Subsequence
**Problem:** Not necessarily contiguous — find longest subsequence that is a palindrome.
**Link:** https://leetcode.com/problems/longest-palindromic-subsequence/ (Medium)

**Brute Force** — generate all subsequences, check palindrome. O(2ⁿ). Not viable, mention only.

**Optimized — DP** (this is essentially LCS of string and its reverse, or direct interval DP).
```java
public class LongestPalindromicSubsequence {
    public static int longestPalinSubseq(String str) {
        int n = str.length();
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int length = 2; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;
                if (str.charAt(i) == str.charAt(j)) {
                    if (length == 2) {
                        dp[i][j] = 2;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    }
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
```
Time: O(n²) | Space: O(n²) (can be optimized to O(n) with rolling array)

---

### 4.9 Valid Parentheses (Multiple Bracket Types)
**Link:** https://leetcode.com/problems/valid-parentheses/ (Easy, but a very common OA filter question)

**Optimized — Stack based** (this is the standard/only reasonable approach; brute force with string replace loops is O(n²) and worth mentioning as "worse" alternative).
```java
import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String str) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (ch == ')' && top != '(') {
                    return false;
                }
                if (ch == '}' && top != '{') {
                    return false;
                }
                if (ch == ']' && top != '[') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
```
Time: O(n) | Space: O(n) worst case

---

### 4.10 Word Break
**Problem:** Given a string and a dictionary of words, check if the string can be segmented into a space-separated sequence of dictionary words.
**Link:** https://leetcode.com/problems/word-break/ (Medium)

**Brute Force — Recursion** (try every prefix, recurse on remainder).
```java
import java.util.List;

public class WordBreakBrute {
    public static boolean wordBreak(String str, List<String> wordDict) {
        return helper(str, wordDict, 0);
    }

    private static boolean helper(String str, List<String> wordDict, int start) {
        if (start == str.length()) {
            return true;
        }
        for (int end = start + 1; end <= str.length(); end++) {
            String prefix = str.substring(start, end);
            if (wordDict.contains(prefix) && helper(str, wordDict, end)) {
                return true;
            }
        }
        return false;
    }
}
```
Time: O(2ⁿ) exponential | Space: O(n) recursion stack

**Optimized — DP (Tabulation)**
```java
import java.util.List;

public class WordBreakDP {
    public static boolean wordBreak(String str, List<String> wordDict) {
        int n = str.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true; // empty prefix is always "breakable"

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(str.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
```
Time: O(n² * avg word length) for substring + contains check | Space: O(n)
*(Use a HashSet instead of List for wordDict to make `.contains()` O(1) instead of O(k) — always mention this optimization out loud in interview.)*

---

## 5. TOP INTERVIEW QUESTIONS — TIERED BY CTC

### Section A — 4-6 LPA (Service-based / Mass Recruiters: TCS, Infosys, Wipro, Cognizant, Capgemini, Accenture etc.)
These interviews focus on **correctness, clean code, and basic optimization** — rarely go beyond O(n log n).

| Problem | Expected Approach |
|---|---|
| Reverse a string / sentence | Two pointers or StringBuilder.reverse() |
| Check palindrome | Two pointers |
| Check anagram | Frequency array or sort & compare |
| Count character frequency | HashMap or int[26] |
| Remove duplicate characters | Boolean seen array |
| First non-repeating character | Two-pass frequency count |
| Check if string is a rotation of another | s1+s1 contains s2 trick |
| Balanced parentheses (single or multi-type) | Stack |
| Longest common prefix | Horizontal scan / shrinking prefix |
| Count vowels/consonants/words | Basic iteration |
| Convert case manually | ASCII arithmetic |
| String to integer (atoi) basic | Digit-by-digit build |
| Check if string contains only alphabets/digits | Character class checks |

**How to prep for Section A:** Be fast and bug-free on all 15 "Solved Examples" above. These companies often test on HackerRank/AMCAT-style OAs first — speed and correctness matter more than asymptotic cleverness.

---

### Section B — 6-10 LPA (Product-based / Mid-tier: mid-size product companies, fintech, well-funded startups, Tier-2 product roles)
These interviews expect **pattern recognition, complexity discussion, and follow-up handling**.

| Problem | Expected Approach | Common Follow-up / Twist |
|---|---|---|
| Longest substring without repeating characters | Sliding window + last-seen-index map | "What if only lowercase letters?" → use int[26] instead of int[256] for tighter space |
| Longest palindromic substring | Expand around center | "Can you do it in O(n)?" → mention Manacher's algorithm by name (rarely need to code it) |
| Minimum window substring | Sliding window with need/have maps | "What if t can have duplicate chars?" → already handled if using frequency counts correctly |
| Group anagrams | Sort-based key or count-based key in HashMap | "Can you avoid sorting?" → use 26-length count array as key |
| String compression | Two-pointer / write-pointer in-place | "Can you do it in-place with O(1) extra space?" → in-place char array version (LeetCode 443 variant) |
| Find all anagrams in a string | Fixed sliding window with frequency array | "What about unicode characters?" → switch to HashMap-based counts |
| Implement strStr / substring search | KMP or Rabin-Karp | "What's the time complexity of naive vs KMP?" → be ready to explain LPS array construction |
| Longest palindromic subsequence | Interval DP | "Space optimize from O(n²) to O(n)" → rolling 1D array |
| Word Break | DP with HashSet dictionary | "Return all possible sentences" → Word Break II, DP + backtracking |
| Valid anagram / Ransom note style | Frequency array | "What if case-insensitive or has unicode?" → normalize case first, or use HashMap |
| Edit Distance (intro DP-on-strings, sometimes asked here) | Classic 2D DP (insert/delete/replace) | "Space optimize to O(n)" using two rolling rows |
| Decode Ways / String decoding (`3[a2[c]]` style) | Stack-based simulation | "Nested brackets" — must handle recursion via stack correctly |

**How to prep for Section B:** Be comfortable explaining **why** sliding window/DP works, not just coding it. Interviewers will ask you to trace through an example on the whiteboard and discuss brute force → optimal trade-offs explicitly — practice narrating your thought process out loud.

---

## 6. QUICK REVISION SHEET (5-Minute Read Before Interview)

### Pattern Recognition Triggers
| If you see... | Think... |
|---|---|
| "substring" + "no repeat" / "at most k distinct" | Sliding Window |
| "anagram" | Frequency array (int[26]) or sorted key |
| "palindrome" (substring) | Expand around center / DP |
| "palindrome" (subsequence) | Interval DP |
| "pattern search" / "find occurrence" | KMP / Rabin-Karp |
| "balanced brackets" / "nested structure" | Stack |
| "minimum window containing..." | Sliding window with need/have maps |
| "can string be segmented into dictionary words" | DP (Word Break) |
| "edit distance" / "min operations to convert" | 2D DP |
| "group by similarity" | HashMap with canonical key |

### Templates to Memorize

**Two Pointer (Palindrome check)**
```java
int left = 0, right = str.length() - 1;
while (left < right) {
    if (str.charAt(left) != str.charAt(right)) return false;
    left++;
    right--;
}
return true;
```

**Sliding Window (variable size, expand-shrink)**
```java
int left = 0;
for (int right = 0; right < n; right++) {
    // add s[right] to window state
    while (/* window invalid */) {
        // remove s[left] from window state
        left++;
    }
    // update answer using window [left, right]
}
```

**Frequency Array (a-z only)**
```java
int[] freq = new int[26];
for (int i = 0; i < s.length(); i++) {
    freq[s.charAt(i) - 'a']++;
}
```

**StringBuilder for building strings in a loop (never use +=)**
```java
StringBuilder sb = new StringBuilder();
for (int i = 0; i < n; i++) {
    sb.append(someChar);
}
String result = sb.toString();
```

**1D DP over string prefixes (Word Break style)**
```java
boolean[] dp = new boolean[n + 1];
dp[0] = true;
for (int i = 1; i <= n; i++) {
    for (int j = 0; j < i; j++) {
        if (dp[j] && isValid(str.substring(j, i))) {
            dp[i] = true;
            break;
        }
    }
}
```

**2D DP over string pairs (LCS / Edit Distance style)**
```java
int[][] dp = new int[n + 1][m + 1];
for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= m; j++) {
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
            dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
    }
}
```

### Must-Remember Tricks Checklist
- [ ] Never use `String +=` in a loop → use `StringBuilder`.
- [ ] `s1 + s1` contains `s2` → tests if `s2` is a rotation of `s1`.
- [ ] Sort characters of a word → canonical anagram key.
- [ ] `int[26]` is faster than `HashMap<Character,Integer>` when input is guaranteed lowercase a-z.
- [ ] Palindromic **substring** → expand around center (contiguous). Palindromic **subsequence** → DP (non-contiguous).
- [ ] KMP's LPS array = "longest proper prefix that is also a suffix" for each prefix of the pattern.
- [ ] For "first non-repeating" type problems: 2-pass (build freq map, then scan again in original order) beats trying to do it in one pass.
- [ ] Always clarify: case sensitivity? spaces/punctuation? unicode? empty string input? — before coding.
- [ ] `substring(i, j)` → `j` is exclusive; off-by-one is the #1 silly bug in string problems.
- [ ] When asked "can you optimize further?" — always have an answer ready: brute force → better (window/DP) → optimal (tight complexity + minimal extra space), even if you don't code the most optimal, explain it verbally.
- [ ] State time & space complexity out loud for every solution you give, unprompted — this alone signals interview readiness.

---

**End of Strings Module.** Next recommended topic (natural progression from your current level): **Two Pointers & Sliding Window on Arrays** (if not fully covered) → then **Linked Lists (deep dive)** → then **Stacks & Queues** → then **Trees**.
