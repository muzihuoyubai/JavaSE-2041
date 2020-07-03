package club.banyuan;

public class TimerImpl implements Timer {

  long start;
  long stop;
  boolean isStart;

  @Override
  public void start() throws IllegalStateException {
    if (isStart) {
      throw new IllegalStateException("starting");
    }
    start = System.currentTimeMillis();
    isStart = true;
  }

  @Override
  public void stop() throws IllegalStateException {
    if (!isStart) {
      throw new IllegalStateException("not start");
    }
    stop = System.currentTimeMillis();
    isStart = false;
  }

  @Override
  public void reset() {
    start = 0L;
    stop = 0L;
  }

  @Override
  public long getTimeMillisecond() {
    return stop - start;
  }
}
