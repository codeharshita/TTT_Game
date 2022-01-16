import java.util.HashSet;
import java.util.Scanner;
import java.io.*;



@SuppressWarnings("unused")
public class Game {
	static HashSet<Integer> ur_set = new HashSet<Integer>();
	static HashSet<Integer> cpu_set = new HashSet<Integer>();

	public static void main(String[] args) {
		
		char[][]g_board= {
			
				{' ','|',' ','|',' '},
				{'-','|','-','|','-'},
				{' ','|',' ','|',' '},
				{'-','|','-','|','-'},
				{' ','|',' ','|',' '}
				
		};
			print_board(g_board);
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				System.out.print("Enter the numbers from 1-9");
				int user_position=sc.nextInt();
				while(ur_set.contains(user_position)||cpu_set.contains(user_position)) 
				{
					System.out.println();
					System.out.print("Retry, ENTER the value again");
					user_position=sc.nextInt();
				}
				place_holder(g_board,user_position, "YOU");
				
				String res = check_winner();
				if(res.length()>0) {
					System.out.println(res);
					break;
				}
				
				
				
				
				
				
				
				
				
			///////////////////////////////////////////	
				
				int cpu_position = gen_random();
				while(ur_set.contains(cpu_position)||cpu_set.contains(cpu_position)) 
				{
					
					cpu_position=gen_random();
				}
				place_holder(g_board,cpu_position, "CPU");
		
				 res = check_winner();
				if(res.length()>0) {
					System.out.println(res);
					break;
				}
		}
	}
	
	@SuppressWarnings("rawtypes")
	static String check_winner() 
	{
		HashSet<Integer>r1= new HashSet<Integer>();
		r1.add(1);r1.add(2);r1.add(3);
		HashSet<Integer>r2= new HashSet<Integer>();
		r2.add(4);r2.add(5);r2.add(6);
		HashSet<Integer>r3= new HashSet<Integer>();
		r3.add(7);r3.add(8);r3.add(9);
		HashSet<Integer>c1= new HashSet<Integer>();
		c1.add(1);c1.add(4);c1.add(7);
		HashSet<Integer>c2= new HashSet<Integer>();
		c2.add(2);c2.add(5);c2.add(8);
		HashSet<Integer>c3= new HashSet<Integer>();
		c3.add(3);c3.add(6);c3.add(9);
		HashSet<Integer>d1= new HashSet<Integer>();
		d1.add(1);d1.add(5);d1.add(9);
		HashSet<Integer>d2= new HashSet<Integer>();
		r1.add(3);r1.add(5);r1.add(7);
		
		HashSet<HashSet> set = new HashSet<HashSet>();
		set.add(r1);set.add(r2);set.add(r3);
		set.add(c1);set.add(c2);set.add(c3);
		set.add(d1);set.add(d2);
		
		
		for(HashSet c : set)
		{
			if(ur_set.containsAll(c)) 
				return "You Won!";
		   else if(cpu_set.containsAll(c)) 
			   return "You Lost!";
	   }
		if(ur_set.size()+cpu_set.size()==9) 
			return "Draw";
			 
		 return "";
			
		
		
	}
	
	 
	
	 static int gen_random() {
		int max=9;
		int min =1;
		
		int range = max-min+1;
		int res= (int) Math.random()*range + min;//Math.random return the value in double so we typecasted it to integer.
		return res;
	}



	static void print_board(char[][]g_board ) {
		for(int i =0;i<g_board.length;i++) {
			for (int j =0; j<g_board[0].length;j++) {
				System.out.print(g_board[i][j]);
			}
			System.out.println();
		}
	}
	
	static void place_holder(char[][]g_board, int pos, String user)
	{
                 char symb='X';
                 if(user.equals("You")) {
                	 symb='X';
                	 ur_set.add(pos);
                 }else if(user.equals("CPU")) {
                	 symb='0';
                	 cpu_set.add(pos);
                 }
                 switch(pos) 
                 {
                 case 1	:
                 g_board[0][0]= symb;
                 break;
                 case 2	:
                     g_board[0][2]= symb;
                     break;
                 case 3	:
                     g_board[0][4]= symb;
                     break;
                 case 4	:
                     g_board[2][0]= symb;
                     break;
                 case 5	:
                     g_board[2][2]= symb;
                     break;
                 case 6	:
                     g_board[2][4]= symb;
                     break;
                 case 7	:
                     g_board[4][0]= symb;
                     break;
                 case 8	:
                     g_board[4][2]= symb;
                     break;
                 case 9	:
                     g_board[4][4]= symb;
                     break;
                     
                     default:
                    	 System.out.println("Invalid input");
                     
                 }
                 
                 print_board(g_board);
                	 
                		 
	}
	
}
