package elementos.basicos;

import Utilitario.GeradorCodigos;
import excessoes.FuncionarioJaCadastrado;
import excessoes.JaCadastrado;
import excessoes.NaoExiste;
import excessoes.NumeroCNPJInvalido;
import excessoes.NumeroCTPSInvalido;
import excessoes.anuncioDeOutroCarater;
import excessoes.clienteBloqueado;
import java.util.ArrayList;
import java.util.Date;

public class PortalNoticias {

    private String nome;
    private String CNPJ;
    private ArrayList<Funcionario> funcionarios;
    private ArrayList<Anunciante> anunciantes;
    private ArrayList<Cliente> clientes;
    private ArrayList<Publicacao> publicacoes;

    public PortalNoticias() {
        funcionarios = new ArrayList<Funcionario>();
        anunciantes = new ArrayList<Anunciante>();
        clientes = new ArrayList<Cliente>();
        publicacoes = new ArrayList<Publicacao>();
    }

    public PortalNoticias(String CNPJ) {
        this.CNPJ = CNPJ;
        funcionarios = new ArrayList<Funcionario>();
        anunciantes = new ArrayList<Anunciante>();
        clientes = new ArrayList<Cliente>();
        publicacoes = new ArrayList<Publicacao>();
    }
    
    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public ArrayList<Anunciante> getAnunciantes() {
        return anunciantes;
    }

