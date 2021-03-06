package com.cacuware.file.service;

import com.cacuware.file.api.dto.EmployeeDto;
import com.cacuware.file.api.dto.VacationDto;
import com.cacuware.file.model.File;
import com.cacuware.file.model.Type;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;

@Service
public class GenerateFileService {
    @Autowired
    private FileStorageService fileStorageService;

    public File createRequestHire() throws Exception {
        int number = fileStorageService.findCount(Type.REQUEST_HIRE);
        XWPFDocument document = getXwpfDocument();
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
        run1.setFontSize(36);
        run1.setText("МОЛБА");
        run1.addBreak();
        run1.setBold(false);
        run1.setFontSize(26);
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
        run2.setText("1. Копие от лична карта;");
        run2.addBreak();
        run2.setText("2. Диплома за завършено образование;");
        run2.addBreak();
        run2.setText("3. Медицинско свидетелство за работа;");
        run2.addBreak();
        run2.setText("4. Други - ..........................");


        setsmth(document, out);

        return fileStorageService.storeFile(new MockMultipartFile("Молба", "Молба-назначаване-№"+number+".docx",
                "application/vnd.openxmlformats-officedocument.wordprocessingml.document", out.toByteArray()), Type.REQUEST_HIRE.name());
    }

    public File createInstruction(EmployeeDto employeeDto) throws Exception {
        int number = fileStorageService.findCount(Type.INSTRUCTORS);

        XWPFDocument document = getXwpfDocument();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        XWPFParagraph request = document.createParagraph();
        request.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun run1 = request.createRun();
        run1.setBold(true);
        run1.setFontSize(36);
        run1.setText("Служебна бележка");
        run1.addBreak();
        String title = "№ " + number;
        run1.setText(title + "/" + LocalDate.now() + " год.");
        run1.addBreak();
        run1.setText("ЕГН .....................");

        XWPFParagraph toWhom = document.createParagraph();
        toWhom.setAlignment(ParagraphAlignment.RIGHT);
        XWPFRun run = toWhom.createRun();
        String line1 = "До Управителя";
        String line2 = "На „Заваръчно-монтажни услуги – ЗМУ“ ЕООД";
        String line3 = "гр. Плевен";
        run.setText(line1 + "\r\n" + line2 + "\r\n" + line3);

        XWPFParagraph layout = document.createParagraph();
        layout.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun run2 = layout.createRun();
        run2.setText("На г-н/ г-жа " + employeeDto.getPerson().getFirstName() + employeeDto.getPerson().getMiddleName() + employeeDto.getPerson().getLastName() + ". е проведен начален инструктаж по безопасност, хигиена на труда и противопожарна охрана на " + LocalDate.now() + " год.");

        XWPFParagraph ending = document.createParagraph();
        ending.setAlignment(ParagraphAlignment.RIGHT);
        XWPFRun run3 = ending.createRun();
        String line14 = "Провел началния инструктаж: ……………………";
        run3.setText(line14);
        document.write(out);
        out.close();

        return fileStorageService.storeFile(new MockMultipartFile("Молба", "Служебна-бележка-" + title + ".docx",
                "application/vnd.openxmlformats-officedocument.wordprocessingml.document", out.toByteArray()), Type.INSTRUCTORS.name());
    }

    public File createGDPR(EmployeeDto employeeDto) throws Exception {
        XWPFDocument document = getXwpfDocument();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        XWPFParagraph request = document.createParagraph();
        request.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun run1 = request.createRun();
        run1.setBold(true);
        run1.setFontSize(36);
        run1.setText("ДЕКЛАРАЦИЯ ЗА СЪГЛАСИЕ ЗА ОБРАБОТКА НА ЛИЧНИ ДАННИ");

        XWPFParagraph toWhom = document.createParagraph();
        toWhom.setAlignment(ParagraphAlignment.RIGHT);
        XWPFRun run = toWhom.createRun();
        String line1 = "Долуподписаният/ата" + employeeDto.getPerson().getFirstName() + employeeDto.getPerson().getMiddleName() + employeeDto.getPerson().getLastName() + ",  с ЕГН: "
                + employeeDto.getSecurityData().getEgn() + ", л.к. № " + employeeDto.getSecurityData().getIdNumber()
                + "., издадена от " + employeeDto.getSecurityData().getAuthority() +
                "., на " + employeeDto.getSecurityData().getIssuedDate() + ".  година.\n";
        run.setText(line1);

        XWPFParagraph heading = document.createParagraph();
        heading.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun run2 = heading.createRun();
        run2.setBold(true);
        run2.setFontSize(36);
        run2.setText("ДЕКЛАРИРАМ");

        XWPFParagraph layout = document.createParagraph();
        layout.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun run4 = layout.createRun();
        run4.setText("Съгласен/съгласна съм „Заваръчно-монтажни услуги – ЗМУ“ ЕООД да съхранява и обработва личните ми данни, съгласно изискванията на Закона за защите на личните данни, които предоставям във връзка с трудово-правните ми отношения  с фирмата.\n" +
                "Запознат/а съм с целта и средствата на обработка на личните ми данни, правото на достъп и коригиране на събраните данни. \n" +
                "Доброволно предоставям и давам своето съгласие „Заваръчно-монтажни услуги – ЗМУ“ ЕООД да обработват личните ми данни за служебно ползване.\n" +
                "Информиран/а съм и разбирам, че мога да оттегля съгласието си по всяко време като използвам образец „Декларация за оттегляне на съгласие“, който мога да  получа от офиса на фирмата. За оттегляне на съгласието ми трябва да предоставя  попълнен образеца в офиса на фирмата.\n");

        setEnding(document, "Дата:....................................");

        document.write(out);
        out.close();

        return fileStorageService.storeFile(new MockMultipartFile("Молба",
                "GDPR-" + employeeDto.getPerson().getFirstName() + employeeDto.getPerson().getLastName() + ".docx",
                "application/vnd.openxmlformats-officedocument.wordprocessingml.document", out.toByteArray()), Type.GDPR.name());
    }

