import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

	public static class User {
		int level;
		String name;

		public User(int level, String name) {
			this.level = level;
			this.name = name;
		}
	}

	public static class Room {
		int level;
		ArrayList<User> user;

		public Room(int level, ArrayList<User> user) {
			this.level = level;
			this.user = user;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ArrayList<Room> rooms = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int level = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			boolean enter = false;
			Room r = null;

			for (int j = 0; j < rooms.size(); j++) {
				r = rooms.get(j);
				if (r.user.size() >= M)
					continue;

				if (Math.abs(r.level - level) <= 10) {
					r.user.add(new User(level, name));
					enter = true;
					break;
				}
			}

			if (!enter) {
				rooms.add(new Room(level, new ArrayList<>(Arrays.asList(new User(level, name)))));
			}
		}

		for (Room r : rooms) {
			r.user.sort((a, b) -> a.name.compareTo(b.name));
			if (r.user.size() >= M) {
				sb.append("Started!").append("\n");
				for (User u : r.user) {
					sb.append(u.level).append(" ").append(u.name).append("\n");
				}
				continue;
			} else {
				sb.append("Waiting!").append("\n");
				for (User u : r.user) {
					sb.append(u.level).append(" ").append(u.name).append("\n");
				}
			}
		}
		System.out.println(sb);
	}
}