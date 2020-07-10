import java.util.*;

public class ExclusiveTimeOfFunc {

        class Func{
            String id;
            String event;
            String time;

            Func(String id, String event, String time){
                this.id = id;
                this.event = event;
                this.time = time;
            }
        }
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Func> stack = new Stack<>();
        int wait=0;
        Map<Integer, Integer> map = new HashMap<>();
        for(String s : logs){
            String str [] = s.split(":");
            String id = str[0];
            String event = str[1];
            String time = str[2];
            Func f = new Func(id, event, time);
            if(!stack.isEmpty() && stack.peek().id.equals(id) && event.equals("end")){
                Func curr = stack.pop();
                int exec = Integer.valueOf(time) - Integer.valueOf(curr.time) -wait +1;
                wait +=exec;
                int i = Integer.valueOf(id);
                map.put(i, exec);
            }
            else stack.push(f);
        }
        int res[] = new int[map.size()];

        for(int i =0; i<map.size(); i++){
            res[i] = map.get(i);
        }

        return res;
    }


    public int[] exclusiveTimeSol(int n, List<String> logs) {
        Stack<Execution> stack = new Stack();
        int[] result = new int[n];
        for(String current : logs){
            Execution execution = getExecution(current);
            if(stack.isEmpty()) stack.push(execution);
            else {
                if(execution.operation.equals("start")){
                    Execution prevRef = stack.peek();
                    prevRef.total = prevRef.total + (execution.value - prevRef.value);
                    stack.push(execution);
                }else{
                    Execution prev = stack.pop();
                    int cal = prev.total + execution.value - prev.value + 1;
                    result[prev.id] = result[prev.id] + cal;

                    if(!stack.isEmpty()){
                        stack.peek().value = execution.value+1;
                    }
                }
            }
        }
        return result;
    }

    public Execution getExecution(String exec){
        String[] sa = exec.split(":");
        return new Execution(Integer.valueOf(sa[0]), 0, Integer.valueOf(sa[2]), sa[1]);
    }

    class Execution{
        int id;
        int total;
        int value;
        String operation;

        public Execution(int id, int total, int value, String operation){
            this.id = id;
            this.total = total;
            this.value = value;
            this.operation = operation;
        }
    }


}
