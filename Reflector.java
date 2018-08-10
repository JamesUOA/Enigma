public class Reflector{

    private int[] _setting;
    private int[] _alphabet;

    private String _UKW_A = "EJMZALYXVBWFCRQUONTSPIKHGD";
    private String _UKW_B = "YRUHQSLDPXNGOKMIEBFZCWVJAT";
    private String _UKW_C = "FVPJIAOYEDRZXWGCTKUQSBNMHL";


    public Reflector(){
        _setting = null;
        _alphabet = null;
    }


    public Reflector(int num) {

        char[] alphabetRotor;
        _setting = new int[26];
        _alphabet = new int[26];

        if (num == 1) {
            alphabetRotor = _UKW_A.toCharArray();
        } else if (num == 2) {
            alphabetRotor = _UKW_B.toCharArray();
        } else if (num == 3) {
            alphabetRotor = _UKW_C.toCharArray();
        }else{
            alphabetRotor = new char[26];
        }

        //sets 1 as A, 2 as B... etc
        for (int i = 0; i < alphabetRotor.length; i++) {
            _alphabet[i] = i;
            _setting[i] = (int) alphabetRotor[i] - 65;

        }

    }

    //Gets the corresponding letter
    public int reflect(int letter){
        return _setting[letter];
    }


}
