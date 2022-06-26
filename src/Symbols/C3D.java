package Symbols;

import java.util.ArrayList;
import java.util.Arrays;

public class C3D {
    C3D gen;
    int countTemp;
    int countLabel;
    String code;
    String funcs;
    String natives;
    boolean inFunc;
    boolean inNatives;
    ArrayList<String> temps;
    ArrayList<String> free;
    ArrayList<String> used;

    String imports;
    boolean imath;

    boolean BprintString;
    boolean BconcatString;
    boolean Bpotencia;
    boolean BpotenciaString;
    boolean Bmodulo;
    boolean BcompararString;
    boolean BtoString;
    
    public C3D() {
        countTemp = 0;
        countLabel = 0;
        code = "";
        funcs = "";
        natives = "";
        inFunc = false;
        inNatives = false;
        temps = new ArrayList<>();
        free =  new ArrayList<>();
        used =  new ArrayList<>();

        imports = "\n\t fmt";
        imath = false;

        BprintString = false;
        BconcatString = false;
        Bpotencia = false;
        BpotenciaString = false;
        Bmodulo = false;
        BcompararString = false;
        BtoString = false;
    }

    public String getHeader(){
        String ret = "#include <stdio.h> \n";
        ret += "float heap[16384]; \n";
        ret += "float stack[16384]; \n";
        ret += "float P; \n";
        ret += "float H; \n";

        if(temps.size() > 0) {
            ret += "float " + temps.get(0);
            if(temps.size() > 1) {
                for (int i = 1; i < temps.size(); i++) {
                    ret += ", " + temps.get(i);
                }
            }
            ret += ";";
        }

        ret += "\n";

        return ret;
    }

    public String getCode(){
        String ret = getHeader();
        ret += natives + "\n";
        ret += funcs + "\n";
        ret += "void main() { \n";
        ret += "    P = 0; H = 0;\n";
        ret += code += "\n";
        ret += "return;\n}";
        return ret;
    }

    public void codeIn(String code, String tab){
        if(inNatives) {
            if (natives == "") {
                natives = natives + "\n";
            }

            natives = natives + "    " + code;
        }else if(inFunc) {
            if (funcs == "") {
                funcs = funcs + "\n";
            }
            funcs = funcs + tab + code;
        }else {
            this.code = this.code + "    " + code;
        }
    }

    public C3D getInstance(){
        if (gen == null) {
            gen = new C3D();
        }
        return gen;
    }

    public void addComment(String comment){
        codeIn("/*==============" + comment + "==============*/\n", "    ");
    }

    public String addTemp(){
        String temp = "";

        if (free.size() > 0){
            temp = free.remove(free.size()-1);
            used.add(temp);
            return temp;
        }

        temp = "t" + countTemp;
        countTemp += 1;
        temps.add(temp);
        used.add(temp);
        return temp;
    }

    public String newLabel(){
        String label = "L" + countLabel;
        countLabel += 1;
        return label;
    }

    public void addLabel(String label){
        codeIn(label + ":\n", "    ");
    }

    public void addGoto(String label) {
        codeIn("goto " + label + ";\n", "    ");
    }

    public void newIF(String left, String op, String right, String label){
        codeIn("if (" + left + " " + op + " " + right + ") goto " + label + ";\n", "    ");
    }

    public void addExp(String izq, String op1, String op, String op2){
        codeIn(izq + " = " + op1 + " " + op + " " + op2 + ";\n", "    ");
    }

    public void addArray(String id, String size){
        codeIn("float " + id + "[(int)" + size + "];\n", "    ");
    }

    public void getPosArray(String tmp, String id, String pos){
        codeIn(tmp + " = " + id + "[(int)" + pos + "];\n", "    ");
    }

    public void setPosArray(String id, String pos, String tmp){
        codeIn(id + "[(int)" + pos + "] = " + tmp + ";\n", "    ");
    }

