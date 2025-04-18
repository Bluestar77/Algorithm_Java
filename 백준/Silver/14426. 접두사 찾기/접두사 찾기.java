import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static class TrieNode{
		TrieNode children[];
		boolean isNumber;
		
		public TrieNode() {
			this.children = new TrieNode[26];
			this.isNumber = false;
		}
	}
	
	static TrieNode root = new TrieNode();
	
	static int result = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			Insert(str);
		}
		
		for(int i=0;i<M;i++) {
			String str = br.readLine();
			if(find(str)==true) result++;
		}
		
		System.out.println(result);
		
	}

	private static boolean find(String str) {
		TrieNode cur = root;
		
		for(int i=0;i<str.length();i++) {
			int idx = str.charAt(i)-'a';
			if(cur.children[idx] == null) return false;
			
			cur = cur.children[idx];
		}
		return true;
	}

	private static void Insert(String str) {
		TrieNode cur = root;
		
		for(int i=0;i<str.length();i++) {
			int idx = str.charAt(i) - 'a';
			
			if(cur.children[idx] == null) {
				cur.children[idx] = new TrieNode();
			}
			
			cur = cur.children[idx];
		}
		cur.isNumber = true;
	}

}
