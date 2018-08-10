public class Rotor{


    private int[] _setting;
    private int[] _alphabet;
    private int startingChar;
    //Default settings from 1939
    private String _I_K = "EKMFLGDQVZNTOWYHXUSPAIBRCJ";
    private String _II_K = "AJDKSIRUXBLHWTMCQGZNPYFVOE";
    private String _III_K = "BDFHJLCPRTXVZNYEIWGAKMUSQO";
    private String _IV_K = "ESOVPZJAYQUIRHXLNFTGKDCMWB";
    private String _V_K = "VZBRGITYUPSDNHLXAWMJQOFECK";


    //Constructors
    public Rotor(){
        _setting = null;
        _alphabet = null;
    }

    public Rotor(int num) {

        char[] alphabetRotor;
        _setting = new int[26];
        _alphabet = new int[26];

        if (num == 1) {
            alphabetRotor = _I_K.toCharArray();
        } else if (num == 2) {
            alphabetRotor = _II_K.toCharArray();
        } else if (num == 3) {
            alphabetRotor = _III_K.toCharArray();
        } else if(num ==4) {
            alphabetRotor = _IV_K.toCharArray();
        } else if(num==5) {
            alphabetRotor = _V_K.toCharArray();
        } else{
            alphabetRotor = new char[26];
        }
        //sets 1 as A, 2 as B... etc
        for (int i = 0; i < alphabetRotor.length; i++) {
            _alphabet[i] = i;
            _setting[i] = (int) alphabetRotor[i] - 65;

            startingChar = _alphabet[0];
        }
    }

    //Methods

    public boolean checkFullRotate (){

        if(_alphabet[0]==startingChar){
            return true;
        }
        return false;
    }

    public void rotate(){
        int firstLetter = _alphabet[0];
        for(int i = 0;i<_alphabet.length-1;i++){
            _alphabet[i] = _alphabet[i+1];
        }
        _alphabet[_alphabet.length-1] = firstLetter;

    }

    public void set(int setNum){
        if(setNum<=26){
            while(_alphabet[0]!= setNum) {
                rotate();
            }
        }else{
            System.out.println("INVALID NUMBER");
        }
    }

    public void reset(){
        this.set(0);
    }

    //The covers the first set of encryptions before the reflector

    public int firstEncrypt(int letter){
        int index = -1;
        for(int i = 0;i<_alphabet.length;i++){
            if (_alphabet[i]==letter){
                index = i;
                break;
            }
        }
        return _setting[index];
    }

    //The covers the second set of encryptions after the reflector
    public int secondEncrypt(int letter){
        int index = -1;
        for(int i = 0;i<_setting.length;i++){
            if (_setting[i]==letter){
                index = i;
                break;
            }
        }
        return _alphabet[index];
    }

    public int getSetting(){
        return _alphabet[0]+1;
    }


}
