import java.util.Scanner;
public class versos_bucocilos{ 
   public static void main(String args[]){ 
   Scanner _scTrx = new Scanner(System.in);
    double a;
    double b;
    boolean c;
    boolean d;
    String x;
    String y;
System.out.print("Hello World");
System.out.println("Fim do programa");
a = 3.1415;
b = _scTrx.nextFloat();
c = true;
d = false;
System.out.print(a);
if (a>5) {System.out.print("maior que 5");
}else {System.out.print("menor que 5");
}System.out.print("oi agora vamos testar outro");
if (c || d) {System.out.print("c or d");
}else {System.out.print("not c or d");
}while (b>=0) {System.out.print("b es positivo");
b = b-1;
}while (a>0) {System.out.print("dentro do doWhile");
a = a-1;
}   }
}
