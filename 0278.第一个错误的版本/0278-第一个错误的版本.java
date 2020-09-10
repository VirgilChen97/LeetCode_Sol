public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        return fbv(1,n);
    }
    
    public int fbv(int start, int end){
        if(start == end){
            return start;
        }
        int mid = start + (end-start)/2;
        if(isBadVersion(mid)){
            return fbv(start, mid);
        }else{
            return fbv(mid+1, end);
        }
    }
}