class Solution {
    Set<Integer> visited = new HashSet<>();
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        helper(0, rooms);
        if(visited.size() == rooms.size()){
            return true;
        }else{
            return false;
        }
    }

    public void helper(int room, List<List<Integer>> rooms){
        visited.add(room);
        for(int nextRoom:rooms.get(room)){
            if(!visited.contains(nextRoom)){
                helper(nextRoom, rooms);
            }
        }
    }
}