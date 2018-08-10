public class PlugBoard {

    private int[][] _connections;
    private static PlugBoard _board = null;
    private int currentIndex;

    private PlugBoard(){
        _connections = new int[2][13];
        currentIndex = 0;
    }

    //Uses singleton design pattern to ensure that only one plugboard is created
    public static PlugBoard getBoard(){
        if(_board==null){
            _board = new PlugBoard();
        }
        return _board;
    }


    //returns true if its already in
    public boolean checkExist(int letter){

        for (int i = 0; i < _connections.length; i++) {
            for (int j = 0; j < currentIndex; j++) {
                if (_connections[i][j] == letter) {
                    return true;
                }
            }
        }
        return false;
    }

    public void connectTwo(int firstLetter,int secondLetter) {
        if((firstLetter<=26 || secondLetter<=26)&&firstLetter!=secondLetter) {

            if (!checkExist(firstLetter) && !checkExist(secondLetter)) {
                _connections[0][currentIndex] = firstLetter;
                _connections[1][currentIndex] = secondLetter;
                currentIndex++;
            }else {
                System.out.println("ALREADY CONNECTED");
            }
        }


    }

    public int convert(int c){
        int letter = c;
        if(checkExist(c)){

            for (int i=0;i<currentIndex;i++){
                if(_connections[0][i]==c){
                    letter = _connections[1][i];
                }
            }

            if (letter==c) {
                for (int i = 0; i < currentIndex; i++) {
                    if (_connections[1][i] == c) {
                        letter = _connections[0][i];
                    }
                }
            }

        }
        return letter;
    }

}
