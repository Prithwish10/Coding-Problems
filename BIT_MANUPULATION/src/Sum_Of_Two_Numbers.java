
public class Sum_Of_Two_Numbers {

	public int getSum(int a, int b) {
        
        int raw_carry = 0;
        do{
            raw_carry = a & b;

            int xor = a ^ b;

            a = xor;
            b = raw_carry << 1;
        }while(raw_carry != 0);
        
        return a;
    }
}
