class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int n=students.length;
        Queue<Integer> studentQueue=new LinkedList<>();
        Stack<Integer> sandwichStack=new Stack<>();
        for(int i=0;i<n;i++){
            studentQueue.offer(students[i]);
            sandwichStack.push(sandwiches[n-i-1]);
        }
        int lastServed=0;
        while(studentQueue.size()>0 && lastServed<studentQueue.size()){
            if(sandwichStack.peek() == studentQueue.peek()){
                sandwichStack.pop();
                studentQueue.poll();
                lastServed=0;
            }else{
                studentQueue.offer(studentQueue.poll());
                lastServed++;
            }
        }
        return studentQueue.size();
    }
}