package lk.chathurabuddi.geolocationservice.controller;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CountryResponse;
import lk.chathurabuddi.geolocationservice.service.GeoLocationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.InetAddress;

@AllArgsConstructor
@RequestMapping("/location")
@RestController
@Slf4j
public class GeoLocationController {

    private final GeoLocationService locationService;

    @GetMapping("/country/{ip-address}")
    public String findCountryByIp(@PathVariable("ip-address") String ipAddress) throws IOException, GeoIp2Exception {
        CountryResponse countryResponse = locationService.countryByIp(InetAddress.getByName(ipAddress));
        log.info("country found [ ip:{} ] [ response:{} ]", ipAddress, countryResponse.toJson());
        return countryResponse.getCountry().getIsoCode();
    }
}
