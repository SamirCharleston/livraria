package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import model.Livro;

public class LivroView extends JFrame{
	private JTable tabela;
	private JScrollPane painel;
	private JPanel painelSalvar = new JPanel();
	private JPanel painelAlterarDeletar = new JPanel();
	//Elementos do painel de salvar
	private JLabel textoTitulo = new JLabel("Titulo:");
	private JTextField campoTitulo = new JTextField(15);
	private JLabel textoAutor = new JLabel("Autor: ");
	private JTextField campoAutor = new JTextField(15);
	private JLabel textoLocal = new JLabel("Local: ");
	private JTextField campoLocal = new JTextField(15);
	private JLabel textoEditora = new JLabel("Editora: ");
	private JTextField campoEditora = new JTextField(15);
	private JButton botaoSalvar = new JButton("Salvar");
	//Elementos do painel de alterar e deletar
	private JLabel textoIdAlterar = new JLabel("Id do BD:");
	private JTextField campoIdAlterar = new JTextField(15);
	private JLabel textoTituloAlterar = new JLabel("Titulo:");
	private JTextField campoTituloAlterar = new JTextField(15);
	private JLabel textoAutorAlterar = new JLabel("Autor: ");
	private JTextField campoAutorAlterar = new JTextField(15);
	private JLabel textoLocalAlterar = new JLabel("Local: ");
	private JTextField campoLocalAlterar = new JTextField(15);
	private JLabel textoEditoraAlterar = new JLabel("Editora: ");
	private JTextField campoEditoraAlterar = new JTextField(15);
	private JButton botaoAlterar = new JButton("Alterar");
	private JButton botaoDeletar = new JButton("Deletar");

	public LivroView() {
		this.setSize(540,300);
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void configurarComponentes(ActionListener ouvinte) {
		painelSalvar.add(textoTitulo);
		painelSalvar.add(campoTitulo);
		painelSalvar.add(textoAutor);
		painelSalvar.add(campoAutor);
		painelSalvar.add(textoLocal);
		painelSalvar.add(campoLocal);
		painelSalvar.add(textoEditora);
		painelSalvar.add(campoEditora);
		botaoSalvar.addActionListener(ouvinte);
		painelSalvar.add(botaoSalvar);
		painelSalvar.setPreferredSize(new Dimension(250, 135));
		this.add(painelSalvar);
		
		painelAlterarDeletar.add(textoIdAlterar);
		painelAlterarDeletar.add(campoIdAlterar);
		painelAlterarDeletar.add(textoTituloAlterar);
		painelAlterarDeletar.add(campoTituloAlterar);		
		painelAlterarDeletar.add(textoAutorAlterar);
		painelAlterarDeletar.add(campoAutorAlterar);
		painelAlterarDeletar.add(textoLocalAlterar);
		painelAlterarDeletar.add(campoLocalAlterar);
		painelAlterarDeletar.add(textoEditoraAlterar);
		painelAlterarDeletar.add(campoEditoraAlterar);
		botaoAlterar.addActionListener(ouvinte);
		botaoDeletar.addActionListener(ouvinte);
		painelAlterarDeletar.add(botaoAlterar);
		painelAlterarDeletar.add(botaoDeletar);
		painelAlterarDeletar.setPreferredSize(new Dimension(250, 200));
		this.add(painelAlterarDeletar);		
	
		this.limparCampos();
	}

	public void carregarTabela(List<Livro> listaLivros, MouseListener ouvinte2) {
		if(painel != null)
			this.remove(painel);
		String[] nomesColunas = new String[] {
				"Id","Titulo", "Autor", "Local", "Editora"
		};

		Object[][] dados = new Object[listaLivros.size()][5];	
		for(int i=0; i<listaLivros.size(); i++) {
			dados[i][0] = listaLivros.get(i).getId();
			dados[i][1] = listaLivros.get(i).getTitulo();
			dados[i][2] = listaLivros.get(i).getAutor();
			dados[i][3] = listaLivros.get(i).getLocal();
			dados[i][4] = listaLivros.get(i).getEditora();
		}
		tabela = new JTable(dados,nomesColunas);
		painel = new JScrollPane(tabela);
		painel.setPreferredSize(new Dimension(520, 115));
		this.tabela.addMouseListener(ouvinte2);
		this.add(painel);
		this.revalidate();
	}
	
	public void limparCampos() {
		this.campoIdAlterar.setText("");
		this.campoTituloAlterar.setText("");
		this.campoLocalAlterar.setText("");
		this.campoEditoraAlterar.setText("");
		this.campoAutorAlterar.setText("");
		this.campoTitulo.setText("");
		this.campoLocal.setText("");
		this.campoEditora.setText("");
		this.campoAutor.setText("");
		this.botaoAlterar.setEnabled(false);
		this.botaoDeletar.setEnabled(false);
	}

	
	
	public JTextField getCampoTitulo() {
		return campoTitulo;
	}

	public void setCampoTitulo(JTextField campoTitulo) {
		this.campoTitulo = campoTitulo;
	}

	public JTextField getCampoAutor() {
		return campoAutor;
	}

	public void setCampoAutor(JTextField campoAutor) {
		this.campoAutor = campoAutor;
	}

	public JTextField getCampoLocal() {
		return campoLocal;
	}

	public void setCampoLocal(JTextField campoLocal) {
		this.campoLocal = campoLocal;
	}
	public JTextField getCampoEditora() {
		return campoEditora;
	}

	public void setCampoEditora(JTextField campoEditora) {
		this.campoEditora = campoEditora;
	}

	public JButton getBotaoSalvar() {
		return botaoSalvar;
	}

	public void setBotaoSalvar(JButton botaoSalvar) {
		this.botaoSalvar = botaoSalvar;
	}

	public JButton getBotaoAlterar() {
		return botaoAlterar;
	}

	public void setBotaoAlterar(JButton botaoAlterar) {
		this.botaoAlterar = botaoAlterar;
	}

	public JButton getBotaoDeletar() {
		return botaoDeletar;
	}

	public void setBotaoDeletar(JButton botaoDeletar) {
		this.botaoDeletar = botaoDeletar;
	}

	public JTable getTabela() {
		return tabela;
	}

	public void setTabela(JTable tabela) {
		this.tabela = tabela;
	}

	public JTextField getCampoIdAlterar() {
		return campoIdAlterar;
	}

	public void setCampoIdAlterar(JTextField campoIdAlterar) {
		this.campoIdAlterar = campoIdAlterar;
	}

	public JTextField getCampoTituloAlterar() {
		return campoTituloAlterar;
	}

	public void setCampoTituloAlterar(JTextField campoTituloAlterar) {
		this.campoTituloAlterar = campoTituloAlterar;
	}

	public JTextField getCampoAutorAlterar() {
		return campoAutorAlterar;
	}

	public void setCampoAutorAlterar(JTextField campoAutorAlterar) {
		this.campoAutorAlterar = campoAutorAlterar;
	}

	public JTextField getCampoLocalAlterar() {
		return campoLocalAlterar;
	}

	public void setCampoLocalAlterar(JTextField campoLocalAlterar) {
		this.campoLocalAlterar = campoLocalAlterar;
	}
	
	public void setCampoEditoraAlterar(JTextField campoEditoraAlterar) {
		this.campoEditoraAlterar = campoEditoraAlterar;
	}
	public JTextField getCampoEditoraAlterar() {
		return campoEditoraAlterar;
	}
	
}
