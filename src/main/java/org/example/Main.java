package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.example.util.DroolsUtil;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import org.example.model.Aluno;
import org.example.model.Documento;
import org.example.model.Matricula;
import org.example.model.Turma;
import org.example.model.enums.StatusMatricula;
import org.example.model.enums.TipoDocumento;
import org.example.util.DroolsUtil;


public class Main {
    public static void main(String[] args) {

        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("ksession-rules");
        KieServices.Factory.get().getLoggers().newFileLogger(kieSession, "debug");

        // Caso 1: Aluno com idade menor que a mínima
        Matricula matriculaIdadeInvalida = criarMatriculaIdadeInvalida();

        // Caso 2: Turma sem vagas
        Matricula matriculaSemVagas = criarMatriculaSemVagas();

        // Caso 3: Documentos faltantes
        Matricula matriculaSemDocumentos = criarMatriculaSemDocumentos();

        // Caso 4: Matrícula válida
        Matricula matriculaValida = criarMatriculaValida();

        DroolsUtil.insertMatriculaAndDocuments(kieSession, matriculaIdadeInvalida);
        DroolsUtil.insertMatriculaAndDocuments(kieSession, matriculaSemVagas);
        DroolsUtil.insertMatriculaAndDocuments(kieSession, matriculaSemDocumentos);
        DroolsUtil.insertMatriculaAndDocuments(kieSession, matriculaValida);

        kieSession.fireAllRules();

    }

    private static Matricula criarMatriculaIdadeInvalida() {
        Matricula matricula = new Matricula();

        Aluno aluno = new Aluno();
        aluno.setId(1L);
        aluno.setNome("João");
        aluno.setPossuiDeficiencia(true);
        aluno.setDataNascimento(LocalDate.now().minusYears(8));

        Turma turma = new Turma();
        turma.setId(1L);
        turma.setCodigo("F5");
        turma.setIdadeMinima(10);
        turma.setVagasDisponiveis(5);

        matricula.setAluno(aluno);
        matricula.setTurma(turma);
        matricula.setStatus(StatusMatricula.EM_ANALISE);
        matricula.setDocumentosApresentados(criarDocumentosValidos());


        return matricula;
    }

    private static Matricula criarMatriculaSemVagas() {
        Matricula matricula = new Matricula();

        Aluno aluno = new Aluno();
        aluno.setId(2L);
        aluno.setNome("Maria");
        aluno.setDataNascimento(LocalDate.now().minusYears(10));

        Turma turma = new Turma();
        turma.setId(1L);
        turma.setCodigo("F5");
        turma.setIdadeMinima(10);
        turma.setVagasDisponiveis(0);

        matricula.setAluno(aluno);
        matricula.setTurma(turma);
        matricula.setStatus(StatusMatricula.EM_ANALISE);
        matricula.setTransferido(true);
        matricula.setDocumentosApresentados(criarDocumentosValidos());

        return matricula;
    }

    private static Matricula criarMatriculaSemDocumentos() {
        Matricula matricula = new Matricula();

        Aluno aluno = new Aluno();
        aluno.setId(3L);
        aluno.setNome("Pedro");
        aluno.setDataNascimento(LocalDate.now().minusYears(10));

        Turma turma = new Turma();
        turma.setId(1L);
        turma.setCodigo("F5");
        turma.setIdadeMinima(10);
        turma.setVagasDisponiveis(5);

        matricula.setAluno(aluno);
        matricula.setTurma(turma);
        matricula.setStatus(StatusMatricula.EM_ANALISE);
        matricula.setDocumentosApresentados(new ArrayList<>());

        return matricula;
    }

    private static Matricula criarMatriculaValida() {
        Matricula matricula = new Matricula();

        Aluno aluno = new Aluno();
        aluno.setId(4L);
        aluno.setNome("Ana");
        aluno.setDataNascimento(LocalDate.now().minusYears(11));

        Turma turma = new Turma();
        turma.setId(1L);
        turma.setCodigo("F5");
        turma.setIdadeMinima(10);
        turma.setVagasDisponiveis(5);

        matricula.setAluno(aluno);
        matricula.setTurma(turma);
        matricula.setStatus(StatusMatricula.EM_ANALISE);
        matricula.setDocumentosApresentados(criarDocumentosValidos());

        return matricula;
    }

    private static List<Documento> criarDocumentosValidos() {
        List<Documento> documentos = new ArrayList<>();

        Documento rg = new Documento();
        rg.setTipo(TipoDocumento.RG);
        rg.setValidado(true);
        documentos.add(rg);

        Documento cpf = new Documento();
        cpf.setTipo(TipoDocumento.CPF);
        cpf.setValidado(true);
        documentos.add(cpf);

        Documento certidao = new Documento();
        certidao.setTipo(TipoDocumento.CERTIDAO_NASCIMENTO);
        certidao.setValidado(true);
        documentos.add(certidao);

        return documentos;
    }
}