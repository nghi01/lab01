
public class Number {
    //Get the hex value of the number
    String bin;
    String hex;
    String opcode;
    int rs;
    int rt;
    int rd;
    int shamt;
    int funct;
    String address;
    int len;
    public Number(String hexVal) {
	this.len = hexVal.length();
	this.hex = hexVal;
	this.bin = hextobin(hexVal);
	this.opcode = this.bin.substring(0,6);
	this.rs = bintodec(this.bin.substring(6,11));
	this.rt = bintodec(this.bin.substring(11,16));
	if (this.typo() == 0) {
	    this.rd = bintodec(this.bin.substring(16,21));
	    this.shamt = bintodec(this.bin.substring(21,26));
	    this.funct = bintodec(this.bin.substring(26,32));
	}
	else if (this.typo() == 1) {
	    this.address = this.hex.substring(4,8);
	}
	return;
    }
//hex to bin
    public String hextobin(String Val) {
	//length of value
	int len = Val.length();
	int dec_val = 0;
	String s1;
	String s2;
	String s3;
	String s4;
	String s = "";
	//Loop through the whole thing
	for (int i = 0; i <len; i++) {
	    //Deal with characters
	    if (Val.charAt(i)>='0' && Val.charAt(i)<= '9') {
		dec_val = (Val.charAt(i)-48);
	    }
	    else if (Val.charAt(i) >= 'A' && Val.charAt(i)<= 'F') {
		dec_val = (Val.charAt(i)-55);
	    }
	    else if (Val.charAt(i) >= 'a' && Val.charAt(i)<= 'f') {
		dec_val = (Val.charAt(i)-87);
	    }
	    // >8 => 1
	    if ((dec_val / 8) == 0) {
		s1 ="0";
	    }
	    else {
		s1 ="1";
	    }
	    // 4,5,6,7,12,13,14,15
	    if (((dec_val/4)%2)==1) {
		s2 = "1";
	    }
	    else {
		s2 = "0";
	    }
	    //2,3,6,7,10,11,14,15
	    if (((dec_val/2)%2)==1) {
		s3 = "1";
	    }
	    else {
		s3 = "0";
	    }
	    //just odd
	    if ((dec_val%2)==1){
		s4 = "1";
	    }
	    else {
		s4 = "0";
	    }
	    //concatenate
	    s += s1 + s2 + s3 + s4;
	}
	return s;
    }
//hex to dec
    public int hextodec(String Val)
    {	//length of the value
        int len = Val.length();
 
        // Initializing base value to 1
        int base = 1;
        //initializing decimal value = 0
        int dec_val = 0;
 
        // Extracting characters as digits 
        for (int i = len - 1; i >= 0; i--) {
            // if character lies in '0'-'9', converting it to 0- 9 respectively with -48.
            if (Val.charAt(i) >= '0' && Val.charAt(i) <= '9') {
                dec_val += (Val.charAt(i) - 48) * base;
 
                // incrementing base by power
                base = base * 16;
            }
 
            // if character lies in 'A'-'F' , converting it to 10-15 by -55 (because A = 65 , 65 - 55 = 10)
            else if (Val.charAt(i) >= 'A' && Val.charAt(i) <= 'F') {
                dec_val += (Val.charAt(i) - 55) * base;
 
                // incrementing base by power
                base = base * 16;
            }
            else if (Val.charAt(i) >= 'a' && Val.charAt(i) <= 'f') {
                dec_val += (Val.charAt(i) - 87) * base;
 
                // incrementing base by power
                base = base * 16;
            }
        }
        return dec_val;
    }
    //bintodec
    public int bintodec(String Val) {
	int len = Val.length();
	//base value = 1
	int base = 0;
	// initializing decimal value = 0
	int dec_val = 0;
	// Extracting characters as digits
	for (int i = len - 1; i >= 0; i --) {
	    dec_val += (Val.charAt(i)-48) * (int)(Math.pow(2,base));
	    base += 1;
	}
	return dec_val;
    }
    //* Find out if this is R-type or I-type
    public int typo() {
	//rtype
	if (bintodec(this.opcode) == 0) {
	    return 0;
	}
	//itype
	else {
	    return 1;
	}
    }
   }
