### [1. 两数之和](https://leetcode.cn/problems/two-sum/)

给定一个整数数组 `nums` 和一个整数目标值 `target`，请你在该数组中找出 **和为目标值** *`target`* 的那 **两个** 整数，并返回它们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。

你可以按任意顺序返回答案。

 **示例 1：**

```
输入：nums = [2,7,11,15], target = 9
输出：[0,1]
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
```

**示例 2：**

```
输入：nums = [3,2,4], target = 6
输出：[1,2]
```

**示例 3：**

```
输入：nums = [3,3], target = 6
输出：[0,1]
```

 **提示：**

- `2 <= nums.length <= 104`
- `-109 <= nums[i] <= 109`
- `-109 <= target <= 109`
- **只会存在一个有效答案**

**进阶：**你可以想出一个时间复杂度小于 `O(n^2)` 的算法吗？

我最先想到的是暴力求解，题目要求数组中同一个元素在答案里不能重复出现。那么从当前元素下一个开始查找，时间复杂度为`O(n^2)`

```java
public int[] twoSum(int[] nums, int target) {
    int n = nums.length;
    for (int i = 0; i < n; ++i) {
        for (int j = i + 1; j < n; ++j) {
            if (nums[i] + nums[j] == target) {
                return new int[]{i, j};
            }
        }
    }
    return new int[0];
}
```

可以将每次遍历的值按照key为值，value为索引存储在哈希表中，用目标值减去当前值就是我们要找的值，判断哈希表中是否存在该值。哈希表查找元素是常数级别的，所有时间复杂度为`O(N)`

```java
public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        int temp = target - nums[i];
        if(hashMap.containsValue(temp)){
            return new int[]{hashMap.get(temp),i};
        }
        hashMap.put(nums[i],i);
    }
    return new int[0];
}
```

### [2. 两数相加](https://leetcode.cn/problems/add-two-numbers/)

给你两个 **非空** 的链表，表示两个非负的整数。它们每位数字都是按照 **逆序** 的方式存储的，并且每个节点只能存储 **一位** 数字。

请你将两个数相加，并以相同形式返回一个表示和的链表。

你可以假设除了数字 0 之外，这两个数都不会以 0 开头。

 **示例 1：**

![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2021/01/02/addtwonumber1.jpg)

```
输入：l1 = [2,4,3], l2 = [5,6,4]
输出：[7,0,8]
解释：342 + 465 = 807.
```

**示例 2：**

```
输入：l1 = [0], l2 = [0]
输出：[0]
```

**示例 3：**

```
输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
输出：[8,9,9,9,0,0,0,1]
```

**提示：**

- 每个链表中的节点数在范围 `[1, 100]` 内
- `0 <= Node.val <= 9`
- 题目数据保证列表表示的数字不含前导零





```java
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
// // 定义total记录两个数的和
// 		int total = 0;
// 		// 定义next记录是否进一
// 		int next = 0;
// 		// 定义返回的链表
// 		ListNode result = new ListNode();
// 		// 定义一个临时指针
// 		ListNode cur = result;
    //先加到短链表
// 		while (l1 != null && l2 != null) {
// 			total = l1.val + l2.val + next;
// 			cur.next = new ListNode(total % 10);
// 			next = total / 10;
// 			l1 = l1.next;
// 			l2 = l2.next;
// 			cur = cur.next;
// 		}
    //补全
// 		while (l1 != null) {
// 			total = l1.val + next;
// 			cur.next = new ListNode(total % 10);
// 			next = total / 10;
// 			l1 = l1.next;
// 			cur = cur.next;
// 		}
// 		while (l2 != null) {
// 			total = l2.val + next;
// 			cur.next = new ListNode(total % 10);
// 			next = total / 10;
// 			l2 = l2.next;
// 			cur = cur.next;
// 		}
    //判断是否还有进位
// 		if (next != 0) {
// 			cur.next = new ListNode(next);
// 		}
// 		return result.next;
//     }

    int total = l1.val + l2.val;
    int next = total / 10;
    ListNode result = new ListNode(total % 10);
    if (l1.next != null || l2.next != null || next != 0) {
        //如果不为空则按当前值，如果为空补成0
        l1 = l1.next = l1.next != null ? l1.next : new ListNode(0);
        l2 = l2.next = l2.next != null ? l2.next : new ListNode(0);
        l1.val += next;
        result.next = addTwoNumbers(l1, l2);
    }
    return result;
}
```

### [3. 无重复字符的最长子串](https://leetcode.cn/problems/longest-substring-without-repeating-characters/)

给定一个字符串 `s` ，请你找出其中不含有重复字符的 **最长子串** 的长度。

**示例 1:**

```
输入: s = "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
```

**示例 2:**

```
输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
```

**示例 3:**

```
输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
```

 **提示：**

- `0 <= s.length <= 5 * 104`
- `s` 由英文字母、数字、符号和空格组成

```java
//滑动窗口
public int lengthOfLongestSubstring(String s) {
    int n = s.length();
    HashMap<Character, Integer> hashMap = new HashMap<>();
    int left = 0;
    int res = 0;
    for (int i = 0; i < n; i++) {
        if (hashMap.containsKey(s.charAt(i))) {
            //如果之前已经遇过该字符，取left和hashmap中存取的下标加1的较大者
            left = Math.max(left, hashMap.get(s.charAt(i)) + 1);
        }
        hashMap.put(s.charAt(i), i);
        res = Math.max(res, i - left + 1);
    }
    return res;
}
```

### [4. 寻找两个正序数组的中位数](https://leetcode.cn/problems/median-of-two-sorted-arrays/)

给定两个大小分别为 `m` 和 `n` 的正序（从小到大）数组 `nums1` 和 `nums2`。请你找出并返回这两个正序数组的 **中位数** 。

算法的时间复杂度应该为 `O(log (m+n))` 。

**示例 1：**

```
输入：nums1 = [1,3], nums2 = [2]
输出：2.00000
解释：合并数组 = [1,2,3] ，中位数 2
```

**示例 2：**

```
输入：nums1 = [1,2], nums2 = [3,4]
输出：2.50000
解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
```

**提示：**

- `nums1.length == m`
- `nums2.length == n`
- `0 <= m <= 1000`
- `0 <= n <= 1000`
- `1 <= m + n <= 2000`
- `-106 <= nums1[i], nums2[i] <= 106`

```java
public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    double res = 0;//结果
    int m = nums1.length;
    int n = nums2.length;
    //特判
    if (m == 0 && n == 0) {
        return 0;
    }
    //合并好的数组
    int[] arr = new int[m + n];
    int q1 = 0;//sum1的索引
    int q2 = 0;//sum2的索引
    int begin = 0;//新数组的索引
    while (q1 < m && q2 < n) {
        //如两数相加，能合并到哪先合
        if (nums1[q1] <= nums2[q2]) {
            arr[begin++] = nums1[q1++];
        } else {
            arr[begin++] = nums2[q2++];
        }
    }
    //看看是谁已经走完了，num1走完则将num2直接加后面
    if (q1 == m) {
        while (q2 != n) {
            arr[begin++] = nums2[q2++];
        }
    }
    if (q2 == n) {
        while (q1 != m) {
            arr[begin++] = nums1[q1++];
        }
    }
    //求中位数
    int mid = (m + n) / 2;
    if ((m + n) % 2 == 0) {
        res = (double) (arr[mid] + arr[mid - 1]) / 2;
    } else {
        res = arr[mid];
    }
    return res;
}
```

