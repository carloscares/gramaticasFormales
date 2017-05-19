package grama;
/**
 *
 * @author curso icc316
 */

public class Gramma {
    private char[] terminal;
    private char[] noterminal;
    private char inicial;
    private Rule[] regla;
    
    
    // las reglas vienes separadas por , y un = en lugar de ->
    // por ejemplo A->abcA es A=abcA
    
    // Fabian Mariqueo

    public Gramma(String term, String reglas, String inicial_){
        this.terminal=term.toCharArray();
        String [] reg = reglas.split(",");
        this.regla = new Rule[reg.length];
        //Guardar todas las reglas en un arreglo aparte
        for (int i = 0; i < reg.length; i++) {
            String aux[]=reg[i].split("=");
            //Guardar el antecedente y el consecuente
            this.regla[i]= new Rule(aux[0],aux[1]);
            }
        //parte nueva ...
        this.setNonTerminal(term, reglas);
        this.inicial= inicial_.charAt(0); 
    }
    
    //Felipe Acuña
    //Modificado por Carlos Cares 19 May.
    public String formalShow(){
        String tupla = "<{" + escribirConComas(this.terminal) + "},{";
        tupla += escribirConComas(this.noterminal) + "}," + this.inicial + ",{"; 
        tupla += this.regla[0].show();
        for (int i = 1; i < this.regla.length ; i++) {
            tupla += "," + this.regla[i].show();
        }
        return tupla += "}>";
    }
    
    //Felipe Acuña
    // Corregido por Carlos Cares el caso que elementos==null; retornará "" (19May)
    //Retorna un arreglo de carácteres como un String separado por comas
    private String escribirConComas(char[] elementos){
        String result="";
        if (elementos!=null){
            if (elementos.length!=0){
                result = String.valueOf(elementos[0]);
                for (int i = 1; i < elementos.length; i++) { //Concatena elementos
                    result += "," + elementos[i];
                }
            }
        }
        return result;
    }
    
    // Carlos Cares
    // Obtieneno terminales no repetidos
    public void setNonTerminal(String terminales, String reglas) {
        String noTerminales = "";
        String tabu = terminales + "=,";
        char va;
        for (int i=0; i<reglas.length();i++){
            va = reglas.charAt(i);
            if (!tabu.contains(""+va)) {
                noTerminales += ""+va;
                tabu += ""+va;
            }
        }
        this.noterminal = noTerminales.toCharArray();
    }
}