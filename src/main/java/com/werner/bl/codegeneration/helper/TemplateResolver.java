package com.werner.bl.codegeneration.helper;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Component
public class TemplateResolver {

    public String resolveTemplate(TemplateName templateName) {
        String filepath = templateName.getFilepath();
        return readSampleFile(new File(filepath));
    }

    private String readSampleFile(File file) {
        try {
            String content = "";
            BufferedReader bufferedReader = null;
            bufferedReader = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                content += line + "\n";
            }
            return content;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
