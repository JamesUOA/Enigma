public class EnigmaModel {

    private String _word;
    private String _encrypted;
    private Encryption _currentEncyption;

    // Constructor for the Model
    public EnigmaModel(int rotor_1_Number,int rotor_2_Number,int rotor_3_Number, int reflectorNumber){
        _word = "";
        _encrypted = "";
        _currentEncyption = new Encryption(rotor_1_Number,rotor_2_Number,rotor_3_Number,reflectorNumber);
    }


    public char addLetter(char s){
        _word = _word + s;
        _encrypted = _encrypted + _currentEncyption.encryptLetter(s);
        char[] c = _encrypted.toCharArray();
        return c[c.length-1];
    }

    public String getCurrentWord(){
        return _word;
    }
    public String getCurrentEncryptedWord(){
        return _encrypted;
    }

    public void setRotorValue(int rotorNumber,int rotorValue){
        _currentEncyption.rotorValue(rotorNumber,rotorValue);
    }

    public void changeRotor(int rotorNumber,int newRotor){
        _currentEncyption.switchRotor(rotorNumber,newRotor);
    }

    public void resetWord(){
        _word = "";
        _encrypted = "";
    }

    public void setReflector(int newReflector){
        _currentEncyption.switchReflector(newReflector);
    }

    public int[] getRotorSetting(){
        return _currentEncyption.getRotorSettings();
    }


}
