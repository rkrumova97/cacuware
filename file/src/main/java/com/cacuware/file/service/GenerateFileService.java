package com.cacuware.file.service;

import com.cacuware.file.model.Type;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.time.LocalDate;

@Service
public class GenerateFileService {
    @Autowired
    private FileStorageService fileStorageService;

    public void createWord() throws Exception {

        XWPFDocument document = new XWPFDocument();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        XWPFParagraph toWhom = document.createParagraph();
        toWhom.setAlignment(ParagraphAlignment.RIGHT);
        XWPFRun run = toWhom.createRun();
        String line1 = "До Управителя";
        String line2 = "на „ЗМУ” ЕООД";
        String line3 = "гр. Плевен";
        run.setText(line1 + "\r\n" + line2 + "\r\n" + line3);

        XWPFParagraph request = document.createParagraph();
        request.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun run1 = request.createRun();
        run1.setBold(true);
        run1.setText("МОЛБА");
        run1.addBreak();
        run1.setText("ОТ ......................");
        run1.addBreak();
        run1.setText("ЕГН .....................");

        XWPFParagraph layout = document.createParagraph();
        layout.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun run2 = layout.createRun();
        run2.setText("                  Г-н Управител,");
        run2.addBreak();
        run2.setText("Моля да бъда назначен/а на подходяща работа във Вашата фирма.");
        run2.addBreak();
        run2.setText("Прилагам следните документи:");
        run2.addBreak();
        run2.setText( "1. Копие от лична карта;");
        run2.addBreak();
        run2.setText( "2. Диплома за завършено образование;");
        run2.addBreak();
        run2.setText( "3. Медицинско свидетелство за работа;");
        run2.addBreak();
        run2.setText( "4. Други - ..........................");


        XWPFParagraph ending = document.createParagraph();
        ending.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun run3 = ending.createRun();
        String line14 = LocalDate.now() + "г.                              С уважение:....................";
        String line15 = "Гр. Плевен";
        run3.setText(line14);
        run3.addBreak();
        run3.setText(line15);
        document.write(out);
        out.close();

        fileStorageService.storeFile(new MockMultipartFile("Молба", "Молба-1.docx",
                "application/vnd.openxmlformats-officedocument.wordprocessingml.document", out.toByteArray()), Type.REQUEST_HIRE.name());
    }
}