    public File createContract(EmployeeDto employeeDto) throws Exception {
        int number = fileStorageService.findCount(Type.CONTRACT);

        XWPFDocument document = getXwpfDocument();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        XWPFParagraph request = document.createParagraph();
        request.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun run1 = request.createRun();
        run1.setBold(true);
        run1.setFontSize(36);
        run1.setText("TРУДОВ ДОГОВОР № " + number);

        XWPFParagraph layout = document.createParagraph();
        layout.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun run4 = layout.createRun();
        run4.setText("Днес " + LocalDate.now() + "г. в гр.  Плевен  ,    община Плевен, област Плевен\n" +
                "между: „Заваръчно-монтажни услуги” ЕООД\n" +
                "със седалище: гр.Плевен  , ул. „Г.М.Димитров”                                              № 92\n" +
                "адрес на управление: гр.Плевен   , ул. , ул. „Г.М.Димитров”                                № 92\n" +
                "Данъчен №   1153040180                                                       Булстат: 114616996\n" +
                "представлявано от : Свилен Венетков Крумов – Управител\n" +
                "ЕГН : 7306183962\n" +
                "от една страна , наричана за краткост по-долу РАБОТОДАТЕЛ и\n" +
                employeeDto.getPerson().getFirstName() + employeeDto.getPerson().getMiddleName() + employeeDto.getPerson().getLastName() +
                "с постоянен адрес : " + employeeDto.getPerson().getAddress() + "\n" +
                "притежаващ л.к.№ " + employeeDto.getSecurityData().getIdNumber() + " изд.на " + employeeDto.getSecurityData().getIssuedDate()
                + " , МВР: " + employeeDto.getSecurityData().getAuthority() + "    , ЕГН : " + employeeDto.getSecurityData().getEgn() + "\n" +
                "с образование : " + employeeDto.getEducation() + "                  със специалност : ......................\n" +
                "втора специалност :                              , научна степен:\n" +
                "с трудов стаж   " + employeeDto.getSecurityData().getYearsOfLabour() + " г.  " + employeeDto.getSecurityData().getMonthsOfLabour() + " м.   "
                + employeeDto.getSecurityData().getDaysOfLabour() + " дни , в т.ч.трудов стаж по специалността    " +
                employeeDto.getSecurityData().getProfessionalYearsOfLabour() + employeeDto.getSecurityData().getProfessionalMonthsOfLabour() + employeeDto.getSecurityData().getProfessionalDaysOfLabour()
                + " г.  м.  д.\n наричан за краткост по-долу РАБОТНИК (СЛУЖИТЕЛ), на основание чл.67 ал.1\n" +
                "от Кодекса на труда се сключи настоящия трудов договор :\n" +
                "1.Предприятието възлага , а работникът/служителят приема да изпълнява в :\n" +
                "  „ЗМУ” ЕООД                                  \n" +
                "Длъжността: " + employeeDto.getJobNumber() + "                           кв. Степен: \n" +
                "категория персонал: работник, с шифър по класификатора на длъжностите: " + employeeDto.getJobNumber() + "\n" +
                "2.С основно месечно (дневно , часово) възнаграждение   " + employeeDto.getSecurityData() + "   лв.\n" +
                "\n" +
                "3.Допълнително възнаграждение за продължителна работа , в размер на .........  %\n" +
                "4.\n" +
                "   /евентуално по-високи размери на доп. възнаграждение за работа при вредни усл. на труд/\n" +
                "5.Възнагражденията се изплащат : oт 25-то до 30-то число на месеца\n" +
                "6.На пълно работно време :            " + employeeDto.getWorkingHours() + "           часа\n" +
                "7. Трудовият договор се сключва за: неопределен срок \n" +
                "8.Със срок на предизвестие: \n" +
                "9.С основен платен годишен отпуск в размер на                       " + employeeDto.getVacationDays() + "                       дни\n" +
                "10.С допълнителен платен год. отпуск                       в размер на  ..........  дни\n" +
                "11.Други условия :\n" +
                "\n" +
                "12.РАБОТНИКЪТ (СЛУЖИТЕЛЯТ) ще постъпи на работа на  12.07.2006г. (или до\n" +
                "            или в седем дневен срок от представяне на екземпляр от скл. трудов договор и уведомлението до НАП по чл.62 ал.4 от КТ.)\n" +
                "  Настоящият договор се сключи в два еднообразни екземпляра , по един за всяка от страните.\n" +
                "РАБОТОДАТЕЛ:                                                 РАБОТНИК:\n" +
                "\n" +
                "Екземпляр от трудовия договор, заверено уведомление от ТП на НАП – гр. Плевен.\n" +
                "И длъжностна характеристика са  връчени на служителя на 17.09.2020 г.\n");

        setEnding(document, "РАБОТНИК:\n" +
                "\n" +
                "Отдел човешки ресурси:\n" +
                "\n" +
                "Работникът(служителят) постъпи на работа на .......... г. \n" +
                "РАБОТНИК:\n");

        document.write(out);
        out.close();

        return fileStorageService.storeFile(new MockMultipartFile("Молба", "Договор-№"+number+".docx",
                "application/vnd.openxmlformats-officedocument.wordprocessingml.document", out.toByteArray()), Type.CONTRACT.name());
    }

