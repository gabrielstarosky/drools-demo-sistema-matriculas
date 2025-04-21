package org.example.util;

import org.kie.api.runtime.KieSession;

import org.example.model.Matricula;

public class DroolsUtil {
    public static void insertMatriculaAndDocuments(KieSession kSession, Matricula matricula) {
        if (matricula.getDocumentosApresentados() != null) {
            matricula.getDocumentosApresentados().forEach(kSession::insert);
        }
        kSession.insert(matricula);
    }
}