grammar BUCOLGrammar;

@header {
	import java.util.ArrayList;
	import java.util.Stack;
	import java.util.HashMap;
	import io.compiler.types.*;
	import io.compiler.core.exceptions.*;
	import io.compiler.core.ast.*;
}

@members {
    private HashMap<String,Var> symbolTable = new HashMap<String, Var>();
    private ArrayList<Var> currentDecl = new ArrayList<Var>();
    private Types currentType;
    private Types leftType=null, rightType=null;
    private Program program = new Program();
    private String strExpr = "";
    private IfCommand currentIfCommand;
    private WhileCommand currentWhileCommand;
    
    private Stack<ArrayList<Command>> stack = new Stack<ArrayList<Command>>();
    
    
    public void updateType(){
    	for(Var v: currentDecl){
    	   v.setType(currentType);
    	   symbolTable.put(v.getId(), v);
    	}
    }
    public void exibirVar(){
        for (String id: symbolTable.keySet()){
        	System.out.println(symbolTable.get(id));
        }
    }
    
    public Program getProgram(){
    	return this.program;
    	}
    
    public boolean isDeclared(String id){
    	return symbolTable.get(id) != null;
    }
}
 
programa	: 'programa' ID  { program.setName(_input.LT(-1).getText());
                               stack.push(new ArrayList<Command>()); 
                             } QL
               declaravar+
               'inicio' QL
               comando+
               'fim' QL
               'fimprog' QL
               {
                  program.setSymbolTable(symbolTable);
                  program.setCommandList(stack.pop());
               }
			;
						
declaravar	: 'declare' { currentDecl.clear(); } 
               ID  { currentDecl.add(new Var(_input.LT(-1).getText()));}
               ( VIRG ID                
              		 { currentDecl.add(new Var(_input.LT(-1).getText()));}
               )*	 
               DP 
               (
               'number' {currentType = Types.NUMBER;}
               |
               'text' {currentType = Types.TEXT;}
               |
               'boolean' {currentType = Types.BOOLEAN;}
               ) 
               
               { updateType(); } 
               QL
			;
			
comando     :  cmdAttrib
			|  cmdLeitura
			|  cmdEscrita
			|  cmdIF
         |  cmdWhile
			;
			
cmdIF		: 'Ao acaso, tendo'  { stack.push(new ArrayList<Command>());
                      strExpr = "";
                      currentIfCommand = new IfCommand();
                    }  
               DP
               expr
               OPREL  { strExpr += _input.LT(-1).getText(); }
               expr 
               { currentIfCommand.setExpression(strExpr); }
               ', tenho que' 
               QL
               comando+                
               { 
                  currentIfCommand.setTrueList(stack.pop());                            
               }  
               ( 'Mas, se o destino não permite,'  
               { stack.push(new ArrayList<Command>()); }
               QL
               comando+
               { currentIfCommand.setFalseList(stack.pop()); }  
               )?
               'E esta é a soluções para minhas indagações' QL 
               {
               	   stack.peek().add(currentIfCommand);
               }  			   
			;

cmdWhile : 'Continuamente, ao caso de' { stack.push(new ArrayList<Command>());
                      strExpr = "";
                      currentWhileCommand = new WhileCommand();
                    }  
            DP
            expr
            OPREL  { strExpr += _input.LT(-1).getText(); }
            expr 
            { currentWhileCommand.setExpression(strExpr); }
            ', busco'
            QL
            comando+                
            { 
               currentWhileCommand.setCommandList(stack.pop());                            
            }
            'O que continuamente trará meu sossego' QL
            {
                  stack.peek().add(currentWhileCommand);
            }  
         ;

			
cmdAttrib   : ID { if (!isDeclared(_input.LT(-1).getText())) {
                       throw new BUCOLSemanticException("Undeclared Variable: "+_input.LT(-1).getText());
                   }
                   symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
                   leftType = symbolTable.get(_input.LT(-1).getText()).getType();
                 }
              OP_AT 
              expr 
              QL
              {
                 System.out.println("Left  Side Expression Type = "+leftType);
                 System.out.println("Right Side Expression Type = "+rightType);
                 if (leftType.getValue() < rightType.getValue()){
                    throw new BUCOLSemanticException("Type Mismatchig on Assignment");
                 }
              }
			;			
			
