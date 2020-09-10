class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<String>();
        search(S.toCharArray(),0,res);
        return res;
    }
    public void search(char[] s,int i,List<String> res){
        if(i==s.length){
            res.add(String.valueOf(s));
            return;
        }
        search(s,i+1,res);
        if(s[i]<'0'||s[i]>'9'){
            s[i]^=(1<<5);
            search(s,i+1,res);
        }
        
    }
}