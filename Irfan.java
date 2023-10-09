import java.util.*;
import java.io.*;

/*
 * users, representing the number of users.
userPairList, representing the profile ID of users such that user2 is a friend of user1.
 */
public class Irfan
{
    static LinkedList<Integer> adjLists[];
    static boolean visited[];
    static int connections = 0;
    static int max_connections = 0;

	public static int  promoMsg(int users, int[][] userPairList)
	{
		int  answer = 0, vertices = users;
		
        adjLists = new LinkedList[vertices];
        visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            adjLists[i] = new LinkedList<Integer>();
        }

        for (int i = 0; i< userPairList.length; i++) {
            adjLists[userPairList[i][0]].add(userPairList[i][1]);
        }

        for(int i = 0; i < users; i++) {
            connections = 0;
            for (int v = 0; v < vertices; v++) {
                visited[v] = false;
            }
            DFS(i);
            if (connections > max_connections) {
                answer = i;
                max_connections = connections;
            }
        }
		System.out.println("ans: " + answer);
		return answer;
	}

    public static void DFS(int vertex) {
            connections++;
            visited[vertex] = true;
        
            Iterator<Integer> ite = adjLists[vertex].listIterator();
            while (ite.hasNext()) {
              int adj = ite.next();
              if (!visited[adj])
                DFS(adj);
            }
    }

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		// input for users
		int users = in.nextInt();
		
		// input for userPairList
		int userPairList_row = in.nextInt();
		int userPairList_col = in.nextInt();
		int userPairList[][] = new int[userPairList_row][userPairList_col];
		for(int idx = 0; idx < userPairList_row; idx++)
		{
			for(int jdx = 0; jdx < userPairList_col; jdx++)
			{
				userPairList[idx][jdx] = in.nextInt();
			}
		}
		
		int result = promoMsg(users, userPairList);
		System.out.print(result);
		
	}
}

/*
 * 
 * 
 * 
5 
4 2 
0 1
3 4
1 2
2 1
 * 
 * 
 */