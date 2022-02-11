import dao.AptJdbcRepository;
import dao.AptRepository;
import domain.Apt;
import java.util.List;
import java.util.stream.Collectors;
import util.file.FileDownloader;

public class Main {

    public static void main(String[] args) {
        AptRepository aptRepository = new AptJdbcRepository();

        // 파일 경로에 있는 데모인포리스트 전체 읽기
        List<String> aptInfo = getFileInfo(FileDownloader.DAEGU_APT_TEXT);

        // 아파트 데모인포리스트 받아와서 Apt 객체로 변환
        List<Apt> apts = aptInfo.stream()
            .map(Apt::infoToApt)
            .collect(Collectors.toList());

        // 받아온 아파트 리스트로 아파트 저장기능
        apts.forEach(aptRepository::save);
    }

    private static List<String> getFileInfo(String textPath) {
        return FileDownloader.getTextInfos(textPath);
    }
}
