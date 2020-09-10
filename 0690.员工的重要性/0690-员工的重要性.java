
class Solution {
    int sum = 0;
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for(int i = 0; i<employees.size(); i++){
            Employee now = employees.get(i);
            map.put(now.id, now);
        }
        Queue<Employee> queue = new LinkedList<>();
        queue.add(map.get(id));
        while(!queue.isEmpty()){
            Employee now = queue.poll();
            sum += now.importance;
            for(int sub:now.subordinates){
                queue.add(map.get(sub));
            }
        }
        return sum;
    }
}