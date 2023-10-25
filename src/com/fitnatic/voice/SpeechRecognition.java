/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fitnatic.voice;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;

import java.io.IOException;

public class SpeechRecognition {
    private Configuration configuration;
    private LiveSpeechRecognizer recognizer;
    private boolean recognitionActive = false;

    public SpeechRecognition() {
        configuration = new Configuration();
        try {
            // Chargement de la configuration par défaut du modèle acoustique (en-US)
            configuration.setAcousticModelPath("C:\\Users\\Youssef\\Desktop\\Reclamation5\\resources\\acoustic\\sphinx4-5prealpha-src\\sphinx4-data\\src\\main\\resources\\edu\\cmu\\sphinx\\models\\en-us");
            configuration.setDictionaryPath("C:\\Users\\Youssef\\Desktop\\Reclamation5\\resources\\acoustic\\sphinx4-5prealpha-src\\sphinx4-core\\src\\test\\resources\\edu\\cmu\\sphinx\\linguist\\dictionary");
            configuration.setLanguageModelPath("C:\\Users\\Youssef\\Desktop\\Reclamation5\\resources\\acoustic\\sphinx4-5prealpha-src\\sphinx4-core\\src\\test\\resources\\edu\\cmu\\sphinx\\linguist\\language\\ngram\\trie");

            recognizer = new LiveSpeechRecognizer(configuration);
        } catch (IOException e) {
            // Gérez l'exception ici, soit en l'enregistrant ou en affichant un message d'erreur
            e.printStackTrace();
        }
    }

    public void startRecognition() {
        if (!recognitionActive) {
            recognizer.startRecognition(true);
            recognitionActive = true;
            System.out.println("Démarrage de la reconnaissance vocale...");
            while (recognitionActive) {
                SpeechResult result = recognizer.getResult();
                if (result != null) {
                    String recognizedSpeech = result.getHypothesis();
                    System.out.println("Texte reconnu : " + recognizedSpeech);
                    // Ajoutez ici le code pour traiter la parole reconnue (par exemple, appelez une méthode de gestion des réclamations).
                }
            }
        }
    }

    public void stopRecognition() {
        if (recognitionActive) {
            recognizer.stopRecognition();
            recognitionActive = false;
            System.out.println("Arrêt de la reconnaissance vocale.");
        }
    }

    public static void main(String[] args) {
        SpeechRecognition speechRecognition = new SpeechRecognition();
        speechRecognition.startRecognition(); // Démarre la reconnaissance
    }
}