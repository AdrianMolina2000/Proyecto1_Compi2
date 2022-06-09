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

INT     : [0-9]+ ;
REAL    : [0-9]+'.'[0-9]+;
COMPLEX : '('[0-9]+','[0-9]+')';
IDEN    : [a-zA-Z][a-zA-Z0-9_]* ;
CHAR    : '"'.'"';
WS      : [ \t\r\n]+ -> skip ;
COMENTARIO: '!' ~( '\r' | '\n' )* -> skip;

start : (instrucciones{Gramatica.Globales.tree.instrucciones.add($instrucciones.nodo);})*   ;


instrucciones returns [Nodo nodo]:
        'program' id1=IDEN 'implicit' 'none'
        {ArrayList<Nodo> instr = new ArrayList<Nodo>();}
        (instrucciones2 {instr.add($instrucciones2.nodo);})*
        'end' 'program' id2=IDEN
        {$nodo= new Program(instr,$id1.text,$id2.text,$id1.line, $id1.pos);}
;

instrucciones2 returns [Nodo nodo]
        :declaracion {$nodo=$declaracion.nodo;}
        |print {$nodo=$print.nodo;}

;

declaracion returns [Nodo nodo]
        @init
        {
            ArrayList<Nodo> listDec = new ArrayList<Nodo>();
        }
        :tipo '::' IDEN '=' expresion
        {listDec.add(new Declaracion($tipo.nodo.tipo, $IDEN.text, $expresion.nodo, $IDEN.line, $IDEN.pos));}
        (listaDeclaracion[$tipo.nodo] {listDec.add($listaDeclaracion.nodo);})*
        {
            $nodo = new ListaDeclaraciones(listDec, $IDEN.line, $IDEN.pos);
        }
        |tipo '::' IDEN
        {listDec.add(new Declaracion($tipo.nodo.tipo, $IDEN.text, Globales.defal($tipo.nodo.tipo, $IDEN.line, $IDEN.pos), $IDEN.line, $IDEN.pos));}
        (listaDeclaracion[$tipo.nodo] {listDec.add($listaDeclaracion.nodo);})*
        {
            $nodo = new ListaDeclaraciones(listDec, $IDEN.line, $IDEN.pos);
        }
;

listaDeclaracion [Tipo type] returns [Nodo nodo]
        :',' IDEN '=' expresion {$nodo = new Declaracion($type.tipo, $IDEN.text, $expresion.nodo, $IDEN.line, $IDEN.pos);}
        |',' IDEN {$nodo = new Declaracion($type.tipo, $IDEN.text, Globales.defal($type.tipo, $IDEN.line, $IDEN.pos), $IDEN.line, $IDEN.pos);}
;


print returns [Nodo nodo]:
    p='print' '*' ',' expresion {$nodo = new Print($expresion.nodo, $p.line, $p.pos);}
;

expresion returns [Nodo nodo]:
    REAL    {$nodo = new Primitivo(Tipo.Tipos.REAL, $REAL.text, $REAL.line, $REAL.pos);}
    |INT    {$nodo = new Primitivo(Tipo.Tipos.INTEGER, $INT.text, $INT.line, $INT.pos);}
;

tipo returns [Tipo nodo]:
    'integer'       {$nodo = new Tipo(Tipo.Tipos.INTEGER);}
    |'real'         {$nodo = new Tipo(Tipo.Tipos.REAL);}
    |'complex'      {$nodo = new Tipo(Tipo.Tipos.COMPLEX);}
    |'character'    {$nodo = new Tipo(Tipo.Tipos.CHARACTER);}
    |'logical'      {$nodo = new Tipo(Tipo.Tipos.LOGICAL);}
;