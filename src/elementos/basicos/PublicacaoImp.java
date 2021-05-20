
package elementos.basicos;

import java.util.ArrayList;

public class PublicacaoImp extends Publicacao{

    public PublicacaoImp(String titulo, String conteudo, String categoria, String identificacao, String CTPSJornalista, String situacao, String tipo) {
        super(titulo, conteudo, categoria, identificacao, CTPSJornalista, situacao, tipo);
    }
    
    

    public PublicacaoImp(String identificacao) {
        super(identificacao);
    }
 
    
 
}