    public File createFireDocument(EmployeeDto employeeDto) throws Exception {
        int number = fileStorageService.findCount(Type.FIRE);
        final String[] name = new String[1];
        fileStorageService.getFiles(employeeDto.getFileIDs()).forEach(file -> {
            if(file.getFileBusinessType().equals(Type.CONTRACT)){
                name[0] = file.getCounter() + " / " + employeeDto.getStartDate();
            }
        });
        String contract = name[0];
        LocalDate end = (Objects.nonNull(employeeDto.getLeavingDate())) ? employeeDto.getLeavingDate() : LocalDate.now().plusMonths(1);

        XWPFDocument document = getXwpfDocument();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        XWPFParagraph request = document.createParagraph();
        request.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun run1 = request.createRun();
        run1.setBold(true);
        run1.setFontSize(36);
        run1.setText("ЗАПОВЕД\n № " + number + " / " + LocalDate.now());
        run1.addBreak();
        run1.addBreak();
        run1.setText("На основание чл. 325, ал.1, т. 1 от Кодекса на труда");
        run1.addBreak();
        run1.setText("ПРЕКРАТЯВАМ ТРУДОВОТО ПРАВООТНОШЕНИЕ");

        XWPFParagraph layout = document.createParagraph();
        layout.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun run4 = layout.createRun();
        run4.setText(employeeDto.getPerson().getFirstName() + employeeDto.getPerson().getMiddleName() + employeeDto.getPerson().getLastName() + ", ЕГН: " + employeeDto.getSecurityData().getEgn() + "\n" +
                "на длъжност: " + employeeDto.getJobNumber() + ",  код по НКПД: " + employeeDto.getJobNumber() + ", \n" +
                "Трудов Договор " + contract + "г., чл. 67, ал.1, т.1,\n" +
                " считано от " + end + " год.\n");

        XWPFParagraph ending = document.createParagraph();
        ending.setAlignment(ParagraphAlignment.RIGHT);
        XWPFRun run3 = ending.createRun();
        String line14 = "Причини за прекратяване на трудовия договор: \n" +
                " \n" +
                "ПО ВЗАИМНО СЪГЛАСИЕ\n" +
                "\n" +
                "На лицето да се изплатят следните обезщетения съгласно:\n" +
                "1. \n" +
                "2.\n" +
                "3.\n" +
                "\n" +
                "Други условия:\n" +
                "\n" +
                "УПРАВИТЕЛ: Свилен Венетков Крумов  ................................\n" +
                "\n" +
                "\n" +
                "Изготвил заповедта: И. Крумова   …………..……        \n" +
                "\n" +
                "\n" +
                "Дата на връчване на заповедта :............................ Подпис на лицето: ……….....................\n" +
                "\n" +
                "\n" +
                "Получил попълнена трудова книжка: …………………………………………….\n" +
                "\t\t\t\t\t\t            (дата и подпис)\n";
        run3.setText(line14);
        document.write(out);
        out.close();

        return fileStorageService.storeFile(new MockMultipartFile("Молба", "Заповед-уволнение-№"+number+".docx",
                "application/vnd.openxmlformats-officedocument.wordprocessingml.document", out.toByteArray()), Type.FIRE.name());
    }

