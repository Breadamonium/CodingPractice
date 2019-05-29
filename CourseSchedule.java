//https://leetcode.com/problems/course-schedule/ #207

public boolean canFinish(int numCourses, int[][] prerequisites) {
    HashMap<Integer, HashSet<Integer>> prereqs = new HashMap<>();
            
    for (int i = 0; i < prerequisites.length; i++) {
        int preReq = prerequisites[i][1];
        int course = prerequisites[i][0];
        if (prereqs.containsKey(course)) {
            HashSet<Integer> current = prereqs.get(course);
            current.add(preReq);
            prereqs.put(course, current);
        }
        else{
            HashSet<Integer> current = new HashSet<Integer>();
            current.add(preReq);
            prereqs.put(course, current);
        }
    }
    HashSet<Integer> taken = new HashSet<Integer>();
    for (int eachCourse = 0; eachCourse<numCourses; eachCourse++) {
        if (prereqs.containsKey(eachCourse)) {
            HashSet<Integer> depends = prereqs.get(eachCourse);
            for (Integer dep : depends) {
                if (!taken.contains(dep)) {
                    return false;
                }
            }
        }
        else{
            taken.add(eachCourse);
        }
    }
    return true;
}