package Lab02_03;// Parser.java
// Parser for language S

import java.util.*;

public class Parser {
    public Token token;          // current token
    public Lexer lexer;
    String funId = "";
    public static Map<String, Type> symbolTable = new HashMap<>();

    public Parser(Lexer scan) {
        lexer = scan;
        token = lexer.getToken(); // get the first token
    }

    private String match(Token t) {
        String value = token.value();
        if (token == t)
            token = lexer.getToken();
        else
            error(t);
        return value;
    }

    private void error(Token tok) {
        System.err.println("Syntax error: " + tok + " --> " + token);
        token = lexer.getToken();
    }

    private void error(String tok) {
        System.err.println("Syntax error: " + tok + " --> " + token);
        token = lexer.getToken();
    }

    public Command command() {
        // <command> ->  <decl> | <function> | <stmt>
        if (isType()) {
            Decl d = decl();
            return d;
        }

	    if (token == Token.FUN) {
	        Function f = function();
	        return f;
	    }

        if (token != Token.EOF) {
            Stmt s = stmt();
            return s;
        }
        return null;
    }

    private Decl decl() {
        // <decl>  -> <type> id [=<expr>]; | <type> id[n];
        Type t = type();
        String id = match(Token.ID);
        Decl d = null;

        if (token == Token.LBRACKET) {
            match(Token.LBRACKET);
            if (token == Token.NUMBER) {
                int n = Integer.parseInt(token.value());
                match(Token.NUMBER);
                match(Token.RBRACKET);
                d = new Decl(id, Type.ARRAY, n);
            } else {
                Expr e = expr();
                match(Token.RBRACKET);
                d = new Decl(id, Type.ARRAY, e);
            }
        } else if (token == Token.ASSIGN) {
            match(Token.ASSIGN);
            Expr e = expr();
            d = new Decl(id, t, e);
        } else
            d = new Decl(id, t);

        match(Token.SEMICOLON);
        symbolTable.put(id, d.type);
        return d;
    }

    private Decls decls() {
        // <decls> -> {<decl>}
        Decls ds = new Decls();
        while (isType()) {
            Decl d = decl();
            ds.add(d);
        }
        return ds;
    }


    private Function function() {
    // <function>  -> fun <type> id(<params>) <stmt> 
        match(Token.FUN);
	    Type t = type();
	    String str = match(Token.ID);
	    funId = str; 
	    Function f = new Function(str, t);
	    match(Token.LPAREN);
        if (token != Token.RPAREN)
            f.params = params();
	    match(Token.RPAREN);
	    Stmt s = stmt();		
	    f.stmt = s;
	    return f;
    }

    private Decls params() {
	    Decls params = new Decls();
        
		// parse declarations of parameters
        Type t = type();
        String id = match(Token.ID);
        params.add(new Decl(id, t));
        while (token == Token.COMMA) {
            match(Token.COMMA);
            Type t2 = type();
            String id2 = match(Token.ID);
            params.add(new Decl(id2, t2));
        }

        return params;
    }



    private Type type() {
        // <type>  ->  int | bool | void | string
        Type t = null;
        switch (token) {
            case INT:
                t = Type.INT;
                break;
            case BOOL:
                t = Type.BOOL;
                break;
            case VOID:
                t = Type.VOID;
                break;
            case STRING:
                t = Type.STRING;
                break;
            default:
                error("int | bool | void | string");
        }
        match(token);
        return t;
    }

    private Stmt stmt() {
        // <stmt> -> <block> | <assignment> | <ifStmt> | <whileStmt> | ...
        Stmt s = new Empty();
        switch (token) {
            case SEMICOLON:
                match(token.SEMICOLON);
                return s;
            case LBRACE:
                match(Token.LBRACE);
                s = stmts();
                match(Token.RBRACE);
                return s;
            case IF:    // if statement
                s = ifStmt();
                return s;
            case WHILE:      // while statement
                s = whileStmt();
                return s;
            case ID:    // assignment
                s = assignment();
                return s;
            case LET:    // let statement
                s = letStmt();
                return s;
            case READ:    // read statement
                s = readStmt();
                return s;
            case PRINT:    // print statment
                s = printStmt();
                return s;
            case RETURN: // return statement
                s = returnStmt();
                return s;
            case FOR:
                s = forstmt();
                return s;
            case DO:
                s = dowhileStmt();
                return s;
            default:
                error("Illegal stmt");
                return null;
        }
    }

