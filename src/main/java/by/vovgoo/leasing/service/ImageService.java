package by.vovgoo.leasing.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;

public interface ImageService {

    Resource getImage(String filename) throws MalformedURLException;

    String uploadFile(MultipartFile file) throws IOException;

}
