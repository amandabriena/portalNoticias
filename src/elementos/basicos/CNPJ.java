package elementos.basicos;
import excessoes.NumeroCNPJInvalido;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CNPJ {
    private String numero;

    public CNPJ(String numero) throws NumeroCNPJInvalido{
        if(validar(numero)) this.numero = numero;
        else throw new NumeroCNPJInvalido();
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) throws NumeroCNPJInvalido{
        if (validar(numero)) this.numero = numero;
       else throw new NumeroCNPJInvalido();
    }
    public boolean validar(String numero){
        Pattern padrao = Pattern.compile("\\d\\d.\\d\\d\\d.\\d\\d\\d/\\d\\d\\d\\d-\\d\\d");
        Matcher teste = padrao.matcher(numero);
        return teste.matches();
    }
}
