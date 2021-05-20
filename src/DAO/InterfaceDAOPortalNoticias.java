/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
/*Equipe: Amanda Briena Batista Flores da Cunha
          ´Vinícius Cardoso de Melo
           Maise Araújo Alves*/
import elementos.basicos.Anunciante;
import elementos.basicos.Anuncio;
import elementos.basicos.Cliente;
import elementos.basicos.ClienteDigital;
import elementos.basicos.ClienteFisico;
import elementos.basicos.Comentario;
import elementos.basicos.Funcionario;
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

public interface InterfaceDAOPortalNoticias {
    //Método para conferir se o login e senha informados são válidos
    public boolean validarAcesso(String CNPJ,String login, String senha, String tipo) throws NaoExiste, NumeroCTPSInvalido, NumeroCNPJInvalido;
    
    //Métodos CRUD
    public void cadastrarPortalNoticias(PortalNoticias pn);
    public void removerPortalNoticias(PortalNoticias pn);
    public PortalNoticias buscarPortalNoticias(String CNPJ);
    public void atualizarPortalNoticias(PortalNoticias pn);
    
    public void cadastrarFuncionario(String CNPJ,
            Funcionario funcionario) throws NaoExiste, JaCadastrado;    
    public void removerFuncionario(String CNPJ, 
            Funcionario funcionario) throws NaoExiste;
    public Funcionario buscarFuncionario(String CNPJ, 
            String CTPS) throws NaoExiste;
    public void atualizarFuncionario(String CNPJ, 
            Funcionario funcionario)  throws NaoExiste;
    
    public void cadastrarAnunciante(String CNPJ,
            Anunciante anunciante)throws JaCadastrado;    
    public void removerAnunciante(String CNPJ, 
            Anunciante anunciante) throws NaoExiste;
    public Anunciante buscarAnunciante(String CNPJ, 
            String CNPJAnunciante)throws NaoExiste;
    public void atualizarAnunciante(String CNPJ, 
            Anunciante anunciante) throws NaoExiste;
    
    public void cadastrarCliente(String CNPJ,
            Cliente cliente)throws JaCadastrado;    
    public void removerCliente(String CNPJ, 
            Cliente cliente) throws NaoExiste;
    public Cliente buscarCliente(String CNPJ, 
            String login, boolean id);
    public void atualizarCliente(String CNPJ, 
            Cliente cliente) throws NaoExiste;
    
    public void cadastrarAnuncio(String CNPJ, String CNPJAnunciante, 
            Anuncio anuncioNovo) throws NumeroCNPJInvalido, NaoExiste, JaCadastrado;
    public void removerAnuncio(String CNPJ,
            Anuncio anuncio);
    public void atualizarAnuncio(String CNPJ,
            Anuncio anuncioAtu);
    public Anuncio buscarAnuncio(String CNPJ, String identificador) throws NaoExiste;
    
    public void cadastrarPublicacao(String CNPJ, String CTPS, 
            Publicacao pubNova) throws JaCadastrado;
    public void removerPublicacao(String CNPJ, 
            Publicacao pub);
    public void atualizarPublicacao(String CNPJ,
            Publicacao pubAtu);
    public Publicacao buscarPublicacao(String CNPJ, String identificacao) throws NaoExiste;
    public void cadastrarPub(String CNPJ, Publicacao pub);
    
    //Métodos para cálculo do valor dos anúncios de um anunciante informado
    public float calcularValorAnunciosAnunciante(String CNPJ, Anunciante anunciante) throws NaoExiste;
    
    //Método para cálculo do valor do pagamento de todos os funcionários
    public float calcularPagamentoFuncionarios(String CNPJ);
    
    //Método para calcular o valor de um anúncio do portal
    public float calcularValorAnuncio(String CNPJ, Anuncio an) throws NaoExiste;
    
    //Método para calcular o valor total arrecadado com os anúncios do portal
    public float calcularValorArrecadacaoAnuncios(String CNPJ);
    
