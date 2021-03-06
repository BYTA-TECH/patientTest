package com.bytatech.patientservice.client.custom_dms_core.api;

import org.springframework.cloud.openfeign.FeignClient;
//import com.bytatech.patientservice.client.custom_dms_core.ClientConfiguration;

@FeignClient(name="${customDmsCore.name:customDmsCore}", url="${customDmsCore.url:http://localhost/alfresco/api/-default-/public/alfresco/versions/1}"/*, configuration = ClientConfiguration.class*/)
public interface QueriesApiClient extends QueriesApi {
}