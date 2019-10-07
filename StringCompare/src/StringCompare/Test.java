package StringCompare;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long n = 30000;  
        
		long startString = System.currentTimeMillis();     
        String simple1 = new String("hello");     
        for (long i = 0; i < n; i++)     
        {     
        	simple1=simple1+"拼接字符串的时间";     
        }     
        long endString = System.currentTimeMillis();     
        long timeString = endString -startString;     
        System.out.println("用String拼接"+n+"个字符串的时间为"+timeString+"\n");
        
        long startStringBuilder = System.currentTimeMillis();     
        StringBuilder simple2 = new StringBuilder("hello");     
        for (long i = 0; i < n; i++)     
        {     
            simple2.append("拼接字符串的时间");     
        }     
        long endStringBuilder = System.currentTimeMillis();     
        long timeStringBuilder = endStringBuilder -startStringBuilder;     
        System.out.println("用StringBuilder.append拼接"+n+"个字符串的时间为"+timeStringBuilder);
	}

}
