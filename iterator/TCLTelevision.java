package iterator;
public class TCLTelevision implements Television {
    private Object[] obj= {"CCTV-1","CCTV-2","CCTV-3",
    		"CCTV-4","CCTV-5","CCTV-6"};


    public TVIterator createIterator(){
        return new TCLIterator();
    }


	public Object[] getObj() {
		return obj;
	}

}
