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
STRING  : ["|'] (~["\r\n] | '""')+ ["|'];
WS      : [ \t\r\n]+ -> skip ;
COMENTARIO: '!' ~( '\r' | '\n' )* -> skip;

start : listaInstrucciones EOF;

listaInstrucciones: e+=instrucciones*
;

instrucciones
        :'program' id1=IDEN 'implicit' 'none' e+=instrucciones2* 'end' 'program' id2=IDEN                       #instruccionesProgram
        |'subroutine' id1=IDEN '(' e1+=listaParams* ')'
         'implicit' 'none' e2+=listaDeclaracionParams* e3+=instrucciones2* 'end' 'subroutine' id2=IDEN          #instruccionesSubrutina
        |'function' id1=IDEN '(' e1+=listaParams* ')' 'result' '(' id3=IDEN ')'
                 'implicit' 'none' e2+=listaDeclaracionParams* e3+=instrucciones2* 'end' 'function' id2=IDEN    #instruccionesFuncion
;

listaParams
    :id=IDEN        #listaParamsNormal
    |',' id=IDEN    #listaParamsComa
;

listaDeclaracionParams
    :tip=tipo ',' 'intent' '(' 'in' ')' '::' id=IDEN                                           #listaDeclaracionParamsNormal
    |tip=tipo ',' 'intent' '(' 'in' ')' '::' id=IDEN '(' dim1=expresion ',' dim2=expresion ')' #listaDeclaracionParamsArray2Dim
    |tip=tipo ',' 'intent' '(' 'in' ')' '::' id=IDEN '(' dim1=expresion ')'                    #listaDeclaracionParamsArray1Dim
;

instrucciones2
        :declaracion #instrucciones2Declaracion
        |asignacion  #instrucciones2Asignacion
        |allocate    #instrucciones2Allocate
        |print       #instrucciones2Print
        |if          #instrucciones2If
        |do          #instrucciones2Do
        |exit        #instrucciones2Exit
        |cycle       #instrucciones2Cycle
        |call        #instrucciones2Call
;

declaracion
        :tipo ',' 'dimension' '(' dim1=expresion ',' dim2=expresion ')' '::' id=IDEN    #declaracionArray2Dim
        |tipo ',' 'dimension' '(' dim1=expresion ')' '::' id=IDEN                       #declaracionArray1Dim
        |tipo ',' 'allocatable' '::' id=IDEN '(' ':' ',' ':' ')'                        #declaracionAllocatable2Dim
        |tipo ',' 'allocatable' '::' id=IDEN '(' ':' ')'                                #declaracionAllocatable1Dim
        |tipo '::' id=IDEN '(' dim1=expresion ',' dim2=expresion ')'                    #declaracionArray2Dim2
        |tipo '::' id=IDEN '(' dim1=expresion ')'                                       #declaracionArray1Dim2
        |tipo '::' id=IDEN '=' expresion e+=listaDeclaracion*                           #declaracionAsig
        |tipo '::' id=IDEN e+=listaDeclaracion*                                         #declaracionUniq
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

if
    :id='if' '(' cond=expresion ')' 'then' e+=instrucciones2* 'end' 'if'                                        #ifNormal
    |id='if' '(' cond=expresion ')' 'then' e+=instrucciones2* 'else' e2+=instrucciones2* 'end' 'if'             #ifElse
    |id='if' '(' cond=expresion ')' 'then' e+=instrucciones2* e2+=elseif* 'end' 'if'                            #ifElseIf
    |id='if' '(' cond=expresion ')' 'then' e+=instrucciones2* e2+=elseif* 'else' e3+=instrucciones2* 'end' 'if' #ifElseIfElse
;

elseif
    :id='else' 'if' '(' cond=expresion ')' 'then' e+=instrucciones2*
;

do
    :id='do' inicio=asignacion ',' fin=expresion ',' paso=expresion e+=instrucciones2* 'end' 'do'                       #doNormal
    |id='do' inicio=asignacion ',' fin=expresion e+=instrucciones2* 'end' 'do'                                          #doNormalSinPaso
    |id1=IDEN ':' 'do' inicio=asignacion ',' fin=expresion ',' paso=expresion e+=instrucciones2* 'end' 'do' id2=IDEN    #doEtiqueta
    |id1=IDEN ':' 'do' inicio=asignacion ',' fin=expresion e+=instrucciones2* 'end' 'do' id2=IDEN                       #doEtiquetaSinPaso
    |id='do' 'while' '(' condicion=expresion ')' e+=instrucciones2* 'end' 'do'                                          #doWhile
    |id1=IDEN ':' 'do' 'while' '(' condicion=expresion ')' e+=instrucciones2* 'end' 'do' id2=IDEN                       #doWhileEtiqueta
;



exit
    :id='exit'                                          #exitNormal
    |id1='exit' id2=IDEN                                #exitEtiqueta
;

cycle
    :id='cycle'                                         #cycleNormal
    |id1='cycle' id2=IDEN                               #cycleEtiqueta
;

call
    :'call' id=IDEN '(' e+=listaCall* ')'
;

listaCall
    :val=expresion          #listaCallNormal
    |',' val=expresion      #listaCallComma
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
    |id1=IDEN '(' e+=listaCall* ')'                     #expresionFuncion
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