grammar Gramatica;

@parser::header{
    import java.util.List;
    import java.util.ArrayList;
    import Abstract.*;
    import Expresiones.*;
    import Instrucciones.*;
    import Other.*;
    import Symbols.*;
}
options {caseInsensitive = true;}
INT     : [0-9]+ ;
REAL    : [0-9]+'.'[0-9]+;
COMPLEX : '('[0-9]+','[0-9]+')';
IDEN    : [a-z][a-z0-9_]* ;
CHAR    : ["|'].["|'];
STRING  : '"' (~["\r\n] | '""')+ '"';
WS      : [ \t\r\n]+ -> skip ;
COMENTARIO: '!' ~( '\r' | '\n' )* -> skip;

start : listaInstrucciones EOF;

listaInstrucciones: e+=instrucciones*
;

instrucciones
        :'program' id1=IDEN 'implicit' 'none' e+=instrucciones2* 'end' 'program' id2=IDEN #instruccionesProgram
;

instrucciones2
        :declaracion #instrucciones2Declaracion
        |asignacion  #instrucciones2Asignacion
        |allocate    #instrucciones2Allocate
        |print       #instrucciones2Print
;

declaracion
        :tipo ',' 'dimension' '(' dim1=INT ',' dim2=INT ')' '::' id=IDEN    #declaracionArray2Dim
        |tipo ',' 'dimension' '(' dim1=INT ')' '::' id=IDEN                 #declaracionArray1Dim
        |tipo ',' 'allocatable' '::' id=IDEN '(' ':' ',' ':' ')'            #declaracionAllocatable2Dim
        |tipo ',' 'allocatable' '::' id=IDEN '(' ':' ')'                    #declaracionAllocatable1Dim
        |tipo '::' id=IDEN '(' dim1=INT ',' dim2=INT ')'                    #declaracionArray2Dim2
        |tipo '::' id=IDEN '(' dim1=INT ')'                                 #declaracionArray1Dim2
        |tipo '::' id=IDEN '=' expresion e+=listaDeclaracion*               #declaracionAsig
        |tipo '::' id=IDEN e+=listaDeclaracion*                             #declaracionUniq
;

listaDeclaracion
        :',' id=IDEN '=' expresion #listaDeclaracionAsig
        |',' id=IDEN               #listaDeclaracionUniq
;

asignacion
        :id=IDEN '=' expresion                                                  #asignacionId
        |id=IDEN '[' num=expresion ']' '=' val=expresion                        #asignacionArray1
        |id=IDEN '[' num1=expresion ',' num2=expresion ']' '=' val=expresion    #asignacionArray2
;

allocate
        :'allocate' '(' id=IDEN '(' val1=expresion ',' val2=expresion ')' ')'   #allocate2Dim
        |'allocate' '(' id=IDEN '(' val1=expresion ')' ')'                      #allocate1Dim
        |'deallocate' '(' id=IDEN ')'                                           #deallocate
;

print:
    p='print' '*' ',' val=expresion e+=listaPrint*
;

listaPrint
    :',' expresion
;

expresion
    :op='-' expresion                                   #expresionNegativo
    |op='.not.' expresion                               #expresionNot
    |val1=expresion op='**' val2=expresion              #expresionPotencia
    |val1=expresion op='*' val2=expresion               #expresionMultiplicacion
    |val1=expresion op='/' val2=expresion               #expresionDivision
    |val1=expresion op='+' val2=expresion               #expresionSuma
    |val1=expresion op='-' val2=expresion               #expresionResta
    |val1=expresion op=('=='|'.eq.') val2=expresion     #expresionEq
    |val1=expresion op=('/='|'.ne.') val2=expresion     #expresionNe
    |val1=expresion op=('>='|'.ge.') val2=expresion     #expresionGe
    |val1=expresion op=('>' |'.gt.') val2=expresion     #expresionGt
    |val1=expresion op=('<='|'.le.') val2=expresion     #expresionLe
    |val1=expresion op=('<' |'.lt.') val2=expresion     #expresionLt
    |val1=expresion op='.and.' val2=expresion           #expresionAnd
    |val1=expresion op='.or.'  val2=expresion           #expresionOr
    |si='size' '(' val=IDEN ')'                         #expresionSize
    |val=IDEN '[' pos=expresion ']'                     #expresionArray1
    |val=IDEN '[' pos1=expresion ',' pos2=expresion ']' #expresionArray2
    |val=IDEN                                           #expresionIdentificador
    |val=REAL                                           #expresionReal
    |val=INT                                            #expresionInt
    |val=CHAR                                           #expresionChar
    |val=STRING                                         #expresionString
    |val='.true.'                                       #expresionTrue
    |val='.false.'                                      #expresionFalse
    |'[/' val=expresion e+=listaExpresion* '/]'         #expresionListaExpresion
    |'(' val=expresion ')'                              #expresionParentesis
;

listaExpresion
    :',' expresion
;

tipo:
    'integer'       #tipoInteger
    |'real'         #tipoReal
    |'complex'      #tipoComplex
    |'character'    #tipoCharacter
    |'logical'      #tipoLogical
;