### [5. 最长回文子串](https://leetcode.cn/problems/longest-palindromic-substring/)

给你一个字符串 `s`，找到 `s` 中最长的回文子串。

 **示例 1：**

```
输入：s = "babad"
输出："bab"
解释："aba" 同样是符合题意的答案。
```

**示例 2：**

```
输入：s = "cbbd"
输出："bb"
```

 **提示：**

- `1 <= s.length <= 1000`
- `s` 仅由数字和英文字母组成

```java
//判断回文的方法
public boolean huiwen(String s) {
    int n = s.length();
    int l = 0;
    int r = n - 1;
    while (l < r) {
        //从两边向中间走，有一个不同就不是回文
        if (s.charAt(l++) != s.charAt(r--)) {
            return false;
        }
    }
    return true;
}

public String longestPalindrome(String s) {
    int n = s.length();
    //特判
    if (n < 2) {
        return s;
    }
    //让res初始值为第一个字符
    String res = String.valueOf(s.charAt(0));
    for (int i = 0; i < n - 1; i++) {
        for (int j = i + 1; j < n; j++) {
            String temp = s.substring(i, j + 1);
            //这里我必须先判断他是否有资格作为结果（长度要大于之前的结果）
            //否则每次都判断是否回文会超时
            if (temp.length() > res.length() && huiwen(temp)) {
                res = temp;
            }
        }

    }
    return res;
}
```

### [6. Z 字形变换](https://leetcode.cn/problems/zigzag-conversion/)

将一个给定字符串 `s` 根据给定的行数 `numRows` ，以从上往下、从左到右进行 Z 字形排列。

比如输入字符串为 `"PAYPALISHIRING"` 行数为 `3` 时，排列如下：

```
P   A   H   N
A P L S I I G
Y   I   R
```

之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如：`"PAHNAPLSIIGYIR"`。

请你实现这个将字符串进行指定行数变换的函数：

```
string convert(string s, int numRows);
```

 **示例 1：**

```
输入：s = "PAYPALISHIRING", numRows = 3
输出："PAHNAPLSIIGYIR"
```

**示例 2：**

```
输入：s = "PAYPALISHIRING", numRows = 4
输出："PINALSIGYAHRPI"
解释：
P     I    N
A   L S  I G
Y A   H R
P     I
```

**示例 3：**

```
输入：s = "A", numRows = 1
输出："A"
```

 **提示：**

- `1 <= s.length <= 1000`
- `s` 由英文字母（小写和大写）、`','` 和 `'.'` 组成
- `1 <= numRows <= 1000`

```java
/**
 * 思路：这是一个反转过程
 * 例如ABCDEFG 3行
 * 0A 1B 2C 开始反转
 * 1D 0E 反转
 * 1F 2G
 * 那么整理 0 1 2对应的字符就是答案
 */
public String convert(String s, int numRows) {
    //特判
    if (numRows == 1) {
        return s;
    }
    //辅助数组
    String[] arr = new String[numRows];
    //初始化
    for (int i = 0; i < arr.length; i++) {
        arr[i]="";
    }
    int index = 0;//对应思路中的012
    int flag = -1;//控制反转
    for (int i = 0; i < s.length(); i++) {
        //如果index为两端，反转
        if (index == 0 || index == numRows - 1) {
            flag = -flag;
        }
        arr[index] += s.charAt(i);
        index += flag;
    }
    String res = "";
    //拼接
    for (String str : arr) {
        res += str;
    }
    return res;
}
```

###  [7.整数反转](https://leetcode.cn/problems/reverse-integer/)

给你一个 32 位的有符号整数 `x` ，返回将 `x` 中的数字部分反转后的结果。

如果反转后整数超过 32 位的有符号整数的范围 `[−231, 231 − 1]` ，就返回 0。

**假设环境不允许存储 64 位整数（有符号或无符号）。**

 **示例 1：**

```
输入：x = 123
输出：321
```

**示例 2：**

```
输入：x = -123
输出：-321
```

**示例 3：**

```
输入：x = 120
输出：21
```

**示例 4：**

```
输入：x = 0
输出：0
```

 **提示：**

- `-231 <= x <= 231 - 1`

```java
//主要逻辑：第一位变个位，第二位变十位。。。
public int reverse(int x) {
    long res = 0;
    while (x != 0) {
        int temp = x % 10;
        res = res * 10 + temp;
        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
            return 0;
        }
        x /= 10;
    }
    return (int) res;
}
//更简便方法，int转stringbuffer，反转后转int
```

### [8. 字符串转换整数 (atoi)](https://leetcode.cn/problems/string-to-integer-atoi/)

请你来实现一个 `myAtoi(string s)` 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 `atoi` 函数）。

函数 `myAtoi(string s)` 的算法如下：

1. 读入字符串并丢弃无用的前导空格
2. 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
3. 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
4. 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 `0` 。必要时更改符号（从步骤 2 开始）。
5. 如果整数数超过 32 位有符号整数范围 `[−231, 231 − 1]` ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 `−231` 的整数应该被固定为 `−231` ，大于 `231 − 1` 的整数应该被固定为 `231 − 1` 。
6. 返回整数作为最终结果。

**注意：**

- 本题中的空白字符只包括空格字符 `' '` 。
- 除前导空格或数字后的其余字符串外，**请勿忽略** 任何其他字符。

**示例 1：**

```
输入：s = "42"
输出：42
解释：加粗的字符串为已经读入的字符，插入符号是当前读取的字符。
第 1 步："42"（当前没有读入字符，因为没有前导空格）
         ^
第 2 步："42"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
         ^
第 3 步："42"（读入 "42"）
           ^
解析得到整数 42 。
由于 "42" 在范围 [-231, 231 - 1] 内，最终结果为 42 。
```

**示例 2：**

```
输入：s = "   -42"
输出：-42
解释：
第 1 步："   -42"（读入前导空格，但忽视掉）
            ^
第 2 步："   -42"（读入 '-' 字符，所以结果应该是负数）
             ^
第 3 步："   -42"（读入 "42"）
               ^
解析得到整数 -42 。
由于 "-42" 在范围 [-231, 231 - 1] 内，最终结果为 -42 。
```

**示例 3：**

```
输入：s = "4193 with words"
输出：4193
解释：
第 1 步："4193 with words"（当前没有读入字符，因为没有前导空格）
         ^
第 2 步："4193 with words"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
         ^
第 3 步："4193 with words"（读入 "4193"；由于下一个字符不是一个数字，所以读入停止）
             ^
解析得到整数 4193 。
由于 "4193" 在范围 [-231, 231 - 1] 内，最终结果为 4193 。
```

 **提示：**

- `0 <= s.length <= 200`
- `s` 由英文字母（大写和小写）、数字（`0-9`）、`' '`、`'+'`、`'-'` 和 `'.'` 组成

