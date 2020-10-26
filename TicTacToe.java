import java.util.Scanner;

class Main {

    private char current_player;
    private char[][] board;

    public static void main(String[] args) {
        Main obj = new Main();
    }

    Main() {
        board = new char[3][3];

        Reset_Board();

        runner();
    }

    private void runner(){
        Switch_Player();
        do{
            Switch_Player();
            print_board();
            set_piece();
        }while(!Winner());
        play_again();        
    }


    private void play_again(){
        Scanner input = new Scanner(System.in);

        System.gc();

        System.out.println("Play Again(y/n)?");
        char ans = input.next().charAt(0);

        if(ans =='y'){
            Reset_Board();
            runner();
        }else{
            System.out.println("Thanks for Playing!");
        }

        input.close();
    }

    private void set_piece(){
        Scanner input =new Scanner(System.in);
        
        System.out.println("Enter the row");
        int i = input.nextInt();
        System.out.println("Enter the column");
        int j = input.nextInt();

        board[i][j] = current_player;

    }

    private void Reset_Board() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        System.out.println(board[2][1]);
        current_player = 'x';
    }

    private void Switch_Player() {
        if (current_player == 'x')
            current_player = 'o';
        else
            current_player = 'x';
    }

    private boolean Winner(){
        if(
            //checks diagnal from top left
            (current_player == board[0][0] && current_player == board[1][1]&&current_player == board[2][2])
            //checks diagnal from top right
            || (current_player == board[0][2] && current_player == board[1][1]&&current_player == board[0][2])
            //checks straight down from left
            || (current_player == board[0][0] && current_player == board[1][0]&&current_player == board[2][0])
            //checks straight down from middle
            || (current_player == board[0][1] && current_player == board[1][1]&&current_player == board[2][1])
            //checks straight down from right
            || (current_player == board[0][2] && current_player == board[1][2]&&current_player == board[2][2])
            //checks straight across from top
            ||(current_player == board[0][0] && current_player == board[0][1] && current_player == board[0][2]) 
            //checks straight across from middle
            || (current_player == board[1][0] && current_player == board[1][1]&&current_player == board[1][2])
            //checks straight across from bottom
            || (current_player == board[2][0] && current_player == board[2][1]&&current_player == board[2][2])){
                System.out.println(current_player+" Wins!");
                return true;
            }else{

            }
            return false;
            
    }

    private void print_board() {
        System.out.println("Current Player: " + current_player + "\n");
        System.out.println("  0 1 2");
        System.out.println("0 " + board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("  -----");
        System.out.println("1 " + board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("  -----");
        System.out.println("2 " + board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
    }
}
