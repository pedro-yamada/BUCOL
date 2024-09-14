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
System.out.println("Hello World");
System.out.println("Fim do programa");
a = 3.1415;
b = _scTrx.nextInt();
c = true;
d = false;
System.out.println(a);
if (a>5) {System.out.println("maior que 5");
}else {System.out.println("menor que 5");
}System.out.println("oi agora vamos testar outro");
if (c || d) {System.out.println("c or d");
}else {System.out.println("not c or d");
}while (b>=0) {System.out.println("b es positivo");
b = b-1;
}while (a>0) {System.out.println("dentro do doWhile");
a = a-1;
}   }
}
