package Lab02_03;

// Sint.java
// Interpreter for S
import java.util.Scanner;

public class Sint {
    static Scanner sc = new Scanner(System.in);
    static State state = new State();

    State Eval(Command c, State state) { 
	if (c instanceof Decl) {
	    Decls decls = new Decls();
	    decls.add((Decl) c);
	    return allocate(decls, state);
	}

	if (c instanceof Function) {
	    Function f = (Function) c;
	    state.push(f.id, new Value(f)); 
	    return state;
	}

	if (c instanceof Stmt)
	    return Eval((Stmt) c, state); 
		
	    throw new IllegalArgumentException("no command");
    }
  
    State Eval(Stmt s, State state) {
        if (s instanceof Empty) 
	        return Eval((Empty)s, state);
        if (s instanceof Assignment)  
	        return Eval((Assignment)s, state);
        if (s instanceof If)  
	        return Eval((If)s, state);
        if (s instanceof While)  
	        return Eval((While)s, state);
        if (s instanceof Stmts)  
	        return Eval((Stmts)s, state);
	    if (s instanceof Let)  
	        return Eval((Let)s, state);
	    if (s instanceof Read)
	        return Eval((Read)s, state);
	    if (s instanceof Print)  
	        return Eval((Print)s, state);
        if (s instanceof Call) 
	        return Eval((Call)s, state);
	    if (s instanceof Return) 
	        return Eval((Return)s, state);
        throw new IllegalArgumentException("no statement");
    }


    // call without return value
    State Eval(Call c, State state) {
	//
	// evaluate call without return value
	//
	    return state;
    }

    // call with return value 
    Value V (Call c, State state) { 
	    Value v = state.get(c.fid);  			// find function
        Function f = v.funValue();
        State s = newFrame(state, c, f);		// create new frame on the stack
        s = Eval(f.stmt, s); 					// interpret the call
	    v = s.peek().val;						// get the return value  v = s.get(new Identifier("return")); 
        s = deleteFrame(s, c, f); 				// delete the frame on the stack
    	return v;
    }

    State Eval(Return r, State state) {
        Value v = V(r.expr, state);
		return state.set(new Identifier("return"), v); 
    }

    State newFrame (State state, Call c, Function f) {
        if (c.args.size() == 0) 
            return state;
	//
	// evaluate arguments
	//

	//
	// activate a new stack frame in the stack 
	//
	
	    state.push(new Identifier("return"), null); // allocate for return value
        return state;
    }

    State deleteFrame (State state, Call c, Function f) {
	    state.pop();  // pop the return value
	//
	// free a stack frame from the stack
	//
	    return state;
    }

    State Eval(Empty s, State state) {
        return state;
    }

    State Eval(Assignment a, State state) {
        if (a.id instanceof Identifier) {  // 변수에 할당인 경우
            Value v = V(a.expr, state);  // expr을 평가하여 값 구하기
            Decl decl = new Decl(a.id.toString(), v.type(), v);  // 새로운 선언 객체 생성
            Decls decls = new Decls(decl);  // 하나의 선언을 포함하는 Decls 객체 생성
            state = allocate(decls, state);  // 상태에 선언 반영
            return state.set(a.id, v);  // 변수에 값 설정
        } else if (a.ar instanceof Array) {  // 배열에 할당인 경우
            Array arr = a.ar;
            Value arrayValue = (Value) state.get(arr.id);  // 배열값 가져오기
            Value indexValue = V(arr.expr, state);  // 인덱스 값을 평가
            int index = indexValue.intValue();  // 인덱스 값 얻기
            Value valueAssign = V(a.expr, state);  // 할당할 값 평가
            Value[] realArray = arrayValue.arrValue();  // 배열 값 얻기
            realArray[index] = valueAssign;  // 배열의 해당 인덱스에 값 대입
            return state;
        }
        throw new RuntimeException("Assignment Error");
    }


    State Eval(Read r, State state) {
        if (r.id.type == Type.INT) {
	        int i = sc.nextInt();
	        state.set(r.id, new Value(i));
	    }

	    if (r.id.type == Type.BOOL) {
	        boolean b = sc.nextBoolean();
            state.set(r.id, new Value(b));
	    }
	// input string
        if (r.id.type == Type.STRING) {
            String s = sc.next();
            state.set(r.id, new Value(s));
        }

	    return state;
    }

