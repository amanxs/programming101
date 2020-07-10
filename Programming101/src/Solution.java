//import java.io.*;
//import java.util.*;
//
///*
// * To execute Java, please define "static void main" on a class
// * named Solution.
// *
// * If you need more classes, simply define them inline.
// */
//
//class Solution {
//    public static void main(String[] args) {
//        ArrayList<String> strings = new ArrayList<String>();
//        strings.add("Hello, World!");
//        strings.add("Welcome to CoderPad.");
//        //strings.add("This pad is running Java " + Runtime.version().feature());
//
//        for (String string : strings) {
//            System.out.println(string);
//        }
//    }
//
//    //2 3 6 6 7 8 8 8 10 10 10 11 12 12 14
//    public int[] searchRange(int[] arr, int x){
//        int first = findFirst(arr, x);
//        int last = findFirst(arr, x+1) -1;
//
//        if(first<= last && arr[first] == x)
//            return new int[]{first,last};
//
//        return new int[]{-1,-1};
//    }
//
//    //Return the first that is greater or eq to x
//    public int findFirst(int arr[], int x){
//        int first  = arr.length;
//        int l =0;
//        int r = arr.length-1;
//
//        while(l<=r){
//            int m = l + (r-l)/2;
//            int mid = arr[m];
//
//
//            if(x<=mid){
//                r = m-1;
//                first = m;
//            }
//
//            else {
//                l = m+1;
//            }
//        }
//
//        return first;
//    }
//
//    // false false false true true true true true
//
//    public int firstBadVersion(int n){
//        int res = -1;
//
//        int l=1;
//        int r = n;
//
//        while(l<=r){
//            int m = l+ (r-l)/2;
//
//            if(isBad(m)){
//                r =m-1;
//                res = m;
//            }
//            else {
//                l = m+1;
//            }
//        }
//
//        return res;
//    }
//
//
//    //dsjcbakkrtbaclnk abc
//    int prime[] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79,
//            83, 89, 97, 101};
//    public List<Integer> findAnagrams(String s, String p){
//        int hash = hash(p); //O(n)
//
//        int len = p.length();
//
//        List<Integer> list = new ArrayList<>();
//        for(int i=0; i< (s.length() - len + 1); i++){//O(mn)
//            String sub = s.substring(i, i+len);
//            int val = hash(sub);//O(n)
//            if(hash==val){
//                list.add(i);
//            }
//        }
//
//
//
//        return list;
//    }
//
//    public int hash(String s){
//        int h =1;
//        for(char c : s.toCharArray()){
//            h *= prime[c -'a'];
//        }
//        return h;
//    }
//
//
//    //abc -> [1,1,1 0 0 0 0 0..]   dbacpjacbdg  badtcba
//    public List<Integer> findAllAnagrams(String s, String p){
//        List<Integer> res = new ArrayList<>();
//        int arr[] = new int[26];
//
//        for(char c : p.toCharArray()){
//            arr[index(c)]++;
//        }
//
//        //abc -> [1,1,1 0 0 0 0 0..]   dbbbacpjacbdg  badtcba
//        for(int start =0, end =0; end<s.length(); end++){
//            char cEnd = s.charAt(end);
//            arr[index(cEnd)]--;
//
//            //end -> 4
//
//            //Move the left window until the current char frequency goes positive or 0.
//            while(arr[index(cEnd)]<0 && end>=start){
//                char cStart = s.charAt(start);
//                arr[index(cStart)]++;
//                start++;
//            }
//            if(end - start +1 == p.length()){
//                res.add(start);
//            }
//
//        }
//        return res;
//    }
//    public int index(char c){
//        return c - 'a';
//    }
//
//
//    // Connected components in a undirected graph
//
//    private Map<Integer, List<Integer>> graph;
//    boolean[] marked;
//    public int countComponents(int edges[][], int n){
//        graph = new HashMap<>();
//        for(int edge[] : edges){
//
//            graph.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(edge[1]);
//            graph.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(edge[1]);
//
//        }
//
//        marked = new int[n];
//
//        int count = 0;
//
//        for(int i=0; i<n; i++){
//            if(!marked[i]){
//                dfs(i);
//                count++;
//            }
//        }
//        return count;
//    }
//
//    public void dfs(int v){
//
//        if(!marked[v]){
//            marked[v] = true;
//            for(int u : graph.get(v))
//                dfs(u);
//        }
//    }
//
//
//    public int numIslands(char [][] grid){
//        int islands =0;
//
//        for(int i=0; i<grid.length; i++){
//            for(int j=0; j<grid[i].length; j++){
//                if(grid[i][j]=='1'){
//                    dfs(grid, i, j);
//                    island++;
//                }
//            }
//        }
//
//        return islands;
//
//    }
//
//    public void dfs(char grid[][], int i, int j){
//        if(i<0 || i>= grid.length || j<0 || j>=grid[i].length || grid[i][j] == '0') return;
//
//        grid[i][j] = '0';
//
//        dfs(grid, i+1, j);
//        dfs(grid, i-1, j);
//        dfs(grid, i, j+1);
//        dfs(grid, i, j-1);
//
//    }
//
//
//    public int shortestBridge(int[][] a) {
//        //Step 1 : Find one of the islands and paint all of its values with 2
//        findAndPaint(a);//dfs
//        return bfs(a);
//
//    }
//
//    public int bfs(int a[][]){
//        //Keep expanding level by level and for each level paint with color = prev color +1
//        int res =0;
//        int color = 2;
//
//        while(res == 0){
//
//            for(int i=0; i<a.length; i++){
//                for(int j=0; j<a[i].length; j++){
//                    if(a[i][j] ==color){
//                        if(expand(a, i+1, j, color)
//                                || expand(a, i-1, j, color)
//                                || expand(a, i, j+1, color)
//                                || expand(a, i, j-1, color)){
//                            res = color-2;
//                        }
//
//                    }
//                }
//            }
//            color++;
//        }
//
//
//        return res;
//    }
//
//    public boolean expand(int[][] a, int i, int j, int color){
//        if(i<0 || i>= a.length ||j< 0 || j>=a[i].length) return false;
//        if(a[i][j] == 0){
//            a[i][j] = color +1;
//
//        }
//
//        return a[i][j] == 1;
//
//    }
//
//    public void findAndPaint(int[][] a){
//
//        for(int i=0; i<a.length; i++){
//            for(int j=0; j<a[i].length; j++){
//                if(a[i][j] ==1){
//                    if(paint(a, i, j)) return;
//                }
//            }
//        }
//    }
//
//    public boolean  paint(int [][] a, int i, int j){
//        if(i<0 || i>= a.length ||j< 0 || j>=a[i].length || a[i][j] != 1) return false;
//        a[i][j] = 2;
//
//        paint(a, i+1, j);
//        paint(a, i-1, j);
//        paint(a, i, j+1);
//        paint(a, i, j-1);
//
//        return true;
//    }
//
//    // sum[l..r] = prefsum[r] - prefSum[l-1];
//    public int subarraysum(int nums[], int k){
//        int count = 0;
//        int sum =0;
//        Map<Integer, Integr> map = new HashMap<>();
//        for(int num : nums){
//            sum += num;
//            map.put(sum, map.getOrDefault(sum,0)+1);
//            if(map.containskey(sum-k)) count += map.get(sum-k);
//        }
//        return count;
//    }
//
////   1 2
////   0 3
//
////     if(vistied[nei] !=0 && visited[nei] !=color
//
//
//    int visited[];
//    public boolean isBipartite(int[][] graph){
//        int N= graph.length;
//        marked = new int[N];
//
//        for(int i=0; i<N; i++){
//            if(visited[i] == 0){
//                if(!dfs(graph, i, 1)) return false;
//            }
//
//
//        }
//        return true;
//
//    }
//
//    public boolean dfs(int [][] graph, int v, int color){
//        if(vistied[v] !=0 && visited[v] !=color) return false;
//        if(visited[v] == color) return true;
//        visited[v] = color;
//
//        int[] neigs= graph[v];
//
//        for(int neig : neigs){
//            if(!dfs(graph, v, -color)) return false;
//        }
//
//        return true;
//    }
//    //3456
//
//    public int[] plusOne(int[] digits){
//        int len = digits.length;
//
//        int carry =1;
//        for(int i=len-1; i>=0; i--){
//            int num = digits[i];
//            int val = num+carry;
//            if(val<10) {
//                carry = 0;
//                digits[i] = val;
//                return digits;
//            }
//
//            carry = val/10;
//
//            val %= 10;
//            digits[i] = val;
//
//        }
//        int [] res = new int[len+1];
//        res[0] = 1;
//
//        for(int i=0; i< len ; i++){
//            res[i+1] = digits[i];
//        }
//
//        return res;
//
//    }
//
//    //Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
//
//    public String addStrings(String s1, String s2){
//
//        int carry =0;
//
//        int len1 = s1.length()-1;
//        int len2 = s2.length()-1;
//
//        char num1[] = s1.toCharArray();
//        char num2[] = s1.toCharArray();
//
//        int len = Math.max(len1, len2);
//        int[] temp = new int[len];
//
//        for(int i=0; i<=len; i++){
//            int n1 = len1-i < 0 ? 0 : num1[len1-i] - '0';
//            int n2 = len2-i < 0 ? 0 : num2[len2-i] - '0';
//
//            int val = n1+n2 + carry;
//
//            carry = val/10;
//            val %= 10;
//            temp[len-i] = val;
//
//        }
//
//        StringBuilder sb = new StringBuilder();
//        if(carry>0){
//            sb.append(carry);
//        }
//
//        for(int e : temp){
//            sb.append(e);
//        }
//
//
//        return sb.toString();
//    }
//
//    public int[] productExceptSelf(int[] nums) {
//        int n = nums.length;
//        int res[] = new int[n];
//        //int e - pref[i] * suff[i+1]
//        //Create pref 1 2 3 4
//        int pref =1;
//        for(int i=0; i<n; i++){
//            res[i] = pref; //1 1 2 6 24
//            pref = pref*nums[i];
//        }
//
//        int suf = 1;
//        for(int i=n-1; i>=0; i--){//24  12 8 6
//            res[i] = res[i]*suf;
//            suf = suf*nums[i]; //24 12 4 1
//        }
//
//
//        return res;
//    }
//
//    public String addBinary(String a, String b){
//        int carry =0;
//
//        int len1 = a.length()-1;
//        int len2 = b.length()-1;
//
//        StringBuilder res = new StringBuilder();
//
//        while(len1>=0 || len2>=0){
//            int n1 =len1<0? 0: a.charAt(len1) - '0';
//            int n2 =len2<0? 0: a.charAt(len2) - '0';
//
//            int val = n1+n2 + carry;
//
//            carry = val/2;
//            val = val%2;
//
//            res.append(val);
//
//        }
//
//        if(carry>0) res.append(carry);
//
//        return res.revers().toString();
//    }
//
//    public boolean isPalindrome(String s){
//        s = s.toLowerCase().replaceAll("[^a-zA-Z0-9]*", "");
//
//        /**
//         ^ : start of string
//         [ : beginning of character group
//         a-z : any lowercase letter
//         A-Z : any uppercase letter
//         0-9 : any digit
//         _ : underscore
//         ] : end of character group
//         * : zero or more of the given characters
//         $ : end of string
//         */
//        String regex = "[^a-zA-Z0-9]*";
//        s = s.replaceAll(regex, "");
//
//        for(int i=0, j=s.length()-1; i<j; i++, j-- ){
//            while(i<j && !Character.isLetterOrDigit(s.charAt(i))) i++;
//
//            while(i<j && !Character.isLetterOrDigit(s.charAt(j))) j--;
//
//            if(Character.toLowerCase(charAt(i)) != Character.toLowerCase(s.charAt(i))) return false;
//
//
//        }
//        return true;
//
//    }
//
//    //Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
//
//    public boolean validPalindrome(String s){
//        return validPalindrome(s, 0, s.length()-1, false);
//    }
//
//    public boolean validPalindrome(String s , int l, int r, boolean deleted){
//        if(l<=r) return true;
//
//        if(s.charAt(l) != s.charAt(r)){
//            return !deleted && (validPalindrome(s, l+1, r, true) || validPalindrome(s, l, r-1, true));
//        }
//        return validPalindrome(s, l+1, r-1, deleted);
//
//    }
//
//
//    /**
//     In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. The   order of the alphabet is some permutation of lowercase letters.
//
//     Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographicaly in this alien language.
//
//
//
//     */
//
//    int lex[] = new int[26];
//    public boolean isAlienSorted(String[] words, String order){
//
//        for(int i=0; i<order.length; i++){
//            lex[order.charAt(i) - 'a'] = i;
//        }
//
//        for(int i =0; i<words.length-1; i++){
//            if(!compare(words[i], words[i+1])) return false;
//        }
//    }
//
//    public boolean compare(String word1, String word2){
//        int len1 = word1.length();
//        int len2 = word2.length();
//
//        int len = Math.min(len1, len2);
//
//        for(int i=0; i<len; i++){
//            char c1 = word1.charAt(i);
//            char c2 = word2.charAt(i);
//            if(c1 != c2){
//                if(lex[c1]>lex[c2]) return false;
//            }
//        }
//
//        return true;
//    }
//
//    class TreeNode{
//        int val;
//        TreeNode left;
//        TreeNode right;
//
//        TreeNode(){
//        }
//
//        TreeNode(int val){
//            this.val = val;
//        }
//    }
//
//
//    List<String> list;
//    public List<String> binaryTreePaths(Node root){
//        list = new LinkedList<>();
//        dfs(root, "");
//        return list;
//    }
//
//    public void dfs(TreeNode node, String s){
//
//        if(node == null) return;
//
//
//        int val = node.val;
//
//        StringBuilder sb = new StringBuilder(s);
//
//        if(s.equals("")){
//            sb.append(val);
//        }
//        else{
//            sb.append("->");
//            sb.append(val);
//        }
//
//
//        dfs(node.left, s);
//
//        dfs(node.right, s);
//
//        if(node.left == null && node.right == null){
//            list.add(s);
//        }
//
//        return ;
//
//    }
//
//    //Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).
//
//    int sum=0;
//    public int rangeSumBST(TreeNode root, int l, int r){
//        dfs(root, l, r);
//        return sum;
//    }
//
//    public void dfs(TreeNode root, int l, int r){
//        if(null == root) return;
//
//        if(root.val >=l && root.val <=r){
//            sum += root.val;
//        }
//
//        if(node.val >l){
//            dfs(node.left, l ,r);
//        }
//
//        if(node.val < r){
//            dfs(node.right, l, r);
//        }
//
//
//    }
//
//  /*
//  Given a non-empty binary tree, find the maximum path sum.
//
//For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
//  */
//
//
//    int max =0;
//    public int maxPathSum(TreeNode root){
//
//        if(null == root) return max;
//        max = root.val;
//
//        dfs(root);
//
//        return max;
//    }
//
//    public int dfs(TreeNode node){
//
//        if(null == node) return 0;
//
//        int left  = dfs(node.left);
//
//        int right  = dfs(node.right);
//
//        int val = left + right + node.val;
//
//        max = Math.max(Math.max(max, val), node.val + Math.max(left, right));
//
//        return Math.max(node.val, Math.max(left, right) + node.val);
//    }
//
//
//
//    public TreeNode lowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q){
//
//        return lca(node, p, q);
//    }
//
//    public TreeNode lca(TreeNode node, TreeNode p, TreeNode q){
//        if(node == null) return null;
//
//        if(node.val == p.val || node.val == q.val){
//            return node;
//        }
//
//        TreeNode left = lca(node.left, p,  q);
//        TreeNode right =  lca(node.right, p, q);
//
//        if(left != null && right != null) return node;
//
//        return left!=null ? left : right;
//    }
//}
//
//
