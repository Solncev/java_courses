package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import service.beans.CbcTripInfo;

@Service
public class RestTrip {

    public static final String API_URL = "http://localhost:8080/api/v1_0/trip/";
    public static final String GET_BY_ID = API_URL + "/{id}";
    public static final String GET_BY_AUTO = API_URL + "auto/{id}";
    @Autowired
    RestTemplate restTemplate;

    public CbcTripInfo getTripInfoById(long goodId) {
        try {
            ResponseEntity<CbcTripInfo> response = restTemplate.getForEntity(
                    GET_BY_ID, CbcTripInfo.class, goodId);
            return response.getBody();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public CbcTripInfo getTripInfoByAuto(long autoId) {
        try {
            ResponseEntity<CbcTripInfo> response = restTemplate.getForEntity(
                    GET_BY_AUTO, CbcTripInfo.class, autoId);
            return response.getBody();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
