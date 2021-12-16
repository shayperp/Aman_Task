package com.example.demo.service.imp;

import com.example.demo.rest.service.FileService;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
@Service
public class FileServiceImpl implements FileService {
    @Override
    public void saveFile(String path, byte[] bytes) {
        BufferedImage image = null;
        try {
            image = ImageIO.read( new ByteArrayInputStream( bytes ) );
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ImageIO.write(image, "JPG", new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