    State Eval(Print p, State state) {
	    System.out.println(V(p.expr, state));
        return state; 
    }
  
    State Eval(Stmts ss, State state) {
        for (Stmt s : ss.stmts) {
            state = Eval(s, state);
            if (s instanceof Return)  
                return state;
        }
        return state;
    }
  
    State Eval(If c, State state) {
        if (V(c.expr, state).boolValue( ))
            return Eval(c.stmt1, state);
        else
            return Eval(c.stmt2, state);
    }
 
    State Eval(While l, State state) {
        if (V(l.expr, state).boolValue( ))
            return Eval(l, Eval(l.stmt, state));
        else 
	        return state;
    }

    State Eval(Let l, State state) {
        State s = allocate(l.decls, state);
        s = Eval(l.stmts,s);
	    return free(l.decls, s);
    }

    State allocate (Decls ds, State state) {
        if (ds != null) {
            for (Decl decl : ds) {
                Value val;

                if (decl.expr != null) {
                    val = V(decl.expr, state);
                } else {
                    if (decl.type == Type.INT) {
                        val = new Value(0);
                    } else if (decl.type == Type.BOOL) {
                        val = new Value(false);
                    } else if (decl.type == Type.STRING) {
                        val = new Value("");
                    } else {
                        throw new RuntimeException("Unknown type");
                    }
                }
                state.push(decl.id, val);
            }
        }
        return state;
    }


    State free (Decls ds, State state) {
		if (ds != null){
            for (Decl decl : ds) {
                state.pop();
            }
            // free the entries for declared variables from the state
        }
        return state;
    }

    Value binaryOperation(Operator op, Value v1, Value v2) {
        check(!v1.undef && !v2.undef,"reference to undef value");
        switch (op.val) {
            case "+":
                return new Value(v1.intValue() + v2.intValue());
            case "-":
                return new Value(v1.intValue() - v2.intValue());
            case "*":
                return new Value(v1.intValue() * v2.intValue());
            case "/":
                return new Value(v1.intValue() / v2.intValue());

            // relational operations
            case "<":
                if (v1.type == Type.INT && v2.type == Type.INT) {
                    return new Value(v1.intValue() < v2.intValue());
                } else if (v1.type == Type.STRING && v2.type == Type.STRING) {
                    return new Value(v1.stringValue().compareTo(v2.stringValue()) < 0);
                }
                break;
            case "<=":
                if (v1.type == Type.INT && v2.type == Type.INT) {
                    return new Value(v1.intValue() <= v2.intValue());
                } else if (v1.type == Type.STRING && v2.type == Type.STRING) {
                    return new Value(v1.stringValue().compareTo(v2.stringValue()) <= 0);
                }
                break;

            case ">":
                if (v1.type == Type.INT && v2.type == Type.INT) {
                    return new Value(v1.intValue() > v2.intValue());
                } else if (v1.type == Type.STRING && v2.type == Type.STRING) {
                    return new Value(v1.stringValue().compareTo(v2.stringValue()) > 0);
                }
                break;

            case ">=":
                if (v1.type == Type.INT && v2.type == Type.INT) {
                    return new Value(v1.intValue() >= v2.intValue());
                } else if (v1.type == Type.STRING && v2.type == Type.STRING) {
                    return new Value(v1.stringValue().compareTo(v2.stringValue()) >= 0);
                }
                break;

            case "==":
                if (v1.type == Type.INT && v2.type == Type.INT) {
                    return new Value(v1.intValue() == v2.intValue());
                } else if (v1.type == Type.STRING && v2.type == Type.STRING) {
                    return new Value(v1.stringValue().equals(v2.stringValue()));
                } else if (v1.type == Type.BOOL && v2.type == Type.BOOL) {
                    return new Value(v1.boolValue() == v2.boolValue());
                }
                break;

            case "!=":
                if (v1.type == Type.INT && v2.type == Type.INT) {
                    return new Value(v1.intValue() != v2.intValue());
                } else if (v1.type == Type.STRING && v2.type == Type.STRING) {
                    return new Value(!v1.stringValue().equals(v2.stringValue()));
                } else if (v1.type == Type.BOOL && v2.type == Type.BOOL) {
                    return new Value(v1.boolValue() != v2.boolValue());
                }
                break;
                // logical operations
            case "&":
                if (v1.type == Type.BOOL && v2.type == Type.BOOL) {
                    return new Value(v1.boolValue() && v2.boolValue());
                }
                break;

            case "|":
                if (v1.type == Type.BOOL && v2.type == Type.BOOL) {
                    return new Value(v1.boolValue() || v2.boolValue());
                }
                break;

//            default:

        }
        throw new IllegalArgumentException("no operation");
    }