```java
public int myAtoi(String s) {
    int cur = 0;//字符串索引
    int n = s.length();
    //特判
    if (n == 0) {
        return 0;
    }
    //去除前导空格
    while (cur < n && s.charAt(cur) == ' ') {
        cur++;
    }
    int temp = 1;
    //去除+-并判断正负
    if (cur < n && (s.charAt(cur) == '-' || s.charAt(cur) == '+')) {
        if (s.charAt(cur) == '-') {
            temp = -1;
            cur++;
        } else {
            cur++;
        }
    }
    int res = 0;
    int last = 0;
    while (cur < n) {
        int num = s.charAt(cur) - '0';//获取当前字符的int值
        //如果不是数字则退出
        if (num < 0 || num > 9) {
            break;
        }
        last = res;
        res = res * 10 + num;
        //如果不相等就是溢出了，这道题对于我重点在这
        if (last != res / 10) {
            return (temp == (-1)) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        cur++;
    }
    return temp * res;
}
```

### [9. 回文数](https://leetcode.cn/problems/palindrome-number/)

给你一个整数 `x` ，如果 `x` 是一个回文整数，返回 `true` ；否则，返回 `false` 。

回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

- 例如，`121` 是回文，而 `123` 不是。

 **示例 1：**

```
输入：x = 121
输出：true
```

**示例 2：**

```
输入：x = -121
输出：false
解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
```

**示例 3：**

```
输入：x = 10
输出：false
解释：从右向左读, 为 01 。因此它不是一个回文数。
```

 **提示：**

- `-231 <= x <= 231 - 1`

 **进阶：**你能不将整数转为字符串来解决这个问题吗？

```java
public boolean isPalindrome(int x) {
    //负数肯定不是回文数
    if (x < 0) {
        return false;
    }
    String temp = Integer.toString(x);
    int left = 0;
    int right = temp.length() - 1;
    while (left < right) {
        if (temp.charAt(left++) != temp.charAt(right--)) {
            return false;
        }
    }
    return true;
}
```

### [10. 正则表达式匹配](https://leetcode.cn/problems/regular-expression-matching/)

给你一个字符串 `s` 和一个字符规律 `p`，请你来实现一个支持 `'.'` 和 `'*'` 的正则表达式匹配。

- `'.'` 匹配任意单个字符
- `'*'` 匹配零个或多个前面的那一个元素

所谓匹配，是要涵盖 **整个** 字符串 `s`的，而不是部分字符串。

**示例 1：**

```
输入：s = "aa", p = "a"
输出：false
解释："a" 无法匹配 "aa" 整个字符串。
```

**示例 2:**

```
输入：s = "aa", p = "a*"
输出：true
解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
```

**示例 3：**

```
输入：s = "ab", p = ".*"
输出：true
解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
```

 **提示：**

- `1 <= s.length <= 20`
- `1 <= p.length <= 30`
- `s` 只包含从 `a-z` 的小写字母。
- `p` 只包含从 `a-z` 的小写字母，以及字符 `.` 和 `*`。
- 保证每次出现字符 `*` 时，前面都匹配到有效的字符

这道题是这十道题里面最难的了，动态规划

```java
public boolean isMatch(String s, String p) {
    //特判
    if (s == null || p == null) {
        return false;
    }
    int n = s.length();
    int m = p.length();
    char[] s1 = s.toCharArray();
    char[] p1 = p.toCharArray();
    //此数组表示s前i个字符能否与p前j个字符匹配
    boolean[][] dp = new boolean[n + 1][m + 1];
    //初始值，空值匹配空值为true
    dp[0][0] = true;
    //初始化第一列，此时s的位置是0
    for (int j = 1; j < m + 1; j++) {
        //情况1：如果p的j-1个位置是’*‘，则j的状态等于j-2的状态
        //如：s='',p='a*'
        if (p1[j - 1] == '*')
            dp[0][j] = dp[0][j - 2];
    }
    for (int i = 1; i < n + 1; i++) {
        for (int j = 1; j < m + 1; j++) {
            //情况2：如果s和p当前位置相等或者p为'.' dp[i][j]=dp[i-1][j-1]
            //如s=“xxxa”,p=xxx."或s="xxxa",p="xxxa"
            if (s1[i - 1] == p1[j - 1] || p1[j - 1] == '.')
                dp[i][j] = dp[i - 1][j - 1];
            else if (p1[j - 1] == '*') {//如果p当前位置为'*'
                //情况3：如果s当前位置和p前一个位置一样
                //dp[i][j-2]:p向前看了2个位置，相当于*重复了0次 如 s=“xxa” p="xxaa*"
                //dp[i][j-1]:p向前看了1个位置，相当于*重复了1次 如 s=“xxa” p="xxa*"
                //dp[i-1][j]:s向前看了1个位置，相当于*重复了n次 如 s=“xaa” p="xxa*"
                if (s1[i - 1] == p1[j - 2] || p1[j - 2] == '.') {
                    dp[i][j] = dp[i][j - 2] || dp[i][j - 1] || dp[i - 1][j];
                } else {
                    //情况4：s与p前两个位置不匹配 相当于*重复了0次 如 s=“xxa” p="xxb*"
                    dp[i][j] = dp[i][j - 2];
                }

            }
        }

    }
    return dp[n][m];
}
```

### [11. 盛最多水的容器](https://leetcode.cn/problems/container-with-most-water/)

给定一个长度为 `n` 的整数数组 `height` 。有 `n` 条垂线，第 `i` 条线的两个端点是 `(i, 0)` 和 `(i, height[i])` 。

找出其中的两条线，使得它们与 `x` 轴共同构成的容器可以容纳最多的水。

返回容器可以储存的最大水量。

**说明：**你不能倾斜容器。

 **示例 1：**

