package programmers.강시혁.dev_matching_상반기;

/**
 * Level3_MySQL
 * __헤비 유저가 소유한 장소__
 * 이 서비스에서는 공간을 둘 이상 등록한 사람을 "헤비 유저"라고 부릅니다.
 * 헤비 유저가 등록한 공간의 정보를 아이디 순으로 조회하는 SQL문을 작성해주세요.
 */
public class 헤비_유저가_소유한_장소 {
    /**
     * SELECT *
     * FROM PALCES
     * WHERE HOST_ID
     * IN (SELECT HOST_ID
     *     FROM PLACES
     *     GROUP BY HOST_ID
     *     HAVING COUNT(HOST_ID) >= 2
     *     )
 *     ORDER BY ID ASC
     */
}
