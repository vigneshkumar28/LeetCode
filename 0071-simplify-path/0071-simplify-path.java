class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack= new Stack<>();
        String[] paths = path.split("/");
        
        for(String str: paths){
            if(str.equals("..") && !stack.isEmpty()){
                stack.pop();
            }else if(!str.equals(".")&& !str.equals("..")&& !str.isEmpty()){
                stack.push(str);
            }
        }
        StringBuilder canonicalPath = new StringBuilder("/");
        for(String str: stack){
            canonicalPath.append(str).append("/");
        }
        if(canonicalPath.length() > 1)
            canonicalPath.setLength(canonicalPath.length()-1);
        return canonicalPath.toString();
    }
}