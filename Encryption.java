public class Encryption {

    private Rotor _r1;
    private Rotor _r2;
    private Rotor _r3;

    private Reflector _ref;
    private PlugBoard _board;


    public Encryption(int rotor_1_Number,int rotor_2_Number,int rotor_3_Number, int reflectorNumber){
        _r1 = new Rotor(rotor_1_Number);
        _r2 = new Rotor(rotor_2_Number);
        _r3 = new Rotor(rotor_3_Number);

        _ref = new Reflector(reflectorNumber);
        _board = PlugBoard.getBoard();
    }


    public char encryptLetter(char c){

        int integerForm = (int) c - 65;
        int result_1 = _board.convert(integerForm);
        //First round of encryption
        int encrypt_1 = _r1.firstEncrypt(result_1);
        int encrypt_2 = _r2.firstEncrypt(encrypt_1);
        int encrypt_3 = _r3.firstEncrypt(encrypt_2);

        //reflects the value
        int reflected = _ref.reflect(encrypt_3);

        //second round of encryption(reverse
        encrypt_3 = _r3.secondEncrypt(reflected);
        encrypt_2 = _r2.secondEncrypt(encrypt_3);
        encrypt_1 = _r1.secondEncrypt(encrypt_2);

        int result_2 = _board.convert(encrypt_1) + 65;

        this.rotateRotors();
        return (char)result_2;
    }

    private void rotateRotors(){
        _r1.rotate();
        if(_r1.checkFullRotate()){
            _r2.rotate();
            if(_r2.checkFullRotate()){
                _r3.rotate();
            }
        }
    }

    public void switchRotor(int rotorNumber,int newRotor){
        _r1.reset();
        _r2.reset();
        _r3.reset();

        if(rotorNumber==1){
            _r1 = new Rotor(newRotor);
        }else if(rotorNumber==2){
            _r2 = new Rotor(newRotor);
        }else if(rotorNumber==3){
            _r3 = new Rotor(newRotor);
        }
    }

    public void rotorValue(int rotorNumber,int newValue){
        if(rotorNumber==1){
            _r1.set(newValue);
        }else if(rotorNumber==2){
            _r2.set(newValue);
        }else if (rotorNumber==3){
            _r3.set(newValue);
        }
    }

    public int[] getRotorSettings(){
        int[] setting ={_r1.getSetting(), _r2.getSetting(),_r3.getSetting()};
        return setting;
    }

    public void switchReflector(int newReflector){
        _ref = new Reflector(newReflector);
    }





}