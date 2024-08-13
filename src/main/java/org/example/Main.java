package org.example;

import de.adorsys.psd2.qwac.certificate.generator.lib.service.CertificateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(CertificateService.class);
    public static void main(String[] args) {
        final int ARGS_SIZE = 1;
        try {
            // Check if the required arguments are provided
            if (args.length < ARGS_SIZE) {
                logger.info(" java -cp target/Testin-jar-with-dependencies.jar org.example.Main /home/cypher/Desktop/Tpps.json");
                return;
            }

            String tppJsonFilePath = args[0];
            // Optional target folder argument
            String targetFolder = args.length > 1 && "--target_folder".equals(args[1]) ? args[2] : "certs";

            CertificateService certificateService = new CertificateService();

            certificateService.generatePemFilesCerts(tppJsonFilePath, targetFolder);
        } catch (IOException e) {
            logger.error("An error occurred: {}", e.getMessage(), e);
        }
    }
}