    public File createVacationDocument(VacationDto vacationDto) throws Exception {
        int number = fileStorageService.findCount(Type.VACATION_APPROVAL);

        LocalDate toDate = vacationDto.getStartDate().plusDays(vacationDto.getVacationDays());
        XWPFDocument document = getXwpfDocument();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        XWPFParagraph request = document.createParagraph();
        request.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun run1 = request.createRun();
        run1.setBold(true);
        run1.setFontSize(36);
        String title = "ЗАПОВЕД № " + number + " / " + LocalDate.now();
        run1.setText(title);
        run1.addBreak();
        run1.addBreak();
        run1.setText("на основание чл. 173, ал. 1 КТ");
        run1.addBreak();
        run1.setText("НАРЕЖДАМ");

        XWPFParagraph layout = document.createParagraph();
        layout.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun run4 = layout.createRun();
        run4.setText("В периода от " + vacationDto.getStartDate() + "до " + toDate +
                " г. да ползва платен годишен отпуск за " + LocalDate.now().getYear() + "година,\n" +
                "в размер на " + vacationDto.getVacationDays() + ".работни дни \n "
                + vacationDto.getEmployee().getPerson().getFirstName() + vacationDto.getEmployee().getPerson().getMiddleName() + vacationDto.getEmployee().getPerson().getLastName() + vacationDto.getEmployee().getJobNumber() + "\n" +
                "                    (посочват се трите имена и длъжноста на работника или служителя)\n" +
                "\n" +
                "Препис от заповедта да се връчи на работника  или служителя  за сведение и изпълнение и да се приложи към личното му трудово досие, а също така и в отдел счетоводство.\n");

        XWPFParagraph ending = document.createParagraph();
        ending.setAlignment(ParagraphAlignment.RIGHT);
        XWPFRun run3 = ending.createRun();
        String line14 = "РАБОТОДАТЕЛ:.....................................\n" +
                "                                                                                  (подпис и печат)\n";
        run3.setText(line14);
        document.write(out);
        out.close();

        return fileStorageService.storeFile(new MockMultipartFile("Молба",
                title+".docx", "application/vnd.openxmlformats-officedocument.wordprocessingml.document",
                out.toByteArray()), Type.VACATION_APPROVAL.name());

    }

    public File createVacationRequest(VacationDto vacation) throws Exception {
        int number = fileStorageService.findCount(Type.VACATION_REQUEST);

        LocalDate toDate = vacation.getStartDate().plusDays(vacation.getVacationDays());
        XWPFDocument document = getXwpfDocument();
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
        run1.setFontSize(36);
        run1.setText("МОЛБА");
        run1.addBreak();
        run1.setBold(false);
        run1.setFontSize(26);
        run1.setText("ОТ" + vacation.getEmployee().getPerson().getFirstName() + vacation.getEmployee().getPerson().getMiddleName() + vacation.getEmployee().getPerson().getLastName());
        run1.addBreak();
        run1.setText("ЕГН " + vacation.getEmployee().getSecurityData().getEgn());
        run1.addBreak();
        run1.setText("на длъжност " + vacation.getEmployee().getJobNumber());


        XWPFParagraph layout = document.createParagraph();
        layout.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun run4 = layout.createRun();
        run4.setText("Уважаеми господин управител,\n" +
                "\n" +
                "\tМоля да ми разрешите ползването на " + vacation.getVacationDays() + "дни платен годишен отпуск, считано от " + vacation.getStartDate() + " до " + toDate + ".г. включително.\n" +
                "\n");

        setsmth(document, out);
        document.write(out);
        out.close();

        return fileStorageService.storeFile(new MockMultipartFile("Молба", "Молба-отпуска-№"+number+".docx",
                "application/vnd.openxmlformats-officedocument.wordprocessingml.document",
                out.toByteArray()), Type.VACATION_REQUEST.name());
    }

    private void setsmth(XWPFDocument document, ByteArrayOutputStream out) throws IOException {
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
    }

    private void setEnding(XWPFDocument document, String s) {
        XWPFParagraph ending = document.createParagraph();
        ending.setAlignment(ParagraphAlignment.RIGHT);
        XWPFRun run3 = ending.createRun();
        String line14 = "ДЕКЛАРАТОР:......................................................................\n" +
                "(име, презиме, фамилия)\n" +
                "\n" +
                "………………………………………\n" +
                "(подпис)\n" +
                "\n";
        run3.setText(line14);
        ending.setAlignment(ParagraphAlignment.RIGHT);
        run3.setText(s);
        run3.addBreak();
        run3.setText(" гр. …………………………..");
    }

    private XWPFDocument getXwpfDocument() {
        return new XWPFDocument();
    }
}

