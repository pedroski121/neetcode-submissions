class Solution {
    Map<Integer, Set<Integer>> children = new HashMap<>();

    Set<Integer> visited = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        for(int i = 0; i < numCourses; i++){
            children.put(i, new HashSet<>());
        }

        for(int[] prereq: prerequisites){
            children.get(prereq[0]).add(prereq[1]);
        }

        // for(int[] courses: prerequisites){
        //     for(int i = 0; i<courses.length; i++){
        //         if(i == 0){
        //             children.put(courses[i], new HashSet<>());
        //         } else {
        //             children.get(courses[0]).add(courses[i]);
        //         }
        //     }
        // }

        for(int i = 0; i<numCourses; i++){
            if(!dfs(i)){
                return false;
            }
        }

        return true;

    }

    public boolean dfs(int course) {
        if(visited.contains(course)){
            return false;
        }

        if(children.get(course).isEmpty()){
            return true;
        }

        Set<Integer> s = children.get(course);

        visited.add(course);

        for(Integer value:s){
            if(!dfs(value)){
                return false;
            }
        }

        visited.remove(course);

        children.put(course, new HashSet<>());

        return true;
    }


}
