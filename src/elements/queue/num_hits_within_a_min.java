public class HitCounter {
	
	/**
	 * If hit() will at most be called once within a second,
	 * then the queue size won't be greater than the elapsedTime (in seconds).
	 * 
	 * If we are not allowed to use a Deque. It's not hard to use an array to
	 * build a deque (with fixed size).
	 */
	private final Deque<Long> record;
	
	private final long elapsedTime;
	
	public HitCounter(long elapsedTime) {
		// assume this input is valid (> 0)
		this.elapsedTime = elapsedTime;
		record = new LinkedList<>();
	}
	
	public void hit() {
		long currTime = System.currentTimeMillis();
		record.addLast(currTime);
		expireEarlyHits(currTime);
	}
	
	public int getHitCount() {
		long currTime = System.currentTimeMillis();
		expireEarlyHits(currTime);
		return record.size();
	}
	
	private void expireEarlyHits(long currTime) {
		while (!record.isEmpty() && record.peekFirst() < currTime - elapsedTime) {
			record.removeFirst();
		}
	}
	
}