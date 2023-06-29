package de.imunixx.backend.service;

import java.io.File;
import java.io.IOException;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
public class ResourcePathFinder {

    private final ResourceLoader resourceLoader;

    public ResourcePathFinder(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public String getResourcePath(String resource) throws IOException {
        Resource res = resourceLoader.getResource(resource);
        File file = res.getFile();
        return file.getAbsolutePath();
    }
}