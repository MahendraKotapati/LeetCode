public class PushDominoes {
    
    /* TC: O(n) , SC: O(n)
     * Approach:
     * 1) calulate the total force on each domino
     * 2) also maintain the time at which left and right force applied on domino
     * 3) if no force from left then domino will depend on force coming from right and vice versa
     * 3) if domino has forces coming from both left and right at the same time then domino will stand straight (won't fall)
     * 4) if domino has forces coming from both left and right but not at the same time then 
     *    domino will depend on the force which acting on it earlier (which has least time)
     */
    
    public static String pushDominoes(String dominoes) {

       int n = dominoes.length(); 

       char[] rightForce = new char[n + 1];
       int[] rightForceTime = new int[n + 1];
       int currentLeftTime = 0;
       char currentLeftForce = '.';
       StringBuilder res = new StringBuilder("");

       rightForce[n] = '.';
       rightForceTime[n] = 0;

       for(int i = n - 1; i >=0 ; i--) {
           if (dominoes.charAt(i) != '.') { // if current domino is L or R
               rightForce[i] = dominoes.charAt(i);
               rightForceTime[i] = 0;
           }
           else {
               rightForce[i] = ((rightForce[i + 1] == 'L') ? 'L' : '.'); // if next domino is acting force towards right, we can ignore it
               rightForceTime[i] = rightForceTime[i + 1] + 1; // after each second, the force is applied to next domino (can be left or right)
           }
       }


       for(int i = 0; i < n; i++) {
           if (dominoes.charAt(i) != '.') {
               res.append(dominoes.charAt(i));
               currentLeftTime = 0;
               currentLeftForce = dominoes.charAt(i);
           }
           else {
               currentLeftTime++;
               currentLeftForce =  ((currentLeftForce == 'R')  ? 'R' : '.' );  // // if previous domino is acting force towards left, we can ignore it

               char currentTotalForce;

               if (currentLeftForce == '.') { // no force from left
                   currentTotalForce = rightForce[i];
               } else if (rightForce[i] == '.')  { // no force from right
                   currentTotalForce = currentLeftForce;
               } else { // has forces coming from both left and right 
                   if (currentLeftTime == rightForceTime[i]) { // at the same time, so they cancel out each other
                       currentTotalForce = '.';
                   }
                   else { // has forces coming from both left and right but not at the same time
                       currentTotalForce = currentLeftTime < rightForceTime[i] ? currentLeftForce : rightForce[i];  
                   }
               }

               res.append(currentTotalForce);
              
           }
       }

       return new String(res);
   }
}