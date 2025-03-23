import java.util.*;

class Solution {

    static class Plan {
        String name;
        int startTime;
        int duration;

        public Plan(String name, String start, String duration) {
            this.name = name;
            this.startTime = toMinute(start);
            this.duration = Integer.parseInt(duration);
        }

        private static int toMinute(String t) {
            String[] parts = t.split(":");
            return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
        }
    }

    public String[] solution(String[][] plans) {
        Plan[] planList = new Plan[plans.length];
        for (int i = 0; i < plans.length; i++) {
            planList[i] = new Plan(plans[i][0], plans[i][1], plans[i][2]);
        }

        Arrays.sort(planList, Comparator.comparingInt(p -> p.startTime));

        Stack<Plan> stack = new Stack<>();
        List<String> answerList = new ArrayList<>();
        int now = planList[0].startTime;

        for (int i = 0; i < planList.length; i++) {
            Plan cur = planList[i];

            now = Math.max(now, cur.startTime);

            int nextStart = (i < planList.length - 1) ? planList[i + 1].startTime : Integer.MAX_VALUE;
            int available = nextStart - now;

            if (cur.duration <= available) {
                now += cur.duration;
                answerList.add(cur.name);

                int remainTime = nextStart - now;
                while (!stack.isEmpty() && remainTime > 0) {
                    Plan paused = stack.pop();
                    if (paused.duration <= remainTime) {
                        now += paused.duration;
                        remainTime -= paused.duration;
                        answerList.add(paused.name);
                    } else {
                        paused.duration -= remainTime;
                        now = nextStart;
                        stack.push(paused);
                        break;
                    }
                }
            } else {
                cur.duration -= available;
                now = nextStart;
                stack.push(cur);
            }
        }

        while (!stack.isEmpty()) {
            answerList.add(stack.pop().name);
        }

        return answerList.toArray(new String[0]);
    }
}
