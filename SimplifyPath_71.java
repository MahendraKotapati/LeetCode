public class SimplifyPath_71 {

    /* Approach: TC: O(n) SC: O(n)
        1. read from end of string to start, if encouter '/' go corresponding matching directory case name
            if (empty) continue;
            else if '..' increment goBack++; // noting down we need to skip one parent level directory in future.
            else if (.) continue;
            else if (valid directory_name) {
                if goBack is > 0 { 
                    goBack--; // since we skipped this directory_name;
                    skip and continue;
                }
                else add directory_name to our answer.
            }
    */

    public String simplifyPath(String path) {
        int i=path.length()-1, goBack=0;
        StringBuilder currDir = new StringBuilder("");
        StringBuilder simplifiedPath = new StringBuilder("");

        while(i>=0) {
            if (path.charAt(i)=='/') {
                if (currDir.toString().equals("")) {
                    i--;
                } else if (currDir.toString().equals("..")) {
                    goBack++;
                    i--;
                } else if (currDir.toString().equals(".")) { 
                    i--;
                } else {
                    if (goBack > 0) {
                        goBack--;
                    } else {
                        simplifiedPath.append(currDir);
                        simplifiedPath.append("/");
                    } 
                    i--;
                } 

                currDir = new StringBuilder("");
            } else {
                currDir.append(path.charAt(i));
                i--;
            }
        }

        if (simplifiedPath.length() == 0) // for cases like /../
            return "/";

        simplifiedPath = simplifiedPath.reverse(); 

        return simplifiedPath.toString();
    }
}

/*
// Easy Editorial Solution: O(n), O(n)
 class Solution {
	  public String simplifyPath(String path) {
	  // Initialize a stack
		Stack<String> stack = new Stack<String>();
		String[] components = path.split("/");
    // Split the input string on "/" as the delimiter
    // and process each portion one by one
    for (String directory : components) {
        // A no-op for a "." or an empty string
        if (directory.equals(".") || directory.isEmpty()) {
            continue;
        } else if (directory.equals("..")) {
            // If the current component is a "..", then
            // we pop an entry from the stack if it's non-empty
            if (!stack.isEmpty()) {
                stack.pop();
            }
        } else {
            // Finally, a legitimate directory name, so we add it
            // to our stack
            stack.add(directory);
        }
    }

    // Stich together all the directory names together
    StringBuilder result = new StringBuilder();
    for (String dir : stack) {
        result.append("/");
        result.append(dir);
    }

    return result.length() > 0 ? result.toString() : "/";
  }
}

*/