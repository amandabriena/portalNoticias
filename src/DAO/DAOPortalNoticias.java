package DAO;
/*Equipe: Amanda Briena Batista Flores da Cunha
          ´Vinícius Cardoso de Melo
           Maise Araújo Alves*/
import elementos.basicos.Anunciante;
import elementos.basicos.Anuncio;
import elementos.basicos.AnuncioDigital;
import elementos.basicos.Cliente;
import elementos.basicos.ClienteDigital;
import elementos.basicos.ClienteFisico;
import elementos.basicos.Comentario;
import elementos.basicos.Funcionario;
import elementos.basicos.Jornalista;
import elementos.basicos.Mediador;
import elementos.basicos.PortalNoticias;
import elementos.basicos.Publicacao;
import elementos.basicos.PublicacaoDig;
import excessoes.FuncionarioJaCadastrado;
import excessoes.JaCadastrado;
import excessoes.NaoExiste;
import excessoes.NumeroCNPJInvalido;
import excessoes.NumeroCTPSInvalido;
import excessoes.anuncioDeOutroCarater;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOPortalNoticias implements InterfaceDAOPortalNoticias {

    private ArrayList<PortalNoticias> portalNoticias = new ArrayList<>();

    @Override
    public void cadastrarPortalNoticias(PortalNoticias pn) {
        if (!portalNoticias.contains(pn)) {
            portalNoticias.add(pn);
        }
    }

    @Override
    public void removerPortalNoticias(PortalNoticias pn) {
        if (portalNoticias.contains(pn)) {
            portalNoticias.remove(pn);
        }
    }

    @Override
    public PortalNoticias buscarPortalNoticias(String CNPJ) {
        for (PortalNoticias pn : portalNoticias) {
            if (pn.getCNPJ().equals(CNPJ)) {
                return pn;
            }
        }
        return null;
    }

    @Override
    public void atualizarPortalNoticias(PortalNoticias pn) {
        int indice = portalNoticias.indexOf(pn);
        if (indice >= 0) {
            portalNoticias.remove(indice);
            portalNoticias.add(pn);
        }
    }

    @Override
    public void cadastrarFuncionario(String CNPJ, Funcionario funcionario) throws JaCadastrado {
        PortalNoticias portalCadastro = buscarPortalNoticias(CNPJ);
        if (portalCadastro != null) {
            try {
                portalCadastro.cadastrarFuncionario(funcionario);
            } catch (FuncionarioJaCadastrado ex) {
                throw new JaCadastrado();
            }
        }
    }

    @Override
    public void removerFuncionario(String CNPJ, Funcionario funcionario) throws NaoExiste {
        PortalNoticias portalRemocao = buscarPortalNoticias(CNPJ);
        if (portalRemocao != null) {
            try {
                portalRemocao.removerFuncionario(funcionario);
            } catch (NaoExiste ex) {
                throw new NaoExiste();
            } catch (NumeroCTPSInvalido ex) {
            }

        }
    }

    @Override
    public Funcionario buscarFuncionario(String CNPJ, String CTPS) throws NaoExiste {
        PortalNoticias portalBusca = buscarPortalNoticias(CNPJ);
        if (portalBusca != null) {
            try {
                return portalBusca.buscarFuncionario(CTPS);
            } catch (NumeroCTPSInvalido ex) {
            } catch (NaoExiste ex) {
                throw new NaoExiste();
            }
        }
        return null;
    }

    @Override
    public void atualizarFuncionario(String CNPJ, Funcionario funcionario) throws NaoExiste {
        PortalNoticias portalAtualizacao = buscarPortalNoticias(CNPJ);
        if (portalAtualizacao != null) {
            try {
                portalAtualizacao.atualizarFuncionario(funcionario);
            } catch (NumeroCTPSInvalido | FuncionarioJaCadastrado ex) {
            } catch (NaoExiste ex) {
                throw new NaoExiste();
            }
        }

    }

    @Override
    public void cadastrarAnunciante(String CNPJ, Anunciante anunciante) throws JaCadastrado {
        PortalNoticias portalCadastro = buscarPortalNoticias(CNPJ);
        if (portalCadastro != null) {
            try {
                portalCadastro.cadastrarAnunciante(anunciante);
            } catch (JaCadastrado ex) {
                throw new JaCadastrado();
            }

        }
    }

    @Override
    public void removerAnunciante(String CNPJ, Anunciante anunciante) throws NaoExiste {
        PortalNoticias portalRemocao = buscarPortalNoticias(CNPJ);
        if (portalRemocao != null) {
            try {
                portalRemocao.removerAnunciante(anunciante);
            } catch (NumeroCNPJInvalido ex) {
                System.out.println("Erro");
            }
        }
    }

    @Override
    public Anunciante buscarAnunciante(String CNPJ, String CNPJAnunciante) throws NaoExiste {
        PortalNoticias portalBusca = buscarPortalNoticias(CNPJ);
        if (portalBusca != null) {
            try {
                return portalBusca.buscarAnunciante(CNPJAnunciante);
            } catch (NumeroCNPJInvalido ex) {
            } catch (NaoExiste ex) {
                throw new NaoExiste();
            }

        }
        return null;
    }

    @Override
    public void atualizarAnunciante(String CNPJ, Anunciante anunciante) throws NaoExiste {
        PortalNoticias portalAtualizacao = buscarPortalNoticias(CNPJ);
        if (portalAtualizacao != null) {
            try {
                portalAtualizacao.atualizarAnunciante(anunciante);
            } catch (NumeroCNPJInvalido ex) {
            } catch (JaCadastrado ex) {
            }

        }
    }

    @Override
    public void cadastrarCliente(String CNPJ,
            Cliente cliente) throws JaCadastrado {
        PortalNoticias portalCadastro = buscarPortalNoticias(CNPJ);
        if (portalCadastro != null) {
            try {
                portalCadastro.cadastrarCliente(cliente);
            } catch (JaCadastrado ex) {
                throw new JaCadastrado();
            }
        }
    }

    @Override
    public void removerCliente(String CNPJ,
            Cliente cliente) throws NaoExiste {
        PortalNoticias portalRemocao = buscarPortalNoticias(CNPJ);
        if (portalRemocao != null) {
            portalRemocao.removerCliente(cliente);
        }
    }

    @Override
    public void atualizarCliente(String CNPJ,
            Cliente cliente) throws NaoExiste {
        PortalNoticias portalAtualizacao = buscarPortalNoticias(CNPJ);
        if (portalAtualizacao != null) {
            try {
                portalAtualizacao.atualizarCliente(cliente);
            } catch (JaCadastrado ex) {
                System.out.println("Erro");
            }
        }
    }

    @Override
    public void cadastrarAnuncio(String CNPJ, String CNPJAnunciante, Anuncio anuncioNovo)
            throws NumeroCNPJInvalido, NaoExiste, JaCadastrado {
        PortalNoticias portalCadastro = buscarPortalNoticias(CNPJ);
        if (portalCadastro != null) {
            try {
                Anunciante anunciante = portalCadastro.buscarAnunciante(CNPJAnunciante);
                if (anunciante != null) {
                    anunciante.cadastrarAnuncio(anuncioNovo);
                } else {
                    throw new NumeroCNPJInvalido();
                }
            } catch (NaoExiste ex) {
                throw new NaoExiste();
            } catch (JaCadastrado ex) {
                throw new JaCadastrado();
            }

        }
    }

    @Override
    public void removerAnuncio(String CNPJ, Anuncio anuncio) {
        PortalNoticias portalRemocao = buscarPortalNoticias(CNPJ);
        if (portalRemocao != null) {
            ArrayList<Anunciante> anuncs = portalRemocao.getAnunciantes();
            for (Anunciante anunciante : anuncs) {
                ArrayList<Anuncio> anunciosA = anunciante.getAnuncios();
                if (anunciosA.contains(anuncio)) {
                    try {
                        anunciante.removerAnuncio(anuncio);
                    } catch (NaoExiste ex) {
                        System.out.println("Erro");
                    }
                }
            }
        }
    }

    @Override
    public void atualizarAnuncio(String CNPJ, Anuncio anuncioAtu) {
        PortalNoticias portalAtu = buscarPortalNoticias(CNPJ);
        if (portalAtu != null) {
            ArrayList<Anunciante> anuncs = portalAtu.getAnunciantes();
            for (Anunciante anunciante : anuncs) {
                ArrayList<Anuncio> anunciosA = anunciante.getAnuncios();
                if (anunciosA.contains(anuncioAtu)) {
                    try {
                        anunciante.atualizarAnuncio(anuncioAtu);
                    } catch (NaoExiste | JaCadastrado ex) {
                        System.out.println("Erro");
                    }
                }
            }
        }
    }

    @Override
    public Anuncio buscarAnuncio(String CNPJ, String identificador) throws NaoExiste {
        PortalNoticias portalBusca = buscarPortalNoticias(CNPJ);
        if (portalBusca != null) {
            ArrayList<Anunciante> anuncs = portalBusca.getAnunciantes();
            for (Anunciante anunciante : anuncs) {
                ArrayList<Anuncio> anunciosA = anunciante.getAnuncios();
                Anuncio anuncioBuscado = anunciante.buscarAnuncio(identificador);
                if (anuncioBuscado != null) {
                    return anuncioBuscado;
                }
            }
        }
        return null;
    }

    @Override
    public void cadastrarPublicacao(String CNPJ, String CTPS, Publicacao pubNova) throws JaCadastrado {
        PortalNoticias portalCadastro = buscarPortalNoticias(CNPJ);
        if (portalCadastro != null) {
            try {
                Funcionario func = portalCadastro.buscarFuncionario(CTPS);
                if (func instanceof Jornalista) {
                    ((Jornalista) func).cadastrarPublicacao(pubNova);
                    portalCadastro.cadastrarPublicacao(pubNova);
                }
            } catch (JaCadastrado ex) {
                throw new JaCadastrado();
            } catch (NumeroCTPSInvalido ex) {
                Logger.getLogger(DAOPortalNoticias.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NaoExiste ex) {
                Logger.getLogger(DAOPortalNoticias.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    @Override
    public void removerPublicacao(String CNPJ, Publicacao pub) {
        PortalNoticias portalRemocao = buscarPortalNoticias(CNPJ);
        if (portalRemocao != null) {
            try {
                portalRemocao.removerPublicacao(pub);
            } catch (NaoExiste ex) {
                System.out.println("Erro");
            }
        }
    }

    @Override
    public void atualizarPublicacao(String CNPJ, Publicacao pubAtu) {
        PortalNoticias portalAtu = buscarPortalNoticias(CNPJ);
        if (portalAtu != null) {
            try {
                portalAtu.atualizarPublicacao(pubAtu);
            } catch (NaoExiste | JaCadastrado ex) {
                System.out.println("Erro");
            }
        }
    }

    @Override
    public Publicacao buscarPublicacao(String CNPJ, String identificacao) throws NaoExiste {
        PortalNoticias portalBusca = buscarPortalNoticias(CNPJ);
        if (portalBusca != null) {
            try {
                return portalBusca.buscarPublicacao(identificacao);
            } catch (NaoExiste ex) {
                throw new NaoExiste();
            }
        }
        return null;
    }

    //busca de cliente no qual o boolean id será true se o cliene for digital
    @Override
    public Cliente buscarCliente(String CNPJ, String login, boolean id) {
        PortalNoticias portalBusca = buscarPortalNoticias(CNPJ);
        if (portalBusca != null) {
            return portalBusca.buscarCliente(login, id);
        }
        return null;
    }

    @Override
    public void cadastrarPub(String CNPJ, Publicacao pub) {
        PortalNoticias portal = buscarPortalNoticias(CNPJ);
        if (portal != null) {
            try {
                portal.cadastrarPublicacao(pub);
            } catch (JaCadastrado ex) {

            }
        }
    }

    @Override
    public float calcularValorAnunciosAnunciante(String CNPJ, Anunciante anunciante) throws NaoExiste {
        PortalNoticias portal = buscarPortalNoticias(CNPJ);
        if (portal != null) {
            return portal.calcularValorAnunciosAnunciante(anunciante);
        } else {
            return -1;
        }
    }

    @Override
    public float calcularPagamentoFuncionarios(String CNPJ) {
        PortalNoticias portal = buscarPortalNoticias(CNPJ);
        if (portal != null) {
            return portal.calcularPagamentoFuncionarios();
        } else {
            return -1;
        }
    }

    @Override
    public boolean validarAcesso(String CNPJ, String login, String senha, String tipo) throws NaoExiste, NumeroCTPSInvalido, NumeroCNPJInvalido {
        PortalNoticias portal = buscarPortalNoticias(CNPJ);
        if (portal != null) {
            try {
                return portal.validarLogin(tipo, login, senha);
            } catch (NumeroCTPSInvalido ex) {
                throw new NumeroCTPSInvalido();
            } catch (NaoExiste ex) {
                throw new NaoExiste();
            } catch (NumeroCNPJInvalido ex) {
                throw new NumeroCNPJInvalido();
            }
        }
        return false;
    }

    @Override
    public ArrayList<Publicacao> retornarPubs(String CNPJ, String tipo) {
        PortalNoticias portal = buscarPortalNoticias(CNPJ);
        if (portal != null) {
            return portal.listarPublicacoes(tipo);
        }
        return null;
    }

    @Override
    public ArrayList<Publicacao> retornarPubsCliente(String CNPJ) {
        PortalNoticias portal = buscarPortalNoticias(CNPJ);
        if (portal != null) {
            return portal.listarPublicacoesCliente();
        }
        return null;
    }

    @Override
    public ArrayList<Publicacao> retornarPubsJornalista(String CNPJ, String CTPS) {
        PortalNoticias portal = buscarPortalNoticias(CNPJ);
        if (portal != null) {
            return portal.listarMinhasPublicacoes(CTPS);
        }
        return null;
    }

    @Override
    public ArrayList<Publicacao> retornarTodasPubs(String CNPJ) {
        PortalNoticias portal = buscarPortalNoticias(CNPJ);
        if (portal != null) {
            return portal.getPublicacoes();
        }
        return null;
    }

    @Override
    public ArrayList<ClienteDigital> retornarClientesDig(String CNPJ) {
        PortalNoticias portal = buscarPortalNoticias(CNPJ);
        ArrayList<Cliente> clientes = portal.getClientes();
        ArrayList<ClienteDigital> clientesDig = new ArrayList();
        if (portal != null) {
            for (Cliente cl : clientes) {
                if (cl instanceof ClienteDigital) {
                    clientesDig.add((ClienteDigital) cl);
                }
            }
            return clientesDig;
        }
        return null;
    }

    @Override
    public ArrayList<ClienteFisico> retornarClientesFis(String CNPJ) {
        PortalNoticias portal = buscarPortalNoticias(CNPJ);
        ArrayList<Cliente> clientes = portal.getClientes();
        ArrayList<ClienteFisico> clientesFis = new ArrayList();
        if (portal != null) {
            for (Cliente cl : clientes) {
                if (cl instanceof ClienteFisico) {
                    clientesFis.add((ClienteFisico) cl);
                }
            }
            return clientesFis;
        }
        return null;
    }

    @Override
    public ArrayList<Anunciante> retornarAnunciantes(String CNPJ) {
        PortalNoticias portal = buscarPortalNoticias(CNPJ);
        if (portal != null) {
            return portal.getAnunciantes();
        }
        return null;
    }

    @Override
    public ArrayList<Funcionario> retornarFuncionarios(String CNPJ) {
        PortalNoticias portal = buscarPortalNoticias(CNPJ);
        if (portal != null) {
            return portal.getFuncionarios();
        }
        return null;
    }

    @Override
    public ArrayList<Anuncio> retornarAnuncios(String CNPJ) {
        PortalNoticias portal = buscarPortalNoticias(CNPJ);
        if (portal != null) {
            return portal.anunciosPortal();
        }
        return null;
    }

    @Override
    public String retornarComentarios(String CNPJ, PublicacaoDig pub) {
        PortalNoticias portal = buscarPortalNoticias(CNPJ);
        if (portal != null) {
            return portal.retornarComentarios(pub);
        }
        return null;
    }

    @Override
    public void fazerComentario(String CNPJ, Comentario comentario) throws NaoExiste {
        PortalNoticias portal = buscarPortalNoticias(CNPJ);
        if (portal != null) {
            portal.fazerComentario(comentario);

        }
    }

    @Override
    public boolean acessarPub(String CNPJ, String login, PublicacaoDig pub) {
        PortalNoticias portal = buscarPortalNoticias(CNPJ);
        if (portal != null) {
            boolean estadoPub = ((PublicacaoDig) pub).isEstado();
            if (!estadoPub) {
                return true;
            } else {
                if(login!=null){
                    Cliente c = buscarCliente(CNPJ, login, true);
                    if(((ClienteDigital)c).isSituacao()){
                        return true;
                    }else return false;
                }else{
                    return false;
                }
            }
        }
        return false;
    }

    @Override
    public void mudarSitucaoPub(String CNPJ, Publicacao pub, String situacao, int peso, boolean paga) {
        PortalNoticias portal = buscarPortalNoticias(CNPJ);
        if (portal != null) {
            try {
                portal.mudarSituacaoPub(pub, situacao, peso, paga);
            } catch (NaoExiste ex) {

            }
        }
    }

    @Override
    public void avaliacaoChefe(String CNPJ, String CTPS, Publicacao pub) {
        PortalNoticias portal = buscarPortalNoticias(CNPJ);
        if (portal != null) {
            try {
                Funcionario chefe = buscarFuncionario(CNPJ, CTPS);
                portal.avaliacaoChefe(chefe, pub);
            } catch (NaoExiste ex) {
                Logger.getLogger(DAOPortalNoticias.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public ArrayList<Publicacao> retornarPubsChefe(String CNPJ, String CTPS) {
        PortalNoticias portal = buscarPortalNoticias(CNPJ);
        if (portal != null) {
            try {
                Funcionario fun = portal.buscarFuncionario(CTPS);
                return portal.retornarPublicacoesChefe(fun);
            } catch (NumeroCTPSInvalido ex) {
                Logger.getLogger(DAOPortalNoticias.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NaoExiste ex) {
                Logger.getLogger(DAOPortalNoticias.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return null;
    }

    @Override
    public void contabilizarErros(String CNPJ, String CTPS, int qtErros) throws NumeroCTPSInvalido, NaoExiste {
        PortalNoticias portal = buscarPortalNoticias(CNPJ);
        if (portal != null) {
            Funcionario revisor = portal.buscarFuncionario(CTPS);
            portal.contabilizarErros(revisor, qtErros);
        }
    }

    @Override
    public void contabilizarVisualizacoes(String CNPJ, PublicacaoDig pub) {
        PortalNoticias portal = buscarPortalNoticias(CNPJ);
        if (portal != null) {
            try {
                Publicacao p = buscarPublicacao(CNPJ, pub.getIdentificacao());
                portal.contabilizarVisu((PublicacaoDig) p);
            } catch (NaoExiste ex) {

            }
        }
    }

    @Override
    public void desaprovarCmImproprio(String CNPJ, String CTPSMed, Comentario comentario) {
        PortalNoticias portal = buscarPortalNoticias(CNPJ);
        if (portal != null) {
            try {
                Funcionario mediador = buscarFuncionario(CNPJ, CTPSMed);
                PublicacaoDig pubOrigem = comentario.getPublicacao();
                pubOrigem.removerComentario(comentario);
                ((Mediador) mediador).adicionarCmReprovado(comentario);
                ClienteDigital cl = comentario.getAutor();
                cl.setNumComentarioIrregulares(cl.getNumComentarioIrregulares() + 1);
                if (cl.getNumComentarioIrregulares() >= 3) {
                    cl.setEstado(false);
                    ((Mediador) mediador).adicionarClienteBloqueado(cl);

                }
            } catch (NaoExiste ex) {
                Logger.getLogger(DAOPortalNoticias.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    @Override
    public ArrayList<Comentario> retornarTdsComentarios(String CNPJ) {
        PortalNoticias portal = buscarPortalNoticias(CNPJ);
        if (portal != null) {
            ArrayList<Comentario> comentarios = new ArrayList();
            ArrayList<Publicacao> pbs = portal.getPublicacoes();
            for (Publicacao p : pbs) {
                ArrayList<Comentario> cm = ((PublicacaoDig) p).getComentarios();
                for (Comentario cy : cm) {
                    comentarios.add(cy);
                }
            }
            return comentarios;
        }
        return null;
    }

    @Override
    public void veicularAnuncioPub(String CNPJ, Anuncio an, Publicacao pub) throws anuncioDeOutroCarater, JaCadastrado {
        PortalNoticias portal = buscarPortalNoticias(CNPJ);
        if (portal != null) {
            portal.veicularAnuncioPublicacao(an, pub);
        }
    }

    @Override
    public float calcularValorAnuncio(String CNPJ, Anuncio an) throws NaoExiste {
        PortalNoticias portal = buscarPortalNoticias(CNPJ);
        if (portal != null) {
            return portal.calcularValorAnuncio(an);
        }
        return 0;
    }

    @Override
    public ArrayList<Anuncio> retornarAnunciosAnunciante(String CNPJ, String CNPJA) {
        PortalNoticias portal = buscarPortalNoticias(CNPJ);
        if (portal != null) {
            try {
                Anunciante a = portal.buscarAnunciante(CNPJA);
                return a.getAnuncios();
            } catch (NumeroCNPJInvalido ex) {
                Logger.getLogger(DAOPortalNoticias.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NaoExiste ex) {
                Logger.getLogger(DAOPortalNoticias.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return null;
    }

    @Override
    public void novoCliqueAnuncio(String CNPJ, Publicacao p, String idAnuncio) {
        PortalNoticias portal = buscarPortalNoticias(CNPJ);
        if (portal != null) {
            try {
                portal.buscarPublicacao(p.getIdentificacao());
                ArrayList<Anuncio> anuncios = p.getAnuncios();
                for (Anuncio a : anuncios) {
                    if(a.getIdentificacao().equals(idAnuncio)){
                        ((AnuncioDigital)a).setNumCliques(((AnuncioDigital)a).getNumCliques()+1);
                    }
                }
            } catch (NaoExiste ex) {
                Logger.getLogger(DAOPortalNoticias.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    @Override
    public void contabilizarVisuAnuncio(String CNPJ, String idAnuncio, String idPub) {
        PortalNoticias portal = buscarPortalNoticias(CNPJ);
        if (portal != null) {
            try {
                Publicacao p = buscarPublicacao(CNPJ, idPub);
                Anuncio an = p.buscarAnuncio(idAnuncio);
                ((AnuncioDigital)an).setNumVisualizacoes(((AnuncioDigital)an).getNumVisualizacoes()+1);
            } catch (NaoExiste ex) {
                Logger.getLogger(DAOPortalNoticias.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @Override
    public Publicacao retornarPubAnuncio(String CNPJ, Anuncio an){
        PortalNoticias portal = buscarPortalNoticias(CNPJ);
        if (portal != null) {
            ArrayList <Publicacao> pubsPortal = portal.getPublicacoes();
            for(Publicacao p : pubsPortal){
                ArrayList <Anuncio> anunciosP = p.getAnuncios();
                for(Anuncio a : anunciosP){
                    if(a.equals(an)){
                        return p;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public float calcularValorArrecadacaoAnuncios(String CNPJ) {
        PortalNoticias portal = buscarPortalNoticias(CNPJ);
        if (portal != null) {
            try {
                return portal.calcularValorAnunciantes();
            } catch (NaoExiste ex) {
                Logger.getLogger(DAOPortalNoticias.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0;
    }

    @Override
    public float calcularValorArrecadacaoCDigitais(String CNPJ) {
        PortalNoticias portal = buscarPortalNoticias(CNPJ);
        if (portal != null) {
            int contadorPagantes = 0;
            ArrayList<Cliente> clientesPortal = portal.getClientes();
            for(Cliente c : clientesPortal){
                if(c instanceof ClienteDigital){
                    if(((ClienteDigital)c).isSituacao() && c.isPagamentoEmDia()) 
                        contadorPagantes = contadorPagantes+1;
                }
            }
            return ClienteDigital.getValorAssinatura()*contadorPagantes;
        }
        return 0;
    }

    @Override
    public float calcularValorAssinaturasFisicas(String CNPJ) {
        PortalNoticias portal = buscarPortalNoticias(CNPJ);
        if (portal != null) {
            int contador = 0;
            ArrayList<Cliente> clientesPortal = portal.getClientes();
            for(Cliente c : clientesPortal){
                if(c instanceof ClienteFisico && c.isPagamentoEmDia()) contador = contador +1;
            return ClienteDigital.getValorAssinatura()*contador;
        }
    }
        return 0;
    }
}