    public void setAnunciantes(ArrayList<Anunciante> anunciantes) {
        this.anunciantes = anunciantes;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Publicacao> getPublicacoes() {
        return publicacoes;
    }

    public void setPublicacoes(ArrayList<Publicacao> publicacoes) {
        this.publicacoes = publicacoes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }
    public boolean validarLogin(String tipo, String login, String senha) throws NumeroCTPSInvalido, NaoExiste, NumeroCNPJInvalido{
        boolean acesso = false;
        if(null != tipo)switch (tipo) {
            case "funcionario":
                Funcionario func = buscarFuncionario(login);
                if(func != null){
                    if(func.getSenha().equals(senha)){
                        acesso = true;
                    }
                }
                break;
            case "cliente":
                Cliente cliente = buscarCliente(login, true);
                if(cliente != null){
                    if(cliente.getSenha().equals(senha)){
                        acesso = true;
                    }
                }   break;
            case "anunciante":
                Anunciante anunc = buscarAnunciante(login);
                if(anunc != null){
                    if(anunc.getSenha().equals(senha)){
                        acesso = true;
                    }
                }   break;
            default:
                break;
        }
        return acesso;
    }
    
    //Identificador será true se o cliente for digital, caso contrário será false   
    public void atualizarCliente(Cliente clienteAtu) throws NaoExiste, JaCadastrado{
        if(clienteAtu instanceof ClienteDigital){
            Cliente cliente;
            cliente = buscarCliente(((ClienteDigital) clienteAtu).getLogin(),true);
            if (cliente != null) {
                removerCliente(clienteAtu);
                cadastrarCliente(cliente);
            } else throw new NaoExiste();
        }else{
            Cliente cliente = buscarCliente(((ClienteFisico) clienteAtu).getCPF(),false);
            if (cliente != null) {
                removerCliente(clienteAtu);
                cadastrarCliente(cliente);
            } else throw new NaoExiste();
        }
        
    }
    
    
    // Identificador vai ser igual a true se o cliente buscado for digital, caso contrário, será false;
    public Cliente buscarCliente(String busca, boolean identificador) {
        if(identificador){
            ClienteDigital clienteBuscado = new ClienteDigital(busca, "nome", "senha");
            int indice = clientes.indexOf(clienteBuscado);
        if (indice >= 0) {
            return clientes.get(indice);
        } else {
            return null;
        }
        }else{
            ClienteFisico clienteBuscado = new ClienteFisico(busca, "nome", "senha");
            int indice = clientes.indexOf(clienteBuscado);
        if (indice >= 0) {
            return clientes.get(indice);
        } else {
            return null;
        }
        }
    }
    
   public void removerCliente(Cliente cliente) throws NaoExiste {
        if (clientes.contains(cliente)) {
            clientes.remove(cliente);
        } else {
            throw new NaoExiste();
        }
    }
    
    public float calcularValorAnunciantes() throws NaoExiste{
        float total = 0;
        for(Anunciante anunciante : anunciantes){
        total = total + calcularValorAnunciosAnunciante(anunciante);
    }
        return total;
    }
    
    public void cadastrarFuncionario(Funcionario funcionarioNovo) throws FuncionarioJaCadastrado {
        if(!funcionarios.contains(funcionarioNovo)){
            funcionarios.add(funcionarioNovo);
        }else throw new FuncionarioJaCadastrado();
    }
    
    public Funcionario buscarFuncionario(String CTPS) throws NumeroCTPSInvalido, NaoExiste{
        try{
        CarteiraTrabalho ct = new CarteiraTrabalho(CTPS);
        Funcionario funcionarioBuscado = new Funcionario(ct);
        int indice = funcionarios.indexOf(funcionarioBuscado);
        if (indice >= 0) {
            return funcionarios.get(indice);
        } else throw new NaoExiste();
        }catch (NumeroCTPSInvalido e){
            throw new NumeroCTPSInvalido();
        }
    }

    public void removerFuncionario(Funcionario func) throws NaoExiste, NumeroCTPSInvalido {
        if (funcionarios.contains(func)) {
            funcionarios.remove(func);
        } else {
            throw new NaoExiste();
        }
    }

    public void atualizarFuncionario(Funcionario funcNovo) throws NaoExiste, NumeroCTPSInvalido, FuncionarioJaCadastrado {
        Funcionario funcionario = buscarFuncionario(funcNovo.getCarteiraTrabalho().getNumero());
        if (funcionario != null) {
            removerFuncionario(funcNovo);
            cadastrarFuncionario(funcionario);
        } else throw new NaoExiste();
    }

    public void cadastrarCliente(Cliente clienteNovo) throws JaCadastrado {
        if(!clientes.contains(clienteNovo)){
            clientes.add(clienteNovo);
        }else throw new JaCadastrado();
    }

    public void cadastrarAnunciante(Anunciante anuncianteNovo) throws JaCadastrado {
        if(!anunciantes.contains(anuncianteNovo)){
            anunciantes.add(anuncianteNovo);
        }else throw new JaCadastrado();
    }

    public Anunciante buscarAnunciante(String CNPJ) throws NumeroCNPJInvalido, NaoExiste {
        try{
            Anunciante anuncianteBuscado = new Anunciante(new CNPJ(CNPJ));
        int indice = anunciantes.indexOf(anuncianteBuscado);
        if (indice >= 0) {
            return anunciantes.get(indice);
        } else throw new NaoExiste();
        }catch(NumeroCNPJInvalido e){
            throw new NumeroCNPJInvalido();
        }
    }
    public void removerAnunciante(Anunciante anunciante) throws NaoExiste, NumeroCNPJInvalido{
       if (anunciantes.contains(anunciante)) {
            anunciantes.remove(anunciante);
        } else throw new NaoExiste();
    }
    public void atualizarAnunciante(Anunciante anuncianteAtu) throws NaoExiste, NumeroCNPJInvalido, JaCadastrado{
        Anunciante anunciante = buscarAnunciante(anuncianteAtu.getCNPJ().getNumero());
        if (anunciante != null) {
            removerAnunciante(anuncianteAtu);
            cadastrarAnunciante(anunciante);
        } else throw new NaoExiste();
    }
    public void cadastrarPublicacao(Publicacao publicacao) throws JaCadastrado{
        if (!publicacoes.contains(publicacao)) {
                publicacoes.add(publicacao);
                String identificacao = GeradorCodigos.gerarCodigo();
                publicacao.setIdentificacao(identificacao);
            }else throw new JaCadastrado();
    }
    
    public void removerPublicacao(Publicacao pub) throws NaoExiste{
        if (publicacoes.contains(pub)) {
            publicacoes.remove(pub);
        } else throw new NaoExiste();
    }
    
    public Publicacao buscarPublicacao(String identificacao) throws NaoExiste{
        Publicacao pubBuscada = new Publicacao(identificacao);
        int indice = publicacoes.indexOf(pubBuscada);
        if (indice >= 0) {
            return publicacoes.get(indice);
        } else throw new NaoExiste();

    }
    
    public void atualizarPublicacao(Publicacao pubAtu) throws NaoExiste, JaCadastrado{
        Publicacao pub = buscarPublicacao(pubAtu.getIdentificacao());
        if(pub != null){
            pub.setTitulo(pubAtu.getTitulo());
            pub.setConteudo(pubAtu.getConteudo());
        }
    }
    //Método adiciona um Anúncio à uma Publicação se ambos forem de mesmo caráter
    public void veicularAnuncioPublicacao(Anuncio anuncio, Publicacao pub) throws JaCadastrado, anuncioDeOutroCarater{
        if(anuncio instanceof AnuncioDigital){
            if(pub instanceof PublicacaoDig){
                pub.adicionarAnuncio(anuncio);                
            }else throw new anuncioDeOutroCarater();
            
        }else if (anuncio instanceof AnuncioImpresso){
            if(pub instanceof PublicacaoImp){
                pub.adicionarAnuncio(anuncio);                
            }else throw new anuncioDeOutroCarater();
            
        }else if (anuncio instanceof AnuncioImpDig){
            pub.adicionarAnuncio(anuncio);
        }
    }
    //Método lista todas as publicações que o funcionário pode modificar
    //Ex: Para um revisor serão mostradas as publicações que já passaram pelo editor
    public ArrayList<Publicacao> listarPublicacoes(String tipo) {
        ArrayList<Publicacao> pubs = new ArrayList();
            for (Publicacao p : publicacoes) {
                if(p.getSituacao().equals(tipo)){
                    pubs.add(p);
                }            
            }
            return pubs;
}
    //Método para o jornalista ver todas as publicações escritas por ele
    public ArrayList<Publicacao> listarMinhasPublicacoes(String CTPS){
        ArrayList<Publicacao> pubs = new ArrayList();
            for (Publicacao p : publicacoes) {
                if(p.getCTPSJornalista().equals(CTPS)){
                    pubs.add(p);
                }            
            }
            return pubs;
    }
    //Metodo para listar para o Cliente Digitasl todas as publicações do portal
    public ArrayList<Publicacao> listarPublicacoesCliente(){
        ArrayList<Publicacao> pubs = new ArrayList();
            for (Publicacao p : publicacoes) {
                if(p instanceof PublicacaoDig && p.getSituacao().equals("publicada")){
                    pubs.add(p);
                }            
            }
            return pubs;
    }
    
    //Método calcula o valor de um anúncio
    public float calcularValorAnuncio(Anuncio an) throws NaoExiste{
        float valorAnuncio = 0;
        for(Publicacao pub : publicacoes){
            ArrayList<Anuncio> a = pub.getAnuncios();
            if(a.contains(an)){
                valorAnuncio = an.calcularValor(pub.getPeso());
            }
        }
        return valorAnuncio;
    }
    //Método calcula o valor total dos anúncios de um anunciante
    public float calcularValorAnunciosAnunciante(Anunciante anunciante) throws NaoExiste{
        float valor = 0;
        ArrayList<Anuncio> anuncios = anunciante.getAnuncios();
        for (Anuncio anc: anuncios){
            valor = valor + calcularValorAnuncio(anc);
        }
        if(anunciante instanceof AnunciantePrivado){
            return valor;
        }else{
            float acrescimoEsfera = 0;
            
            if (((AnunciantePublico) anunciante).getEsfera().equals("Federal")) acrescimoEsfera = 1.5f;
            if (((AnunciantePublico) anunciante).equals("Estadual")) acrescimoEsfera = 1.3f;
            else acrescimoEsfera = 1.3f;
            return valor*acrescimoEsfera;
        }
    }
    public ArrayList<Anuncio> anunciosPortal(){
        ArrayList<Anuncio> anuncios = new ArrayList();
        ArrayList<Anuncio> anunciosAn = new ArrayList();
        for(Anunciante an : anunciantes){
            anunciosAn = an.getAnuncios();
            for(Anuncio anuncio : anunciosAn){
                anuncios.add(anuncio);
            }
        }
        return anuncios;
    }
    //Método calcula o valor total do pagamento dos funcionários
    public float calcularPagamentoFuncionarios(){
        float pagamentoTotal =0;
        for(Funcionario fun : funcionarios){
            pagamentoTotal = pagamentoTotal + fun.calcularRemuneracao();
        }
        return pagamentoTotal;
    }
    
    public void fazerComentario(Comentario comentario) throws NaoExiste{
        ClienteDigital cliente = comentario.getAutor();
        PublicacaoDig pub = comentario.getPublicacao();
        if(cliente != null){
            String identificacao = GeradorCodigos.gerarCodigo();
            comentario.setIdentificacao(identificacao);
            cliente.adicionarComentario(comentario);
            pub.adicionarComentario(comentario);
        }else throw new NaoExiste();
    }
    public String retornarComentarios(PublicacaoDig pub){
        return pub.listarComentarios();
    }
    public void mudarSituacaoPub(Publicacao pub, String situacao, int peso, boolean paga) throws NaoExiste{
        Publicacao p = buscarPublicacao(pub.getIdentificacao());
        p.setSituacao(situacao);
        p.setPeso(peso);
        if(p instanceof PublicacaoDig){
            ((PublicacaoDig)p).setEstado(paga);
        }
    }

    public void avaliacaoChefe(Funcionario chefe, Publicacao pub) {
        ((ChefeRedacao) chefe).avaliarPublicacao(pub);
    }
    public ArrayList<Publicacao> retornarPublicacoesChefe(Funcionario chefe){
        return ((ChefeRedacao) chefe).getPublicacoesAvaliadas();
    }
    public void contabilizarErros(Funcionario fun, int erros){
        ((Revisor) fun).contadorErros(erros);
    }
    public void contabilizarVisu(PublicacaoDig pub) throws NaoExiste{
        PublicacaoDig pubb = (PublicacaoDig) buscarPublicacao(pub.getIdentificacao());
        pubb.setNumVisualizacoes(pubb.getNumVisualizacoes()+1);
    }
    }
