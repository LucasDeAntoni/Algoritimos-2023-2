package MapaDispersao;

import java.time.LocalDate;

public class Aluno {
    
    private String nome;
    private int matricula;
    private LocalDate dataNascimento;
    
    public Aluno(String nome, int matricula, LocalDate dataNsascimento) {
        setNome(nome);
        setMatricula(matricula);
        setDataNascimento(dataNsascimento);
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getMatricula() {
        return matricula;
    }
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
    
}
