
public class Mips {
    public static void main(String[] args) {
	Number n = new Number(args[0]);
	try {
	    int erExist = 0;
	    if (n.len != 8) {
		throw new InvalidNumberException();
	    }
	    for (int i = 0; i < 8; i++) {
		if (n.hex.charAt(i) <48) {
		    erExist = 1;
		}
		if (n.hex.charAt(i) > 57) {
		    if (n.hex.charAt(i) <64) {
			erExist = 1;
		    }
		}
		if (n.hex.charAt(i) > 70) {
		    if (n.hex.charAt(i)< 97) {
			erExist = 1;
		    }
		}
		if (n.hex.charAt(i)> 102) {
		    erExist = 1;
		}
	    }
	    if (erExist == 1) {
		throw new InvalidNumberException();
	    }
	if (n.typo() == 0) {
	    System.out.println("This MIPS is R-type");
	    System.out.print("opcode: ");
	    System.out.println(n.opcode);
	    System.out.print("rs: ");
	    System.out.println(n.rs);
	    System.out.print("rt: ");
	    System.out.println(n.rt);
	    System.out.print("rd: ");
	    System.out.println(n.rd);
	    System.out.print("shamt: ");
	    System.out.println(n.shamt);
	    System.out.print("funct: ");
	    System.out.println(n.funct);
	}
	else if (n.typo()==1) {
	    System.out.println("This MIPS is I-type");
	    System.out.print("opcode: ");
	    System.out.println(n.opcode);
	    System.out.print("rs: ");
	    System.out.println(n.rs);
	    System.out.print("rt: ");
	    System.out.println(n.rt);
	    System.out.print("address: ");
	    System.out.println(n.address);
	}
	}catch (InvalidNumberException e) {
	    System.out.println(e.getMessage());
	}
    }
}

