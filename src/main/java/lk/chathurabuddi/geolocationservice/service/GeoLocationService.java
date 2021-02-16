package lk.chathurabuddi.geolocationservice.service;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CountryResponse;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

@Service
public class GeoLocationService {

    private final String dbLocation = "/home/rmx-admin/IdeaProjects/geo-location-service/database/GeoLite2-Country.mmdb";

    public CountryResponse countryByIp(InetAddress ipAddress) throws IOException, GeoIp2Exception {
        File database = new File(dbLocation);
        DatabaseReader dbReader = new DatabaseReader.Builder(database).build();
        return dbReader.country(ipAddress);
    }
}
