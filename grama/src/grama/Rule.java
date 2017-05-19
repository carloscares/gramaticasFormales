package grama;


/**
 *
 * @author icc316
 */
public class Rule {
    private String ant; //antecedente
    private String con; //consecuente
    
    //Matias Gutierrez Constructor Regla
    public Rule(String antecedente, String consecuente) {
    this.ant = antecedente;
    this.con = consecuente;
    }
    
    //Marcos Pinilla rule.show
    public String show(){
      return ant + "->" + con;
    }
    
    //Marcos Pinilla rule.hasAntecedent(expresion)
    public boolean hasAntecedent (String expresion){
          return expresion.matches(".*"+ant+".*");
    }

    
    /* Tiene un problema porque sólo considera el 
       antecedente de largo 1.
    //Marcos Pinilla Rule.applicationPoints(expresion)
    public int[] applicationPoints (String expresion){
          char ante = ant.charAt(0);
          int[] posiciones = new int[expresion.length()];
          String pos="";
          if(hasAntecedent(expresion)){
                 char[] exp= expresion.toCharArray();
                 for(int i=0;i<expresion.length();i++){
                        if(exp[i]== ante){
                               for(int j=1;j<posiciones.length;j++){
                                        posiciones[j] = i;
                               }
                        }
                 }
          }
           return posiciones; 
    }
    */
    
}
