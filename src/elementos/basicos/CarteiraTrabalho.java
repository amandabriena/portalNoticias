package elementos.basicos;
import excessoes.NumeroCTPSInvalido;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CarteiraTrabalho {
    private String numero;
    
    
    public CarteiraTrabalho(String numero)throws NumeroCTPSInvalido{
        if(validar(numero)) this.numero = numero;
        else throw new NumeroCTPSInvalido();
    }
    
    public String getNumero(){
        return numero;
    }
    public void setNumero(String numero) throws NumeroCTPSInvalido{
       if (validar(numero)) this.numero = numero;
       else throw new NumeroCTPSInvalido();
    }
    
    public boolean validar(String numero){
        Pattern padrao = Pattern.compile("\\d\\d\\d.\\d\\d\\d\\d\\d.\\d\\d-\\d");
        Matcher teste = padrao.matcher(numero);
        return teste.matches();
    }
}