    public void initFun(String id){
        if(!inNatives){
            inFunc = true;
        }
        codeIn("void " + id + "(){\n", "");
    }

    public void endFun(){
        codeIn("return;\n    } \n", "    ");
        if(!inNatives){
            inFunc = false;
        }
    }

    public void setStack(String pos, String value){
        codeIn("stack[(int)" + pos + "] = " + value + ";\n", "    ");
    }

    public void getStack(String izq, String pos){
        codeIn(izq + " = stack[(int)" + pos + "];\n", "    ");
    }

    public void newTable(String size){
        codeIn("P = P + " + size + ";\n", "    ");
    }

    public void callFun(String id){
        codeIn(id + "();\n", "    ");
    }

    public void getTable(String size){
        codeIn("P = P - " + size + ";\n", "    ");
    }

    public void setHeap(String pos, String value){
        codeIn("heap[(int)" + pos + "] = " + value + ";\n", "    ");
    }

    public void getHeap(String izq, String pos){
        codeIn(izq + " = heap[(int)" + pos + "];\n", "    ");
    }

    public void nextHeap(){
        codeIn("H= H + 1;\n", "    ");
    }

    public void addPrint(String type, String value){
            codeIn("printf(\"%"+ type +"\", (int) " + value + " );\n", "    ");
    }

    public void printFloat(String type, String value){
            codeIn("printf(\"%f\", (float) " + value + ");\n", "    ");
    }

    public void printTrue(){
        addComment("Imprimiendo true");
        addPrint("d", "1");

    }

    public void printFalse(){
        addComment("Imprimiendo false");
        addPrint("d", "0");

    }

    public void printString(){
        if (BprintString) {
            return;
        }

        BprintString = true;
        inNatives = true;

        initFun("printString");
        String salida = newLabel();
        String comprobar = newLabel();

        String tmpP = addTemp();
        String tmpH = addTemp();

        addExp(tmpP, "P", "+", "1");

        getStack(tmpH, tmpP);

        String tmp = addTemp();
        addLabel(comprobar);
        getHeap(tmp, tmpH);
        newIF(tmp, "==", "-1", salida);
        addPrint("c", tmp);
        addExp(tmpH, tmpH, "+", "1");
        addGoto(comprobar);
        addLabel(salida);
        endFun();
        inNatives = false;
    }

    public void potencia(){
        if(Bpotencia) {
            return;
        }
        Bpotencia = true;
        inNatives = true;

        initFun("potencia");

        String tmpP = addTemp();

        addExp(tmpP, "P", "+", "1");

        String tmp = addTemp();
        getStack(tmp, tmpP);

        String base = tmp;

        tmpP = addTemp();
        addExp(tmpP, "P", "+", "2");
        tmp = addTemp();
        getStack(tmp, tmpP);
        String exponente = tmp;

        String exp0 = newLabel();
        String exp1 = newLabel();
        String retornando = newLabel();
        String condicional = newLabel();
        String salida = newLabel();
        String continuando = newLabel();

        newIF(exponente, "==", "0", exp0);
        addGoto(exp1);
        addLabel(exp0);
        setStack("P", "1");
        addGoto(retornando);
        addLabel(exp1);

        String contador = addTemp();
        addExp(contador, "1", "", "");
        String elevado = addTemp();
        addExp(elevado, "1", "", "");

        addLabel(continuando);
        newIF(contador, "<=", exponente, condicional);
        addGoto(salida);
        addLabel(condicional);

        String tmp2 = addTemp();
        addExp(tmp2, elevado, "*", base);
        addExp(elevado, tmp2, "", "");
        setStack(tmpP, tmp2);

        addExp(contador, contador, "+", "1");

        addGoto(continuando);
        addLabel(salida);

        tmp = addTemp();
        getStack(tmp, tmpP) ;
        setStack("P", tmp);

        addGoto(retornando);
        addLabel(retornando);

        endFun();
        inNatives = false;
    }
}