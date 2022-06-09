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
        |print       #instrucciones2Print
        |asignacion  #instrucciones2Asignacion
;

declaracion

        :tipo '::' id=IDEN '=' expresion e+=listaDeclaracion* #declaracionAsig
        |tipo '::' id=IDEN e+=listaDeclaracion*               #declaracionUniq

;

listaDeclaracion
        :',' id=IDEN '=' expresion #listaDeclaracionAsig
        |',' id=IDEN               #listaDeclaracionUniq
;

asignacion
        :id=IDEN '=' expresion
;


print:
    p='print' '*' ',' val=expresion e+=listaPrint*
;

listaPrint
    :',' expresion
;

expresion
    :val=REAL       #expresionReal
    |val=INT        #expresionInt
    |val=CHAR       #expresionChar
    |val=STRING     #expresionString
    |val='.true.'   #expresionTrue
    |val='.false.'  #expresionFalse
;

tipo:
    'integer'       #tipoInteger
    |'real'         #tipoReal
    |'complex'      #tipoComplex
    |'character'    #tipoCharacter
    |'logical'      #tipoLogical
;