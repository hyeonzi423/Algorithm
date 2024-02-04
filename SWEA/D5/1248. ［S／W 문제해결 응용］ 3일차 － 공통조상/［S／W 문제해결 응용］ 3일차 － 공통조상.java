import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static Node[] nodes;
	static ArrayList<Integer> ap, bp;
	static Queue<Node> q;

	static class Node {
		int value, parent;
		Node left, right;

		Node(int n) {
			this.value = n;
			this.left = null;
			this.right = null;
		}

		void insert(Node par, int c, int p) {
			if (par.left == null) {
				if (nodes[c] != null) {
					par.left = nodes[c];
					nodes[c].parent = p;
				} else {
					par.left = new Node(c);
					if (nodes[c] == null) {
						nodes[c] = par.left;
						nodes[c].parent = p;
					}
				}
			} else {
				if (nodes[c] != null) {
					par.right = nodes[c];
					nodes[c].parent = p;
				} else {
					par.right = new Node(c);
					if (nodes[c] == null) {
						nodes[c] = par.right;
						nodes[c].parent = p;
					}
				}
			}
		}
	}

	public static int findSame(int a, int b) {
		ap = new ArrayList<>();
		bp = new ArrayList<>();
		Node na = nodes[a];
		Node nb = nodes[b];
		while (true) {
			if (na.parent == 0) {
				break;
			}
			ap.add(na.parent);
			na = nodes[na.parent];
		}
		while (true) {
			if (nb.parent == 0) {
				break;
			}
			bp.add(nb.parent);
			nb = nodes[nb.parent];
		}
		for (int i = 0; i < ap.size(); i++) {
			for (int j = 0; j < bp.size(); j++) {
				if (ap.get(i).equals(bp.get(j))) {
					return ap.get(i);
				}
			}
		}
		return -1;
	}

	public static int subTreeSize(int a) {
		int cnt = 1;
		Node start = nodes[a];
		q = new ArrayDeque<Node>();
		if (start.left != null) {
			q.offer(nodes[start.left.value]);
			cnt += 1;
		}
		if (start.right != null) {
			q.offer(nodes[start.right.value]);
			cnt += 1;
		}
		while (!q.isEmpty()) {
			start = q.poll();
			if (start.left != null) {
				q.offer(nodes[start.left.value]);
				cnt += 1;
			}
			if (start.right != null) {
				q.offer(nodes[start.right.value]);
				cnt += 1;
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		int nodeN, lineN, want1, want2;
		int np, nc, same, layer;
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			nodeN = Integer.parseInt(st.nextToken());
			lineN = Integer.parseInt(st.nextToken());
			want1 = Integer.parseInt(st.nextToken());
			want2 = Integer.parseInt(st.nextToken());

			nodes = new Node[nodeN + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < lineN; i++) {
				np = Integer.parseInt(st.nextToken());
				nc = Integer.parseInt(st.nextToken());
				if (nodes[np] == null) {
					nodes[np] = new Node(np);
					if (np == 1) {
						nodes[np].parent = 0;
					}
				}
				nodes[np].insert(nodes[np], nc, np);
			}
			same = findSame(want1, want2);
			layer = subTreeSize(same);
			sb.append(same + " " + layer + "\n");
		}
		System.out.println(sb);
	}

}