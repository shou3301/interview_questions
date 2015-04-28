public class JobSchedule {

	public static void main(String[] args) {
		System.out.println(timeCost("aaaaabbbbcccdde", 4));
		System.out.println(scheduleJobs("aaaaabbbbcccdde", 4));
	}
	
	/*
	Job scheduling. The same type of job can not be done within the given n unit of time. 
	Given a string like "abcacb", each character represents a type of job. And give n = 4, then the job schedule should be like:
	abc__a_cb

	This is because after 'a', another 'a' job can not be scheduled again within 4 time unit. So in total, such a job sequence needs
	9 time units to finish.

	Given such a string and such a n, return how many time unit it needs to finish all the jobs.
	*/
	public static int timeCost(String jobs, int n) {
	    if (n == 0) return jobs.length();
	    
	    int count = 0;
	    Map<Character, Integer> last = new HashMap<>();
	    for (int i = 0; i < jobs.length(); ) {
	        if (!last.containsKey(jobs.charAt(i)) || last.get(jobs.charAt(i)) < count - n) {
	            last.put(jobs.charAt(i), count);
	            i++;
	        }
	        count++;
	    }
	    
	    return count;
	}
	
	/*
	A follow up question:
	If the given string can be re-ordered, how will you schedule the jobs so that you can minimize the number of time unit needed
	to finish all jobs.
	*/
	public static int scheduleJobs(String jobs, int n) {
	    if (jobs.length() <= 1 || n == 0) return jobs.length();
	    Map<Character, Integer> map = new HashMap<>();
	    for (int i = 0; i < jobs.length(); i++) {
	        if (!map.containsKey(jobs.charAt(i))) {
	            map.put(jobs.charAt(i), 1);
	        } else {
	            map.put(jobs.charAt(i), map.get(jobs.charAt(i)) + 1);
	        }
	    }
	    
	    List<Entry<Character, Integer>> entries = new ArrayList<>(map.entrySet());
	    Collections.sort(entries, new Comparator<Entry<Character, Integer>>() {
	        @Override
	       public int compare(Entry<Character, Integer> e1, Entry<Character, Integer> e2) {
	           return e2.getValue() - e1.getValue();
	       } 
	    });
	    
	    StringBuilder sb = new StringBuilder();
	    while (entries.get(0).getValue() > 0) {
	        for (int i = 0; i < entries.size(); i++) {
	            if (entries.get(i).getValue() > 0) {
	                sb.append(entries.get(i).getKey());
	                entries.get(i).setValue(entries.get(i).getValue() - 1);
	            }
	        }
	    }
	    
	    System.out.println(sb.toString());
	    
	    return timeCost(sb.toString(), n);
	}
	
}
