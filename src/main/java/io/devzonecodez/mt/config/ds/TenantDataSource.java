package io.devzonecodez.mt.config.ds;

import io.devzonecodez.mt.config.web.TenantContextHolder;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;


public class TenantDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return TenantContextHolder.getTenantId();
    }
}