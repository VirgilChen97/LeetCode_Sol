class Solution {
    public String findLongestWord(String s, List<String> d) {
        char[] sc = s.toCharArray();
        String result = "";
        for(String ds : d){
            // 先对长度进行判断,(如果小于结果字符串,不用比了 || (如果相等 && 字典顺序小 也不用比了))
            if(result.length() > ds.length() || (result.length() == ds.length() && result.compareTo(ds) < 0)){
                continue;
            }

            if(isSubStr(sc,ds)){
                result = ds;
            }
        }
        return result;
    }
    public boolean isSubStr(char[] sc,String ds){
        // 字典字符串下标
        int i = 0;
        char[] dsc = ds.toCharArray();
        for(char s : sc){
            if(s == dsc[i]){
                i ++;
                // 如果下标和长度相等,就证明找到了
                if(i == dsc.length){
                    return true;
                }
            }
        }
        // 这还找不到,就证明失败了
        return false;
    }
}