    Value unaryOperation(Operator op, Value v) {
        check( !v.undef, "reference to undef value");
	    switch (op.val) {
        case "!": 
            return new Value(!v.boolValue( ));
        case "-": 
            return new Value(-v.intValue( ));
        default:
            throw new IllegalArgumentException("no operation: " + op.val); 
        }
    } 

    static void check(boolean test, String msg) {
        if (test) return;
        System.err.println(msg);
    }

    Value V(Expr e, State state) {
        if (e instanceof Value) 
            return (Value) e;

        if (e instanceof Identifier) {
	        Identifier v = (Identifier) e;
            return (Value)(state.get(v));
	    }

        if (e instanceof Binary) {
            Binary b = (Binary) e;
            Value v1 = V(b.expr1, state);
            Value v2 = V(b.expr2, state);
            return binaryOperation (b.op, v1, v2); 
        }

        if (e instanceof Unary) {
            Unary u = (Unary) e;
            Value v = V(u.expr, state);
            return unaryOperation(u.op, v); 
        }

        if (e instanceof Call) 
    	    return V((Call)e, state);

        if (e instanceof Array) {
            Array arr = (Array) e;
            Value arrayValue = (Value) state.get(arr.id);
            Value indexValue = V(arr.expr, state);
            int index = indexValue.intValue();
            Value[] realArray = arrayValue.arrValue();
            return realArray[index];
        }

        throw new IllegalArgumentException("no operation");
    }

    public static void main(String args[]) {
	    if (args.length == 0) {
	        Sint sint = new Sint(); 
			Lexer.interactive = true;
            System.out.println("Language S Interpreter 2.0");
            System.out.print(">> ");
	        Parser parser  = new Parser(new Lexer());

	        do { // Program = Command*
	            if (parser.token == Token.EOF)
		            parser.token = parser.lexer.getToken();
	       
	            Command command=null;
                try {
	                command = parser.command();
                    // if (command != null)  command.display(0);    // display AST
				    if (command == null) 
						 throw new Exception();
					 else  {
//						 command.type = TypeChecker.Check(command);
//                         System.out.println("Type: "+ command.type);
					 }
                } catch (Exception e) {
//                    System.out.println(e);
		            System.out.print(">> ");
                    continue;
                }

	            if (command.type != Type.ERROR) {
                    System.out.println("\nInterpreting..." );
                    try {
                        state = sint.Eval(command, state);
                    } catch (Exception e) {
                         System.err.println(e);  
                    }
                }
		    System.out.print(">> ");
	        } while (true);
	    }
        else {
	        System.out.println("Begin parsing... " + args[0]);
	        Command command = null;
	        Parser parser  = new Parser(new Lexer(args[0]));
	        Sint sint = new Sint();

	        do {	// Program = Command*
	            if (parser.token == Token.EOF)
                    break;
	         
                try {
	                command = parser.command();
//                    if (command != null)  command.display(0);    // display AST
				    if (command == null) 
						 throw new Exception();
					 else  {
//						 command.type = TypeChecker.Check(command);
//                         System.out.println("\nType: "+ command.type);
					 }
                } catch (Exception e) {
                    System.out.println(e);
                    continue;
                }

	            if (command.type!=Type.ERROR) {
                    System.out.println("\nInterpreting..." + args[0]);
                    try {
                        state = sint.Eval(command, state);
                    } catch (Exception e) {
//                        System.err.println(e);
                    }
                }
	        } while (command != null);
        }        
    }
}