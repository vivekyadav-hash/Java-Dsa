import java.util.*;

public class heapAssignment{
// Minimum time to required fill n slot
    public static void minTime(int arr[], int k, int n) {
        Queue<Integer> q = new LinkedList<>();

        boolean visit[] = new boolean[n + 1];
        int time = 0;
        for (int i = 0; i < k; i++) {
            visit[arr[i]] = true;
            q.add(arr[i]);
        }

        while (q.size() > 0) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int curr = q.poll();
                if (curr - 1 >= 1 && !visit[curr - 1]) {
                    visit[curr - 1] = true;
                    q.add(curr - 1);
                }

                if (curr + 1 <= n && !visit[curr + 1]) {
                    visit[curr + 1] = true;
                    q.add(curr + 1);
                }
            }
            time++;
        }
        System.out.println(time - 1);
    }



    static class Node {
        int r, c, cost;

        Node(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }
    }

    public static int minCost(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        PriorityQueue<Node> pq = new PriorityQueue<>(
                (a, b) -> a.cost - b.cost
        );

        pq.add(new Node(0, 0, grid[0][0]));

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            int r = curr.r;
            int c = curr.c;
            int cost = curr.cost;

            if (visited[r][c])
                continue;

            visited[r][c] = true;

            if (r == n - 1 && c == m - 1)
                return cost;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nc >= 0 && nr < n && nc < m && !visited[nr][nc]) {
                    pq.add(new Node(nr, nc, cost + grid[nr][nc]));
                }
            }
        }
        return -1;
    }

    //minimum sum of the half of the any element
public static int minOp(int arr[]){
    int sum =0;
    for(int i=0; i<arr.length; i++){
        sum += arr[i];
    }
    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    for(int i=0; i<arr.length; i++){
        pq.add(arr[i]);
    }

    double temp = sum ;
    int cnt =0;
    while(temp > sum /2){
   int x = pq.peek();
   pq.remove();
   temp -=Math.ceil(x*1.0/2);
   pq.add(x/2);
   cnt++;
    }

    return cnt ;
}


//Merge k sorted Linked list
static class Node{
    int data;
    Node next;

    Node( int key){
        data = key ;
        next = null;
    }
}

class NodeComparator implements  Comparator<Node> {
    public int compare(Node k1, Node k2){
        if(k1.data > k2.data){
            return 1;
        }
        else if(k1.data < k2.data){
            return -1;
        }
        return 0;
    }
}


public static void printList(Node node){
}
}