    private Stmts stmts() {
        Stmts ss = new Stmts();
        while (true) {
            if (token == Token.END || token == Token.RBRACE || token == Token.EOF) break;
            Stmt s = stmt();
            if (s != null)
                ss.stmts.add(s);
            else
                break;
        }
        return ss;
    }

    private Let letStmt() {
        // <letStmt> -> let <decls> in <block> end
        match(Token.LET);
        Decls ds = decls();
        match(Token.IN);
        Stmts ss = stmts();
        match(Token.END);
        match(Token.SEMICOLON);
        return new Let(ds, null, ss);
    }

    private Read readStmt() {
        // <readStmt> -> read id;
        //
        // parse read statement
        match(Token.READ);
        Identifier id = new Identifier(match(Token.ID));
        match(Token.SEMICOLON);
        return new Read(id);

    }

    private Print printStmt() {
        // <printStmt> -> print <expr>;
        //
        // parse print statement
        match(Token.PRINT);
        Expr e = expr();
        match(Token.SEMICOLON);
        return new Print(e);
    }

    private Return returnStmt() {
        // <returnStmt> -> return <expr>;
        match(Token.RETURN);
        Expr e = expr();
        match(Token.SEMICOLON);
        return new Return(funId, e);
    }

    private Stmt assignment() {
        // <assignment> -> id = <expr>; | id[<expr>] = <expr>;
        Identifier id = new Identifier(match(Token.ID));

        if (token == Token.LBRACKET) {
            match(Token.LBRACKET);
            Expr e1 = expr();
            match(Token.RBRACKET);
            Array a = new Array(id, e1);
            match(Token.ASSIGN);
            Expr e2 = expr();
            match(Token.SEMICOLON);
            return new Assignment(a, e2);
        } else if (token == Token.LPAREN)    // function call
	        return call(id);

        match(Token.ASSIGN);
        Expr e = expr();
        match(Token.SEMICOLON);
        return new Assignment(id, e);
    }


    private Call call(Identifier id) {
    // <call> -> id(<expr>{,<expr>});
        match(Token.LPAREN);
        Call c = new Call(id, arguments());
        match(Token.RPAREN);
        match(Token.SEMICOLON);
    //
    // parse function call
    //
	return null;
    }


    private If ifStmt() {
        // <ifStmt> -> if (<expr>) then <stmt> [else <stmt>]
        match(Token.IF);
        match(Token.LPAREN);
        Expr e = expr();
        match(Token.RPAREN);
        match(Token.THEN);
        Stmt s1 = stmt();
        Stmt s2 = new Empty();
        if (token == Token.ELSE) {
            match(Token.ELSE);
            s2 = stmt();
        }
        return new If(e, s1, s2);
    }

    private While whileStmt() {
        // <whileStmt> -> while (<expr>) <stmt>
        //
        // parse while statement
        match(Token.WHILE);
        match(Token.LPAREN);
        Expr e = expr();
        match(Token.RPAREN);

        Stmt s = stmt();
        return new While(e, s);
    }

    private Stmt forstmt() {
        match(Token.FOR);
        match(Token.LPAREN);

        Decl decl = decl();
        Expr condition = expr();
        match(Token.SEMICOLON);

        Identifier id = new Identifier(match(Token.ID));
        match(Token.ASSIGN);
        Expr rhs = expr();
        Stmt increment = new Assignment(id, rhs);

        match(Token.RPAREN);

        Stmts whileBody;
        Stmt body = stmt();
        if (body instanceof Stmts) {
            ArrayList<Stmt> stmts = new ArrayList<>(((Stmts) body).stmts);
            stmts.add(increment);
            whileBody = new Stmts(stmts);
        } else {
            whileBody = new Stmts(new ArrayList<>(List.of(body, increment)));
        }

        While whileStmt = new While(condition, whileBody);

        Decls decls = new Decls();
        decls.add(decl);
        return new Let(decls, new Stmts(new ArrayList<>(List.of(whileStmt))));
    }

    private Stmt dowhileStmt() {
        match(Token.DO);
        Stmts doBlock = stmts();
        match(Token.WHILE);
        match(Token.LPAREN);
        Expr condition = expr();
        match(Token.RPAREN);
        match(Token.SEMICOLON);

        Stmts whileBody = new Stmts(new ArrayList<>(doBlock.stmts));
        While whileStmt = new While(condition, whileBody);


        Stmts full = new Stmts(new ArrayList<>());

        full.stmts.addAll(doBlock.stmts);
        full.stmts.add(whileStmt);

        return full;

    }


