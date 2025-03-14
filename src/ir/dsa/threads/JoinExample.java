package ir.dsa.threads;

import java.math.BigInteger;

public class JoinExample {

    public static void main(String arr[]){

    }


    private static class PowerCalculatingThread extends Thread {
        private BigInteger result = BigInteger.ONE;
        private BigInteger base;
        private BigInteger power;

        public PowerCalculatingThread(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
           /*
           Implement the calculation of result = base ^ power
           */
            for(BigInteger i = BigInteger.ZERO; i.compareTo(power) < 0; i = i.add(BigInteger.ONE)){
                result = result.multiply(base);
            }

        }

        public BigInteger getResult() { return result; }
    }
}
