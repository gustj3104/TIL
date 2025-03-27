package Lab01;
import java.io.*;
import java.util.Objects;

class Calc {
    int token; int value; int ch;
    private PushbackInputStream input;
    final int NUMBER=256;

    Calc(PushbackInputStream is) {
        input = is;
    }

    int getToken( )  { /* tokens are characters */
        while(true) {
            try  {
	            ch = input.read();
                if (ch == ' ' || ch == '\t' || ch == '\r') ;
                else 
                    if (Character.isDigit(ch)) {
                        value = number( );
	               input.unread(ch);
		     return NUMBER;
	          }
	          else return ch;
	  } catch (IOException e) {
                System.err.println(e);
            }
        }
    }

    private int number( )  {
    /* number -> digit { digit } */
        int result = ch - '0';
        try  {
            ch = input.read();
            while (Character.isDigit(ch)) {
                result = 10 * result + ch -'0';
                ch = input.read(); 
            }
        } catch (IOException e) {
            System.err.println(e);
        }
        return result;
    }

    void error( ) {
        System.out.printf("parse error : %d\n", ch);
        //System.exit(1);
    }

    void match(int c) { 
        if (token == c) 
	    token = getToken();
        else error();
    }

    void command( ) {
    /* command -> expr '\n' */
        Object result = expr();
        if (token == '\n') /* end the parse and print the result */
	    System.out.println("The result is: " + result);
        else error();
    }

    Object expr() {
        Object result = bexp();
        if (token == '!') {
            match('!');
            result = !(boolean) expr();
        } else if (token == 't') {
            match('t');
            result = true;
        } else if (token == 'f') {
            match('f');
            result = false;
        } else {
            while (token == '&' || token == '|') {
                if (token == '&') {
                    match('&');
                    result = (boolean) result & (boolean) bexp();
                } else if (token == '|') {
                    match('|');
                    result = (boolean) result | (boolean) bexp();
                }
            }
        }

        return result;
	}

    Object bexp( ) {
        Object result = null;
        int first = aexp();
        String r = relop();
        if (r != null) {
            int second = aexp();
            switch (r) {
                case "==":
                    result = (first == second);
                    break;
                case "!=":
                    result = (first != second);
                    break;
                case "<":
                    result = (first < second);
                    break;
                case ">":
                    result = (first > second);
                    break;
                case "<=":
                    result = (first <= second);
                    break;
                case ">=":
                    result = (first >= second);
                    break;
            }
        } else {
            result = first;
        }

        return result;
	}

    String relop() {
        String result = null;
        if (token == '=') {
            match('=');
            if (token == '=') {
                match('=');
                result = "==";
            }
        } else if (token == '!') {
            match('!');
            if (token == '=') {
                match('=');
                result = "!=";
            } else {
                error();
            }
        } else if (token == '<') {
            match('<');
            if (token == '=') {
                match('=');
                result = "<=";
            } else {
                result = "<";
            }
        } else if (token == '>') {
            match('>');
            if (token == '=') {
                match('=');
                result = ">=";
            } else {
                result = ">";
            }
        }

        if (result == null && (token == '=' || token == '!' || token == '<' || token == '>')) {
            match(token); // token을 소비하여 무한 루프 방지
        }

        return result;
    }



    int aexp( ) {
    /* expr -> term { '+' term } */
        int result = term();
        while (token == '+' || token == '-') {
            if (token == '+') {
                match('+');
                result += term();
            } else {
                match('-');
                result -= term();
            }
        }

        return result;
    }

    int term( ) {
    /* term -> factor { '*' factor } */
       int result = factor();
       while (token == '*' || token == '/') {
           if (token == '*') {
               match('*');
               result *= factor();
           } else {
               match('/');
               result /= factor();
           }
       }
       return result;
    }

    int factor() {
    /* factor -> '(' expr ')' | number */
        int result = 0;
        if (token == '-') {
            match('-');
            result = -factor();
        }
        if (token == '(') {
            match('(');
            result = aexp();
            match(')');
        }
        else if (token == NUMBER) {
            result = value;
	        match(NUMBER); //token = getToken();
        }
        return result;
    }

    void parse( ) {
        token = getToken(); // get the first token
        command();          // call the parsing command
    }

    public static void main(String args[]) { 
        Calc calc = new Calc(new PushbackInputStream(System.in));
        while(true) {
            System.out.print(">> ");
            calc.parse();
        }
    }
}