    private Expr expr() {
        // <expr> -> <bexp> {& <bexp> | '|'<bexp>} | !<expr> | true | false
        switch (token) {
            case NOT:
                Operator op = new Operator(match(token));
                Expr e = expr();
                return new Unary(op, e);
            case TRUE:
                match(Token.TRUE);
                return new Value(true);
            case FALSE:
                match(Token.FALSE);
                return new Value(false);
        }

        Expr e = bexp();

        // parse logical operations
        while (token == Token.AND || token == Token.OR) {
            Operator op = new Operator(match(token));
            Expr t = term();
            e = new Binary(op, e, t);
        }

        return e;
    }

    private Expr bexp() {
        // <bexp> -> <aexp> [ (< | <= | > | >= | == | !=) <aexp> ]
        Expr e = aexp();
        // parse relational operations
        if (token == Token.LT || token == Token.LTEQ || token == Token.GT || token == Token.GTEQ || token == Token.EQUAL || token == Token.NOTEQ) {
            Operator op = new Operator(match(token));
            Expr t = aexp();
            e = new Binary(op, e, t);
        }

        return e;
    }

    private Expr aexp() {
        // <aexp> -> <term> { + <term> | - <term> }
        Expr e = term();
        while (token == Token.PLUS || token == Token.MINUS) {
            Operator op = new Operator(match(token));
            Expr t = term();
            e = new Binary(op, e, t);
        }
        return e;
    }

    private Expr term() {
        // <term> -> <factor> { * <factor> | / <factor>}
        Expr t = factor();
        while (token == Token.MULTIPLY || token == Token.DIVIDE) {
            Operator op = new Operator(match(token));
            Expr f = factor();
            t = new Binary(op, t, f);
        }
        return t;
    }

    private Expr factor() {
        // <factor> -> [-](id | id '[' <expr> ']' | <call> | literal | '('<aexp> ')')
        Operator op = null;
        if (token == Token.MINUS)
            op = new Operator(match(Token.MINUS));

        Expr e = null;
        switch (token) {
            case ID:
                Identifier v = new Identifier(match(Token.ID));
                e = v;
                if (token == Token.LPAREN) {  // function call
                    match(Token.LPAREN);
                    Call c = new Call(v, arguments());
                    match(Token.RPAREN);
                    e = c;
                }
                // array
                if (token == Token.LBRACKET) {
                    match(Token.LBRACKET);
                    Expr idx = expr();
                    match(Token.RBRACKET);
                    e = new Array(v, idx);
                }

                break;
            case NUMBER:
            case STRLITERAL:
                e = literal();
                break;
            case LPAREN:
                match(Token.LPAREN);
                e = aexp();
                match(Token.RPAREN);
                break;
            default:
                error("Identifier | Literal");
        }

        if (op != null)
            return new Unary(op, e);
        else return e;
    }

    private Exprs arguments() {
        // arguments -> [ <expr> {, <expr> } ]
        Exprs es = new Exprs();
        while (token != Token.RPAREN) {
            es.add(expr());
            if (token == Token.COMMA)
                match(Token.COMMA);
            else if (token != Token.RPAREN)
                error("Exprs");
        }
        return es;
    }

    private Value literal() {
        String s = null;
        switch (token) {
            case NUMBER:
                s = match(Token.NUMBER);
                return new Value(Integer.parseInt(s));
            case STRLITERAL:
                s = match(Token.STRLITERAL);
                return new Value(s);
        }
        throw new IllegalArgumentException("no literal");
    }

    private boolean isType() {
        switch (token) {
            case INT:
            case BOOL:
            case STRING:
                return true;
            default:
                return false;
        }
    }

    public static void main(String args[]) {
        Parser parser;
        Command command = null;
        if (args.length == 0) {
            System.out.print(">> ");
            Lexer.interactive = true;
            parser = new Parser(new Lexer());
            do {
                if (parser.token == Token.EOF)
                    parser.token = parser.lexer.getToken();

                try {
                    command = parser.command();
                    if (command != null) command.display(0);    // display AST
                } catch (Exception e) {
                    System.err.println(e);
                }
                System.out.print("\n>> ");
            } while (true);
        } else {
            System.out.println("Begin parsing... " + args[0]);
            parser = new Parser(new Lexer(args[0]));
            do {
                if (parser.token == Token.EOF)
                    break;

                try {
                    command = parser.command();
                    if (command != null) command.display(0);      // display AST
                } catch (Exception e) {
                    System.err.println(e);
                }
            } while (command != null);
        }
    } //main
} // Parser
