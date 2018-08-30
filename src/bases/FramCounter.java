package bases;

public class FramCounter {
    public int count;
    public int limit;
    public boolean expired;

    public FramCounter(int limit) {

        this.limit = limit;
        this.count = 0;
        this.expired = false;

    }

    public void run() {

        if (count >= limit) {

            expired = true;
        } else {
            count++;

        }

    }

    public void reset() {
        count = 0;
        expired = false;


    }
}
