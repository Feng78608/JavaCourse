package iterator;
public class TCLIterator implements TVIterator {
    private int currentIndex= 0 ;
    private TCLTelevision tv=new TCLTelevision();

    public void setChannel(int i){
    	currentIndex=i;
    }

    public Object currentChannel(){
        return tv.getObj()[currentIndex];
    }

    public void next(){
    	if(currentIndex<tv.getObj().length)
    		currentIndex++;
    }

    public void previous(){
    	if(currentIndex>0)
    		currentIndex--;
    }

    public boolean isLast(){
        return currentIndex==tv.getObj().length;
    }

    public boolean isFirst(){
        return currentIndex==0;
    }

}