cmdLeitura  : 'leia' AP 
               ID { if (!isDeclared(_input.LT(-1).getText())) {
                       throw new BUCOLSemanticException("Undeclared Variable: "+_input.LT(-1).getText());
                    }
                    symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
                    Command cmdRead = new ReadCommand(symbolTable.get(_input.LT(-1).getText()));
                    stack.peek().add(cmdRead);
                  } 
               FP 
               QL 
			;
			
cmdEscrita  : 'escreva' AP 
              ( termo  { Command cmdWrite = new WriteCommand(_input.LT(-1).getText());
                         stack.peek().add(cmdWrite);
                       } 
              ) 
              FP QL { rightType = null;}
			;			

			
expr		:  termo  { strExpr += _input.LT(-1).getText(); } exprl 			
			;
			
termo		: ID  { if (!isDeclared(_input.LT(-1).getText())) {
                       throw new BUCOLSemanticException("Undeclared Variable: "+_input.LT(-1).getText());
                    }
                    if (!symbolTable.get(_input.LT(-1).getText()).isInitialized()){
                       throw new BUCOLSemanticException("Variable "+_input.LT(-1).getText()+" has no value assigned");
                    }
                    if (rightType == null){
                       rightType = symbolTable.get(_input.LT(-1).getText()).getType();
                       //System.out.println("Encontrei pela 1a vez uma variavel = "+rightType);
                    }   
                    else{
                       if (symbolTable.get(_input.LT(-1).getText()).getType().getValue() > rightType.getValue()){
                          rightType = symbolTable.get(_input.LT(-1).getText()).getType();
                          //System.out.println("Ja havia tipo declarado e mudou para = "+rightType);
                          
                       }
                    }
                  }   
			| NUM    {  if (rightType == null) {
			 				rightType = Types.NUMBER;
			 				//System.out.println("Encontrei um numero pela 1a vez "+rightType);
			            }
			            else{
			                if (rightType.getValue() < Types.NUMBER.getValue()){			                    			                   
			                	rightType = Types.NUMBER;
			                	//System.out.println("Mudei o tipo para Number = "+rightType);
			                }
			            }
			         }
			| TEXTO  {  if (rightType == null) {
			 				rightType = Types.TEXT;
			 				//System.out.println("Encontrei pela 1a vez um texto ="+ rightType);
			            }
			            else{
			                if (rightType.getValue() < Types.TEXT.getValue()){			                    
			                	rightType = Types.TEXT;
			                	//System.out.println("Mudei o tipo para TEXT = "+rightType);
			                }
			            }
			         }
         | BOOLEAN  {  if (rightType == null) {
			 				rightType = Types.BOOLEAN;
			 				//System.out.println("Encontrei pela 1a vez um booleano ="+ rightType);
			            }
			            else{
			                if (rightType.getValue() < Types.BOOLEAN.getValue()){			                    
			                	rightType = Types.BOOLEAN;
			                	//System.out.println("Mudei o tipo para BOOLEAN = "+rightType);
			                }
			            }
			         }
			;
			
exprl		: ( OP { strExpr += _input.LT(-1).getText(); } 
                termo { strExpr += _input.LT(-1).getText(); } 
              ) *
			;	
			
OP			: '+' | '-' | '*' | '/'
			;	
			
OP_AT	    : ':='
		    ;
		    
OPREL    : '>' | '<' | '>=' | '<= ' | '<>' | '==' |  'e também' | 'ou também'
			;		    			
			
ID			: [a-z] ( [a-z] | [A-Z] | [0-9] )*		
			;
			
NUM		: [0-9]+ ('.' [0-9]+ )?
			;		

BOOLEAN : 'absoluto paraíso' | 'terrível inferno'
        ;
			
VIRG		: ','
			;
						
QL			: '\n'
         ;			
            
AP			: '('
			;            
						
FP			: ')'
			;
									
DP			: ':'
		    ;
		    
TEXTO       : '"' ( [a-z] | [A-Z] | [0-9] | ',' | '.' | ' ' | '-' )* '"'
			;		    
		    			
WS			: (' ' | '\n' | '\r' | '\t') -> skip
			;