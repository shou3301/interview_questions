/*
给一个 string,返回含有 word 的 list。word 的定义是空格(大于等于一个)之间的或者引号 之间的,
如果引号里面有空格要做为一个 word 返回。比如 string 是 I have a “faux coat” 要返回[I, have, a, faux coat]
*/

// This problem can be extended to mutiple separators.
public class Tokenizer {

	public static void main(String[] args) {
		System.out.println(stringTokenizer(""));
		System.out.println(stringTokenizer("I"));
		System.out.println(stringTokenizer("Hello"));
		System.out.println(stringTokenizer("I say Hello"));
		System.out.println(stringTokenizer("I say \"hello\" you say \"hi\""));
		System.out.println(stringTokenizer("I      say   \"\"\"\"\"\"\"hello\" you\"\"\"\" say      \"hi\""));
	}
	
	public static List<String> stringTokenizer(String str) {
	    List<String> res = new ArrayList<>();
	    
	    if (str.length() == 0) return res;
	    
	    int i = 0;
	    while (i < str.length()) {
	        // find the beginning of next word
	        while (i < str.length() && (str.charAt(i) == ' ' || str.charAt(i) == '\"')) {
	            i++;
	        }
	        int j = i;
	        
	        while (i < str.length() && (str.charAt(i) != ' ' && str.charAt(i) != '\"')) {
	            i++;
	        }
	        
	        if (j < i)
	        	res.add(str.substring(j, i));
	    }
	    
	    return res;
	}

}