package domain;

import java.util.Arrays;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Apt {

    public static final String INFO_REGEX = "\\|";
    public static final int INFO_DEFALT_SIZE = 29;

    // sido_name (2 시도명)
    private final String sidoName;

    // gungu_name (3 시군구명)
    private final String gunguName;

    // dong_name (4 법정읍면동명)
    private final String dongName;

    // road_name (10 도로명)
    private final String roadName;

    // road_apt_num (12 건물본번)
    private final String roadAptNum;

    // apt_number (16 건물관리번호)
    private final String aptNumber;

    // zip_code (20 우편번호)
    private final Integer zipCode;

    // apt_name (26 시군구용 건물명)
    private final String aptName;

    @Builder
    private Apt(String sidoName, String gunguName, String dongName, String roadName, String roadAptNum, String aptNumber,
        Integer zipCode, String aptName) {
        this.sidoName = sidoName;
        this.gunguName = gunguName;
        this.dongName = dongName;
        this.roadName = roadName;
        this.roadAptNum = roadAptNum;
        this.aptNumber = aptNumber;
        this.zipCode = zipCode;
        this.aptName = aptName;
    }

    public static Apt infoToApt(String aptInfo) {
        List<String> aptInfos = Arrays.asList(aptInfo.split(INFO_REGEX));
        if (aptInfos.size() != INFO_DEFALT_SIZE) {
            throw new IllegalArgumentException("아파트 정보 입력값 에러");
        }
        return Apt.builder()
            .sidoName(aptInfos.get(1))
            .gunguName(aptInfos.get(2))
            .dongName(aptInfos.get(3))
            .roadName(aptInfos.get(9))
            .roadAptNum(aptInfos.get(11))
            .aptNumber(aptInfos.get(15))
            .zipCode(Integer.parseInt(aptInfos.get(19)))
            .aptName(aptInfos.get(25))
            .build();
    }

}