    //Método para calcular o valor total arrecadado com clientes digitais pagantes
    public float calcularValorArrecadacaoCDigitais(String CNPJ);
    
    //Método para calcular a arrecadação total com com assinauras físicas
    public float calcularValorAssinaturasFisicas(String CNPJ);
    
    //Métodos para retornar respectivamente as todas as publicações, as publicações 
    //acessíveis a uma determinada categoria, as produzidas pelo jornalista dono do CTPS informado, 
    //as publicações publicadas, os clientes digitais, clientes físicos, anunciantes, funcionários,
    //anúncios e comentários de uma publicação do portal de notícias
    public ArrayList<Publicacao> retornarPubs(String CNPJ, String tipo);
    public ArrayList<Publicacao> retornarPubsChefe(String CNPJ, String CTPS);
    public ArrayList<Publicacao> retornarPubsCliente(String CNPJ);
    public ArrayList<Publicacao> retornarPubsJornalista(String CNPJ, String CTPS);
    public ArrayList<Publicacao> retornarTodasPubs(String CNPJ);
    public ArrayList<ClienteDigital> retornarClientesDig(String CNPJ);
    public ArrayList<ClienteFisico> retornarClientesFis(String CNPJ);
    public ArrayList<Anunciante> retornarAnunciantes(String CNPJ);
    public ArrayList<Funcionario> retornarFuncionarios(String CNPJ);
    public ArrayList<Anuncio> retornarAnuncios(String CNPJ);
    public ArrayList<Anuncio> retornarAnunciosAnunciante(String CNPJ, String CNPJA);
    public String retornarComentarios(String CNPJ, PublicacaoDig pub);
    public ArrayList<Comentario> retornarTdsComentarios(String CNPJ);
    
    //Método que vincula um novo comentário ao cliente proprietário e a publicação na qual for feito
    public void fazerComentario(String CNPJ,Comentario comentario) throws NaoExiste;
    
    //Método para acessar uma publicação, verificando se a publicação é paga
    //caso não seja paga, o acesso é aprovado retornando true, caso contrário,
    // se o cliente requisitor for um usúario ou cliente não pagante, retorna false
    public boolean acessarPub(String CNPJ,String login, PublicacaoDig pub);
    
    //Método que muda a situação da publicação conforme informado para aprovada, editada, revisada, etc e a torna paga ou não
    public void mudarSitucaoPub(String CNPJ, Publicacao pub, String situacao, int peso, boolean paga);
    
    //Método que adiciona uma publicação avaliada por um chefe informado ao seu array de publicações avaliadas
    public void avaliacaoChefe(String CNPJ, String CTPS, Publicacao pub);
    
    //Método para contabilizar os erros encontrados em publicações por um revisor
    public void contabilizarErros(String CNPJ, String CTPS, int qtErros) throws NumeroCTPSInvalido, NaoExiste;
    
    //Método para contabilizar as visualizações de uma publicação digital  
    public void contabilizarVisualizacoes(String CNPJ, PublicacaoDig pub);
    //Método para contalizar a visualização de um anúncio em uma pubicação
    public void contabilizarVisuAnuncio(String CNPJ, String idAnuncio, String idPub);
    
    //Método para desaprovar um comentário, no qual este é removido da publicação de origem, 
    //contabilizado nos comentários impróprios do clientes autor e no array de comentarios avaliados pelo mediador
    //caso o autor tenha feito três ou mais comentários irregulares, sua conta é bloqueada;
    public void desaprovarCmImproprio(String CNPJ,String CTPSMed, Comentario comentario);
    
    //Método para incluir um anúncio em uma publicação
    public void veicularAnuncioPub(String CNPJ, Anuncio an, Publicacao pub) throws anuncioDeOutroCarater, JaCadastrado;
    
    //Método que contabiliza um novo clique em anúncio
    public void novoCliqueAnuncio(String CNPJ, Publicacao p, String idAnuncio);
    
    public Publicacao retornarPubAnuncio(String CNPJ, Anuncio an);
}
