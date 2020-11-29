import java.math.BigInteger;
import java.util.ArrayList;

class Scratch {
    public static void main(String[] args) {

        //RSA 110 numbers
        BigInteger p = new BigInteger("6122421090493547576937037317561418841225758554253106999");
        BigInteger q = new BigInteger("5846418214406154678836553182979162384198610505601062333");
        BigInteger N = p.multiply(q);
        System.out.println(N.toString() + "\n" + " lenght:" + N.toString().length() + "\n");

        BigInteger Phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        BigInteger e = new BigInteger("65537");
        BigInteger d = e.modInverse(Phi);

        System.out.println(d.multiply(e).mod(Phi));

        String msg = "Привет, как у тебя дела?";

        ArrayList<BigInteger> enMsg = encode(msg, N, e);
        String deMsg = decode(enMsg, N, d);

        System.out.println(deMsg);



    }
    public static ArrayList<BigInteger> encode (String msg, BigInteger N, BigInteger e){
        ArrayList<BigInteger> encMsg = new  ArrayList<BigInteger>();

        for (char i : msg.toCharArray()){
            encMsg.add(BigInteger.valueOf(i).modPow(e, N));
        }

        return encMsg;

    }



    public static String decode (ArrayList<BigInteger> msg, BigInteger N, BigInteger d){
        StringBuffer deMsg = new StringBuffer(" ");

        for (BigInteger i : msg){
            deMsg.append((char) i.modPow(d, N).intValue());
        }

        return deMsg.toString();

    }
}