import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Sistema Acadêmico: Início dos Testes ---");

        Matriculador sistema = new Matriculador();

        System.out.println("\n--- Cadastro de Disciplinas ---");
        // Capacidade 2 (Teste de lotação)
        Disciplina poo = new Disciplina("POO101", "Programação Orientada a Objetos", 2);
        Disciplina estrDados = new Disciplina("ED202", "Estrutura de Dados", 3);

        sistema.cadastrarDisciplina(poo);
        sistema.cadastrarDisciplina(estrDados);

        // Teste de código duplicado
        Disciplina pooDuplicada = new Disciplina("POO101", "POO Duplicada", 1);
        sistema.cadastrarDisciplina(pooDuplicada);

        System.out.println("\n--- Cadastro de Alunos ---");
        Aluno aluno1 = new Aluno("Alice Silva", "alice@email.com");
        Aluno aluno2 = new Aluno("Bruno Costa", "bruno@email.com");
        Aluno aluno3 = new Aluno("Carla Santos", "carla@email.com");
        Aluno aluno4 = new Aluno("David Almeida", "david@email.com");

        sistema.cadastrarAluno(aluno1);
        sistema.cadastrarAluno(aluno2);
        sistema.cadastrarAluno(aluno3);
        sistema.cadastrarAluno(aluno4);

        System.out.println("\n--- Teste de Matrículas ---");
        int matAlice = aluno1.getMatricula();
        int matBruno = aluno2.getMatricula();
        int matCarla = aluno3.getMatricula();
        int matDavid = aluno4.getMatricula();

        // Matrículas bem-sucedidas em POO101
        sistema.matricular(matAlice, "POO101"); // 1/2
        sistema.matricular(matBruno, "POO101"); // 2/2 -> POO101 lotada

        // Matrículas bem-sucedidas em ED202
        sistema.matricular(matCarla, "ED202"); // 1/3
        sistema.matricular(matDavid, "ED202"); // 2/3

        // Tenta matricular além da capacidade máxima (Teste de lotação)
        System.out.println("\n--- Teste de Lotação (POO101) ---");
        sistema.matricular(matCarla, "POO101"); // Falha: Disciplina lotada

        // Tenta matricular um aluno já inscrito (Teste de duplicidade)
        System.out.println("\n--- Teste de Duplicidade (ED202) ---");
        sistema.matricular(matDavid, "ED202"); // Falha: Aluno já inscrito

        System.out.println("\n--- Relatório de Inscritos ---");

        // Relatório POO101
        List<Aluno> inscritosPOO = sistema.listarInscritos("POO101");
        System.out.println("\nInscritos em " + poo.getTitulo() + " (" + poo.getCodigo() + "):");

        if (inscritosPOO.isEmpty()) {
            System.out.println("Nenhum aluno inscrito.");
        } else {
            for (Aluno a : inscritosPOO) {
                System.out.println(" > Nome: " + a.getNome() + " (Matrícula: " + a.getMatricula() + ")");
            }
        }

        // Relatório ED202
        List<Aluno> inscritosED = sistema.listarInscritos("ED202");
        System.out.println("\nInscritos em " + estrDados.getTitulo() + " (" + estrDados.getCodigo() + "):");

        if (inscritosED.isEmpty()) {
            System.out.println("Nenhum aluno inscrito.");
        } else {
            for (Aluno a : inscritosED) {
                System.out.println(" > Nome: " + a.getNome() + " (Matrícula: " + a.getMatricula() + ")");
            }
        }

        System.out.println("\n--- Testes Concluídos ---");
    }
}