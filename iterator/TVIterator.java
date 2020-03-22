package iterator;
public interface TVIterator {

    public void setChannel(int i);

    public Object currentChannel();

    public void next();

    public void previous();

    public boolean isLast();

    public boolean isFirst();

}
