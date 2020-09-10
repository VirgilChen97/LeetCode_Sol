class CQueue {
    Stack<Integer> inStack;
    Stack<Integer> outStack;
    public CQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }
    
    public void appendTail(int value) {
        inStack.push(value);
    }
    
    public int deleteHead() {
        if(!outStack.isEmpty()){
            return outStack.pop();
        }else{
            while(!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
            if(!outStack.isEmpty()){
                return outStack.pop();
            }else{
                return -1;
            }
        }
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */