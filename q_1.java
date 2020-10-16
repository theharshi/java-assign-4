import java.util.Scanner;

class q_1 {
	
	public static int replant (String[] crops){

		int count = 0;
		
		//converting array of strings into char array
		char[][] cropsGrid = new char[crops.length][];

		for(int i=0; i<cropsGrid.length; i++) {

			cropsGrid[i] = new char[crops[i].length()];

			for(int j=0; j<crops[i].length(); j++) {
				cropsGrid[i][j] = crops[i].charAt(j);
			}
		}
		
		for(int i=0; i<cropsGrid.length; i++) {

			for(int j=0; j<cropsGrid[i].length; j++) {
				
				if(j >= 1 && i >= 1 ) {

					if(cropsGrid[i][j-1] == cropsGrid[i][j] || cropsGrid[i-1][j] == cropsGrid[i][j]) {
						count++;
						cropsGrid[i][j]='A';
					}
				}
				else if(j+1 < crops[i].length() && i+1 < cropsGrid.length) {

					if((cropsGrid[i][j] == cropsGrid[i+1][j]) && (cropsGrid[i][j] == cropsGrid[i][j+1])) {
						count++;
						cropsGrid[i][j]='A';
					}
				}
				else if(j >= 1) {

					if(cropsGrid[i][j-1] == cropsGrid[i][j]) {
						count++;
						cropsGrid[i][j]='A';
					}
				}
				else if(i >= 1 ) {

					if(cropsGrid[i-1][j] == cropsGrid[i][j]) {
						count++;
						cropsGrid[i][j]='A';
					}
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args){
		int n;
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		sc.nextLine();
		String[] crops = new String[n];

		for (int i=0; i<n; i++){
			crops[i] = sc.nextLine().trim();
		}
		System.out.println(replant(crops));
	}
}
