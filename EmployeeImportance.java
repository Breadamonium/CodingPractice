/*
Leetcode #690 https://leetcode.com/problems/employee-importance/
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class EmployeeImportance {
    HashMap<Integer, Employee> directory = new HashMap<Integer, Employee>();
    public int getImportance(List<Employee> employees, int id) {
        for (Employee each : employees) {
            directory.put(each.id, each);
        }
        Employee theGuy = directory.get(id);
        return helperFindSubs(theGuy.subordinates, theGuy.importance);
    }

    public int helperFindSubs(List<Integer> subs, int answer) {
        int currentanswer = answer;
        if (subs.isEmpty()) {
            return answer;
        }
        else {
            for (int every1 : subs) {
                System.out.println(every1);
                System.out.println(currentanswer);
                currentanswer += directory.get(every1).importance;
                currentanswer =  helperFindSubs(directory.get(every1).subordinates, currentanswer);
            }
            return currentanswer;
        }
    }
}