package com.ajaycodes.soapws.endpoints;

import com.ajaycodes.soapws.repo.CountryRepository;
import jakarta.xml.bind.JAXBElement;
import org.example.countries.GetCountryRequest;
import org.example.countries.GetCountryResponse;
import org.example.countries.ObjectFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CountryEndpoint {

    private static final String NAMESPACE_URI = "http://www.example.org/countries";
    private final CountryRepository countryRepository;

    public CountryEndpoint(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
     public JAXBElement<GetCountryResponse> getCountry(@RequestPayload GetCountryRequest request) {
        GetCountryResponse response = new GetCountryResponse();
        response.setCountry(countryRepository.findCountry(request.getName()));

        return new ObjectFactory().createGetCountryResponse(response);
    }

}