![img](https://aliyun-lc-upload.oss-cn-hangzhou.aliyuncs.com/aliyun-lc-upload/uploads/2018/07/25/question_11.jpg)

```
输入：[1,8,6,2,5,4,8,3,7]
输出：49 
解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
```

**示例 2：**

```
输入：height = [1,1]
输出：1
```

 **提示：**

- `n == height.length`
- `2 <= n <= 105`
- `0 <= height[i] <= 104`

```java
public int maxArea(int[] height) {
    int left = 0;
    int right = height.length - 1;
    int res = 0;
    while (left < right) {
        //底总是减一，那就让高保持大
        res = height[left] > height[right] ?
                Math.max(res, (right - left) * height[right--]) :
                Math.max(res, (right - left) * height[left++]);
    }
    return res;
}
```

### [12. 整数转罗马数字](https://leetcode.cn/problems/integer-to-roman/)

罗马数字包含以下七种字符： `I`， `V`， `X`， `L`，`C`，`D` 和 `M`。

```
字符          数值
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
```

例如， 罗马数字 2 写做 `II` ，即为两个并列的 1。12 写做 `XII` ，即为 `X` + `II` 。 27 写做 `XXVII`, 即为 `XX` + `V` + `II` 。

通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 `IIII`，而是 `IV`。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 `IX`。这个特殊的规则只适用于以下六种情况：

- `I` 可以放在 `V` (5) 和 `X` (10) 的左边，来表示 4 和 9。
- `X` 可以放在 `L` (50) 和 `C` (100) 的左边，来表示 40 和 90。 
- `C` 可以放在 `D` (500) 和 `M` (1000) 的左边，来表示 400 和 900。

给你一个整数，将其转为罗马数字。

 **示例 1:**

```
输入: num = 3
输出: "III"
```

**示例 2:**

```
输入: num = 4
输出: "IV"
```

**示例 3:**

```
输入: num = 9
输出: "IX"
```

**示例 4:**

```
输入: num = 58
输出: "LVIII"
解释: L = 50, V = 5, III = 3.
```

**示例 5:**

```
输入: num = 1994
输出: "MCMXCIV"
解释: M = 1000, CM = 900, XC = 90, IV = 4.
```

 **提示：**

- `1 <= num <= 3999`

```java
public String intToRoman(int num) {
    int[] nums = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] strs = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    String res = "";
    int count = 0;
    while (num > 0) {
        //从大到小拼接
        while (num - nums[count] >= 0) {
            res += strs[count];
            num -= nums[count];
        }
        count++;
    }
    return res;
}
```

### [13. 罗马数字转整数](https://leetcode.cn/problems/roman-to-integer/)

罗马数字包含以下七种字符: `I`， `V`， `X`， `L`，`C`，`D` 和 `M`。

```
字符          数值
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
```

例如， 罗马数字 `2` 写做 `II` ，即为两个并列的 1 。`12` 写做 `XII` ，即为 `X` + `II` 。 `27` 写做 `XXVII`, 即为 `XX` + `V` + `II` 。

通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 `IIII`，而是 `IV`。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 `IX`。这个特殊的规则只适用于以下六种情况：

- `I` 可以放在 `V` (5) 和 `X` (10) 的左边，来表示 4 和 9。
- `X` 可以放在 `L` (50) 和 `C` (100) 的左边，来表示 40 和 90。 
- `C` 可以放在 `D` (500) 和 `M` (1000) 的左边，来表示 400 和 900。

给定一个罗马数字，将其转换成整数。

 **示例 1:**

```
输入: s = "III"
输出: 3
```

**示例 2:**

```
输入: s = "IV"
输出: 4
```

**示例 3:**

```
输入: s = "IX"
输出: 9
```

**示例 4:**

```
输入: s = "LVIII"
输出: 58
解释: L = 50, V= 5, III = 3.
```

**示例 5:**

```
输入: s = "MCMXCIV"
输出: 1994
解释: M = 1000, CM = 900, XC = 90, IV = 4.
```

 **提示：**

- `1 <= s.length <= 15`
- `s` 仅含字符 `('I', 'V', 'X', 'L', 'C', 'D', 'M')`
- 题目数据保证 `s` 是一个有效的罗马数字，且表示整数在范围 `[1, 3999]` 内
- 题目所给测试用例皆符合罗马数字书写规则，不会出现跨位等情况。
- IL 和 IM 这样的例子并不符合题目要求，49 应该写作 XLIX，999 应该写作 CMXCIX 。
- 关于罗马数字的详尽书写规则，可以参考 [罗马数字 - Mathematics ](https://b2b.partcommunity.com/community/knowledge/zh_CN/detail/10753/罗马数字#knowledge_article)。

```java
public int romanToInt(String s) {
    int sum = 0;
    int preNum = getValue(s.charAt(0));
    for (int i = 1; i < s.length(); i++) {
        int num = getValue(s.charAt(i));
        //关键点：如果前面的数字小于后面的就减，否则加
        if (preNum < num) {
            sum -= preNum;
        } else {
            sum += preNum;
        }
        preNum = num;
    }
    sum += preNum;
    return sum;
}
//将罗马数字转出整数
private int getValue(char ch) {
    switch (ch) {
        case 'I':
            return 1;
        case 'V':
            return 5;
        case 'X':
            return 10;
        case 'L':
            return 50;
        case 'C':
            return 100;
        case 'D':
            return 500;
        case 'M':
            return 1000;
        default:
            return 0;
    }
}
```

### [14. 最长公共前缀](https://leetcode.cn/problems/longest-common-prefix/)

编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 `""`。

**示例 1：**

```
输入：strs = ["flower","flow","flight"]
输出："fl"
```

**示例 2：**

```
输入：strs = ["dog","racecar","car"]
输出：""
解释：输入不存在公共前缀。
```

**提示：**

- `1 <= strs.length <= 200`
- `0 <= strs[i].length <= 200`
- `strs[i]` 仅由小写英文字母组成

```java
public String longestCommonPrefix(String[] strs) {
    String res = "";
    for (int i = 0; i < strs[0].length(); i++) {
        for (int j = 1; j < strs.length; j++) {
            //如果有一个字符串结束直接返回结果
            if (i >= strs[j].length()) {
                return res;
            }
            //让第一个字符串和后面所有字符串对比
            //有一个字符不同直接返回结果
            if (strs[0].charAt(i) != strs[j].charAt(i)) {
                return res;
            }
        }
        res += strs[0].charAt(i);
    }
    return res;
}
```

### [15. 三数之和](https://leetcode.cn/problems/3sum/)

给你一个整数数组 `nums` ，判断是否存在三元组 `[nums[i], nums[j], nums[k]]` 满足 `i != j`、`i != k` 且 `j != k` ，同时还满足 `nums[i] + nums[j] + nums[k] == 0` 。请

你返回所有和为 `0` 且不重复的三元组。

**注意：**答案中不可以包含重复的三元组。

 **示例 1：**

```
输入：nums = [-1,0,1,2,-1,-4]
输出：[[-1,-1,2],[-1,0,1]]
解释：
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
注意，输出的顺序和三元组的顺序并不重要。
```

**示例 2：**

```
输入：nums = [0,1,1]
输出：[]
解释：唯一可能的三元组和不为 0 。
```

**示例 3：**

```
输入：nums = [0,0,0]
输出：[[0,0,0]]
解释：唯一可能的三元组和为 0 。
```

 **提示：**

- `3 <= nums.length <= 3000`
- `-105 <= nums[i] <= 105`

```java
public List<List<Integer>> threeSum(int[] nums) {
    //结果集
    ArrayList<List<Integer>> lists = new ArrayList<>();
    //现将数组排序，有大用
    Arrays.sort(nums);
    int n = nums.length;
    for (int i = 0; i < n; i++) {
        //当前最小值都大于0直接返回结果
        if (nums[i] > 0) {
            return lists;
        }
        //相邻值相同跳过本轮，防止结果重复
        if (i > 0 && nums[i] == nums[i - 1]) {
            continue;
        }
        int cur = nums[i];
        int left = i + 1;
        int right = n - 1;
        while (left < right) {
            int temp = nums[left] + nums[right] + cur;
            if (temp == 0) {
                //三数之和等于0加入结果集
                ArrayList<Integer> list = new ArrayList<>();
                list.add(cur);
                list.add(nums[left]);
                list.add(nums[right]);
                lists.add(list);
                //去重
                while (left < right && nums[left] == nums[left + 1]) {
                    left++;
                }
                while (left < right && nums[right] == nums[right - 1]) {
                    right--;
                }
                left++;
                right--;
            } else if (temp > 0) {
                //大于0说明大了，让三数之和变小，右指针左移
                right--;
            } else {
                //大于0说明小了，让三数之和变大，左指针右移
                left++;
            }
        }
    }
    return lists;
}
```

### [16. 最接近的三数之和](https://leetcode.cn/problems/3sum-closest/)

给你一个长度为 `n` 的整数数组 `nums` 和 一个目标值 `target`。请你从 `nums` 中选出三个整数，使它们的和与 `target` 最接近。

返回这三个数的和。

假定每组输入只存在恰好一个解。

 **示例 1：**

```
输入：nums = [-1,2,1,-4], target = 1
输出：2
解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
```

**示例 2：**

```
输入：nums = [0,0,0], target = 1
输出：0
```

 **提示：**

- `3 <= nums.length <= 1000`
- `-1000 <= nums[i] <= 1000`
- `-104 <= target <= 104`

```java
public int threeSumClosest(int[] nums, int target) {
    int res = Integer.MAX_VALUE;
    //和三数之和一样，先排序
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {
        int cur = nums[i];
        int left = i + 1;
        int right = nums.length - 1;
        while (left < right) {
            int temp = cur + nums[left] + nums[right];
            //也是判断大了还是小了移动双指针
            if (temp < target) {
                left++;
            } else if (temp > target) {
                right--;
            } else {
                //和target一样直接返回target
                return target;
            }
            //取当前三数之和与之前的结果距离target较小的那个
            if (Math.abs(temp - target) < Math.abs(res - target)) {
                res = temp;
            }
        }
    }
    return res;
}
```

### [17. 电话号码的字母组合](https://leetcode.cn/problems/letter-combinations-of-a-phone-number/)

给定一个仅包含数字 `2-9` 的字符串，返回所有它能表示的字母组合。答案可以按 **任意顺序** 返回。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2021/11/09/200px-telephone-keypad2svg.png)

 **示例 1：**

```
输入：digits = "23"
输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
```

**示例 2：**

```
输入：digits = ""
输出：[]
```

**示例 3：**

```
输入：digits = "2"
输出：["a","b","c"]
```

 **提示：**

- `0 <= digits.length <= 4`
- `digits[i]` 是范围 `['2', '9']` 的一个数字。

```java
//最终返回的结果，作为成员变量使得每个函数都可以访问到
ArrayList<String> list = new ArrayList<>();

public List<String> letterCombinations(String digits) {
    //对应2-9的按键，0,1没有值
    String[] str = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    //存储数字代表的字符串
    String[] data = new String[digits.length()];
    //初始化
    for (int i = 0; i < digits.length(); i++) {
        data[i] = str[digits.charAt(i) - '0'];
    }
    StringBuilder sb = new StringBuilder();
    getRes(data, sb, 0);
    return list;
}

//回溯函数：传入存储数字代表的字符串，StringBuilder，索引
public void getRes(String[] data, StringBuilder sb, int index) {
    //终止条件
    if (index == data.length) {
        list.add(sb.toString());
        return;
    }
    for (int i = 0; i < data[index].length(); i++) {
        //获取每一个字符，加入StringBuilder
        char c = data[index].charAt(i);
        sb.append(c);//处理
        getRes(data, sb, index + 1);//递归
        sb.deleteCharAt(sb.length() - 1);//回溯
    }
}
```

### [18. 四数之和](https://leetcode.cn/problems/4sum/)

给你一个由 `n` 个整数组成的数组 `nums` ，和一个目标值 `target` 。请你找出并返回满足下述全部条件且**不重复**的四元组 `[nums[a], nums[b], nums[c], nums[d]]` （若两个四元组元素一一对应，则认为两个四元组重复）：

- `0 <= a, b, c, d < n`
- `a`、`b`、`c` 和 `d` **互不相同**
- `nums[a] + nums[b] + nums[c] + nums[d] == target`

你可以按 **任意顺序** 返回答案 。

 **示例 1：**

```
输入：nums = [1,0,-1,0,-2,2], target = 0
输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
```

**示例 2：**

```
输入：nums = [2,2,2,2,2], target = 8
输出：[[2,2,2,2]]
```

 **提示：**

- `1 <= nums.length <= 200`
- `-109 <= nums[i] <= 109`
- `-109 <= target <= 109`

这道题我个人认为就没啥意义了。做出来之后赶紧看题解希望有优解，发现就行O(N^3)的解法

```java
public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> res = new ArrayList<>();
    int n = nums.length;
    Arrays.sort(nums);
    for (int i = 0; i < n; i++) {
        //相邻值相同跳过本轮，防止结果重复
        if (i > 0 && nums[i] == nums[i - 1]) {
            continue;
        }
        int pre = nums[i];
        for (int j = i + 1; j < n; j++) {
            //相邻值相同跳过本轮，防止结果重复
            if (j > i + 1 && nums[j] == nums[j - 1]) {
                continue;
            }
            int cur = nums[j];
            int left = j + 1;
            int right = n - 1;
            while (left < right) {
                long temp = (long) pre + cur + nums[left] + nums[right];
                if (temp > target) {
                    right--;
                } else if (temp < target) {
                    left++;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(pre);
                    list.add(cur);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);
                    //去重
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                }
            }
        }
    }
    return res;
}
```

### [19. 删除链表的倒数第 N 个结点](https://leetcode.cn/problems/remove-nth-node-from-end-of-list/)

给你一个链表，删除链表的倒数第 `n` 个结点，并且返回链表的头结点。

 **示例 1：**

![img](https://assets.leetcode.com/uploads/2020/10/03/remove_ex1.jpg)

```
输入：head = [1,2,3,4,5], n = 2
输出：[1,2,3,5]
```

**示例 2：**

```
输入：head = [1], n = 1
输出：[]
```

**示例 3：**

```
输入：head = [1,2], n = 1
输出：[1]
```

 **提示：**

- 链表中结点的数目为 `sz`
- `1 <= sz <= 30`
- `0 <= Node.val <= 100`
- `1 <= n <= sz`

 **进阶：**你能尝试使用一趟扫描实现吗？

```java
public ListNode removeNthFromEnd(ListNode head, int n) {
    //特判
    if (head == null) {
        return null;
    }
    //辅助节点
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode pre = dummy;//当前节点的前一个
    ListNode cur = pre.next;//当前节点
    ListNode last = dummy;//先锋节点
    //先让先锋节点走n步
    for (int i = 0; i < n; i++) {
        last = last.next;
    }
    //当last的下一个为空时，就找到了要删除节点
    while (last.next != null) {
        pre = pre.next;
        cur = cur.next;
        last = last.next;
    }
    //断链表完成删除
    pre.next = cur.next;
    return dummy.next;
}
```

### [20. 有效的括号](https://leetcode.cn/problems/valid-parentheses/)

给定一个只包括 `'('`，`')'`，`'{'`，`'}'`，`'['`，`']'` 的字符串 `s` ，判断字符串是否有效。

有效字符串需满足：

1. 左括号必须用相同类型的右括号闭合。
2. 左括号必须以正确的顺序闭合。
3. 每个右括号都有一个对应的相同类型的左括号。

 **示例 1：**

```
输入：s = "()"
输出：true
```

**示例 2：**

```
输入：s = "()[]{}"
输出：true
```

**示例 3：**

```
输入：s = "(]"
输出：false
```

 **提示：**

- `1 <= s.length <= 104`
- `s` 仅由括号 `'()[]{}'` 组成

```java
//经典考察栈的题目
public boolean isValid(String s) {
    if (s.length() == 0) {
        return true; //特判
    }
    //创建栈
    Stack<Character> stack = new Stack<>();
    for (char ch : s.toCharArray()) {
        //左括号入栈
        if (ch == '(' || ch == '[' || ch == '{') {
            stack.push(ch);
        } else {
            if (stack.isEmpty()) {
                return false;//没有左括号有右括号直接返回false
            } else {
                //弹出一个左括号进行匹配
                char temp = stack.pop();
                if (ch == ')') {
                    if (temp != '(') {
                        return false;
                    }
                } else if (ch == ']') {
                    if (temp != '[') {
                        return false;
                    }
                } else if (ch == '}') {
                    if (temp != '{') {
                        return false;
                    }
                }
            }
        }
    }
    return stack.isEmpty();//最后检查是否栈空。都排查完了还剩括号就是false
}
```

### [21. 合并两个有序链表](https://leetcode.cn/problems/merge-two-sorted-lists/)

将两个升序链表合并为一个新的 **升序** 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

 **示例 1：**

![img](https://assets.leetcode.com/uploads/2020/10/03/merge_ex1.jpg)

```
输入：l1 = [1,2,4], l2 = [1,3,4]
输出：[1,1,2,3,4,4]
```

**示例 2：**

```
输入：l1 = [], l2 = []
输出：[]
```

**示例 3：**

```
输入：l1 = [], l2 = [0]
输出：[0]
```

 **提示：**

- 两个链表的节点数目范围是 `[0, 50]`
- `-100 <= Node.val <= 100`
- `l1` 和 `l2` 均按 **非递减顺序** 排列

```java
public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//方法一：递归
    //特判
    if (list1 == null || list2 == null) {
        return list1 == null ? list2 : list1;
    }
    if (list1.val <= list2.val) {
        list1.next = mergeTwoLists(list1.next, list2);
        return list1;
    } else {
        list2.next = mergeTwoLists(list1, list2.next);
        return list2;
    }
//方法二：迭代        
    ListNode res = new ListNode();
    ListNode cur = res;
    while (list1 != null && list2 != null) {
        if (list1.val <= list2.val) {
            cur.next = list1;
            list1 = list1.next;
        } else {
            cur.next = list2;
            list2 = list2.next;
        }
        cur = cur.next;
    }
    if (list1 == null) {
        cur.next = list2;
    }
    if (list2 == null) {
        cur.next = list1;
    }
    return res.next;
}
```

### [22. 括号生成](https://leetcode.cn/problems/generate-parentheses/)

数字 `n` 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 **有效的** 括号组合。

**示例 1：**

```
输入：n = 3
输出：["((()))","(()())","(())()","()(())","()()()"]
```

**示例 2：**

```
输入：n = 1
输出：["()"]
```

 **提示：**

- `1 <= n <= 8`

**深度优先遍历**

```java
public List<String> generateParenthesis(int n) {
    ArrayList<String> res = new ArrayList<>();
    if (n == 0) {
        return res;//特判
    }
    dfs("",0,0,res ,n);
    return res;

}
public void dfs(String s, int left, int right, List<String> res, int n) {
    //终止条件：左括号和右括号等于括号数
    if (left == n && right == n) {
        res.add(s);
        return;
    }
    if (left < right) {
        return;//左括号小于右括号，剪枝
    }
    if (left < n) {
        //添加左括号
        dfs(s + "(", left + 1, right, res, n);
    }
    if (right < n) {
        //添加右括号
        dfs(s + ")", left, right + 1, res, n);
    }
}
```

**广度优先遍历**

```java
class Node {
	//准备一个树形结构
    private String val;//结构值
    private int left;//左括号数
    private int right;//右括号数

    public Node(String val, int left, int right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public List<String> generateParenthesis(int n) {
    ArrayList<String> res = new ArrayList<>();
    if (n == 0) {
        return res;//特判
    }
    //准备队列，bfs常用方法
    Queue<Node> queue = new LinkedList<>();
    queue.offer(new Node("", 0, 0));

    while (!queue.isEmpty()) {
        Node curNode = queue.poll();
        //终止条件：左括号和右括号等于括号数
        if (curNode.left == n && curNode.right == n) {
            res.add(curNode.val);
        }
        if(curNode.left < curNode.right){
            continue;//左括号小于右括号
        }
        //添加左括号
        if (curNode.left <n ) {
            queue.offer(new Node(curNode.val + "(", curNode.left + 1, curNode.right));
        }
        //添加右括号
        if (curNode.right <n ) {
            queue.offer(new Node(curNode.val + ")", curNode.left, curNode.right + 1));
        }
    }
    return res;
}
```

### [23. 合并K个升序链表](https://leetcode.cn/problems/merge-k-sorted-lists/)

给你一个链表数组，每个链表都已经按升序排列。

请你将所有链表合并到一个升序链表中，返回合并后的链表。

 **示例 1：**

```
输入：lists = [[1,4,5],[1,3,4],[2,6]]
输出：[1,1,2,3,4,4,5,6]
解释：链表数组如下：
[
  1->4->5,
  1->3->4,
  2->6
]
将它们合并到一个有序链表中得到。
1->1->2->3->4->4->5->6
```

**示例 2：**

```
输入：lists = []
输出：[]
```

**示例 3：**

```
输入：lists = [[]]
输出：[]
```

 **提示：**

- `k == lists.length`
- `0 <= k <= 10^4`
- `0 <= lists[i].length <= 500`
- `-10^4 <= lists[i][j] <= 10^4`
- `lists[i]` 按 **升序** 排列
- `lists[i].length` 的总和不超过 `10^4`

```java
//分治算法
public ListNode mergeKLists(ListNode[] lists) {
    int n = lists.length;
    if (n == 0) {
        return null;
    }
    return process(lists, 0, n - 1);
}
//分
public ListNode process(ListNode[] lists, int left, int right) {
    if (left == right) {
        return lists[left];
    }
    int mid = left + (right - left) / 2;
    ListNode l = process(lists, left, mid);
    ListNode r = process(lists, mid + 1, right);
    return merge(l, r);
}
//治
public ListNode merge(ListNode l1, ListNode l2) {
    //这里其实就是合并两条链表的算法
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    while (l1 != null && l2 != null) {
        if (l1.val <= l2.val) {
            cur.next = l1;
            l1 = l1.next;
        } else {
            cur.next = l2;
            l2 = l2.next;
        }
        cur = cur.next;
    }
    cur.next = l1 == null ? l2 : l1;
    return dummy.next;
}
```

### [24. 两两交换链表中的节点](https://leetcode.cn/problems/swap-nodes-in-pairs/)

给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。

 **示例 1：**

![img](https://assets.leetcode.com/uploads/2020/10/03/swap_ex1.jpg)

```
输入：head = [1,2,3,4]
输出：[2,1,4,3]
```

**示例 2：**

```
输入：head = []
输出：[]
```

**示例 3：**

```
输入：head = [1]
输出：[1]
```

 **提示：**

- 链表中节点的数目在范围 `[0, 100]` 内
- `0 <= Node.val <= 100`

```java
public ListNode swapPairs(ListNode head) {
    if (head == null) {
        return null;
    }
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode pre = dummy;
    ListNode cur = dummy.next;
    ListNode next = cur.next;
    ListNode last;
    while (cur != null && next != null) {
        last = next.next;
        pre.next = next;
        next.next = cur;
        cur.next = last;
        pre = cur;
        cur = last;
        next = cur == null ? null : cur.next;
    }
    return dummy.next;
}
```

### [25. K 个一组翻转链表](https://leetcode.cn/problems/reverse-nodes-in-k-group/)

给你链表的头节点 `head` ，每 `k` 个节点一组进行翻转，请你返回修改后的链表。

`k` 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 `k` 的整数倍，那么请将最后剩余的节点保持原有顺序。

你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。

 **示例 1：**

![img](https://assets.leetcode.com/uploads/2020/10/03/reverse_ex1.jpg)

```
输入：head = [1,2,3,4,5], k = 2
输出：[2,1,4,3,5]
```

**示例 2：**

![img](https://assets.leetcode.com/uploads/2020/10/03/reverse_ex2.jpg)

```
输入：head = [1,2,3,4,5], k = 3
输出：[3,2,1,4,5]
```

 **提示：**

- 链表中的节点数目为 `n`
- `1 <= k <= n <= 5000`
- `0 <= Node.val <= 1000`

 **进阶：**你可以设计一个只用 `O(1)` 额外内存空间的算法解决此问题吗？

```java
public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null || k < 2) {
        return head;//特判
    }
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode pre = dummy;
    ListNode end = dummy;
    while (end.next != null) {
        //找到结尾，若k比待反转部分长度大，返回结果
        for (int i = 0; i < k; i++) {
            end = end.next;
            if (end == null) return dummy.next;
        }
        //反转开始的节点
        ListNode start = pre.next;
        //下一次反转的节点开始
        ListNode next = end.next;
        //断链表
        end.next = null;
        pre.next = reverse(start);
        start.next = next;
        pre = start;
        end = start;
    }
    return dummy.next;
}

//反转链表
public ListNode reverse(ListNode head) {
    ListNode pre = null;
    ListNode cur = head;
    while (cur != null) {
        ListNode last = cur.next;
        cur.next = pre;
        pre = cur;
        cur = last;
    }
    return pre;
}
```

### [26. 删除有序数组中的重复项](https://leetcode.cn/problems/remove-duplicates-from-sorted-array/)

给你一个 **升序排列** 的数组 `nums` ，请你**[ 原地](http://baike.baidu.com/item/原地算法)** 删除重复出现的元素，使每个元素 **只出现一次** ，返回删除后数组的新长度。元素的 **相对顺序** 应该保持 **一致** 。

由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 `k` 个元素，那么 `nums` 的前 `k` 个元素应该保存最终结果。

将最终结果插入 `nums` 的前 `k` 个位置后返回 `k` 。

不要使用额外的空间，你必须在 **[原地 ](https://baike.baidu.com/item/原地算法)修改输入数组** 并在使用 O(1) 额外空间的条件下完成。

**判题标准:**

系统会用下面的代码来测试你的题解:

```
int[] nums = [...]; // 输入数组
int[] expectedNums = [...]; // 长度正确的期望答案

int k = removeDuplicates(nums); // 调用

assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
    assert nums[i] == expectedNums[i];
}
```

如果所有断言都通过，那么您的题解将被 **通过**。

 **示例 1：**

```
输入：nums = [1,1,2]
输出：2, nums = [1,2,_]
解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
```

**示例 2：**

```
输入：nums = [0,0,1,1,1,2,2,3,3,4]
输出：5, nums = [0,1,2,3,4]
解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
```

 **提示：**

- `1 <= nums.length <= 3 * 104`
- `-104 <= nums[i] <= 104`
- `nums` 已按 **升序** 排列

```java
public int removeDuplicates(int[] nums) {
    int ans = 0;
    for (int i = 1; i < nums.length; i++) {
        if (nums[ans] != nums[i]) {
            nums[ans + 1] = nums[right];
            ans++;
        }
    }
    return ans + 1;
}
```

### [27. 移除元素](https://leetcode.cn/problems/remove-element/)

给你一个数组 `nums` 和一个值 `val`，你需要 **[原地](https://baike.baidu.com/item/原地算法)** 移除所有数值等于 `val` 的元素，并返回移除后数组的新长度。

不要使用额外的数组空间，你必须仅使用 `O(1)` 额外空间并 **[原地 ](https://baike.baidu.com/item/原地算法)修改输入数组**。

元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

 **说明:**

为什么返回数值是整数，但输出的答案是数组呢?

请注意，输入数组是以**「引用」**方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。

你可以想象内部操作如下:

```
// nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
int len = removeElement(nums, val);

// 在函数里修改输入数组对于调用者是可见的。
// 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
for (int i = 0; i < len; i++) {
    print(nums[i]);
}
```

 **示例 1：**

```
输入：nums = [3,2,2,3], val = 3
输出：2, nums = [2,2]
解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
```

**示例 2：**

```
输入：nums = [0,1,2,2,3,0,4,2], val = 2
输出：5, nums = [0,1,4,0,3]
解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。
```

 **提示：**

- `0 <= nums.length <= 100`
- `0 <= nums[i] <= 50`
- `0 <= val <= 100`

```java
public int removeElement(int[] nums, int val) {
    int ans = 0;
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] != val) {
            nums[ans] = nums[i];
            ans++;
        }
    }
    return ans;
}
```

### [28. 找出字符串中第一个匹配项的下标](https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/)

给你两个字符串 `haystack` 和 `needle` ，请你在 `haystack` 字符串中找出 `needle` 字符串的第一个匹配项的下标（下标从 0 开始）。如果 `needle` 不是 `haystack` 的一部分，则返回 `-1` 。

 **示例 1：**

```
输入：haystack = "sadbutsad", needle = "sad"
输出：0
解释："sad" 在下标 0 和 6 处匹配。
第一个匹配项的下标是 0 ，所以返回 0 。
```

**示例 2：**

```
输入：haystack = "leetcode", needle = "leeto"
输出：-1
解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
```

 **提示：**

- `1 <= haystack.length, needle.length <= 104`
- `haystack` 和 `needle` 仅由小写英文字符组成

**利用API**

```java
public int strStr(String haystack, String needle) {
    return haystack.indexOf(needle);
}
```

**KMP算法**

如果看不懂只能去学习了解KMP算法了，本人无法通过文字描述。这道题就是KMP的模板题

```java
//构建next数组
public int[] createNext(String s) {
    int[] next = new int[s.length()];
    int j = 0;
    for (int i = 1; i < s.length(); i++) {
        while (j > 0 && s.charAt(i) != s.charAt(j)) {
            j = next[j - 1];
        }
        if (s.charAt(i) == s.charAt(j)) {
            j++;
        }
        next[i] = j;
    }
    return next;
}

public int strStr(String haystack, String needle) {
    int n = haystack.length(), m = needle.length();
    if (m == 0) {
        return 0;
    }
    int[] next = createNext(needle);
    int index = 0;
    for (int i = 0; i < n; i++) {
        while (index > 0 && haystack.charAt(i) != needle.charAt(index)) {
            index = next[index - 1];
        }
        if (haystack.charAt(i) == needle.charAt(index)) {
            index++;
        }
        if (index == m) {
            return i - m + 1;
        }
    }
    return -1;
}
```

### [29. 两数相除](https://leetcode.cn/problems/divide-two-integers/)

给定两个整数，被除数 `dividend` 和除数 `divisor`。将两数相除，要求不使用乘法、除法和 mod 运算符。

返回被除数 `dividend` 除以除数 `divisor` 得到的商。

整数除法的结果应当截去（`truncate`）其小数部分，例如：`truncate(8.345) = 8` 以及 `truncate(-2.7335) = -2`

 **示例 1:**

```
输入: dividend = 10, divisor = 3
输出: 3
解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
```

**示例 2:**

```
输入: dividend = 7, divisor = -3
输出: -2
解释: 7/-3 = truncate(-2.33333..) = -2
```

 **提示：**

- 被除数和除数均为 32 位有符号整数。
- 除数不为 0。
- 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231, 231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。

```java
public int divide(int dividend, int divisor) {
    long d1 = (long) Math.abs(((long) dividend));
    long d2 = (long) Math.abs(((long) divisor));
    boolean isNeg = (dividend ^ divisor) < 0;
    long l = 1, r = d1;
    long ans = 0;
    while (l <= r) {
        long mid = l + ((r - l) >> 1);
        if (multiply(mid, d2) <= d1) {
            ans = mid;
            l = mid + 1;
        } else {
            r = mid - 1;
        }
    }
    if (!isNeg && ans > Integer.MAX_VALUE) {
        return Integer.MAX_VALUE;
    }
    return isNeg ? (int) (-ans) : (int) ans;
}

public long multiply(long a, long b) {
    long ans = 0;
    while (b > 0) {
        if ((b & 1) == 1) {
            ans += a;
        }
        a += a;
        b >>= 1;
    }
    return ans;
}
```

### [30. 串联所有单词的子串](https://leetcode.cn/problems/substring-with-concatenation-of-all-words/)

给定一个字符串 `s` 和一个字符串数组 `words`**。** `words` 中所有字符串 **长度相同**。

 `s` 中的 **串联子串** 是指一个包含 `words` 中所有字符串以任意顺序排列连接起来的子串。

- 例如，如果 `words = ["ab","cd","ef"]`， 那么 `"abcdef"`， `"abefcd"`，`"cdabef"`， `"cdefab"`，`"efabcd"`， 和 `"efcdab"` 都是串联子串。 `"acdbef"` 不是串联子串，因为他不是任何 `words` 排列的连接。

返回所有串联字串在 `s` 中的开始索引。你可以以 **任意顺序** 返回答案。

 **示例 1：**

```
输入：s = "barfoothefoobarman", words = ["foo","bar"]
输出：[0,9]
解释：因为 words.length == 2 同时 words[i].length == 3，连接的子字符串的长度必须为 6。
子串 "barfoo" 开始位置是 0。它是 words 中以 ["bar","foo"] 顺序排列的连接。
子串 "foobar" 开始位置是 9。它是 words 中以 ["foo","bar"] 顺序排列的连接。
输出顺序无关紧要。返回 [9,0] 也是可以的。
```

**示例 2：**

```
输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
输出：[]
解释：因为 words.length == 4 并且 words[i].length == 4，所以串联子串的长度必须为 16。
s 中没有子串长度为 16 并且等于 words 的任何顺序排列的连接。
所以我们返回一个空数组。
```

**示例 3：**

```
输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
输出：[6,9,12]
解释：因为 words.length == 3 并且 words[i].length == 3，所以串联子串的长度必须为 9。
子串 "foobarthe" 开始位置是 6。它是 words 中以 ["foo","bar","the"] 顺序排列的连接。
子串 "barthefoo" 开始位置是 9。它是 words 中以 ["bar","the","foo"] 顺序排列的连接。
子串 "thefoobar" 开始位置是 12。它是 words 中以 ["the","foo","bar"] 顺序排列的连接。
```

 **提示：**

- `1 <= s.length <= 104`
- `1 <= words.length <= 5000`
- `1 <= words[i].length <= 30`
- `words[i]` 和 `s` 由小写英文字母组成

**失败的版本，用的回溯，通过150+的示例，然后超出内存限制了**

```java
List<Integer> res = new ArrayList<>();
List<String> list = new ArrayList<>();

public List<Integer> findSubstring(String s, String[] words) {
    if (s == null || words[0].length() * words.length > s.length()) {
        return res;
    }
    StringBuffer sb = new StringBuffer();
    bfs(sb, words, 0);
    for (String str : list) {
        int index = -1;
        while (index <= s.length()) {
            index = s.indexOf(str, index);
            if (index == -1) {
                break;
            }
            if (!res.contains(index)) {
                res.add(index);
            }
            index += 1;
        }
    }
    return res;
}

public void bfs(StringBuffer s, String[] words, int index) {
    if (words.length == index) {
        list.add(s.toString());
        return;
    }
    String help;
    for (int i = 0; i < words.length; i++) {
        if (words[i].equals("")) continue;
        s.append(words[i]);
        help = words[i];
        words[i] = "";
        bfs(s, words, index + 1);
        words[i] = help;
        s.delete(index * words[i].length(), (index + 1) * words[i].length());
    }
}
```

**滑动窗口**

```java
public List<Integer> findSubstring(String s, String[] words) {
    List<Integer> res = new ArrayList<>();
    int w = words[0].length();//一个单词的长度
    int len = w * words.length;//子串长度
    if (len > s.length()) {
        return res;//特判
    }
    HashMap<String, Integer> hashMap = new HashMap<>();
    for (String word : words) {
        if (hashMap.containsKey(word)) {
            int key = hashMap.get(word);
            hashMap.put(word, ++key);
        } else {
            hashMap.put(word, 1);
        }
    }
    HashMap<String, Integer> tempMap = new HashMap<>();
    for (int start = 0; start + len <= s.length(); start++) {
        tempMap.clear();
        int j;
        for (j = 0; j < len; j += w) {
            String temp = s.substring(start + j, start + j + w);//截取一个单词的长度
            if (hashMap.containsKey(temp)) {
                //如果有这个单词，就让它加入到临时哈希表
                if (tempMap.containsKey(temp)) {
                    int value = tempMap.get(temp);
                    tempMap.put(temp, ++value);
                    if (value > hashMap.get(temp)) {
                        //如果匹配的单词数比原有的多，跳出
                        break;
                    }
                } else {
                    tempMap.put(temp, 1);
                }
            } else {
                //如果都没有这个单词，跳出
                break;
            }
        }
        if (j == len) {
            //全部都有，加入结果集
            res.add(start);
        }
    }
    return res;
}
```

